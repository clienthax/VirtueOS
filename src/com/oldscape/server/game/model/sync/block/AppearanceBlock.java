package com.oldscape.server.game.model.sync.block;

import com.oldscape.server.game.model.player.inv.ItemContainer;
import com.oldscape.server.game.model.sync.reference.Appearance;

/**
 * The appearance {@link SynchronizationBlock}. Only players can utilise this
 * block.
 *
 * @author Graham
 */
public final class AppearanceBlock extends SynchronizationBlock {

    /**
     * The player's appearance.
     */
    private final Appearance appearance;

    /**
     * The player's combat level.
     */
    private final int combat;

    /**
     * The player's equipment.
     */
    private final ItemContainer equipment;

    /**
     * Whether or not the player is skulled.
     */
    private final boolean isSkulled;

    /**
     * The player's name.
     */
    private final String name;

    /**
     * The npc id this player is appearing as, if any.
     */
    private final int npcId;

    /**
     * The player's prayer icon.
     */
    private final int headIcon;

    /**
     * The player's total skill level (or 0).
     */
    private final int skill;

    /**
     * A flag if the player is hidden from view
     */
    private final boolean hidden;

    /**
     * Creates the appearance block. Assumes that the player is not appearing as
     * an npc.
     *
     * @param name       The player's username, encoded to base 37.
     * @param appearance The {@link Appearance}.
     * @param combat     The player's combat.
     * @param skill      The player's skill, or 0 if showing the combat level.
     * @param equipment  The player's equipment.
     * @param headIcon   The head icon id of the player.
     * @param isSkulled  Whether or not the player is skulled.
     */
    AppearanceBlock(String name, Appearance appearance, int combat, int skill, ItemContainer equipment, int headIcon,
                    boolean isSkulled) {
        this(name, appearance, combat, skill, equipment, headIcon, isSkulled, false, -1);
    }

    /**
     * Creates the appearance block.
     *
     * @param name       The player's username, encoded to base 37.
     * @param appearance The {@link Appearance}.
     * @param combat     The player's combat.
     * @param skill      The player's skill, or 0 if showing the combat level.
     * @param equipment  The player's equipment.
     * @param headIcon   The prayer icon id of this player.
     * @param isSkulled  Whether or not the player is skulled.
     * @param npcId      The npc id of the player, if they are appearing as an npc,
     *                   (otherwise {@code -1}).
     */
    AppearanceBlock(String name, Appearance appearance, int combat, int skill, ItemContainer equipment, int headIcon,
                    boolean isSkulled, boolean hidden, int npcId) {
        this.name = name;
        this.appearance = appearance;
        this.combat = combat;
        this.skill = skill;
        this.equipment = equipment.duplicate();
        this.headIcon = headIcon;
        this.isSkulled = isSkulled;
        this.hidden = hidden;
        this.npcId = npcId;
    }

    /**
     * If the player is appearing as an npc or not.
     *
     * @return {@code true} if the player is appearing as an npc, otherwise
     * {@code false}.
     */
    public boolean appearingAsNpc() {
        return npcId != -1;
    }

    /**
     * Gets the player's {@link Appearance}.
     *
     * @return The player's appearance.
     */
    public Appearance getAppearance() {
        return appearance;
    }

    /**
     * Gets the player's combat level.
     *
     * @return The player's combat level.
     */
    public int getCombatLevel() {
        return combat;
    }

    /**
     * Gets the player's equipment.
     *
     * @return The player's equipment.
     */
    public ItemContainer getEquipment() {
        return equipment;
    }

    /**
     * Whether or not the player is skulled.
     *
     * @return {@code true} if the player is skulled, otherwise {@code false}.
     */
    public boolean isSkulled() {
        return isSkulled;
    }

    /**
     * Gets the player's name.
     *
     * @return The player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the npc id the player is appearing as, or {@code -1} if the player
     * is not appearing as one.
     *
     * @return The npc id.
     */
    public int getNpcId() {
        return npcId;
    }

    /**
     * Gets the player's head icon.
     *
     * @return The head icon.
     */
    public int getHeadIcon() {
        return headIcon;
    }

    /**
     * Gets the player's skill level.
     *
     * @return The player's skill level.
     */
    public int getSkillLevel() {
        return skill;
    }

    /**
     * gets the flag if the player is hidden form view
     *
     * @return The player is hidden
     */
    public boolean isHidden() {
        return hidden;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.oldscape.server.game.model.sync.block.SynchronizationBlock#getType()
     */
    @Override
    public BlockType getType() {
        return BlockType.APPEARANCE;
    }

}