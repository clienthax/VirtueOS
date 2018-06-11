package com.oldscape.client.reference;

public class Sequence extends CacheableNode {
    static final NodeCache sequences;
    static final NodeCache skeletons;
    static IndexDataBase seq_ref;
    static IndexDataBase skel_ref;
    static IndexDataBase skin_ref;

    static {
        sequences = new NodeCache(64);
        skeletons = new NodeCache(100);
    }

    public int[] frameIDs;
    public int[] frameLengths;
    public int[] field3759;
    public int frameStep;
    public boolean stretches;
    public int forcedPriority;
    public int leftHandItem;
    public int rightHandItem;
    public int maxLoops;
    public int precedenceAnimating;
    public int priority;
    public int replyMode;
    private int[] field3758;
    private int[] interleaveLeave;

    Sequence() {
        this.frameStep = -1;
        this.stretches = false;
        this.forcedPriority = 5;
        this.leftHandItem = -1;
        this.rightHandItem = -1;
        this.maxLoops = 99;
        this.precedenceAnimating = -1;
        this.priority = -1;
        this.replyMode = 2;
    }

    void decode(final Buffer var1) {
        while (true) {
            final int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.readNext(var1, var2);
        }
    }

    private void readNext(final Buffer var1, final int var2) {
        final int var3;
        int var4;
        if (var2 == 1) {
            var3 = var1.readUnsignedShort();
            this.frameLengths = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameLengths[var4] = var1.readUnsignedShort();
            }

            this.frameIDs = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameIDs[var4] = var1.readUnsignedShort();
            }

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameIDs[var4] += var1.readUnsignedShort() << 16;
            }
        } else if (var2 == 2) {
            this.frameStep = var1.readUnsignedShort();
        } else if (var2 == 3) {
            var3 = var1.readUnsignedByte();
            this.interleaveLeave = new int[var3 + 1];

            for (var4 = 0; var4 < var3; ++var4) {
                this.interleaveLeave[var4] = var1.readUnsignedByte();
            }

            this.interleaveLeave[var3] = 9999999;
        } else if (var2 == 4) {
            this.stretches = true;
        } else if (var2 == 5) {
            this.forcedPriority = var1.readUnsignedByte();
        } else if (var2 == 6) {
            this.leftHandItem = var1.readUnsignedShort();
        } else if (var2 == 7) {
            this.rightHandItem = var1.readUnsignedShort();
        } else if (var2 == 8) {
            this.maxLoops = var1.readUnsignedByte();
        } else if (var2 == 9) {
            this.precedenceAnimating = var1.readUnsignedByte();
        } else if (var2 == 10) {
            this.priority = var1.readUnsignedByte();
        } else if (var2 == 11) {
            this.replyMode = var1.readUnsignedByte();
        } else if (var2 == 12) {
            var3 = var1.readUnsignedByte();
            this.field3758 = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.field3758[var4] = var1.readUnsignedShort();
            }

            for (var4 = 0; var4 < var3; ++var4) {
                this.field3758[var4] += var1.readUnsignedShort() << 16;
            }
        } else if (var2 == 13) {
            var3 = var1.readUnsignedByte();
            this.field3759 = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.field3759[var4] = var1.read24BitInt();
            }
        }

    }

    void post() {
        if (this.precedenceAnimating == -1) {
            if (this.interleaveLeave != null) {
                this.precedenceAnimating = 2;
            } else {
                this.precedenceAnimating = 0;
            }
        }

        if (this.priority == -1) {
            if (this.interleaveLeave != null) {
                this.priority = 2;
            } else {
                this.priority = 0;
            }
        }

    }

    public Model transformActorModel(final Model var1, int var2) {
        var2 = this.frameIDs[var2];
        final Frames var3 = Item.getFrames(var2 >> 16);
        var2 &= 65535;
        if (var3 == null) {
            return var1.toSharedModel(true);
        } else {
            final Model var4 = var1.toSharedModel(!var3.method3063(var2));
            var4.method2695(var3, var2);
            return var4;
        }
    }

    Model transformObjectModel(final Model var1, int var2, int var3) {
        var2 = this.frameIDs[var2];
        final Frames var4 = Item.getFrames(var2 >> 16);
        var2 &= 65535;
        if (var4 == null) {
            return var1.toSharedModel(true);
        } else {
            final Model var5 = var1.toSharedModel(!var4.method3063(var2));
            var3 &= 3;
            if (var3 == 1) {
                var5.rotateY270Ccw();
            } else if (var3 == 2) {
                var5.rotateY180Ccw();
            } else if (var3 == 3) {
                var5.rotateY90Ccw();
            }

            var5.method2695(var4, var2);
            if (var3 == 1) {
                var5.rotateY90Ccw();
            } else if (var3 == 2) {
                var5.rotateY180Ccw();
            } else if (var3 == 3) {
                var5.rotateY270Ccw();
            }

            return var5;
        }
    }

    Model transformSpotAnimModel(final Model var1, int var2) {
        var2 = this.frameIDs[var2];
        final Frames var3 = Item.getFrames(var2 >> 16);
        var2 &= 65535;
        if (var3 == null) {
            return var1.toSharedSpotAnimModel(true);
        } else {
            final Model var4 = var1.toSharedSpotAnimModel(!var3.method3063(var2));
            var4.method2695(var3, var2);
            return var4;
        }
    }

    public Model applyTransformations(final Model var1, int var2, final Sequence var3, int var4) {
        var2 = this.frameIDs[var2];
        final Frames var5 = Item.getFrames(var2 >> 16);
        var2 &= 65535;
        if (var5 == null) {
            return var3.transformActorModel(var1, var4);
        } else {
            var4 = var3.frameIDs[var4];
            final Frames var6 = Item.getFrames(var4 >> 16);
            var4 &= 65535;
            final Model var7;
            if (var6 == null) {
                var7 = var1.toSharedModel(!var5.method3063(var2));
                var7.method2695(var5, var2);
            } else {
                var7 = var1.toSharedModel(!var5.method3063(var2) & !var6.method3063(var4));
                var7.method2745(var5, var2, var6, var4, this.interleaveLeave);
            }
            return var7;
        }
    }

    public Model method5180(final Model model, final int sequenceFrame) {
        int frameID = this.frameIDs[sequenceFrame];
        final Frames frames = Item.getFrames(frameID >> 16);
        frameID &= 65535;
        if (frames == null) {
            return model.toSharedModel(true);
        } else {
            Frames tempFrame = null;
            int var6 = 0;
            if (this.field3758 != null && sequenceFrame < this.field3758.length) {
                var6 = this.field3758[sequenceFrame];
                tempFrame = Item.getFrames(var6 >> 16);
                var6 &= 65535;
            }

            final Model tempModel;
            if (tempFrame != null && var6 != 65535) {
                tempModel = model.toSharedModel(!frames.method3063(frameID) & !tempFrame.method3063(var6));
                tempModel.method2695(frames, frameID);
                tempModel.method2695(tempFrame, var6);
            } else {
                tempModel = model.toSharedModel(!frames.method3063(frameID));
                tempModel.method2695(frames, frameID);
            }
            return tempModel;
        }
    }
}
