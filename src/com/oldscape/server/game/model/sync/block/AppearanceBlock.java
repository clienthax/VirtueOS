package com.oldscape.server.game.model.sync.block;

import com.oldscape.server.game.model.entity.player.inv.ItemContainer;
import com.oldscape.server.game.model.sync.reference.Appearance;

/**
 * The appearance {@link SynchronizationBlock}. Only players can utilise this
 * block.
 *
 * @author Graham
 */
public final class AppearanceBlock extends SynchronizationBlock {

    /**
     * The account's appearance.
     */
    private final Appearance appearance;

    /**
     * The account's combat level.
     */
    private final int combat;

    /**
     * The account's equipment.
     */
    private final ItemContainer equipment;

    /**
     * Whether or not the account is skulled.
     */
    private final boolean isSkulled;

    /**
     * The account's name.
     */
    private final String name;

    /**
     * The npc id this account is appearing as, if any.
     */
    private final int npcId;

    /**
     * The account's prayer icon.
     */
    private final int headIcon;

    /**
     * The account's total skill level (or 0).
     */
    private final int skill;

    /**
     * A flag if the account is hidden from view
     */
    private final boolean hidden;

    /**
     * Creates the appearance block. Assumes that the account is not appearing as
     * an npc.
     *
     * @param name       The account's username, encoded to base 37.
     * @param appearance The {@link Appearance}.
     * @param combat     The account's combat.
     * @param skill      The account's skill, or 0 if showing the combat level.
     * @param equipment  The account's equipment.
     * @param headIcon   The head icon id of the account.
     * @param isSkulled  Whether or not the account is skulled.
     */
    AppearanceBlock(String name, Appearance appearance, int combat, int skill, ItemContainer equipment, int headIcon,
                    boolean isSkulled) {
        this(name, appearance, combat, skill, equipment, headIcon, isSkulled, false, -1);
    }

    /**
     * Creates the appearance block.
     *
     * @param name       The account's username, encoded to base 37.
     * @param appearance The {@link Appearance}.
     * @param combat     The account's combat.
     * @param skill      The account's skill, or 0 if showing the combat level.
     * @param equipment  The account's equipment.
     * @param headIcon   The prayer icon id of this account.
     * @param isSkulled  Whether or not the account is skulled.
     * @param npcId      The npc id of the account, if they are appearing as an npc,
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
     * If the account is appearing as an npc or not.
     *
     * @return {@code true} if the account is appearing as an npc, otherwise
     * {@code false}.
     */
    public boolean appearingAsNpc() {
        return npcId != -1;
    }

    /**
     * Gets the account's {@link Appearance}.
     *
     * @return The account's appearance.
     */
    public Appearance getAppearance() {
        return appearance;
    }

    /**
     * Gets the account's combat level.
     *
     * @return The account's combat level.
     */
    public int getCombatLevel() {
        return combat;
    }

    /**
     * Gets the account's equipment.
     *
     * @return The account's equipment.
     */
    public ItemContainer getEquipment() {
        return equipment;
    }

    /**
     * Whether or not the account is skulled.
     *
     * @return {@code true} if the account is skulled, otherwise {@code false}.
     */
    public boolean isSkulled() {
        return isSkulled;
    }

    /**
     * Gets the account's name.
     *
     * @return The account's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the npc id the account is appearing as, or {@code -1} if the account
     * is not appearing as one.
     *
     * @return The npc id.
     */
    public int getNpcId() {
        return npcId;
    }

    /**
     * Gets the account's head icon.
     *
     * @return The head icon.
     */
    public int getHeadIcon() {
        return headIcon;
    }

    /**
     * Gets the account's skill level.
     *
     * @return The account's skill level.
     */
    public int getSkillLevel() {
        return skill;
    }

    /**
     * gets the flag if the account is hidden form view
     *
     * @return The account is hidden
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