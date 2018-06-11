package com.oldscape.client.reference;

final class Tile extends Node {
    final int x;
    final int y;
    final int renderLevel;
    final GameObject[] objects;
    final int[] entityFlags;
    int plane;
    SceneTilePaint paint;
    SceneTileModel overlay;
    WallObject wallObject;
    DecorativeObject decorativeObject;
    GroundObject groundObject;
    ItemLayer itemLayer;
    int entityCount;
    int flags;
    int physicalLevel;
    boolean draw;
    boolean visible;
    boolean drawEntities;
    int wallCullDirection;
    int wallUncullDirection;
    int wallCullOppositeDirection;
    int wallDrawFlags;
    Tile bridge;

    Tile(final int plane, final int x, final int y) {
        this.objects = new GameObject[5];
        this.entityFlags = new int[5];
        this.flags = 0;
        this.renderLevel = this.plane = plane;
        this.x = x;
        this.y = y;
    }

}
