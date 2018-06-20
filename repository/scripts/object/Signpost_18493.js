var ObjectId = Java.type('com.oldscape.server.game.model.object.ObjectId');

var ObjectListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.ObjectListener'), {

    getPossibleObjects: function() {
        return [ObjectId.SIGNPOST_18493];
    },

    handle: function(player, actionSlot, object, type, x, y) {
        /* First Click */
        if (actionSlot == 0) {
            player.sendCS2Script(143, 280, 0); // Set Camera ..?
            player.setCameraReposition(48, 42, 2, 1500, 10);

            player.sendSetWidgetText(135, 12, "West to the Lumbridge Castle and Draynor Village. Beware the goblins!")
            player.sendSetWidgetText(135, 9, "South to the swamps of Lumbridge.")
            player.sendSetWidgetText(135, 3, "Head north towards Fred's farm and the windmill.")
            player.sendSetWidgetText(135, 8, "Cross the bridge and head east to Al Kharid or north to Varrock.")

            player.sendOpenWidgetSub(548, 22, 135, false)
            return true;
        }
    }
});

/* Listen for the interfaces specified */
var listen = function(scriptManager) {
    var listener = new ObjectListener();
    scriptManager.setObjectListener(listener, listener.getPossibleObjects());
};