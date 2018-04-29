package com.oldscape.client;

@SuppressWarnings("Duplicates")
public class ModelData extends Renderable {
   private static final int[] field1765;
   private static final int[] field1753;
   private static int field1724;
   private static final int[] field1768;
   private static final int[] field1757;
   private int vertexCount;
   private int[] vertexX;
   private int[] vertexY;
   private int[] vertexZ;
   private int triangleFaceCount;
   private int[] trianglePointsX;
   private int[] trianglePointsY;
   private int[] trianglePointsZ;
   private byte[] faceRenderTypes;
   private byte[] faceRenderPriorities;
   private byte[] faceAlphas;
   private byte[] textureCoords;
   private short[] faceColor;
   private short[] faceTextures;
   private byte priority;
   private int field1738;
   private byte[] textureRenderTypes;
   private short[] texTriangleX;
   private short[] texTriangleY;
   private short[] texTriangleZ;
   private short[] field1743;
   private short[] field1745;
   private short[] field1740;
   private short[] field1746;
   private short[] field1747;
   private short[] texturePrimaryColor;
   private byte[] field1749;
   private int[] vertexSkins;
   private int[] triangleSkinValues;
   private int[][] vertexGroups;
   private int[][] field1758;
   private FaceNormal[] faceNormals;
   private VertexNormal[] normals;
   private VertexNormal[] field1756;
   public short field1731;
   public short contrast;
   private boolean field1759;
   private int field1760;
   private int field1761;
   private int field1762;
   private int field1763;
   private int field1764;

   static {
      field1765 = new int[10000];
      field1753 = new int[10000];
      field1724 = 0;
      field1768 = Graphics3D.SINE;
      field1757 = Graphics3D.COSINE;
   }

   private ModelData() {
      this.vertexCount = 0;
      this.triangleFaceCount = 0;
      this.priority = 0;
      this.field1759 = false;
   }

   public ModelData(final ModelData[] var1, final int var2) {
      this.vertexCount = 0;
      this.triangleFaceCount = 0;
      this.priority = 0;
      this.field1759 = false;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.vertexCount = 0;
      this.triangleFaceCount = 0;
      this.field1738 = 0;
      this.priority = -1;

      int var9;
      ModelData var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.vertexCount += var10.vertexCount;
            this.triangleFaceCount += var10.triangleFaceCount;
            this.field1738 += var10.field1738;
            if(var10.faceRenderPriorities != null) {
               var4 = true;
            } else {
               if(this.priority == -1) {
                  this.priority = var10.priority;
               }

               if(this.priority != var10.priority) {
                  var4 = true;
               }
            }

            var3 |= var10.faceRenderTypes != null;
            var5 |= var10.faceAlphas != null;
            var6 |= var10.triangleSkinValues != null;
            var7 |= var10.faceTextures != null;
            var8 |= var10.textureCoords != null;
         }
      }

      this.vertexX = new int[this.vertexCount];
      this.vertexY = new int[this.vertexCount];
      this.vertexZ = new int[this.vertexCount];
      this.vertexSkins = new int[this.vertexCount];
      this.trianglePointsX = new int[this.triangleFaceCount];
      this.trianglePointsY = new int[this.triangleFaceCount];
      this.trianglePointsZ = new int[this.triangleFaceCount];
      if(var3) {
         this.faceRenderTypes = new byte[this.triangleFaceCount];
      }

      if(var4) {
         this.faceRenderPriorities = new byte[this.triangleFaceCount];
      }

      if(var5) {
         this.faceAlphas = new byte[this.triangleFaceCount];
      }

      if(var6) {
         this.triangleSkinValues = new int[this.triangleFaceCount];
      }

      if(var7) {
         this.faceTextures = new short[this.triangleFaceCount];
      }

      if(var8) {
         this.textureCoords = new byte[this.triangleFaceCount];
      }

      this.faceColor = new short[this.triangleFaceCount];
      if(this.field1738 > 0) {
         this.textureRenderTypes = new byte[this.field1738];
         this.texTriangleX = new short[this.field1738];
         this.texTriangleY = new short[this.field1738];
         this.texTriangleZ = new short[this.field1738];
         this.field1743 = new short[this.field1738];
         this.field1745 = new short[this.field1738];
         this.field1740 = new short[this.field1738];
         this.field1746 = new short[this.field1738];
         this.field1749 = new byte[this.field1738];
         this.field1747 = new short[this.field1738];
         this.texturePrimaryColor = new short[this.field1738];
      }

      this.vertexCount = 0;
      this.triangleFaceCount = 0;
      this.field1738 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.triangleFaceCount; ++var11) {
               if(var3 && var10.faceRenderTypes != null) {
                  this.faceRenderTypes[this.triangleFaceCount] = var10.faceRenderTypes[var11];
               }

               if(var4) {
                  if(var10.faceRenderPriorities != null) {
                     this.faceRenderPriorities[this.triangleFaceCount] = var10.faceRenderPriorities[var11];
                  } else {
                     this.faceRenderPriorities[this.triangleFaceCount] = var10.priority;
                  }
               }

               if(var5 && var10.faceAlphas != null) {
                  this.faceAlphas[this.triangleFaceCount] = var10.faceAlphas[var11];
               }

               if(var6 && var10.triangleSkinValues != null) {
                  this.triangleSkinValues[this.triangleFaceCount] = var10.triangleSkinValues[var11];
               }

               if(var7) {
                  if(var10.faceTextures != null) {
                     this.faceTextures[this.triangleFaceCount] = var10.faceTextures[var11];
                  } else {
                     this.faceTextures[this.triangleFaceCount] = -1;
                  }
               }

               if(var8) {
                  if(var10.textureCoords != null && var10.textureCoords[var11] != -1) {
                     this.textureCoords[this.triangleFaceCount] = (byte)(this.field1738 + var10.textureCoords[var11]);
                  } else {
                     this.textureCoords[this.triangleFaceCount] = -1;
                  }
               }

               this.faceColor[this.triangleFaceCount] = var10.faceColor[var11];
               this.trianglePointsX[this.triangleFaceCount] = this.method2626(var10, var10.trianglePointsX[var11]);
               this.trianglePointsY[this.triangleFaceCount] = this.method2626(var10, var10.trianglePointsY[var11]);
               this.trianglePointsZ[this.triangleFaceCount] = this.method2626(var10, var10.trianglePointsZ[var11]);
               ++this.triangleFaceCount;
            }

            for(var11 = 0; var11 < var10.field1738; ++var11) {
               final byte var12 = this.textureRenderTypes[this.field1738] = var10.textureRenderTypes[var11];
               if(var12 == 0) {
                  this.texTriangleX[this.field1738] = (short)this.method2626(var10, var10.texTriangleX[var11]);
                  this.texTriangleY[this.field1738] = (short)this.method2626(var10, var10.texTriangleY[var11]);
                  this.texTriangleZ[this.field1738] = (short)this.method2626(var10, var10.texTriangleZ[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.texTriangleX[this.field1738] = var10.texTriangleX[var11];
                  this.texTriangleY[this.field1738] = var10.texTriangleY[var11];
                  this.texTriangleZ[this.field1738] = var10.texTriangleZ[var11];
                  this.field1743[this.field1738] = var10.field1743[var11];
                  this.field1745[this.field1738] = var10.field1745[var11];
                  this.field1740[this.field1738] = var10.field1740[var11];
                  this.field1746[this.field1738] = var10.field1746[var11];
                  this.field1749[this.field1738] = var10.field1749[var11];
                  this.field1747[this.field1738] = var10.field1747[var11];
               }

               if(var12 == 2) {
                  this.texturePrimaryColor[this.field1738] = var10.texturePrimaryColor[var11];
               }

               ++this.field1738;
            }
         }
      }

   }

   private ModelData(final byte[] var1) {
      this.vertexCount = 0;
      this.triangleFaceCount = 0;
      this.priority = 0;
      this.field1759 = false;
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.decodeNewFormat(var1);
      } else {
         this.decodeOldFormat(var1);
      }

   }

   public ModelData(final ModelData var1, final boolean var2, final boolean var3, final boolean var4) {
      this.vertexCount = 0;
      this.triangleFaceCount = 0;
      this.priority = 0;
      this.field1759 = false;
      this.vertexCount = var1.vertexCount;
      this.triangleFaceCount = var1.triangleFaceCount;
      this.field1738 = var1.field1738;
      int var6;
      if(var2) {
         this.vertexX = var1.vertexX;
         this.vertexY = var1.vertexY;
         this.vertexZ = var1.vertexZ;
      } else {
         this.vertexX = new int[this.vertexCount];
         this.vertexY = new int[this.vertexCount];
         this.vertexZ = new int[this.vertexCount];

         for(var6 = 0; var6 < this.vertexCount; ++var6) {
            this.vertexX[var6] = var1.vertexX[var6];
            this.vertexY[var6] = var1.vertexY[var6];
            this.vertexZ[var6] = var1.vertexZ[var6];
         }
      }

      if(var3) {
         this.faceColor = var1.faceColor;
      } else {
         this.faceColor = new short[this.triangleFaceCount];

         for(var6 = 0; var6 < this.triangleFaceCount; ++var6) {
            this.faceColor[var6] = var1.faceColor[var6];
         }
      }

      if(!var4 && var1.faceTextures != null) {
         this.faceTextures = new short[this.triangleFaceCount];

         for(var6 = 0; var6 < this.triangleFaceCount; ++var6) {
            this.faceTextures[var6] = var1.faceTextures[var6];
         }
      } else {
         this.faceTextures = var1.faceTextures;
      }

      this.faceAlphas = var1.faceAlphas;
      this.trianglePointsX = var1.trianglePointsX;
      this.trianglePointsY = var1.trianglePointsY;
      this.trianglePointsZ = var1.trianglePointsZ;
      this.faceRenderTypes = var1.faceRenderTypes;
      this.faceRenderPriorities = var1.faceRenderPriorities;
      this.textureCoords = var1.textureCoords;
      this.priority = var1.priority;
      this.textureRenderTypes = var1.textureRenderTypes;
      this.texTriangleX = var1.texTriangleX;
      this.texTriangleY = var1.texTriangleY;
      this.texTriangleZ = var1.texTriangleZ;
      this.field1743 = var1.field1743;
      this.field1745 = var1.field1745;
      this.field1740 = var1.field1740;
      this.field1746 = var1.field1746;
      this.field1749 = var1.field1749;
      this.field1747 = var1.field1747;
      this.texturePrimaryColor = var1.texturePrimaryColor;
      this.vertexSkins = var1.vertexSkins;
      this.triangleSkinValues = var1.triangleSkinValues;
      this.vertexGroups = var1.vertexGroups;
      this.field1758 = var1.field1758;
      this.normals = var1.normals;
      this.faceNormals = var1.faceNormals;
      this.field1756 = var1.field1756;
      this.field1731 = var1.field1731;
      this.contrast = var1.contrast;
   }

   private void decodeNewFormat(final byte[] var1) {
      final Buffer var2 = new Buffer(var1);
      final Buffer var3 = new Buffer(var1);
      final Buffer var4 = new Buffer(var1);
      final Buffer var5 = new Buffer(var1);
      final Buffer var6 = new Buffer(var1);
      final Buffer var7 = new Buffer(var1);
      final Buffer var8 = new Buffer(var1);
      var2.offset = var1.length - 23;
      final int var9 = var2.readUnsignedShort();
      final int var10 = var2.readUnsignedShort();
      final int var11 = var2.readUnsignedByte();
      final int var12 = var2.readUnsignedByte();
      final int var13 = var2.readUnsignedByte();
      final int var14 = var2.readUnsignedByte();
      final int var15 = var2.readUnsignedByte();
      final int var16 = var2.readUnsignedByte();
      final int var17 = var2.readUnsignedByte();
      final int var18 = var2.readUnsignedShort();
      final int var19 = var2.readUnsignedShort();
      final int var20 = var2.readUnsignedShort();
      final int var21 = var2.readUnsignedShort();
      final int var22 = var2.readUnsignedShort();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.textureRenderTypes = new byte[var11];
         var2.offset = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            final byte var27 = this.textureRenderTypes[var26] = var2.readByte();
            if(var27 == 0) {
               ++var23;
            }

            if(var27 >= 1 && var27 <= 3) {
               ++var24;
            }

            if(var27 == 2) {
               ++var25;
            }
         }
      }

      var26 = var11 + var9;
      final int var28 = var26;
      if(var12 == 1) {
         var26 += var10;
      }

      final int var29 = var26;
      var26 += var10;
      final int var30 = var26;
      if(var13 == 255) {
         var26 += var10;
      }

      final int var31 = var26;
      if(var15 == 1) {
         var26 += var10;
      }

      final int var32 = var26;
      if(var17 == 1) {
         var26 += var9;
      }

      final int var33 = var26;
      if(var14 == 1) {
         var26 += var10;
      }

      final int var34 = var26;
      var26 += var21;
      final int var35 = var26;
      if(var16 == 1) {
         var26 += var10 * 2;
      }

      final int var36 = var26;
      var26 += var22;
      final int var37 = var26;
      var26 += var10 * 2;
      final int var38 = var26;
      var26 += var18;
      final int var39 = var26;
      var26 += var19;
      final int var40 = var26;
      var26 += var20;
      final int var41 = var26;
      var26 += var23 * 6;
      final int var42 = var26;
      var26 += var24 * 6;
      final int var43 = var26;
      var26 += var24 * 6;
      final int var44 = var26;
      var26 += var24 * 2;
      final int var45 = var26;
      var26 += var24;
      final int var46 = var26;
      var26 += var24 * 2 + var25 * 2;
      this.vertexCount = var9;
      this.triangleFaceCount = var10;
      this.field1738 = var11;
      this.vertexX = new int[var9];
      this.vertexY = new int[var9];
      this.vertexZ = new int[var9];
      this.trianglePointsX = new int[var10];
      this.trianglePointsY = new int[var10];
      this.trianglePointsZ = new int[var10];
      if(var17 == 1) {
         this.vertexSkins = new int[var9];
      }

      if(var12 == 1) {
         this.faceRenderTypes = new byte[var10];
      }

      if(var13 == 255) {
         this.faceRenderPriorities = new byte[var10];
      } else {
         this.priority = (byte)var13;
      }

      if(var14 == 1) {
         this.faceAlphas = new byte[var10];
      }

      if(var15 == 1) {
         this.triangleSkinValues = new int[var10];
      }

      if(var16 == 1) {
         this.faceTextures = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.textureCoords = new byte[var10];
      }

      this.faceColor = new short[var10];
      if(var11 > 0) {
         this.texTriangleX = new short[var11];
         this.texTriangleY = new short[var11];
         this.texTriangleZ = new short[var11];
         if(var24 > 0) {
            this.field1743 = new short[var24];
            this.field1745 = new short[var24];
            this.field1740 = new short[var24];
            this.field1746 = new short[var24];
            this.field1749 = new byte[var24];
            this.field1747 = new short[var24];
         }

         if(var25 > 0) {
            this.texturePrimaryColor = new short[var25];
         }
      }

      var2.offset = var11;
      var3.offset = var38;
      var4.offset = var39;
      var5.offset = var40;
      var6.offset = var32;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;

      int var51;
      int var52;
      int var53;
      int var54;
      int var55;
      for(var51 = 0; var51 < var9; ++var51) {
         var52 = var2.readUnsignedByte();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.readShortSmart();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.readShortSmart();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.readShortSmart();
         }

         this.vertexX[var51] = var48 + var53;
         this.vertexY[var51] = var49 + var54;
         this.vertexZ[var51] = var50 + var55;
         var48 = this.vertexX[var51];
         var49 = this.vertexY[var51];
         var50 = this.vertexZ[var51];
         if(var17 == 1) {
            this.vertexSkins[var51] = var6.readUnsignedByte();
         }
      }

      var2.offset = var37;
      var3.offset = var28;
      var4.offset = var30;
      var5.offset = var33;
      var6.offset = var31;
      var7.offset = var35;
      var8.offset = var36;

      for(var51 = 0; var51 < var10; ++var51) {
         this.faceColor[var51] = (short)var2.readUnsignedShort();
         if(var12 == 1) {
            this.faceRenderTypes[var51] = var3.readByte();
         }

         if(var13 == 255) {
            this.faceRenderPriorities[var51] = var4.readByte();
         }

         if(var14 == 1) {
            this.faceAlphas[var51] = var5.readByte();
         }

         if(var15 == 1) {
            this.triangleSkinValues[var51] = var6.readUnsignedByte();
         }

         if(var16 == 1) {
            this.faceTextures[var51] = (short)(var7.readUnsignedShort() - 1);
         }

         if(this.textureCoords != null && this.faceTextures[var51] != -1) {
            this.textureCoords[var51] = (byte)(var8.readUnsignedByte() - 1);
         }
      }

      var2.offset = var34;
      var3.offset = var29;
      var51 = 0;
      var52 = 0;
      var53 = 0;
      var54 = 0;

      int var56;
      for(var55 = 0; var55 < var10; ++var55) {
         var56 = var3.readUnsignedByte();
         if(var56 == 1) {
            var51 = var2.readShortSmart() + var54;
            var52 = var2.readShortSmart() + var51;
            var53 = var2.readShortSmart() + var52;
            var54 = var53;
            this.trianglePointsX[var55] = var51;
            this.trianglePointsY[var55] = var52;
            this.trianglePointsZ[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.readShortSmart() + var54;
            var54 = var53;
            this.trianglePointsX[var55] = var51;
            this.trianglePointsY[var55] = var52;
            this.trianglePointsZ[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.readShortSmart() + var54;
            var54 = var53;
            this.trianglePointsX[var55] = var51;
            this.trianglePointsY[var55] = var52;
            this.trianglePointsZ[var55] = var53;
         }

         if(var56 == 4) {
            final int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.readShortSmart() + var54;
            var54 = var53;
            this.trianglePointsX[var55] = var51;
            this.trianglePointsY[var55] = var57;
            this.trianglePointsZ[var55] = var53;
         }
      }

      var2.offset = var41;
      var3.offset = var42;
      var4.offset = var43;
      var5.offset = var44;
      var6.offset = var45;
      var7.offset = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.textureRenderTypes[var55] & 255;
         if(var56 == 0) {
            this.texTriangleX[var55] = (short)var2.readUnsignedShort();
            this.texTriangleY[var55] = (short)var2.readUnsignedShort();
            this.texTriangleZ[var55] = (short)var2.readUnsignedShort();
         }

         if(var56 == 1) {
            this.texTriangleX[var55] = (short)var3.readUnsignedShort();
            this.texTriangleY[var55] = (short)var3.readUnsignedShort();
            this.texTriangleZ[var55] = (short)var3.readUnsignedShort();
            this.field1743[var55] = (short)var4.readUnsignedShort();
            this.field1745[var55] = (short)var4.readUnsignedShort();
            this.field1740[var55] = (short)var4.readUnsignedShort();
            this.field1746[var55] = (short)var5.readUnsignedShort();
            this.field1749[var55] = var6.readByte();
            this.field1747[var55] = (short)var7.readUnsignedShort();
         }

         if(var56 == 2) {
            this.texTriangleX[var55] = (short)var3.readUnsignedShort();
            this.texTriangleY[var55] = (short)var3.readUnsignedShort();
            this.texTriangleZ[var55] = (short)var3.readUnsignedShort();
            this.field1743[var55] = (short)var4.readUnsignedShort();
            this.field1745[var55] = (short)var4.readUnsignedShort();
            this.field1740[var55] = (short)var4.readUnsignedShort();
            this.field1746[var55] = (short)var5.readUnsignedShort();
            this.field1749[var55] = var6.readByte();
            this.field1747[var55] = (short)var7.readUnsignedShort();
            this.texturePrimaryColor[var55] = (short)var7.readUnsignedShort();
         }

         if(var56 == 3) {
            this.texTriangleX[var55] = (short)var3.readUnsignedShort();
            this.texTriangleY[var55] = (short)var3.readUnsignedShort();
            this.texTriangleZ[var55] = (short)var3.readUnsignedShort();
            this.field1743[var55] = (short)var4.readUnsignedShort();
            this.field1745[var55] = (short)var4.readUnsignedShort();
            this.field1740[var55] = (short)var4.readUnsignedShort();
            this.field1746[var55] = (short)var5.readUnsignedShort();
            this.field1749[var55] = var6.readByte();
            this.field1747[var55] = (short)var7.readUnsignedShort();
         }
      }

      var2.offset = var26;
      var55 = var2.readUnsignedByte();
      if(var55 != 0) {
         new class138();
         var2.readUnsignedShort();
         var2.readUnsignedShort();
         var2.readUnsignedShort();
         var2.readInt();
      }

   }

   private void decodeOldFormat(final byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      final Buffer var4 = new Buffer(var1);
      final Buffer var5 = new Buffer(var1);
      final Buffer var6 = new Buffer(var1);
      final Buffer var7 = new Buffer(var1);
      final Buffer var8 = new Buffer(var1);
      var4.offset = var1.length - 18;
      final int var9 = var4.readUnsignedShort();
      final int var10 = var4.readUnsignedShort();
      final int var11 = var4.readUnsignedByte();
      final int var12 = var4.readUnsignedByte();
      final int var13 = var4.readUnsignedByte();
      final int var14 = var4.readUnsignedByte();
      final int var15 = var4.readUnsignedByte();
      final int var16 = var4.readUnsignedByte();
      final int var17 = var4.readUnsignedShort();
      final int var18 = var4.readUnsignedShort();
      final int var19 = var4.readUnsignedShort();
      final int var20 = var4.readUnsignedShort();
      final byte var21 = 0;
      int var45 = var21 + var9;
      final int var23 = var45;
      var45 += var10;
      final int var24 = var45;
      if(var13 == 255) {
         var45 += var10;
      }

      final int var25 = var45;
      if(var15 == 1) {
         var45 += var10;
      }

      final int var26 = var45;
      if(var12 == 1) {
         var45 += var10;
      }

      final int var27 = var45;
      if(var16 == 1) {
         var45 += var9;
      }

      final int var28 = var45;
      if(var14 == 1) {
         var45 += var10;
      }

      final int var29 = var45;
      var45 += var20;
      final int var30 = var45;
      var45 += var10 * 2;
      final int var31 = var45;
      var45 += var11 * 6;
      final int var32 = var45;
      var45 += var17;
      final int var33 = var45;
      var45 += var18;
      final int var10000 = var45 + var19;
      this.vertexCount = var9;
      this.triangleFaceCount = var10;
      this.field1738 = var11;
      this.vertexX = new int[var9];
      this.vertexY = new int[var9];
      this.vertexZ = new int[var9];
      this.trianglePointsX = new int[var10];
      this.trianglePointsY = new int[var10];
      this.trianglePointsZ = new int[var10];
      if(var11 > 0) {
         this.textureRenderTypes = new byte[var11];
         this.texTriangleX = new short[var11];
         this.texTriangleY = new short[var11];
         this.texTriangleZ = new short[var11];
      }

      if(var16 == 1) {
         this.vertexSkins = new int[var9];
      }

      if(var12 == 1) {
         this.faceRenderTypes = new byte[var10];
         this.textureCoords = new byte[var10];
         this.faceTextures = new short[var10];
      }

      if(var13 == 255) {
         this.faceRenderPriorities = new byte[var10];
      } else {
         this.priority = (byte)var13;
      }

      if(var14 == 1) {
         this.faceAlphas = new byte[var10];
      }

      if(var15 == 1) {
         this.triangleSkinValues = new int[var10];
      }

      this.faceColor = new short[var10];
      var4.offset = var21;
      var5.offset = var32;
      var6.offset = var33;
      var7.offset = var45;
      var8.offset = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; ++var38) {
         var39 = var4.readUnsignedByte();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.readShortSmart();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.readShortSmart();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.readShortSmart();
         }

         this.vertexX[var38] = var35 + var40;
         this.vertexY[var38] = var36 + var41;
         this.vertexZ[var38] = var37 + var42;
         var35 = this.vertexX[var38];
         var36 = this.vertexY[var38];
         var37 = this.vertexZ[var38];
         if(var16 == 1) {
            this.vertexSkins[var38] = var8.readUnsignedByte();
         }
      }

      var4.offset = var30;
      var5.offset = var26;
      var6.offset = var24;
      var7.offset = var28;
      var8.offset = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.faceColor[var38] = (short)var4.readUnsignedShort();
         if(var12 == 1) {
            var39 = var5.readUnsignedByte();
            if((var39 & 1) == 1) {
               this.faceRenderTypes[var38] = 1;
               var2 = true;
            } else {
               this.faceRenderTypes[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.textureCoords[var38] = (byte)(var39 >> 2);
               this.faceTextures[var38] = this.faceColor[var38];
               this.faceColor[var38] = 127;
               if(this.faceTextures[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.textureCoords[var38] = -1;
               this.faceTextures[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.faceRenderPriorities[var38] = var6.readByte();
         }

         if(var14 == 1) {
            this.faceAlphas[var38] = var7.readByte();
         }

         if(var15 == 1) {
            this.triangleSkinValues[var38] = var8.readUnsignedByte();
         }
      }

      var4.offset = var29;
      var5.offset = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; ++var42) {
         var43 = var5.readUnsignedByte();
         if(var43 == 1) {
            var38 = var4.readShortSmart() + var41;
            var39 = var4.readShortSmart() + var38;
            var40 = var4.readShortSmart() + var39;
            var41 = var40;
            this.trianglePointsX[var42] = var38;
            this.trianglePointsY[var42] = var39;
            this.trianglePointsZ[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.readShortSmart() + var41;
            var41 = var40;
            this.trianglePointsX[var42] = var38;
            this.trianglePointsY[var42] = var39;
            this.trianglePointsZ[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.readShortSmart() + var41;
            var41 = var40;
            this.trianglePointsX[var42] = var38;
            this.trianglePointsY[var42] = var39;
            this.trianglePointsZ[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.readShortSmart() + var41;
            var41 = var40;
            this.trianglePointsX[var42] = var38;
            this.trianglePointsY[var42] = var44;
            this.trianglePointsZ[var42] = var40;
         }
      }

      var4.offset = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.textureRenderTypes[var42] = 0;
         this.texTriangleX[var42] = (short)var4.readUnsignedShort();
         this.texTriangleY[var42] = (short)var4.readUnsignedShort();
         this.texTriangleZ[var42] = (short)var4.readUnsignedShort();
      }

      if(this.textureCoords != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.textureCoords[var43] & 255;
            if(var44 != 255) {
               if(this.trianglePointsX[var43] == (this.texTriangleX[var44] & '\uffff') && this.trianglePointsY[var43] == (this.texTriangleY[var44] & '\uffff') && this.trianglePointsZ[var43] == (this.texTriangleZ[var44] & '\uffff')) {
                  this.textureCoords[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.textureCoords = null;
         }
      }

      if(!var3) {
         this.faceTextures = null;
      }

      if(!var2) {
         this.faceRenderTypes = null;
      }

   }

   private int method2626(final ModelData var1, final int var2) {
      int var3 = -1;
      final int var4 = var1.vertexX[var2];
      final int var5 = var1.vertexY[var2];
      final int var6 = var1.vertexZ[var2];

      for(int var7 = 0; var7 < this.vertexCount; ++var7) {
         if(var4 == this.vertexX[var7] && var5 == this.vertexY[var7] && var6 == this.vertexZ[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.vertexX[this.vertexCount] = var4;
         this.vertexY[this.vertexCount] = var5;
         this.vertexZ[this.vertexCount] = var6;
         if(var1.vertexSkins != null) {
            this.vertexSkins[this.vertexCount] = var1.vertexSkins[var2];
         }

         var3 = this.vertexCount++;
      }

      return var3;
   }

   public ModelData method2604() {
      final ModelData var1 = new ModelData();
      if(this.faceRenderTypes != null) {
         var1.faceRenderTypes = new byte[this.triangleFaceCount];

          System.arraycopy(this.faceRenderTypes, 0, var1.faceRenderTypes, 0, this.triangleFaceCount);
      }

      var1.vertexCount = this.vertexCount;
      var1.triangleFaceCount = this.triangleFaceCount;
      var1.field1738 = this.field1738;
      var1.vertexX = this.vertexX;
      var1.vertexY = this.vertexY;
      var1.vertexZ = this.vertexZ;
      var1.trianglePointsX = this.trianglePointsX;
      var1.trianglePointsY = this.trianglePointsY;
      var1.trianglePointsZ = this.trianglePointsZ;
      var1.faceRenderPriorities = this.faceRenderPriorities;
      var1.faceAlphas = this.faceAlphas;
      var1.textureCoords = this.textureCoords;
      var1.faceColor = this.faceColor;
      var1.faceTextures = this.faceTextures;
      var1.priority = this.priority;
      var1.textureRenderTypes = this.textureRenderTypes;
      var1.texTriangleX = this.texTriangleX;
      var1.texTriangleY = this.texTriangleY;
      var1.texTriangleZ = this.texTriangleZ;
      var1.field1743 = this.field1743;
      var1.field1745 = this.field1745;
      var1.field1740 = this.field1740;
      var1.field1746 = this.field1746;
      var1.field1749 = this.field1749;
      var1.field1747 = this.field1747;
      var1.texturePrimaryColor = this.texturePrimaryColor;
      var1.vertexSkins = this.vertexSkins;
      var1.triangleSkinValues = this.triangleSkinValues;
      var1.vertexGroups = this.vertexGroups;
      var1.field1758 = this.field1758;
      var1.normals = this.normals;
      var1.faceNormals = this.faceNormals;
      var1.field1731 = this.field1731;
      var1.contrast = this.contrast;
      return var1;
   }

   public ModelData method2601(final int[][] var1, final int var2, final int var3, final int var4, final int var6) {
      this.method2641();
      int var7 = var2 + this.field1761;
      int var8 = var2 + this.field1762;
      int var9 = var4 + this.field1764;
      int var10 = var4 + this.field1763;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
            return this;
         } else {
            final ModelData var11 = new ModelData();
            var11.vertexCount = this.vertexCount;
            var11.triangleFaceCount = this.triangleFaceCount;
            var11.field1738 = this.field1738;
            var11.vertexX = this.vertexX;
            var11.vertexZ = this.vertexZ;
            var11.trianglePointsX = this.trianglePointsX;
            var11.trianglePointsY = this.trianglePointsY;
            var11.trianglePointsZ = this.trianglePointsZ;
            var11.faceRenderTypes = this.faceRenderTypes;
            var11.faceRenderPriorities = this.faceRenderPriorities;
            var11.faceAlphas = this.faceAlphas;
            var11.textureCoords = this.textureCoords;
            var11.faceColor = this.faceColor;
            var11.faceTextures = this.faceTextures;
            var11.priority = this.priority;
            var11.textureRenderTypes = this.textureRenderTypes;
            var11.texTriangleX = this.texTriangleX;
            var11.texTriangleY = this.texTriangleY;
            var11.texTriangleZ = this.texTriangleZ;
            var11.field1743 = this.field1743;
            var11.field1745 = this.field1745;
            var11.field1740 = this.field1740;
            var11.field1746 = this.field1746;
            var11.field1749 = this.field1749;
            var11.field1747 = this.field1747;
            var11.texturePrimaryColor = this.texturePrimaryColor;
            var11.vertexSkins = this.vertexSkins;
            var11.triangleSkinValues = this.triangleSkinValues;
            var11.vertexGroups = this.vertexGroups;
            var11.field1758 = this.field1758;
            var11.field1731 = this.field1731;
            var11.contrast = this.contrast;
            var11.vertexY = new int[var11.vertexCount];
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
            if(var6 == 0) {
               for(var12 = 0; var12 < var11.vertexCount; ++var12) {
                  var13 = var2 + this.vertexX[var12];
                  var14 = var4 + this.vertexZ[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.vertexY[var12] = var21 + this.vertexY[var12] - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.vertexCount; ++var12) {
                  var13 = (-this.vertexY[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = var2 + this.vertexX[var12];
                     var15 = var4 + this.vertexZ[var12];
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                     final int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.vertexY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.vertexY[var12];
                  }
               }
            }

            var11.method2617();
            return var11;
         }
      } else {
         return this;
      }
   }

   private void computeAnimationTables() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.vertexSkins != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.vertexCount; ++var3) {
            var4 = this.vertexSkins[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.vertexGroups = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.vertexGroups[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.vertexCount; this.vertexGroups[var4][var1[var4]++] = var3++) {
            var4 = this.vertexSkins[var3];
         }

         this.vertexSkins = null;
      }

      if(this.triangleSkinValues != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.triangleFaceCount; ++var3) {
            var4 = this.triangleSkinValues[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1758 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1758[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.triangleFaceCount; this.field1758[var4][var1[var4]++] = var3++) {
            var4 = this.triangleSkinValues[var3];
         }

         this.triangleSkinValues = null;
      }

   }

   public void method2607() {
      for(int var1 = 0; var1 < this.vertexCount; ++var1) {
         final int var2 = this.vertexX[var1];
         this.vertexX[var1] = this.vertexZ[var1];
         this.vertexZ[var1] = -var2;
      }

      this.method2617();
   }

   public void method2625() {
      for(int var1 = 0; var1 < this.vertexCount; ++var1) {
         this.vertexX[var1] = -this.vertexX[var1];
         this.vertexZ[var1] = -this.vertexZ[var1];
      }

      this.method2617();
   }

   public void method2610() {
      for(int var1 = 0; var1 < this.vertexCount; ++var1) {
         final int var2 = this.vertexZ[var1];
         this.vertexZ[var1] = this.vertexX[var1];
         this.vertexX[var1] = -var2;
      }

      this.method2617();
   }

   public void method2606(final int var1) {
      final int var2 = field1768[var1];
      final int var3 = field1757[var1];

      for(int var4 = 0; var4 < this.vertexCount; ++var4) {
         final int var5 = var2 * this.vertexZ[var4] + var3 * this.vertexX[var4] >> 16;
         this.vertexZ[var4] = var3 * this.vertexZ[var4] - var2 * this.vertexX[var4] >> 16;
         this.vertexX[var4] = var5;
      }

      this.method2617();
   }

   public void method2611(final int var1, final int var2, final int var3) {
      for(int var4 = 0; var4 < this.vertexCount; ++var4) {
         this.vertexX[var4] += var1;
         this.vertexY[var4] += var2;
         this.vertexZ[var4] += var3;
      }

      this.method2617();
   }

   public void recolor(final short var1, final short var2) {
      for(int var3 = 0; var3 < this.triangleFaceCount; ++var3) {
         if(this.faceColor[var3] == var1) {
            this.faceColor[var3] = var2;
         }
      }

   }

   public void method2613(final short var1, final short var2) {
      if(this.faceTextures != null) {
         for(int var3 = 0; var3 < this.triangleFaceCount; ++var3) {
            if(this.faceTextures[var3] == var1) {
               this.faceTextures[var3] = var2;
            }
         }

      }
   }

   public void method2614() {
      int var1;
      for(var1 = 0; var1 < this.vertexCount; ++var1) {
         this.vertexZ[var1] = -this.vertexZ[var1];
      }

      for(var1 = 0; var1 < this.triangleFaceCount; ++var1) {
         final int var2 = this.trianglePointsX[var1];
         this.trianglePointsX[var1] = this.trianglePointsZ[var1];
         this.trianglePointsZ[var1] = var2;
      }

      this.method2617();
   }

   public void method2615(final int var1, final int var2, final int var3) {
      for(int var4 = 0; var4 < this.vertexCount; ++var4) {
         this.vertexX[var4] = this.vertexX[var4] * var1 / 128;
         this.vertexY[var4] = var2 * this.vertexY[var4] / 128;
         this.vertexZ[var4] = var3 * this.vertexZ[var4] / 128;
      }

      this.method2617();
   }

   public void computeNormals() {
      if(this.normals == null) {
         this.normals = new VertexNormal[this.vertexCount];

         for(int vertexIdx = 0; vertexIdx < this.vertexCount; ++vertexIdx) {
            this.normals[vertexIdx] = new VertexNormal();
         }

         for(int faceIdx = 0; faceIdx < this.triangleFaceCount; ++faceIdx) {
            final int pointX = this.trianglePointsX[faceIdx];
            final int pointY = this.trianglePointsY[faceIdx];
            final int pointZ = this.trianglePointsZ[faceIdx];
            final int var5 = this.vertexX[pointY] - this.vertexX[pointX];
            final int var6 = this.vertexY[pointY] - this.vertexY[pointX];
            final int var7 = this.vertexZ[pointY] - this.vertexZ[pointX];
            final int var8 = this.vertexX[pointZ] - this.vertexX[pointX];
            final int var9 = this.vertexY[pointZ] - this.vertexY[pointX];
            final int var10 = this.vertexZ[pointZ] - this.vertexZ[pointX];
            int x = var6 * var10 - var9 * var7;
            int y = var7 * var8 - var10 * var5;

            int z;
            for(z = var5 * var9 - var8 * var6; x > 8192 || y > 8192 || z > 8192 || x < -8192 || y < -8192 || z < -8192; z >>= 1) {
               x >>= 1;
               y >>= 1;
            }

            int var14 = (int)Math.sqrt((x * x + y * y + z * z));
            if(var14 <= 0) {
               var14 = 1;
            }

            x = x * 256 / var14;
            y = y * 256 / var14;
            z = z * 256 / var14;
            final byte faceRenderType;
            if(this.faceRenderTypes == null) {
               faceRenderType = 0;
            } else {
               faceRenderType = this.faceRenderTypes[faceIdx];
            }

            if(faceRenderType == 0) {
               VertexNormal vertexNormal = this.normals[pointX];
               vertexNormal.x += x;
               vertexNormal.y += y;
               vertexNormal.z += z;
               ++vertexNormal.magnitude;
               vertexNormal = this.normals[pointY];
               vertexNormal.x += x;
               vertexNormal.y += y;
               vertexNormal.z += z;
               ++vertexNormal.magnitude;
               vertexNormal = this.normals[pointZ];
               vertexNormal.x += x;
               vertexNormal.y += y;
               vertexNormal.z += z;
               ++vertexNormal.magnitude;
            } else if(faceRenderType == 1) {
               if(this.faceNormals == null) {
                  this.faceNormals = new FaceNormal[this.triangleFaceCount];
               }

               final FaceNormal faceNormal = this.faceNormals[faceIdx] = new FaceNormal();
               faceNormal.x = x;
               faceNormal.y = y;
               faceNormal.z = z;
            }
         }

      }
   }

   private void method2617() {
      this.normals = null;
      this.field1756 = null;
      this.faceNormals = null;
      this.field1759 = false;
   }

   private void method2641() {
      if(!this.field1759) {
         super.modelHeight = 0;
         this.field1760 = 0;
         this.field1761 = 999999;
         this.field1762 = -999999;
         this.field1763 = -99999;
         this.field1764 = 99999;

         for(int vertexIdx = 0; vertexIdx < this.vertexCount; ++vertexIdx) {
            final int var2 = this.vertexX[vertexIdx];
            final int var3 = this.vertexY[vertexIdx];
            final int var4 = this.vertexZ[vertexIdx];
            if(var2 < this.field1761) {
               this.field1761 = var2;
            }

            if(var2 > this.field1762) {
               this.field1762 = var2;
            }

            if(var4 < this.field1764) {
               this.field1764 = var4;
            }

            if(var4 > this.field1763) {
               this.field1763 = var4;
            }

            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1760) {
               this.field1760 = var3;
            }
         }

         this.field1759 = true;
      }
   }

   public final Model light(final int var1, final int var2, final int var3, final int var4, final int var5) {
      this.computeNormals();
      final int var6 = (int)Math.sqrt((var5 * var5 + var3 * var3 + var4 * var4));
      final int var7 = var6 * var2 >> 8;
      final Model model = new Model();
      model.field1852 = new int[this.triangleFaceCount];
      model.field1861 = new int[this.triangleFaceCount];
      model.field1862 = new int[this.triangleFaceCount];
      if(this.field1738 > 0 && this.textureCoords != null) {
         final int[] var9 = new int[this.field1738];

         int var10;
         for(var10 = 0; var10 < this.triangleFaceCount; ++var10) {
            if(this.textureCoords[var10] != -1) {
               ++var9[this.textureCoords[var10] & 255];
            }
         }

         model.field1866 = 0;

         for(var10 = 0; var10 < this.field1738; ++var10) {
            if(var9[var10] > 0 && this.textureRenderTypes[var10] == 0) {
               ++model.field1866;
            }
         }

         model.field1869 = new int[model.field1866];
         model.field1868 = new int[model.field1866];
         model.field1871 = new int[model.field1866];
         var10 = 0;

         for(int var11 = 0; var11 < this.field1738; ++var11) {
            if(var9[var11] > 0 && this.textureRenderTypes[var11] == 0) {
               model.field1869[var10] = this.texTriangleX[var11] & '\uffff';
               model.field1868[var10] = this.texTriangleY[var11] & '\uffff';
               model.field1871[var10] = this.texTriangleZ[var11] & '\uffff';
               var9[var11] = var10++;
            } else {
               var9[var11] = -1;
            }
         }

         model.field1865 = new byte[this.triangleFaceCount];

         for(int var11 = 0; var11 < this.triangleFaceCount; ++var11) {
            if(this.textureCoords[var11] != -1) {
               model.field1865[var11] = (byte)var9[this.textureCoords[var11] & 255];
            } else {
               model.field1865[var11] = -1;
            }
         }
      }

      for(int faceIdx = 0; faceIdx < this.triangleFaceCount; ++faceIdx) {
         byte faceRenderType;
         if(this.faceRenderTypes == null) {
            faceRenderType = 0;
         } else {
            faceRenderType = this.faceRenderTypes[faceIdx];
         }

         final byte faceAlpha;
         if(this.faceAlphas == null) {
            faceAlpha = 0;
         } else {
            faceAlpha = this.faceAlphas[faceIdx];
         }

         final short faceTexture;
         if(this.faceTextures == null) {
            faceTexture = -1;
         } else {
            faceTexture = this.faceTextures[faceIdx];
         }

         if(faceAlpha == -2) {
            faceRenderType = 3;
         }

         if(faceAlpha == -1) {
            faceRenderType = 2;
         }

         VertexNormal vertexNormal;
         int var14;
         final FaceNormal faceNormal;
         if(faceTexture == -1) {
            if(faceRenderType != 0) {
               if(faceRenderType == 1) {
                  faceNormal = this.faceNormals[faceIdx];
                  var14 = (var4 * faceNormal.y + var5 * faceNormal.z + var3 * faceNormal.x) / (var7 / 2 + var7) + var1;
                  model.field1852[faceIdx] = method2630(this.faceColor[faceIdx] & '\uffff', var14);
                  model.field1862[faceIdx] = -1;
               } else if(faceRenderType == 3) {
                  model.field1852[faceIdx] = 128;
                  model.field1862[faceIdx] = -1;
               } else {
                  model.field1862[faceIdx] = -2;
               }
            } else {
               final int var15 = this.faceColor[faceIdx] & '\uffff';
               if(this.field1756 != null && this.field1756[this.trianglePointsX[faceIdx]] != null) {
                  vertexNormal = this.field1756[this.trianglePointsX[faceIdx]];
               } else {
                  vertexNormal = this.normals[this.trianglePointsX[faceIdx]];
               }

               var14 = (var4 * vertexNormal.y + var5 * vertexNormal.z + var3 * vertexNormal.x) / (var7 * vertexNormal.magnitude) + var1;
               model.field1852[faceIdx] = method2630(var15, var14);
               if(this.field1756 != null && this.field1756[this.trianglePointsY[faceIdx]] != null) {
                  vertexNormal = this.field1756[this.trianglePointsY[faceIdx]];
               } else {
                  vertexNormal = this.normals[this.trianglePointsY[faceIdx]];
               }

               var14 = (var4 * vertexNormal.y + var5 * vertexNormal.z + var3 * vertexNormal.x) / (var7 * vertexNormal.magnitude) + var1;
               model.field1861[faceIdx] = method2630(var15, var14);
               if(this.field1756 != null && this.field1756[this.trianglePointsZ[faceIdx]] != null) {
                  vertexNormal = this.field1756[this.trianglePointsZ[faceIdx]];
               } else {
                  vertexNormal = this.normals[this.trianglePointsZ[faceIdx]];
               }

               var14 = (var4 * vertexNormal.y + var5 * vertexNormal.z + var3 * vertexNormal.x) / (var7 * vertexNormal.magnitude) + var1;
               model.field1862[faceIdx] = method2630(var15, var14);
            }
         } else if(faceRenderType != 0) {
            if(faceRenderType == 1) {
               faceNormal = this.faceNormals[faceIdx];
               var14 = (var4 * faceNormal.y + var5 * faceNormal.z + var3 * faceNormal.x) / (var7 / 2 + var7) + var1;
               model.field1852[faceIdx] = method2622(var14);
               model.field1862[faceIdx] = -1;
            } else {
               model.field1862[faceIdx] = -2;
            }
         } else {
            if(this.field1756 != null && this.field1756[this.trianglePointsX[faceIdx]] != null) {
               vertexNormal = this.field1756[this.trianglePointsX[faceIdx]];
            } else {
               vertexNormal = this.normals[this.trianglePointsX[faceIdx]];
            }

            var14 = (var4 * vertexNormal.y + var5 * vertexNormal.z + var3 * vertexNormal.x) / (var7 * vertexNormal.magnitude) + var1;
            model.field1852[faceIdx] = method2622(var14);
            if(this.field1756 != null && this.field1756[this.trianglePointsY[faceIdx]] != null) {
               vertexNormal = this.field1756[this.trianglePointsY[faceIdx]];
            } else {
               vertexNormal = this.normals[this.trianglePointsY[faceIdx]];
            }

            var14 = (var4 * vertexNormal.y + var5 * vertexNormal.z + var3 * vertexNormal.x) / (var7 * vertexNormal.magnitude) + var1;
            model.field1861[faceIdx] = method2622(var14);
            if(this.field1756 != null && this.field1756[this.trianglePointsZ[faceIdx]] != null) {
               vertexNormal = this.field1756[this.trianglePointsZ[faceIdx]];
            } else {
               vertexNormal = this.normals[this.trianglePointsZ[faceIdx]];
            }

            var14 = (var4 * vertexNormal.y + var5 * vertexNormal.z + var3 * vertexNormal.x) / (var7 * vertexNormal.magnitude) + var1;
            model.field1862[faceIdx] = method2622(var14);
         }
      }

      this.computeAnimationTables();
      model.verticesCount = this.vertexCount;
      model.verticesX = this.vertexX;
      model.verticesY = this.vertexY;
      model.verticesZ = this.vertexZ;
      model.indicesCount = this.triangleFaceCount;
      model.indices1 = this.trianglePointsX;
      model.indices2 = this.trianglePointsY;
      model.indices3 = this.trianglePointsZ;
      model.faceRenderPriorities = this.faceRenderPriorities;
      model.faceAplhas = this.faceAlphas;
      model.priority = this.priority;
      model.vertexGroups = this.vertexGroups;
      model.field1890 = this.field1758;
      model.faceTextures = this.faceTextures;
      return model;
   }

   public static ModelData method2645(final IndexDataBase var0, final int var1, final int var2) {
      final byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new ModelData(var3);
   }

   static void method2608(final ModelData var0, final ModelData var1, final int var2, final int var3, final int var4, final boolean var5) {
      var0.method2641();
      var0.computeNormals();
      var1.method2641();
      var1.computeNormals();
      ++field1724;
      int var6 = 0;
      final int[] var7 = var1.vertexX;
      final int var8 = var1.vertexCount;

      int var9;
      for(var9 = 0; var9 < var0.vertexCount; ++var9) {
         final VertexNormal var10 = var0.normals[var9];
         if(var10.magnitude != 0) {
            final int var11 = var0.vertexY[var9] - var3;
            if(var11 <= var1.field1760) {
               final int var12 = var0.vertexX[var9] - var2;
               if(var12 >= var1.field1761 && var12 <= var1.field1762) {
                  final int var13 = var0.vertexZ[var9] - var4;
                  if(var13 >= var1.field1764 && var13 <= var1.field1763) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        final VertexNormal var15 = var1.normals[var14];
                        if(var12 == var7[var14] && var13 == var1.vertexZ[var14] && var11 == var1.vertexY[var14] && var15.magnitude != 0) {
                           if(var0.field1756 == null) {
                              var0.field1756 = new VertexNormal[var0.vertexCount];
                           }

                           if(var1.field1756 == null) {
                              var1.field1756 = new VertexNormal[var8];
                           }

                           VertexNormal var16 = var0.field1756[var9];
                           if(var16 == null) {
                              var16 = var0.field1756[var9] = new VertexNormal(var10);
                           }

                           VertexNormal var17 = var1.field1756[var14];
                           if(var17 == null) {
                              var17 = var1.field1756[var14] = new VertexNormal(var15);
                           }

                           var16.x += var15.x;
                           var16.y += var15.y;
                           var16.z += var15.z;
                           var16.magnitude += var15.magnitude;
                           var17.x += var10.x;
                           var17.y += var10.y;
                           var17.z += var10.z;
                           var17.magnitude += var10.magnitude;
                           ++var6;
                           field1765[var9] = field1724;
                           field1753[var14] = field1724;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.triangleFaceCount; ++var9) {
            if(field1765[var0.trianglePointsX[var9]] == field1724 && field1765[var0.trianglePointsY[var9]] == field1724 && field1765[var0.trianglePointsZ[var9]] == field1724) {
               if(var0.faceRenderTypes == null) {
                  var0.faceRenderTypes = new byte[var0.triangleFaceCount];
               }

               var0.faceRenderTypes[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.triangleFaceCount; ++var9) {
            if(field1724 == field1753[var1.trianglePointsX[var9]] && field1724 == field1753[var1.trianglePointsY[var9]] && field1724 == field1753[var1.trianglePointsZ[var9]]) {
               if(var1.faceRenderTypes == null) {
                  var1.faceRenderTypes = new byte[var1.triangleFaceCount];
               }

               var1.faceRenderTypes[var9] = 2;
            }
         }

      }
   }

   private static int method2630(final int var0, int var1) {
      var1 = (var0 & 127) * var1 >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 65408) + var1;
   }

   private static int method2622(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }
}
