package com.oldscape.client.reference;

public final class class213 {
    private final int field2640;
    private final IterableHashTable field2642;
    private final IterableDualNodeQueue field2643;
    private int field2641;

    public class213(final int var1, final int var2) {
        this.field2643 = new IterableDualNodeQueue();
        this.field2640 = var1;
        this.field2641 = var1;

        int var3;
        for (var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
        }

        this.field2642 = new IterableHashTable(var3);
    }

    public Object method3932(final long var1) {
        final class224 var3 = (class224) this.field2642.get(var1);
        if (var3 == null) {
            return null;
        } else {
            final Object var4 = var3.vmethod4084();
            if (var4 == null) {
                var3.unlink();
                var3.unlinkDual();
                this.field2641 += var3.field2669;
                return null;
            } else {
                if (var3.vmethod4087()) {
                    final class208 var5 = new class208(var4, var3.field2669);
                    this.field2642.put(var5, var3.hash);
                    this.field2643.add(var5);
                    var5.field2658 = 0L;
                    var3.unlink();
                    var3.unlinkDual();
                } else {
                    this.field2643.add(var3);
                    var3.field2658 = 0L;
                }

                return var4;
            }
        }
    }

    private void method3933(final long var1) {
        final class224 var3 = (class224) this.field2642.get(var1);
        this.method3931(var3);
    }

    private void method3931(final class224 var1) {
        if (var1 != null) {
            var1.unlink();
            var1.unlinkDual();
            this.field2641 += var1.field2669;
        }

    }

    public void method3935(final Object var1, final long var2) {
        this.method3936(var1, var2, 1);
    }

    public void method3936(final Object var1, final long var2, final int var4) {
        if (var4 > this.field2640) {
            throw new IllegalStateException();
        } else {
            this.method3933(var2);
            this.field2641 -= var4;

            while (this.field2641 < 0) {
                final class224 var5 = (class224) this.field2643.method4104();
                this.method3931(var5);
            }

            final class208 var6 = new class208(var1, var4);
            this.field2642.put(var6, var2);
            this.field2643.add(var6);
            var6.field2658 = 0L;
        }
    }

    public void method3937(final int var1) {
        for (class224 var2 = (class224) this.field2643.method4118(); var2 != null; var2 = (class224) this.field2643.method4107()) {
            if (var2.vmethod4087()) {
                if (var2.vmethod4084() == null) {
                    var2.unlink();
                    var2.unlinkDual();
                    this.field2641 += var2.field2669;
                }
            } else if (++var2.field2658 > var1) {
                final class219 var3 = new class219(var2.vmethod4084(), var2.field2669);
                this.field2642.put(var3, var2.hash);
                Node2LinkedList.method3860(var3, var2);
                var2.unlink();
                var2.unlinkDual();
            }
        }

    }

    public void method3938() {
        this.field2643.clear();
        this.field2642.clear();
        this.field2641 = this.field2640;
    }
}
