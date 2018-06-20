var ContainerConstants = Java.type('com.oldscape.server.game.model.player.inv.ContainerConstants');
var NpcId = Java.type('com.oldscape.server.game.model.npc.NpcId');

var NpcListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.NpcListener'), {

    getPossibleNpcs: function() {
        return [NpcId.HAIRDRESSER];
    },

    handle: function(player, npcId, option) {
        if(option == 0) {
            /* Talk-to */
            return true;
        }
        if(option == 2){
            /* Bank */
            return true;
        }
        if(option == 3) {
            /* Collect */
            return true;
        }
    }

});

var listen = function(scriptManager) {
    var listener = new NpcListener();
    scriptManager.setNpcListener(listener, listener.getPossibleNpcs());
};