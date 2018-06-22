package com.oldscape.server.game.model.region.clip;

import com.oldscape.server.game.model.region.Direction;
import com.oldscape.server.game.model.region.Position;

public class Collision {

    public static boolean wall(Position start, Position end, int endPos, int endDir) {
        Clipping clipping = new Clipping(start.getRegionID());

        int currentX = start.getX();
        int currentY = start.getY();
        int currentZ = start.getZ();

        int goalX = end.getX();
        int goalY = end.getY();

        if (currentX == goalX && currentY == goalY) {
            return true;
        }
        if (endPos == 0) {
            if (endDir == Direction.SOUTH) {
                if (currentX == goalX - 1 && currentY == goalY) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY + 1
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280120) == 0) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY - 1
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280102) == 0) {
                    return true;
                }
            } else if (endDir == Direction.WEST) {
                if (currentX == goalX && currentY == goalY + 1) {
                    return true;
                }
                if (currentX == goalX - 1 && currentY == goalY
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280108) == 0) {
                    return true;
                }
                if (currentX == goalX + 1 && currentY == goalY
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280180) == 0) {
                    return true;
                }
            } else if (endDir == Direction.NORTH) {
                if (currentX == goalX + 1 && currentY == goalY) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY + 1
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280120) == 0) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY - 1
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280102) == 0) {
                    return true;
                }
            } else if (endDir == Direction.EAST) {
                if (currentX == goalX && currentY == goalY - 1) {
                    return true;
                }
                if (currentX == goalX - 1 && currentY == goalY
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280108) == 0) {
                    return true;
                }
                if (currentX == goalX + 1 && currentY == goalY
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280180) == 0) {
                    return true;
                }
            }
        }
        if (endPos == 2) {
            if (endDir == Direction.SOUTH) {
                if (currentX == goalX - 1 && currentY == goalY) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY + 1) {
                    return true;
                }
                if (currentX == goalX + 1 && currentY == goalY
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280180) == 0) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY - 1
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280102) == 0) {
                    return true;
                }
            } else if (endDir == Direction.WEST) {
                if (currentX == goalX - 1 && currentY == goalY
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280108) == 0) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY + 1) {
                    return true;
                }
                if (currentX == goalX + 1 && currentY == goalY) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY - 1
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280102) == 0) {
                    return true;
                }
            } else if (endDir == Direction.NORTH) {
                if (currentX == goalX - 1 && currentY == goalY
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280108) == 0) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY + 1
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280120) == 0) {
                    return true;
                }
                if (currentX == goalX + 1 && currentY == goalY) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY - 1) {
                    return true;
                }
            } else if (endDir == Direction.EAST) {
                if (currentX == goalX - 1 && currentY == goalY) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY + 1
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280120) == 0) {
                    return true;
                }
                if (currentX == goalX + 1 && currentY == goalY
                        && (clipping.getClip(currentX, currentY, currentZ) & 0x1280180) == 0) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY - 1) {
                    return true;
                }
            }
        }
        if (endPos == 9) {
            if (currentX == goalX && currentY == goalY + 1
                    && (clipping.getClip(currentX, currentY, currentZ) & CollisionDataFlag.BLOCK_MOVEMENT_SOUTH) == 0) {
                return true;
            }
            if (currentX == goalX && currentY == goalY - 1
                    && (clipping.getClip(currentX, currentY, currentZ) & CollisionDataFlag.BLOCK_MOVEMENT_NORTH) == 0) {
                return true;
            }
            if (currentX == goalX - 1 && currentY == goalY
                    && (clipping.getClip(currentX, currentY, currentZ) & CollisionDataFlag.BLOCK_MOVEMENT_EAST) == 0) {
                return true;
            }
            if (currentX == goalX + 1 && currentY == goalY
                    && (clipping.getClip(currentX, currentY, currentZ) & CollisionDataFlag.BLOCK_MOVEMENT_WEST) == 0) {
                return true;
            }
        }
        return false;
    }


    public static boolean decoration(Position start, Position end, int endPos, int endDir) {
        Clipping clipping = new Clipping(start.getRegionID());

        int currentX = start.getX();
        int currentY = start.getY();
        int currentZ = start.getZ();

        int goalX = end.getX();
        int goalY = end.getY();

        if (currentX == goalX && currentY == goalY) {
            return true;
        }
        if (endPos == 6 || endPos == 7) {
            if (endPos == 7) {
                endDir = endDir + Direction.NORTH & Direction.EAST;
            }
            if (endDir == Direction.SOUTH) {
                if (currentX == goalX + 1 && currentY == goalY
                        && (clipping.getClip(currentX, currentY, currentZ)
                        & CollisionDataFlag.BLOCK_MOVEMENT_WEST) == 0) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY - 1
                        && (clipping.getClip(currentX, currentY, currentZ)
                        & CollisionDataFlag.BLOCK_MOVEMENT_NORTH) == 0) {
                    return true;
                }
            } else if (endDir == Direction.WEST) {
                if (currentX == goalX - 1 && currentY == goalY
                        && (clipping.getClip(currentX, currentY, currentZ)
                        & CollisionDataFlag.BLOCK_MOVEMENT_EAST) == 0) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY - 1
                        && (clipping.getClip(currentX, currentY, currentZ)
                        & CollisionDataFlag.BLOCK_MOVEMENT_NORTH) == 0) {
                    return true;
                }
            } else if (endDir == Direction.NORTH) {
                if (currentX == goalX - 1 && currentY == goalY
                        && (clipping.getClip(currentX, currentY, currentZ)
                        & CollisionDataFlag.BLOCK_MOVEMENT_EAST) == 0) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY + 1
                        && (clipping.getClip(currentX, currentY, currentZ)
                        & CollisionDataFlag.BLOCK_MOVEMENT_SOUTH) == 0) {
                    return true;
                }
            } else if (endDir == Direction.EAST) {
                if (currentX == goalX + 1 && currentY == goalY
                        && (clipping.getClip(currentX, currentY, currentZ)
                        & CollisionDataFlag.BLOCK_MOVEMENT_WEST) == 0) {
                    return true;
                }
                if (currentX == goalX && currentY == goalY + 1
                        && (clipping.getClip(currentX, currentY, currentZ)
                        & CollisionDataFlag.BLOCK_MOVEMENT_SOUTH) == 0) {
                    return true;
                }
            }
        }
        if (endPos == 8) {
            if (currentX == goalX && currentY == goalY + 1
                    && (clipping.getClip(currentX, currentY, currentZ)
                    & CollisionDataFlag.BLOCK_MOVEMENT_SOUTH) == 0) {
                return true;
            }
            if (currentX == goalX && currentY == goalY - 1
                    && (clipping.getClip(currentX, currentY, currentZ)
                    & CollisionDataFlag.BLOCK_MOVEMENT_NORTH) == 0) {
                return true;
            }
            if (currentX == goalX - 1 && currentY == goalY
                    && (clipping.getClip(currentX, currentY, currentZ)
                    & CollisionDataFlag.BLOCK_MOVEMENT_EAST) == 0) {
                return true;
            }
            if (currentX == goalX + 1 && currentY == goalY
                    && (clipping.getClip(currentX, currentY, currentZ)
                    & CollisionDataFlag.BLOCK_MOVEMENT_WEST) == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean object(Position start, Position end, int endDeltaX, int endDeltaY, int surrounding) {
        Clipping clipping = new Clipping(start.getRegionID());

        int currentX = start.getX();
        int currentY = start.getY();
        int currentZ = start.getZ();

        int goalX = end.getX();
        int goalY = end.getY();

        int goalX2 = (goalX + endDeltaX) - 1;
        int goalY2 = (goalY + endDeltaY) - 1;

        if (currentX >= goalX && currentX <= goalX2 && currentY >= goalY && currentY <= goalY2) {
            return true;
        }
        if (currentX == goalX - 1 && currentY >= goalY
                && currentY <= goalY2 && (clipping.getClip(currentX, currentY, currentZ)
                & CollisionDataFlag.BLOCK_MOVEMENT_EAST) == 0 && (surrounding & 8) == 0) {
            return true;
        }
        if (currentX == goalX2 + 1 && currentY >= goalY
                && currentY <= goalY2 && (clipping.getClip(currentX, currentY, currentZ)
                & CollisionDataFlag.BLOCK_MOVEMENT_WEST) == 0 && (surrounding & 2) == 0) {
            return true;
        }
        if (currentY == goalY - 1 && currentX >= goalX
                && currentX <= goalX2 && (clipping.getClip(currentX, currentY, currentZ)
                & CollisionDataFlag.BLOCK_MOVEMENT_NORTH) == 0 && (surrounding & 4) == 0) {
            return true;
        }
        return currentY == goalY2 + 1 && currentX >= goalX
                && currentX <= goalX2 && (clipping.getClip(currentX, currentY, currentZ)
                & CollisionDataFlag.BLOCK_MOVEMENT_SOUTH) == 0 && (surrounding & 1) == 0;
    }

}
