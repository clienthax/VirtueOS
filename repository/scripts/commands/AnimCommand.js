var Permission = Java.type('com.oldscape.shared.model.player.Permission');
var Animation = Java.type('com.oldscape.server.game.model.sync.reference.Animation');

var CommandListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.CommandListener'), {

    /* The commands to bind to */
    getPossibleSyntaxes: function() {
        return ["anim", "animation"];
    },

    /* The first option on an object */
    handle: function(player, syntax, args, clientCommand) {
        if (args.length < 1) {
            return false;
        }
        var animID = Integer.parseInt(args[0]);
        player.playAnimation(new Animation(animID));
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