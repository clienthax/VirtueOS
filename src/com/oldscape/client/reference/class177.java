package com.oldscape.client.reference;

class class177 {
    static final int[][] field2285;
    static final int[][] field2286;
    static final int[] field2290;
    static final int[] field2287;
    static int field2283;
    static int field2289;

    static {
        field2285 = new int[128][128];
        field2286 = new int[128][128];
        field2290 = new int[4096];
        field2287 = new int[4096];
    }

    static void method3427() {
        for (Projectile projectile = (Projectile) Client.projectiles.getFront(); projectile != null; projectile = (Projectile) Client.projectiles.getNext()) {
            if (projectile.floor == BoundingBox3DDrawMode.plane && Client.gameCycle <= projectile.endCycle) {
                if (Client.gameCycle >= projectile.startMovementCycle) {
                    if (projectile.interacting > 0) {
                        final NPC cachedNPC = Client.cachedNPCs[projectile.interacting - 1];
                        if (cachedNPC != null && cachedNPC.x >= 0 && cachedNPC.x < 13312 && cachedNPC.y >= 0 && cachedNPC.y < 13312) {
                            projectile.moveProjectile(cachedNPC.x, cachedNPC.y, WorldMapManager.getTileHeight(cachedNPC.x, cachedNPC.y, projectile.floor) - projectile.endHeight, Client.gameCycle);
                        }
                    }

                    if (projectile.interacting < 0) {
                        final int var2 = -projectile.interacting - 1;
                        final Player player;
                        if (var2 == Client.localInteractingIndex) {
                            player = Client.localPlayer;
                        } else {
                            player = Client.cachedPlayers[var2];
                        }

                        if (player != null && player.x >= 0 && player.x < 13312 && player.y >= 0 && player.y < 13312) {
                            projectile.moveProjectile(player.x, player.y, WorldMapManager.getTileHeight(player.x, player.y, projectile.floor) - projectile.endHeight, Client.gameCycle);
                        }
                    }

                    projectile.update(Client.field930);
                    class255.region.method2863(BoundingBox3DDrawMode.plane, (int) projectile.x, (int) projectile.y, (int) projectile.z, 60, projectile, projectile.rotationX, -1, false);
                }
            } else {
                projectile.unlink();
            }
        }

    }
}
