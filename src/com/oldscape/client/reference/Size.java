package com.oldscape.client.reference;

public class Size {
    public static final Size small;
    public static final Size medium;
    public static final Size large;
    public static CacheFile[] idxFiles;
    static int field369;
    static IndexData configsIndex;
    static Task field364;

    static {
        small = new Size("SMALL", 1, 0, 4);
        medium = new Size("MEDIUM", 0, 1, 2);
        large = new Size("LARGE", 2, 2, 0);
    }

    private final String name;
    private final int field362;
    private final int id;
    private final int field372;

    private Size(final String name, final int var2, final int id, final int var4) {
        this.name = name;
        this.field362 = var2;
        this.id = id;
        this.field372 = var4;
    }

    static Size getSizeFromId(final int id) {

        for (final Size size : new Size[]{large, small, medium}) {
            if (id == size.id) {
                return size;
            }
        }

        return null;
    }

    static void method199() {
        class57.sendGameMessage(30, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
    }

    static void method198() {
        Client.menuOptionCount = 0;
        Client.isMenuOpen = false;
        Client.menuOptions[0] = "Cancel";
        Client.menuTargets[0] = "";
        Client.menuTypes[0] = 1006;
        Client.menuBooleanArray[0] = false;
        Client.menuOptionCount = 1;
    }

    boolean method192(final float var1) {
        return var1 >= this.field372;
    }
}
