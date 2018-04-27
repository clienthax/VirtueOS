package com.oldscape.client;

public class ServerPacket {
   public static final ServerPacket logoutPacket;
   public static final ServerPacket LOC_ANIM;
   public static final ServerPacket IF_SET_SCROLL_POS;
   public static final ServerPacket TRIGGER_ONDIALOGABORT;
   public static final ServerPacket FRIENDLIST_LOADED;
   public static final ServerPacket MESSAGE_PRIVATE_ECHO;
   public static final ServerPacket REFLECTION_CHECKER;
   public static final ServerPacket HINT_ARROW;
   public static final ServerPacket IF_MOVE_SUB;
   public static final ServerPacket IF_SETCOLOUR;
   public static final ServerPacket dynamicRegionPacket;
   public static final ServerPacket UPDATE_INV_PARTIAL;
   public static final ServerPacket CAM_SHAKE;
   public static final ServerPacket UPDATE_INV_FULL;
   public static final ServerPacket setVarpSmall;
   public static final ServerPacket clearAnimationsPacket;
   public static final ServerPacket grandExchangeOffersPacket;
   public static final ServerPacket field2314;
   public static final ServerPacket getParamsPacket;
   public static final ServerPacket grandExchangeEventsPackets;
   public static final ServerPacket UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER;
   public static final ServerPacket field2318;
   public static final ServerPacket MESSAGE_FRIENDCHANNEL;
   public static final ServerPacket OBJ_DEL;
   public static final ServerPacket UPDATE_IGNORELIST;
   public static final ServerPacket UPDATE_ZONE_PARTIAL_ENCLOSED;
   public static final ServerPacket LOC_CUSTOMISE;
   public static final ServerPacket IF_SETANIM;
   public static final ServerPacket IF_SETANGLE;
   public static final ServerPacket IF_OPENSUB;
   public static final ServerPacket IF_CLOSESUB;
   public static final ServerPacket UPDATE_FRIENDLIST;
   public static final ServerPacket groundItemSpawnPacket;
   public static final ServerPacket NPC_INFO_SMALL;
   public static final ServerPacket field2331;
   public static final ServerPacket IF_SETTEXT;
   public static final ServerPacket IF_SETNPCHEAD;
   public static final ServerPacket UPDATE_STAT;
   public static final ServerPacket IF_SETCLICKMASK;
   public static final ServerPacket IF_SETPLAYERHEAD;
   public static final ServerPacket playerUpdatePacket;
   public static final ServerPacket staticRegionPacket;
   public static final ServerPacket MESSAGE_PRIVATE;
   public static final ServerPacket UPDATE_RUNENERGY;
   public static final ServerPacket OBJ_COUNT;
   public static final ServerPacket setVarpLarge;
   public static final ServerPacket CHAT_FILTER_SETTINGS;
   public static final ServerPacket CAM_LOOKAT;
   public static final ServerPacket cameraPacket;
   public static final ServerPacket NPC_INFO_LARGE;
   public static final ServerPacket UPDATE_INV_STOP_TRANSMIT;
   public static final ServerPacket LOGOUT_TRANSFER;
   public static final ServerPacket SET_MAP_FLAG;
   public static final ServerPacket MAP_PROJANIM;
   public static final ServerPacket field2361;
   public static final ServerPacket UPDATE_RUNWEIGHT;
   public static final ServerPacket SYNTH_SOUND;
   public static final ServerPacket IF_SETOBJECT;
   public static final ServerPacket field2338;
   public static final ServerPacket performanceMonitoringPacket;
   public static final ServerPacket LOC_ADD_CHANGE;
   public static final ServerPacket UPDATE_ZONE_PARTIAL_FOLLOWS;
   public static final ServerPacket IF_SETMODEL;
   public static final ServerPacket UPDATE_UID192;
   public static final ServerPacket cameraResetPacket;
   public static final ServerPacket playerOptionsPacket;
   public static final ServerPacket IF_OPEN_TOP;
   public static final ServerPacket IF_SET_POSITION;
   public static final ServerPacket IF_SET_HIDDEN;
   public static final ServerPacket UPDATE_FRIENDCHAT_CHANNEL_FULL;
   public static final ServerPacket field2367;
   public static final ServerPacket SOUND_AREA;
   public static final ServerPacket CHAT_FILTER_SETTINGS_PRIVATECHAT;
   public static final ServerPacket UPDATE_REBOOT_TIMER;
   public static final ServerPacket RUNCLIENTSCRIPT;
   public static final ServerPacket OBJ_ADD;
   public static final ServerPacket field2373;
   public static final ServerPacket field2374;
   public static final ServerPacket RESET_CLIENT_VARCACHE;
   public static final ServerPacket MESSAGE_GAME;
   public static final ServerPacket MINIMAP_TOGGLE;
   public static final ServerPacket field2378;
   public static final ServerPacket playSongPacket;
   public static final ServerPacket IF_PREBUILD_TOP_LEVEL;
   public final int packetId;
   public final int packetLength;

   static {
      logoutPacket = new ServerPacket(0, 0);
      LOC_ANIM = new ServerPacket(1, 6);
      IF_SET_SCROLL_POS = new ServerPacket(2, 6);
      TRIGGER_ONDIALOGABORT = new ServerPacket(3, 0);
      FRIENDLIST_LOADED = new ServerPacket(4, 0);
      MESSAGE_PRIVATE_ECHO = new ServerPacket(5, -2);
      REFLECTION_CHECKER = new ServerPacket(6, -2);//reflection lookup for anticheat
      HINT_ARROW = new ServerPacket(7, 6);
      IF_MOVE_SUB = new ServerPacket(8, 8);//IF_MOVESUB / setinterfacesets ?
      IF_SETCOLOUR = new ServerPacket(9, 6);
      dynamicRegionPacket = new ServerPacket(10, -2);//REBUILD_REGION
      UPDATE_INV_PARTIAL = new ServerPacket(11, -2);
      CAM_SHAKE = new ServerPacket(12, 4);
      UPDATE_INV_FULL = new ServerPacket(13, -2);
      setVarpSmall = new ServerPacket(14, 3);
      clearAnimationsPacket = new ServerPacket(15, 0);
      grandExchangeOffersPacket = new ServerPacket(16, 20);

      field2314 = new ServerPacket(17, 4);
      getParamsPacket = new ServerPacket(18, -1);
      grandExchangeEventsPackets = new ServerPacket(19, -2);

      UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER = new ServerPacket(20, -1);
      field2318 = new ServerPacket(21, 4);
      MESSAGE_FRIENDCHANNEL = new ServerPacket(22, -1);
      OBJ_DEL = new ServerPacket(23, 3);
      UPDATE_IGNORELIST = new ServerPacket(24, -2);
      UPDATE_ZONE_PARTIAL_ENCLOSED = new ServerPacket(25, -2);//for doing multiple objects at once, eg moving projectiles
      LOC_CUSTOMISE = new ServerPacket(26, 4);
      IF_SETANIM = new ServerPacket(27, 6);
      IF_SETANGLE = new ServerPacket(28, 10);
      IF_OPENSUB = new ServerPacket(29, 7);//IF_OPENSUB / setinterface
      IF_CLOSESUB = new ServerPacket(30, 4);//sent when closing report interface
      UPDATE_FRIENDLIST = new ServerPacket(31, -2);//private chat? / logged in alerts above chatbox?
      groundItemSpawnPacket = new ServerPacket(32, 2);// dont think this is right, think it updates map dots? -- clears an 8x8 area of ground items
      NPC_INFO_SMALL = new ServerPacket(33, -2);
      field2331 = new ServerPacket(34, 1);
      IF_SETTEXT = new ServerPacket(35, -2);
      IF_SETNPCHEAD = new ServerPacket(36, 6);
      UPDATE_STAT = new ServerPacket(37, 6);
      IF_SETCLICKMASK = new ServerPacket(38, 12);//clickmask / interfacesettings packet
      IF_SETPLAYERHEAD = new ServerPacket(39, 4);
      playerUpdatePacket = new ServerPacket(40, -2);
      staticRegionPacket = new ServerPacket(41, -2);//REBUILD_NORMAL
      MESSAGE_PRIVATE = new ServerPacket(42, -2);
      UPDATE_RUNENERGY = new ServerPacket(43, 1);
      OBJ_COUNT = new ServerPacket(44, 7);
      setVarpLarge = new ServerPacket(45, 6);
      CHAT_FILTER_SETTINGS = new ServerPacket(46, 2);//public chat settings?
      CAM_LOOKAT = new ServerPacket(47, 6);
      cameraPacket = new ServerPacket(48, 6);//heh?
      NPC_INFO_LARGE = new ServerPacket(49, -2);
      UPDATE_INV_STOP_TRANSMIT = new ServerPacket(50, 2);
      LOGOUT_TRANSFER = new ServerPacket(51, -1);
      SET_MAP_FLAG = new ServerPacket(52, 2);
      MAP_PROJANIM = new ServerPacket(53, 15);//projectiles
      field2361 = new ServerPacket(54, 14);
      UPDATE_RUNWEIGHT = new ServerPacket(55, 2);
      SYNTH_SOUND = new ServerPacket(56, 5);
      IF_SETOBJECT = new ServerPacket(57, 10);
      field2338 = new ServerPacket(58, 8);
      performanceMonitoringPacket = new ServerPacket(59, 8);//performance monitoring packet O_o
      LOC_ADD_CHANGE = new ServerPacket(60, 4);
      UPDATE_ZONE_PARTIAL_FOLLOWS = new ServerPacket(61, 2);
      IF_SETMODEL = new ServerPacket(62, 6);
      UPDATE_UID192 = new ServerPacket(63, 28);
      cameraResetPacket = new ServerPacket(64, 0);
      playerOptionsPacket = new ServerPacket(65, -1);
      IF_OPEN_TOP = new ServerPacket(66, 2);//root interface
      IF_SET_POSITION = new ServerPacket(67, 8);
      IF_SET_HIDDEN = new ServerPacket(68, 5);
      UPDATE_FRIENDCHAT_CHANNEL_FULL = new ServerPacket(69, -2);
      field2367 = new ServerPacket(70, 1);
      SOUND_AREA = new ServerPacket(71, 5);
      CHAT_FILTER_SETTINGS_PRIVATECHAT = new ServerPacket(72, 1);
      UPDATE_REBOOT_TIMER = new ServerPacket(73, 2);
      RUNCLIENTSCRIPT = new ServerPacket(74, -2);
      OBJ_ADD = new ServerPacket(75, 5);
      field2373 = new ServerPacket(76, 2);
      field2374 = new ServerPacket(77, 0);
      RESET_CLIENT_VARCACHE = new ServerPacket(78, 0);
      MESSAGE_GAME = new ServerPacket(79, -1);
      MINIMAP_TOGGLE = new ServerPacket(80, 1);
      field2378 = new ServerPacket(81, 5);//runs when entering building mode, some kind of song packet?
      playSongPacket = new ServerPacket(82, 2);//shows when clicking songs
      IF_PREBUILD_TOP_LEVEL = new ServerPacket(83, -2);
   }

   ServerPacket(int var1, int var2) {
      this.packetId = var1;
      this.packetLength = var2;
   }

   public static PacketNode method3433() {
      return PacketNode.field2502 == 0?new PacketNode():PacketNode.packetBufferNodes[--PacketNode.field2502];
   }
}
