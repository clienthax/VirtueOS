package com.sean.game;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

import com.sean.game.network.game.listeners.*;
import com.sean.shared.network.game.event.impl.*;
import net.openrs.cache.Cache;
import com.sean.game.network.GameChannelHandler;
import com.sean.game.network.SessionEventContext;
import com.sean.game.network.login.LoginEventListener;
import com.sean.game.network.login.LoginResponseEventListener;
import com.sean.game.network.ondemand.DropConnectionEventListener;
import com.sean.game.network.ondemand.EncryptionMessageEventListener;
import com.sean.game.network.ondemand.FileRequestEventListener;
import com.sean.game.network.ondemand.InitConnectionEventListener;
import com.sean.game.network.ondemand.LoginStateEventListener;
import com.sean.game.network.ondemand.ValidationEventListener;
import com.sean.game.services.GameScheduleService;
import com.sean.game.services.OnDemandService;
import com.sean.game.services.PlayerLoadService;
import com.sean.game.services.PlayerSaveService;
import com.sean.shared.event.EventHub;
import com.sean.shared.event.hubs.DefaultEventHub;
import com.sean.shared.model.region.RegionManager;
import com.sean.shared.network.game.event.GameEventRepository;
import com.sean.shared.network.handshake.HandshakeDecoder;
import com.sean.shared.network.login.LoginEvent;
import com.sean.shared.network.login.LoginResponseEvent;
import com.sean.shared.network.ondemand.DropConnectionEvent;
import com.sean.shared.network.ondemand.FileRequestEvent;
import com.sean.shared.network.ondemand.InitConnectionEvent;
import com.sean.shared.network.ondemand.LoginStateEvent;
import com.sean.shared.network.ondemand.UpdateEncryptionMessageEvent;
import com.sean.shared.network.ondemand.ValidationMessageEvent;
import com.sean.shared.script.ScriptManager;
import com.sean.shared.utility.Huffman;

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
import net.openrs.cache.ChecksumTable;
import net.openrs.cache.Container;
import net.openrs.cache.FileStore;
import net.openrs.cache.type.TypeListManager;

/**
 * Created by sean on 16/07/14.
 */
public final class Server {

	/**
	 * The dedicated logger for the {@link com.sean.game.Server} class.
	 */
	private static final Logger logger = Logger.getLogger(Server.class.getName());

	/**
	 * The {@link java.io.File} for the
	 */
	private static final File CACHE_LOCATION = new File("./repository/cache/");

	/**
	 * The {@link com.sean.game.ServerContext} containing the various data of
	 * the server.
	 */
	private final ServerContext context;

	/**
	 * The {@link com.sean.shared.network.game.event.GameEventRepository}.
	 */
	private final GameEventRepository eventRepository = new GameEventRepository(this);

	/**
	 * Creates a new {@link io.netty.channel.nio.NioEventLoopGroup} with a
	 * number of threads based on the available processors the server is running
	 * on.
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
	 * The {@link com.sean.game.GameWorld}.
	 */
	private final GameWorld gameWorld = new GameWorld();

	/**
	 * The {@link com.sean.game.services.OnDemandService}.
	 */
	private final OnDemandService onDemandService = new OnDemandService();

	/**
	 * The {@link com.sean.game.services.GameScheduleService}.
	 */
	private final GameScheduleService gameScheduleService = new GameScheduleService(this);

	/**
	 * The game {@link Cache}.
	 */
	private final Cache cache;

	/**
	 * The {@link com.sean.shared.event.EventHub} containing all the
	 * {@link com.sean.shared.event.Event}s and its corresponding
	 * {@link com.sean.shared.event.EventListener}s.
	 */
	private final EventHub<SessionEventContext> gameEventHub = new DefaultEventHub<>();

	/**
	 * The {@link io.netty.util.AttributeKey} for the game server.
	 */
	private final AttributeKey<SessionEventContext> gameAttributeKey = AttributeKey.valueOf("game-attribute-key");

	/**
	 * The {@link com.sean.rs3.shared.db.DatabaseService}.
	 */
	// private DatabaseService databaseService;

	/**
	 * The {@link com.sean.game.services.PlayerLoadService}.
	 */
	private PlayerLoadService loadService = new PlayerLoadService();

	/**
	 * The {@link com.sean.game.services.PlayerLoadService}.
	 */
	private PlayerSaveService saveService = new PlayerSaveService();

	/**
	 * The {@link com.sean.shared.scripts.ScriptManager}.
	 */
	private ScriptManager scriptManager = new ScriptManager();

	/**
	 * The {@link com.sean.shared.model.region.RegionManager}.
	 */
	private RegionManager regionManager = new RegionManager(this);

	/**
	 * The {@link com.sean.openrs.ChecksumTable}.
	 */
	private final ChecksumTable checksumTable;

	/**
	 * The {@link com.sean.openrs.ChecksumTable}.
	 */
	private final ByteBuffer checksumBuffer;

	/**
	 * The {@link com.sean.utility.Huffman}.
	 */
	private final Huffman huffman;

	private static Server server;

	/**
	 * Creates a new {@link com.sean.game.Server}
	 * 
	 * @param context
	 *            The {@link com.sean.game.ServerContext}
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
	 * @return The {@link com.sean.game.Server} for chaining.
	 */
	public Server initialize() throws IOException {

		logger.info("Initializing Game Channel.");

		server = this;

		TypeListManager.initialize(cache);

		scriptManager.initialize();

		regionManager.initialize();

		bootstrap.group(group).channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ChannelInitializer<NioSocketChannel>() {

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

		//TODO update when game updates
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
	 * @return The {@link com.sean.game.Server} for chaining.
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
	 * Gets the {@link com.sean.game.ServerContext}.
	 * 
	 * @return The {@code context}
	 */
	public ServerContext getContext() {
		return context;
	}

	/**
	 * Gets the {@link com.sean.game.GameWorld}.
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
	 * Gets the {@link com.sean.shared.event.EventHub}.
	 * 
	 * @return The {@code gameEventHub}.
	 */
	public EventHub<SessionEventContext> getGameEventHub() {
		return gameEventHub;
	}

	/**
	 * Gets the {@link com.sean.openrs.Cache}.
	 * 
	 * @return The {@code cache}.
	 */
	public Cache getCache() {
		return cache;
	}

	/**
	 * Gets the {@link com.sean.utility.Huffman}.
	 * 
	 * @return The {@code huffman}.
	 */
	public Huffman getHuffman() {
		return huffman;
	}

	/**
	 * Gets the {@link com.sean.game.services.OnDemandService}.
	 * 
	 * @return The {@code onDemandService}.
	 */
	public OnDemandService getOnDemandService() {
		return onDemandService;
	}

	/**
	 * Gets the {@link com.sean.openrs.ChecksumTable}.
	 * 
	 * @return The {@code checksumTable}.
	 */
	public ChecksumTable getChecksumTable() {
		return checksumTable;
	}

	/**
	 * Gets the {@link com.sean.openrs.ChecksumTable}.
	 * 
	 * @return The {@code checksumTable}.
	 */
	public ByteBuffer getChecksumBuffer() {
		return checksumBuffer;
	}

	/**
	 * Gets the {@link com.sean.shared.network.game.event.GameEventRepository} .
	 * 
	 * @return The {@code eventRepository}.
	 */
	public GameEventRepository getEventRepository() {
		return eventRepository;
	}

	/**
	 * Gets the {@link com.sean.game.services.PlayerLoadService}.
	 * 
	 * @return The {@code loginService}.
	 */
	public PlayerLoadService getLoadService() {
		return loadService;
	}

	/**
	 * Gets the {@link com.sean.game.services.PlayerLoadService}.
	 * 
	 * @return The {@code loginService}.
	 */
	public PlayerSaveService getSaveService() {
		return saveService;
	}

	/**
	 * Gets the {@link com.sean.shared.scripts.ScriptManager}.
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
	 * Gets the {@link com.sean.rs3.shared.db.DatabaseService}.
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
