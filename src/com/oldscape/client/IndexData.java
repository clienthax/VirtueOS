package com.oldscape.client;

import java.util.zip.CRC32;

public class IndexData extends IndexDataBase {
   private static final CRC32 crc32;
   private IndexFile indexStore;
   private IndexFile referenceStore;
   private int index;
   private volatile boolean field3407;
   private boolean field3410;
   private volatile boolean[] validArchives;
   private int crcValue;
   private int indexReferenceVersion;
   private int field3412;

   static {
      crc32 = new CRC32();
   }

   public IndexData(final IndexFile var1, final IndexFile var2, final int var3, final boolean var4, final boolean var5, final boolean var6) {
      super(var4, var5);
      this.field3407 = false;
      this.field3410 = false;
      this.field3412 = -1;
      this.indexStore = var1;
      this.referenceStore = var2;
      this.index = var3;
      this.field3410 = var6;
      final int var8 = this.index;
      if(FrameMap.NetCache_reference != null) {
         FrameMap.NetCache_reference.offset = var8 * 8 + 5;
         final int var9 = FrameMap.NetCache_reference.readInt();
         final int var10 = FrameMap.NetCache_reference.readInt();
         this.setInformation(var9, var10);
      } else {
         class2.requestNetFile(null, 255, 255, 0, (byte)0, true);
         class264.NetCache_indexCaches[var8] = this;
      }

   }

   void vmethod4634(final int var1) {
      final int var2 = this.index;
      final long var3 = ((var2 << 16) + var1);
      final FileRequest var5 = (FileRequest)class264.NetCache_pendingWrites.get(var3);
      if(var5 != null) {
         class264.NetCache_pendingWritesQueue.setHead(var5);
      }

   }

   int archiveLoadPercent(final int var1) {
      if(super.archives[var1] != null) {
         return 100;
      } else if(this.validArchives[var1]) {
         return 100;
      } else {
         final int var3 = this.index;
         final long var4 = ((var3 << 16) + var1);
         final int var2;
         if(WorldMapType4.currentRequest != null && WorldMapType4.currentRequest.hash == var4) {
            var2 = class47.NetCache_responseArchiveBuffer.offset * 99 / (class47.NetCache_responseArchiveBuffer.payload.length - WorldMapType4.currentRequest.padding) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   void loadArchive(final int var1) {
      if(this.indexStore != null && this.validArchives != null && this.validArchives[var1]) {
         CombatInfoListHolder.method1871(var1, this.indexStore, this);
      } else {
         class2.requestNetFile(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   public int percentage() {
      if(this.field3407) {
         return 100;
      } else if(super.archives != null) {
         return 99;
      } else {
         final int var2 = this.index;
         final long var3 = (var2 + 16711680);
         final int var1;
         if(WorldMapType4.currentRequest != null && var3 == WorldMapType4.currentRequest.hash) {
            var1 = class47.NetCache_responseArchiveBuffer.offset * 99 / (class47.NetCache_responseArchiveBuffer.payload.length - WorldMapType4.currentRequest.padding) + 1;
         } else {
            var1 = 0;
         }

         int var5 = var1;
         if(var1 >= 100) {
            var5 = 99;
         }

         return var5;
      }
   }

   void setInformation(final int var1, final int var2) {
      this.crcValue = var1;
      this.indexReferenceVersion = var2;
      if(this.referenceStore != null) {
         CombatInfoListHolder.method1871(this.index, this.referenceStore, this);
      } else {
         class2.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   void write(final int var1, final byte[] var2, final boolean var3, final boolean var4) {
      if(var3) {
         if(this.field3407) {
            throw new RuntimeException();
         }

         if(this.referenceStore != null) {
            final int var5 = this.index;
            final IndexFile var6 = this.referenceStore;
            final FileSystem var7 = new FileSystem();
            var7.type = 0;
            var7.hash = var5;
            var7.field3367 = var2;
            var7.index = var6;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
               IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var7);
            }

            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
               if(IndexStoreActionHandler.field3401 == 0) {
                  class229.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
                  class229.IndexStoreActionHandler_thread.setDaemon(true);
                  class229.IndexStoreActionHandler_thread.start();
                  class229.IndexStoreActionHandler_thread.setPriority(5);
               }

               IndexStoreActionHandler.field3401 = 600;
            }
         }

         this.setIndexReference(var2);
         this.loadAllLocal();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.indexStore != null) {
            final IndexFile var13 = this.indexStore;
            final FileSystem var18 = new FileSystem();
            var18.type = 0;
            var18.hash = var1;
            var18.field3367 = var2;
            var18.index = var13;
            final Deque var19 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
               IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var18);
            }

            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
               if(IndexStoreActionHandler.field3401 == 0) {
                  class229.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
                  class229.IndexStoreActionHandler_thread.setDaemon(true);
                  class229.IndexStoreActionHandler_thread.start();
                  class229.IndexStoreActionHandler_thread.setPriority(5);
               }

               IndexStoreActionHandler.field3401 = 600;
            }

            this.validArchives[var1] = true;
         }

         if(var4) {
            super.archives[var1] = GameEngine.byteArrayToObject(var2);
         }
      }

   }

   public void load(final IndexFile var1, final int var2, final byte[] var3, final boolean var4) {
      final int var5;
      if(var1 == this.referenceStore) {
         if(this.field3407) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class2.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         if(var5 != this.crcValue) {
            class2.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         final Buffer var9 = new Buffer(WorldMapType3.decodeContainer(var3));
         final int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var8 != this.indexReferenceVersion) {
            class2.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.setIndexReference(var3);
         this.loadAllLocal();
      } else {
         if(!var4 && var2 == this.field3412) {
            this.field3407 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.validArchives[var2] = false;
            if(this.field3410 || var4) {
               class2.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         final int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.validArchives[var2] = false;
            if(this.field3410 || var4) {
               class2.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.validArchives[var2] = true;
         if(var4) {
            super.archives[var2] = GameEngine.byteArrayToObject(var3);
         }
      }

   }

   private void loadAllLocal() {
      this.validArchives = new boolean[super.archives.length];

      int var1;
      for(var1 = 0; var1 < this.validArchives.length; ++var1) {
         this.validArchives[var1] = false;
      }

      if(this.indexStore == null) {
         this.field3407 = true;
      } else {
         this.field3412 = -1;

         for(var1 = 0; var1 < this.validArchives.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               final IndexFile var2 = this.indexStore;
               final FileSystem var4 = new FileSystem();
               var4.type = 1;
               var4.hash = var1;
               var4.index = var2;
               var4.data = this;
               synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
                  IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var4);
               }

               synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
                  if(IndexStoreActionHandler.field3401 == 0) {
                     class229.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
                     class229.IndexStoreActionHandler_thread.setDaemon(true);
                     class229.IndexStoreActionHandler_thread.start();
                     class229.IndexStoreActionHandler_thread.setPriority(5);
                  }

                  IndexStoreActionHandler.field3401 = 600;
               }

               this.field3412 = var1;
            }
         }

         if(this.field3412 == -1) {
            this.field3407 = true;
         }

      }
   }

   public boolean method4636(final int var1) {
      return this.validArchives[var1];
   }

   public boolean method4642(final int var1) {
      return this.getChilds(var1) != null;
   }

   public int loadPercent() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.archives.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.archiveLoadPercent(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }
}
