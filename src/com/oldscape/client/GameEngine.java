package com.oldscape.client;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URL;

public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   public static int canvasWidth;
   static ClanMemberManager clanMemberManager;
   static Signlink taskManager;
   static int field1348;
   static int canvasHeight;
   private static GameEngine shell;
   private static int shellCount;
   private static long field681;
   private static boolean field690;
   static int field684;
   private static final int field685;
   private static int field686;
   static int FPS;
   static final long[] field688;
   static final long[] field709;
   private static int field701;
   private static volatile boolean focused;
   static long garbageCollectorLastCollectionTime;
   static long garbageCollectorLastCheckTimeMs;
   static SpritePixels[] headIconsPk;
   private boolean hasErrored;
   int field680;
   int field712;
   private int field692;
   private int field693;
   private int field678;
   private int field694;
   private int field696;
   private int field689;
   private java.awt.Frame frame;
   private Canvas canvas;
   private volatile boolean field700;
   private boolean field702;
   private volatile boolean field703;
   private volatile long field704;
   private MouseWheelHandler mouseWheelHandler;
   private Clipboard clipboard;
   private final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field681 = 0L;
      field690 = false;
      field685 = 20;
      field686 = 1;
      FPS = 0;
      field688 = new long[32];
      field709 = new long[32];
      field701 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field692 = 0;
      this.field693 = 0;
      this.field700 = true;
      this.field702 = false;
      this.field703 = false;
      this.field704 = 0L;
      EventQueue eventQueue = null;

      try {
         eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (final Throwable ignored) {
      }

      this.eventQueue = eventQueue;
      AbstractSoundSystem.soundTaskDataProvider = new SoundTaskDataProvider();
   }

   final void method894(final int var1, final int var2) {
      if(this.field696 != var1 || var2 != this.field689) {
         this.method911();
      }

      this.field696 = var1;
      this.field689 = var2;
   }

   private void method1002(final Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            ScriptVarType.method11(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   MouseWheel mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   void method898(final String var1) {
      this.clipboard.setContents(new StringSelection(var1), null);
   }

   final void setUpKeyboard() {
      if(Signlink.javaVendor.toLowerCase().contains("microsoft")) {
         KeyFocusListener.KeyHandler_keyCodes[186] = 57;
         KeyFocusListener.KeyHandler_keyCodes[187] = 27;
         KeyFocusListener.KeyHandler_keyCodes[188] = 71;
         KeyFocusListener.KeyHandler_keyCodes[189] = 26;
         KeyFocusListener.KeyHandler_keyCodes[190] = 72;
         KeyFocusListener.KeyHandler_keyCodes[191] = 73;
         KeyFocusListener.KeyHandler_keyCodes[192] = 58;
         KeyFocusListener.KeyHandler_keyCodes[219] = 42;
         KeyFocusListener.KeyHandler_keyCodes[220] = 74;
         KeyFocusListener.KeyHandler_keyCodes[221] = 43;
         KeyFocusListener.KeyHandler_keyCodes[222] = 59;
         KeyFocusListener.KeyHandler_keyCodes[223] = 28;
      } else {
         KeyFocusListener.KeyHandler_keyCodes[44] = 71;
         KeyFocusListener.KeyHandler_keyCodes[45] = 26;
         KeyFocusListener.KeyHandler_keyCodes[46] = 72;
         KeyFocusListener.KeyHandler_keyCodes[47] = 73;
         KeyFocusListener.KeyHandler_keyCodes[59] = 57;
         KeyFocusListener.KeyHandler_keyCodes[61] = 27;
         KeyFocusListener.KeyHandler_keyCodes[91] = 42;
         KeyFocusListener.KeyHandler_keyCodes[92] = 74;
         KeyFocusListener.KeyHandler_keyCodes[93] = 43;
         KeyFocusListener.KeyHandler_keyCodes[192] = 28;
         KeyFocusListener.KeyHandler_keyCodes[222] = 58;
         KeyFocusListener.KeyHandler_keyCodes[520] = 59;
      }

      class23.method186(this.canvas);
   }

   final void setUpMouse() {
      final Canvas canvas = this.canvas;
      canvas.addMouseListener(MouseInput.mouse);
      canvas.addMouseMotionListener(MouseInput.mouse);
      canvas.addFocusListener(MouseInput.mouse);
   }

   private void method901() {
      final Container container = this.container();
      if(container != null) {
         final Bounds bounds = this.method925();
         this.field680 = Math.max(bounds.field3942, this.field678);
         this.field712 = Math.max(bounds.field3944, this.field694);
         if(this.field680 <= 0) {
            this.field680 = 1;
         }

         if(this.field712 <= 0) {
            this.field712 = 1;
         }

         canvasWidth = Math.min(this.field680, this.field696);
         canvasHeight = Math.min(this.field712, this.field689);
         this.field692 = (this.field680 - canvasWidth) / 2;
         this.field693 = 0;
         this.canvas.setSize(canvasWidth, canvasHeight);
         MapCacheArchiveNames.rasterProvider = new MainBufferProvider(canvasWidth, canvasHeight, this.canvas);
         if(container == this.frame) {
            final Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(var3.left + this.field692, var3.top + this.field693);
         } else {
            this.canvas.setLocation(this.field692, this.field693);
         }

         this.field700 = true;
         this.vmethod1262();
      }
   }

   protected abstract void vmethod1262();

   private void method903() {
      final int var1 = this.field692;
      final int var2 = this.field693;
      final int var3 = this.field680 - canvasWidth - var1;
      final int var4 = this.field712 - canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            final Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.frame) {
               final Insets insets = this.frame.getInsets();
               var6 = insets.left;
               var7 = insets.top;
            }

            final Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field712);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field680, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field680 - var3, var7, var3, this.field712);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field712 - var4, this.field680, var4);
            }
         } catch (final Exception ignored) {
         }
      }

   }

   private void method904() {
      CacheFile.method2545(this.canvas);
      final Canvas var1 = this.canvas;
      var1.removeMouseListener(MouseInput.mouse);
      var1.removeMouseMotionListener(MouseInput.mouse);
      var1.removeFocusListener(MouseInput.mouse);
      MouseInput.MouseHandler_currentButton = 0;
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      class23.method186(this.canvas);
      final Canvas var2 = this.canvas;
      var2.addMouseListener(MouseInput.mouse);
      var2.addMouseMotionListener(MouseInput.mouse);
      var2.addFocusListener(MouseInput.mouse);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method911();
   }

   final void initialize(final int var1, final int var2, final int var3) {
      try {
         if(shell != null) {
            ++shellCount;
            if(shellCount >= 3) {
               this.error("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         shell = this;
         canvasWidth = var1;
         canvasHeight = var2;
         RunException.revision = var3;
         RunException.field2198 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (final Exception var5) {
         Signlink.processClientError(null, var5);
         this.error("crash");
      }

   }

   private synchronized void replaceCanvas() {
      final Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      canvasWidth = Math.max(var1.getWidth(), this.field678);
      canvasHeight = Math.max(var1.getHeight(), this.field694);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         canvasWidth -= var2.right + var2.left;
         canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new GameCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(canvasWidth, canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(this.field692 + var2.left, this.field693 + var2.top);
      } else {
         this.canvas.setLocation(this.field692, this.field693);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field700 = true;
      if(MapCacheArchiveNames.rasterProvider != null && canvasWidth == MapCacheArchiveNames.rasterProvider.width && canvasHeight == MapCacheArchiveNames.rasterProvider.height) {
         ((MainBufferProvider)MapCacheArchiveNames.rasterProvider).replaceComponent(this.canvas);
         MapCacheArchiveNames.rasterProvider.drawFull(0, 0);
      } else {
         MapCacheArchiveNames.rasterProvider = new MainBufferProvider(canvasWidth, canvasHeight, this.canvas);
      }

      this.field703 = false;
      this.field704 = class64.method1118();
   }

   final boolean isValidHost() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if(!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if(!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if(var1.endsWith("127.0.0.1")) {
               return true;
            } else {
               while(!var1.isEmpty() && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
                  var1 = var1.substring(0, var1.length() - 1);
               }

               if(var1.endsWith("192.168.1.")) {
                  return true;
               } else {
                  this.error("invalidhost");
                  return false;
               }
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   private void method1015() {
      final long var1 = class64.method1118();
      final long var3 = field709[field1348];
      field709[field1348] = var1;
      field1348 = field1348 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
      }

      synchronized(this) {
         PlayerComposition.gameFocused = focused;
      }

      this.packetHandler();
   }

   private void method910() {
      final Container container = this.container();
      final long var2 = class64.method1118();
      final long var4 = field688[class250.field3022];
      field688[class250.field3022] = var2;
      class250.field3022 = class250.field3022 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         final int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field701 - 1 > 50) {
         field701 -= 50;
         this.field700 = true;
         this.canvas.setSize(canvasWidth, canvasHeight);
         this.canvas.setVisible(true);
         if(container == this.frame) {
            final Insets insets = this.frame.getInsets();
            this.canvas.setLocation(this.field692 + insets.left, insets.top + this.field693);
         } else {
            this.canvas.setLocation(this.field692, this.field693);
         }
      }

      if(this.field703) {
         this.method904();
      }

      this.method932();
      this.methodDraw(this.field700);//resized?
      if(this.field700) {
         this.method903();
      }

      this.field700 = false;
   }

   private void method932() {
      final Bounds bounds = this.method925();
      if(this.field680 != bounds.field3942 || bounds.field3944 != this.field712 || this.field702) {
         this.method901();
         this.field702 = false;
      }

   }

   private void method911() {
      this.field702 = true;
   }

   private synchronized void method912() {
      if(!field690) {
         field690 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (final Exception ignored) {
         }

         try {
            this.vmethod1256();
         } catch (final Exception ignored) {
         }

         if(this.frame != null) {
            try {
               System.exit(0);
            } catch (final Throwable ignored) {
            }
         }

         if(taskManager != null) {
            try {
               taskManager.join();
            } catch (final Exception ignored) {
            }
         }

         this.vmethod1251();
      }
   }

   protected abstract void setUp();

   protected abstract void packetHandler();

   protected abstract void methodDraw(boolean var1);

   protected abstract void vmethod1256();

   final void drawLoadingScreen(final int var1, final String var2, final boolean var3) {
      try {
         final Graphics var4 = this.canvas.getGraphics();
         if(SoundTask.font_helvetica_bold13 == null) {
            SoundTask.font_helvetica_bold13 = new java.awt.Font("Helvetica", Font.BOLD, 13);
            ChatLineBuffer.field1479 = this.canvas.getFontMetrics(SoundTask.font_helvetica_bold13);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, canvasWidth, canvasHeight);
         }

         final Color var5 = new Color(140, 17, 17);

         try {
            if(TotalQuantityComparator.field304 == null) {
               TotalQuantityComparator.field304 = this.canvas.createImage(304, 34);
            }

            final Graphics var6 = TotalQuantityComparator.field304.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(SoundTask.font_helvetica_bold13);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - ChatLineBuffer.field1479.stringWidth(var2)) / 2, 22);
            var4.drawImage(TotalQuantityComparator.field304, canvasWidth / 2 - 152, canvasHeight / 2 - 18, null);
         } catch (final Exception var9) {
            final int var7 = canvasWidth / 2 - 152;
            final int var8 = canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(SoundTask.font_helvetica_bold13);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - ChatLineBuffer.field1479.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (final Exception var10) {
         this.canvas.repaint();
      }

   }

   final void method922() {
      TotalQuantityComparator.field304 = null;
      SoundTask.font_helvetica_bold13 = null;
      ChatLineBuffer.field1479 = null;
   }

   void error(final String var1) {
      if(!this.hasErrored) {
         this.hasErrored = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (final Exception ignored) {
         }

      }
   }

   private Container container() {
      return this.frame != null?this.frame:this;
   }

   private Bounds method925() {
      final Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field678);
      int var3 = Math.max(var1.getHeight(), this.field694);
      if(this.frame != null) {
         final Insets var4 = this.frame.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Bounds(var2, var3);
   }

   final boolean method926() {
      return this.frame != null;
   }

   protected abstract void vmethod1251();

   public final void destroy() {
      if(this == shell && !field690) {
         field681 = class64.method1118();
         ScriptVarType.method11(5000L);
         this.method912();
      }
   }

   public final synchronized void paint(final Graphics var1) {
      if(this == shell && !field690) {
         this.field700 = true;
         if(class64.method1118() - this.field704 > 1000L) {
            final Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= canvasWidth && var2.height >= canvasHeight) {
               this.field703 = true;
            }
         }

      }
   }

   public void run() {
      try {
         if(Signlink.javaVendor != null) {
            final String var1 = Signlink.javaVendor.toLowerCase();
            if(var1.contains("sun") || var1.contains("apple")) {
               final String var2 = Signlink.javaVersion;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.error("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class64.method1111(var2.charAt(var3)); ++var3) {
                  }

                  final String var4 = var2.substring(6, var3);
                  if(class7.method27(var4)) {
                     final int var5 = class150.parseInt(var4, 10);
                     if(var5 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field686 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.replaceCanvas();
         this.setUp();

         Object var9;
         try {
            var9 = new NanoTimer();
         } catch (final Throwable var7) {
            var9 = new MilliTimer();
         }

         UrlRequester.timer = (Timer)var9;

         while(field681 == 0L || class64.method1118() < field681) {
            field684 = UrlRequester.timer.vmethod3328(field685, field686);

            for(int var6 = 0; var6 < field684; ++var6) {
               this.method1015();
            }

            this.method910();
            this.method1002(this.canvas);
         }
      } catch (final Exception var8) {
         Signlink.processClientError(null, var8);
         this.error("crash");
      }

      this.method912();
   }

   public final void update(final Graphics var1) {
      this.paint(var1);
   }

   public final void start() {
      if(this == shell && !field690) {
         field681 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field690) {
         field681 = class64.method1118() + 4000L;
      }
   }

   public final void focusGained(final FocusEvent var1) {
      focused = true;
      this.field700 = true;
   }

   public final void windowActivated(final WindowEvent var1) {
   }

   public final void windowClosed(final WindowEvent var1) {
   }

   public final void windowClosing(final WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeactivated(final WindowEvent var1) {
   }

   public final void windowDeiconified(final WindowEvent var1) {
   }

   public abstract void init();

   public final void windowOpened(final WindowEvent var1) {
   }

   public final void windowIconified(final WindowEvent var1) {
   }

   public final void focusLost(final FocusEvent var1) {
      focused = false;
   }

   static boolean method984() {
      final long var0 = class64.method1118();
      int var2 = (int)(var0 - BoundingBox3DDrawMode.field270);
      BoundingBox3DDrawMode.field270 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class264.field3416 += var2;
      if(class264.NetCache_pendingResponsesCount == 0 && class264.NetCache_pendingPriorityResponsesCount == 0 && class264.NetCache_pendingWritesCount == 0 && class264.NetCache_pendingPriorityWritesCount == 0) {
         return true;
      } else if(class264.NetCache_socket == null) {
         return false;
      } else {
         try {
            if(class264.field3416 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class264.NetCache_pendingPriorityResponsesCount < 200 && class264.NetCache_pendingPriorityWritesCount > 0) {
                  var3 = (FileRequest)class264.NetCache_pendingPriorityWrites.first();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class264.NetCache_socket.vmethod3337(var4.payload, 0, 4);
                  class264.NetCache_pendingPriorityResponses.put(var3, var3.hash);
                  --class264.NetCache_pendingPriorityWritesCount;
                  ++class264.NetCache_pendingPriorityResponsesCount;
               }

               while(class264.NetCache_pendingResponsesCount < 200 && class264.NetCache_pendingWritesCount > 0) {
                  var3 = (FileRequest)class264.NetCache_pendingWritesQueue.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class264.NetCache_socket.vmethod3337(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class264.NetCache_pendingResponses.put(var3, var3.hash);
                  --class264.NetCache_pendingWritesCount;
                  ++class264.NetCache_pendingResponsesCount;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  final int var16 = class264.NetCache_socket.getAvailable();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class264.field3416 = 0;
                  byte var5 = 0;
                  if(WorldMapType4.currentRequest == null) {
                     var5 = 8;
                  } else if(class264.field3426 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class264.NetCache_responseHeaderBuffer.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class264.NetCache_socket.vmethod3348(class264.NetCache_responseHeaderBuffer.payload, class264.NetCache_responseHeaderBuffer.offset, var6);
                     if(class264.field3429 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class264.NetCache_responseHeaderBuffer.payload[var7 + class264.NetCache_responseHeaderBuffer.offset] ^= class264.field3429;
                        }
                     }

                     class264.NetCache_responseHeaderBuffer.offset += var6;
                     if(class264.NetCache_responseHeaderBuffer.offset < var5) {
                        break;
                     }

                     if(WorldMapType4.currentRequest == null) {
                        class264.NetCache_responseHeaderBuffer.offset = 0;
                        var7 = class264.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var8 = class264.NetCache_responseHeaderBuffer.readUnsignedShort();
                        final int var9 = class264.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var10 = class264.NetCache_responseHeaderBuffer.readInt();
                        final long var11 = (var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class264.NetCache_pendingPriorityResponses.get(var11);
                        class264.field3419 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class264.NetCache_pendingResponses.get(var11);
                           class264.field3419 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        final int var14 = var9 == 0?5:9;
                        WorldMapType4.currentRequest = var13;
                        class47.NetCache_responseArchiveBuffer = new Buffer(var10 + var14 + WorldMapType4.currentRequest.padding);
                        class47.NetCache_responseArchiveBuffer.putByte(var9);
                        class47.NetCache_responseArchiveBuffer.putInt(var10);
                        class264.field3426 = 8;
                        class264.NetCache_responseHeaderBuffer.offset = 0;
                     } else if(class264.field3426 == 0) {
                        if(class264.NetCache_responseHeaderBuffer.payload[0] == -1) {
                           class264.field3426 = 1;
                           class264.NetCache_responseHeaderBuffer.offset = 0;
                        } else {
                           WorldMapType4.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = class47.NetCache_responseArchiveBuffer.payload.length - WorldMapType4.currentRequest.padding;
                     var7 = 512 - class264.field3426;
                     if(var7 > var6 - class47.NetCache_responseArchiveBuffer.offset) {
                        var7 = var6 - class47.NetCache_responseArchiveBuffer.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class264.NetCache_socket.vmethod3348(class47.NetCache_responseArchiveBuffer.payload, class47.NetCache_responseArchiveBuffer.offset, var7);
                     if(class264.field3429 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class47.NetCache_responseArchiveBuffer.payload[class47.NetCache_responseArchiveBuffer.offset + var8] ^= class264.field3429;
                        }
                     }

                     class47.NetCache_responseArchiveBuffer.offset += var7;
                     class264.field3426 += var7;
                     if(var6 == class47.NetCache_responseArchiveBuffer.offset) {
                        if(WorldMapType4.currentRequest.hash == 16711935L) {
                           FrameMap.NetCache_reference = class47.NetCache_responseArchiveBuffer;

                           for(var8 = 0; var8 < 256; ++var8) {
                              final IndexData var17 = class264.NetCache_indexCaches[var8];
                              if(var17 != null) {
                                 FrameMap.NetCache_reference.offset = var8 * 8 + 5;
                                 var10 = FrameMap.NetCache_reference.readInt();
                                 final int var18 = FrameMap.NetCache_reference.readInt();
                                 var17.setInformation(var10, var18);
                              }
                           }
                        } else {
                           class264.NetCache_crc.reset();
                           class264.NetCache_crc.update(class47.NetCache_responseArchiveBuffer.payload, 0, var6);
                           var8 = (int)class264.NetCache_crc.getValue();
                           if(var8 != WorldMapType4.currentRequest.crc) {
                              try {
                                 class264.NetCache_socket.vmethod3331();
                              } catch (final Exception ignored) {
                              }

                              ++class264.field3430;
                              class264.NetCache_socket = null;
                              class264.field3429 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class264.field3430 = 0;
                           class264.field3431 = 0;
                           WorldMapType4.currentRequest.index.write((int)(WorldMapType4.currentRequest.hash & 65535L), class47.NetCache_responseArchiveBuffer.payload, 16711680L == (WorldMapType4.currentRequest.hash & 16711680L), class264.field3419);
                        }

                        WorldMapType4.currentRequest.unlink();
                        if(class264.field3419) {
                           --class264.NetCache_pendingPriorityResponsesCount;
                        } else {
                           --class264.NetCache_pendingResponsesCount;
                        }

                        class264.field3426 = 0;
                        WorldMapType4.currentRequest = null;
                        class47.NetCache_responseArchiveBuffer = null;
                     } else {
                        if(class264.field3426 != 512) {
                           break;
                        }

                        class264.field3426 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (final IOException var21) {
            try {
               class264.NetCache_socket.vmethod3331();
            } catch (final Exception ignored) {
            }

            ++class264.field3431;
            class264.NetCache_socket = null;
            return false;
         }
      }
   }

   public static Object byteArrayToObject(final byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.directBufferUnavailable) {
            try {
               final DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (final Throwable var3) {
               AbstractByteBuffer.directBufferUnavailable = true;
            }
         }

         return var0;
      }
   }

   static int adjustHSLListness0(final int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
