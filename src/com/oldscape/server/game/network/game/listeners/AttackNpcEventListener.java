package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.model.entity.npc.Npc;
import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.EventListener;
import com.oldscape.server.game.model.map.Position;
import com.oldscape.shared.network.game.event.impl.AttackNpcEvent;

public class AttackNpcEventListener implements EventListener<AttackNpcEvent, GameSessionContext> {

    @Override
    public void onEvent(AttackNpcEvent event, GameSessionContext context) {
        // TODO Auto-generated method stub
        context.getPlayer().addBlock(SynchronizationBlock.createHitUpdateBlock(1, 1, 1, 99, false));
        Npc npc = context.getServer().getGameWorld().getNpcs().get(event.getNpcIndex() - 1);
        if (npc != null) {
            System.out.println(npc.getPosition().toString());
            context.getPlayer().getWalkingQueue().addStep(new Position((npc.getPosition().getX()), (npc.getPosition().getY()), npc.getPosition().getZ()));
            context.getPlayer().addBlock(SynchronizationBlock.createInteractingMobBlock(event.getNpcIndex()));
        }
        System.out.println("ATTACK_NPC_EVENT_LISTENER index: " + event.getNpcIndex() + ", bool: " + event.isBool());
    }

}
