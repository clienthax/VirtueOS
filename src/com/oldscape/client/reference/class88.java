package com.oldscape.client.reference;

import java.math.BigInteger;

class class88 {
    static final BigInteger RSA_EXPONENT;
    static final BigInteger RSA_MODULUS;

    static {
//      RSA_EXPONENT = new BigInteger("10001", 16);
//      RSA_MODULUS = new BigInteger("8c2fa7b0d382137893318d3fda891138e957d00298df52ce53b5e53fda1eafb9dfa623bdc78fe87c2dcabd04698b27c446a72aee861ceed45c85e7c10db182d95e3514b67d44e92e1df9c10a3136207ffd9df0956fe4507fb969ab0abb4e19b876b16752f90de888c88e393a769c0c13977ee81c79549e9a690f112230ff4303", 16);
        RSA_EXPONENT = new BigInteger("65537");
        RSA_MODULUS = new BigInteger("165865706435016682110653568563251120094278686912987295809145491806194715902716739338411927793058925228087565434562948389222225588420069703784252638483569608159614392485969864899137973999614056797405232846059198315441808544524190866210655169682670028293787208173603935453834899795395794572295868565624049196373");
    }

    static void method1893(final int var0, final int var1, final int var2, final int var3, final int var4, final int var5, final int var6, final int var7) {
        if (class189.loadWidget(var0)) {
            class66.field785 = null;
            GameCanvas.gameDraw(MouseRecorder.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
            if (class66.field785 != null) {
                GameCanvas.gameDraw(class66.field785, -1412584499, var1, var2, var3, var4, CombatInfoListHolder.field1310, GrandExchangeEvent.field300, var7);
                class66.field785 = null;
            }

        } else {
            if (var7 != -1) {
                Client.field1072[var7] = true;
            } else {
                for (int var8 = 0; var8 < 100; ++var8) {
                    Client.field1072[var8] = true;
                }
            }

        }
    }

    static void method1894(final Widget widget) {
        final int contentType = widget.contentType;
        if (contentType == 324) {
            if (Client.field1044 == -1) {
                Client.field1044 = widget.spriteId;
                Client.field1138 = widget.field2858;
            }

            if (Client.field1132.isFemale) {
                widget.spriteId = Client.field1044;
            } else {
                widget.spriteId = Client.field1138;
            }

        } else if (contentType == 325) {
            if (Client.field1044 == -1) {
                Client.field1044 = widget.spriteId;
                Client.field1138 = widget.field2858;
            }

            if (Client.field1132.isFemale) {
                widget.spriteId = Client.field1138;
            } else {
                widget.spriteId = Client.field1044;
            }

        } else if (contentType == 327) {
            widget.rotationX = 150;
            widget.rotationZ = (int) (Math.sin(Client.gameCycle / 40.0D) * 256.0D) & 2047;
            widget.modelType = 5;
            widget.modelId = 0;
        } else if (contentType == 328) {
            widget.rotationX = 150;
            widget.rotationZ = (int) (Math.sin(Client.gameCycle / 40.0D) * 256.0D) & 2047;
            widget.modelType = 5;
            widget.modelId = 1;
        }
    }
}
