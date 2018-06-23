package com.oldscape.server.game.model.entity.player;

import com.google.common.collect.Lists;
import com.oldscape.server.game.Server;
import com.oldscape.server.game.model.MobileEntity;
import com.oldscape.server.game.model.Node;
import com.oldscape.server.game.model.entity.item.Item;
import com.oldscape.server.game.model.entity.player.inv.*;
import com.oldscape.server.game.model.entity.player.inv.ItemContainer.StackMode;
import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.server.game.model.sync.reference.Appearance;
import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.server.game.model.entity.player.var.Varbit;
import com.oldscape.server.game.model.widget.WidgetId;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.Event;
import com.oldscape.server.game.model.MessageType;
import com.oldscape.server.game.model.map.Position;
import com.oldscape.server.game.model.entity.player.account.Credentials;
import com.oldscape.server.game.model.entity.player.account.DisplayMode;
import com.oldscape.server.game.model.entity.player.account.Permission;
import com.oldscape.shared.network.game.GameFrameBuilder;
import com.oldscape.shared.network.game.GameFrameDecoder;
import com.oldscape.shared.network.game.GameFrameEncoder;
import com.oldscape.shared.network.game.event.GameEventDecoder;
import com.oldscape.shared.network.game.event.GameEventEncoder;
import com.oldscape.shared.network.game.event.impl.*;
import com.oldscape.shared.utility.IsaacRandom;
import io.netty.channel.ChannelPipeline;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sean on 19/12/2014.
 */
public class Player extends MobileEntity {

    /**
     * The id the {@link Player} is in the database.
     */
    protected final int id;
    /**
     * The {@link Credentials}.
     */
    protected final Credentials credentials;
    /**
     * This mob's equipment.
     */
    protected final ItemContainer equipment = new ItemContainer(ContainerConstants.EQUIPMENT_CAPACITY, StackMode.STACK_ALWAYS);
    /**
     * This mob's bank.
     */
    protected final ItemContainer bank = new ItemContainer(ContainerConstants.BANK_CAPACITY, StackMode.STACK_ALWAYS);
    /**
     * This mob's inventory.
     */
    protected final ItemContainer inventory = new ItemContainer(ContainerConstants.INVENTORY_CAPACITY, StackMode.STACK_ALWAYS);
    /**
     * The viewport for this account
     */
    private final Viewport viewport = new Viewport(this);
    /**
     * Amount of items in each bank tab
     */
    protected int[] bankTabItems = new int[10];
    /**
     * Gets the {@link com.oldscape.server.game.network.game.GameSessionContext}.
     */
    protected GameSessionContext sessionContext;
    /**
     * The {@link com.oldscape.server.game.model.entity.player.account.DisplayMode}.
     */
    protected DisplayMode display;
    /**
     * The {@link com.oldscape.shared.utility.IsaacRandom} for the server and
     * client.
     */
    private IsaacRandom encodingRandom, decodingRandom;
    /**
     * The account's appearance.
     */
    private Appearance appearance = Appearance.DEFAULT_APPEARANCE;

    private Varbit varbits = new Varbit(this);
    /**
     * This account's prayer icon.
     */
    private int prayerIcon = -1;
    /**
     * Whether or not the account is skulled.
     */
    private boolean skulled = false;
    /**
     * Whether or not the account is hidden.
     */
    private boolean hidden = false;
    /**
     * If account is using side panels.
     */
    private boolean sidePanels = false;
    /**
     * If the account is past the welcome screen.
     */
    private boolean inGame = false;

    /**
     * Creates a new {@link com.oldscape.server.game.model.entity.player.Player}.
     *
     * @param id          The slot the account is in the database.
     * @param credentials The {@link Credentials}.
     * @param display     The {@link com.oldscape.server.game.model.entity.player.account.DisplayMode}.
     */
    public Player(int id, Credentials credentials, DisplayMode display) {
        this.id = id;
        this.credentials = credentials;
        this.display = display;
    }

    public int[] getBankTabItems() {
        return bankTabItems;
    }

    public void setBankTabItems(int[] bankTabItems) {
        this.bankTabItems = bankTabItems;
    }

    /**
     * Initializes the {@link Node}.
     */
    @Override
    public void initialize() {
        setRegion(sessionContext.getServer().getRegionManager().lookup(position.getRegionID()));

        equipment.addListener(new SynchronizationContainerListener(this, ContainerConstants.EQUIPMENT_ID, ContainerConstants.EQUIPMENT_CHANNEL));
        equipment.addListener(new AppearanceContainerListener(this));

        inventory.addListener(new SynchronizationContainerListener(this, ContainerConstants.INVENTORY_ID, ContainerConstants.INVENTORY_CHANNEL));
        inventory.addListener(new FullContainerListener(this, ContainerConstants.FULL_INVENTORY_MESSAGE));

        bank.addListener(new SynchronizationContainerListener(this, ContainerConstants.BANK_ID, ContainerConstants.BANK_CHANNEL));// TODO
        bank.addListener(new FullContainerListener(this, ContainerConstants.FULL_BANK_MESSAGE));
    }

    /**
     * Handles the login of a {@link com.oldscape.server.game.model.entity.player.Player}
     */
    public void onLogin() {

        GameFrameBuilder builder = new GameFrameBuilder(sessionContext.getChannel().alloc());

        viewport.initialize(builder, sessionContext.getWorld());

        sendRegionUpdate(position, builder);

        sendExternalIP(credentials.getLastKnownIpAddress());

        sendVarpReset();

        sendCameraReset();

        // Login Screen.
        sendWidgetText(WidgetId.LOGIN_CLICK_TO_PLAY_GROUP_ID, 56, "Welcome to Virtue");
        sendWidgetText(WidgetId.LOGIN_CLICK_TO_PLAY_GROUP_ID, 57, "You last logged in <col=ff0000>earlier today</col>.");
        sendWidgetText(WidgetId.LOGIN_CLICK_TO_PLAY_GROUP_ID, 61, "Never tell anyone your password,<br>even if they claim to work for Jagex!");
        sendWidgetText(WidgetId.LOGIN_CLICK_TO_PLAY_GROUP_ID, 70, "You do not have a Bank PIN.<br>Please visit a bank if you would like one.");

        // Login Screen: Message of the Week Panel.
        sendWidgetText(WidgetId.LOGIN_CLICK_TO_PLAY_GROUP_ID, 2, "Message of the week");
        sendWidgetText(WidgetId.LOGIN_CLICK_TO_PLAY_GROUP_ID, 3, "Join our Official <col=7289DA>Discord</col> server to chat live with like-minded Developers, <col=6a97a5>Rune-Status.net</col>.");
        sendCS2Script(233, 24772660, 30685, 0, 120, 94, 110, 0, 1800, -1);
        sendCS2Script(233, 24772661, 16356, 0, 190, 0, 122, 0, 3000, -1);
        sendCS2Script(1080, "https://Rune-Status.net/discord/");

        // Login Screen: Messages Panel.
        // TODO: Implement this.
        int unreadMessages = 100;
        sendVarp(262, unreadMessages); //Messages;

        // Login Screen: Membership Panel.
        // TODO: Implement this.
        int membershipRemaining = 30;
        sendVarp(263, membershipRemaining);
        boolean wasMember = true;
        if (wasMember) {
            sendCS2Script(828, 1);
        } else {
            sendCS2Script(828, 0);
        }

        // Game Frame.
        sendRootWidget(WidgetId.GAMEFRAME_GROUP_ID);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 1, WidgetId.CHATBOX_GROUP_ID, true);
        // 2 - 7 = Nothing.
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 8, WidgetId.COMBAT_GROUP_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 9, WidgetId.STATS_GROUP_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 10, WidgetId.QUEST_GROUP_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 11, WidgetId.INVENTORY_GROUP_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 12, WidgetId.EQUIPMENT_GROUP_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 13, WidgetId.PRAYER_GROUP_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 14, WidgetId.MAGIC_GROUP_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 15, WidgetId.CLAN_CHAT_GROUP_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 16, WidgetId.FRIENDS_LIST_GROUP_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 17, WidgetId.IGNORE_LIST_GROUP_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 18, WidgetId.LOGOUT_PANEL_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 19, WidgetId.SETTINGS_PANEL_GROUP_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 20, WidgetId.EMOTES_GROUP_ID, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 21, WidgetId.MUSIC_PANEL_ID, true);
        // 22 = Nothing.
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 23, WidgetId.PRIVATE_CHAT, true);
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 24, WidgetId.MINIMAP_GROUP_ID, true);
        // 25, 26 = Nothing.
        sendOpenWidgetSub(WidgetId.GAMEFRAME_GROUP_ID, 27, WidgetId.LOGIN_CLICK_TO_PLAY_GROUP_ID, false);
        // 28 = Nothing.

        // Emote Panel.
        sendVarp(313, -1); // Unlock Emotes.
        sendVarp(465, -1); // Unlock Emotes: Lost Tribe Quest. (also Status)
        sendVarp(802, -1); // Unlock Emotes: Stronghold of Security.
        sendWidgetClickMask(WidgetId.EMOTES_GROUP_ID, 1, 0, 47, 2); // Clickable Emote List.

        // Settings Panel.
        // TODO: Implement these.
        sendVarp(166, 4); // Display: Screen Brightness.
        sendVarp(168, 0); // Audio: Music Volume.
        sendVarp(169, 0); // Audio: Sound Effect Volume.
        sendVarp(170, 0); // Controls: Mouse Buttons.
        sendVarp(171, 0); // Chat: Chat Effects.
        sendVarp(173, 1); // Run.
        sendRunEnergy(100); // Run Energy.
        sendVarp(287, 1); // Chat: Split Private Chat.
        sendVarp(872, 0); // Audio: Area Sound Effect Volume.
        sendVarp(1074, 1); // Chat: Profanity Filter.

        // TODO: Figure out what each of these do.
        sendWidgetClickMask(WidgetId.SETTINGS_PANEL_GROUP_ID, 85, 1, 4, 2);
        sendWidgetClickMask(WidgetId.SETTINGS_PANEL_GROUP_ID, 86, 1, 4, 2);

        // Quest Panel.
        sendVarp(101, 0); // Quest Points.
        sendWidgetClickMask(WidgetId.QUEST_GROUP_ID, 7, 0, 19, 2); // Free List.
        sendWidgetClickMask(WidgetId.QUEST_GROUP_ID, 8, 0, 116, 2); // Members List.
        sendWidgetClickMask(WidgetId.QUEST_GROUP_ID, 9, 0, 11, 2); // Miniquest List.

        // Music Panel.
        // TODO: Implement this.
        sendMusic(1);
        sendVarp(19, 1); // Loop switch.
        sendVarp(18, 1); // Auto/Manual Switch.
        sendVarp(20, -1); // First 32 Tracks unlocked,
        sendVarp(21, -1); // +32 Tracks,
        sendVarp(22, -1); // +32 Tracks,
        sendVarp(23, -1); // +32 Tracks,
        sendVarp(24, -1); // +32 Tracks,
        sendVarp(25, -1); // +32 Tracks,
        sendVarp(298, -1); // +32 Tracks,
        sendVarp(311, -1); // +32 Tracks,
        sendVarp(346, -1); // +32 Tracks,
        sendVarp(414, -1); // +32 Tracks,
        sendVarp(464, -1); // +32 Tracks,
        sendVarp(598, -1); // +32 Tracks,
        sendVarp(662, -1); // +32 Tracks,
        sendVarp(721, -1); // +32 Tracks,
        sendVarp(906, -1); // +32 Tracks,
        sendVarp(1009, -1); // +32 Tracks,
        sendVarp(1338, -1); // +32 Tracks,
        sendVarp(1681, -1); // +20 Tracks.
        sendWidgetText(WidgetId.MUSIC_PANEL_ID, 5, "AUTO"); // FIXME: This is wrong?
        sendWidgetClickMask(WidgetId.MUSIC_PANEL_ID, 1, 0, 556, 6); // Track List.

        // Combat Panel.
        // TODO: Implement this.
        sendVarp(43, 0); // Attack Style Selection.
        sendVarp(172, -1);// Auto Retaliate
        sendVarp(300, 1000); // Special Attack Amount.
        sendVarp(301, 0); // Special Attack Switch.
        sendVarp(843, 0); // Weapon Style Group.
        sendWidgetText(WidgetId.COMBAT_GROUP_ID, 1, "Unarmed");
        sendWidgetText(WidgetId.COMBAT_GROUP_ID, 2, "Combat Lvl: " + 3);

        // Chatbox Panel: Check Display Name.
        sendVarp(1054, 0); // Clan Tab Setting.
        // TODO: Implement this.
        boolean hasSetDisplayName = true;
        if (hasSetDisplayName) {
            sendCS2Script(1105, 1);
        } else {
            sendCS2Script(1105, 0);
        }

        // Stats Panel.
        sendSkill(3, 10, 1154);
        for (int i = 0; i < 25; i++) {
            if (i != 3) {
                sendSkill(i, 1, 0);
            }
        }

        sendMessage("Welcome to VirtueOS #168!");

        addBlock(SynchronizationBlock.createAppearanceBlock(this));
        addBlock(SynchronizationBlock.createMovementTypeBlock(walkingQueue.runningQueue(), isTeleporting()));
    }

    public void logout() {
        sessionContext.getWorld().getPlayersToRemove().add(this);
        sendLogout();
    }

    /**
     * Handles the disconnection of a {@link com.oldscape.server.game.model.entity.player.Player}
     */
    public void onDisconnection() {
        Server server = sessionContext.getServer();
        server.getSaveService().addPlayerSave(this);
    }

    public void setCameraReposition(int x, int y, int z, int pitch, int yaw) {
        write(new CameraRepositionEvent(x, y, z, pitch, yaw));
    }

    public void sendWidgetClickMask(int root, int component, int from, int to, int settings) {
        write(new WidgetSetClickMaskEvent(root, component, from, to, settings));
    }

    public void sendWidgetNpcHead(int widget, int child, int npc) {
        write(new WidgetNpcHeadEvent(widget, child, npc));
    }

    public void sendWidgetAnim(int widget, int child, int anim) {
        write(new WidgetAnimEvent(widget, child, anim));
    }

    public void sendRegionUpdate(Position position) {
        write(new RegionUpdateEvent(position));
    }

    public void sendRegionUpdate(Position position, GameFrameBuilder builder) {
        write(new RegionUpdateEvent(position, builder));
    }

    public void sendOpenWidgetSub(int root, int child, int interfaceId, boolean clickable) {
        write(new WidgetOpenSubEvent(root, child, interfaceId, clickable));
    }

    public void sendWidgetText(int root, int child, String message) {
        write(new WidgetSetTextEvent(root, child, message));
    }

    public void sendCloseWidgetSub(int root, int child) {
        write(new WidgetCloseSubEvent(root, child));
    }

    public void sendVarp(int i, int val) {
        write(new VarpEvent(i, val));
    }

    public void sendVarbit(int i, int val) {
        varbits.sendVarbit(i, val);
    }

    public void sendVarbit(int i, int val, boolean force) {
        varbits.forceVarbit(i, val);
    }

    public void sendRootWidget(int interfaceId) {
        write(new WidgetSetRootEvent(interfaceId));
    }

    public void sendCS2Script(int id, Object... params) {
        write(new CS2ScriptEvent(id, Lists.reverse(Arrays.asList(params)).toArray()));
    }

    public void sendWidgetMoveSubEvent(int root, int child, int root1, int child1) {
        write(new WidgetMoveSubEvent(root, child, root1, child1));
    }

    public void sendPlayerSynchronization(List<SynchronizationSegment> segments) {
        write(new PlayerSynchronizationEvent(segments));
    }

    public void sendNpcSynchronization(Position position, List<SynchronizationSegment> segments, int localNpcs) {
        write(new NpcSynchronizationEvent(position, segments, localNpcs, viewport.isLargeScene()));
    }

    public void sendExternalIP(String ip) {
        // FIXME: Does this not exist in revision 168?
        //write(new ExternalIPEvent(ip));
    }

    public void sendLogout() {
        write(new LogoutEvent());
    }

    public void sendSlottedItems(int id, int channel, SlottedItem... items) {
        write(new SlottedItemsUpdateEvent(id, channel, items));
    }

    public void sendItems(int id, int channel, Item... items) {
        write(new WidgetItemUpdateEvent(id, channel, items));
    }

    public void sendSkill(int id, int lvl, int xp) {
        write(new SkillEvent(id, lvl, xp));
    }

    public void sendRunEnergy(int amt) {
        write(new RunEnergyEvent(amt));
    }

    public void sendCameraReset() {
        write(new CameraResetEvent());
    }

    public void sendVarpReset() {
        write(new VarpResetEvent());
    }

    public void sendVarpRecache() {
        write(new VarpRecacheEvent());
    }

    public void sendMusic(int id) {
        write(new MusicEvent(id));
    }

    public void sendChatMessage(String playerFrom, String message) {
        if(getCredentials().getPermission() == Permission.ADMINISTRATOR || getCredentials().getPermission() == Permission.MODERATOR) {
            write(new MessageEvent(MessageType.PUBLIC_MOD, playerFrom, message));
        } else {
            write(new MessageEvent(MessageType.PUBLIC, playerFrom, message));
        }
    }

    public void sendMessage(String message) {
        write(new MessageEvent(MessageType.SERVER, message));
    }

    public void initGameFrameCodec() {

        ChannelPipeline pipeline = getChannelPipeline();
        Server server = getServer();
        pipeline.addLast(GameEventEncoder.class.getName(), new GameEventEncoder(server.getEventRepository()));
        pipeline.addBefore(GameEventEncoder.class.getName(), GameFrameEncoder.class.getName(), new GameFrameEncoder(encodingRandom));

        pipeline.addBefore("handler", GameFrameDecoder.class.getName(), new GameFrameDecoder(decodingRandom));
        pipeline.addAfter(GameFrameDecoder.class.getName(), GameEventDecoder.class.getName(), new GameEventDecoder(server.getEventRepository()));
    }

    public Server getServer() {
        return sessionContext.getServer();
    }

    public ChannelPipeline getChannelPipeline() {
        return sessionContext.getChannel().pipeline();
    }

    /**
     * Writes a {@link com.oldscape.shared.event.Event} to the client.
     *
     * @param event The {@link com.oldscape.shared.event.Event} to write.
     */
    public void write(Event event) {
        sessionContext.write(event);
    }

    public DisplayMode getDisplay() {
        return display;
    }

    public void setDisplay(DisplayMode display) {
        this.display = display;
    }

    /**
     * @return the sidePanels
     */
    public boolean isSidePanels() {
        return sidePanels;
    }

    /**
     * @param sidePanels the sidePanels to set
     */
    public void setSidePanels(boolean sidePanels) {
        this.sidePanels = sidePanels;
    }

    /**
     * @return the inGame
     */
    public final boolean isInGame() {
        return inGame;
    }

    /**
     * @param inGame the inGame to set
     */
    public final void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    /**
     * @return the viewport
     */
    public final Viewport getViewport() {
        return viewport;
    }

    /**
     * @return the appearance
     */
    public Appearance getAppearance() {
        return appearance;
    }

    /**
     * Gets the account's prayer icon.
     *
     * @return The prayer icon.
     */
    public int getPrayerIcon() {
        return prayerIcon;
    }

    /**
     * Indicates whether or not the account is skulled
     *
     * @return {@code true} if the account is skulled, otherwise {@code false}.
     */
    public boolean isSkulled() {
        return skulled;
    }

    /**
     * Indicates whether or not the account is hidden
     *
     * @return {@code true} if the account is hidden, otherwise {@code false}.
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Gets the {@link com.oldscape.server.game.network.game.GameSessionContext}.
     *
     * @return The {@code sessionContext}.
     */
    public GameSessionContext getSessionContext() {
        return sessionContext;
    }

    /**
     * Sets the {@link com.oldscape.server.game.network.game.GameSessionContext}.
     *
     * @param sessionContext The {@link com.oldscape.server.game.network.game.GameSessionContext} to
     *                       set.
     */
    public void setSessionContext(GameSessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

    /**
     * Gets the {@link Credentials}.
     *
     * @return The {@code credentials}.
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * Gets the id.
     *
     * @return The {@code id}.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the {@link com.oldscape.shared.utility.IsaacRandom} for the server.
     *
     * @return The {@code encodingRandom}.
     */
    public IsaacRandom getEncodingRandom() {
        return encodingRandom;
    }

    /**
     * @param encodingRandom the encodingRandom to set
     */
    public void setEncodingRandom(IsaacRandom encodingRandom) {
        this.encodingRandom = encodingRandom;
    }

    /**
     * Gets the {@link com.oldscape.shared.utility.IsaacRandom}.
     *
     * @return The {@code decodingRandom}.
     */
    public IsaacRandom getDecodingRandom() {
        return decodingRandom;
    }

    /**
     * @param decodingRandom the decodingRandom to set
     */
    public void setDecodingRandom(IsaacRandom decodingRandom) {
        this.decodingRandom = decodingRandom;
    }

    /**
     * Gets this account's equipment.
     *
     * @return The account's equipment.
     */
    public final ItemContainer getEquipment() {
        return equipment;
    }

    /**
     * Gets this account's inventory.
     *
     * @return The account's inventory.
     */
    public final ItemContainer getInventory() {
        return inventory;
    }

    /**
     * Gets this account's bank.
     *
     * @return The account's bank.
     */
    public final ItemContainer getBank() {
        return bank;
    }

}
