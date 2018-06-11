package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.model.npc.Npc;
import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.model.Position;
import com.oldscape.shared.network.game.event.impl.AttackNpcEvent;

public class AttackNpcEventListener implements EventListener<AttackNpcEvent, GameSessionContext> {

    @Override
    public void onEvent(AttackNpcEvent event, GameSessionContext context) {
        // TODO Auto-generated method stub
        context.getPlayer().addBlock(SynchronizationBlock.createHitUpdateBlock(1, 1, 1, 99, false));
        Npc npc = context.getServer().getGameWorld().getNpcs().get(event.getNpcIndex() - 1);
        if (npc != null) {
            System.out.println(npc.getPosition().toString());
            context.getPlayer().getWalkingQueue().addStep(new Position((npc.getPosition().getX()), (npc.getPosition().getY()), npc.getPosition().getHeight()));
            context.getPlayer().addBlock(SynchronizationBlock.createInteractingMobBlock(event.getNpcIndex()));
        }
        System.out.println("npc was clicked, index: " + event.getNpcIndex() + ", bool: " + event.isBool());
    }

}
