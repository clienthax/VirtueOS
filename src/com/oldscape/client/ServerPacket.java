package com.oldscape.client;

public class ServerPacket {
   public static final ServerPacket LOGOUT;
   public static final ServerPacket LOC_ANIM;
   public static final ServerPacket IF_SET_SCROLL_POS;
   public static final ServerPacket TRIGGER_ON_DIALOG_ABORT;
   public static final ServerPacket FRIEND_LIST_LOADED;
   public static final ServerPacket MESSAGE_PRIVATE_ECHO;
   public static final ServerPacket REFLECTION_CHECKER;
   public static final ServerPacket HINT_ARROW;
   public static final ServerPacket IF_MOVE_SUB;
   public static final ServerPacket IF_SET_COLOUR;
   public static final ServerPacket DYNAMIC_REGION_PACKET;
   public static final ServerPacket UPDATE_INV_PARTIAL;
   public static final ServerPacket CAM_SHAKE;
   public static final ServerPacket UPDATE_INV_FULL;
   public static final ServerPacket SET_VARP_SMALL;
   public static final ServerPacket CLEAR_ANIMATIONS;
   public static final ServerPacket GRAND_EXCHANGE_OFFERS;
   public static final ServerPacket field2314;
   public static final ServerPacket GET_PARAMS;
   public static final ServerPacket GRAND_EXCHANGE_EVENTS;
   public static final ServerPacket UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER;
   public static final ServerPacket field2318;
   public static final ServerPacket MESSAGE_FRIENDCHANNEL;
   public static final ServerPacket OBJ_DEL;
   public static final ServerPacket UPDATE_IGNORE_LIST;
   public static final ServerPacket UPDATE_ZONE_PARTIAL_ENCLOSED;
   public static final ServerPacket LOC_CUSTOMISE;
   public static final ServerPacket IF_SET_ANIM;
   public static final ServerPacket IF_SET_ANGLE;
   public static final ServerPacket IF_OPEN_SUB;
   public static final ServerPacket IF_CLOSE_SUB;
   public static final ServerPacket UPDATE_FRIEND_LIST;
   public static final ServerPacket GROUND_ITEM_SPAWN;
   public static final ServerPacket NPC_INFO_SMALL;
   public static final ServerPacket field2331;
   public static final ServerPacket IF_SET_TEXT;
   public static final ServerPacket IF_SET_NPC_HEAD;
   public static final ServerPacket UPDATE_STAT;
   public static final ServerPacket IF_SET_CLICK_MASK;
   public static final ServerPacket IF_SET_PLAYER_HEAD;
   public static final ServerPacket PLAYER_UPDATE;
   public static final ServerPacket STATIC_REGION;
   public static final ServerPacket MESSAGE_PRIVATE;
   public static final ServerPacket UPDATE_RUN_ENERGY;
   public static final ServerPacket OBJ_COUNT;
   public static final ServerPacket SET_VARP_LARGE;
   public static final ServerPacket CHAT_FILTER_SETTINGS;
   public static final ServerPacket CAM_LOOKAT;
   public static final ServerPacket cameraPacket;//better name?
   public static final ServerPacket NPC_INFO_LARGE;
   public static final ServerPacket UPDATE_INV_STOP_TRANSMIT;
   public static final ServerPacket LOGOUT_TRANSFER;
   public static final ServerPacket SET_MAP_FLAG;
   public static final ServerPacket MAP_PROJANIM;
   public static final ServerPacket field2361;
   public static final ServerPacket UPDATE_RUN_WEIGHT;
   public static final ServerPacket SYNTH_SOUND;
   public static final ServerPacket IF_SET_OBJECT;
   public static final ServerPacket field2338;
   public static final ServerPacket PERFORMANCE_MONITORING;
   public static final ServerPacket LOC_ADD_CHANGE;
   public static final ServerPacket UPDATE_ZONE_PARTIAL_FOLLOWS;
   public static final ServerPacket IF_SET_MODEL;
   public static final ServerPacket UPDATE_UID192;
   public static final ServerPacket CAMERA_RESET;
   public static final ServerPacket PLAYER_OPTIONS;
   public static final ServerPacket IF_OPEN_TOP;
   public static final ServerPacket IF_SET_POSITION;
   public static final ServerPacket IF_SET_HIDDEN;
   public static final ServerPacket UPDATE_FRIENDCHAT_CHANNEL_FULL;
   public static final ServerPacket field2367;
   public static final ServerPacket SOUND_AREA;
   public static final ServerPacket CHAT_FILTER_SETTINGS_PRIVATECHAT;
   public static final ServerPacket UPDATE_REBOOT_TIMER;
   public static final ServerPacket RUN_CLIENT_SCRIPT;
   public static final ServerPacket OBJ_ADD;
   public static final ServerPacket field2373;
   public static final ServerPacket field2374;
   public static final ServerPacket RESET_CLIENT_VARCACHE;
   public static final ServerPacket MESSAGE_GAME;
   public static final ServerPacket MINIMAP_TOGGLE;
   public static final ServerPacket field2378;
   public static final ServerPacket PLAY_SONG;
   public static final ServerPacket IF_PREBUILD_TOP_LEVEL;
   public final int packetId;
   public final int packetLength;

   static {
      LOGOUT = new ServerPacket(0, 0);
      LOC_ANIM = new ServerPacket(1, 6);
      IF_SET_SCROLL_POS = new ServerPacket(2, 6);
      TRIGGER_ON_DIALOG_ABORT = new ServerPacket(3, 0);
      FRIEND_LIST_LOADED = new ServerPacket(4, 0);
      MESSAGE_PRIVATE_ECHO = new ServerPacket(5, -2);
      REFLECTION_CHECKER = new ServerPacket(6, -2);//reflection lookup for anticheat
      HINT_ARROW = new ServerPacket(7, 6);
      IF_MOVE_SUB = new ServerPacket(8, 8);//IF_MOVESUB / setinterfacesets ?
      IF_SET_COLOUR = new ServerPacket(9, 6);
      DYNAMIC_REGION_PACKET = new ServerPacket(10, -2);//REBUILD_REGION
      UPDATE_INV_PARTIAL = new ServerPacket(11, -2);
      CAM_SHAKE = new ServerPacket(12, 4);
      UPDATE_INV_FULL = new ServerPacket(13, -2);
      SET_VARP_SMALL = new ServerPacket(14, 3);
      CLEAR_ANIMATIONS = new ServerPacket(15, 0);
      GRAND_EXCHANGE_OFFERS = new ServerPacket(16, 20);

      field2314 = new ServerPacket(17, 4);
      GET_PARAMS = new ServerPacket(18, -1);
      GRAND_EXCHANGE_EVENTS = new ServerPacket(19, -2);

      UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER = new ServerPacket(20, -1);
      field2318 = new ServerPacket(21, 4);
      MESSAGE_FRIENDCHANNEL = new ServerPacket(22, -1);
      OBJ_DEL = new ServerPacket(23, 3);
      UPDATE_IGNORE_LIST = new ServerPacket(24, -2);
      UPDATE_ZONE_PARTIAL_ENCLOSED = new ServerPacket(25, -2);//for doing multiple objects at once, eg moving projectiles
      LOC_CUSTOMISE = new ServerPacket(26, 4);
      IF_SET_ANIM = new ServerPacket(27, 6);
      IF_SET_ANGLE = new ServerPacket(28, 10);
      IF_OPEN_SUB = new ServerPacket(29, 7);//IF_OPENSUB / setinterface
      IF_CLOSE_SUB = new ServerPacket(30, 4);//sent when closing report interface
      UPDATE_FRIEND_LIST = new ServerPacket(31, -2);//private chat? / logged in alerts above chatbox?
      GROUND_ITEM_SPAWN = new ServerPacket(32, 2);// dont think this is right, think it updates map dots? -- clears an 8x8 area of ground items
      NPC_INFO_SMALL = new ServerPacket(33, -2);
      field2331 = new ServerPacket(34, 1);
      IF_SET_TEXT = new ServerPacket(35, -2);
      IF_SET_NPC_HEAD = new ServerPacket(36, 6);
      UPDATE_STAT = new ServerPacket(37, 6);
      IF_SET_CLICK_MASK = new ServerPacket(38, 12);//clickmask / interfacesettings packet
      IF_SET_PLAYER_HEAD = new ServerPacket(39, 4);
      PLAYER_UPDATE = new ServerPacket(40, -2);
      STATIC_REGION = new ServerPacket(41, -2);//REBUILD_NORMAL
      MESSAGE_PRIVATE = new ServerPacket(42, -2);
      UPDATE_RUN_ENERGY = new ServerPacket(43, 1);
      OBJ_COUNT = new ServerPacket(44, 7);
      SET_VARP_LARGE = new ServerPacket(45, 6);
      CHAT_FILTER_SETTINGS = new ServerPacket(46, 2);//public chat settings?
      CAM_LOOKAT = new ServerPacket(47, 6);
      cameraPacket = new ServerPacket(48, 6);//heh?
      NPC_INFO_LARGE = new ServerPacket(49, -2);
      UPDATE_INV_STOP_TRANSMIT = new ServerPacket(50, 2);
      LOGOUT_TRANSFER = new ServerPacket(51, -1);
      SET_MAP_FLAG = new ServerPacket(52, 2);
      MAP_PROJANIM = new ServerPacket(53, 15);//projectiles
      field2361 = new ServerPacket(54, 14);
      UPDATE_RUN_WEIGHT = new ServerPacket(55, 2);
      SYNTH_SOUND = new ServerPacket(56, 5);
      IF_SET_OBJECT = new ServerPacket(57, 10);
      field2338 = new ServerPacket(58, 8);
      PERFORMANCE_MONITORING = new ServerPacket(59, 8);//performance monitoring packet O_o
      LOC_ADD_CHANGE = new ServerPacket(60, 4);
      UPDATE_ZONE_PARTIAL_FOLLOWS = new ServerPacket(61, 2);
      IF_SET_MODEL = new ServerPacket(62, 6);
      UPDATE_UID192 = new ServerPacket(63, 28);
      CAMERA_RESET = new ServerPacket(64, 0);
      PLAYER_OPTIONS = new ServerPacket(65, -1);
      IF_OPEN_TOP = new ServerPacket(66, 2);//root interface
      IF_SET_POSITION = new ServerPacket(67, 8);
      IF_SET_HIDDEN = new ServerPacket(68, 5);
      UPDATE_FRIENDCHAT_CHANNEL_FULL = new ServerPacket(69, -2);
      field2367 = new ServerPacket(70, 1);
      SOUND_AREA = new ServerPacket(71, 5);
      CHAT_FILTER_SETTINGS_PRIVATECHAT = new ServerPacket(72, 1);
      UPDATE_REBOOT_TIMER = new ServerPacket(73, 2);
      RUN_CLIENT_SCRIPT = new ServerPacket(74, -2);
      OBJ_ADD = new ServerPacket(75, 5);
      field2373 = new ServerPacket(76, 2);
      field2374 = new ServerPacket(77, 0);
      RESET_CLIENT_VARCACHE = new ServerPacket(78, 0);
      MESSAGE_GAME = new ServerPacket(79, -1);
      MINIMAP_TOGGLE = new ServerPacket(80, 1);
      field2378 = new ServerPacket(81, 5);//runs when entering building mode, some kind of song packet?
      PLAY_SONG = new ServerPacket(82, 2);//shows when clicking songs
      IF_PREBUILD_TOP_LEVEL = new ServerPacket(83, -2);
   }

   private ServerPacket(final int packetId, final int length) {
      this.packetId = packetId;
      this.packetLength = length;
   }

   public static PacketNode method3433() {
      return PacketNode.field2502 == 0?new PacketNode():PacketNode.packetBufferNodes[--PacketNode.field2502];
   }
}
