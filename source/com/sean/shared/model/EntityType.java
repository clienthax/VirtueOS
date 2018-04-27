/**
 * Copyright (c) 2015 Kyle Friz
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.sean.shared.model;

/**
 * Represents a type of {@link Entity}.
 * 
 * @author Major
 */
public enum EntityType {

	/**
	 * A GameObject that is loaded dynamically, usually for specific Players.
	 */
	DYNAMIC_OBJECT,

	/**
	 * An Item that is positioned on the ground.
	 */
	GROUND_ITEM,

	/**
	 * An Npc.
	 */
	NPC,

	/**
	 * A Player.
	 */
	PLAYER,

	/**
	 * A projectile (e.g. an arrow).
	 */
	PROJECTILE,

	/**
	 * A GameObject that is loaded statically (i.e. from the game resources) at start-up.
	 */
	STATIC_OBJECT;

	/**
	 * Returns whether or not this EntityType is for a Mob.
	 *
	 * @return {@code true} if this EntityType is for a Mob, otherwise {@code false}.
	 */
	public boolean isMob() {
		return this == PLAYER || this == NPC;
	}

	/**
	 * Returns whether or not this EntityType should be short-lived (i.e. not added to its {@link Region}s
	 * local objects).
	 *
	 * @return {@code true} if this EntityType is short-lived.
     */
	public boolean isTransient() {
		return this == PROJECTILE;
	}
}
