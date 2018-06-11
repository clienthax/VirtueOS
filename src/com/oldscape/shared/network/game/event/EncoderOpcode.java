/**
 * Copyright (c) 2015 Kyle Friz & Kayla Friz
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
package com.oldscape.shared.network.game.event;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jul 24, 2015
 */
public enum EncoderOpcode {

    //80 is something todo with compass (look direction?)

    RAW(-1),

    //Doesnt seem to be in 168? task is not present 3:
    EXTERN_IP(0),//193

    //Interfaces
    IF_SET_SCROLL_POS(2),
    IF_MOVE_SUB(8),
    IF_SET_COLOR(9),
    IF_SET_ANIM(27),
    IF_SET_ANGLE(28),
    IF_OPEN_SUB(29),
    IF_CLOSE_SUB(30),
    IF_SET_TEXT(35),
    IF_SET_NPC_HEAD(36),
    IF_SET_CLICK_MASK(38),
    IF_SET_PLAYER_HEAD(39),
    IF_SET_OBJECT(57),
    IF_SET_MODEL(62),
    IF_ROOT(66),
    IF_SET_POSITION(67),
    IF_SET_HIDDEN(68),
    IF_UNKNOWN(83),//TODO -- it sets toplevel interfaces, adds sub interfaces and sets click masks - polar -- IF_PREBUILD_TOP_LEVEL

    CS2_SCRIPT(74),

//	FULL_ITEMS(0),
//	SLOT_ITEMS(0),

    GAME_MESSAGE(79),//
    MUSIC(82),

    //NPCS
    NPC_SYNC(33),
    NPC_SYNC_LARGE(49),

    PLAYER_SYNC(40),//opcode updated, needs masks updated
    LOGOUT(0),

    REGION_STATIC(41),//150 -- opcode updated
//	REGION_DYNAMIC(44),

    RUN_ENERGY(43),
    SKILL(37),

    VARP_SMALL(14),//185 -- updated
    VARP_LARGE(45),//9 --updated
    VARP_RESET(78),//182
//	VARP_RECACHE(0)

    ;

    final int opcode;

    EncoderOpcode(int op) {
        this.opcode = op;
    }

    public final int getOpcode() {
        return opcode;
    }

}
