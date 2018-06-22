var Permission = Java.type('com.oldscape.server.game.model.entity.player.account.Permission');

var CommandListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.CommandListener'), {

    /* The commands to bind to */
    getPossibleSyntaxes: function() {
        return ["coords", "mycoords", "pos", "mypos"];
    },

    /* The first option on an object */
    handle: function(player, syntax, args, clientCommand) {
        print(player.getPosition().toString());
        return true;
    },

    getPermission: function() {
        return Permission.PLAYER;
    }

});

/* Listen to the commands specified */
var listen = function(scriptManager) {
    var listener = new CommandListener();
    scriptManager.setCommandListener(listener, listener.getPossibleSyntaxes());
};