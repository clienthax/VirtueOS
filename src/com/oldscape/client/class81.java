package com.oldscape.client;

import java.util.Calendar;

public class class81 {
   static int field1287;
   static int[] scriptLocalInts;
   static String[] scriptLocalStrings;
   static int[] field1282;
   static int[][] SHAPE_VERTICES;
   static int[] intStack;
   static String[] scriptStringStack;
   static int scriptStackCount;
   static ScriptState[] scriptStack;
   static Widget field1285;
   static Calendar calendar;
   static final String[] months;
   static int field1288;

   static {
      field1282 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      calendar = Calendar.getInstance();
      months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1288 = 0;
   }

   static char method1849(char var0) {
      return var0 != 181 && var0 != 131?Character.toTitleCase(var0):var0;
   }

   static void method1848(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(Client.method1503(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method1848(var0, var7 - 1, var2, var3, var4, var5);
         method1848(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
