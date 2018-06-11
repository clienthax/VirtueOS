package com.oldscape.client.reference;

public class class298 extends NameableContainer {
    static int[] mapRegions;
    private final JagexLoginType loginType;

    public class298(final JagexLoginType var1) {
        super(400);
        this.loginType = var1;
    }

    Nameable vmethod5454() {
        return new Ignore();
    }

    Nameable[] vmethod5462(final int var1) {
        return new Ignore[var1];
    }

    public void method5294(final Buffer var1, final int var2) {
        while (true) {
            if (var1.offset < var2) {
                final int var3 = var1.readUnsignedByte();
                final boolean var4 = (var3 & 1) == 1;
                final Name currentName = new Name(var1.readString(), this.loginType);//current currentName
                final Name previousName = new Name(var1.readString(), this.loginType);//previous currentName
//            System.out.println(currentName.currentName+", "+previousName.currentName);
                var1.readString();
                if (currentName.isCleanNameValid()) {
                    Ignore var7 = (Ignore) this.method5327(currentName);
                    if (var4) {
                        final Ignore var8 = (Ignore) this.method5327(previousName);
                        if (var8 != null && var7 != var8) {
                            if (var7 != null) {
                                this.method5311(var8);
                            } else {
                                var7 = var8;
                            }
                        }
                    }

                    if (var7 != null) {
                        this.method5316(var7, currentName, previousName);
                        continue;
                    }

                    if (this.getCount() < 400) {
                        final int var9 = this.getCount();
                        var7 = (Ignore) this.method5313(currentName, previousName);
                        var7.field3844 = var9;
                    }
                    continue;
                }

                throw new IllegalStateException();
            }

            return;
        }
    }
}
