package com.oldscape.shared.script.listeners;

import com.oldscape.server.game.model.entity.player.Player;

public interface ObjectListener {

    public Integer[] getPossibleObjects();

    public boolean handle(Player player, int action,  int object, int type, int x, int y);
}
