package com.oldscape.client;

import java.util.Random;

class MachineInfo extends Node {
   private final int osType;
   private final boolean os64Bit;
   private int osVersionType;
   private final int javaVendorType;
   private final int javaVersionMajor;
   private final int javaVersionMinor;
   private final int javaVersionPatch;
   private final boolean field4082;
   private final int maxMemoryMB;
   private final int availableProcessors;
   private final int field4101;
   private int field4114;
   private String field4103;
   private String field4104;
   private String field4105;
   private String field4106;
   private int field4107;
   private int field4111;
   private int field4109;
   private int field4110;
   private String field4087;
   private String field4112;
   private final int[] field4113;
   private int field4085;

   public MachineInfo(final boolean var1) {
      this.field4113 = new int[3];
      if(Signlink.osNameLC.startsWith("win")) {
         this.osType = 1;
      } else if(Signlink.osNameLC.startsWith("mac")) {
         this.osType = 2;
      } else if(Signlink.osNameLC.startsWith("linux")) {
         this.osType = 3;
      } else {
         this.osType = 4;
      }

      String var2;
      try {
         var2 = System.getProperty("os.arch").toLowerCase();
      } catch (final Exception var13) {
         var2 = "";
      }

      String var3;
      try {
         var3 = System.getProperty("os.version").toLowerCase();
      } catch (final Exception var12) {
         var3 = "";
      }

      String var4 = "Unknown";
      String var5 = "1.1";

      try {
         var4 = System.getProperty("java.vendor");
         var5 = System.getProperty("java.version");
      } catch (final Exception ignored) {
      }

      this.os64Bit = var2.startsWith("amd64") || var2.startsWith("x86_64");

      if(this.osType == 1) {
         if(var3.contains("4.0")) {
            this.osVersionType = 1;
         } else if(var3.contains("4.1")) {
            this.osVersionType = 2;
         } else if(var3.contains("4.9")) {
            this.osVersionType = 3;
         } else if(var3.contains("5.0")) {
            this.osVersionType = 4;
         } else if(var3.contains("5.1")) {
            this.osVersionType = 5;
         } else if(var3.contains("5.2")) {
            this.osVersionType = 8;
         } else if(var3.contains("6.0")) {
            this.osVersionType = 6;
         } else if(var3.contains("6.1")) {
            this.osVersionType = 7;
         } else if(var3.contains("6.2")) {
            this.osVersionType = 9;
         } else if(var3.contains("6.3")) {
            this.osVersionType = 10;
         } else if(var3.contains("10.0")) {
            this.osVersionType = 11;
         }
      } else if(this.osType == 2) {
         if(var3.contains("10.4")) {
            this.osVersionType = 20;
         } else if(var3.contains("10.5")) {
            this.osVersionType = 21;
         } else if(var3.contains("10.6")) {
            this.osVersionType = 22;
         } else if(var3.contains("10.7")) {
            this.osVersionType = 23;
         } else if(var3.contains("10.8")) {
            this.osVersionType = 24;
         } else if(var3.contains("10.9")) {
            this.osVersionType = 25;
         } else if(var3.contains("10.10")) {
            this.osVersionType = 26;
         } else if(var3.contains("10.11")) {
            this.osVersionType = 27;
         }
      }

      if(var4.toLowerCase().contains("sun")) {
         this.javaVendorType = 1;
      } else if(var4.toLowerCase().contains("microsoft")) {
         this.javaVendorType = 2;
      } else if(var4.toLowerCase().contains("apple")) {
         this.javaVendorType = 3;
      } else if(var4.toLowerCase().contains("oracle")) {
         this.javaVendorType = 5;
      } else {
         this.javaVendorType = 4;
      }

      int var9 = 2;
      int var7 = 0;

      char var8;
      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < '0' || var8 > '9') {
               break;
            }

            var7 = var7 * 10 + (var8 - '0');
            ++var9;
         }
      } catch (final Exception ignored) {
      }

      this.javaVersionMajor = var7;
      var9 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < '0' || var8 > '9') {
               break;
            }

            var7 = var8 - '0' + var7 * 10;
            ++var9;
         }
      } catch (final Exception ignored) {
      }

      this.javaVersionMinor = var7;
      var9 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < '0' || var8 > '9') {
               break;
            }

            var7 = var8 - '0' + var7 * 10;
            ++var9;
         }
      } catch (final Exception ignored) {
      }

      this.javaVersionPatch = var7;
      this.field4082 = false;
      Runtime.getRuntime();
      this.maxMemoryMB = (int)(((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.javaVersionMajor > 3) {
         this.availableProcessors = Runtime.getRuntime().availableProcessors();
      } else {
         this.availableProcessors = 0;
      }

      this.field4101 = 0;
      if(this.field4103 == null) {
         this.field4103 = "";
      }

      if(this.field4104 == null) {
         this.field4104 = "";
      }

      if(this.field4105 == null) {
         this.field4105 = "";
      }

      if(this.field4106 == null) {
         this.field4106 = "";
      }

      if(this.field4087 == null) {
         this.field4087 = "";
      }

      if(this.field4112 == null) {
         this.field4112 = "";
      }

      this.method6187();
   }

   private void method6187() {
      if(this.field4103.length() > 40) {
         this.field4103 = this.field4103.substring(0, 40);
      }

      if(this.field4104.length() > 40) {
         this.field4104 = this.field4104.substring(0, 40);
      }

      if(this.field4105.length() > 10) {
         this.field4105 = this.field4105.substring(0, 10);
      }

      if(this.field4106.length() > 10) {
         this.field4106 = this.field4106.substring(0, 10);
      }

   }

   public void method6183(final Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.osType);
      var1.putByte(this.os64Bit?1:0);
      var1.putByte(this.osVersionType);
      var1.putByte(this.javaVendorType);
      var1.putByte(this.javaVersionMajor);
      var1.putByte(this.javaVersionMinor);
      var1.putByte(this.javaVersionPatch);
      var1.putByte(this.field4082?1:0);
      var1.putShort(this.maxMemoryMB);
      var1.putByte(this.availableProcessors);
      var1.put24bitInt(this.field4101);
      var1.putShort(this.field4114);
      var1.putJagString(this.field4103);
      var1.putJagString(this.field4104);
      var1.putJagString(this.field4105);
      var1.putJagString(this.field4106);
      var1.putByte(this.field4111);
      var1.putShort(this.field4107);
      var1.putJagString(this.field4087);
      var1.putJagString(this.field4112);
      var1.putByte(this.field4109);
      var1.putByte(this.field4110);

       for (final int aField4113 : this.field4113) {
           var1.putInt(aField4113);
       }

      var1.putInt(this.field4085);
   }

   public int method6184() {
      final byte var1 = 38;
      int var2 = var1 + class19.method167(this.field4103);
      var2 += class19.method167(this.field4104);
      var2 += class19.method167(this.field4105);
      var2 += class19.method167(this.field4106);
      var2 += class19.method167(this.field4087);
      var2 += class19.method167(this.field4112);
      return var2;
   }
}
