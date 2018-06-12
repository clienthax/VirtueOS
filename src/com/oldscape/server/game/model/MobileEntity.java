package com.oldscape.server.game.model;

import com.oldscape.server.game.model.sync.block.InteractingMobBlock;
import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.server.game.model.sync.block.SynchronizationBlockSet;
import com.oldscape.server.game.model.sync.reference.Animation;
import com.oldscape.server.game.model.sync.reference.Direction;
import com.oldscape.server.game.model.sync.reference.Graphic;
import com.oldscape.shared.cache.type.npcs.NpcType;
import com.oldscape.shared.model.Node;
import com.oldscape.shared.model.Position;
import com.oldscape.shared.model.region.Region;

import java.util.Optional;

/**
 * Created by sean on 17/07/14.
 */
public abstract class MobileEntity extends Node {

    /**
     * This mob's walking queue.
     */
    protected final WalkingQueue walkingQueue = new WalkingQueue(this);

    //3250 3423 --varock east
    //3222 3222 --lumby
    protected int X = 3250;
    protected int Y = 3423;

    protected Position position = new Position(X, Y, 0, Position.RegionSize.DEFAULT);

    protected Position lastPosition = new Position(X, Y, 0, Position.RegionSize.DEFAULT);
    /**
     * This mob's set of synchronization blocks.
     */
    protected SynchronizationBlockSet blockSet = new SynchronizationBlockSet();
    /**
     * A flag indicating if the sector changed in the last cycle.
     */
    protected boolean regionChange = false;

    /**
     * The mob this mob is interacting with.
     */
    protected MobileEntity interactingMob;

    /**
     * A flag indicating if the mob is active
     */
    protected boolean active = true;

    /**
     * The position this mob is facing towards.
     */
    protected Position facingPosition = position;

    /**
     * This mob's first movement direction.
     */
    protected Direction firstDirection = Direction.NONE;

    /**
     * This mob's second movement direction.
     */
    protected Direction secondDirection = Direction.NONE;

    /**
     * Indicates whether this mob is currently teleporting or not.
     */
    protected boolean teleporting = false;

    /**
     * This mob's npc definition. A player only uses this if they are appearing
     * as an npc.
     */
    protected Optional<NpcType> npcType = Optional.empty();

    protected Region region;

    protected Position lastKnownRegion = null;

    public Position getLastKnownRegion() {
        return lastKnownRegion;
    }

    public void setLastKnownRegion(Position lastKnownRegion) {
        this.lastKnownRegion = lastKnownRegion;
    }

    /**
     * Gets the entity's current position
     *
     * @return The current position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the entity's current position
     *
     * @param position The position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Gets the entity's last position
     *
     * @return The last position
     */
    public Position getLastPosition() {
        return lastPosition;
    }

    /**
     * Sets the entity's last position
     *
     * @param position The position to set
     */
    public void setLastPosition(Position position) {
        this.lastPosition = position;
    }

    /**
     * Checks if the sector has changed.
     *
     * @return {@code true} if so, {@code false} if not.
     */
    public boolean hasRegionChanged() {
        return regionChange;
    }

    /**
     * Sets the sector changed flag.
     *
     * @param sectorChanged A flag indicating if the sector has changed.
     */
    public void setRegionChange(boolean sectorChanged) {
        this.regionChange = sectorChanged;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     * Gets this mob's {@link WalkingQueue}.
     *
     * @return The walking queue.
     */
    public final WalkingQueue getWalkingQueue() {
        return walkingQueue;
    }

    /*
     * Checks if this player has ever known a sector.
     *
     * @return {@code true} if so, {@code false} if not.
     */
    public boolean hasLastKnownPosition() {
        return lastPosition != null;
    }

    /**
     * Gets this mob's {@link SynchronizationBlockSet}.
     *
     * @return The block set.
     */
    public final SynchronizationBlockSet getBlockSet() {
        return blockSet;
    }

    /**
     * Adds a block to the blockSet
     *
     * @param block The block to add
     */
    public final void addBlock(SynchronizationBlock block) {
        blockSet.add(block);
    }

    /**
     * Makes this mob perform the specified {@link Animation}.
     *
     * @param animation The animation.
     */
    public final void playAnimation(Animation animation) {
        blockSet.add(SynchronizationBlock.createAnimationBlock(animation));
    }

    /**
     * Makes this mob perform the specified {@link Graphic}.
     *
     * @param graphic The graphic.
     */
    public final void playGraphic(Graphic graphic) {
        blockSet.add(SynchronizationBlock.createGraphicBlock(graphic));
    }

    /**
     * Resets this mob's block set.
     */
    public final void resetBlockSet() {
        blockSet = new SynchronizationBlockSet();
    }

    /**
     * Resets the mob this mob is interacting with.
     */
    public final void resetInteractingMob() {
        interactingMob = null;
        blockSet.add(SynchronizationBlock.createInteractingMobBlock(InteractingMobBlock.RESET_INDEX));
    }

    /**
     * Stops this mob's current {@link Animation}.
     */
    public final void stopAnimation() {
        playAnimation(Animation.STOP_ANIMATION);
    }

    /**
     * Stops this mob's current {@link Graphic}.
     */
    public final void stopGraphic() {
        playGraphic(Graphic.STOP_GRAPHIC);
    }

    /**
     * Turns this mob to face the specified {@link Position}.
     *
     * @param position The position to face.
     */
    public final void turnTo(Position position) {
        this.facingPosition = position;
        blockSet.add(SynchronizationBlock.createTurnToPositionBlock(position));
    }

    /**
     * Gets the first {@link Direction}.
     *
     * @return The direction.
     */
    public final Direction getFirstDirection() {
        return firstDirection;
    }

    /**
     * Gets this mob's second movement {@link Direction}.
     *
     * @return The direction.
     */
    public final Direction getSecondDirection() {
        return secondDirection;
    }

    /**
     * Sets the next movement {@link Direction}s for this mob.
     *
     * @param first  The first direction.
     * @param second The second direction.
     */
    public final void setDirections(Direction first, Direction second) {
        firstDirection = first;
        secondDirection = second;
    }

    /**
     * Gets this mob's movement {@link Direction}s, as an array.
     *
     * @return A zero, one or two element array containing the directions (in
     * order).
     */
    public final Direction[] getDirections() {
        if (firstDirection != Direction.NONE) {
            return secondDirection == Direction.NONE ? new Direction[]{firstDirection}
                    : new Direction[]{firstDirection, secondDirection};
        }

        return Direction.EMPTY_DIRECTION_ARRAY;
    }

    /**
     * Gets the {@link Position} this mob is facing towards.
     *
     * @return The position.
     */
    public final Position getFacingPosition() {
        return facingPosition;
    }

    /**
     * Checks if this mob is currently teleporting.
     *
     * @return {@code true} if so, {@code false} if not.
     */
    public final boolean isTeleporting() {
        return teleporting;
    }

    /**
     * Sets whether this mob is teleporting or not.
     *
     * @param teleporting {@code true} if the mob is teleporting, {@code false} if not.
     */
    public final void setTeleporting(boolean teleporting) {
        this.teleporting = teleporting;
    }

    /**
     * Teleports this mob to the specified {@link Position}, setting the
     * appropriate flags and clearing the walking queue.
     *
     * @param position The position.
     */
    public void teleport(Position position) {
        setLastPosition(getPosition());
        setPosition(position);

        walkingQueue.handleRegionChange();

        setTeleporting(true);

        walkingQueue.clear();

        addBlock(SynchronizationBlock.createMovementTypeBlock(getWalkingQueue().runningQueue(), isTeleporting()));

    }

    /**
     * Gets the {@code active} flag.
     *
     * @return The {@code active}.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the {@code active} flag.
     *
     * @param active The {@code active} to be set.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Gets this mob's {@link NpcType}.
     *
     * @return The npc definition.
     */
    public final NpcType getNpcType() {
        return npcType.get();
    }

    /**
     * Returns whether or not this mob has an {@link NpcType}.
     *
     * @return {@code true} if this mob has an npc definition, {@code false} if
     * not.
     */
    public final boolean hasNpcType() {
        return npcType.isPresent();
    }

}
