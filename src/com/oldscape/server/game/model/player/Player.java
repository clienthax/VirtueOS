package com.oldscape.server.game.model.player;

import com.google.common.collect.Lists;
import com.oldscape.server.game.Server;
import com.oldscape.server.game.model.MobileEntity;
import com.oldscape.server.game.model.player.inv.*;
import com.oldscape.server.game.model.player.inv.ItemContainer.StackMode;
import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.server.game.model.sync.reference.Appearance;
import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.Event;
import com.oldscape.shared.model.MessageType;
import com.oldscape.shared.model.Position;
import com.oldscape.shared.model.player.AccountCredentials;
import com.oldscape.shared.model.player.DisplayMode;
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
     * The {@link com.oldscape.shared.model.player.AccountCredentials}.
     */
    protected final AccountCredentials credentials;
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
     * The viewport for this player
     */
    private final Viewport viewport = new Viewport(this);
    /**
     * Gets the {@link com.oldscape.server.game.network.game.GameSessionContext}.
     */
    protected GameSessionContext sessionContext;
    /**
     * The {@link com.oldscape.shared.model.player.DisplayMode}.
     */
    protected DisplayMode display;
    /**
     * The {@link com.oldscape.shared.utility.IsaacRandom} for the server and
     * client.
     */
    private IsaacRandom encodingRandom, decodingRandom;
    /**
     * The player's appearance.
     */
    private Appearance appearance = Appearance.DEFAULT_APPEARANCE;
    /**
     * This player's prayer icon.
     */
    private int prayerIcon = -1;

    /**
     * Whether or not the player is skulled.
     */
    private boolean skulled = false;

    /**
     * Whether or not the player is hidden.
     */
    private boolean hidden = false;

    /**
     * If player is using side panels.
     */
    private boolean sidePanels = false;

    /**
     * If the player is past the welcome screen.
     */
    private boolean inGame = false;

    /**
     * Creates a new {@link com.oldscape.server.game.model.player.Player}.
     *
     * @param id          The slot the player is in the database.
     * @param credentials The {@link com.oldscape.shared.model.player.AccountCredentials}.
     * @param display     The {@link com.oldscape.shared.model.player.DisplayMode}.
     */
    public Player(int id, AccountCredentials credentials, DisplayMode display) {
        this.id = id;
        this.credentials = credentials;
        this.display = display;
    }

    // its possible the region packet is out of date, in osrs it also calls for
    // player updating, if it is the same try just sending them both at once,
    // but if its not

    /**
     * Initializes the {@link com.oldscape.shared.model.Node}.
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
     * Handles the login of a {@link com.oldscape.server.game.model.player.Player}
     */
    public void onLogin() {

        GameFrameBuilder builder = new GameFrameBuilder(sessionContext.getChannel().alloc());

        viewport.initialize(builder, sessionContext.getWorld());

        sendRegionUpdate(position, builder);

        sendExternalIP(credentials.getLastKnownIpAddress());

        //TODO figure out the varps etc
		/*
		sendSetInterfaceText(378, 14, "Never tell anyone your password, even if they claim to work for Jagex!");
		sendSetInterfaceText(378, 15, "You have 0 unread messages in your message centre.");
		sendSetInterfaceText(378, 18, "You are not a member. Subscribe to access extra skills, areas and quests, and much<br>more besides.");
		sendSetInterfaceText(378, 20, "A membership subscription grants access to the members-only features of both versions of RuneScape.");
		sendSetInterfaceText(378, 21, "Keep your account secure.");
		sendSetInterfaceText(378, 13, "You last logged in <col=ff0000>earlier today<col=000000>.");
		sendSetInterfaceText(378, 16, "You do not have a Bank PIN. Please visit a bank if you would like one.");
		sendSetInterfaceText(50, 3, "Organise your teleport scrolls in the new <col=6f007f>Master Scroll Book</col> available from treasure trails. Also you can now recolour <col=003fbf>rock golems</col> with lovekite, elemental or daeyalt ore!");
		sendSetInterfaceText(593, 1, "Unarmed");
		sendSetInterfaceText(593, 2, "Combat Lvl: 3");
		sendSetInterfaceText(239, 5, "AUTO");

		sendSetRootInterface(165);
		
		sendOpenInterfaceSub(165, 1, 162, true);
		sendOpenInterfaceSub(165, 8, 593, true);
		sendOpenInterfaceSub(165, 9, 320, true);
		sendOpenInterfaceSub(165, 10, 76, true);
		sendOpenInterfaceSub(165, 11, 149, true);
		sendOpenInterfaceSub(165, 12, 387, true);
		sendOpenInterfaceSub(165, 13, 541, true);
		sendOpenInterfaceSub(165, 14, 218, true);
		sendOpenInterfaceSub(165, 15, 7, true);
		sendOpenInterfaceSub(165, 16, 429, true);
		sendOpenInterfaceSub(165, 17, 432, true);
		sendOpenInterfaceSub(165, 18, 182, true);
		sendOpenInterfaceSub(165, 19, 261, true);
		sendOpenInterfaceSub(165, 20, 216, true);
		sendOpenInterfaceSub(165, 21, 239, true);
		sendOpenInterfaceSub(165, 23, 163, true);
		sendOpenInterfaceSub(165, 24, 160, true);
		sendOpenInterfaceSub(165, 28, 50, false);//50 = theme
		sendOpenInterfaceSub(165, 29, 378, false);
		
		sendCS2Script(233, new Object[] { 3276804, 33179, 0, 0, 468, 1897, 0, 392, -1});
		sendCS2Script(233, new Object[] { 3276805, 33194, 0, 56, 54, 74, 0, 660, -1});
		
		sendInterfaceSetClickMask(216, 1, 0, 46, 2);
		sendInterfaceSetClickMask(239, 1, 0, 535, 2);

		sendVarp(18, 1);
		sendVarp(20, 131072);
		sendVarp(21, 67141632);
		sendVarp(22, 33554432);
		sendVarp(23, 2097216);
		sendVarp(43, 1);
		sendVarp(101, 0);
		sendVarp(153, -1);
		sendVarp(166, 2);
		sendVarp(167, 0);
		sendVarp(168, 4);
		sendVarp(169, 4);
		sendVarp(170, 0);
		sendVarp(171, 0);
		sendVarp(173, 1);
		sendVarp(281, 1000);
		sendVarp(284, 60001);
		sendVarp(287, 0);
		sendVarp(300, 1000);
		sendVarp(406, 20);
		sendVarp(447, -1);
		sendVarp(449, 2097152);
		sendVarp(486, 1073741824);
		sendVarp(520, 1);
		sendVarp(553, -2147483648);
		sendVarp(788, 128);
		sendVarp(810, 33554432);
		sendVarp(849, -1);
		sendVarp(850, -1);
		sendVarp(851, -1);
		sendVarp(852, -1);
		sendVarp(853, -1);
		sendVarp(854, -1);
		sendVarp(855, -1);
		sendVarp(856, -1);
		sendVarp(872, 4);
		sendVarp(904, 253);
		sendVarp(913, 4194304);
		sendVarp(1010, 2048);
		sendVarp(1017, 8192);
		sendVarp(1050, 4096);
		sendVarp(1065, -1);
		sendVarp(1067, -1302855680);
		sendVarp(1074, 0);
		sendVarp(1075, -1);
		sendVarp(1107, 0);
		sendVarp(1151, -1);
		sendVarp(1224, 172395585);
		sendVarp(1225, 379887846);
		sendVarp(1226, 12);
		sendVarp(1306, 0);
		sendVarp(1427, -1);

		sendMessage("Welcome to Unnamed #155.");

		// sendSetInterfaceText(12, 4, "Bank of Unnamed #149.");

		// sendSkill(0, 99, 200000000);
		// sendSkill(1, 99, 200000000);
		// sendSkill(2, 99, 200000000);
		// sendSkill(3, 99, 200000000);
		// sendSkill(4, 99, 200000000);
		// sendSkill(5, 99, 200000000);
		// sendSkill(6, 99, 200000000);
		// sendSkill(7, 99, 200000000);
		// sendSkill(8, 99, 200000000);
		// sendSkill(9, 99, 200000000);
		// sendSkill(10, 99, 200000000);
		// sendSkill(11, 99, 200000000);
		// sendSkill(12, 99, 200000000);
		// sendSkill(13, 99, 200000000);
		// sendSkill(14, 99, 200000000);
		// sendSkill(15, 99, 200000000);
		// sendSkill(16, 99, 200000000);
		// sendSkill(17, 99, 200000000);
		// sendSkill(18, 99, 200000000);
		// sendSkill(19, 99, 200000000);
		// sendSkill(20, 99, 200000000);
		// sendSkill(21, 99, 200000000);
		// sendSkill(22, 99, 200000000);
		// sendSkill(23, 99, 200000000);
		// sendSkill(24, 99, 200000000);
		//
		// sendRunEnergy(100);
		//
		// sendMusic(177);
		//todo
		*/


		/*
		sendSetInterfaceText(378, 14, "Never tell anyone your password, even if they claim to work for Jagex!");
		sendSetInterfaceText(378, 15, "You have 0 unread messages in your message centre");
		sendSetInterfaceText(378, 18, "You are not a member Subscribe to access extra skills, areas and quests, and much<br>more besides");
		sendSetInterfaceText(378, 20, "A membership subscription grants access to the members-only features of both versions of RuneScape");
		sendSetInterfaceText(378, 21, "Keep your account secure");
		sendSetInterfaceText(378, 13, "You last logged in <col=ff0000>earlier today<col=000000>");
		sendSetInterfaceText(378, 16, "You do not have a Bank PIN Please visit a bank if you would like one");
		sendSetRootInterface(165);
		sendOpenInterfaceSub(165, 1, 162, true);
		sendOpenInterfaceSub(165, 23, 163, true);
		sendOpenInterfaceSub(165, 24, 160, true);
		//sendOpenInterfaceSub(165, 29, 378, false);//heh, seems to be missing on 168

		int loginTheme = 50;

		sendOpenInterfaceSub(165, 28, loginTheme, false);
		sendSetInterfaceText(50, 3, "Once you've had a <col=cfcfcf>graceful set</col> repainted <col=2f2fff>blue</col> in <col=4f2f1f>Brimhaven</col>,<br>you can get <col=003600>individual pieces</col> repainted<br>Next week, <col=9f005f>Halloween</col>!");
		sendCS2Script(233, new Object[] {3276804, 7085, 0, 0, 434, 1912, 0, 400, -1});
		sendCS2Script(233, new Object[] {3276805, 32817, 0, 100, 93, 179, 0, 800, 820});
		sendCS2Script(1080, new Object[] {});
		sendOpenInterfaceSub(165, 9, 320, true);
		sendOpenInterfaceSub(165, 10, 399, true);
		sendOpenInterfaceSub(165, 11, 149, true);
		sendOpenInterfaceSub(165, 12, 387, true);
		sendOpenInterfaceSub(165, 13, 541, true);
		sendOpenInterfaceSub(165, 14, 218, true);
		sendOpenInterfaceSub(165, 16, 429, true);
		sendOpenInterfaceSub(165, 17, 432, true);
		sendOpenInterfaceSub(165, 18, 182, true);
		sendOpenInterfaceSub(165, 19, 261, true);
		sendOpenInterfaceSub(165, 20, 216, true);
		sendOpenInterfaceSub(165, 21, 239, true);
		sendOpenInterfaceSub(165, 15, 7, true);
		sendOpenInterfaceSub(165, 8, 593, true);
		sendSetInterfaceText(593, 1, "Unarmed");
		sendSetInterfaceText(593, 2, "Combat Lvl: 126");
		sendSetInterfaceText(239, 5, "AUTO");
		sendCS2Script(2014, new Object[] {0, 0, 0, 0, 0, 0});
		sendCS2Script(2015, new Object[] {0});
		sendVarp(18, 1);
		sendVarp(20, 131072);
		sendVarp(21, 67141632);
		sendVarp(22, 33554432);
		sendVarp(23, 2097216);
		sendVarp(43, 1);
		sendVarp(101, 0);
		sendVarp(153, -1);
		sendVarp(166, 2);
		sendVarp(167, 0);
		sendVarp(168, 4);
		sendVarp(169, 4);
		sendVarp(170, 0);
		sendVarp(171, 0);
		sendVarp(173, 1);
		sendVarp(281, 1000);
		sendVarp(284, 60001);
		sendVarp(287, 0);
		sendVarp(300, 1000);
		sendVarp(406, 20);
		sendVarp(447, -1);
		sendVarp(449, 2097152);
		sendVarp(486, 1073741824);
		sendVarp(520, 1);
		sendVarp(553, -2147483648);
		sendVarp(788, 128);
		sendVarp(810, 33554432);
		sendVarp(849, -1);
		sendVarp(850, -1);
		sendVarp(851, -1);
		sendVarp(852, -1);
		sendVarp(853, -1);
		sendVarp(854, -1);
		sendVarp(855, -1);
		sendVarp(856, -1);
		sendVarp(872, 4);
		sendVarp(904, 253);
		sendVarp(913, 4194304);
		sendVarp(1010, 2048);
		sendVarp(1017, 8192);
		sendVarp(1050, 4096);
		sendVarp(1065, -1);
		sendVarp(1067, -1302855680);
		sendVarp(1074, 0);
		sendVarp(1075, -1);
		sendVarp(1107, 0);
		sendVarp(1151, -1);
		sendVarp(1224, 172395585);
		sendVarp(1225, 379887846);
		sendVarp(1226, 12);
		sendVarp(1306, 0);
		sendVarp(1427, -1);
		*/

        sendVarpReset();

        sendVarp(0, 11);
        sendVarp(11, 5);
        sendVarp(12, 16);
        sendVarp(18, 1);
        sendVarp(19, 1);
        sendVarp(20, 1543450431);
        sendVarp(21, -1632247826);
        sendVarp(22, 2011150318);
        sendVarp(23, -1895859086);
        sendVarp(24, -2078508105);
        sendVarp(25, -101577798);
        sendVarp(26, 10);
        sendVarp(29, 2);
        sendVarp(31, 100);
        sendVarp(32, 3);
        sendVarp(43, 3);
        sendVarp(60, 1);
        sendVarp(62, 6);
        sendVarp(63, 6);
        sendVarp(65, 10);
        sendVarp(67, 3);
        sendVarp(68, 16);
        sendVarp(71, 4);
        sendVarp(80, 4);
        sendVarp(84, 4608);
        sendVarp(101, 87);
        sendVarp(107, 5);
        sendVarp(111, 9);
        sendVarp(122, 7);
        sendVarp(130, 4);
        sendVarp(131, 9);
        sendVarp(135, 994);
        sendVarp(144, 100);
        sendVarp(146, 4);
        sendVarp(147, 6);
        sendVarp(153, -1);
        sendVarp(159, 12);
        sendVarp(160, 2);
        sendVarp(165, 30);
        sendVarp(166, 4);
        sendVarp(167, 0);
        sendVarp(168, 3);
        sendVarp(169, 3);
        sendVarp(170, 0);
        sendVarp(171, 0);
        sendVarp(173, 1);
        sendVarp(175, 12);
        sendVarp(176, 10);
        sendVarp(177, 8257604);
        sendVarp(178, 3);
        sendVarp(179, 21);
        sendVarp(180, 6);
        sendVarp(222, 22437955);
        sendVarp(263, 17);
        sendVarp(273, 110);
        sendVarp(279, 97060);
        sendVarp(281, 1000);
        sendVarp(284, 60001);
        sendVarp(287, 1);
        sendVarp(298, 11207152);
        sendVarp(300, 1000);
        sendVarp(302, 61);
        sendVarp(304, 20000);
        sendVarp(307, 110);
        sendVarp(311, 285215680);
        sendVarp(313, 128);
        sendVarp(314, 80);
        sendVarp(317, 50);
        sendVarp(318, 536870975);
        sendVarp(320, 1);
        sendVarp(335, 110);
        sendVarp(346, 41602207);
        sendVarp(399, 8);
        sendVarp(406, 20);
        sendVarp(408, -2017034368);
        sendVarp(414, 1885798414);
        sendVarp(425, 9);
        sendVarp(433, 2019844462);
        sendVarp(435, 693532);
        sendVarp(436, 855699855);
        sendVarp(447, -1);
        sendVarp(449, 2097152);
        sendVarp(464, 1078001915);
        sendVarp(482, 388268466);
        sendVarp(486, 1073741824);
        sendVarp(491, 1073799168);
        sendVarp(492, 4);
        sendVarp(496, 15958018);
        sendVarp(498, 67108864);
        sendVarp(520, 1);
        sendVarp(521, -208678004);
        sendVarp(531, 1697);
        sendVarp(534, 153391689);
        sendVarp(553, -764476036);
        sendVarp(554, 1609826303);
        sendVarp(598, 98560);
        sendVarp(623, 1073741824);
        sendVarp(661, 12);
        sendVarp(662, 410517755);
        sendVarp(664, -1);
        sendVarp(667, 42);
        sendVarp(671, 20971610);
        sendVarp(673, 2);
        sendVarp(709, -2139095027);
        sendVarp(710, 31783);
        sendVarp(711, 3000);
        sendVarp(712, 23);
        sendVarp(721, 2048);
        sendVarp(728, 6);
        sendVarp(738, 201337889);
        sendVarp(788, 128);
        sendVarp(802, 527);
        sendVarp(810, 33554432);
        sendVarp(842, 1);
        sendVarp(843, 9);
        sendVarp(849, -1);
        sendVarp(850, -1);
        sendVarp(851, -1);
        sendVarp(852, -1);
        sendVarp(853, -1);
        sendVarp(854, -1);
        sendVarp(855, -1);
        sendVarp(856, -1);
        sendVarp(867, 44065803);
        sendVarp(872, 3);
        sendVarp(904, 263);
        sendVarp(906, 135267484);
        sendVarp(912, 35528);
        sendVarp(913, 8213268);
        sendVarp(977, 1362);
        sendVarp(978, 130023424);
        sendVarp(1000, 1342186021);
        sendVarp(1001, 1073741826);
        sendVarp(1009, 262660);
        sendVarp(1010, 6242);
        sendVarp(1011, 1086079);
        sendVarp(1014, 1073741822);
        sendVarp(1017, 8192);
        sendVarp(1045, 809048064);
        sendVarp(1046, 1073741824);
        sendVarp(1047, 6144);
        sendVarp(1048, 64);
        sendVarp(1050, 4096);
        sendVarp(1052, 28320781);
        sendVarp(1053, 43002886);
        sendVarp(1054, 2);
        sendVarp(1055, 267264);
        sendVarp(1065, -1);
        sendVarp(1067, -1204289536);
        sendVarp(1074, 1);
        sendVarp(1075, -1);
        sendVarp(1105, 10);
        sendVarp(1107, 0);
        sendVarp(1111, 1);
        sendVarp(1112, 4);
        sendVarp(1151, -1);
        sendVarp(1176, 536739838);
        sendVarp(1178, 33687616);
        sendVarp(1180, 2621632);
        sendVarp(1182, 8192);
        sendVarp(1184, 1049088);
        sendVarp(1186, 33817279);
        sendVarp(1188, -1073740801);
        sendVarp(1190, 3145728);
        sendVarp(1192, 67108864);
        sendVarp(1194, 139298);
        sendVarp(1196, 65536);
        sendVarp(1198, 2064);
        sendVarp(1224, 172395585);
        sendVarp(1225, 379887846);
        sendVarp(1226, 12);
        sendVarp(1227, -1665138688);
        sendVarp(1238, 11000);
        sendVarp(1247, 119737);
        sendVarp(1262, 13363);
        sendVarp(1271, 166636);
        sendVarp(1306, 0);
        sendVarp(1317, -2147483648);
        sendVarp(1427, -1);
        sendVarp(1429, 30720);
        sendVarp(1535, 134221703);
        sendVarp(1566, 1);
        sendVarp(1677, 16384);
        sendVarp(1683, -1);
        sendVarp(1706, 2);
        sendVarp(1719, 1048595);
        sendVarp(1720, 2621442);
        sendVarp(1721, 2228241);
        sendVarp(1722, 2228258);
        sendVarp(1723, 16777438);
        sendVarp(1724, 16);
        sendVarp(1725, 866423);

        sendCS2Script(828, new Object[]{1});
        ;
        sendSetInterfaceText(378, 70, "You do not have a Bank PIN.<br>Please visit a bank if you would like one.");
        sendSetInterfaceText(378, 3, "Delve into the history of <col=ff0000>Shayzien House</col> and uncover a conspiracy a thousand years in the making in our new quest, <col=ffff00>Tale of the Righteous</col>.");
        sendCS2Script(233, new Object[]{24772660, 30685, 0, 120, 94, 110, 0, 1800, -1});
        sendCS2Script(233, new Object[]{24772661, 16356, 0, 190, 0, 122, 0, 3000, -1});


        sendSetRootInterface(165);
        sendCS2Script(1105, new Object[]{1});
        sendOpenInterfaceSub(165, 1, 162, true);
        sendOpenInterfaceSub(165, 23, 163, true);
        sendOpenInterfaceSub(165, 24, 160, true);
        sendOpenInterfaceSub(165, 27, 378, false);
        sendCS2Script(1080, new Object[]{});
        //resetCamera();
        sendOpenInterfaceSub(165, 9, 320, true);
        sendOpenInterfaceSub(165, 10, 399, true);
        sendInterfaceSetClickMask(399, 7, 0, 19, 2);
        sendInterfaceSetClickMask(399, 8, 0, 116, 2);
        sendInterfaceSetClickMask(399, 9, 0, 11, 2);
        sendOpenInterfaceSub(165, 11, 149, true);
        sendOpenInterfaceSub(165, 12, 387, true);
        sendOpenInterfaceSub(165, 13, 541, true);
        sendOpenInterfaceSub(165, 14, 218, true);
        sendOpenInterfaceSub(165, 16, 429, true);
        sendOpenInterfaceSub(165, 17, 432, true);
        sendOpenInterfaceSub(165, 18, 182, true);
        sendOpenInterfaceSub(165, 19, 261, true);
        sendInterfaceSetClickMask(261, 85, 1, 4, 2);
        sendInterfaceSetClickMask(261, 86, 1, 4, 2);
        sendOpenInterfaceSub(165, 20, 216, true);
        sendInterfaceSetClickMask(216, 1, 0, 47, 2);
        sendOpenInterfaceSub(165, 21, 239, true);
        sendInterfaceSetClickMask(239, 1, 0, 556, 6);
        sendOpenInterfaceSub(165, 15, 7, true);
        sendOpenInterfaceSub(165, 8, 593, true);
        sendSetInterfaceText(593, 1, "Rune scimitar");
        sendSetInterfaceText(593, 2, "Combat Lvl: 57");

        sendSetInterfaceText(239, 5, "AUTO");
        sendOpenInterfaceSub(165, 24, 160, true);

        for (int i = 0; i < 25; i++)
            sendSkill(i, 99, 200000000);

        sendVarp(375, 8);
        sendCS2Script(2014, new Object[]{0, 0, 0, 0, 0, 0});
        sendCS2Script(2015, new Object[]{0});
        sendVarp(1055, 267264);


        sendMessage("Welcome to VirtueOS #168!");
        sendRunEnergy(100);
        sendMusic(1);


        addBlock(SynchronizationBlock.createAppearanceBlock(this));
        addBlock(SynchronizationBlock.createMovementTypeBlock(walkingQueue.runningQueue(), isTeleporting()));
    }

    public void logout() {
        sessionContext.getWorld().getPlayersToRemove().add(this);
        sendLogout();
    }

    /**
     * Handles the disconnection of a {@link com.oldscape.server.game.model.player.Player}
     */
    public void onDisconnection() {
        Server server = sessionContext.getServer();

        server.getSaveService().addPlayerSave(this);
    }

    public void sendInterfaceSetClickMask(int root, int component, int from, int to, int settings) {
        write(new InterfaceSetClickMaskEvent(root, component, from, to, settings));
    }

    public void sendRegionUpdate(Position position) {
        write(new RegionUpdateEvent(position));
    }

    public void sendRegionUpdate(Position position, GameFrameBuilder builder) {
        write(new RegionUpdateEvent(position, builder));
    }

    public void sendOpenInterfaceSub(int root, int child, int interfaceId, boolean clickable) {
        write(new InterfaceOpenSubEvent(root, child, interfaceId, clickable));
    }

    public void sendSetInterfaceText(int root, int child, String message) {
        write(new InterfaceSetTextEvent(root, child, message));
    }

    public void sendCloseInterfaceSub(int root, int child) {
        write(new InterfaceCloseSubEvent(root, child));
    }

    public void sendVarp(int i, int val) {
        write(new VarpEvent(i, val));
    }

    public void sendSetRootInterface(int interfaceId) {
        write(new SetRootInterfaceEvent(interfaceId));
    }

    public void sendCS2Script(int id, Object[] params) {
        // TODO Temp Fix. params are encoded/decoded backwards.
        write(new CS2ScriptEvent(id, Lists.reverse(Arrays.asList(params)).toArray()));
    }

    public void sendSetInterfaceMoveSubEvent(int root, int child, int root1, int child1) {
        write(new InterfaceMoveSubEvent(root, child, root1, child1));
    }

    public void sendPlayerSynchronization(List<SynchronizationSegment> segments) {
        write(new PlayerSynchronizationEvent(segments));
    }

    public void sendNpcSynchronization(Position position, List<SynchronizationSegment> segments, int localNpcs) {
        write(new NpcSynchronizationEvent(position, segments, localNpcs, viewport.isLargeScene()));
    }

    public void sendExternalIP(String ip) {
        //Not in 168 O_o
        //write(new ExternalIPEvent(ip));
    }

    public void sendLogout() {
        write(new LogoutEvent());
    }

    public void sendSlottedItems(int id, int channel, SlottedItem... items) {
        write(new SlottedItemsUpdateEvent(id, channel, items));
    }

    public void sendItems(int id, int channel, Item... items) {
        write(new ItemsUpdateEvent(id, channel, items));
    }

    public void sendSkill(int id, int lvl, int xp) {
        write(new SkillEvent(id, lvl, xp));
    }

    public void sendRunEnergy(int amt) {
        write(new RunEnergyEvent(amt));
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
        write(new MessageEvent(MessageType.CHAT, playerFrom, message));
    }

    public void sendMessage(String message) {
        write(new MessageEvent(MessageType.GAME, message));
    }

    public void initGameFrameCodec() {

        ChannelPipeline pipeline = sessionContext.getChannel().pipeline();
        Server server = sessionContext.getServer();

        pipeline.addLast(GameEventEncoder.class.getName(), new GameEventEncoder(server.getEventRepository()));
        pipeline.addBefore(GameEventEncoder.class.getName(), GameFrameEncoder.class.getName(), new GameFrameEncoder(encodingRandom));

        pipeline.addBefore("handler", GameFrameDecoder.class.getName(), new GameFrameDecoder(decodingRandom));
        pipeline.addAfter(GameFrameDecoder.class.getName(), GameEventDecoder.class.getName(), new GameEventDecoder(server.getEventRepository()));
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
     * Gets the player's prayer icon.
     *
     * @return The prayer icon.
     */
    public int getPrayerIcon() {
        return prayerIcon;
    }

    /**
     * Indicates whether or not the player is skulled
     *
     * @return {@code true} if the player is skulled, otherwise {@code false}.
     */
    public boolean isSkulled() {
        return skulled;
    }

    /**
     * Indicates whether or not the player is hidden
     *
     * @return {@code true} if the player is hidden, otherwise {@code false}.
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
     * Gets the {@link com.oldscape.shared.model.player.AccountCredentials}.
     *
     * @return The {@code credentials}.
     */
    public AccountCredentials getCredentials() {
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
     * Gets this player's equipment.
     *
     * @return The player's equipment.
     */
    public final ItemContainer getEquipment() {
        return equipment;
    }

    /**
     * Gets this player's inventory.
     *
     * @return The player's inventory.
     */
    public final ItemContainer getInventory() {
        return inventory;
    }

    /**
     * Gets this player's bank.
     *
     * @return The player's bank.
     */
    public final ItemContainer getBank() {
        return bank;
    }

}
