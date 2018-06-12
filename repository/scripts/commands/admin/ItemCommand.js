var Integer = Java.type('java.lang.Integer');
var Permission = Java.type('com.oldscape.shared.model.player.Permission');

var CommandListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.CommandListener'), {

    /* The commands to bind to */
    getPossibleSyntaxes: function() {
        return ["item"];
    },

    /* The first option on an object */
    handle: function(player, syntax, args, clientCommand) {
        var itemID = Integer.parseInt(args[0]);
        var itemAmount = 1;
        if (args.length > 1) {
            itemAmount = Integer.parseInt(args[1]);
            itemAmount = itemAmount > Integer.MAX_VALUE ? Integer.MAX_VALUE : itemAmount;
        }
        player.getInventory().add(itemID, itemAmount);
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