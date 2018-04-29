package com.oldscape.client;

class class160 implements class159 {
   public static boolean method3183() {
      final KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field623 == KeyFocusListener.field620) {
            return false;
         } else {
            Item.currentPressedKey = KeyFocusListener.field629[KeyFocusListener.field620];
            class38.currentTypedKey = KeyFocusListener.field632[KeyFocusListener.field620];
            KeyFocusListener.field620 = KeyFocusListener.field620 + 1 & 127;
            return true;
         }
      }
   }
}
