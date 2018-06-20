package com.oldscape.server.game.model.var;

import com.oldscape.server.game.model.player.Player;
import com.oldscape.shared.cache.type.TypeListManager;
import com.oldscape.shared.cache.type.varbits.VarBitType;

public class Varbit {

    private final int[] values;

    private final Player player;

    private static final int[] MASK_LOOKUP = new int[32];

    public Varbit(final Player player) {
        this.player = player;
        values = new int[TypeListManager.varbitSize() + 1];
    }

    static {
        int i = 2;
        for (int j = 0; j < 32; j++) {
            MASK_LOOKUP[j] = i - 1;
            i += i;
        }
    }

    public void sendVarp(final int id, final int value) {
        sendVarp(id, value, false);
    }

    public void forceVarp(final int id, final int value) {
        sendVarp(id, value, true);
    }

    private void sendVarp(final int id, final int value, final boolean force) {
        if (id < 0 || id >= values.length) {
            return;
        }
        if (!force && values[id] == value && value != 0) {
            return;
        }
        setVarp(id, value);
    }

    public void setVarp(final int id, final int value) {
        if (id == -1) {
            return;
        }
        values[id] = value;
        player.sendVarp(id, values[id]);
    }

    public int getValue(final int id) {
        return values[id];
    }

    public void forceVarbit(final int id, final int value) {
        setVarbit(id, value, 0x1 | 0x2);
    }

    public void sendVarbit(final int id, final int value) {
        setVarbit(id, value, 0x1);
    }

    public void forceVarbit(final int id, final boolean value) {
        setVarbit(id, value ? 1 : 0, 0x1 | 0x2);
    }

    public void sendVarbit(final int id, final boolean value) {
        setVarbit(id, value ? 1 : 0, 0x1);
    }

    public void setVarbit(final int id, final int value) {
        setVarbit(id, value, 0);
    }

    public int getVarbit(final int id) {
        final VarBitType defs = TypeListManager.lookupVarBit(id);
        if (defs == null) {
            return 0;
        }
        return values[defs.getConfigID()] >> defs.getLeastSigBit() & MASK_LOOKUP[defs.getMostSigBit() - defs.getLeastSigBit()];
    }

    private void setVarbit(final int id, int value, final int flag) {
        if (id == -1) {
            return;
        }

        final VarBitType defs = TypeListManager.lookupVarBit(id);
        if (defs == null) {
            return;
        }
        int mask = MASK_LOOKUP[defs.getMostSigBit() - defs.getLeastSigBit()];
        if (value < 0 || value > mask) {
            value = 0;
        }
        mask <<= defs.getLeastSigBit();
        final int varpValue = (values[defs.getConfigID()] & (mask ^ 0xffffffff) | value << defs.getLeastSigBit() & mask);
        if ((flag & 0x2) != 0 || varpValue != values[defs.getConfigID()]) {
            setVarp(defs.getConfigID(), varpValue);
        }
    }
}