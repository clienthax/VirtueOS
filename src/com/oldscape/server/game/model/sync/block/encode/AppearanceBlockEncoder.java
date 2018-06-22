/**
 * Copyright (c) 2015 Kyle Friz
 * <p>
 * ChatCrownType is hereby granted, free of charge, to any person obtaining a copy
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
package com.oldscape.server.game.model.sync.block.encode;

import com.oldscape.server.game.model.entity.item.equip.Equipment;
import com.oldscape.server.game.model.entity.item.Item;
import com.oldscape.server.game.model.entity.player.inv.ItemContainer;
import com.oldscape.server.game.model.sync.block.AppearanceBlock;
import com.oldscape.server.game.model.sync.block.BlockType;
import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.server.game.model.sync.reference.Appearance;
import com.oldscape.server.game.model.sync.reference.Appearance.Gender;
import com.oldscape.server.game.model.entity.item.equip.EquipmentType;
import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameBuilder;

/**
 * @author Kyle Friz
 * @since Aug 31, 2015
 */
public class AppearanceBlockEncoder extends SynchronizationBlockEncoder {

    public AppearanceBlockEncoder() {
        super(2, 0);
    }

    @Override
    public void encodeBlock(SynchronizationBlock block, GameFrameBuilder builder, boolean player) {
        AppearanceBlock aBlock = (AppearanceBlock) block;
        Appearance appearance = aBlock.getAppearance();
        GameFrameBuilder props = new GameFrameBuilder(builder.getAllocator());

        props.put(DataType.BYTE, appearance.getGender().ordinal());
        props.put(DataType.BYTE, aBlock.isSkulled() ? 1 : -1);
        props.put(DataType.BYTE, aBlock.getHeadIcon());

        if (aBlock.appearingAsNpc()) {
            props.put(DataType.BYTE, 255);
            props.put(DataType.BYTE, 255);
            props.put(DataType.SHORT, aBlock.getNpcId());
        } else {
            ItemContainer equipment = aBlock.getEquipment();
            int[] style = appearance.getStyle();
            Item item, chest, helm;

            for (int slot = 0; slot < 4; slot++) {
                if ((item = equipment.get(slot)) != null) {
                    props.put(DataType.SHORT, 0x200 + item.getId());
                } else {
                    props.put(DataType.BYTE, 0);
                }
            }

            if ((chest = equipment.get(Equipment.CHEST)) != null) {
                props.put(DataType.SHORT, 0x200 + chest.getId());
            } else {
                props.put(DataType.SHORT, 0x100 + style[2]);
            }

            if ((item = equipment.get(Equipment.SHIELD)) != null) {
                props.put(DataType.SHORT, 0x200 + item.getId());
            } else {
                props.put(DataType.BYTE, 0);
            }

            if (chest != null) {
                EquipmentType def = EquipmentType.lookup(chest.getId());
                if (def != null && !def.isFullBody()) {
                    props.put(DataType.SHORT, 0x100 + style[3]);
                } else {
                    props.put(DataType.BYTE, 0);
                }
            } else {
                props.put(DataType.SHORT, 0x100 + style[3]);
            }

            if ((item = equipment.get(Equipment.LEGS)) != null) {
                props.put(DataType.SHORT, 0x200 + item.getId());
            } else {
                props.put(DataType.SHORT, 0x100 + style[5]);
            }

            if ((helm = equipment.get(Equipment.HAT)) != null) {
                EquipmentType def = EquipmentType.lookup(helm.getId());
                if (def != null && !def.isFullHat() && !def.isFullMask()) {
                    props.put(DataType.SHORT, 0x100 + style[0]);
                } else {
                    props.put(DataType.BYTE, 0);
                }
            } else {
                props.put(DataType.SHORT, 0x100 + style[0]);
            }

            if ((item = equipment.get(Equipment.HANDS)) != null) {
                props.put(DataType.SHORT, 0x200 + item.getId());
            } else {
                props.put(DataType.SHORT, 0x100 + style[4]);
            }

            if ((item = equipment.get(Equipment.FEET)) != null) {
                props.put(DataType.SHORT, 0x200 + item.getId());
            } else {
                props.put(DataType.SHORT, 0x100 + style[6]);
            }

            EquipmentType def = null;
            if (helm != null) {
                def = EquipmentType.lookup(helm.getId());
            }
            if (def != null && (def.isFullHat() || def.isFullMask()) || appearance.getGender() == Gender.FEMALE) {
                props.put(DataType.BYTE, 0);
            } else {
                props.put(DataType.SHORT, 0x100 + style[1]);
            }
        }

        int[] colors = appearance.getColors();
        for (int color : colors) {
            props.put(DataType.BYTE, color);
        }

        props.put(DataType.SHORT, aBlock.getEquipment().getStandAnim());
        props.put(DataType.SHORT, aBlock.getEquipment().getStandTurnAnim());
        props.put(DataType.SHORT, aBlock.getEquipment().getWalkAnim());
        props.put(DataType.SHORT, aBlock.getEquipment().getTurn180Anim());
        props.put(DataType.SHORT, aBlock.getEquipment().getTurn90cwAnim());
        props.put(DataType.SHORT, aBlock.getEquipment().getTurn90ccwAnim());
        props.put(DataType.SHORT, aBlock.getEquipment().getRunAnim());

        props.putString(aBlock.getName());

        props.put(DataType.BYTE, aBlock.getCombatLevel());
        props.put(DataType.SHORT, aBlock.getSkillLevel());
        props.put(DataType.BYTE, aBlock.isHidden() ? 1 : 0);

        builder.put(DataType.BYTE, DataTransformation.SUBTRACT, props.getLength());

        builder.putRawBuilder(DataTransformation.ADD, props);
    }

    @Override
    public BlockType getType() {
        return BlockType.APPEARANCE;
    }

}
