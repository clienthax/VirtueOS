package com.oldscape.client;

class class47 {
   static Buffer NetCache_responseArchiveBuffer;
   private final int field588;
   private byte[][][] field582;

   class47(final int var1) {
      this.field588 = var1;
   }

   void method707(final int var1, final int var2, final int var3, final int var4, final int var5, final int var6, int var7, int var8) {
      if(var7 != 0 && this.field588 != 0 && this.field582 != null) {
         var8 = this.method746(var8, var7);
         var7 = this.method709(var7);
         Rasterizer2D.method5728(var1, var2, var5, var6, var3, var4, this.field582[var7 - 1][var8], this.field588);
      }
   }

   private int method746(int var1, final int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   private int method709(final int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   void method734() {
      if(this.field582 == null) {
         this.field582 = new byte[8][4][];
         this.method731();
         this.method712();
         this.method713();
         this.method723();
         this.method722();
         this.method716();
         this.method724();
         this.method718();
      }
   }

   private void method731() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[0][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[0][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[0][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[0][3] = var1;
   }

   private void method712() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[1][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

            }
             ++var2;
         }
      }

      this.field582[1][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[1][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[1][3] = var1;
   }

   private void method713() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[2][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[2][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[2][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[2][3] = var1;
   }

   private void method723() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[3][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[3][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[3][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[3][3] = var1;
   }

   private void method722() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[4][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[4][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[4][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var2 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field582[4][3] = var1;
   }

   private void method716() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[5][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var3 <= this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[5][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[5][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var3 >= this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[5][3] = var1;
   }

   private void method724() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[6][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 <= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[6][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[6][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[6][3] = var1;
   }

   private void method718() {
      byte[] var1 = new byte[this.field588 * this.field588];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[7][0] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field588; ++var4) {
            if(var4 >= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[7][1] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = this.field588 - 1; var3 >= 0; --var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[7][2] = var1;
      var1 = new byte[this.field588 * this.field588];
      var5 = 0;

      for(var3 = 0; var3 < this.field588; ++var3) {
         for(var4 = this.field588 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field588 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field582[7][3] = var1;
   }

   static void method739(final Widget[] widgets, final int id) {
       for (final Widget widget : widgets) {
           if (widget != null && widget.parentId == id) {
               boolean desu;
               if (widget.hasScript) {
                   desu = widget.isHidden;
                   if (desu) {
                       continue;
                   }
               }

               int var5;
               if (widget.type == 0) {
                   if (!widget.hasScript) {
                       desu = widget.isHidden;
                       if (desu && widget != BoundingBox3D.field259) {
                           continue;
                       }
                   }

                   method739(widgets, widget.id);
                   if (widget.children != null) {
                       method739(widget.children, widget.id);
                   }

                   final WidgetNode widgetNode = (WidgetNode) Client.componentTable.get(widget.id);
                   if (widgetNode != null) {
                       var5 = widgetNode.id;
                       if (class189.loadWidget(var5)) {
                           method739(MouseRecorder.widgets[var5], -1);
                       }
                   }
               }

               if (widget.type == 6) {
                   if (widget.field2869 != -1 || widget.field2855 != -1) {
                       desu = class27.method246(widget);
                       if (desu) {
                           var5 = widget.field2855;
                       } else {
                           var5 = widget.field2869;
                       }

                       if (var5 != -1) {
                           final Sequence sequence = CombatInfo1.getAnimation(var5);

                           for (widget.field2945 += Client.field930; widget.field2945 > sequence.frameLengths[widget.sequenceFrameId]; FontName.method5490(widget)) {
                               widget.field2945 -= sequence.frameLengths[widget.sequenceFrameId];
                               ++widget.sequenceFrameId;
                               if (widget.sequenceFrameId >= sequence.frameIDs.length) {
                                   widget.sequenceFrameId -= sequence.frameStep;
                                   if (widget.sequenceFrameId < 0 || widget.sequenceFrameId >= sequence.frameIDs.length) {
                                       widget.sequenceFrameId = 0;
                                   }
                               }
                           }
                       }
                   }

                   if (widget.field2904 != 0 && !widget.hasScript) {
                       int var8 = widget.field2904 >> 16;
                       var5 = widget.field2904 << 16 >> 16;
                       var8 *= Client.field930;
                       var5 *= Client.field930;
                       widget.rotationX = var8 + widget.rotationX & 2047;
                       widget.rotationZ = var5 + widget.rotationZ & 2047;
                       FontName.method5490(widget);
                   }
               }
           }
       }

   }
}
