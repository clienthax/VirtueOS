package com.oldscape.client.reference;

final class Projectile extends Renderable {
    static String host;
    static ContextMenuRow topContextMenuRow;
    final int floor;
    final int endHeight;
    final int startMovementCycle;
    final int endCycle;
    final int interacting;
    private final int id;
    private final int x1;
    private final int y1;
    private final int height;
    private final int slope;
    private final int startHeight;
    private final Sequence animationSequence;
    double x;
    double y;
    double z;
    int rotationX;
    private boolean isMoving;
    private double velocityX;
    private double velocityY;
    private double scalar;
    private double velocityZ;
    private double heightOffset;
    private int rotationY;
    private int int7;
    private int int6;

    Projectile(final int var1, final int var2, final int var3, final int var4, final int var5, final int var6, final int var7, final int var8, final int var9, final int var10, final int var11) {
        this.isMoving = false;
        this.int7 = 0;
        this.int6 = 0;
        this.id = var1;
        this.floor = var2;
        this.x1 = var3;
        this.y1 = var4;
        this.height = var5;
        this.startMovementCycle = var6;
        this.endCycle = var7;
        this.slope = var8;
        this.startHeight = var9;
        this.interacting = var10;
        this.endHeight = var11;
        this.isMoving = false;
        final int var12 = Spotanim.getSpotAnimType(this.id).field3497;
        if (var12 != -1) {
            this.animationSequence = CombatInfo1.getAnimation(var12);
        } else {
            this.animationSequence = null;
        }

    }

    static void method1944(final int var0) {
        class132.Viewport_entityIdsAtMouse[++class132.Viewport_entityCountAtMouse - 1] = var0;
    }

    public static void method1938(final IndexDataBase var0, final IndexDataBase var1, final IndexDataBase var2, final IndexDataBase var3) {
        UrlRequest.widgetIndex = var0;
        Friend.field3864 = var1;
        Widget.field2815 = var2;
        Widget.field1471 = var3;
        MouseRecorder.widgets = new Widget[UrlRequest.widgetIndex.size()][];
        class154.validInterfaces = new boolean[UrlRequest.widgetIndex.size()];
    }

    final void moveProjectile(final int var1, final int var2, final int var3, final int var4) {
        double var5;
        if (!this.isMoving) {
            var5 = (var1 - this.x1);
            final double var7 = (var2 - this.y1);
            final double var9 = Math.sqrt(var5 * var5 + var7 * var7);
            this.x = this.x1 + var5 * this.startHeight / var9;
            this.y = this.y1 + this.startHeight * var7 / var9;
            this.z = this.height;
        }

        var5 = (this.endCycle + 1 - var4);
        this.velocityX = (var1 - this.x) / var5;
        this.velocityY = (var2 - this.y) / var5;
        this.scalar = Math.sqrt(this.velocityY * this.velocityY + this.velocityX * this.velocityX);
        if (!this.isMoving) {
            this.velocityZ = -this.scalar * Math.tan(this.slope * 0.02454369D);
        }

        this.heightOffset = (var3 - this.z - var5 * this.velocityZ) * 2.0D / (var5 * var5);
    }

    final void update(final int var1) {
        this.isMoving = true;
        this.x += var1 * this.velocityX;
        this.y += var1 * this.velocityY;
        this.z += (double) var1 * var1 * this.heightOffset * 0.5D + this.velocityZ * var1;
        this.velocityZ += this.heightOffset * var1;
        this.rotationX = (int) (Math.atan2(this.velocityX, this.velocityY) * 325.949D) + 1024 & 2047;
        this.rotationY = (int) (Math.atan2(this.velocityZ, this.scalar) * 325.949D) & 2047;
        if (this.animationSequence != null) {
            this.int6 += var1;

            while (true) {
                do {
                    do {
                        if (this.int6 <= this.animationSequence.frameLengths[this.int7]) {
                            return;
                        }

                        this.int6 -= this.animationSequence.frameLengths[this.int7];
                        ++this.int7;
                    } while (this.int7 < this.animationSequence.frameIDs.length);

                    this.int7 -= this.animationSequence.frameStep;
                } while (this.int7 >= 0 && this.int7 < this.animationSequence.frameIDs.length);

                this.int7 = 0;
            }
        }
    }

    protected final Model getModel() {
        final Spotanim var1 = Spotanim.getSpotAnimType(this.id);
        final Model var2 = var1.getModel(this.int7);
        if (var2 == null) {
            return null;
        } else {
            var2.rotateZ(this.rotationY);
            return var2;
        }
    }
}
