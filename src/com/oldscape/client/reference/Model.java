package com.oldscape.client.reference;

public class Model extends Renderable {
    public static final int[] modelViewportYs;
    public static final int[] modelViewportXs;
    private static final Model field1856;
    private static final Model field1850;
    private static final boolean[] field1887;
    private static final boolean[] field1848;
    private static final int[] field1891;
    private static final int[] yViewportBuffer;
    private static final int[] field1893;
    private static final int[] field1894;
    private static final int[] field1896;
    private static final int[][] field1860;
    private static final int[] field1898;
    private static final int[][] field1899;
    private static final int[] field1900;
    private static final int[] field1895;
    private static final int[] field1901;
    private static final int[] field1903;
    private static final int[] field1875;
    private static final int[] xViewportBuffer;
    private static final boolean useBoundingBoxes3D;
    private static final int[] Model_sine;
    private static final int[] Model_cosine;
    private static final int[] field1914;
    private static final int[] field1915;
    private static byte[] field1911;
    private static byte[] field1904;
    private static int animOffsetX;
    private static int animOffsetY;
    private static int animOffsetZ;

    static {
        field1856 = new Model();
        field1911 = new byte[1];
        field1850 = new Model();
        field1904 = new byte[1];
        field1887 = new boolean[4700];
        field1848 = new boolean[4700];
        modelViewportYs = new int[4700];
        modelViewportXs = new int[4700];
        field1891 = new int[4700];
        yViewportBuffer = new int[4700];
        field1893 = new int[4700];
        field1894 = new int[4700];
        field1896 = new int[1600];
        field1860 = new int[1600][512];
        field1898 = new int[12];
        field1899 = new int[12][2000];
        field1900 = new int[2000];
        field1895 = new int[2000];
        field1901 = new int[12];
        field1903 = new int[10];
        field1875 = new int[10];
        xViewportBuffer = new int[10];
        useBoundingBoxes3D = true;
        Model_sine = Graphics3D.SINE;
        Model_cosine = Graphics3D.COSINE;
        field1914 = Graphics3D.colorPalette;
        field1915 = Graphics3D.field1952;
    }

    public int indicesCount;
    public int[] indices1;
    public int[] indices2;
    public int[] indices3;
    public int[] field1862;
    public boolean field1874;
    public int centerX;
    public int centerY;
    public int centerZ;
    public int extremeX;
    public int extremeY;
    public int extremeZ;
    int verticesCount;
    int[] verticesX;
    int[] verticesY;
    int[] verticesZ;
    int[] field1852;
    int[] field1861;
    byte[] faceRenderPriorities;
    byte[] faceAplhas;
    byte[] field1865;
    short[] faceTextures;
    byte priority;
    int field1866;
    int[] field1869;
    int[] field1868;
    int[] field1871;
    int[][] vertexGroups;
    int[][] field1890;
    private int boundsType;
    private int bottomY;
    private int XYZMag;
    private int diameter;
    private int radius;

    Model() {
        this.verticesCount = 0;
        this.indicesCount = 0;
        this.priority = 0;
        this.field1866 = 0;
        this.field1874 = false;
        this.extremeX = -1;
        this.extremeY = -1;
        this.extremeZ = -1;
    }

    public Model(final Model[] var1, final int var2) {
        this.verticesCount = 0;
        this.indicesCount = 0;
        this.priority = 0;
        this.field1866 = 0;
        this.field1874 = false;
        this.extremeX = -1;
        this.extremeY = -1;
        this.extremeZ = -1;
        boolean var3 = false;
        boolean var4 = false;
        boolean var5 = false;
        boolean var6 = false;
        this.verticesCount = 0;
        this.indicesCount = 0;
        this.field1866 = 0;
        this.priority = -1;

        int var7;
        Model var8;
        for (var7 = 0; var7 < var2; ++var7) {
            var8 = var1[var7];
            if (var8 != null) {
                this.verticesCount += var8.verticesCount;
                this.indicesCount += var8.indicesCount;
                this.field1866 += var8.field1866;
                if (var8.faceRenderPriorities != null) {
                    var3 = true;
                } else {
                    if (this.priority == -1) {
                        this.priority = var8.priority;
                    }

                    if (this.priority != var8.priority) {
                        var3 = true;
                    }
                }

                var4 |= var8.faceAplhas != null;
                var5 |= var8.faceTextures != null;
                var6 |= var8.field1865 != null;
            }
        }

        this.verticesX = new int[this.verticesCount];
        this.verticesY = new int[this.verticesCount];
        this.verticesZ = new int[this.verticesCount];
        this.indices1 = new int[this.indicesCount];
        this.indices2 = new int[this.indicesCount];
        this.indices3 = new int[this.indicesCount];
        this.field1852 = new int[this.indicesCount];
        this.field1861 = new int[this.indicesCount];
        this.field1862 = new int[this.indicesCount];
        if (var3) {
            this.faceRenderPriorities = new byte[this.indicesCount];
        }

        if (var4) {
            this.faceAplhas = new byte[this.indicesCount];
        }

        if (var5) {
            this.faceTextures = new short[this.indicesCount];
        }

        if (var6) {
            this.field1865 = new byte[this.indicesCount];
        }

        if (this.field1866 > 0) {
            this.field1869 = new int[this.field1866];
            this.field1868 = new int[this.field1866];
            this.field1871 = new int[this.field1866];
        }

        this.verticesCount = 0;
        this.indicesCount = 0;
        this.field1866 = 0;

        for (var7 = 0; var7 < var2; ++var7) {
            var8 = var1[var7];
            if (var8 != null) {
                int var9;
                for (var9 = 0; var9 < var8.indicesCount; ++var9) {
                    this.indices1[this.indicesCount] = this.verticesCount + var8.indices1[var9];
                    this.indices2[this.indicesCount] = this.verticesCount + var8.indices2[var9];
                    this.indices3[this.indicesCount] = this.verticesCount + var8.indices3[var9];
                    this.field1852[this.indicesCount] = var8.field1852[var9];
                    this.field1861[this.indicesCount] = var8.field1861[var9];
                    this.field1862[this.indicesCount] = var8.field1862[var9];
                    if (var3) {
                        if (var8.faceRenderPriorities != null) {
                            this.faceRenderPriorities[this.indicesCount] = var8.faceRenderPriorities[var9];
                        } else {
                            this.faceRenderPriorities[this.indicesCount] = var8.priority;
                        }
                    }

                    if (var4 && var8.faceAplhas != null) {
                        this.faceAplhas[this.indicesCount] = var8.faceAplhas[var9];
                    }

                    if (var5) {
                        if (var8.faceTextures != null) {
                            this.faceTextures[this.indicesCount] = var8.faceTextures[var9];
                        } else {
                            this.faceTextures[this.indicesCount] = -1;
                        }
                    }

                    if (var6) {
                        if (var8.field1865 != null && var8.field1865[var9] != -1) {
                            this.field1865[this.indicesCount] = (byte) (this.field1866 + var8.field1865[var9]);
                        } else {
                            this.field1865[this.indicesCount] = -1;
                        }
                    }

                    ++this.indicesCount;
                }

                for (var9 = 0; var9 < var8.field1866; ++var9) {
                    this.field1869[this.field1866] = this.verticesCount + var8.field1869[var9];
                    this.field1868[this.field1866] = this.verticesCount + var8.field1868[var9];
                    this.field1871[this.field1866] = this.verticesCount + var8.field1871[var9];
                    ++this.field1866;
                }

                for (var9 = 0; var9 < var8.verticesCount; ++var9) {
                    this.verticesX[this.verticesCount] = var8.verticesX[var9];
                    this.verticesY[this.verticesCount] = var8.verticesY[var9];
                    this.verticesZ[this.verticesCount] = var8.verticesZ[var9];
                    ++this.verticesCount;
                }
            }
        }

    }

    public static boolean boundingBox3DContainsMouse(final Model model, final int var1, final int var2, final int var3) {
        if (!IndexStoreActionHandler.method4629()) {
            return false;
        } else {
            class33.method408();
            final int centerX = model.centerX + var1;
            final int centerY = var2 + model.centerY;
            final int centerZ = var3 + model.centerZ;
            final int extremeX = model.extremeX;
            final int extremeY = model.extremeY;
            final int extremeZ = model.extremeZ;
            final int var10 = class132.field1919 - centerX;
            final int var11 = class132.field1923 - centerY;
            final int var12 = class132.field1924 - centerZ;
            return Math.abs(var10) <= extremeX + class20.field336 && (Math.abs(var11) <= extremeY + class132.field1926 && (Math.abs(var12) <= extremeZ + IndexStoreActionHandler.field3399 && (Math.abs(var12 * class37.field502 - var11 * Resampler.field1629) <= extremeY * IndexStoreActionHandler.field3399 + extremeZ * class132.field1926 && (Math.abs(var10 * Resampler.field1629 - var12 * class132.field1925) <= extremeX * IndexStoreActionHandler.field3399 + extremeZ * class20.field336 && Math.abs(var11 * class132.field1925 - var10 * class37.field502) <= extremeX * class132.field1926 + extremeY * class20.field336))));
        }
    }

    static int getViewportMouseY() {
        return class132.Viewport_mouseY;
    }

    public Model method2686(final int[][] var1, final int var2, final int var3, final int var4, final boolean var5, final int var6) {
        this.calculateBoundsCylinder();
        int var7 = var2 - this.XYZMag;
        int var8 = var2 + this.XYZMag;
        int var9 = var4 - this.XYZMag;
        int var10 = var4 + this.XYZMag;
        if (var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
            var7 >>= 7;
            var8 = var8 + 127 >> 7;
            var9 >>= 7;
            var10 = var10 + 127 >> 7;
            if (var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
                return this;
            } else {
                final Model var11;
                if (var5) {
                    var11 = new Model();
                    var11.verticesCount = this.verticesCount;
                    var11.indicesCount = this.indicesCount;
                    var11.field1866 = this.field1866;
                    var11.verticesX = this.verticesX;
                    var11.verticesZ = this.verticesZ;
                    var11.indices1 = this.indices1;
                    var11.indices2 = this.indices2;
                    var11.indices3 = this.indices3;
                    var11.field1852 = this.field1852;
                    var11.field1861 = this.field1861;
                    var11.field1862 = this.field1862;
                    var11.faceRenderPriorities = this.faceRenderPriorities;
                    var11.faceAplhas = this.faceAplhas;
                    var11.field1865 = this.field1865;
                    var11.faceTextures = this.faceTextures;
                    var11.priority = this.priority;
                    var11.field1869 = this.field1869;
                    var11.field1868 = this.field1868;
                    var11.field1871 = this.field1871;
                    var11.vertexGroups = this.vertexGroups;
                    var11.field1890 = this.field1890;
                    var11.field1874 = this.field1874;
                    var11.verticesY = new int[var11.verticesCount];
                } else {
                    var11 = this;
                }

                int var12;
                int var13;
                int var14;
                int var15;
                int var16;
                int var17;
                int var18;
                int var19;
                int var20;
                int var21;
                if (var6 == 0) {
                    for (var12 = 0; var12 < var11.verticesCount; ++var12) {
                        var13 = var2 + this.verticesX[var12];
                        var14 = var4 + this.verticesZ[var12];
                        var15 = var13 & 127;
                        var16 = var14 & 127;
                        var17 = var13 >> 7;
                        var18 = var14 >> 7;
                        var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                        var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                        var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                        var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
                    }
                } else {
                    for (var12 = 0; var12 < var11.verticesCount; ++var12) {
                        var13 = (-this.verticesY[var12] << 16) / super.modelHeight;
                        if (var13 < var6) {
                            var14 = var2 + this.verticesX[var12];
                            var15 = var4 + this.verticesZ[var12];
                            var16 = var14 & 127;
                            var17 = var15 & 127;
                            var18 = var14 >> 7;
                            var19 = var15 >> 7;
                            var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                            var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                            final int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                            var11.verticesY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.verticesY[var12];
                        }
                    }
                }

                var11.resetBounds();
                return var11;
            }
        } else {
            return this;
        }
    }

    public Model toSharedModel(final boolean var1) {
        if (!var1 && field1911.length < this.indicesCount) {
            field1911 = new byte[this.indicesCount + 100];
        }

        return this.method2689(var1, field1856, field1911);
    }

    public Model toSharedSpotAnimModel(final boolean var1) {
        if (!var1 && field1904.length < this.indicesCount) {
            field1904 = new byte[this.indicesCount + 100];
        }

        return this.method2689(var1, field1850, field1904);
    }

    private Model method2689(final boolean var1, final Model var2, final byte[] var3) {
        var2.verticesCount = this.verticesCount;
        var2.indicesCount = this.indicesCount;
        var2.field1866 = this.field1866;
        if (var2.verticesX == null || var2.verticesX.length < this.verticesCount) {
            var2.verticesX = new int[this.verticesCount + 100];
            var2.verticesY = new int[this.verticesCount + 100];
            var2.verticesZ = new int[this.verticesCount + 100];
        }

        int var4;
        for (var4 = 0; var4 < this.verticesCount; ++var4) {
            var2.verticesX[var4] = this.verticesX[var4];
            var2.verticesY[var4] = this.verticesY[var4];
            var2.verticesZ[var4] = this.verticesZ[var4];
        }

        if (var1) {
            var2.faceAplhas = this.faceAplhas;
        } else {
            var2.faceAplhas = var3;
            if (this.faceAplhas == null) {
                for (var4 = 0; var4 < this.indicesCount; ++var4) {
                    var2.faceAplhas[var4] = 0;
                }
            } else {
                for (var4 = 0; var4 < this.indicesCount; ++var4) {
                    var2.faceAplhas[var4] = this.faceAplhas[var4];
                }
            }
        }

        var2.indices1 = this.indices1;
        var2.indices2 = this.indices2;
        var2.indices3 = this.indices3;
        var2.field1852 = this.field1852;
        var2.field1861 = this.field1861;
        var2.field1862 = this.field1862;
        var2.faceRenderPriorities = this.faceRenderPriorities;
        var2.field1865 = this.field1865;
        var2.faceTextures = this.faceTextures;
        var2.priority = this.priority;
        var2.field1869 = this.field1869;
        var2.field1868 = this.field1868;
        var2.field1871 = this.field1871;
        var2.vertexGroups = this.vertexGroups;
        var2.field1890 = this.field1890;
        var2.field1874 = this.field1874;
        var2.resetBounds();
        return var2;
    }

    private void method2690(final int var1) {
        if (this.extremeX == -1) {
            int var2 = 0;
            int var3 = 0;
            int var4 = 0;
            int var5 = 0;
            int var6 = 0;
            int var7 = 0;
            final int var8 = Model_cosine[var1];
            final int var9 = Model_sine[var1];

            for (int var10 = 0; var10 < this.verticesCount; ++var10) {
                final int var11 = Graphics3D.method2798(this.verticesX[var10], this.verticesZ[var10], var8, var9);
                final int var12 = this.verticesY[var10];
                final int var13 = Graphics3D.method2799(this.verticesX[var10], this.verticesZ[var10], var8, var9);
                if (var11 < var2) {
                    var2 = var11;
                }

                if (var11 > var5) {
                    var5 = var11;
                }

                if (var12 < var3) {
                    var3 = var12;
                }

                if (var12 > var6) {
                    var6 = var12;
                }

                if (var13 < var4) {
                    var4 = var13;
                }

                if (var13 > var7) {
                    var7 = var13;
                }
            }

            this.centerX = (var5 + var2) / 2;
            this.centerY = (var6 + var3) / 2;
            this.centerZ = (var7 + var4) / 2;
            this.extremeX = (var5 - var2 + 1) / 2;
            this.extremeY = (var6 - var3 + 1) / 2;
            this.extremeZ = (var7 - var4 + 1) / 2;
            if (this.extremeX < 32) {
                this.extremeX = 32;
            }

            if (this.extremeZ < 32) {
                this.extremeZ = 32;
            }

            if (this.field1874) {
                this.extremeX += 8;
                this.extremeZ += 8;
            }

        }
    }

    public void calculateBoundsCylinder() {
        if (this.boundsType != 1) {
            this.boundsType = 1;
            super.modelHeight = 0;
            this.bottomY = 0;
            this.XYZMag = 0;

            for (int var1 = 0; var1 < this.verticesCount; ++var1) {
                final int var2 = this.verticesX[var1];
                final int var3 = this.verticesY[var1];
                final int var4 = this.verticesZ[var1];
                if (-var3 > super.modelHeight) {
                    super.modelHeight = -var3;
                }

                if (var3 > this.bottomY) {
                    this.bottomY = var3;
                }

                final int var5 = var2 * var2 + var4 * var4;
                if (var5 > this.XYZMag) {
                    this.XYZMag = var5;
                }
            }

            this.XYZMag = (int) (Math.sqrt(this.XYZMag) + 0.99D);
            this.radius = (int) (Math.sqrt((this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
            this.diameter = this.radius + (int) (Math.sqrt((this.XYZMag * this.XYZMag + this.bottomY * this.bottomY)) + 0.99D);
        }
    }

    private void method2692() {
        if (this.boundsType != 2) {
            this.boundsType = 2;
            this.XYZMag = 0;

            for (int var1 = 0; var1 < this.verticesCount; ++var1) {
                final int var2 = this.verticesX[var1];
                final int var3 = this.verticesY[var1];
                final int var4 = this.verticesZ[var1];
                final int var5 = var2 * var2 + var4 * var4 + var3 * var3;
                if (var5 > this.XYZMag) {
                    this.XYZMag = var5;
                }
            }

            this.XYZMag = (int) (Math.sqrt(this.XYZMag) + 0.99D);
            this.radius = this.XYZMag;
            this.diameter = this.XYZMag + this.XYZMag;
        }
    }

    public int method2693() {
        this.calculateBoundsCylinder();
        return this.XYZMag;
    }

    private void resetBounds() {
        this.boundsType = 0;
        this.extremeX = -1;
    }

    public void method2695(final Frames var1, final int var2) {
        if (this.vertexGroups != null) {
            if (var2 != -1) {
                final Frame var3 = var1.skeletons[var2];
                final FrameMap var4 = var3.skin;
                animOffsetX = 0;
                animOffsetY = 0;
                animOffsetZ = 0;

                for (int var5 = 0; var5 < var3.transformCount; ++var5) {
                    final int var6 = var3.transformTypes[var5];
                    this.animate(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
                }

                this.resetBounds();
            }
        }
    }

    public void method2745(final Frames var1, final int var2, final Frames var3, final int var4, final int[] var5) {
        if (var2 != -1) {
            if (var5 != null && var4 != -1) {
                final Frame var6 = var1.skeletons[var2];
                final Frame var7 = var3.skeletons[var4];
                final FrameMap var8 = var6.skin;
                animOffsetX = 0;
                animOffsetY = 0;
                animOffsetZ = 0;
                byte var9 = 0;
                int var13 = var9 + 1;
                int var10 = var5[var9];

                int var11;
                int var12;
                for (var11 = 0; var11 < var6.transformCount; ++var11) {
                    for (var12 = var6.transformTypes[var11]; var12 > var10; var10 = var5[var13++]) {
                    }

                    if (var12 != var10 || var8.types[var12] == 0) {
                        this.animate(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
                    }
                }

                animOffsetX = 0;
                animOffsetY = 0;
                animOffsetZ = 0;
                var9 = 0;
                var13 = var9 + 1;
                var10 = var5[var9];

                for (var11 = 0; var11 < var7.transformCount; ++var11) {
                    for (var12 = var7.transformTypes[var11]; var12 > var10; var10 = var5[var13++]) {
                    }

                    if (var12 == var10 || var8.types[var12] == 0) {
                        this.animate(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
                    }
                }

                this.resetBounds();
            } else {
                this.method2695(var1, var2);
            }
        }
    }

    private void animate(final int var1, final int[] var2, final int var3, final int var4, final int var5) {
        final int var6 = var2.length;
        int var7;
        int var8;
        int var11;
        int var12;
        if (var1 == 0) {
            var7 = 0;
            animOffsetX = 0;
            animOffsetY = 0;
            animOffsetZ = 0;

            for (var8 = 0; var8 < var6; ++var8) {
                final int var9 = var2[var8];
                if (var9 < this.vertexGroups.length) {
                    final int[] var10 = this.vertexGroups[var9];

                    for (var11 = 0; var11 < var10.length; ++var11) {
                        var12 = var10[var11];
                        animOffsetX += this.verticesX[var12];
                        animOffsetY += this.verticesY[var12];
                        animOffsetZ += this.verticesZ[var12];
                        ++var7;
                    }
                }
            }

            if (var7 > 0) {
                animOffsetX = var3 + animOffsetX / var7;
                animOffsetY = var4 + animOffsetY / var7;
                animOffsetZ = var5 + animOffsetZ / var7;
            } else {
                animOffsetX = var3;
                animOffsetY = var4;
                animOffsetZ = var5;
            }

        } else {
            int[] var18;
            int var19;
            if (var1 == 1) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < this.vertexGroups.length) {
                        var18 = this.vertexGroups[var8];

                        for (var19 = 0; var19 < var18.length; ++var19) {
                            var11 = var18[var19];
                            this.verticesX[var11] += var3;
                            this.verticesY[var11] += var4;
                            this.verticesZ[var11] += var5;
                        }
                    }
                }

            } else if (var1 == 2) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < this.vertexGroups.length) {
                        var18 = this.vertexGroups[var8];

                        for (var19 = 0; var19 < var18.length; ++var19) {
                            var11 = var18[var19];
                            this.verticesX[var11] -= animOffsetX;
                            this.verticesY[var11] -= animOffsetY;
                            this.verticesZ[var11] -= animOffsetZ;
                            var12 = (var3 & 255) * 8;
                            final int var13 = (var4 & 255) * 8;
                            final int var14 = (var5 & 255) * 8;
                            int var15;
                            int var16;
                            int var17;
                            if (var14 != 0) {
                                var15 = Model_sine[var14];
                                var16 = Model_cosine[var14];
                                var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                                this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                                this.verticesX[var11] = var17;
                            }

                            if (var12 != 0) {
                                var15 = Model_sine[var12];
                                var16 = Model_cosine[var12];
                                var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                                this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                                this.verticesY[var11] = var17;
                            }

                            if (var13 != 0) {
                                var15 = Model_sine[var13];
                                var16 = Model_cosine[var13];
                                var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                                this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                                this.verticesX[var11] = var17;
                            }

                            this.verticesX[var11] += animOffsetX;
                            this.verticesY[var11] += animOffsetY;
                            this.verticesZ[var11] += animOffsetZ;
                        }
                    }
                }

            } else if (var1 == 3) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < this.vertexGroups.length) {
                        var18 = this.vertexGroups[var8];

                        for (var19 = 0; var19 < var18.length; ++var19) {
                            var11 = var18[var19];
                            this.verticesX[var11] -= animOffsetX;
                            this.verticesY[var11] -= animOffsetY;
                            this.verticesZ[var11] -= animOffsetZ;
                            this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                            this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                            this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                            this.verticesX[var11] += animOffsetX;
                            this.verticesY[var11] += animOffsetY;
                            this.verticesZ[var11] += animOffsetZ;
                        }
                    }
                }

            } else if (var1 == 5) {
                if (this.field1890 != null && this.faceAplhas != null) {
                    for (var7 = 0; var7 < var6; ++var7) {
                        var8 = var2[var7];
                        if (var8 < this.field1890.length) {
                            var18 = this.field1890[var8];

                            for (var19 = 0; var19 < var18.length; ++var19) {
                                var11 = var18[var19];
                                var12 = (this.faceAplhas[var11] & 255) + var3 * 8;
                                if (var12 < 0) {
                                    var12 = 0;
                                } else if (var12 > 255) {
                                    var12 = 255;
                                }

                                this.faceAplhas[var11] = (byte) var12;
                            }
                        }
                    }
                }

            }
        }
    }

    public void rotateY90Ccw() {
        for (int var1 = 0; var1 < this.verticesCount; ++var1) {
            final int var2 = this.verticesX[var1];
            this.verticesX[var1] = this.verticesZ[var1];
            this.verticesZ[var1] = -var2;
        }

        this.resetBounds();
    }

    public void rotateY180Ccw() {
        for (int var1 = 0; var1 < this.verticesCount; ++var1) {
            this.verticesX[var1] = -this.verticesX[var1];
            this.verticesZ[var1] = -this.verticesZ[var1];
        }

        this.resetBounds();
    }

    public void rotateY270Ccw() {
        for (int var1 = 0; var1 < this.verticesCount; ++var1) {
            final int var2 = this.verticesZ[var1];
            this.verticesZ[var1] = this.verticesX[var1];
            this.verticesX[var1] = -var2;
        }

        this.resetBounds();
    }

    public void rotateZ(final int var1) {
        final int var2 = Model_sine[var1];
        final int var3 = Model_cosine[var1];

        for (int var4 = 0; var4 < this.verticesCount; ++var4) {
            final int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
            this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
            this.verticesY[var4] = var5;
        }

        this.resetBounds();
    }

    public void offsetBy(final int var1, final int var2, final int var3) {
        for (int var4 = 0; var4 < this.verticesCount; ++var4) {
            this.verticesX[var4] += var1;
            this.verticesY[var4] += var2;
            this.verticesZ[var4] += var3;
        }

        this.resetBounds();
    }

    public void scale(final int var1, final int var2, final int var3) {
        for (int var4 = 0; var4 < this.verticesCount; ++var4) {
            this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
            this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
            this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
        }

        this.resetBounds();
    }

    public final void method2734(final int var1, final int var2, final int var3, final int var4, final int var5, final int var6, final int var7) {
        field1896[0] = -1;
        if (this.boundsType != 2 && this.boundsType != 1) {
            this.method2692();
        }

        final int var8 = Graphics3D.centerX;
        final int var9 = Graphics3D.centerY;
        final int var10 = Model_sine[var1];
        final int var11 = Model_cosine[var1];
        final int var12 = Model_sine[var2];
        final int var13 = Model_cosine[var2];
        final int var14 = Model_sine[var3];
        final int var15 = Model_cosine[var3];
        final int var16 = Model_sine[var4];
        final int var17 = Model_cosine[var4];
        final int var18 = var16 * var6 + var17 * var7 >> 16;

        for (int var19 = 0; var19 < this.verticesCount; ++var19) {
            int var20 = this.verticesX[var19];
            int var21 = this.verticesY[var19];
            int var22 = this.verticesZ[var19];
            int var23;
            if (var3 != 0) {
                var23 = var21 * var14 + var20 * var15 >> 16;
                var21 = var21 * var15 - var20 * var14 >> 16;
                var20 = var23;
            }

            if (var1 != 0) {
                var23 = var21 * var11 - var22 * var10 >> 16;
                var22 = var21 * var10 + var22 * var11 >> 16;
                var21 = var23;
            }

            if (var2 != 0) {
                var23 = var22 * var12 + var20 * var13 >> 16;
                var22 = var22 * var13 - var20 * var12 >> 16;
                var20 = var23;
            }

            var20 += var5;
            var21 += var6;
            var22 += var7;
            var23 = var21 * var17 - var22 * var16 >> 16;
            var22 = var21 * var16 + var22 * var17 >> 16;
            field1891[var19] = var22 - var18;
            modelViewportYs[var19] = var20 * Graphics3D.Rasterizer3D_zoom / var22 + var8;
            modelViewportXs[var19] = var23 * Graphics3D.Rasterizer3D_zoom / var22 + var9;
            if (this.field1866 > 0) {
                yViewportBuffer[var19] = var20;
                field1893[var19] = var23;
                field1894[var19] = var22;
            }
        }

        try {
            this.method2707(false, false, false, 0);
        } catch (final Exception ignored) {
        }

    }

    public final void method2748(final int var1, final int var2, final int var3, final int var4, final int var5, final int var6, final int var7, final int var8) {
        field1896[0] = -1;
        if (this.boundsType != 2 && this.boundsType != 1) {
            this.method2692();
        }

        final int var9 = Graphics3D.centerX;
        final int var10 = Graphics3D.centerY;
        final int var11 = Model_sine[var1];
        final int var12 = Model_cosine[var1];
        final int var13 = Model_sine[var2];
        final int var14 = Model_cosine[var2];
        final int var15 = Model_sine[var3];
        final int var16 = Model_cosine[var3];
        final int var17 = Model_sine[var4];
        final int var18 = Model_cosine[var4];
        final int var19 = var17 * var6 + var18 * var7 >> 16;

        for (int var20 = 0; var20 < this.verticesCount; ++var20) {
            int var21 = this.verticesX[var20];
            int var22 = this.verticesY[var20];
            int var23 = this.verticesZ[var20];
            int var24;
            if (var3 != 0) {
                var24 = var22 * var15 + var21 * var16 >> 16;
                var22 = var22 * var16 - var21 * var15 >> 16;
                var21 = var24;
            }

            if (var1 != 0) {
                var24 = var22 * var12 - var23 * var11 >> 16;
                var23 = var22 * var11 + var23 * var12 >> 16;
                var22 = var24;
            }

            if (var2 != 0) {
                var24 = var23 * var13 + var21 * var14 >> 16;
                var23 = var23 * var14 - var21 * var13 >> 16;
                var21 = var24;
            }

            var21 += var5;
            var22 += var6;
            var23 += var7;
            var24 = var22 * var18 - var23 * var17 >> 16;
            var23 = var22 * var17 + var23 * var18 >> 16;
            field1891[var20] = var23 - var19;
            modelViewportYs[var20] = var9 + var21 * Graphics3D.Rasterizer3D_zoom / var8;
            modelViewportXs[var20] = var10 + var24 * Graphics3D.Rasterizer3D_zoom / var8;
            if (this.field1866 > 0) {
                yViewportBuffer[var20] = var21;
                field1893[var20] = var24;
                field1894[var20] = var23;
            }
        }

        try {
            this.method2707(false, false, false, 0);
        } catch (final Exception ignored) {
        }

    }

    private void method2707(final boolean var1, boolean var2, final boolean var3, final int var4) {
        if (this.diameter < 1600) {
            int var5;
            for (var5 = 0; var5 < this.diameter; ++var5) {
                field1896[var5] = 0;
            }

            var5 = var3 ? 20 : 5;
            if (class7.drawObjectGeometry2D && var2) {
                WorldMapData.method398(this, var5);
            }

            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var14;
            int var15;
            int var17;
            for (var6 = 0; var6 < this.indicesCount; ++var6) {
                if (this.field1862[var6] != -2) {
                    var7 = this.indices1[var6];
                    var8 = this.indices2[var6];
                    var9 = this.indices3[var6];
                    var10 = modelViewportYs[var7];
                    var11 = modelViewportYs[var8];
                    var12 = modelViewportYs[var9];
                    int var16;
                    int var31;
                    if (var1 && (var10 == -5000 || var11 == -5000 || var12 == -5000)) {
                        var31 = yViewportBuffer[var7];
                        var14 = yViewportBuffer[var8];
                        var15 = yViewportBuffer[var9];
                        var16 = field1893[var7];
                        var17 = field1893[var8];
                        int var18 = field1893[var9];
                        int var19 = field1894[var7];
                        final int var20 = field1894[var8];
                        int var21 = field1894[var9];
                        var31 -= var14;
                        var15 -= var14;
                        var16 -= var17;
                        var18 -= var17;
                        var19 -= var20;
                        var21 -= var20;
                        final int var22 = var16 * var21 - var19 * var18;
                        final int var23 = var19 * var15 - var31 * var21;
                        final int var24 = var31 * var18 - var16 * var15;
                        if (var14 * var22 + var17 * var23 + var20 * var24 > 0) {
                            field1848[var6] = true;
                            final int var25 = (field1891[var7] + field1891[var8] + field1891[var9]) / 3 + this.radius;
                            field1860[var25][field1896[var25]++] = var6;
                        }
                    } else {
                        if (var2) {
                            var14 = modelViewportXs[var7];
                            var15 = modelViewportXs[var8];
                            var16 = modelViewportXs[var9];
                            var17 = var5 + class132.Viewport_mouseY;
                            final boolean var13;
                            if (var17 < var14 && var17 < var15 && var17 < var16) {
                                var13 = false;
                            } else {
                                var17 = class132.Viewport_mouseY - var5;
                                if (var17 > var14 && var17 > var15 && var17 > var16) {
                                    var13 = false;
                                } else {
                                    var17 = var5 + class132.Viewport_mouseX;
                                    if (var17 < var10 && var17 < var11 && var17 < var12) {
                                        var13 = false;
                                    } else {
                                        var17 = class132.Viewport_mouseX - var5;
                                        var13 = var17 <= var10 || var17 <= var11 || var17 <= var12;
                                    }
                                }
                            }

                            if (var13) {
                                Projectile.method1944(var4);
                                var2 = false;
                            }
                        }

                        if ((var10 - var11) * (modelViewportXs[var9] - modelViewportXs[var8]) - (var12 - var11) * (modelViewportXs[var7] - modelViewportXs[var8]) > 0) {
                            field1848[var6] = false;
                            field1887[var6] = var10 < 0 || var11 < 0 || var12 < 0 || var10 > Graphics3D.rasterClipX || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX;

                            var31 = (field1891[var7] + field1891[var8] + field1891[var9]) / 3 + this.radius;
                            field1860[var31][field1896[var31]++] = var6;
                        }
                    }
                }
            }

            int[] var26;
            if (this.faceRenderPriorities == null) {
                for (var6 = this.diameter - 1; var6 >= 0; --var6) {
                    var7 = field1896[var6];
                    if (var7 > 0) {
                        var26 = field1860[var6];

                        for (var9 = 0; var9 < var7; ++var9) {
                            this.method2708(var26[var9]);
                        }
                    }
                }

            } else {
                for (var6 = 0; var6 < 12; ++var6) {
                    field1898[var6] = 0;
                    field1901[var6] = 0;
                }

                for (var6 = this.diameter - 1; var6 >= 0; --var6) {
                    var7 = field1896[var6];
                    if (var7 > 0) {
                        var26 = field1860[var6];

                        for (var9 = 0; var9 < var7; ++var9) {
                            var10 = var26[var9];
                            final byte var30 = this.faceRenderPriorities[var10];
                            var12 = field1898[var30]++;
                            field1899[var30][var12] = var10;
                            if (var30 < 10) {
                                field1901[var30] += var6;
                            } else if (var30 == 10) {
                                field1900[var12] = var6;
                            } else {
                                field1895[var12] = var6;
                            }
                        }
                    }
                }

                var6 = 0;
                if (field1898[1] > 0 || field1898[2] > 0) {
                    var6 = (field1901[1] + field1901[2]) / (field1898[1] + field1898[2]);
                }

                var7 = 0;
                if (field1898[3] > 0 || field1898[4] > 0) {
                    var7 = (field1901[3] + field1901[4]) / (field1898[3] + field1898[4]);
                }

                var8 = 0;
                if (field1898[6] > 0 || field1898[8] > 0) {
                    var8 = (field1901[8] + field1901[6]) / (field1898[8] + field1898[6]);
                }

                var10 = 0;
                var11 = field1898[10];
                int[] var27 = field1899[10];
                int[] var28 = field1900;
                if (var10 == var11) {
                    var10 = 0;
                    var11 = field1898[11];
                    var27 = field1899[11];
                    var28 = field1895;
                }

                if (var10 < var11) {
                    var9 = var28[var10];
                } else {
                    var9 = -1000;
                }

                for (var14 = 0; var14 < 10; ++var14) {
                    while (var14 == 0 && var9 > var6) {
                        this.method2708(var27[var10++]);
                        if (var10 == var11 && var27 != field1899[11]) {
                            var10 = 0;
                            var11 = field1898[11];
                            var27 = field1899[11];
                            var28 = field1895;
                        }

                        if (var10 < var11) {
                            var9 = var28[var10];
                        } else {
                            var9 = -1000;
                        }
                    }

                    while (var14 == 3 && var9 > var7) {
                        this.method2708(var27[var10++]);
                        if (var10 == var11 && var27 != field1899[11]) {
                            var10 = 0;
                            var11 = field1898[11];
                            var27 = field1899[11];
                            var28 = field1895;
                        }

                        if (var10 < var11) {
                            var9 = var28[var10];
                        } else {
                            var9 = -1000;
                        }
                    }

                    while (var14 == 5 && var9 > var8) {
                        this.method2708(var27[var10++]);
                        if (var10 == var11 && var27 != field1899[11]) {
                            var10 = 0;
                            var11 = field1898[11];
                            var27 = field1899[11];
                            var28 = field1895;
                        }

                        if (var10 < var11) {
                            var9 = var28[var10];
                        } else {
                            var9 = -1000;
                        }
                    }

                    var15 = field1898[var14];
                    final int[] var29 = field1899[var14];

                    for (var17 = 0; var17 < var15; ++var17) {
                        this.method2708(var29[var17]);
                    }
                }

                while (var9 != -1000) {
                    this.method2708(var27[var10++]);
                    if (var10 == var11 && var27 != field1899[11]) {
                        var10 = 0;
                        var27 = field1899[11];
                        var11 = field1898[11];
                        var28 = field1895;
                    }

                    if (var10 < var11) {
                        var9 = var28[var10];
                    } else {
                        var9 = -1000;
                    }
                }

            }
        }
    }

    private void method2708(final int var1) {
        if (field1848[var1]) {
            this.method2709(var1);
        } else {
            final int var2 = this.indices1[var1];
            final int var3 = this.indices2[var1];
            final int var4 = this.indices3[var1];
            Graphics3D.rasterClipEnable = field1887[var1];
            if (this.faceAplhas == null) {
                Graphics3D.rasterAlpha = 0;
            } else {
                Graphics3D.rasterAlpha = this.faceAplhas[var1] & 255;
            }

            if (this.faceTextures != null && this.faceTextures[var1] != -1) {
                final int var5;
                final int var6;
                final int var7;
                if (this.field1865 != null && this.field1865[var1] != -1) {
                    final int var8 = this.field1865[var1] & 255;
                    var5 = this.field1869[var8];
                    var6 = this.field1868[var8];
                    var7 = this.field1871[var8];
                } else {
                    var5 = var2;
                    var6 = var3;
                    var7 = var4;
                }

                if (this.field1862[var1] == -1) {
                    Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1852[var1], this.field1852[var1], this.field1852[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1893[var5], field1893[var6], field1893[var7], field1894[var5], field1894[var6], field1894[var7], this.faceTextures[var1]);
                } else {
                    Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1852[var1], this.field1861[var1], this.field1862[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1893[var5], field1893[var6], field1893[var7], field1894[var5], field1894[var6], field1894[var7], this.faceTextures[var1]);
                }
            } else if (this.field1862[var1] == -1) {
                Graphics3D.rasterFlat(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], field1914[this.field1852[var1]]);
            } else {
                Graphics3D.rasterGouraud(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1852[var1], this.field1861[var1], this.field1862[var1]);
            }

        }
    }

    private void method2709(final int var1) {
        final int var2 = Graphics3D.centerX;
        final int var3 = Graphics3D.centerY;
        int var4 = 0;
        final int var5 = this.indices1[var1];
        final int var6 = this.indices2[var1];
        final int var7 = this.indices3[var1];
        final int var8 = field1894[var5];
        final int var9 = field1894[var6];
        final int var10 = field1894[var7];
        if (this.faceAplhas == null) {
            Graphics3D.rasterAlpha = 0;
        } else {
            Graphics3D.rasterAlpha = this.faceAplhas[var1] & 255;
        }

        int var11;
        int var12;
        int var13;
        int var14;
        if (var8 >= 50) {
            field1903[var4] = modelViewportYs[var5];
            field1875[var4] = modelViewportXs[var5];
            xViewportBuffer[var4++] = this.field1852[var1];
        } else {
            var11 = yViewportBuffer[var5];
            var12 = field1893[var5];
            var13 = this.field1852[var1];
            if (var10 >= 50) {
                var14 = field1915[var10 - var8] * (50 - var8);
                field1903[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
                field1875[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1893[var7] - var12) * var14 >> 16)) / 50;
                xViewportBuffer[var4++] = var13 + ((this.field1862[var1] - var13) * var14 >> 16);
            }

            if (var9 >= 50) {
                var14 = field1915[var9 - var8] * (50 - var8);
                field1903[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
                field1875[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1893[var6] - var12) * var14 >> 16)) / 50;
                xViewportBuffer[var4++] = var13 + ((this.field1861[var1] - var13) * var14 >> 16);
            }
        }

        if (var9 >= 50) {
            field1903[var4] = modelViewportYs[var6];
            field1875[var4] = modelViewportXs[var6];
            xViewportBuffer[var4++] = this.field1861[var1];
        } else {
            var11 = yViewportBuffer[var6];
            var12 = field1893[var6];
            var13 = this.field1861[var1];
            if (var8 >= 50) {
                var14 = field1915[var8 - var9] * (50 - var9);
                field1903[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
                field1875[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1893[var5] - var12) * var14 >> 16)) / 50;
                xViewportBuffer[var4++] = var13 + ((this.field1852[var1] - var13) * var14 >> 16);
            }

            if (var10 >= 50) {
                var14 = field1915[var10 - var9] * (50 - var9);
                field1903[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
                field1875[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1893[var7] - var12) * var14 >> 16)) / 50;
                xViewportBuffer[var4++] = var13 + ((this.field1862[var1] - var13) * var14 >> 16);
            }
        }

        if (var10 >= 50) {
            field1903[var4] = modelViewportYs[var7];
            field1875[var4] = modelViewportXs[var7];
            xViewportBuffer[var4++] = this.field1862[var1];
        } else {
            var11 = yViewportBuffer[var7];
            var12 = field1893[var7];
            var13 = this.field1862[var1];
            if (var9 >= 50) {
                var14 = field1915[var9 - var10] * (50 - var10);
                field1903[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
                field1875[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1893[var6] - var12) * var14 >> 16)) / 50;
                xViewportBuffer[var4++] = var13 + ((this.field1861[var1] - var13) * var14 >> 16);
            }

            if (var8 >= 50) {
                var14 = field1915[var8 - var10] * (50 - var10);
                field1903[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
                field1875[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1893[var5] - var12) * var14 >> 16)) / 50;
                xViewportBuffer[var4++] = var13 + ((this.field1852[var1] - var13) * var14 >> 16);
            }
        }

        var11 = field1903[0];
        var12 = field1903[1];
        var13 = field1903[2];
        var14 = field1875[0];
        final int var15 = field1875[1];
        final int var16 = field1875[2];
        Graphics3D.rasterClipEnable = false;
        int var17;
        int var18;
        int var19;
        int var20;
        if (var4 == 3) {
            if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
                Graphics3D.rasterClipEnable = true;
            }

            if (this.faceTextures != null && this.faceTextures[var1] != -1) {
                if (this.field1865 != null && this.field1865[var1] != -1) {
                    var20 = this.field1865[var1] & 255;
                    var17 = this.field1869[var20];
                    var18 = this.field1868[var20];
                    var19 = this.field1871[var20];
                } else {
                    var17 = var5;
                    var18 = var6;
                    var19 = var7;
                }

                if (this.field1862[var1] == -1) {
                    Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1852[var1], this.field1852[var1], this.field1852[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1893[var17], field1893[var18], field1893[var19], field1894[var17], field1894[var18], field1894[var19], this.faceTextures[var1]);
                } else {
                    Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1893[var17], field1893[var18], field1893[var19], field1894[var17], field1894[var18], field1894[var19], this.faceTextures[var1]);
                }
            } else if (this.field1862[var1] == -1) {
                Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1914[this.field1852[var1]]);
            } else {
                Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            }
        }

        if (var4 == 4) {
            if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1903[3] < 0 || field1903[3] > Graphics3D.rasterClipX) {
                Graphics3D.rasterClipEnable = true;
            }

            if (this.faceTextures != null && this.faceTextures[var1] != -1) {
                if (this.field1865 != null && this.field1865[var1] != -1) {
                    var20 = this.field1865[var1] & 255;
                    var17 = this.field1869[var20];
                    var18 = this.field1868[var20];
                    var19 = this.field1871[var20];
                } else {
                    var17 = var5;
                    var18 = var6;
                    var19 = var7;
                }

                final short var21 = this.faceTextures[var1];
                if (this.field1862[var1] == -1) {
                    Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1852[var1], this.field1852[var1], this.field1852[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1893[var17], field1893[var18], field1893[var19], field1894[var17], field1894[var18], field1894[var19], var21);
                    Graphics3D.rasterTextureAffine(var14, var16, field1875[3], var11, var13, field1903[3], this.field1852[var1], this.field1852[var1], this.field1852[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1893[var17], field1893[var18], field1893[var19], field1894[var17], field1894[var18], field1894[var19], var21);
                } else {
                    Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1893[var17], field1893[var18], field1893[var19], field1894[var17], field1894[var18], field1894[var19], var21);
                    Graphics3D.rasterTextureAffine(var14, var16, field1875[3], var11, var13, field1903[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1893[var17], field1893[var18], field1893[var19], field1894[var17], field1894[var18], field1894[var19], var21);
                }
            } else if (this.field1862[var1] == -1) {
                var17 = field1914[this.field1852[var1]];
                Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
                Graphics3D.rasterFlat(var14, var16, field1875[3], var11, var13, field1903[3], var17);
            } else {
                Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
                Graphics3D.rasterGouraud(var14, var16, field1875[3], var11, var13, field1903[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
            }
        }

    }

    void draw(final int var1, final int var2, final int var3, final int var4, final int var5, final int var6, final int var7, final int var8, final int var9) {
        field1896[0] = -1;
        if (this.boundsType != 1) {
            this.calculateBoundsCylinder();
        }

        this.method2690(var1);
        final int var10 = var5 * var8 - var4 * var6 >> 16;
        final int var11 = var2 * var7 + var3 * var10 >> 16;
        final int var12 = var3 * this.XYZMag >> 16;
        final int var13 = var11 + var12;
        if (var13 > 50 && var11 < 3500) {
            final int var14 = var8 * var4 + var5 * var6 >> 16;
            int var15 = (var14 - this.XYZMag) * Graphics3D.Rasterizer3D_zoom;
            if (var15 / var13 < Graphics3D.Rasterizer3D_clipMidX2) {
                int var16 = (var14 + this.XYZMag) * Graphics3D.Rasterizer3D_zoom;
                if (var16 / var13 > Graphics3D.Rasterizer3D_clipNegativeMidX) {
                    final int var17 = var3 * var7 - var10 * var2 >> 16;
                    final int var18 = var2 * this.XYZMag >> 16;
                    int var19 = (var17 + var18) * Graphics3D.Rasterizer3D_zoom;
                    if (var19 / var13 > Graphics3D.Rasterizer3D_clipNegativeMidY) {
                        final int var20 = (var3 * super.modelHeight >> 16) + var18;
                        int var21 = (var17 - var20) * Graphics3D.Rasterizer3D_zoom;
                        if (var21 / var13 < Graphics3D.Rasterizer3D_clipMidY2) {
                            final int var22 = var12 + (var2 * super.modelHeight >> 16);
                            boolean var23 = false;
                            boolean var24 = false;
                            if (var11 - var22 <= 50) {
                                var24 = true;
                            }

                            final boolean var25 = var24 || this.field1866 > 0;
                            final int var26 = class132.Viewport_mouseX;
                            final int var28 = getViewportMouseY();
                            final boolean var29 = IndexStoreActionHandler.method4629();
                            if (class7.drawBoundingBoxes3D && var9 > 0) {
                                World.method1723(this, var6, var7, var8);
                            }

                            int var31;
                            int var32;
                            int var33;
                            int var34;
                            int var35;
                            int var36;
                            int var37;
                            if (class7.drawBoundingBoxes2D && var9 > 0) {
                                int var30 = var11 - var12;
                                if (var30 <= 50) {
                                    var30 = 50;
                                }

                                if (var14 > 0) {
                                    var31 = var15 / var13;
                                    var32 = var16 / var30;
                                } else {
                                    var32 = var16 / var13;
                                    var31 = var15 / var30;
                                }

                                if (var17 > 0) {
                                    var33 = var21 / var13;
                                    var34 = var19 / var30;
                                } else {
                                    var34 = var19 / var13;
                                    var33 = var21 / var30;
                                }

                                var35 = -8355840;
                                var36 = var26 - Graphics3D.centerX;
                                var37 = var28 - Graphics3D.centerY;
                                if (var36 > var31 && var36 < var32 && var37 > var33 && var37 < var34) {
                                    var35 = -256;
                                }

                                class149.method3104(var31 + Graphics3D.centerX, var33 + Graphics3D.centerY, var32 + Graphics3D.centerX, var34 + Graphics3D.centerY, var35);
                            }

                            boolean var42 = false;
                            if (var9 > 0 && var29) {
                                boolean var43 = false;
                                if (useBoundingBoxes3D) {
                                    var43 = boundingBox3DContainsMouse(this, var6, var7, var8);
                                } else {
                                    var32 = var11 - var12;
                                    if (var32 <= 50) {
                                        var32 = 50;
                                    }

                                    if (var14 > 0) {
                                        var15 /= var13;
                                        var16 /= var32;
                                    } else {
                                        var16 /= var13;
                                        var15 /= var32;
                                    }

                                    if (var17 > 0) {
                                        var21 /= var13;
                                        var19 /= var32;
                                    } else {
                                        var19 /= var13;
                                        var21 /= var32;
                                    }

                                    var33 = var26 - Graphics3D.centerX;
                                    var34 = var28 - Graphics3D.centerY;
                                    if (var33 > var15 && var33 < var16 && var34 > var21 && var34 < var19) {
                                        var43 = true;
                                    }
                                }

                                if (var43) {
                                    if (this.field1874) {
                                        class132.Viewport_entityIdsAtMouse[++class132.Viewport_entityCountAtMouse - 1] = var9;
                                    } else {
                                        var42 = true;
                                    }
                                }
                            }

                            var31 = Graphics3D.centerX;
                            var32 = Graphics3D.centerY;
                            var33 = 0;
                            var34 = 0;
                            if (var1 != 0) {
                                var33 = Model_sine[var1];
                                var34 = Model_cosine[var1];
                            }

                            for (var35 = 0; var35 < this.verticesCount; ++var35) {
                                var36 = this.verticesX[var35];
                                var37 = this.verticesY[var35];
                                int var38 = this.verticesZ[var35];
                                int var39;
                                if (var1 != 0) {
                                    var39 = var38 * var33 + var36 * var34 >> 16;
                                    var38 = var38 * var34 - var36 * var33 >> 16;
                                    var36 = var39;
                                }

                                var36 += var6;
                                var37 += var7;
                                var38 += var8;
                                var39 = var38 * var4 + var5 * var36 >> 16;
                                var38 = var5 * var38 - var36 * var4 >> 16;
                                var36 = var39;
                                var39 = var3 * var37 - var38 * var2 >> 16;
                                var38 = var37 * var2 + var3 * var38 >> 16;
                                field1891[var35] = var38 - var11;
                                if (var38 >= 50) {
                                    modelViewportYs[var35] = var36 * Graphics3D.Rasterizer3D_zoom / var38 + var31;
                                    modelViewportXs[var35] = var39 * Graphics3D.Rasterizer3D_zoom / var38 + var32;
                                } else {
                                    modelViewportYs[var35] = -5000;
                                    var23 = true;
                                }

                                if (var25) {
                                    yViewportBuffer[var35] = var36;
                                    field1893[var35] = var39;
                                    field1894[var35] = var38;
                                }
                            }

                            try {
                                this.method2707(var23, var42, this.field1874, var9);
                            } catch (final Exception ignored) {
                            }

                        }
                    }
                }
            }
        }
    }
}
