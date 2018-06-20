var WidgetId = Java.type('com.oldscape.server.game.model.widget.WidgetId');

var WidgetListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.WidgetListener'), {

    getPossibleWidgets: function() {
        return [WidgetId.SKILL_GUIDE];
    },

    handle: function(player, widgetHash, childHash, widgetID, widgetChildID, opcode) {
        /* Switch subcategory */
        player.sendVarbit(4372, (childHash - 11));
        return true;
    }
});

/* Listen for the interfaces specified */
var listen = function(scriptManager) {
    var listener = new WidgetListener();
    scriptManager.setWidgetListener(listener, listener.getPossibleWidgets());
};