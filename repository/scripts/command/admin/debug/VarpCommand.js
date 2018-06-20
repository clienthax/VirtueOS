var Integer = Java.type('java.lang.Integer');
var Permission = Java.type('com.oldscape.shared.model.player.Permission');


var CommandListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.CommandListener'), {

    /* The commands to bind to */
    getPossibleSyntaxes: function() {
        return ["varp"];
    },

    /* The first option on an object */
    handle: function(player, syntax, args, clientCommand) {
        var settingId = Integer.parseInt(args[0]);
        var setting = Integer.parseInt(args[1]);
        player.sendVarp(settingId, setting);
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