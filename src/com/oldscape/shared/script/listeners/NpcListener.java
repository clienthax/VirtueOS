package com.oldscape.shared.script.listeners;

import com.oldscape.server.game.model.player.Player;

public interface NpcListener {

    public Integer[] getPossibleNpcs();

    public boolean handle(Player player, int npcId, int option);

}
