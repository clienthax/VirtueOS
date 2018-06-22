package com.oldscape.server.game.model.entity.player.skill;

import com.oldscape.server.game.model.entity.player.Player;

import java.util.stream.IntStream;

public final class SynchronizationSkillListener extends SkillAdapter {

    /**
     * The account.
     */
    private final Player player;

    /**
     * Creates the skill synchronization listener.
     *
     * @param player The account.
     */
    public SynchronizationSkillListener(Player player) {
        this.player = player;
    }

    @Override
    public void levelledUp(SkillSet set, int id, Skill skill) {
        if (Skill.isCombatSkill(id)) {
            player.getAppearance();
        }
    }

    @Override
    public void skillsUpdated(SkillSet set) {
        IntStream.range(0, set.size()).forEach(id -> skillUpdated(set, id, set.getSkill(id)));
    }

    @Override
    public void skillUpdated(SkillSet set, int id, Skill skill) {
        //	account.send(new UpdateSkillMessage(id, skill));
    }

}