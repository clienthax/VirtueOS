package com.oldscape.server.game.model.region.clip;

import com.oldscape.server.game.model.entity.object.DynamicObject;
import com.oldscape.server.game.model.entity.object.ObjectTypes;
import com.oldscape.server.game.model.region.Direction;
import com.oldscape.shared.cache.type.TypeListManager;
import com.oldscape.shared.cache.type.objects.ObjectType;

public class Clipping {

    public static Clipping[] regions;
    public int[][][] clipping = new int[4][][];
    public int region;

    public Clipping(int region) {
        this.region = region;
    }

    public void add(int object, int x, int y, int z, int type, int dir) {
        ObjectType obj = TypeListManager.lookupObject(object);

        if (obj == null) {
            return;
        }

        int xLen, yLen;
        if (dir != Direction.WEST && dir != Direction.EAST) {
            xLen = obj.getSizeX();
            yLen = obj.getSizeY();
        } else {
            xLen = obj.getSizeY();
            yLen = obj.getSizeX();
        }

        if (type == ObjectTypes.GROUND_DECORATION) {
            if (obj.isInteractive() && obj.isSolid()) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_FLOOR);
            }
        } else if (type >= ObjectTypes.WALL_DIAGONAL) {
            if (obj.isSolid()) {
                addClippingSolid(x, y, z, xLen, yLen, obj.isWalkable());
            }
        } else if (type == ObjectTypes.WALL
                || type == ObjectTypes.WALL_DIAGONAL_CORNER
                || type == ObjectTypes.WALL_CORNER
                || type == ObjectTypes.WALL_CORNER_CONNECTING) {
            if (obj.isSolid()) {
                addClippingVariable(x, y, z, type, dir, obj.isWalkable());
            }
        }

    }

    public void remove(DynamicObject object) {
        if (object != null) {
            int x = object.getPosition().getX();
            int y = object.getPosition().getY();
            int z = object.getPosition().getZ();
            int type = object.getType();

            ObjectType obj = object.getObjectType();

            int xLength;
            int yLength;
            if (object.getDirection() != 1 && object.getDirection() != 3) {
                xLength = obj.getSizeX();
                yLength = obj.getSizeY();
            } else {
                xLength = obj.getSizeY();
                yLength = obj.getSizeX();
            }

            if (type == ObjectTypes.GROUND_DECORATION) {
                if (obj.isInteractive() && obj.isSolid()) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_FLOOR);
                }
            } else if (type >= ObjectTypes.WALL_DIAGONAL) {
                if (obj.isSolid()) {
                    removeClippingSolid(x, y, z, xLength, yLength, obj.isWalkable());
                }
            } else if (type == ObjectTypes.WALL
                    || type == ObjectTypes.WALL_DIAGONAL_CORNER
                    || type == ObjectTypes.WALL_CORNER
                    || type == ObjectTypes.WALL_CORNER_CONNECTING) {
                if (obj.isSolid()) {
                    removeClippingVariable(x, y, z, object.getType(), object.getDirection(), obj.isWalkable());
                }
            }

        }
    }

    public void addClipping(int x, int y, int z, int flag) {
        int rX = x >> 3;
        int rY = y >> 3;
        int rId = ((rX / 8) << 8) + (rY / 8);

        for (Clipping region : regions) {
            if (region.getRegion() == rId) {
                region.addClip(x, y, z, flag);
                break;
            }
        }

    }

    private void removeClipping(int x, int y, int z, int flag) {
        int rX = x >> 3;
        int rY = y >> 3;
        int rId = ((rX / 8) << 8) + (rY / 8);

        for (Clipping region : regions) {
            if (region.getRegion() == rId) {
                region.removeClip(x, y, z, flag);
                break;
            }
        }

    }

    private void addClippingSolid(int x, int y, int z, int xLen, int yLen, boolean canWalk) {
        int clipping = CollisionDataFlag.BLOCK_MOVEMENT_OBJECT;
        if (canWalk) {
            clipping += CollisionDataFlag.BLOCK_LINE_OF_SIGHT_FULL;
        }
        for (int toX = x; toX < x + xLen; toX++) {
            for (int toY = y; toY < y + yLen; toY++) {
                addClipping(toX, toY, z, clipping);
            }
        }
    }

    private void removeClippingSolid(int x, int y, int z, int xLen, int yLen, boolean canWalk) {
        int clipping = CollisionDataFlag.BLOCK_MOVEMENT_OBJECT;
        if (canWalk) {
            clipping |= CollisionDataFlag.BLOCK_LINE_OF_SIGHT_FULL;
        }
        for (int fromX = x; fromX < x + xLen; fromX++) {
            for (int fromY = y; fromY < y + yLen; fromY++) {
                removeClipping(fromX, fromY, z, clipping);
            }
        }
    }

    private void addClippingVariable(int x, int y, int z, int type, int direction, boolean canWalk) {
        if (type == ObjectTypes.WALL) {
            if (direction == Direction.SOUTH) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_WEST);
                addClipping(x - 1, y, z, CollisionDataFlag.BLOCK_MOVEMENT_EAST);
            } else if (direction == Direction.WEST) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH);
                addClipping(x, y + 1, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH);
            } else if (direction == Direction.NORTH) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_EAST);
                addClipping(x + 1, y, z, CollisionDataFlag.BLOCK_MOVEMENT_WEST);
            } else if (direction == Direction.EAST) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH);
                addClipping(x, y - 1, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH);
            }
        } else if (type == ObjectTypes.WALL_DIAGONAL_CORNER || type == ObjectTypes.WALL_CORNER_CONNECTING) {
            if (direction == Direction.SOUTH) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH_WEST);
                addClipping(x - 1, y, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_EAST);
            } else if (direction == Direction.WEST) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH_EAST);
                addClipping(x + 1, y + 1, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_WEST);
            } else if (direction == Direction.NORTH) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_EAST);
                addClipping(x + 1, y - 1, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH_WEST);
            } else if (direction == Direction.EAST) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_WEST);
                addClipping(x - 1, y - 1, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH_EAST);
            }
        } else if (type == ObjectTypes.WALL_CORNER) {
            if (direction == Direction.SOUTH) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_WEST | CollisionDataFlag.BLOCK_MOVEMENT_NORTH);
                addClipping(x - 1, y, z, CollisionDataFlag.BLOCK_MOVEMENT_EAST);
                addClipping(x, y + 1, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH);
            } else if (direction == Direction.WEST) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH | CollisionDataFlag.BLOCK_MOVEMENT_EAST);
                addClipping(x, y + 1, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH);
                addClipping(x + 1, y, z, CollisionDataFlag.BLOCK_MOVEMENT_WEST);
            } else if (direction == Direction.NORTH) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH | CollisionDataFlag.BLOCK_MOVEMENT_EAST);
                addClipping(x + 1, y, z, CollisionDataFlag.BLOCK_MOVEMENT_WEST);
                addClipping(x, y - 1, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH);
            } else if (direction == Direction.EAST) {
                addClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_WEST | CollisionDataFlag.BLOCK_MOVEMENT_SOUTH);
                addClipping(x, y - 1, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH);
                addClipping(x - 1, y, z, CollisionDataFlag.BLOCK_MOVEMENT_EAST);
            }
        }
        if (canWalk) {
            if (type == ObjectTypes.WALL) {
                if (direction == Direction.SOUTH) {
                    addClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                    addClipping(x - 1, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                } else if (direction == Direction.WEST) {
                    addClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH);
                    addClipping(x, y + 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH);
                } else if (direction == Direction.NORTH) {
                    addClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                    addClipping(x + 1, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                } else if (direction == Direction.EAST) {
                    addClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH);
                    addClipping(x, y - 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH);
                }
            }
            if (type == ObjectTypes.WALL_DIAGONAL_CORNER || type == ObjectTypes.WALL_CORNER_CONNECTING) {
                if (direction == Direction.SOUTH) {
                    addClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH_WEST);
                    addClipping(x - 1, y + 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH_EAST);
                } else if (direction == Direction.WEST) {
                    addClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH_EAST);
                    addClipping(x + 1, y + 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH_WEST);
                } else if (direction == Direction.NORTH) {
                    addClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH_EAST);
                    addClipping(x + 1, y + 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH_WEST);
                } else if (direction == Direction.EAST) {
                    addClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH_WEST);
                    addClipping(x - 1, y - 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH_EAST);
                }
            } else if (type == ObjectTypes.WALL_CORNER) {
                if (direction == Direction.SOUTH) {
                    addClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH | CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                    addClipping(x - 1, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                    addClipping(x, y + 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH);
                } else if (direction == Direction.WEST) {
                    addClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH | CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                    addClipping(x, y + 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH);
                    addClipping(x + 1, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                } else if (direction == Direction.NORTH) {
                    addClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH | CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                    addClipping(x + 1, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                    addClipping(x, y - 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH);
                } else if (direction == Direction.EAST) {
                    addClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH | CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                    addClipping(x, y - 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH);
                    addClipping(x - 1, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                }
            }
        }
    }

    private void removeClippingVariable(int x, int y, int z, int type, int direction, boolean canWalk) {
        if (type == ObjectTypes.WALL) {
            if (direction == Direction.SOUTH) {
                removeClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_WEST);
                removeClipping(x - 1, y, z, CollisionDataFlag.BLOCK_MOVEMENT_EAST);
            }
            if (direction == Direction.WEST) {
                removeClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH);
                removeClipping(x, 1 + y, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH);
            }
            if (direction == Direction.NORTH) {
                removeClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_EAST);
                removeClipping(1 + x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_WEST);
            }
            if (direction == Direction.EAST) {
                removeClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH);
                removeClipping(x, y - 1, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH);
            }
        }
        if (type == ObjectTypes.WALL_DIAGONAL_CORNER || type == ObjectTypes.WALL_CORNER_CONNECTING) {
            if (direction == Direction.SOUTH) {
                removeClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH_WEST);
                removeClipping(x - 1, 1 + y, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_EAST);
            }
            if (direction == Direction.WEST) {
                removeClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH_EAST);
                removeClipping(1 + x, y + 1, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_WEST);
            }
            if (direction == Direction.NORTH) {
                removeClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_EAST);
                removeClipping(x + 1, -1 + y, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH_WEST);
            }
            if (direction == Direction.EAST) {
                removeClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_WEST);
                removeClipping(-1 + x, -1 + y, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH_EAST);
            }
        }
        if (type == ObjectTypes.WALL_CORNER) {
            if (direction == Direction.SOUTH) {
                removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH | CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                removeClipping(x - 1, y, z, CollisionDataFlag.BLOCK_MOVEMENT_EAST);
                removeClipping(x, 1 + y, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH);
            }
            if (direction == Direction.WEST) {
                removeClipping(x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH | CollisionDataFlag.BLOCK_MOVEMENT_EAST);
                removeClipping(x, 1 + y, z, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH);
                removeClipping(1 + x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_WEST);
            }
            if (direction == Direction.NORTH) {
                removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH | CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                removeClipping(x + 1, y, z, CollisionDataFlag.BLOCK_MOVEMENT_WEST);
                removeClipping(x, -1 + y, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH);
            }
            if (direction == Direction.EAST) {
                removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH | CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                removeClipping(x, y - 1, z, CollisionDataFlag.BLOCK_MOVEMENT_NORTH);
                removeClipping(-1 + x, y, z, CollisionDataFlag.BLOCK_MOVEMENT_EAST);
            }
        }
        if (canWalk) {
            if (type == ObjectTypes.WALL) {
                if (direction == Direction.SOUTH) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                    removeClipping(-1 + x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                }
                if (direction == Direction.WEST) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH);
                    removeClipping(x, 1 + y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH);
                }
                if (direction == Direction.NORTH) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                    removeClipping(x + 1, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                }
                if (direction == Direction.EAST) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH);
                    removeClipping(x, y - 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH);
                }
            }
            if (type == ObjectTypes.WALL_DIAGONAL_CORNER || type == ObjectTypes.WALL_CORNER_CONNECTING) {
                if (direction == Direction.SOUTH) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH_WEST);
                    removeClipping(x - 1, y + 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH_EAST);
                } else if (direction == Direction.WEST) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH_EAST);
                    removeClipping(x + 1, y + 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH_WEST);
                } else if (direction == Direction.NORTH) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH_EAST);
                    removeClipping(x + 1, y + 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH_WEST);
                } else if (direction == Direction.EAST) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH_WEST);
                    removeClipping(x - 1, y - 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH_EAST);
                }
            } else if (type == ObjectTypes.WALL_CORNER) {
                if (direction == Direction.SOUTH) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH | CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                    removeClipping(x - 1, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                    removeClipping(x, y + 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH);
                } else if (direction == Direction.WEST) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH | CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                    removeClipping(x, y + 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH);
                    removeClipping(x + 1, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                } else if (direction == Direction.NORTH) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH | CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                    removeClipping(x + 1, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST);
                    removeClipping(x, y - 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH);
                } else if (direction == Direction.EAST) {
                    removeClipping(x, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH | CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                    removeClipping(x, y - 1, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH);
                    removeClipping(x - 1, y, z, CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST);
                }
            }
        }
    }

    public boolean getClipping(int x, int y, int z, int moveTypeX, int moveTypeY) {
        if (z > 3)
            z = 0;
        int checkX = (x + moveTypeX);
        int checkY = (y + moveTypeY);
        if (moveTypeX == -1 && moveTypeY == 0) {
            return (getClip(x, y, z) & 0x1280108) == 0;
        } else if (moveTypeX == 1 && moveTypeY == 0) {
            return (getClip(x, y, z) & 0x1280180) == 0;
        } else if (moveTypeX == 0 && moveTypeY == -1) {
            return (getClip(x, y, z) & 0x1280102) == 0;
        } else if (moveTypeX == 0 && moveTypeY == 1) {
            return (getClip(x, y, z) & 0x1280120) == 0;
        } else if (moveTypeX == -1 && moveTypeY == -1) {
            return ((getClip(x, y, z) & 0x128010e) == 0
                    && (getClip(checkX - 1, checkY, z) & 0x1280108) == 0
                    && (getClip(checkX - 1, checkY, z) & 0x1280102) == 0);
        } else if (moveTypeX == 1 && moveTypeY == -1) {
            return ((getClip(x, y, z) & 0x1280183) == 0
                    && (getClip(checkX + 1, checkY, z) & 0x1280180) == 0
                    && (getClip(checkX, checkY - 1, z) & 0x1280102) == 0);
        } else if (moveTypeX == -1 && moveTypeY == 1) {
            return ((getClip(x, y, z) & 0x1280138) == 0
                    && (getClip(checkX - 1, checkY, z) & 0x1280108) == 0
                    && (getClip(checkX, checkY + 1, z) & 0x1280120) == 0);
        } else if (moveTypeX == 1 && moveTypeY == 1) {
            return ((getClip(x, y, z) & 0x12801e0) == 0
                    && (getClip(checkX + 1, checkY, z) & 0x1280180) == 0
                    && (getClip(checkX, checkY + 1, z) & 0x1280120) == 0);
        } else {
            return false;
        }
    }

    public void addClip(int x, int y, int z, int shift) {
        int rAbsX = (region >> 8) * 64;
        int rAbsY = (region & 0xff) * 64;

        if (clipping[z] == null) {
            clipping[z] = new int[64][64];
        }

        clipping[z][x - rAbsX][y - rAbsY] |= shift;
    }

    public void removeClip(int x, int y, int z, int shift) {
        int rAbsX = (region >> 8) * 64;
        int rAbsY = (region & 0xff) * 64;
        if (clipping[z] == null) {
            clipping[z] = new int[64][64];
        }
        clipping[z][x - rAbsX][y - rAbsY] &= ~shift;
    }

    public int getClip(int x, int y, int z) {
        int rAbsX = (region >> 8) * 64;
        int rAbsY = (region & 0xff) * 64;
        if (clipping[z] == null) {
            return 0;
        }
        return clipping[z][x - rAbsX][y - rAbsY];
    }

    public int getRegion() {
        return region;
    }


}
