package com.oldscape.client;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;

public final class FileOnDisk {
   private RandomAccessFile file;
   private long length;
   private long position;

   public FileOnDisk(final File var1, final String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      final int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   final void seek(final long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   public final void write(final byte[] var1, final int var2, final int var3) throws IOException {
      if(var3 + this.position > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += var3;
      }
   }

   public final void close() throws IOException {
      this.closeSync(false);
   }

   public final void closeSync(final boolean var1) throws IOException {
      if(this.file != null) {
         if(var1) {
            try {
               this.file.getFD().sync();
            } catch (final SyncFailedException ignored) {
            }
         }

         this.file.close();
         this.file = null;
      }

   }

   public final long length() throws IOException {
      return this.file.length();
   }

   public final int read(final byte[] var1, final int var2, final int var3) throws IOException {
      final int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println();
         this.close();
      }

   }
}
