var WidgetId = Java.type('com.oldscape.server.game.model.widget.WidgetId');

var WidgetListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.WidgetListener'), {

    getPossibleWidgets: function() {
        return [WidgetId.STATS_GROUP_ID];
    },

    handle: function(player, widgetHash, childHash, widgetID, widgetChildID, opcode) {
        /* Stat buttons */
        if (childHash >= 1 && childHash <= 23) {
            /* Show Skill guide */
            var tabs = [1, 2, 5, 3, 7, 4, 12, 22, 6, 8, 9, 10, 11, 19, 20, 23, 13, 14, 15, 16, 17, 18, 21];
            player.sendVarbit(4371, tabs[childHash - 1]);
            player.sendVarbit(4372, 0);
            player.sendOpenWidgetSub(548, 21, 214, false);
            player.sendWidgetClickMask(214, 8, 0, 99, 0);
            player.sendCS2Script(917, 4600861, 80);
            return true;
        }
    }
});

/* Listen for the interfaces specified */
var listen = function(scriptManager) {
    var listener = new WidgetListener();
    scriptManager.setWidgetListener(listener, listener.getPossibleWidgets());
};