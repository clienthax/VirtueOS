package com.oldscape.client;

public class WorldMapType4 implements WorldMapSectionBase {
   static FileRequest currentRequest;
   static SpritePixels[] mapDots;
   private int field599;
   private int field597;
   private int field598;
   private int field608;
   private int field600;
   private int field596;
   private int field602;
   private int field603;
   private int field604;
   private int field605;

   public void vmethod767(final WorldMapData worldMapData) {
      if(worldMapData.minX > this.field600) {
         worldMapData.minX = this.field600;
      }

      if(worldMapData.maxX < this.field600) {
         worldMapData.maxX = this.field600;
      }

      if(worldMapData.minY > this.field596) {
         worldMapData.minY = this.field596;
      }

      if(worldMapData.maxY < this.field596) {
         worldMapData.maxY = this.field596;
      }

   }

   public boolean containsCoord(final int plane, final int worldX, final int worldY) {
      return (plane >= this.field599 && plane < this.field599 + this.field597) && (worldX >= (this.field598 << 6) + (this.field602 << 3) && worldX <= (this.field598 << 6) + (this.field602 << 3) + 7 && worldY >= (this.field608 << 6) + (this.field603 << 3) && worldY <= (this.field608 << 6) + (this.field603 << 3) + 7);
   }

   public boolean vmethod768(final int worldX, final int worldY) {
      return worldX >= (this.field600 << 6) + (this.field604 << 3) && worldX <= (this.field600 << 6) + (this.field604 << 3) + 7 && worldY >= (this.field596 << 6) + (this.field605 << 3) && worldY <= (this.field596 << 6) + (this.field605 << 3) + 7;
   }

   public int[] vmethod753(final int plane, final int worldX, final int worldY) {
      if(!this.containsCoord(plane, worldX, worldY)) {
         return null;
      } else {
          return new int[]{this.field600 * 64 - this.field598 * 64 + worldX + (this.field604 * 8 - this.field602 * 8), worldY + (this.field596 * 64 - this.field608 * 64) + (this.field605 * 8 - this.field603 * 8)};
      }
   }

   public Coordinates vmethod758(final int var1, final int var2) {
      if(!this.vmethod768(var1, var2)) {
         return null;
      } else {
         final int var3 = this.field598 * 64 - this.field600 * 64 + (this.field602 * 8 - this.field604 * 8) + var1;
         final int var4 = this.field608 * 64 - this.field596 * 64 + var2 + (this.field603 * 8 - this.field605 * 8);
         return new Coordinates(this.field599, var3, var4);
      }
   }

   public void decode(final Buffer var1) {
      this.field599 = var1.readUnsignedByte();
      this.field597 = var1.readUnsignedByte();
      this.field598 = var1.readUnsignedShort();
      this.field602 = var1.readUnsignedByte();
      this.field608 = var1.readUnsignedShort();
      this.field603 = var1.readUnsignedByte();
      this.field600 = var1.readUnsignedShort();
      this.field604 = var1.readUnsignedByte();
      this.field596 = var1.readUnsignedShort();
      this.field605 = var1.readUnsignedByte();
      this.method756();
   }

   private void method756() {
   }

   static void method755() {
      final int playerIndexesCount = class93.playerIndexesCount;
      final int[] playerIndices = class93.playerIndices;

      for(int var2 = 0; var2 < playerIndexesCount; ++var2) {
         if(playerIndices[var2] != Client.field1112 && playerIndices[var2] != Client.localInteractingIndex) {
            WorldMapManager.method627(Client.cachedPlayers[playerIndices[var2]], true);
         }
      }

   }
}
