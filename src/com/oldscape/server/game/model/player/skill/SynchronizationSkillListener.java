package com.oldscape.server.game.model.player.skill;

import java.util.stream.IntStream;

import com.oldscape.server.game.model.player.Player;

public final class SynchronizationSkillListener extends SkillAdapter {

	/**
	 * The player.
	 */
	private final Player player;

	/**
	 * Creates the skill synchronization listener.
	 *
	 * @param player The player.
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
	//	player.send(new UpdateSkillMessage(id, skill));
	}

}