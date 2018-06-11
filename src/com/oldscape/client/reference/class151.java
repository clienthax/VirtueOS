package com.oldscape.client.reference;

class class151 extends class297 {
    static IndexData indexSprites;
    private final boolean field2147;

    public class151(final boolean var1) {
        this.field2147 = var1;
    }

    public static void method3130(final IndexDataBase var0) {
        VarPlayerType.varplayer_ref = var0;
        class289.field3777 = VarPlayerType.varplayer_ref.fileCount(16);
    }

    private int method3123(final ChatPlayer var1, final ChatPlayer var2) {
        if (Client.world == var1.world) {
            if (var2.world != Client.world) {
                return this.field2147 ? -1 : 1;
            }
        } else if (var2.world == Client.world) {
            return this.field2147 ? 1 : -1;
        }

        return this.doCompare(var1, var2);
    }

    public int compare(final Object var1, final Object var2) {
        return this.method3123((ChatPlayer) var1, (ChatPlayer) var2);
    }
}
