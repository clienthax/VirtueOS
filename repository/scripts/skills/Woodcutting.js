 var Animation = Java.type('com.oldscape.server.game.model.sync.reference.Animation');

 var api;
 var WOODCUTTING_SKILL = 8;
 var BACKPACK = 93;

 var Trees = {
     NORMAL: {
         level: 1,
         xp: 25,
         logID: 1511,
         baseTime: 20,
         randomTime: 4,
         stumpID: 1341,
         respawnDelay: 8,
         randomLife: 0
     },
     EVERGREEN: {
         level: 1,
         xp: 25,
         logID: 1511,
         baseTime: 20,
         randomTime: 4,
         stumpID: 57931,
         respawnDelay: 8,
         randomLife: 0
     },
     DEAD: {
         level: 1,
         xp: 25,
         logID: 1511,
         baseTime: 20,
         randomTime: 4,
         stumpID: 12733,
         respawnDelay: 8,
         randomLife: 0
     },
     SWAMP: { //TODO Find the correct ids for this tree
         level: 1,
         xp: 25,
         logID: 1511,
         baseTime: 20,
         randomTime: 4,
         stumpID: 12733,
         respawnDelay: 8,
         randomLife: 0
     },
     ACHEY: {
         level: 1,
         xp: 25,
         logId: 2862,
         baseTime: 20,
         randomTime: 4,
         stumpID: 69555,
         respawnDelay: 8,
         randomLife: 0
     },
     OAK: {
         level: 15,
         xp: 36,
         logID: 1521,
         baseTime: 30,
         randomTime: 4,
         stumpID: 78118,
         respawnDelay: 15,
         randomLife: 15
     },
     WILLOW: {
         level: 30,
         xp: 67.5,
         logID: 1519,
         baseTime: 60,
         randomTime: 4,
         stumpID: 1341,
         respawnDelay: 51,
         randomLife: 15
     },
     MAPLE: {
         level: 45,
         xp: 100,
         logID: 1517,
         baseTime: 83,
         randomTime: 16,
         stumpID: 51843,
         respawnDelay: 72,
         randomLife: 10
     },
     YEW: {
         level: 60,
         xp: 175,
         logID: 1515,
         baseTime: 120,
         randomTime: 17,
         stumpID: 1341,
         respawnDelay: 94,
         randomLife: 10
     },
     MAGIC: {
         level: 75,
         xp: 250,
         logID: 1513,
         baseTime: 150,
         randomTime: 21,
         stumpID: 37824,
         respawnDelay: 121,
         randomLife: 10
     }
 };

 var Hatchet = {
     BRONZE: {
         level: 1,
         time: 1,
         anim: 879, //879
         itemID: 1351
     },
     IRON: {
         level: 1,
         time: 2,
         anim: 877, //877
         itemID: 1349
     },
     STEEL: {
         level: 6,
         time: 3,
         anim: 875, //875
         itemID: 1353
     },
     BLACK: {
         level: 11,
         time: 4,
         anim: 873, //873
         itemID: 1361
     },
     MITHRIL: {
         level: 21,
         time: 5,
         anim: 871, //871
         itemID: 1355
     },
     ADAMANT: {
         level: 31,
         time: 7,
         anim: 869, //869
         itemID: 1357
     },
     RUNE: {
         level: 41,
         time: 10,
         anim: 867, //867
         itemID: 1359
     },
     DRAGON: {
         level: 61,
         time: 13,
         anim: 2846, //2846
         itemID: 6739
     }
 };



 /* Listen to the object ids specified */
 var listen = function(scriptManager) {

     //TODO

 };


 function forTree(name) {
     switch (name) {
         case "Tree":
             return Trees.NORMAL;
         case "Evergreen":
             return Trees.EVERGREEN;
         case "Dead tree":
             return Trees.DEAD;
         case "Swamp tree":
             return Trees.SWAMP;
         case "Oak":
             return Trees.OAK;
         case "Willow":
             return Trees.WILLOW;
         case "Maple":
             return Trees.MAPLE;
         case "Yew":
             return Trees.YEW;
         case "Magic":
             return Trees.MAGIC;
     }
 }

 function forHatchet(player) {
     var hatchet;
     for (ordial in Hatchet) {
         hatchet = Hatchet[ordial]; //TODO: Run this backwards (from best to worst)
         if (api.itemTotal(player, BACKPACK, hatchet.itemID) >= 1) {
             return hatchet;
         }
     }
     return Hatchet.BRONZE;
     return Hatchet.IRON;
     return Hatchet.STEEL;
     return Hatchet.BLACK;
     return Hatchet.MITHRIL;
     return Hatchet.ADAMANT;
     return Hatchet.RUNE;
     return Hatchet.ADZE;
     return Hatchet.DRAGON;
     return Hatcjet.CRYSTAL;
 }