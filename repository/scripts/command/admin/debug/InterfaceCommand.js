var Integer = Java.type('java.lang.Integer');
var Permission = Java.type('com.oldscape.shared.model.player.Permission');


var CommandListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.CommandListener'), {

    /* The commands to bind to */
    getPossibleSyntaxes: function() {
        return ["interface"];
    },

    /* The first option on an object */
    handle: function(player, syntax, args, clientCommand) {
        var root = Integer.parseInt(args[0]);
        var child = Integer.parseInt(args[1]);
        var interfaceId = Integer.parseInt(args[2]);
        player.sendOpenWidgetSub(root, child, interfaceId, false); //548
        return true;
    },

    //Fixed: 548
    //Resize: 161
    //Resize Panels: 164
    //Game Frame: 165

    getPermission: function() {
        return Permission.ADMINISTRATOR;
    }

});

/* Listen to the commands specified */
var listen = function(scriptManager) {
    var listener = new CommandListener();
    scriptManager.setCommandListener(listener, listener.getPossibleSyntaxes());
};