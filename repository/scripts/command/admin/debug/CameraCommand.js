var Permission = Java.type('com.oldscape.server.game.model.entity.player.account.Permission');

var CommandListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.CommandListener'), {

    /* The commands to bind to */
    getPossibleSyntaxes: function() {
        return ["cam", "campos"];
    },

    /* The first option on an object */
    handle: function(player, syntax, args, clientCommand) {
        var x = Integer.parseInt(args[0]);
        var y = Integer.parseInt(args[1]);
        var z = Integer.parseInt(args[2]);
        var pitch = Integer.parseInt(args[3]);
        var yaw = Integer.parseInt(args[4]);

        // TODO: Below Cs2's for testing Lumby signpost.
        player.sendCS2Script(143, 280, 0); // Set Camera ..?
        player.sendCS2Script(917, 10786175, 200); // Set Varcs: 173 to 10786175 and 172 to 200 ..?

        player.setCameraReposition(x, y, z, pitch, yaw);
        return true;
    },

    getPermission: function() {
        return Permission.ADMINISTRATOR;
    }

});

/* Listen to the commands specified */
var listen = function(scriptManager) {
    var listener = new CommandListener();
    scriptManager.setCommandListener(listener, listener.getPossibleSyntaxes());
};