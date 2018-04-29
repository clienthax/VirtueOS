package com.oldscape.client;

import java.nio.ByteBuffer;

class DirectByteBuffer extends AbstractByteBuffer {
   private ByteBuffer buffer;

   @Override
   byte[] get() {
      final byte[] bytes = new byte[this.buffer.capacity()];
      this.buffer.position(0);
      this.buffer.get(bytes);
      return bytes;
   }

   @Override
   void put(final byte[] bytes) {
      this.buffer = ByteBuffer.allocateDirect(bytes.length);
      this.buffer.position(0);
      this.buffer.put(bytes);
   }
}
