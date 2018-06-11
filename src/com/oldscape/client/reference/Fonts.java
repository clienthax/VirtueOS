package com.oldscape.client.reference;

import java.util.HashMap;

class Fonts {
    static SpritePixels[] headIconsPrayer;
    private final IndexDataBase indexSprites;
    private final IndexDataBase field3890;
    private final HashMap<FontName, Font> map;

    public Fonts(final IndexDataBase indexSprites, final IndexDataBase var2) {
        this.indexSprites = indexSprites;
        this.field3890 = var2;
        this.map = new HashMap<>();
    }

    public HashMap<FontName, Font> createMap(final FontName[] var1) {
        final HashMap<FontName, Font> tempMap = new HashMap<>();

        for (final FontName fontName : var1) {
            if (this.map.containsKey(fontName)) {
                tempMap.put(fontName, this.map.get(fontName));
            } else {
                final IndexDataBase var7 = this.indexSprites;
                final IndexDataBase var8 = this.field3890;
                final String fileName = fontName.fileName;
                final int var10 = var7.getFile(fileName);
                final int var11 = var7.getChild(var10, "");
                final Font font = FontName.method5488(var7, var8, var10, var11);
                if (font != null) {
                    this.map.put(fontName, font);
                    tempMap.put(fontName, font);
                }
            }
        }

        return tempMap;
    }
}
