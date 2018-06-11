package com.oldscape.server.game.model.sync.block;

import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.model.sync.reference.Animation;
import com.oldscape.server.game.model.sync.reference.ChatMessage;
import com.oldscape.server.game.model.sync.reference.Direction;
import com.oldscape.server.game.model.sync.reference.Graphic;
import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.shared.model.Position;

/**
 * A synchronization block is part of a {@link SynchronizationSegment}. A
 * segment can have up to one block of each type.
 * <p>
 * This class also has static factory methods for creating
 * {@link SynchronizationBlock}s.
 *
 * @author Graham
 */
public abstract class SynchronizationBlock {

    /**
     * Creates an {@link AnimationBlock} with the specified animation.
     *
     * @param animation The animation.
     * @return The animation block.
     */
    public static SynchronizationBlock createAnimationBlock(Animation animation) {
        return new AnimationBlock(animation);
    }

    /**
     * Creates an {@link AppearanceBlock} for the specified player.
     *
     * @param player The player.
     * @return The appearance block.
     */
    public static SynchronizationBlock createAppearanceBlock(Player player) {
        int combat = 126;// player.getSkillSet().getCombatLevel();
        int id = player.hasNpcType() ? player.getNpcType().getID() : -1;

        return new AppearanceBlock(player.getCredentials().getDisplayName(), player.getAppearance(), combat, 0,
                player.getEquipment(), player.getPrayerIcon(), player.isSkulled(), player.isHidden(), id);
    }

    /**
     * Creates a {@link ChatBlock} for the specified player.
     *
     * @param player      The player.
     * @param chatMessage The chat message.
     * @return The chat block.
     */
    public static SynchronizationBlock createChatBlock(Player player, ChatMessage chatMessage) {
        return new ChatBlock(player.getCredentials().getPermission(), chatMessage);
    }

    /**
     * Creates a {@link ForceChatBlock} with the specified message.
     *
     * @param message The message.
     * @return The force chat block.
     */
    public static SynchronizationBlock createForceChatBlock(String message) {
        return new ForceChatBlock(message);
    }

    /**
     * Creates a {@link ForceMovementBlock} with the specified parameters.
     *
     * @param initialPosition The initial {@link Position} of the player.
     * @param finalPosition   The final position of the player
     * @param travelDurationX The length of time (in game pulses) the player's movement
     *                        along the X axis will last.
     * @param travelDurationY The length of time (in game pulses) the player's movement
     *                        along the Y axis will last.
     * @param direction       The {@link Direction} the player should move.
     * @return The force movement block.
     */
    public static SynchronizationBlock createForceMovementBlock(Position initialPosition, Position finalPosition,
                                                                int travelDurationX, int travelDurationY, Direction direction) {
        return new ForceMovementBlock(initialPosition, finalPosition, travelDurationX, travelDurationY, direction);
    }

    /**
     * Creates a {@link GraphicBlock} with the specified graphic.
     *
     * @param graphic The graphic.
     * @return The graphic block.
     */
    public static SynchronizationBlock createGraphicBlock(Graphic graphic) {
        return new GraphicBlock(graphic);
    }

    /**
     * Creates a {@link HitUpdateBlock} or {@link SecondaryHitUpdateBlock},
     * depending on the value of the {@code secondary} flag.
     *
     * @param damage        The damage dealt by the hit.
     * @param type          The type of hit.
     * @param currentHealth The current health of the mob.
     * @param maximumHealth The maximum health of the mob.
     * @param secondary     If the block is a secondary hit or not.
     * @return The hit update block.
     */
    public static SynchronizationBlock createHitUpdateBlock(int damage, int type, int currentHealth, int maximumHealth,
                                                            boolean secondary) {
        return secondary ? new SecondaryHitUpdateBlock(damage, type, currentHealth, maximumHealth)
                : new HitUpdateBlock(damage, type, currentHealth, maximumHealth);
    }

    /**
     * Creates an {@link InteractingMobBlock} with the specified index.
     *
     * @param index The index of the mob being interacted with.
     * @return The interacting mob block.
     */
    public static SynchronizationBlock createInteractingMobBlock(int index) {
        return new InteractingMobBlock(index);
    }

    /**
     * Creates a {@link TransformBlock} with the specified id.
     *
     * @param id The id.
     * @return The transform block.
     */
    public static SynchronizationBlock createTransformBlock(int id) {
        return new TransformBlock(id);
    }

    /**
     * Creates a {@link OrientationBlock} with the specified {@link Position} .
     *
     * @param position The position.
     * @return The turn to position block.
     */
    public static SynchronizationBlock createTurnToPositionBlock(Position position) {
        return new OrientationBlock(position);
    }

    public static SynchronizationBlock createMovementTypeBlock(boolean running, boolean teleporting) {
        if (teleporting) {
            return new MovementTypeBlock((byte) 127);
        } else {
            return new MovementTypeBlock((byte) (running ? 2 : 1));
        }
    }

    public abstract BlockType getType();

}