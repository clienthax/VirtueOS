package com.oldscape.server.game;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

import com.oldscape.cache.Cache;
import com.oldscape.cache.ChecksumTable;
import com.oldscape.cache.Container;
import com.oldscape.cache.FileStore;
import com.oldscape.cache.type.TypeListManager;
import com.oldscape.server.game.network.GameChannelHandler;
import com.oldscape.server.game.network.SessionEventContext;
import com.oldscape.server.game.network.game.listeners.AttackNpcEventListener;
import com.oldscape.server.game.network.game.listeners.ButtonClickEventListener;
import com.oldscape.server.game.network.game.listeners.ClientDimensionsEventListener;
import com.oldscape.server.game.network.game.listeners.CommandEventListener;
import com.oldscape.server.game.network.game.listeners.InterfaceClickEventListener;
import com.oldscape.server.game.network.game.listeners.ItemOptionEventListener;
import com.oldscape.server.game.network.game.listeners.NpcClickListener;
import com.oldscape.server.game.network.game.listeners.ObjectClickListener;
import com.oldscape.server.game.network.game.listeners.PublicChatEventListener;
import com.oldscape.server.game.network.game.listeners.WalkEventListener;
import com.oldscape.server.game.network.login.LoginEventListener;
import com.oldscape.server.game.network.login.LoginResponseEventListener;
import com.oldscape.server.game.network.ondemand.DropConnectionEventListener;
import com.oldscape.server.game.network.ondemand.EncryptionMessageEventListener;
import com.oldscape.server.game.network.ondemand.FileRequestEventListener;
import com.oldscape.server.game.network.ondemand.InitConnectionEventListener;
import com.oldscape.server.game.network.ondemand.LoginStateEventListener;
import com.oldscape.server.game.network.ondemand.ValidationEventListener;
import com.oldscape.server.game.services.GameScheduleService;
import com.oldscape.server.game.services.OnDemandService;
import com.oldscape.server.game.services.PlayerLoadService;
import com.oldscape.server.game.services.PlayerSaveService;
import com.oldscape.shared.event.EventHub;
import com.oldscape.shared.event.hubs.DefaultEventHub;
import com.oldscape.shared.model.region.RegionManager;
import com.oldscape.shared.network.game.event.GameEventRepository;
import com.oldscape.shared.network.game.event.impl.AttackNpcEvent;
import com.oldscape.shared.network.game.event.impl.ButtonClickEvent;
import com.oldscape.shared.network.game.event.impl.ClientDimensionsEvent;
import com.oldscape.shared.network.game.event.impl.CommandEvent;
import com.oldscape.shared.network.game.event.impl.InterfaceClickEvent;
import com.oldscape.shared.network.game.event.impl.ItemOptionEvent;
import com.oldscape.shared.network.game.event.impl.NpcActionEvent;
import com.oldscape.shared.network.game.event.impl.ObjectClickEvent;
import com.oldscape.shared.network.game.event.impl.PublicChatMessage;
import com.oldscape.shared.network.game.event.impl.WalkEvent;
import com.oldscape.shared.network.handshake.HandshakeDecoder;
import com.oldscape.shared.network.login.LoginEvent;
import com.oldscape.shared.network.login.LoginResponseEvent;
import com.oldscape.shared.network.ondemand.DropConnectionEvent;
import com.oldscape.shared.network.ondemand.FileRequestEvent;
import com.oldscape.shared.network.ondemand.InitConnectionEvent;
import com.oldscape.shared.network.ondemand.LoginStateEvent;
import com.oldscape.shared.network.ondemand.UpdateEncryptionMessageEvent;
import com.oldscape.shared.network.ondemand.ValidationMessageEvent;
import com.oldscape.shared.script.ScriptManager;
import com.oldscape.shared.utility.Huffman;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.AttributeKey;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetector.Level;

/**
 * Created by sean on 16/07/14.
 */
@SuppressWarnings("deprecation")
public final class Server {

	/**
	 * The dedicated logger for the {@link com.oldscape.server.game.Server} class.
	 */
	private static final Logger logger = Logger.getLogger(Server.class.getName());

	/**
	 * The {@link java.io.File} for the
	 */
	private static final File CACHE_LOCATION = new File("./repository/cache/");

	/**
	 * The {@link com.oldscape.server.game.ServerContext} containing the various
	 * data of the server.
	 */
	private final ServerContext context;

	/**
	 * The {@link com.oldscape.shared.network.game.event.GameEventRepository}.
	 */
	private final GameEventRepository eventRepository = new GameEventRepository(this);

	/**
	 * Creates a new {@link io.netty.channel.nio.NioEventLoopGroup} with a number of
	 * threads based on the available processors the server is running on.
	 */
	private final EventLoopGroup group = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors());

	/**
	 * The {@link io.netty.bootstrap.ServerBootstrap}.
	 */
	private final ServerBootstrap bootstrap = new ServerBootstrap();

	/**
	 * The {@link io.netty.channel.ChannelFuture}.
	 */
	private ChannelFuture future;

	/**
	 * The {@link com.oldscape.server.game.GameWorld}.
	 */
	private final GameWorld gameWorld = new GameWorld();

	/**
	 * The {@link com.oldscape.server.game.services.OnDemandService}.
	 */
	private final OnDemandService onDemandService = new OnDemandService();

	/**
	 * The {@link com.oldscape.server.game.services.GameScheduleService}.
	 */
	private final GameScheduleService gameScheduleService = new GameScheduleService(this);

	/**
	 * The game {@link Cache}.
	 */
	private final Cache cache;

	/**
	 * The {@link com.oldscape.shared.event.EventHub} containing all the
	 * {@link com.oldscape.shared.event.Event}s and its corresponding
	 * {@link com.oldscape.shared.event.EventListener}s.
	 */
	private final EventHub<SessionEventContext> gameEventHub = new DefaultEventHub<>();

	/**
	 * The {@link io.netty.util.AttributeKey} for the game server.
	 */
	private final AttributeKey<SessionEventContext> gameAttributeKey = AttributeKey.valueOf("game-attribute-key");

	/**
	 * The {@link com.oldscape.server.rs3.shared.db.DatabaseService}.
	 */
	// private DatabaseService databaseService;

	/**
	 * The {@link com.oldscape.server.game.services.PlayerLoadService}.
	 */
	private PlayerLoadService loadService = new PlayerLoadService();

	/**
	 * The {@link com.oldscape.server.game.services.PlayerLoadService}.
	 */
	private PlayerSaveService saveService = new PlayerSaveService();

	/**
	 * The {@link com.oldscape.shared.scripts.ScriptManager}.
	 */
	private ScriptManager scriptManager = new ScriptManager();

	/**
	 * The {@link com.oldscape.shared.model.region.RegionManager}.
	 */
	private RegionManager regionManager = new RegionManager(this);

	/**
	 * The {@link com.oldscape.server.openrs.ChecksumTable}.
	 */
	private final ChecksumTable checksumTable;

	/**
	 * The {@link com.oldscape.server.openrs.ChecksumTable}.
	 */
	private final ByteBuffer checksumBuffer;

	/**
	 * The {@link com.oldscape.server.utility.Huffman}.
	 */
	private final Huffman huffman;

	private static Server server;

	/**
	 * Creates a new {@link com.oldscape.server.game.Server}
	 * 
	 * @param context
	 *            The {@link com.oldscape.server.game.ServerContext}
	 */
	public Server(ServerContext context) throws IOException {
		this.context = context;
		this.cache = new Cache(FileStore.open(CACHE_LOCATION));
		this.checksumTable = cache.createChecksumTable();
		this.checksumBuffer = new Container(Container.COMPRESSION_NONE, checksumTable.encode()).encode();
		this.huffman = new Huffman(cache.read(10, cache.getFileId(10, "huffman")).getData());
	}

	/**
	 * Initializes the server.
	 * 
	 * @return The {@link com.oldscape.server.game.Server} for chaining.
	 */
	public Server initialize() throws IOException {

		logger.info("Initializing Game Channel.");

		server = this;

		TypeListManager.initialize(cache);

		scriptManager.initialize();

		regionManager.initialize();

		bootstrap.group(group).channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO))
				.childHandler(new ChannelInitializer<NioSocketChannel>() {

					@Override
					protected void initChannel(NioSocketChannel ch) throws Exception {
						ChannelPipeline pipeline = ch.pipeline();

						pipeline.addLast(HandshakeDecoder.class.getName(), new HandshakeDecoder());
						pipeline.addLast(IdleStateHandler.class.getName(), new IdleStateHandler(15, 0, 0));
						pipeline.addLast("handler", new GameChannelHandler(server));
					}

				}).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.TCP_NODELAY, true);

		ResourceLeakDetector.setLevel(Level.ADVANCED);

		gameEventHub.subscribe(LoginEvent.class, new LoginEventListener());
		gameEventHub.subscribe(LoginResponseEvent.class, new LoginResponseEventListener());
		gameEventHub.subscribe(ValidationMessageEvent.class, new ValidationEventListener());
		gameEventHub.subscribe(UpdateEncryptionMessageEvent.class, new EncryptionMessageEventListener());
		gameEventHub.subscribe(FileRequestEvent.class, new FileRequestEventListener());
		gameEventHub.subscribe(InitConnectionEvent.class, new InitConnectionEventListener());
		gameEventHub.subscribe(DropConnectionEvent.class, new DropConnectionEventListener());
		gameEventHub.subscribe(LoginStateEvent.class, new LoginStateEventListener());

		// TODO update when game updates
		gameEventHub.subscribe(InterfaceClickEvent.class, new InterfaceClickEventListener());
		gameEventHub.subscribe(ButtonClickEvent.class, new ButtonClickEventListener());
		gameEventHub.subscribe(CommandEvent.class, new CommandEventListener());
		gameEventHub.subscribe(WalkEvent.class, new WalkEventListener());
		gameEventHub.subscribe(AttackNpcEvent.class, new AttackNpcEventListener());
		gameEventHub.subscribe(ObjectClickEvent.class, new ObjectClickListener());
		gameEventHub.subscribe(NpcActionEvent.class, new NpcClickListener());
		gameEventHub.subscribe(ItemOptionEvent.class, new ItemOptionEventListener());

		gameEventHub.subscribe(PublicChatMessage.class, new PublicChatEventListener());

		gameEventHub.subscribe(ClientDimensionsEvent.class, new ClientDimensionsEventListener());

		onDemandService.startAsync();
		loadService.startAsync();
		saveService.startAsync();
		gameScheduleService.startAsync();
		// databaseService.startAsync();

		return server;
	}

	/**
	 * Starts the server.
	 * 
	 * @return The {@link com.oldscape.server.game.Server} for chaining.
	 */
	public Server bind() {
		try {
			future = bootstrap.bind(context.getAddress()).sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	/**
	 * Stops the server.
	 */
	public void stop() {
		try {
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
			gameScheduleService.stopAsync();
			onDemandService.stopAsync();
			loadService.stopAsync();
			saveService.stopAsync();
			// databaseService.stopAsync();
			System.exit(1);
		}
	}

	/**
	 * Gets the {@link com.oldscape.server.game.ServerContext}.
	 * 
	 * @return The {@code context}
	 */
	public ServerContext getContext() {
		return context;
	}

	/**
	 * Gets the {@link com.oldscape.server.game.GameWorld}.
	 * 
	 * @return The {@code gameWorld}.
	 */
	public GameWorld getGameWorld() {
		return gameWorld;
	}

	/**
	 * Gets the {@link io.netty.util.AttributeKey}.
	 * 
	 * @return The {@code gameAttributeKey}.
	 */
	public AttributeKey<SessionEventContext> getGameAttributeKey() {
		return gameAttributeKey;
	}

	/**
	 * Gets the {@link com.oldscape.shared.event.EventHub}.
	 * 
	 * @return The {@code gameEventHub}.
	 */
	public EventHub<SessionEventContext> getGameEventHub() {
		return gameEventHub;
	}

	/**
	 * Gets the {@link com.oldscape.server.openrs.Cache}.
	 * 
	 * @return The {@code cache}.
	 */
	public Cache getCache() {
		return cache;
	}

	/**
	 * Gets the {@link com.oldscape.server.utility.Huffman}.
	 * 
	 * @return The {@code huffman}.
	 */
	public Huffman getHuffman() {
		return huffman;
	}

	/**
	 * Gets the {@link com.oldscape.server.game.services.OnDemandService}.
	 * 
	 * @return The {@code onDemandService}.
	 */
	public OnDemandService getOnDemandService() {
		return onDemandService;
	}

	/**
	 * Gets the {@link com.oldscape.server.openrs.ChecksumTable}.
	 * 
	 * @return The {@code checksumTable}.
	 */
	public ChecksumTable getChecksumTable() {
		return checksumTable;
	}

	/**
	 * Gets the {@link com.oldscape.server.openrs.ChecksumTable}.
	 * 
	 * @return The {@code checksumTable}.
	 */
	public ByteBuffer getChecksumBuffer() {
		return checksumBuffer;
	}

	/**
	 * Gets the {@link com.oldscape.shared.network.game.event.GameEventRepository} .
	 * 
	 * @return The {@code eventRepository}.
	 */
	public GameEventRepository getEventRepository() {
		return eventRepository;
	}

	/**
	 * Gets the {@link com.oldscape.server.game.services.PlayerLoadService}.
	 * 
	 * @return The {@code loginService}.
	 */
	public PlayerLoadService getLoadService() {
		return loadService;
	}

	/**
	 * Gets the {@link com.oldscape.server.game.services.PlayerLoadService}.
	 * 
	 * @return The {@code loginService}.
	 */
	public PlayerSaveService getSaveService() {
		return saveService;
	}

	/**
	 * Gets the {@link com.oldscape.shared.scripts.ScriptManager}.
	 * 
	 * @return The {@code scriptManager}.
	 */
	public ScriptManager getScriptManager() {
		return scriptManager;
	}

	/**
	 * @return the regionManager
	 */
	public final RegionManager getRegionManager() {
		return regionManager;
	}

	/**
	 * Gets the {@link com.oldscape.server.rs3.shared.db.DatabaseService}.
	 * 
	 * @return The {@code databaseService}.
	 */
	// public DatabaseService getDatabaseService() {
	// return databaseService;
	// }

	public static Server getServer() {
		return server;
	}
}
