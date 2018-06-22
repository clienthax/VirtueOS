package com.oldscape.server.game.model.sync.block;

import com.oldscape.server.game.model.sync.reference.Direction;
import com.oldscape.server.game.model.region.Position;

/**
 * The Force Movement {@link SynchronizationBlock}. Only players can utilise
 * this block.
 * <p>
 * Note: This block is used to force a account to walk to a set location. The
 * account can then perform an action (e.g. an animation), as used in the Agility
 * skill, hence this block earning the name 'Asynchronous Animation/Walking',
 * although the action is not restricted to animations.
 *
 * @author Major
 */
public final class ForceMovementBlock extends SynchronizationBlock {

    /**
     * The direction the account is moving.
     */
    private final Direction direction;

    /**
     * The {@link Position} the account is being moved to.
     */
    private final Position finalPosition;

    /**
     * The initial {@link Position} of the account.
     */
    private final Position initialPosition;

    /**
     * The length of time (in game pulses) the account's movement along the
     * X-axis will last.
     */
    private final int travelDurationX;

    /**
     * The length of time (in game pulses) the account's movement along the
     * Y-axis will last.
     */
    private final int travelDurationY;

    /**
     * Creates a new force movement block.
     *
     * @param initialPosition The initial {@link Position} of the account.
     * @param finalPosition   The final {@link Position} of the account
     * @param travelDurationX The length of time (in game pulses) the account's movement
     *                        along the X-axis will last.
     * @param travelDurationY The length of time (in game pulses) the account's movement
     *                        along the Y-axis will last.
     * @param direction       The direction the account should move.
     */
    ForceMovementBlock(Position initialPosition, Position finalPosition,
                       int travelDurationX, int travelDurationY, Direction direction) {
        this.initialPosition = initialPosition;
        this.finalPosition = finalPosition;
        this.travelDurationX = travelDurationX;
        this.travelDurationY = travelDurationY;
        this.direction = direction;
    }

    /**
     * Gets the {@link Direction} the account should move.
     *
     * @return The direction.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Gets the X coordinate of the final {@link Position}.
     *
     * @return The X coordinate.
     */
    public int getFinalX() {
        return finalPosition.getX();
    }

    /**
     * Gets the Y coordinate of the final {@link Position}.
     *
     * @return The Y coordinate.
     */
    public int getFinalY() {
        return finalPosition.getY();
    }

    /**
     * Gets the X coordinate of the initial {@link Position}.
     *
     * @return The X coordinate.
     */
    public int getInitialX() {
        return initialPosition.getX();
    }

    /**
     * Gets the Y coordinate of the initial {@link Position}.
     *
     * @return The Y coordinate.
     */
    public int getInitialY() {
        return initialPosition.getY();
    }

    /**
     * Gets the length of time (in game pulses) the account's movement along the
     * X-axis will last.
     *
     * @return The time period.
     */
    public int getTravelDurationX() {
        return travelDurationX;
    }

    /**
     * Gets the length of time (in game pulses) the account's movement along the
     * Y-axis will last.
     *
     * @return The time period.
     */
    public int getTravelDurationY() {
        return travelDurationY;
    }

    /* (non-Javadoc)
     * @see com.oldscape.server.game.model.sync.block.SynchronizationBlock#getType()
     */
    @Override
    public BlockType getType() {
        return BlockType.FORCE_MOVEMENT;
    }

}