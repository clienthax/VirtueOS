package com.oldscape.client;

public class AbstractSoundSystem {
   static int sampleRate;
   static boolean audioHighMemory;
   static int field1583;
   static ISoundTaskDataProvider soundTaskDataProvider;
   static int[] field1585;
   int[] samples;
   private TaskDataNode field1586;
   private final int field1567;
   private long field1568;
   int offset;
   int field1570;
   private int field1561;
   private long field1572;
   private int field1573;
   private int field1569;
   private int field1574;
   private long field1576;
   private boolean field1577;
   private int field1579;
   private final TaskDataNode[] field1580;
   private final TaskDataNode[] field1571;

   AbstractSoundSystem() {
      this.field1567 = 32;
      this.field1568 = class64.method1118();
      this.field1572 = 0L;
      this.field1573 = 0;
      this.field1569 = 0;
      this.field1574 = 0;
      this.field1576 = 0L;
      this.field1577 = true;
      this.field1579 = 0;
      this.field1580 = new TaskDataNode[8];
      this.field1571 = new TaskDataNode[8];
   }

   void vmethod2247() throws Exception {
   }

   void create(final int var1) throws Exception {
   }

   int size() throws Exception {
      return this.offset;
   }

   void write() throws Exception {
   }

   void close() {
   }

   void flush() throws Exception {
   }

   public final synchronized void method2206(final TaskDataNode var1) {
      this.field1586 = var1;
   }

   public final synchronized void method2197() {
      if(this.samples != null) {
         long var1 = class64.method1118();

         try {
            if(this.field1572 != 0L) {
               if(var1 < this.field1572) {
                  return;
               }

               this.create(this.offset);
               this.field1572 = 0L;
               this.field1577 = true;
            }

            int var3 = this.size();
            if(this.field1574 - var3 > this.field1573) {
               this.field1573 = this.field1574 - var3;
            }

            int var4 = this.field1561 + this.field1570;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.offset) {
               this.offset += 1024;
               if(this.offset > 16384) {
                  this.offset = 16384;
               }

               this.close();
               this.create(this.offset);
               var3 = 0;
               this.field1577 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1561 = var4 - this.field1570;
               }
            }

            while(var3 < var4) {
               this.method2226(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1576) {
               if(!this.field1577) {
                  if(this.field1573 == 0 && this.field1569 == 0) {
                     this.close();
                     this.field1572 = var1 + 2000L;
                     return;
                  }

                  this.field1561 = Math.min(this.field1569, this.field1573);
                  this.field1569 = this.field1573;
               } else {
                  this.field1577 = false;
               }

               this.field1573 = 0;
               this.field1576 = 2000L + var1;
            }

            this.field1574 = var3;
         } catch (final Exception var7) {
            this.close();
            this.field1572 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1568) {
               var1 = this.field1568;
            }

            while(var1 > 5000L + this.field1568) {
               this.method2201(256);
               this.field1568 += (256000 / sampleRate);
            }
         } catch (final Exception var6) {
            this.field1568 = var1;
         }

      }
   }

   public final void method2214() {
      this.field1577 = true;
   }

   public final synchronized void tryFlush() {
      this.field1577 = true;

      try {
         this.flush();
      } catch (final Exception var2) {
         this.close();
         this.field1572 = class64.method1118() + 2000L;
      }

   }

   public final synchronized void shutdown() {
      if(WidgetNode.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == WidgetNode.task.systems[var2]) {
               WidgetNode.task.systems[var2] = null;
            }

            if(WidgetNode.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class316.scheduledExecutorService.shutdownNow();
            class316.scheduledExecutorService = null;
            WidgetNode.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   private void method2201(final int var1) {
      this.field1579 -= var1;
      if(this.field1579 < 0) {
         this.field1579 = 0;
      }

      if(this.field1586 != null) {
         this.field1586.vmethod4319(var1);
      }

   }

   private void method2226(final int[] var1, final int var2) {
      int var3 = var2;
      if(audioHighMemory) {
         var3 = var2 << 1;
      }

      class205.method3848(var1, 0, var3);
      this.field1579 -= var2;
      if(this.field1586 != null && this.field1579 <= 0) {
         this.field1579 += sampleRate >> 4;
         class55.method837(this.field1586);
         this.method2237(this.field1586, this.field1586.vmethod2491());
         int var4 = 0;
         int var5 = 255;

         int var6;
         TaskDataNode var10;
         label104:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  TaskDataNode var11 = this.field1580[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        final AbstractIntegerNode0 var12 = var11.data;
                        if(var12 != null && var12.int1 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1658;
                        } else {
                           var11.field1660 = true;
                           final int var13 = var11.vmethod4314();
                           var4 += var13;
                           if(var12 != null) {
                              var12.int1 += var13;
                           }

                           if(var4 >= this.field1567) {
                              break label104;
                           }

                           TaskDataNode var14 = var11.vmethod4330();
                           if(var14 != null) {
                              for(final int var15 = var11.field1659; var14 != null; var14 = var11.vmethod4321()) {
                                 this.method2237(var14, var15 * var14.vmethod2491() >> 8);
                              }
                           }

                           final TaskDataNode var18 = var11.field1658;
                           var11.field1658 = null;
                           if(var10 == null) {
                              this.field1580[var7] = var18;
                           } else {
                              var10.field1658 = var18;
                           }

                           if(var18 == null) {
                              this.field1571[var7] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            TaskDataNode var16 = this.field1580[var6];
            final TaskDataNode[] var17 = this.field1580;
            this.field1571[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1658;
               var16.field1658 = null;
            }
         }
      }

      if(this.field1579 < 0) {
         this.field1579 = 0;
      }

      if(this.field1586 != null) {
         this.field1586.vmethod4317(var1, 0, var2);
      }

      this.field1568 = class64.method1118();
   }

   private void method2237(final TaskDataNode var1, final int var2) {
      final int var3 = var2 >> 5;
      final TaskDataNode var4 = this.field1571[var3];
      if(var4 == null) {
         this.field1580[var3] = var1;
      } else {
         var4.field1658 = var1;
      }

      this.field1571[var3] = var1;
      var1.field1659 = var2;
   }

   public static void method2256(final ScriptEvent var0) {
      FloorUnderlayDefinition.runScript(var0, 500000);
   }

   static int method2246(final int var0, final int var1, final int var2, final int var3) {
      final int var4 = 65536 - Graphics3D.COSINE[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }
}
