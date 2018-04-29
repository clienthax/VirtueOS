package com.oldscape.client;

class class319 {
   static byte[][][] field3930;

   public static void method5650(final int var0) {
      if(class229.field2687 != 0) {
         class86.field1330 = var0;
      } else {
         class229.field2690.method4134(var0);
      }

   }

   static void method5651(final Widget[] widgets, final int var1, final int var2, final int var3, final int var4, final int var5, final int x, final int y) {
       for (final Widget widget : widgets) {
           if (widget != null && (!widget.hasScript || widget.type == 0 || widget.hasListener || GroundObject.getWidgetClickMask(widget) != 0 || widget == Client.field937 || widget.contentType == 1338) && widget.parentId == var1) {
               if (widget.hasScript) {
                   final boolean hidden = widget.isHidden;
                   if (hidden) {
                       continue;
                   }
               }

               final int var43 = widget.relativeX + x;
               final int var11 = y + widget.relativeY;
               final int var12;
               final int var13;
               final int var14;
               final int var15;
               int var16;
               int var17;
               int var19;
               if (widget.type == 2) {
                   var12 = var2;
                   var13 = var3;
                   var14 = var4;
                   var15 = var5;
               } else if (widget.type == 9) {
                   var16 = var43;
                   var17 = var11;
                   int var18 = var43 + widget.width;
                   var19 = var11 + widget.height;
                   if (var18 < var43) {
                       var16 = var18;
                       var18 = var43;
                   }

                   if (var19 < var11) {
                       var17 = var19;
                       var19 = var11;
                   }

                   ++var18;
                   ++var19;
                   var12 = var16 > var2 ? var16 : var2;
                   var13 = var17 > var3 ? var17 : var3;
                   var14 = var18 < var4 ? var18 : var4;
                   var15 = var19 < var5 ? var19 : var5;
               } else {
                   var16 = var43 + widget.width;
                   var17 = var11 + widget.height;
                   var12 = var43 > var2 ? var43 : var2;
                   var13 = var11 > var3 ? var11 : var3;
                   var14 = var16 < var4 ? var16 : var4;
                   var15 = var17 < var5 ? var17 : var5;
               }

               if (widget == Client.draggedWidget) {
                   Client.field958 = true;
                   Client.field1049 = var43;
                   Client.field882 = var11;
               }

               if (!widget.hasScript || var12 < var14 && var13 < var15) {
                   var16 = MouseInput.mouseLastX;
                   var17 = MouseInput.mouseLastY;
                   if (MouseInput.mouseLastButton != 0) {
                       var16 = MouseInput.mouseLastPressedX;
                       var17 = MouseInput.mouseLastPressedY;
                   }

                   boolean var44 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
                   if (widget.contentType == 1337) {
                       if (!Client.field880 && !Client.isMenuOpen && var44) {
                           GameCanvas.method833(var16, var17, var12, var13);
                       }
                   } else if (widget.contentType == 1338) {
                       class71.method1181(widget, var43, var11);
                   } else {
                       if (widget.contentType == 1400) {
                           Preferences.renderOverview.method6009(MouseInput.mouseLastX, MouseInput.mouseLastY, var44, var43, var11, widget.width, widget.height);
                       }

                       int var23;
                       int var37;
                       int var38;
                       if (!Client.isMenuOpen && var44) {
                           if (widget.contentType == 1400) {
                               Preferences.renderOverview.method6077(var43, var11, widget.width, widget.height, var16, var17);
                           } else {
                               var19 = var16 - var43;
                               final int var20 = var17 - var11;
                               if (widget.field2932 == 1) {
                                   TextureProvider.addMenuEntry(widget.tooltip, "", 24, 0, 0, widget.id);
                               }

                               String var21;
                               if (widget.field2932 == 2 && !Client.spellSelected) {
                                   if (class250.method4502(GroundObject.getWidgetClickMask(widget)) == 0) {
                                       var21 = null;
                                   } else if (widget.targetVerb != null && !widget.targetVerb.trim().isEmpty()) {
                                       var21 = widget.targetVerb;
                                   } else {
                                       var21 = null;
                                   }

                                   if (var21 != null) {
                                       TextureProvider.addMenuEntry(var21, class45.getColTags(65280) + widget.spellName, 25, 0, -1, widget.id);
                                   }
                               }

                               if (widget.field2932 == 3) {
                                   TextureProvider.addMenuEntry("Close", "", 26, 0, 0, widget.id);
                               }

                               if (widget.field2932 == 4) {
                                   TextureProvider.addMenuEntry(widget.tooltip, "", 28, 0, 0, widget.id);
                               }

                               if (widget.field2932 == 5) {
                                   TextureProvider.addMenuEntry(widget.tooltip, "", 29, 0, 0, widget.id);
                               }

                               if (widget.field2932 == 6 && Client.field1033 == null) {
                                   TextureProvider.addMenuEntry(widget.tooltip, "", 30, 0, -1, widget.id);
                               }

                               int var24;
                               if (widget.type == 2) {
                                   var37 = 0;

                                   for (var38 = 0; var38 < widget.height; ++var38) {
                                       for (var23 = 0; var23 < widget.width; ++var23) {
                                           var24 = var23 * (widget.paddingX + 32);
                                           int var25 = var38 * (widget.paddingY + 32);
                                           if (var37 < 20) {
                                               var24 += widget.xSprites[var37];
                                               var25 += widget.field2915[var37];
                                           }

                                           if (var19 >= var24 && var20 >= var25 && var19 < var24 + 32 && var20 < var25 + 32) {
                                               Client.field980 = var37;
                                               class36.widget = widget;
                                               if (widget.itemIds[var37] > 0) {
                                                   label1333:
                                                   {
                                                       final ItemComposition var26 = ItemComposition.getItemDefinition(widget.itemIds[var37] - 1);
                                                       boolean var27;
                                                       int var28;
                                                       if (Client.itemSelectionState == 1) {
                                                           var28 = GroundObject.getWidgetClickMask(widget);
                                                           var27 = (var28 >> 30 & 1) != 0;
                                                           if (var27) {
                                                               if (widget.id != BoundingBox.field251 || var37 != UrlRequester.selectedItemIndex) {
                                                                   TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class45.getColTags(16748608) + var26.name, 31, var26.id, var37, widget.id);
                                                               }
                                                               break label1333;
                                                           }
                                                       }

                                                       if (Client.spellSelected) {
                                                           var28 = GroundObject.getWidgetClickMask(widget);
                                                           var27 = (var28 >> 30 & 1) != 0;
                                                           if (var27) {
                                                               if ((class110.field1607 & 16) == 16) {
                                                                   TextureProvider.addMenuEntry(Client.field1092, Client.field1028 + " " + "->" + " " + class45.getColTags(16748608) + var26.name, 32, var26.id, var37, widget.id);
                                                               }
                                                               break label1333;
                                                           }
                                                       }

                                                       final String[] var40;
                                                       var28 = -1;
                                                       if (Client.field981 && CombatInfo1.method1679()) {
                                                           var28 = var26.getShiftClickActionIndex();
                                                       }

                                                       final int var30 = GroundObject.getWidgetClickMask(widget);
                                                       final boolean var29 = (var30 >> 30 & 1) != 0;
                                                       if (var29) {
                                                           for (int var31 = 4; var31 >= 3; --var31) {
                                                               if (var28 != var31) {
                                                                   class110.method2272(widget, var26, var37, var31, false);
                                                               }
                                                           }
                                                       }

                                                       if (class304.method5423(GroundObject.getWidgetClickMask(widget))) {
                                                           TextureProvider.addMenuEntry("Use", class45.getColTags(16748608) + var26.name, 38, var26.id, var37, widget.id);
                                                       }

                                                       final int var32 = GroundObject.getWidgetClickMask(widget);
                                                       final boolean var50 = (var32 >> 30 & 1) != 0;
                                                       int var33;
                                                       if (var50) {
                                                           for (var33 = 2; var33 >= 0; --var33) {
                                                               if (var33 != var28) {
                                                                   class110.method2272(widget, var26, var37, var33, false);
                                                               }
                                                           }

                                                           if (var28 >= 0) {
                                                               class110.method2272(widget, var26, var37, var28, true);
                                                           }
                                                       }

                                                       var40 = widget.configActions;
                                                       if (var40 != null) {
                                                           for (var33 = 4; var33 >= 0; --var33) {
                                                               if (var40[var33] != null) {
                                                                   byte var34 = 0;
                                                                   if (var33 == 0) {
                                                                       var34 = 39;
                                                                   }

                                                                   if (var33 == 1) {
                                                                       var34 = 40;
                                                                   }

                                                                   if (var33 == 2) {
                                                                       var34 = 41;
                                                                   }

                                                                   if (var33 == 3) {
                                                                       var34 = 42;
                                                                   }

                                                                   if (var33 == 4) {
                                                                       var34 = 43;
                                                                   }

                                                                   TextureProvider.addMenuEntry(var40[var33], class45.getColTags(16748608) + var26.name, var34, var26.id, var37, widget.id);
                                                               }
                                                           }
                                                       }

                                                       TextureProvider.addMenuEntry("Examine", class45.getColTags(16748608) + var26.name, 1005, var26.id, var37, widget.id);
                                                   }
                                               }
                                           }

                                           ++var37;
                                       }
                                   }
                               }

                               if (widget.hasScript) {
                                   if (Client.spellSelected) {
                                       if (GroundObject.method2669(GroundObject.getWidgetClickMask(widget)) && (class110.field1607 & 32) == 32) {
                                           TextureProvider.addMenuEntry(Client.field1092, Client.field1028 + " " + "->" + " " + widget.opBase, 58, 0, widget.index, widget.id);
                                       }
                                   } else {
                                       for (var37 = 9; var37 >= 5; --var37) {
                                           final String var22;
                                           if (!DynamicObject.method2021(GroundObject.getWidgetClickMask(widget), var37) && widget.onOpListener == null) {
                                               var22 = null;
                                           } else if (widget.actions != null && widget.actions.length > var37 && widget.actions[var37] != null && !widget.actions[var37].trim().isEmpty()) {
                                               var22 = widget.actions[var37];
                                           } else {
                                               var22 = null;
                                           }

                                           if (var22 != null) {
                                               TextureProvider.addMenuEntry(var22, widget.opBase, 1007, var37 + 1, widget.index, widget.id);
                                           }
                                       }

                                       if (class250.method4502(GroundObject.getWidgetClickMask(widget)) == 0) {
                                           var21 = null;
                                       } else if (widget.targetVerb != null && !widget.targetVerb.trim().isEmpty()) {
                                           var21 = widget.targetVerb;
                                       } else {
                                           var21 = null;
                                       }

                                       if (var21 != null) {
                                           TextureProvider.addMenuEntry(var21, widget.opBase, 25, 0, widget.index, widget.id);
                                       }

                                       for (var23 = 4; var23 >= 0; --var23) {
                                           final String var41;
                                           if (!DynamicObject.method2021(GroundObject.getWidgetClickMask(widget), var23) && widget.onOpListener == null) {
                                               var41 = null;
                                           } else if (widget.actions != null && widget.actions.length > var23 && widget.actions[var23] != null && !widget.actions[var23].trim().isEmpty()) {
                                               var41 = widget.actions[var23];
                                           } else {
                                               var41 = null;
                                           }

                                           if (var41 != null) {
                                               TextureProvider.addMenuEntry(var41, widget.opBase, 57, var23 + 1, widget.index, widget.id);
                                           }
                                       }

                                       var24 = GroundObject.getWidgetClickMask(widget);
                                       final boolean var49 = (var24 & 1) != 0;
                                       if (var49) {
                                           TextureProvider.addMenuEntry("Continue", "", 30, 0, widget.index, widget.id);
                                       }
                                   }
                               }
                           }
                       }

                       boolean var46;
                       if (widget.type == 0) {
                           if (!widget.hasScript) {
                               var46 = widget.isHidden;
                               if (var46 && widget != BoundingBox3D.field259) {
                                   continue;
                               }
                           }

                           method5651(widgets, widget.id, var12, var13, var14, var15, var43 - widget.scrollX, var11 - widget.scrollY);
                           if (widget.children != null) {
                               method5651(widget.children, widget.id, var12, var13, var14, var15, var43 - widget.scrollX, var11 - widget.scrollY);
                           }

                           final WidgetNode var35 = (WidgetNode) Client.componentTable.get(widget.id);
                           if (var35 != null) {
                               if (var35.owner == 0 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15 && !Client.isMenuOpen) {
                                   for (ScriptEvent var36 = (ScriptEvent) Client.field1066.getFront(); var36 != null; var36 = (ScriptEvent) Client.field1066.getNext()) {
                                       if (var36.boolean1) {
                                           var36.unlink();
                                           var36.widget.field2835 = false;
                                       }
                                   }

                                   if (class55.field660 == 0) {
                                       Client.draggedWidget = null;
                                       Client.field937 = null;
                                   }

                                   if (!Client.isMenuOpen) {
                                       Size.method198();
                                   }
                               }

                               Client.method400(var35.id, var12, var13, var14, var15, var43, var11);
                           }
                       }

                       if (widget.hasScript) {
                           ScriptEvent var51;
                           if (!widget.noClickThrough) {
                               if (widget.noScrollThrough && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                                   for (var51 = (ScriptEvent) Client.field1066.getFront(); var51 != null; var51 = (ScriptEvent) Client.field1066.getNext()) {
                                       if (var51.boolean1 && var51.widget.onScrollWheelListener == var51.objs) {
                                           var51.unlink();
                                       }
                                   }
                               }
                           } else if (MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                               for (var51 = (ScriptEvent) Client.field1066.getFront(); var51 != null; var51 = (ScriptEvent) Client.field1066.getNext()) {
                                   if (var51.boolean1) {
                                       var51.unlink();
                                       var51.widget.field2835 = false;
                                   }
                               }

                               if (class55.field660 == 0) {
                                   Client.draggedWidget = null;
                                   Client.field937 = null;
                               }

                               if (!Client.isMenuOpen) {
                                   Size.method198();
                               }
                           }

                           var44 = MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15;

                           var46 = (MouseInput.mouseCurrentButton == 1 || !MapIconReference.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) && var44;

                           boolean var45 = false;
                           if ((MouseInput.mouseLastButton == 1 || !MapIconReference.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                               var45 = true;
                           }

                           if (var45) {
                               class27.method239(widget, MouseInput.mouseLastPressedX - var43, MouseInput.mouseLastPressedY - var11);
                           }

                           if (widget.contentType == 1400) {
                               Preferences.renderOverview.method6010(var16, var17, var44 & var46, var44 & var45);
                           }

                           if (Client.draggedWidget != null && widget != Client.draggedWidget && var44) {
                               var38 = GroundObject.getWidgetClickMask(widget);
                               final boolean var52 = (var38 >> 20 & 1) != 0;
                               if (var52) {
                                   Client.draggedOnWidget = widget;
                               }
                           }

                           if (widget == Client.field937) {
                               Client.field1053 = true;
                               Client.field1008 = var43;
                               Client.field1047 = var11;
                           }

                           if (widget.hasListener) {
                               ScriptEvent var48;
                               if (var44 && Client.mouseWheelRotation != 0 && widget.onScrollWheelListener != null) {
                                   var48 = new ScriptEvent();
                                   var48.boolean1 = true;
                                   var48.widget = widget;
                                   var48.field798 = Client.mouseWheelRotation;
                                   var48.objs = widget.onScrollWheelListener;
                                   Client.field1066.addFront(var48);
                               }

                               if (Client.draggedWidget != null || UrlRequest.field2137 != null || Client.isMenuOpen) {
                                   var45 = false;
                                   var46 = false;
                                   var44 = false;
                               }

                               if (!widget.field2948 && var45) {
                                   widget.field2948 = true;
                                   if (widget.onClickListener != null) {
                                       var48 = new ScriptEvent();
                                       var48.boolean1 = true;
                                       var48.widget = widget;
                                       var48.field799 = MouseInput.mouseLastPressedX - var43;
                                       var48.field798 = MouseInput.mouseLastPressedY - var11;
                                       var48.objs = widget.onClickListener;
                                       Client.field1066.addFront(var48);
                                   }
                               }

                               if (widget.field2948 && var46 && widget.onClickRepeatListener != null) {
                                   var48 = new ScriptEvent();
                                   var48.boolean1 = true;
                                   var48.widget = widget;
                                   var48.field799 = MouseInput.mouseLastX - var43;
                                   var48.field798 = MouseInput.mouseLastY - var11;
                                   var48.objs = widget.onClickRepeatListener;
                                   Client.field1066.addFront(var48);
                               }

                               if (widget.field2948 && !var46) {
                                   widget.field2948 = false;
                                   if (widget.onReleaseListener != null) {
                                       var48 = new ScriptEvent();
                                       var48.boolean1 = true;
                                       var48.widget = widget;
                                       var48.field799 = MouseInput.mouseLastX - var43;
                                       var48.field798 = MouseInput.mouseLastY - var11;
                                       var48.objs = widget.onReleaseListener;
                                       Client.field1125.addFront(var48);
                                   }
                               }

                               if (var46 && widget.onHoldListener != null) {
                                   var48 = new ScriptEvent();
                                   var48.boolean1 = true;
                                   var48.widget = widget;
                                   var48.field799 = MouseInput.mouseLastX - var43;
                                   var48.field798 = MouseInput.mouseLastY - var11;
                                   var48.objs = widget.onHoldListener;
                                   Client.field1066.addFront(var48);
                               }

                               if (!widget.field2835 && var44) {
                                   widget.field2835 = true;
                                   if (widget.onMouseOverListener != null) {
                                       var48 = new ScriptEvent();
                                       var48.boolean1 = true;
                                       var48.widget = widget;
                                       var48.field799 = MouseInput.mouseLastX - var43;
                                       var48.field798 = MouseInput.mouseLastY - var11;
                                       var48.objs = widget.onMouseOverListener;
                                       Client.field1066.addFront(var48);
                                   }
                               }

                               if (widget.field2835 && var44 && widget.onMouseRepeatListener != null) {
                                   var48 = new ScriptEvent();
                                   var48.boolean1 = true;
                                   var48.widget = widget;
                                   var48.field799 = MouseInput.mouseLastX - var43;
                                   var48.field798 = MouseInput.mouseLastY - var11;
                                   var48.objs = widget.onMouseRepeatListener;
                                   Client.field1066.addFront(var48);
                               }

                               if (widget.field2835 && !var44) {
                                   widget.field2835 = false;
                                   if (widget.onMouseLeaveListener != null) {
                                       var48 = new ScriptEvent();
                                       var48.boolean1 = true;
                                       var48.widget = widget;
                                       var48.field799 = MouseInput.mouseLastX - var43;
                                       var48.field798 = MouseInput.mouseLastY - var11;
                                       var48.objs = widget.onMouseLeaveListener;
                                       Client.field1125.addFront(var48);
                                   }
                               }

                               if (widget.onTimerListener != null) {
                                   var48 = new ScriptEvent();
                                   var48.widget = widget;
                                   var48.objs = widget.onTimerListener;
                                   Client.field1067.addFront(var48);
                               }

                               ScriptEvent var53;
                               if (widget.onVarTransmitListener != null && Client.field1054 > widget.field2950) {
                                   if (widget.varTransmitTriggers != null && Client.field1054 - widget.field2950 <= 32) {
                                       label999:
                                       for (var37 = widget.field2950; var37 < Client.field1054; ++var37) {
                                           var38 = Client.field984[var37 & 31];

                                           for (var23 = 0; var23 < widget.varTransmitTriggers.length; ++var23) {
                                               if (var38 == widget.varTransmitTriggers[var23]) {
                                                   var53 = new ScriptEvent();
                                                   var53.widget = widget;
                                                   var53.objs = widget.onVarTransmitListener;
                                                   Client.field1066.addFront(var53);
                                                   break label999;
                                               }
                                           }
                                       }
                                   } else {
                                       var48 = new ScriptEvent();
                                       var48.widget = widget;
                                       var48.objs = widget.onVarTransmitListener;
                                       Client.field1066.addFront(var48);
                                   }

                                   widget.field2950 = Client.field1054;
                               }

                               if (widget.onInvTransmitListener != null && Client.field1056 > widget.field2951) {
                                   if (widget.invTransmitTriggers != null && Client.field1056 - widget.field2951 <= 32) {
                                       label975:
                                       for (var37 = widget.field2951; var37 < Client.field1056; ++var37) {
                                           var38 = Client.interfaceItemTriggers[var37 & 31];

                                           for (var23 = 0; var23 < widget.invTransmitTriggers.length; ++var23) {
                                               if (var38 == widget.invTransmitTriggers[var23]) {
                                                   var53 = new ScriptEvent();
                                                   var53.widget = widget;
                                                   var53.objs = widget.onInvTransmitListener;
                                                   Client.field1066.addFront(var53);
                                                   break label975;
                                               }
                                           }
                                       }
                                   } else {
                                       var48 = new ScriptEvent();
                                       var48.widget = widget;
                                       var48.objs = widget.onInvTransmitListener;
                                       Client.field1066.addFront(var48);
                                   }

                                   widget.field2951 = Client.field1056;
                               }

                               if (widget.onStatTransmitListener != null && Client.field1052 > widget.field2856) {
                                   if (widget.statTransmitTriggers != null && Client.field1052 - widget.field2856 <= 32) {
                                       label951:
                                       for (var37 = widget.field2856; var37 < Client.field1052; ++var37) {
                                           var38 = Client.field1057[var37 & 31];

                                           for (var23 = 0; var23 < widget.statTransmitTriggers.length; ++var23) {
                                               if (var38 == widget.statTransmitTriggers[var23]) {
                                                   var53 = new ScriptEvent();
                                                   var53.widget = widget;
                                                   var53.objs = widget.onStatTransmitListener;
                                                   Client.field1066.addFront(var53);
                                                   break label951;
                                               }
                                           }
                                       }
                                   } else {
                                       var48 = new ScriptEvent();
                                       var48.widget = widget;
                                       var48.objs = widget.onStatTransmitListener;
                                       Client.field1066.addFront(var48);
                                   }

                                   widget.field2856 = Client.field1052;
                               }

                               if (Client.chatCycle > widget.field2949 && widget.onChatTransmitListener != null) {
                                   var48 = new ScriptEvent();
                                   var48.widget = widget;
                                   var48.objs = widget.onChatTransmitListener;
                                   Client.field1066.addFront(var48);
                               }

                               if (Client.field1060 > widget.field2949 && widget.onFriendTransmitListener != null) {
                                   var48 = new ScriptEvent();
                                   var48.widget = widget;
                                   var48.objs = widget.onFriendTransmitListener;
                                   Client.field1066.addFront(var48);
                               }

                               if (Client.field967 > widget.field2949 && widget.onClanTransmitListener != null) {
                                   var48 = new ScriptEvent();
                                   var48.widget = widget;
                                   var48.objs = widget.onClanTransmitListener;
                                   Client.field1066.addFront(var48);
                               }

                               if (Client.field1062 > widget.field2949 && widget.onStockTransmitListener != null) {
                                   var48 = new ScriptEvent();
                                   var48.widget = widget;
                                   var48.objs = widget.onStockTransmitListener;
                                   Client.field1066.addFront(var48);
                               }

                               if (Client.field1063 > widget.field2949 && widget.onCamFinishedListener != null) {
                                   var48 = new ScriptEvent();
                                   var48.widget = widget;
                                   var48.objs = widget.onCamFinishedListener;
                                   Client.field1066.addFront(var48);
                               }

                               if (Client.field1064 > widget.field2949 && widget.onMiscTransmitListener != null) {
                                   var48 = new ScriptEvent();
                                   var48.widget = widget;
                                   var48.objs = widget.onMiscTransmitListener;
                                   Client.field1066.addFront(var48);
                               }

                               widget.field2949 = Client.cycleCntr;
                               if (widget.onKeyListener != null) {
                                   for (var37 = 0; var37 < Client.field952; ++var37) {
                                       final ScriptEvent var47 = new ScriptEvent();
                                       var47.widget = widget;
                                       var47.pressedKey = Client.field968[var37];
                                       var47.typedKey = Client.field1089[var37];
                                       var47.objs = widget.onKeyListener;
                                       Client.field1066.addFront(var47);
                                   }
                               }
                           }
                       }

                       if (!widget.hasScript && Client.draggedWidget == null && UrlRequest.field2137 == null && !Client.isMenuOpen) {
                           if ((widget.field2937 >= 0 || widget.field2849 != 0) && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                               if (widget.field2937 >= 0) {
                                   BoundingBox3D.field259 = widgets[widget.field2937];
                               } else {
                                   BoundingBox3D.field259 = widget;
                               }
                           }

                           if (widget.type == 8 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                               class7.field234 = widget;
                           }

                           if (widget.scrollHeight > widget.height) {
                               GrandExchangeEvent.method90(widget, var43 + widget.width, var11, widget.height, widget.scrollHeight, MouseInput.mouseLastX, MouseInput.mouseLastY);
                           }
                       }
                   }
               }
           }
       }

   }
}
