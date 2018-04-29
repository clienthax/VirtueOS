package com.oldscape.client;

public class Nameable implements Comparable {
   Name currentName;
   Name previousName;

   Name getCurrentName() {
      return this.currentName;
   }

   String getCurrentNameString() {
      return this.currentName == null?"":this.currentName.getName();
   }

   String getPreviousNameString() {
      return this.previousName == null?"":this.previousName.getName();
   }

   void method5264(final Name currentName, final Name previousName) {
      if(currentName == null) {
         throw new NullPointerException();
      } else {
         this.currentName = currentName;
         this.previousName = previousName;
      }
   }

   public int doCompare(final Nameable var1) {
      return this.currentName.compareCleanName(var1.currentName);
   }

   public int compareTo(final Object var1) {
      return this.doCompare((Nameable)var1);
   }

}
