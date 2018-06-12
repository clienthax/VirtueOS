var Position = Java.type('com.oldscape.shared.model.Position');
var Permission = Java.type('com.oldscape.shared.model.player.Permission');

var CommandListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.CommandListener'), {

    /* The commands to bind to */
    getPossibleSyntaxes: function() {
        return ["tele", "newpos"];
    },

    /* The first option on an object */
    handle: function(player, syntax, args, clientCommand) {
        var coordX = parseInt(args[0]);
        var coordY = parseInt(args[1]);
        var coordZ = parseInt(args[2]);
        player.teleport(new Position(coordX, coordY, coordZ));
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