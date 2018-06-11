package com.oldscape.client.reference;

interface WorldMapSectionBase {

    void vmethod767(WorldMapData worldMapData);

    boolean containsCoord(int plane, int worldX, int worldY);

    boolean vmethod768(int worldX, int worldY);

    int[] vmethod753(int plane, int worldX, int worldY);

    Coordinates vmethod758(int var1, int var2);

    void decode(Buffer var1);

}
