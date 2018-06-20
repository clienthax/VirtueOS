package com.oldscape.server.game.model.widget;

/**
 * Utility class mapping widget IDs to global constants.
 * <p>
 * The constants defined directly under the {@link WidgetId} class are
 * Widget group IDs. All child IDs are defined in sub-classes relating
 * to their group.
 */
public class WidgetId {

    public static final int SKILL_GUIDE = 214;
    public static final int GAMEFRAME_GROUP_ID = 165;
    public static final int SETTINGS_PANEL_GROUP_ID = 261;
    public static final int IGNORE_LIST_GROUP_ID = 432;
    public static final int MAGIC_GROUP_ID = 218;
    public static final int QUEST_GROUP_ID = 399;
    public static final int STATS_GROUP_ID = 320;
    public static final int FAIRY_RING_CODE_GROUP_ID = 381;
    public static final int FAIRY_RING_GROUP_ID = 398;
    public static final int LOGOUT_PANEL_ID = 182;
    public static final int MUSIC_PANEL_ID = 239;
    public static final int ADVANCED_OPTIONS_GROUP_ID = 60;
    public static final int BANK_GROUP_ID = 12;
    public static final int BANK_INVENTORY_GROUP_ID = 15;
    public static final int GRAND_EXCHANGE_INVENTORY_GROUP_ID = 467;
    public static final int DEPOSIT_BOX_GROUP_ID = 192;
    public static final int INVENTORY_GROUP_ID = 149;
    public static final int FRIENDS_LIST_GROUP_ID = 429;
    public static final int RAIDING_PARTY_GROUP_ID = 500;
    public static final int EQUIPMENT_GROUP_ID = 387;
    public static final int EQUIPMENT_INVENTORY_GROUP_ID = 85;
    public static final int EMOTES_GROUP_ID = 216;
    public static final int RUNE_POUCH_GROUP_ID = 190;
    public static final int DIARY_GROUP_ID = 259;
    public static final int PEST_CONTROL_GROUP_ID = 408;
    public static final int CLAN_CHAT_GROUP_ID = 7;
    public static final int MINIMAP_GROUP_ID = 160;
    public static final int LOGIN_CLICK_TO_PLAY_GROUP_ID = 378;
    public static final int CLUE_SCROLL_GROUP_ID = 203;
    public static final int FIXED_VIEWPORT_GROUP_ID = 548;
    public static final int RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX_GROUP_ID = 161;
    public static final int RESIZABLE_VIEWPORT_BOTTOM_LINE_GROUP_ID = 164;
    public static final int PRAYER_GROUP_ID = 541;
    public static final int QUICK_PRAYERS_GROUP_ID = 77;
    public static final int SHOP_GROUP_ID = 300;
    public static final int SHOP_INVENTORY_GROUP_ID = 301;
    public static final int GUIDE_PRICES_GROUP_ID = 464;
    public static final int GUIDE_PRICES_INVENTORY_GROUP_ID = 238;
    public static final int COMBAT_GROUP_ID = 593;
    public static final int DIALOG_NPC_GROUP_ID = 231;
    public static final int SLAYER_REWARDS_GROUP_ID = 426;
    public static final int PRIVATE_CHAT = 163;
    public static final int CHATBOX_GROUP_ID = 162;
    public static final int WORLD_MAP_MENU_GROUP_ID = 160;
    public static final int VOLCANIC_MINE_GROUP_ID = 611;
    public static final int BA_ATTACKER_GROUP_ID = 485;
    public static final int BA_COLLECTOR_GROUP_ID = 486;
    public static final int BA_DEFENDER_GROUP_ID = 487;
    public static final int BA_HEALER_GROUP_ID = 488;
    public static final int LEVEL_UP_GROUP_ID = 233;
    public static final int DIALOG_SPRITE_GROUP_ID = 193;
    public static final int QUEST_COMPLETED_GROUP_ID = 277;
    public static final int CLUE_SCROLL_REWARD_GROUP_ID = 73;
    public static final int BARROWS_REWARD_GROUP_ID = 155;
    public static final int RAIDS_GROUP_ID = 513;
    public static final int MOTHERLODE_MINE_GROUP_ID = 382;
    public static final int EXPERIENCE_DROP_GROUP_ID = 122;
    public static final int PUZZLE_BOX_GROUP_ID = 306;
    public static final int NIGHTMARE_ZONE_GROUP_ID = 202;
    public static final int BLAST_FURNACE_GROUP_ID = 474;
    public static final int WORLD_MAP_GROUP_ID = 595;
    public static final int PYRAMID_PLUNDER_GROUP_ID = 428;
    public static final int RAIDS_REWARD_GROUP_ID = 539;
    public static final int EXPERIENCE_TRACKER_GROUP_ID = 122;
    public static final int TITHE_FARM_GROUP_ID = 241;
    public static final int KINGDOM_GROUP_ID = 392;
    public static final int BARROWS_GROUP_ID = 24;
    public static final int BLAST_MINE_GROUP_ID = 598;

    public static class ClickToPlay {
        public static final int CLICK_TO_PLAY_BUTTON = 75;
    }

    public static class WorldMap {
        public static final int OPTION = 36;
        public static final int TOOLTIP = 35;
        public static final int CLOSE = 34;
        public static final int MAPVIEW = 3;
    }

    public static class SlayerRewards {
        public static final int TOP_BAR = 12;
    }

    public static class DialogNPC {
        public static final int HEAD_MODEL = 0;
        public static final int NAME = 1;
        public static final int CONTINUE = 2;
        public static final int TEXT = 3;
    }

    public static class LogoutPanel {
        public static final int WORLD_SWITCHER_BUTTON = 3;
        public static final int LOGOUT_BUTTON = 8;
    }

    public static class PestControl {
        public static final int PURPLE_SHIELD = 21;
        public static final int BLUE_SHIELD = 23;
        public static final int YELLOW_SHIELD = 25;
        public static final int RED_SHIELD = 27;

        public static final int PURPLE_HEALTH = 17;
        public static final int BLUE_HEALTH = 18;
        public static final int YELLOW_HEALTH = 19;
        public static final int RED_HEALTH = 20;

        public static final int PURPLE_ICON = 13;
        public static final int BLUE_ICON = 14;
        public static final int YELLOW_ICON = 15;
        public static final int RED_ICON = 16;

        public static final int ACTIVITY_BAR = 6;
        public static final int ACTIVITY_PROGRESS = 8;
    }

    public static class ClanChat {
        public static final int TITLE = 1;
        public static final int NAME = 3;
        public static final int OWNER = 5;
    }

    public static class Bank {
        public static final int ITEM_CONTAINER = 23;
        public static final int INVENTORY_ITEM_CONTAINER = 3;
        public static final int BANK_TITLE_BAR = 15;
        public static final int BANK_ITEM_COUNT = 16;
    }

    public static class GrandExchange {
        public static final int INVENTORY_ITEM_CONTAINER = 0;
    }

    public static class DepositBox {
        public static final int INVENTORY_ITEM_CONTAINER = 2;
    }

    public static class Shop {
        public static final int ITEMS_CONTAINER = 2;
        public static final int INVENTORY_ITEM_CONTAINER = 0;
    }

    public static class GuidePrices {
        public static final int ITEM_CONTAINER = 2;
        public static final int INVENTORY_ITEM_CONTAINER = 0;
    }

    public static class Equipment {
        public static final int HELMET = 6;
        public static final int CAPE = 7;
        public static final int AMULET = 8;
        public static final int WEAPON = 9;
        public static final int BODY = 10;
        public static final int SHIELD = 11;
        public static final int LEGS = 12;
        public static final int GLOVES = 13;
        public static final int BOOTS = 14;
        public static final int RING = 15;
        public static final int AMMO = 16;
        public static final int INVENTORY_ITEM_CONTAINER = 0;
    }

    public static class Emotes {
        public static final int EMOTE_WINDOW = 0;
        public static final int EMOTE_CONTAINER = 1;
    }

    public static class Cluescroll {
        public static final int CLUE_TEXT = 2;
    }

    public static class Minimap {
        public static final int XP_ORB = 1;
        public static final int HEALTH_ORB = 2;
        public static final int PRAYER_ORB = 12;
        public static final int QUICK_PRAYER_ORB = 14;
        public static final int RUN_ORB = 20;
        public static final int SPEC_ORB = 28;
    }

    public static class Viewport {
        public static final int MINIMAP_WIDGET = 17;
        public static final int FIXED_VIEWPORT = 17;
        public static final int RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX = 12;
        public static final int RESIZABLE_VIEWPORT_BOTTOM_LINE = 12;
    }

    public static class FixedViewport {
        public static final int GAME_VIEWPORT = 22;

        public static final int CLAN_CHAT_TAB = 31;
        public static final int FRIENDS_TAB = 32;
        public static final int IGNORES_TAB = 33;
        public static final int LOGOUT_TAB = 34;
        public static final int OPTIONS_TAB = 35;
        public static final int EMOTES_TAB = 36;
        public static final int MUSIC_TAB = 37;
        public static final int CLAN_CHAT_ICON = 38;
        public static final int FRIENDS_ICON = 39;
        public static final int IGNORES_ICON = 40;
        public static final int LOGOUT_ICON = 41;
        public static final int OPTIONS_ICON = 42;
        public static final int EMOTES_ICON = 43;
        public static final int MUSIC_ICON = 44;
        public static final int COMBAT_TAB = 48;
        public static final int STATS_TAB = 49;
        public static final int QUESTS_TAB = 50;
        public static final int INVENTORY_TAB = 51;
        public static final int EQUIPMENT_TAB = 52;
        public static final int PRAYER_TAB = 53;
        public static final int MAGIC_TAB = 54;
        public static final int COMBAT_ICON = 55;
        public static final int STATS_ICON = 56;
        public static final int QUESTS_ICON = 57;
        public static final int INVENTORY_ICON = 58;
        public static final int EQUIPMENT_ICON = 59;
        public static final int PRAYER_ICON = 60;
        public static final int MAGIC_ICON = 61;
        public static final int ROOT_INTERFACE_CONTAINER = 62;
        public static final int BANK_CONTAINER = 64;
        public static final int INTERFACE_CONTAINER = 65;
    }

    public static class ResizableViewport {
        public static final int CLAN_CHAT_TAB = 35;
        public static final int FRIENDS_TAB = 36;
        public static final int IGNORES_TAB = 37;
        public static final int LOGOUT_TAB = 38;
        public static final int OPTIONS_TAB = 39;
        public static final int EMOTES_TAB = 40;
        public static final int MUSIC_TAB = 41;
        public static final int CLAN_CHAT_ICON = 42;
        public static final int FRIENDS_ICON = 43;
        public static final int IGNORES_ICON = 44;
        public static final int LOGOUT_ICON = 45;
        public static final int OPTIONS_ICON = 46;
        public static final int EMOTES_ICON = 47;
        public static final int MUSIC_ICON = 48;
        public static final int COMBAT_TAB = 51;
        public static final int STATS_TAB = 52;
        public static final int QUESTS_TAB = 53;
        public static final int INVENTORY_TAB = 54;
        public static final int EQUIPMENT_TAB = 55;
        public static final int PRAYER_TAB = 56;
        public static final int MAGIC_TAB = 57;
        public static final int COMBAT_ICON = 58;
        public static final int STATS_ICON = 59;
        public static final int QUESTS_ICON = 60;
        public static final int INVENTORY_ICON = 61;
        public static final int EQUIPMENT_ICON = 62;
        public static final int PRAYER_ICON = 63;
        public static final int MAGIC_ICON = 64;
    }

    public static class ResizableViewportBottomLine {
        public static final int LOGOUT_BUTTON_OVERLAY = 29;
        public static final int INVENTORY_TAB = 51;
        public static final int PRAYER_TAB = 53;
        public static final int QUESTS_ICON = 57;
        public static final int INVENTORY_ICON = 58;
        public static final int PRAYER_ICON = 60;
    }

    public static class Chatbox {
        public static final int CHATBOX_MESSAGES = 30;
        public static final int CHATBOX_REPORT_TEXT = 29;
        public static final int CHATBOX_FRAME = 1;
        public static final int CHATBOX_BUTTONS = 2;
    }

    public static class Prayer {
        public static final int THICK_SKIN = 4;
        public static final int BURST_OF_STRENGTH = 5;
        public static final int CLARITY_OF_THOUGHT = 6;
        public static final int SHARP_EYE = 22;
        public static final int MYSTIC_WILL = 23;
        public static final int ROCK_SKIN = 7;
        public static final int SUPERHUMAN_STRENGTH = 8;
        public static final int IMPROVED_REFLEXES = 9;
        public static final int RAPID_RESTORE = 10;
        public static final int RAPID_HEAL = 11;
        public static final int PROTECT_ITEM = 12;
        public static final int HAWK_EYE = 24;
        public static final int MYSTIC_LORE = 25;
        public static final int STEEL_SKIN = 13;
        public static final int ULTIMATE_STRENGTH = 14;
        public static final int INCREDIBLE_REFLEXES = 15;
        public static final int PROTECT_FROM_MAGIC = 16;
        public static final int PROTECT_FROM_MISSILES = 17;
        public static final int PROTECT_FROM_MELEE = 18;
        public static final int EAGLE_EYE = 26;
        public static final int MYSTIC_MIGHT = 27;
        public static final int RETRIBUTION = 19;
        public static final int REDEMPTION = 20;
        public static final int SMITE = 21;
        public static final int PRESERVE = 32;
        public static final int CHIVALRY = 28;
        public static final int PIETY = 29;
        public static final int RIGOUR = 30;
        public static final int AUGURY = 31;
    }

    public static class QuickPrayer {
        public static final int THICK_SKIN_CHILD_ID = 0;
        public static final int BURST_OF_STRENGTH_CHILD_ID = 1;
        public static final int CLARITY_OF_THOUGHT_CHILD_ID = 2;
        public static final int SHARP_EYE_CHILD_ID = 18;
        public static final int MYSTIC_WILL_CHILD_ID = 19;
        public static final int ROCK_SKIN_CHILD_ID = 3;
        public static final int SUPERHUMAN_STRENGTH_CHILD_ID = 4;
        public static final int IMPROVED_REFLEXES_CHILD_ID = 5;
        public static final int RAPID_RESTORE_CHILD_ID = 6;
        public static final int RAPID_HEAL_CHILD_ID = 7;
        public static final int PROTECT_ITEM_CHILD_ID = 8;
        public static final int HAWK_EYE_CHILD_ID = 20;
        public static final int MYSTIC_LORE_CHILD_ID = 21;
        public static final int STEEL_SKIN_CHILD_ID = 9;
        public static final int ULTIMATE_STRENGTH_CHILD_ID = 10;
        public static final int INCREDIBLE_REFLEXES_CHILD_ID = 11;
        public static final int PROTECT_FROM_MAGIC_CHILD_ID = 12;
        public static final int PROTECT_FROM_MISSILES_CHILD_ID = 13;
        public static final int PROTECT_FROM_MELEE_CHILD_ID = 14;
        public static final int EAGLE_EYE_CHILD_ID = 22;
        public static final int MYSTIC_MIGHT_CHILD_ID = 23;
        public static final int RETRIBUTION_CHILD_ID = 15;
        public static final int REDEMPTION_CHILD_ID = 16;
        public static final int SMITE_CHILD_ID = 17;
        public static final int PRESERVE_CHILD_ID = 28;
        public static final int CHIVALRY_CHILD_ID = 25;
        public static final int PIETY_CHILD_ID = 26;
        public static final int RIGOUR_CHILD_ID = 24;
        public static final int AUGURY_CHILD_ID = 27;
        public static final int PRAYERS = 4;
    }

    public static class Combat {
        public static final int WEAPON_NAME = 1;
        public static final int LEVEL = 2;
        public static final int STYLE_ONE = 3;
        public static final int STYLE_TWO = 7;
        public static final int STYLE_THREE = 11;
        public static final int STYLE_FOUR = 15;
        public static final int SPELLS = 19;
        public static final int DEFENSIVE_SPELL_BOX = 20;
        public static final int DEFENSIVE_SPELL_ICON = 21;
        public static final int DEFENSIVE_SPELL_SHIELD = 22;
        public static final int DEFENSIVE_SPELL_TEXT = 23;
        public static final int SPELL_BOX = 24;
        public static final int SPELL_ICON = 25;
        public static final int SPELL_TEXT = 26;
    }

    public static class VolcanicMine {
        public static final int GENERAL_INFOBOX_GROUP_ID = 4;
        public static final int TIME_LEFT = 8;
        public static final int POINTS = 10;
        public static final int STABILITY = 12;
        public static final int PLAYER_COUNT = 14;
        public static final int VENTS_INFOBOX_GROUP_ID = 15;
        public static final int VENT_A_PERCENTAGE = 19;
        public static final int VENT_B_PERCENTAGE = 20;
        public static final int VENT_C_PERCENTAGE = 21;
        public static final int VENT_A_STATUS = 23;
        public static final int VENT_B_STATUS = 24;
        public static final int VENT_C_STATUS = 25;
    }

    public static class BarbarianAssault {
        public static final int CURRENT_WAVE = 1;
        public static final int CORRECT_STYLE = 3;
        public static final int TO_CALL = 5;
        public static final int ROLE_SPRITE = 6;
        public static final int ROLE = 7;

        public static class ATK {
            public static final int CORRECT_STYLE2 = 4;
            public static final int TO_CALL = 6;
            public static final int ROLE = 8;
            public static final int ROLE_SPRITE = 7;
        }
    }

    public static class LevelUp {
        public static final int SKILL = 0;
        public static final int LEVEL = 1;
    }

    public static class QuestCompleted {
        public static final int NAME_TEXT = 2;
    }

    public static class Raids {
        public static final int POINTS_INFOBOX = 3;
    }

    public static class ExperienceDrop {
        public static final int DROP_1 = 15;
        public static final int DROP_2 = 16;
        public static final int DROP_3 = 17;
        public static final int DROP_4 = 18;
        public static final int DROP_5 = 19;
        public static final int DROP_6 = 20;
        public static final int DROP_7 = 21;
    }

    public static class PuzzleBox {
        public static final int VISIBLE_BOX = 4;
    }

    public static class DialogSprite {
        public static final int SPRITE = 0;
        public static final int TEXT = 1;
    }

    public static class ExperienceTracker {
        public static final int WIDGET = 1;
        public static final int BOTTOM_BAR = 14;
    }

    public static class FairyRing {
        public static final int LEFT_ORB_CLOCKWISE = 19;
        public static final int LEFT_ORB_COUNTER_CLOCKWISE = 20;
        public static final int MIDDLE_ORB_CLOCKWISE = 21;
        public static final int MIDDLE_ORB_COUNTER_CLOCKWISE = 22;
        public static final int RIGHT_ORB_CLOCKWISE = 23;
        public static final int RIGHT_ORB_COUNTER_CLOCKWISE = 24;
        public static final int TELEPORT_BUTTON = 26;
    }

    public static class FairyRingCode {
        public static final int FAIRY_QUEEN_HIDEOUT = 139;
    }

    public static class Barrows {
        public static final int BARROWS_BROTHERS = 8;
        public static final int BARROWS_POTENTIAL = 9;
        public static final int BARROWS_REWARD_INVENTORY = 3;
    }

    public static class EmotePanel{
        public static final int YES = 0;
        public static final int NO = 1;
        public static final int BOW = 2;
        public static final int ANGRY = 3;
        public static final int THINK = 4;
        public static final int WAVE = 5;
        public static final int SHRUG = 6;
        public static final int CHEER = 7;
        public static final int BECKON = 8;
        public static final int LAUGH = 9;
        public static final int JUMP = 10;
        public static final int YAWN = 11;
        public static final int DANCE = 12;
        public static final int JIG = 13;
        public static final int SPIN = 14;
        public static final int HEAD_BANG = 15;
        public static final int CRY = 16;
        public static final int BLOW_KISS = 17;
        public static final int PANIC = 18;
        public static final int RASPBERRY = 19;
        public static final int CLAP = 20;
        public static final int SALUTE = 21;
        //TODO: Emotes 22 > 47
    }
}