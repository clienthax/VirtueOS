var NpcId = Java.type('com.oldscape.server.game.model.entity.npc.NpcId');
var WidgetId = Java.type('com.oldscape.server.game.model.widget.WidgetId');

var NpcListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.NpcListener'), {

    getPossibleNpcs: function() {
        return [NpcId.HAIRDRESSER];
    },

    handle: function(player, npcId, option) {
        if(option == 0) {
            /* Talk-to */
            player.sendOpenWidgetSub(162, 550, WidgetId.DIALOG_NPC_GROUP_ID, false);

            player.sendWidgetNpcHead(WidgetId.DIALOG_NPC_GROUP_ID, 0, NpcId.HAIRDRESSER);
            player.sendWidgetAnim(WidgetId.DIALOG_NPC_GROUP_ID, 0, 568);

            player.sendWidgetText(WidgetId.DIALOG_NPC_GROUP_ID, 1, "Hairdresser");
            player.sendWidgetText(WidgetId.DIALOG_NPC_GROUP_ID, 3, "Good afternoon madam. In need of a haircut are we?<br>The service costs 2000 coins.");

            player.sendCS2Script(600, 1, 1, 28, 15138819);
            player.sendWidgetClickMask(WidgetId.DIALOG_NPC_GROUP_ID, 2, -1, -1, 1);
            player.sendWidgetText(WidgetId.DIALOG_NPC_GROUP_ID, 2, "Click here to continue");
            return true;
        }
        if(option == 3) {
            /* Haircut */
            return true;
        }
    }

});

var listen = function(scriptManager) {
    var listener = new NpcListener();
    scriptManager.setNpcListener(listener, listener.getPossibleNpcs());
};