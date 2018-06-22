var Permission = Java.type('com.oldscape.server.game.model.entity.player.account.Permission');

var CommandListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.CommandListener'), {

    /* The commands to bind to */
    getPossibleSyntaxes: function() {
        return ["openbank", "bank"];
    },

    /* The first option on an object */
    handle: function(player, syntax, args, clientCommand) {
        player.sendOpenInterfaceSub(164, 3, 12, false);
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