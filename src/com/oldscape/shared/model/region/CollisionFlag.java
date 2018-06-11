/**
 * Copyright (c) 2015 Kyle Friz
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oldscape.shared.model.region;

import com.oldscape.shared.model.EntityType;

/**
 * A type of flag in a {@link CollisionMatrix}.
 *
 * @author Major
 */
public enum CollisionFlag {

    /**
     * The walk north flag.
     */
    MOB_NORTH(0),

    /**
     * The walk east flag.
     */
    MOB_EAST(1),

    /**
     * The walk south flag.
     */
    MOB_SOUTH(2),

    /**
     * The walk west flag.
     */
    MOB_WEST(3),

    /**
     * The projectile north flag.
     */
    PROJECTILE_NORTH(4),

    /**
     * The projectile east flag.
     */
    PROJECTILE_EAST(5),

    /**
     * The projectile south flag.
     */
    PROJECTILE_SOUTH(6),

    /**
     * The projectile west flag.
     */
    PROJECTILE_WEST(7);

    /**
     * The index of the bit this flag is stored in.
     */
    private final int bit;

    /**
     * Creates the CollisionFlag.
     *
     * @param bit The index of the bit this flag is stored in.
     */
    private CollisionFlag(int bit) {
        this.bit = bit;
    }

    /**
     * Returns an array of CollisionFlags that indicate if the specified {@link EntityType} can be positioned on a tile.
     *
     * @param type The EntityType.
     * @return The array of CollisionFlags.
     */
    public static CollisionFlag[] forType(EntityType type) {
        return type == EntityType.PROJECTILE ? projectiles() : mobs();
    }

    /**
     * Returns an array of CollisionFlags that indicate if a Mob can be positioned on a tile.
     *
     * @return The array of CollisionFlags.
     */
    public static CollisionFlag[] mobs() {
        return new CollisionFlag[]{MOB_NORTH, MOB_EAST, MOB_SOUTH, MOB_WEST};
    }

    /**
     * Returns an array of CollisionFlags that indicate if a Projectile can be positioned on a tile.
     *
     * @return The array of CollisionFlags.
     */
    public static CollisionFlag[] projectiles() {
        return new CollisionFlag[]{PROJECTILE_NORTH, PROJECTILE_EAST, PROJECTILE_SOUTH, PROJECTILE_WEST};
    }

    /**
     * Gets this CollisionFlag, as a {@code byte}.
     *
     * @return The value, as a {@code byte}.
     */
    public byte asByte() {
        return (byte) (1 << bit);
    }

    /**
     * Gets the index of the bit this flag is stored in.
     *
     * @return The index of the bit.
     */
    public int getBit() {
        return bit;
    }

}
