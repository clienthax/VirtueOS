package com.oldscape.client.reference;

final class class80 extends Node {
    static final Deque field1263;

    static {
        field1263 = new Deque();
    }

    int field1259;
    int field1265;
    int field1261;
    int field1269;
    int field1262;
    int field1273;
    int ambientSoundId;
    class115 field1266;
    int field1267;
    int field1268;
    int[] field1274;
    int field1270;
    class115 field1271;
    ObjectComposition objectComposition;

    void method1794() {
        final int currentAmbientSoundId = this.ambientSoundId;
        final ObjectComposition objectComposition = this.objectComposition.getImpostor();
        if (objectComposition != null) {
            this.ambientSoundId = objectComposition.ambientSoundId;
            this.field1273 = objectComposition.int4 * 128;
            this.field1267 = objectComposition.int5;
            this.field1268 = objectComposition.int6;
            this.field1274 = objectComposition.field3614;
        } else {
            this.ambientSoundId = -1;
            this.field1273 = 0;
            this.field1267 = 0;
            this.field1268 = 0;
            this.field1274 = null;
        }

        if (currentAmbientSoundId != this.ambientSoundId && this.field1266 != null) {
            MouseInput.field727.method2060(this.field1266);
            this.field1266 = null;
        }

    }
}
