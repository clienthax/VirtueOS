package com.oldscape.server.game.model.map.movement.path.pathfinder;

import com.oldscape.server.game.model.CompassPoint;
import com.oldscape.server.game.model.map.Position;
import com.oldscape.server.game.model.map.movement.path.Path;
import com.oldscape.server.game.model.map.movement.path.Point;
import static com.oldscape.server.game.model.map.clip.ClipFlag.*;

import java.util.ArrayList;
import java.util.List;

public final class DumbPathfinder extends AbstractPathfinder {

    /**
     * If a path can be found.
     */
    private boolean found;

    /**
     * The plane.
     */
    private int z;

    /**
     * The x-coordinate.
     */
    private int x;

    /**
     * The y-coordinate.
     */
    private int y;

    /**
     * Constructs a new {@code DumbPathfinder} {@code Object}.
     */
    public DumbPathfinder() {
        super();
    }

    @Override
    public Path find(Position start, int size, Position end, int sizeX, int sizeY, int rotation, int type, int surroundings, boolean near) {
        Path path = new Path();
        z = start.getZ();
        x = start.getX();
        y = start.getY();
        List<Point> points = new ArrayList<>();
        path.setSuccesful(true);
        while (x != end.getX() || y != end.getY()) {
            CompassPoint[] directions = getDirection(x, y, end);
            if (type != 0) {
                if ((type < 5 || type == 10) && canDoorInteract(x, y, size, end.getX(), end.getY(), type - 1, rotation, z)) {
                    break;
                }
                if (type < 10 && canDecorationInteract(x, y, size, end.getX(), end.getY(), type - 1, rotation, z)) {
                    break;
                }
            }
            if (sizeX != 0 && sizeY != 0) {
                if (canInteract(x, y, size, end.getX(), end.getY(), sizeX, sizeY, surroundings, z)) {
                    break;
                }
                if (directions.length > 1) { // Ensures we approach the location
                    // correctly (non-diagonal).
                    CompassPoint dir = directions[0];
                    if (x + dir.getDeltaX() == end.getX() && y + dir.getDeltaY() == end.getY()) {
                        directions[0] = directions[directions.length - 1];
                        directions[directions.length - 1] = dir;
                    }
                }
            }
            found = true;
            if (size < 2) {
                checkSingleTraversal(points, directions);
            } else if (size == 2) {
                checkDoubleTraversal(points, directions);
            } else {
                checkVariableTraversal(points, directions, size);
            }
            if (!found) {
                path.setMoveNear(x != start.getX() || y != start.getY());
                path.setSuccesful(false);
                break;
            }
        }
        if (!points.isEmpty()) {
            Point last = null;
            for (int i = 0; i < points.size() - 1; i++) {
                Point p = points.get(i);
                if (!p.equals(last)) {
                    path.getPoints().add(p);
                    last = p;
                }
            }
            path.getPoints().add(points.get(points.size() - 1));
        }
        return path;
    }

    /**
     * Checks traversal for a size 1 entity.
     * @param points The points list.
     * @param directions The directions.
     */
    private void checkSingleTraversal(List<Point> points, CompassPoint... directions) {
        for (CompassPoint dir : directions) {
            found = true;
            switch (dir) {
                case NORTH:
                    if ((getClippingFlag(z, x, y + 1) & TRAVERSABLE_NORTH) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x, y + 1));
                    y++;
                    break;
                case NORTHEAST:
                    if ((getClippingFlag(z, x + 1, y) & TRAVERSABLE_EAST) != 0 || (getClippingFlag(z, x, y + 1) & TRAVERSABLE_NORTH) != 0 || (getClippingFlag(z, x + 1, y + 1) & TRAVERSABLE_NORTHWEST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x + 1, y + 1));
                    x++;
                    y++;
                    break;
                case EAST:
                    if ((getClippingFlag(z, x + 1, y) & TRAVERSABLE_EAST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x + 1, y));
                    x++;
                    break;
                case SOUTHEAST:
                    if ((getClippingFlag(z, x + 1, y) & TRAVERSABLE_EAST) != 0 || (getClippingFlag(z, x, y - 1) & TRAVERSABLE_SOUTH) != 0 || (getClippingFlag(z, x + 1, y - 1) & TRAVERSABLE_SOUTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x + 1, y - 1));
                    x++;
                    y--;
                    break;
                case SOUTH:
                    if ((getClippingFlag(z, x, y - 1) & TRAVERSABLE_SOUTH) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x, y - 1));
                    y--;
                    break;
                case SOUTHWEST:
                    if ((getClippingFlag(z, x - 1, y) & TRAVERSABLE_WEST) != 0 || (getClippingFlag(z, x, y - 1) & TRAVERSABLE_SOUTH) != 0 || (getClippingFlag(z, x - 1, y - 1) & TRAVERSABLE_SOUTHWEST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x - 1, y - 1));
                    x--;
                    y--;
                    break;
                case WEST:
                    if ((getClippingFlag(z, x - 1, y) & TRAVERSABLE_WEST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x - 1, y));
                    x--;
                    break;
                case NORTHWEST:
                    if ((getClippingFlag(z, x - 1, y) & TRAVERSABLE_WEST) != 0 || (getClippingFlag(z, x, y + 1) & TRAVERSABLE_NORTH) != 0 || (getClippingFlag(z, x - 1, y + 1) & TRAVERSABLE_NORTHWEST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x - 1, y + 1));
                    x--;
                    y++;
                    break;
            }
            if (found) {
                break;
            }
        }
    }

    /**
     * Checks traversal for a size 1 entity.
     * @param points The points list.
     * @param directions The directions.
     */
    private void checkDoubleTraversal(List<Point> points, CompassPoint... directions) {
        for (CompassPoint dir : directions) {
            found = true;
            switch (dir) {
                case NORTH:
                    if ((getClippingFlag(z, x, y + 2) & TRAVERSABLE_NORTHWEST) != 0 || (getClippingFlag(z, x + 1, y + 2) & TRAVERSABLE_NORTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x, y + 1));
                    y++;
                    break;
                case NORTHEAST:
                    if ((getClippingFlag(z, x + 1, y + 2) & TRAVERSABLE_NORTHWEST) != 0 || (getClippingFlag(z, x + 2, y + 2) & TRAVERSABLE_NORTHEAST) != 0 || (getClippingFlag(z, x + 2, y + 1) & TRAVERSABLE_SOUTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x + 1, y + 1));
                    x++;
                    y++;
                    break;
                case EAST:
                    if ((getClippingFlag(z, x + 2, y) & TRAVERSABLE_SOUTHEAST) != 0 || (getClippingFlag(z, x + 2, y + 1) & TRAVERSABLE_NORTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x + 1, y));
                    x++;
                    break;
                case SOUTHEAST:
                    if ((getClippingFlag(z, x + 1, y - 1) & TRAVERSABLE_SOUTHWEST) != 0 || (getClippingFlag(z, x + 2, y) & TRAVERSABLE_NORTHEAST) != 0 || (getClippingFlag(z, x + 2, y - 1) & TRAVERSABLE_SOUTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x + 1, y - 1));
                    x++;
                    y--;
                    break;
                case SOUTH:
                    if ((getClippingFlag(z, x, y - 1) & TRAVERSABLE_SOUTHWEST) != 0 || (getClippingFlag(z, x + 1, y - 1) & TRAVERSABLE_SOUTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x, y - 1));
                    y--;
                    break;
                case SOUTHWEST:
                    if ((getClippingFlag(z, x - 1, y - 1) & TRAVERSABLE_SOUTHWEST) != 0 || (getClippingFlag(z, x - 1, y) & TRAVERSABLE_NORTHWEST) != 0 || (getClippingFlag(z, x, y - 1) & TRAVERSABLE_SOUTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x - 1, y - 1));
                    x--;
                    y--;
                    break;
                case WEST:
                    if ((getClippingFlag(z, x - 1, y) & TRAVERSABLE_SOUTHWEST) != 0 || (getClippingFlag(z, x - 1, y + 1) & TRAVERSABLE_NORTHWEST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x - 1, y));
                    x--;
                    break;
                case NORTHWEST:
                    if ((getClippingFlag(z, x - 1, y + 1) & TRAVERSABLE_SOUTHWEST) != 0 || (getClippingFlag(z, x - 1, y + 2) & TRAVERSABLE_NORTHWEST) != 0 || (getClippingFlag(z, x, y + 2) & TRAVERSABLE_NORTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    points.add(new Point(x - 1, y + 1));
                    x--;
                    y++;
                    break;
            }
            if (found) {
                break;
            }
        }
    }

    /**
     * Checks traversal for variable size entities.
     * @param points The points list.
     * @param directions The directions to check.
     * @param size The mover size.
     */
    private void checkVariableTraversal(List<Point> points, CompassPoint[] directions, int size) {
        for (CompassPoint dir : directions) {
            found = true;
            roar: switch (dir) {
                case NORTH:
                    if ((getClippingFlag(z, x, y + size) & TRAVERSABLE_NORTHWEST) != 0 || (getClippingFlag(z, x + (size - 1), y + size) & TRAVERSABLE_NORTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    for (int i = 1; i < size - 1; i++) {
                        if ((getClippingFlag(z, x + i, y + size) & TRAVERSABLE_NORTH_VARIABLE) != 0) {
                            found = false;
                            break roar;
                        }
                    }
                    points.add(new Point(x, y + 1));
                    y++;
                    break;
                case NORTHEAST:
                    if ((getClippingFlag(z, x + 1, y + size) & TRAVERSABLE_NORTHWEST) != 0 || (getClippingFlag(z, x + size, y + size) & TRAVERSABLE_NORTHEAST) != 0 || (getClippingFlag(z, x + size, y + 1) & TRAVERSABLE_SOUTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    for (int i = 1; i < size - 1; i++) {
                        if ((getClippingFlag(z, x + (i + 1), y + size) & TRAVERSABLE_NORTH_VARIABLE) != 0 || (getClippingFlag(z, x + size, y + (i + 1)) & TRAVERSABLE_EAST_VARIABLE) != 0) {
                            found = false;
                            break roar;
                        }
                    }
                    points.add(new Point(x + 1, y + 1));
                    x++;
                    y++;
                    break;
                case EAST:
                    if ((getClippingFlag(z, x + size, y) & TRAVERSABLE_NORTHEAST) != 0 || (getClippingFlag(z, x + size, y + (size - 1)) & TRAVERSABLE_SOUTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    for (int i = 1; i < size - 1; i++) {
                        if ((getClippingFlag(z, x + size, y + i) & TRAVERSABLE_EAST_VARIABLE) != 0) {
                            found = false;
                            break roar;
                        }
                    }
                    points.add(new Point(x + 1, y));
                    x++;
                    break;
                case SOUTHEAST:
                    if ((getClippingFlag(z, x + 1, y - 1) & TRAVERSABLE_SOUTHWEST) != 0 || (getClippingFlag(z, x + size, y + (size - 2)) & TRAVERSABLE_NORTHEAST) != 0 || (getClippingFlag(z, x + size, y - 1) & TRAVERSABLE_SOUTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    for (int i = 1; i < size - 1; i++) {
                        if ((getClippingFlag(z, x + size, y + (i - 1)) & TRAVERSABLE_EAST_VARIABLE) != 0 || (getClippingFlag(z, x + (i + 1), y - 1) & TRAVERSABLE_SOUTH_VARIABLE) != 0) {
                            found = false;
                            break roar;
                        }
                    }
                    points.add(new Point(x + 1, y - 1));
                    x++;
                    y--;
                    break;
                case SOUTH:
                    if ((getClippingFlag(z, x, y - 1) & TRAVERSABLE_SOUTHEAST) != 0 || (getClippingFlag(z, x + (size - 1), y - 1) & TRAVERSABLE_NORTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    for (int i = 1; i < size - 1; i++) {
                        if ((getClippingFlag(z, x + i, y - 1) & TRAVERSABLE_SOUTH_VARIABLE) != 0) {
                            found = false;
                            break roar;
                        }
                    }
                    points.add(new Point(x, y - 1));
                    y--;
                    break;
                case SOUTHWEST:
                    if ((getClippingFlag(z, x - 1, y + (size - 2)) & TRAVERSABLE_NORTHWEST) != 0 || (getClippingFlag(z, x - 1, y - 1) & TRAVERSABLE_SOUTHWEST) != 0 || (getClippingFlag(z, x + (size - 2), y - 1) & TRAVERSABLE_SOUTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    for (int i = 1; i < size - 1; i++) {
                        if ((getClippingFlag(z, x - 1, y + (i - 1)) & TRAVERSABLE_WEST_VARIABLE) != 0 || (getClippingFlag(z, x + (i - 1), y - 1) & TRAVERSABLE_SOUTH_VARIABLE) != 0) {
                            found = false;
                            break roar;
                        }
                    }
                    points.add(new Point(x - 1, y - 1));
                    x--;
                    y--;
                    break;
                case WEST:
                    if ((getClippingFlag(z, x - 1, y) & TRAVERSABLE_SOUTHWEST) != 0 || (getClippingFlag(z, x - 1, y + (size - 1)) & TRAVERSABLE_NORTHWEST) != 0) {
                        found = false;
                        break;
                    }
                    for (int i = 1; i < size - 1; i++) {
                        if ((getClippingFlag(z, x - 1, y + i) & TRAVERSABLE_WEST_VARIABLE) != 0) {
                            found = false;
                            break roar;
                        }
                    }
                    points.add(new Point(x - 1, y));
                    x--;
                    break;
                case NORTHWEST:
                    if ((getClippingFlag(z, x - 1, y + 1) & TRAVERSABLE_SOUTHWEST) != 0 || (getClippingFlag(z, x - 1, y + size) & TRAVERSABLE_NORTHWEST) != 0 || (getClippingFlag(z, x, y + size) & TRAVERSABLE_NORTHEAST) != 0) {
                        found = false;
                        break;
                    }
                    for (int i = 1; i < size - 1; i++) {
                        if ((getClippingFlag(z, x - 1, y + (i + 1)) & TRAVERSABLE_WEST_VARIABLE) != 0 || (getClippingFlag(z, x + (i - 1), y + size) & TRAVERSABLE_NORTH_VARIABLE) != 0) {
                            found = false;
                            break roar;
                        }
                    }
                    points.add(new Point(x - 1, y + 1));
                    x--;
                    y++;
                    break;
            }
            if (found) {
                break;
            }
        }
    }

    /**
     * Gets the direction.
     */
    private static CompassPoint[] getDirection(int startX, int startY, Position end) {
        int endX = end.getX();
        int endY = end.getY();
        if (startX == endX) {
            if (startY > endY) {
                return new CompassPoint[] { CompassPoint.SOUTH };
            } else if (startY < endY) {
                return new CompassPoint[] { CompassPoint.NORTH };
            }
        } else if (startY == endY) {
            if (startX > endX) {
                return new CompassPoint[] { CompassPoint.WEST };
            }
            return new CompassPoint[] { CompassPoint.EAST };
        } else {
            if (startX < endX && startY < endY) {
                return new CompassPoint[] { CompassPoint.NORTHEAST, CompassPoint.EAST, CompassPoint.NORTH };
            } else if (startX < endX && startY > endY) {
                return new CompassPoint[] { CompassPoint.SOUTHEAST, CompassPoint.EAST, CompassPoint.SOUTH };
            } else if (startX > endX && startY < endY) {
                return new CompassPoint[] { CompassPoint.NORTHWEST, CompassPoint.WEST, CompassPoint.NORTH };
            } else if (startX > endX && startY > endY) {
                return new CompassPoint[] { CompassPoint.SOUTHWEST, CompassPoint.WEST, CompassPoint.SOUTH };
            }
        }
        return new CompassPoint[0];
    }

}