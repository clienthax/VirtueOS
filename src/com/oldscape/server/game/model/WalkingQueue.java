package com.oldscape.server.game.model;

import com.google.common.base.MoreObjects;
import com.oldscape.server.game.model.entity.player.Player;
import com.oldscape.server.game.model.map.Position;
import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.server.game.model.sync.reference.Direction;
import com.oldscape.server.game.model.map.RegionManager;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * A queue of {@link Direction}s which a {@link MobileEntity} will follow.
 *
 * @author Graham
 */
public final class WalkingQueue {

    /**
     * The maximum size of the queue. If any additional steps are added, they
     * are discarded.
     */
    private static final int MAXIMUM_SIZE = 128;
    /**
     * The mob whose walking queue this is.
     */
    private final MobileEntity mob;
    /**
     * The old queue of directions.
     */
    private final Deque<Point> oldPoints = new ArrayDeque<>();
    /**
     * The queue of directions.
     */
    private final Deque<Point> points = new ArrayDeque<>();
    /**
     * Flag indicating if this queue (only) should be ran.
     */
    private boolean runningQueue = true;

    /**
     * Creates a walking queue for the specified mob.
     *
     * @param mob The mob.
     */
    public WalkingQueue(MobileEntity mob) {
        this.mob = mob;
    }

    /**
     * Adds the first step to the queue, attempting to connect the server and
     * client position by looking at the previous queue.
     *
     * @param clientPosition The first step.
     * @return {@code true} if the queues could be connected correctly,
     * {@code false} if not.
     */
    public boolean addFirstStep(Position clientPosition) {
        Position serverPosition = mob.getPosition();

        int deltaX = clientPosition.getX() - serverPosition.getX();
        int deltaY = clientPosition.getY() - serverPosition.getY();

        if (Direction.isConnectable(deltaX, deltaY)) {
            points.clear();
            oldPoints.clear();

            addStep(clientPosition);
            return true;
        }

        Queue<Position> travelBackQueue = new ArrayDeque<>();

        Point oldPoint;
        while ((oldPoint = oldPoints.pollLast()) != null) {
            Position oldPosition = oldPoint.position;

            deltaX = oldPosition.getX() - serverPosition.getX();
            deltaY = oldPosition.getX() - serverPosition.getY();

            travelBackQueue.add(oldPosition);

            if (Direction.isConnectable(deltaX, deltaY)) {
                points.clear();
                oldPoints.clear();

                for (Position travelBackPosition : travelBackQueue) {
                    addStep(travelBackPosition);
                }

                addStep(clientPosition);
                return true;
            }
        }

        oldPoints.clear();
        return false;
    }

    /**
     * Adds a step.
     *
     * @param x The x coordinate of this step.
     * @param y The y coordinate of this step.
     */
    private void addStep(int x, int y) {
        if (points.size() >= MAXIMUM_SIZE) {
            return;
        }

        Point last = getLast();

        int deltaX = x - last.position.getX();
        int deltaY = y - last.position.getY();

        Direction direction = Direction.fromDeltas(deltaX, deltaY);

        if (direction != Direction.NONE) {
            Point point = new Point(new Position(x, y, mob.getPosition().getZ()), direction);
            points.add(point);
            oldPoints.add(point);
        }
    }

    /**
     * Adds a step to the queue.
     *
     * @param step The step to add.
     */
    public void addStep(Position step) {
        int x = step.getX(), y = step.getY();
        Point last = getLast();

        int deltaX = x - last.position.getX();
        int deltaY = y - last.position.getY();

        int max = Math.max(Math.abs(deltaX), Math.abs(deltaY));

        for (int i = 0; i < max; i++) {
            if (deltaX < 0) {
                deltaX++;
            } else if (deltaX > 0) {
                deltaX--;
            }

            if (deltaY < 0) {
                deltaY++;
            } else if (deltaY > 0) {
                deltaY--;
            }

            addStep(x - deltaX, y - deltaY);
        }
    }

    /**
     * Adds a step to the queue.
     *
     * @param step The step to add.
     */
    public void addStep(Position step, RegionManager manager) {
        int x = step.getX(), y = step.getY();
        Point last = getLast();

        int deltaX = x - last.position.getX();
        int deltaY = y - last.position.getY();

        int max = Math.max(Math.abs(deltaX), Math.abs(deltaY));

        for (int i = 0; i < max; i++) {
            if (deltaX < 0) {
                deltaX++;
            } else if (deltaX > 0) {
                deltaX--;
            }

            if (deltaY < 0) {
                deltaY++;
            } else if (deltaY > 0) {
                deltaY--;
            }

            Position pos = new Position(x - deltaX, y - deltaY, step.getZ());

//            Region map = manager.lookup(pos.getRegionID());
//            System.out.println("Tile: [ " + pos.getX() + ", " + pos.getY() + " ], Blocked: [ " + map.getClipMap().isClipped(step.getZ(), pos.getXInRegion(), pos.getYInRegion(), 1, ClipFlag.FLOOR_BLOCKSWALK) + " ]");

            addStep(pos);
        }
    }

    /**
     * Clears the walking queue.
     */
    public void clear() {
        points.clear();
        oldPoints.clear();
    }

    /**
     * Gets the last point.
     *
     * @return The last point.
     */
    private Point getLast() {
        Point last = points.peekLast();
        if (last == null) {
            return new Point(mob.getPosition(), Direction.NONE);
        }
        return last;
    }

    /**
     * Called every pulse, updates the queue.
     */
    public void pulse() {
        Position position = mob.getPosition();
        Direction first = Direction.NONE, second = Direction.NONE;

        Point next = points.poll();
        if (next != null) {
            first = next.direction;
            position = next.position;

            if (runningQueue /* and enough energy */) {
                next = points.poll();
                if (next != null) {
                    second = next.direction;
                    position = next.position;
                }
            }
            mob.setLastPosition(mob.getPosition().clone());
            mob.setPosition(position);
        }
        mob.setDirections(first, second);

        handleRegionChange();
    }

    public void handleRegionChange() {
        if (!(mob instanceof Player)) {
            return;
        }

        Player player = (Player) mob;

        if (!player.hasLastKnownPosition() || needsRegionUpdate()) {
            player.setRegionChange(true);

            Position position = player.getPosition().clone();

            player.setLastKnownRegion(position);
            player.sendRegionUpdate(position);
        }
    }

    private boolean needsRegionUpdate() {
        if (!(mob instanceof Player)) {
            return false;
        }

        Player player = (Player) mob;

        Position current = player.getPosition();

        if(player.getLastKnownRegion() == null) {
            player.setLastKnownRegion(current);
        }

        Position last = player.getLastKnownRegion();

        int deltaX = current.getLocalX(last);
        int deltaY = current.getLocalY(last);

        return deltaX < 16 || deltaX >= 88 || deltaY < 16 || deltaY >= 88;
    }


    /**
     * Sets the running queue flag.
     */
    public void flipRunningQueue() {
        runningQueue ^= true;

        mob.addBlock(SynchronizationBlock.createMovementTypeBlock(mob.getWalkingQueue().runningQueue(), mob.isTeleporting()));
    }

    public boolean runningQueue() {
        return runningQueue;
    }

    /**
     * Gets the size of the queue.
     *
     * @return The size of the queue.
     */
    public int size() {
        return points.size();
    }

    /**
     * Represents a single point in the queue.
     *
     * @author Graham
     */
    private static final class Point {

        /**
         * The direction to walk to this point.
         */
        private final Direction direction;

        /**
         * The point's position.
         */
        private final Position position;

        /**
         * Creates a point.
         *
         * @param position  The position.
         * @param direction The direction.
         */
        public Point(Position position, Direction direction) {
            this.position = position;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("direction", direction).add("position", position).toString();
        }

    }

}