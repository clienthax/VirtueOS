var ContainerConstants = Java.type('com.oldscape.server.game.model.player.inv.ContainerConstants');
var NpcId = Java.type('com.oldscape.server.game.model.npc.NpcId');

var NpcListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.NpcListener'), {

    getPossibleNpcs: function() {
        return [NpcId.BANKER];
    },

    handle: function(player, npcId, option) {
        if(option == 0) {
            /* Talk-to */
        }

        // Option 1 non-existant

        if(option == 2){
            /* Bank */
            // TODO: This should be handled better / finished off.
            player.sendOpenWidgetSub(548, 21, 12, false);

            player.sendVarp(115, 0);
            player.sendItems(ContainerConstants.BANK_ID, 95, player.getBank().getItems());
            player.sendItems(ContainerConstants.INVENTORY_CHANNEL, 93, player.getInventory().getItems());

            player.sendOpenWidgetSub(161, 66, 15, false);
            player.sendCS2Script(1495, 786487, 786450, "Non-members' capacity: 400<br>+8 for your PIN<br>+8 for your Authenticator");

            player.sendSetWidgetText(12, 18, ContainerConstants.BANK_CAPACITY + "");

            var tabItems = new Array();
            tabItems = player.getBankTabItems();

            var varpOne = 0, varpTwo = 0, varpThree = 0;

            varpOne += tabItems[0];
            varpOne += tabItems[1] << 10;
            varpOne += tabItems[2] << 20;

            varpTwo += tabItems[3];
            varpTwo += tabItems[4] << 10;
            varpTwo += tabItems[5] << 20;
            varpTwo += tabItems[6] << 30;

            varpThree += tabItems[7];
            varpThree += tabItems[8] << 10;
            varpThree += tabItems[9] << 20;

            player.sendVarp(867, varpOne);
            player.sendVarp(867, varpOne);
            player.sendVarp(867, varpOne);

            player.sendVarp(1052, varpTwo);
            player.sendVarp(1052, varpTwo);
            player.sendVarp(1052, varpTwo);

            player.sendVarp(1053, varpThree);
            player.sendVarp(1053, varpThree);
            player.sendVarp(1053, varpThree);

            return true;
        }
        if(option == 3) {
            /* Collect */
        }
    }

});

var listen = function(scriptManager) {
    var listener = new NpcListener();
    scriptManager.setNpcListener(listener, listener.getPossibleNpcs());
};