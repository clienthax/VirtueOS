package com.oldscape.client;

import java.awt.Component;
import java.io.EOFException;
import java.io.IOException;

public class CacheFile {
   FileOnDisk accessFile;
   byte[] readPayload;
   long field1694;
   int field1693;
   byte[] writePayload;
   long field1697;
   int field1698;
   long position;
   long length;
   long capacity;
   long field1702;

   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1694 = -1L;
      this.field1697 = -1L;
      this.field1698 = 0;
      this.accessFile = var1;
      this.capacity = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   public void close() throws IOException {
      this.flush();
      this.accessFile.close();
   }

   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   public long length() {
      return this.capacity;
   }

   public void read(byte[] var1) throws IOException {
      this.read(var1, 0, var1.length);
   }

   public void read(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1697 != -1L && this.position >= this.field1697 && (long)var3 + this.position <= this.field1697 + (long)this.field1698) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1697), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1694 && this.position < (long)this.field1693 + this.field1694) {
            var8 = (int)((long)this.field1693 - (this.position - this.field1694));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1694), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.accessFile.seek(this.position);

            for(this.field1702 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1702 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.load();
            var8 = var3;
            if(var3 > this.field1693) {
               var8 = this.field1693;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(-1L != this.field1697) {
            if(this.field1697 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1697 - this.position);
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.position;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1697 >= var4 && this.field1697 < (long)var7 + var4) {
               var13 = this.field1697;
            } else if(var4 >= this.field1697 && var4 < this.field1697 + (long)this.field1698) {
               var13 = var4;
            }

            if((long)this.field1698 + this.field1697 > var4 && (long)this.field1698 + this.field1697 <= (long)var7 + var4) {
               var10 = this.field1697 + (long)this.field1698;
            } else if((long)var7 + var4 > this.field1697 && var4 + (long)var7 <= this.field1697 + (long)this.field1698) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1697), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1702 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   void load() throws IOException {
      this.field1693 = 0;
      if(this.position != this.field1702) {
         this.accessFile.seek(this.position);
         this.field1702 = this.position;
      }

      int var1;
      for(this.field1694 = this.position; this.field1693 < this.readPayload.length; this.field1693 += var1) {
         var1 = this.accessFile.read(this.readPayload, this.field1693, this.readPayload.length - this.field1693);
         if(var1 == -1) {
            break;
         }

         this.field1702 += (long)var1;
      }

   }

   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.position + (long)var3 > this.capacity) {
            this.capacity = this.position + (long)var3;
         }

         if(-1L != this.field1697 && (this.position < this.field1697 || this.position > (long)this.field1698 + this.field1697)) {
            this.flush();
         }

         if(-1L != this.field1697 && this.position + (long)var3 > this.field1697 + (long)this.writePayload.length) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1697));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1697), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1698 = this.writePayload.length;
            this.flush();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(this.field1697 == -1L) {
                  this.field1697 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1697), var3);
               this.position += (long)var3;
               if(this.position - this.field1697 > (long)this.field1698) {
                  this.field1698 = (int)(this.position - this.field1697);
               }

            }
         } else {
            if(this.field1702 != this.position) {
               this.accessFile.seek(this.position);
               this.field1702 = this.position;
            }

            this.accessFile.write(var1, var2, var3);
            this.field1702 += (long)var3;
            if(this.field1702 > this.length) {
               this.length = this.field1702;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1694 && this.position < (long)this.field1693 + this.field1694) {
               var9 = this.position;
            } else if(this.field1694 >= this.position && this.field1694 < (long)var3 + this.position) {
               var9 = this.field1694;
            }

            if(this.position + (long)var3 > this.field1694 && this.position + (long)var3 <= this.field1694 + (long)this.field1693) {
               var6 = (long)var3 + this.position;
            } else if((long)this.field1693 + this.field1694 > this.position && (long)this.field1693 + this.field1694 <= (long)var3 + this.position) {
               var6 = this.field1694 + (long)this.field1693;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1694), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1702 = -1L;
         throw var12;
      }
   }

   void flush() throws IOException {
      if(-1L != this.field1697) {
         if(this.field1702 != this.field1697) {
            this.accessFile.seek(this.field1697);
            this.field1702 = this.field1697;
         }

         this.accessFile.write(this.writePayload, 0, this.field1698);
         this.field1702 += 1514538769L * (long)(this.field1698 * 102222321);
         if(this.field1702 > this.length) {
            this.length = this.field1702;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1697 >= this.field1694 && this.field1697 < this.field1694 + (long)this.field1693) {
            var1 = this.field1697;
         } else if(this.field1694 >= this.field1697 && this.field1694 < this.field1697 + (long)this.field1698) {
            var1 = this.field1694;
         }

         if(this.field1697 + (long)this.field1698 > this.field1694 && this.field1697 + (long)this.field1698 <= (long)this.field1693 + this.field1694) {
            var3 = this.field1697 + (long)this.field1698;
         } else if((long)this.field1693 + this.field1694 > this.field1697 && this.field1694 + (long)this.field1693 <= this.field1697 + (long)this.field1698) {
            var3 = this.field1694 + (long)this.field1693;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1697), this.readPayload, (int)(var1 - this.field1694), var5);
         }

         this.field1697 = -1L;
         this.field1698 = 0;
      }

   }

   static void method2545(Component var0) {
      var0.removeKeyListener(KeyFocusListener.keyboard);
      var0.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field627 = -1;
   }

   static final int method2544(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
