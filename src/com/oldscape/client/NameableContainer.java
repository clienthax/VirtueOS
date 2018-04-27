package com.oldscape.client;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public abstract class NameableContainer {
   final int field3838;
   int count;
   Nameable[] nameables;
   HashMap field3837;
   HashMap field3840;
   Comparator field3842;

   NameableContainer(int var1) {
      this.count = 0;
      this.field3842 = null;
      this.field3838 = var1;
      this.nameables = this.vmethod5462(var1);
      this.field3837 = new HashMap(var1 / 8);
      this.field3840 = new HashMap(var1 / 8);
   }

   abstract Nameable vmethod5454();

   abstract Nameable[] vmethod5462(int var1);

   public void method5302() {
      this.count = 0;
      Arrays.fill(this.nameables, (Object)null);
      this.field3837.clear();
      this.field3840.clear();
   }

   public int getCount() {
      return this.count;
   }

   public boolean method5305() {
      return this.field3838 == this.count;
   }

   public boolean isMember(Name var1) {
      return !var1.isCleanNameValid()?false:(this.field3837.containsKey(var1)?true:this.field3840.containsKey(var1));
   }

   public Nameable method5307(Name var1) {
      Nameable var2 = this.method5327(var1);
      return var2 != null?var2:this.method5309(var1);
   }

   Nameable method5327(Name var1) {
      return !var1.isCleanNameValid()?null:(Nameable)this.field3837.get(var1);
   }

   Nameable method5309(Name var1) {
      return !var1.isCleanNameValid()?null:(Nameable)this.field3840.get(var1);
   }

   public final boolean method5344(Name var1) {
      Nameable var2 = this.method5327(var1);
      if(var2 == null) {
         return false;
      } else {
         this.method5311(var2);
         return true;
      }
   }

   final void method5311(Nameable var1) {
      int var2 = this.method5317(var1);
      if(var2 != -1) {
         this.method5328(var2);
         this.method5318(var1);
      }
   }

   Nameable method5312(Name var1) {
      return this.method5313(var1, (Name)null);
   }

   Nameable method5313(Name var1, Name var2) {
      if(this.method5327(var1) != null) {
         throw new IllegalStateException();
      } else {
         Nameable var3 = this.vmethod5454();
         var3.method5264(var1, var2);
         this.method5349(var3);
         this.method5320(var3);
         return var3;
      }
   }

   public final Nameable get(int var1) {
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

   final void method5316(Nameable var1, Name var2, Name var3) {
      this.method5318(var1);
      var1.method5264(var2, var3);
      this.method5320(var1);
   }

   final int method5317(Nameable var1) {
      for(int var2 = 0; var2 < this.count; ++var2) {
         if(this.nameables[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   final void method5318(Nameable var1) {
      if(this.field3837.remove(var1.name) == null) {
         throw new IllegalStateException();
      } else {
         if(var1.field3830 != null) {
            this.field3840.remove(var1.field3830);
         }

      }
   }

   final void method5349(Nameable var1) {
      this.nameables[++this.count - 1] = var1;
   }

   final void method5320(Nameable var1) {
      this.field3837.put(var1.name, var1);
      if(var1.field3830 != null) {
         Nameable var2 = (Nameable)this.field3840.put(var1.field3830, var1);
         if(var2 != null && var2 != var1) {
            var2.field3830 = null;
         }
      }

   }

   final void method5328(int var1) {
      --this.count;
      if(var1 < this.count) {
         System.arraycopy(this.nameables, var1 + 1, this.nameables, var1, this.count - var1);
      }

   }

   public final void method5323() {
      this.field3842 = null;
   }

   public final void method5324(Comparator var1) {
      if(this.field3842 == null) {
         this.field3842 = var1;
      } else if(this.field3842 instanceof class297) {
         ((class297)this.field3842).method5283(var1);
      }

   }
}
