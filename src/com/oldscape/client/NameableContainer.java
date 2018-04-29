package com.oldscape.client;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

abstract class NameableContainer {
   final int field3838;
   private int count;
   private final Nameable[] nameables;
   private final HashMap<Name, Nameable> field3837;
   private final HashMap<Name, Nameable> field3840;
   private Comparator field3842;

   NameableContainer(final int var1) {
      this.count = 0;
      this.field3842 = null;
      this.field3838 = var1;
      this.nameables = this.vmethod5462(var1);
      this.field3837 = new HashMap<>(var1 / 8);
      this.field3840 = new HashMap<>(var1 / 8);
   }

   abstract Nameable vmethod5454();

   abstract Nameable[] vmethod5462(int var1);

   public void method5302() {
      this.count = 0;
      Arrays.fill(this.nameables, null);
      this.field3837.clear();
      this.field3840.clear();
   }

   public int getCount() {
      return this.count;
   }

   public boolean method5305() {
      return this.field3838 == this.count;
   }

   public boolean isMember(final Name var1) {
      return var1.isCleanNameValid() && (this.field3837.containsKey(var1) || this.field3840.containsKey(var1));
   }

   public Nameable method5307(final Name var1) {
      final Nameable var2 = this.method5327(var1);
      return var2 != null?var2:this.method5309(var1);
   }

   Nameable method5327(final Name var1) {
      return !var1.isCleanNameValid()?null: this.field3837.get(var1);
   }

   private Nameable method5309(final Name var1) {
      return !var1.isCleanNameValid()?null: this.field3840.get(var1);
   }

   public final boolean method5344(final Name var1) {
      final Nameable nameable = this.method5327(var1);
      if(nameable == null) {
         return false;
      } else {
         this.method5311(nameable);
         return true;
      }
   }

   final void method5311(final Nameable nameable) {
      final int var2 = this.method5317(nameable);
      if(var2 != -1) {
         this.method5328(var2);
         this.method5318(nameable);
      }
   }

   Nameable method5312(final Name var1) {
      return this.method5313(var1, null);
   }

   Nameable method5313(final Name var1, final Name var2) {
      if(this.method5327(var1) != null) {
         throw new IllegalStateException();
      } else {
         final Nameable var3 = this.vmethod5454();
         var3.method5264(var1, var2);
         this.method5349(var3);
         this.method5320(var3);
         return var3;
      }
   }

   public final Nameable get(final int var1) {
      if(var1 >= 0 && var1 < this.count) {
         return this.nameables[var1];
      } else {
         throw new ArrayIndexOutOfBoundsException(var1);
      }
   }

   public final void method5331() {
      if(this.field3842 == null) {
         Arrays.sort(this.nameables, 0, this.count);
      } else {
         Arrays.sort(this.nameables, 0, this.count, this.field3842);
      }

   }

   final void method5316(final Nameable nameable, final Name currentName, final Name previousName) {
      this.method5318(nameable);
      nameable.method5264(currentName, previousName);
      this.method5320(nameable);
   }

   private int method5317(final Nameable nameable) {
      for(int var2 = 0; var2 < this.count; ++var2) {
         if(this.nameables[var2] == nameable) {
            return var2;
         }
      }

      return -1;
   }

   private void method5318(final Nameable nameable) {
      if(this.field3837.remove(nameable.currentName) == null) {
         throw new IllegalStateException();
      } else {
         if(nameable.previousName != null) {
            this.field3840.remove(nameable.previousName);
         }

      }
   }

   private void method5349(final Nameable nameable) {
      this.nameables[this.count++] = nameable;
   }

   private void method5320(final Nameable nameable) {
      this.field3837.put(nameable.currentName, nameable);
      if(nameable.previousName != null) {
         final Nameable var2 = this.field3840.put(nameable.previousName, nameable);
         if(var2 != null && var2 != nameable) {
            var2.previousName = null;
         }
      }

   }

   private void method5328(final int var1) {
      --this.count;
      if(var1 < this.count) {
         System.arraycopy(this.nameables, var1 + 1, this.nameables, var1, this.count - var1);
      }

   }

   public final void method5323() {
      this.field3842 = null;
   }

   public final void method5324(final Comparator var1) {
      if(this.field3842 == null) {
         this.field3842 = var1;
      } else if(this.field3842 instanceof class297) {
         ((class297)this.field3842).method5283(var1);
      }

   }
}
