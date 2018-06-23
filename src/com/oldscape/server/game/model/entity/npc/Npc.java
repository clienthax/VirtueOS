/**
 * Copyright (c) 2015 Virtue Studios
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
package com.oldscape.server.game.model.entity.npc;

import com.oldscape.server.game.model.MobileEntity;
import com.oldscape.shared.cache.type.TypeListManager;
import com.oldscape.server.game.model.map.Position;

import java.util.Optional;

/**
 * @author Im Frizzy <skype:kfriz1998>
 * @author Frosty Teh Snowman <skype:travis.mccorkle>
 * @author Arthur <skype:arthur.behesnilian>
 * @author Sundays211
 * @since Mar 21, 2015
 */
public class Npc extends MobileEntity {

    public Npc(int id, int x, int y) {
        this.npcType = Optional.of(TypeListManager.lookupNpc(id));
        this.setPosition(new Position(x, y, 0));
    }

    /*
     * (non-Javadoc)
     *
     * @see com.etoile.shared.model.Node#initialise()
     */
    @Override
    public void initialize() {

    }

    /**
     * @return
     */
    public int getId() {
        return getNpcType().getID();
    }

    public boolean isAttackable() {
        for (String option : getNpcType().getOptions()) {
            if ("Attack".equalsIgnoreCase(option)) {
                return true;
            }
        }
        return false;
    }
}
