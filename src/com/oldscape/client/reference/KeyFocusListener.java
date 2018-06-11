package com.oldscape.client.reference;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class KeyFocusListener implements KeyListener, FocusListener {
    public static final boolean[] keyPressed;
    public static final int[] field630;
    static final int[] field625;
    static final char[] field632;
    static final int[] field629;
    static final int[] KeyHandler_keyCodes;
    public static KeyFocusListener keyboard;
    public static int field638;
    static int scriptStringStackSize;
    static int field626;
    static int field627;
    static int field620;
    static int field631;
    static int field623;
    static volatile int keyboardIdleTicks;
    static IndexData indexCache13;

    static {
        keyboard = new KeyFocusListener();
        keyPressed = new boolean[112];
        field625 = new int[128];
        field626 = 0;
        field627 = 0;
        field632 = new char[128];
        field629 = new int[128];
        field630 = new int[128];
        field638 = 0;
        field620 = 0;
        field631 = 0;
        field623 = 0;
        keyboardIdleTicks = 0;
        KeyHandler_keyCodes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    static void method811(NPCComposition var0, final int var1, final int var2, final int var3) {
        if (Client.menuOptionCount < 400) {
            if (var0.configs != null) {
                var0 = var0.transform();
            }

            if (var0 != null) {
                if (var0.field3724) {
                    if (!var0.field3738 || Client.field1048 == var1) {
                        String var4 = var0.name;
                        if (var0.combatLevel != 0) {
                            var4 = var4 + PendingSpawn.method1653(var0.combatLevel, Client.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                        }

                        if (var0.field3738 && Client.field1014) {
                            TextureProvider.addMenuEntry("Examine", class45.getColTags(16776960) + var4, 1003, var1, var2, var3);
                        }

                        if (Client.itemSelectionState == 1) {
                            TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class45.getColTags(16776960) + var4, 7, var1, var2, var3);
                        } else if (Client.spellSelected) {
                            if ((class110.field1607 & 2) == 2) {
                                TextureProvider.addMenuEntry(Client.field1092, Client.field1028 + " " + "->" + " " + class45.getColTags(16776960) + var4, 8, var1, var2, var3);
                            }
                        } else {
                            final int var5 = var0.field3738 && Client.field1014 ? 2000 : 0;
                            final String[] var6 = var0.actions;
                            int var7;
                            int var8;
                            if (var6 != null) {
                                for (var7 = 4; var7 >= 0; --var7) {
                                    if (var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
                                        var8 = 0;
                                        if (var7 == 0) {
                                            var8 = var5 + 9;
                                        }

                                        if (var7 == 1) {
                                            var8 = var5 + 10;
                                        }

                                        if (var7 == 2) {
                                            var8 = var5 + 11;
                                        }

                                        if (var7 == 3) {
                                            var8 = var5 + 12;
                                        }

                                        if (var7 == 4) {
                                            var8 = var5 + 13;
                                        }

                                        TextureProvider.addMenuEntry(var6[var7], class45.getColTags(16776960) + var4, var8, var1, var2, var3);
                                    }
                                }
                            }

                            if (var6 != null) {
                                for (var7 = 4; var7 >= 0; --var7) {
                                    if (var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                                        short var9 = 0;
                                        if (Client.npcAttackOption != AttackOption.AttackOption_hidden) {
                                            if (Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.npcAttackOption && var0.combatLevel > Client.localPlayer.combatLevel) {
                                                var9 = 2000;
                                            }

                                            var8 = 0;
                                            if (var7 == 0) {
                                                var8 = var9 + 9;
                                            }

                                            if (var7 == 1) {
                                                var8 = var9 + 10;
                                            }

                                            if (var7 == 2) {
                                                var8 = var9 + 11;
                                            }

                                            if (var7 == 3) {
                                                var8 = var9 + 12;
                                            }

                                            if (var7 == 4) {
                                                var8 = var9 + 13;
                                            }

                                            TextureProvider.addMenuEntry(var6[var7], class45.getColTags(16776960) + var4, var8, var1, var2, var3);
                                        }
                                    }
                                }
                            }

                            if (!var0.field3738 || !Client.field1014) {
                                TextureProvider.addMenuEntry("Examine", class45.getColTags(16776960) + var4, 1003, var1, var2, var3);
                            }
                        }

                    }
                }
            }
        }
    }

    static void method787(final Widget[] var0, final int var1, final int var2, final int var3, final boolean var4) {
        for (final Widget var6 : var0) {
            if (var6 != null && var6.parentId == var1) {
                BoundingBox3D.method48(var6, var2, var3, var4);
                BoundingBox3D.method52(var6, var2, var3);
                if (var6.scrollX > var6.scrollWidth - var6.width) {
                    var6.scrollX = var6.scrollWidth - var6.width;
                }

                if (var6.scrollX < 0) {
                    var6.scrollX = 0;
                }

                if (var6.scrollY > var6.scrollHeight - var6.height) {
                    var6.scrollY = var6.scrollHeight - var6.height;
                }

                if (var6.scrollY < 0) {
                    var6.scrollY = 0;
                }

                if (var6.type == 0) {
                    class86.method1889(var0, var6, var4);
                }
            }
        }

    }

    public final synchronized void keyPressed(final KeyEvent var1) {
        if (keyboard != null) {
            int var2 = var1.getKeyCode();
            if (var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
                var2 = KeyHandler_keyCodes[var2];
                if ((var2 & 128) != 0) {
                    var2 = -1;
                }
            } else {
                var2 = -1;
            }

            if (field627 >= 0 && var2 >= 0) {
                field625[field627] = var2;
                field627 = field627 + 1 & 127;
                if (field626 == field627) {
                    field627 = -1;
                }
            }

            int var3;
            if (var2 >= 0) {
                var3 = field631 + 1 & 127;
                if (var3 != field620) {
                    field629[field631] = var2;
                    field632[field631] = 0;
                    field631 = var3;
                }
            }

            var3 = var1.getModifiers();
            if ((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
                var1.consume();
            }
        }

    }

    public final synchronized void keyReleased(final KeyEvent var1) {
        if (keyboard != null) {
            int var2 = var1.getKeyCode();
            if (var2 >= 0 && var2 < KeyHandler_keyCodes.length) {
                var2 = KeyHandler_keyCodes[var2] & -129;
            } else {
                var2 = -1;
            }

            if (field627 >= 0 && var2 >= 0) {
                field625[field627] = ~var2;
                field627 = field627 + 1 & 127;
                if (field626 == field627) {
                    field627 = -1;
                }
            }
        }

        var1.consume();
    }

    public final void keyTyped(final KeyEvent var1) {
        if (keyboard != null) {
            final char var2 = var1.getKeyChar();
            if (var2 != 0 && var2 != '\uffff') {
                final boolean var3;
                if (var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
                    var3 = true;
                } else {
                    label59:
                    {
                        if (var2 != 0) {
                            final char[] var7 = class314.cp1252AsciiExtension;

                            for (final char var6 : var7) {
                                if (var2 == var6) {
                                    var3 = true;
                                    break label59;
                                }
                            }
                        }

                        var3 = false;
                    }
                }

                if (var3) {
                    final int var4 = field631 + 1 & 127;
                    if (var4 != field620) {
                        field629[field631] = -1;
                        field632[field631] = var2;
                        field631 = var4;
                    }
                }
            }
        }

        var1.consume();
    }

    public final void focusGained(final FocusEvent var1) {
    }

    public final synchronized void focusLost(final FocusEvent var1) {
        if (keyboard != null) {
            field627 = -1;
        }

    }
}
