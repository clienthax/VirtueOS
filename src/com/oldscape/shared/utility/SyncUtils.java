package com.oldscape.shared.utility;

import com.oldscape.server.game.model.sync.block.encode.*;
import com.oldscape.server.game.model.sync.descriptor.*;
import com.oldscape.server.game.model.sync.segment.SegmentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SyncUtils {

    private static final Map<SegmentType, SynchronizationDescriptor> pDescriptors = new HashMap<>();
    private static final Map<SegmentType, SynchronizationDescriptor> nDescriptors = new HashMap<>();
    private static final List<SynchronizationBlockEncoder> pBlocks = new ArrayList<>(12);
    private static final List<SynchronizationBlockEncoder> nBlocks = new ArrayList<>(8);

    private static final byte[] DIRECTION_DELTA_X = new byte[]{-1, 0, 1, -1, 1, -1, 0, 1};
    private static final byte[] DIRECTION_DELTA_Y = new byte[]{-1, -1, -1, 0, 0, 1, 1, 1};

    static {
        pDescriptors.put(SegmentType.CYCLE_START, new CycleStartDescriptor());
        pDescriptors.put(SegmentType.CYCLE_END, new CycleEndDescriptor());
        pDescriptors.put(SegmentType.SKIP, new PlayerSkipDescriptor());
        pDescriptors.put(SegmentType.ADD_MOB, new PlayerAdditionDescriptor());
        pDescriptors.put(SegmentType.REMOVE_MOB, new PlayerRemovalDescriptor());
        pDescriptors.put(SegmentType.TELEPORT, new PlayerTeleportDescriptor());
        pDescriptors.put(SegmentType.WALK, new PlayerWalkDescriptor());
        pDescriptors.put(SegmentType.RUN, new PlayerRunDescriptor());
        pDescriptors.put(SegmentType.NO_MOVEMENT, new PlayerStillDescriptor());

        nDescriptors.put(SegmentType.ADD_MOB, new NpcAdditionDescriptor());
        nDescriptors.put(SegmentType.REMOVE_MOB, new NpcRemovalDescriptor());
        nDescriptors.put(SegmentType.WALK, new NpcWalkDescriptor());
        nDescriptors.put(SegmentType.RUN, new NpcRunDescriptor());
        nDescriptors.put(SegmentType.NO_MOVEMENT, new NpcStillDescriptor());

        //TODO these need to match up with the clients ordering, or else they will be read out of order
        /**
         * Correct order for 168
         * 4 - forcechat
         * 64 - face entity
         * 16 - orientation
         * 128 - hitmasks
         * 2048 - context menu -- doesn't seem to be in this yet
         * 1 - animation
         * 256 - gfx
         * 8 - chat masks
         * 512 - movement mask
         * 1024 - forced movement
         * 4096 - unknown - temp movement?
         * 2 - appearance
         *
         * TODO hit updates need to be remade for 168
         * TODO implement context menu
         *
         */
        pBlocks.add(new ForceChatBlockEncoder());//4
        pBlocks.add(new InteractingMobBlockEncoder());//64
        pBlocks.add(new OrientationBlockEncoder());//16
        pBlocks.add(new HitUpdateBlockEncoder());//TODO update
        pBlocks.add(new ContextMenuBlockEncoder());//2048
        pBlocks.add(new AnimationBlockEncoder());//1
        pBlocks.add(new GraphicBlockEncoder());//256
        pBlocks.add(new ChatBlockEncoder());//8
        pBlocks.add(new MovementTypeBlockEncoder());//512
        pBlocks.add(new ForceMovementBlockEncoder());//1024
        pBlocks.add(new TemporaryMovementTypeBlockEncoder());//4096
        pBlocks.add(new AppearanceBlockEncoder());//2

        //pBlocks.add(new SecondaryHitUpdateBlockEncoder());


        /**
         * Correct order for 168
         * 4	- animation
         * 64	- transform
         * 2	-
         * 32	- face entity
         * 16	- hitmasks?
         * 1	- gfx
         * 8	-
         */

        nBlocks.add(new AnimationBlockEncoder());//4
        nBlocks.add(new TransformBlockEncoder());//64
        nBlocks.add(new OrientationBlockEncoder());//2
        nBlocks.add(new InteractingMobBlockEncoder());//32
        nBlocks.add(new HitUpdateBlockEncoder());//TODO update
        nBlocks.add(new GraphicBlockEncoder());//1
        nBlocks.add(new ForceChatBlockEncoder());//8

        //nBlocks.add(new SecondaryHitUpdateBlockEncoder());
    }

    public static SynchronizationDescriptor getPlayerDescriptor(SegmentType type) {
        return pDescriptors.get(type);
    }

    public static SynchronizationDescriptor getNpcDescriptor(SegmentType type) {
        return nDescriptors.get(type);
    }

    public static SynchronizationBlockEncoder getPlayerBlock(int index) {
        return pBlocks.get(index);
    }

    public static SynchronizationBlockEncoder getNpcBlock(int index) {
        return nBlocks.get(index);
    }

    public static int getDirX(int index) {
        return DIRECTION_DELTA_X[index];
    }

    public static int getDirX(int first, int second) {
        return DIRECTION_DELTA_X[first] + DIRECTION_DELTA_X[second];
    }

    public static int getDirY(int index) {
        return DIRECTION_DELTA_Y[index];
    }

    public static int getDirY(int first, int second) {
        return DIRECTION_DELTA_Y[first] + DIRECTION_DELTA_Y[second];
    }

    public static int getPlayerWalkingDirection(int dirX, int dirY) {
        if (dirX == -1 && dirY == -1) {
            return 0;
        }
        if (dirX == 0 && dirY == -1) {
            return 1;
        }
        if (dirX == 1 && dirY == -1) {
            return 2;
        }
        if (dirX == -1 && dirY == 0) {
            return 3;
        }
        if (dirX == 1 && dirY == 0) {
            return 4;
        }
        if (dirX == -1 && dirY == 1) {
            return 5;
        }
        if (dirX == 0 && dirY == 1) {
            return 6;
        }
        if (dirX == 1 && dirY == 1) {
            return 7;
        }
        return -1;
    }

    public static int getPlayerRunningDirection(int dirX, int dirY) {
        if (dirX == -2 && dirY == -2)
            return 0;

        if (dirX == -1 && dirY == -2)
            return 1;

        if (dirX == 0 && dirY == -2)
            return 2;

        if (dirX == 1 && dirY == -2)
            return 3;

        if (dirX == 2 && dirY == -2)
            return 4;

        if (dirX == -2 && dirY == -1)
            return 5;

        if (dirX == 2 && dirY == -1)
            return 6;

        if (dirX == -2 && dirY == 0)
            return 7;

        if (dirX == 2 && dirY == 0)
            return 8;

        if (dirX == -2 && dirY == 1)
            return 9;

        if (dirX == 2 && dirY == 1)
            return 10;

        if (dirX == -2 && dirY == 2)
            return 11;

        if (dirX == -1 && dirY == 2)
            return 12;

        if (dirX == 0 && dirY == 2)
            return 13;

        if (dirX == 1 && dirY == 2)
            return 14;

        if (dirX == 2 && dirY == 2)
            return 15;

        return -1;
    }
}
