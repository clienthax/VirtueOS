package com.oldscape.client.reference;

public interface ITextureLoader {
    int[] load(int var1);

    int getAverageTextureRGB(int textureId);

    boolean vmethod3069(int textureId);

    boolean isLowMem(int textureId);
}
