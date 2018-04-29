package com.oldscape.client;

public class Coordinates {
   public int plane;
   public int x;
   public int y;

   public Coordinates(final Coordinates coordinates) {
      this.plane = coordinates.plane;
      this.x = coordinates.x;
      this.y = coordinates.y;
   }

   public Coordinates(final int plane, final int x, final int y) {
      this.plane = plane;
      this.x = x;
      this.y = y;
   }

   public Coordinates() {
      this.plane = -1;
   }

   public Coordinates(final int hash) {
      if(hash == -1) {
         this.plane = -1;
      } else {
         this.plane = hash >> 28 & 3;
         this.x = hash >> 14 & 16383;
         this.y = hash & 16383;
      }

   }

   public void set(final int plane, final int x, final int y) {
      this.plane = plane;
      this.x = x;
      this.y = y;
   }

   public int bitpack() {
      return this.plane << 28 | this.x << 14 | this.y;
   }

   private boolean isSame(final Coordinates coordinates) {
      return this.plane == coordinates.plane && (this.x == coordinates.x && this.y == coordinates.y);
   }

   private String method4360(final String var1) {
      return this.plane + var1 + (this.x >> 6) + var1 + (this.y >> 6) + var1 + (this.x & 63) + var1 + (this.y & 63);
   }

   public boolean equals(final Object var1) {
      return this == var1 || (var1 instanceof Coordinates && this.isSame((Coordinates) var1));
   }

   public String toString() {
      return this.method4360(",");
   }

   public int hashCode() {
      return this.bitpack();
   }
}
