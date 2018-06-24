package com.oldscape.client.reference;

import java.applet.Applet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class GrandExchangeEvents {
    static final Comparator field283;
    static final Comparator field290;
    static final Comparator field285;
    static final Comparator field288;
    static int field284;
    static int[] field287;

    static {
        field283 = new class19();
        new WorldComparator();
        field290 = new UnitPriceComparator();
        field285 = new class18();
        field288 = new TotalQuantityComparator();
    }

    final List<GrandExchangeEvent> events;

    public GrandExchangeEvents(final Buffer buffer) {
        final int var3 = buffer.readUnsignedShort();
        final boolean var4 = buffer.readUnsignedByte() == 1;
        final byte var5;
        if (var4) {
            var5 = 1;
        } else {
            var5 = 0;
        }

        final int var6 = buffer.readUnsignedShort();
        this.events = new ArrayList<>(var6);

        for (int var7 = 0; var7 < var6; ++var7) {
            this.events.add(new GrandExchangeEvent(buffer, var5, var3));
        }

    }

    static void method76(final Applet var0, final String var1) {
        class57.field674 = var0;
        if (var1 != null) {
            class57.field667 = var1;
        }

    }

    static void method72(String var0, final boolean var1) {
        var0 = var0.toLowerCase();
        short[] var2 = new short[16];
        int var3 = 0;

        for (int var4 = 0; var4 < AbstractSoundSystem.field1583; ++var4) {
            final ItemComposition item = ItemComposition.getItemDefinition(var4);
            if ((!var1 || item.isTradable) && item.notedTemplate == -1 && item.name.toLowerCase().contains(var0)) {
                if (var3 >= 250) {
                    class61.field737 = -1;
                    Preferences.field1248 = null;
                    return;
                }

                if (var3 >= var2.length) {
                    final short[] var6 = new short[var2.length * 2];

                    System.arraycopy(var2, 0, var6, 0, var3);

                    var2 = var6;
                }

                var2[var3++] = (short) var4;
            }
        }

        Preferences.field1248 = var2;
        class81.field1287 = 0;
        class61.field737 = var3;
        final String[] var8 = new String[class61.field737];

        for (int var9 = 0; var9 < class61.field737; ++var9) {
            var8[var9] = ItemComposition.getItemDefinition(var2[var9]).name;
        }

        final short[] var10 = Preferences.field1248;
        AbstractByteBuffer.method3757(var8, var10, 0, var8.length - 1);
    }

   /*
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class326.classInfos.last();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3947);

         for(int var3 = 0; var3 < var1.count; ++var3) {
            if(var1.errorIdentifiers[var3] != 0) {
               var0.putByte(var1.errorIdentifiers[var3]);
            } else {
               try {
                  int var4 = var1.type[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.putByte(0);
                     var0.putInt(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3951[var3]);
                     var0.putByte(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.putByte(0);
                     var0.putInt(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.putByte(0);
                        var0.putInt(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = Reflection.invoke(var25, (Object)null, var7);
                     if(var11 == null) {
                        var0.putByte(0);
                     } else if(var11 instanceof Number) {
                        var0.putByte(1);
                        var0.putLong(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.putByte(2);
                        var0.putString((String)var11);
                     } else {
                        var0.putByte(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.putByte(-10);
               } catch (InvalidClassException var14) {
                  var0.putByte(-11);
               } catch (StreamCorruptedException var15) {
                  var0.putByte(-12);
               } catch (OptionalDataException var16) {
                  var0.putByte(-13);
               } catch (IllegalAccessException var17) {
                  var0.putByte(-14);
               } catch (IllegalArgumentException var18) {
                  var0.putByte(-15);
               } catch (InvocationTargetException var19) {
                  var0.putByte(-16);
               } catch (SecurityException var20) {
                  var0.putByte(-17);
               } catch (IOException var21) {
                  var0.putByte(-18);
               } catch (NullPointerException var22) {
                  var0.putByte(-19);
               } catch (Exception var23) {
                  var0.putByte(-20);
               } catch (Throwable var24) {
                  var0.putByte(-21);
               }
            }
         }

         var0.putCrc(var2);
         var1.unlink();
      }
   }*/ // TODO

    void sort(final Comparator var1, final boolean var2) {
        if (var2) {
            this.events.sort(var1);
        } else {
            this.events.sort(Collections.reverseOrder(var1));
        }

    }
}
