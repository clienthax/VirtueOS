package com.oldscape.client.reference;

class class315 {
    static final char[] field3920;
    static final char[] field3922;

    static {
        field3920 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
        field3922 = new char[]{'[', ']', '#'};
    }

    public static void method5614(final int var0, int var1) {
        Varbit var3 = (Varbit) Varbit.varbits.get(var0);
        final Varbit var2;
        if (var3 == null) {
            final byte[] var8 = Varbit.varbit_ref.getConfigData(14, var0);
            var3 = new Varbit();
            if (var8 != null) {
                var3.decode(new Buffer(var8));
            }

            Varbit.varbits.put(var3, var0);
        }
        var2 = var3;

        final int var4 = var2.configId;
        final int var5 = var2.leastSignificantBit;
        final int var6 = var2.mostSignificantBit;
        int var7 = VarpStorage.varpsMasks[var6 - var5];
        if (var1 < 0 || var1 > var7) {
            var1 = 0;
        }

        var7 <<= var5;
        VarpStorage.clientVarps[var4] = VarpStorage.clientVarps[var4] & ~var7 | var1 << var5 & var7;
    }
}
