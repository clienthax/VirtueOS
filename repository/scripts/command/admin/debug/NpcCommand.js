var Integer = Java.type('java.lang.Integer');
var Permission = Java.type('com.oldscape.server.game.model.entity.player.account.Permission');
var Npc = Java.type('com.oldscape.server.game.model.entity.npc.Npc');

var CommandListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.CommandListener'), {

    /* The commands to bind to */
    getPossibleSyntaxes: function() {
        return ["npc"];
    },

    /* The first option on an object */
    handle: function(player, syntax, args, clientCommand) {
        var npcId = Integer.parseInt(args[0]);
        player.getServer().getGameWorld().registerNpc(new Npc(npcId, player.getPosition().getX(), player.getPosition().getY()));
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