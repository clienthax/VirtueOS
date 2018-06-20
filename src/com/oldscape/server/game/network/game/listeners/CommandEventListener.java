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
package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.model.player.DisplayMode;
import com.oldscape.shared.network.game.event.impl.CommandEvent;
import com.oldscape.shared.script.listeners.CommandListener;

import java.util.Arrays;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @date May 4, 2015
 */
public class CommandEventListener implements EventListener<CommandEvent, GameSessionContext> {

    @Override
    public void onEvent(CommandEvent event, GameSessionContext context) {
        System.out.println(event.getSyntax() + ", " + Arrays.toString(event.getArgs()));

        CommandListener listener = context.getServer().getScriptManager().forSyntax(event.getSyntax());
        if (listener != null) {
            if (context.getPlayer().getCredentials().getPermission().compareTo(listener.getPermission()) > -1) {
                boolean success = listener.handle(context.getPlayer(), event.getSyntax(), event.getArgs());
                if (!success)
                    System.out.println("Unsuccessful command. [ " + event.getSyntax() + " ]");
            } else {
                System.out.println("ChatCrownType requirement not met. [ " + event.getSyntax() + " ]");
            }
        } else {
            System.out.println("Unknown command. [ " + event.getSyntax() + " ]");
        }


        if (event.getSyntax().equals("logout")) {
            context.getPlayer().logout();
        }

        if (event.getSyntax().equals("resize_p")) {
            Player player = context.getPlayer();
            context.getPlayer().setDisplay(DisplayMode.RESIZE_PANELS);
            player.sendSetRootWidget(player.getDisplay().getId());
            if (player.getDisplay().equals(DisplayMode.RESIZE_PANELS)) {
                player.sendSetWidgetMoveSubEvent(165, 1, 164, 19);
                player.sendSetWidgetMoveSubEvent(165, 4, 164, 8);
                player.sendSetWidgetMoveSubEvent(165, 2, 164, 3);
                player.sendSetWidgetMoveSubEvent(165, 3, 164, 6);
                player.sendSetWidgetMoveSubEvent(165, 5, 164, 52);
                player.sendSetWidgetMoveSubEvent(165, 6, 164, 54);
                player.sendSetWidgetMoveSubEvent(165, 7, 164, 55);
                player.sendSetWidgetMoveSubEvent(165, 8, 164, 56);
                player.sendSetWidgetMoveSubEvent(165, 9, 164, 57);
                player.sendSetWidgetMoveSubEvent(165, 10, 164, 58);
                player.sendSetWidgetMoveSubEvent(165, 11, 164, 59);
                player.sendSetWidgetMoveSubEvent(165, 12, 164, 60);
                player.sendSetWidgetMoveSubEvent(165, 13, 164, 61);
                player.sendSetWidgetMoveSubEvent(165, 14, 164, 62);
                player.sendSetWidgetMoveSubEvent(165, 15, 164, 63);
                player.sendSetWidgetMoveSubEvent(165, 16, 164, 64);
                player.sendSetWidgetMoveSubEvent(165, 17, 164, 65);
                player.sendSetWidgetMoveSubEvent(165, 18, 164, 66);
                player.sendSetWidgetMoveSubEvent(165, 19, 164, 67);
                player.sendSetWidgetMoveSubEvent(165, 20, 164, 4);
                player.sendSetWidgetMoveSubEvent(165, 21, 164, 7);
                player.sendSetWidgetMoveSubEvent(165, 22, 164, 16);
            }
        }

        if (event.getSyntax().equals("resize")) {
            context.getPlayer().setDisplay(DisplayMode.RESIZE);
        }

        if (event.getSyntax().equals("fixed")) {
            context.getPlayer().setDisplay(DisplayMode.FIXED);
        }

        if (event.getSyntax().equals("inter")) {
            if (event.getArgs().length > 1) {
                return;
            }
            context.getPlayer().sendOpenWidgetSub(548, 22, Integer.parseInt(event.getArgs()[0]), false);
        }

        if (event.getSyntax().equals("closeinter")) {
            context.getPlayer().sendCloseWidgetSub(548, 22);
        }

        /*
         * if (event.getSyntax().equals("item")) { int itemID =
         * Integer.parseInt(event.getArgs()[0]); int itemAmount = 1; if
         * (event.getArgs().length > 1) { itemAmount =
         * Integer.parseInt(event.getArgs()[1]); itemAmount = itemAmount >
         * Integer.MAX_VALUE ? Integer.MAX_VALUE : itemAmount; }
         * context.getPlayer().getInventory().add(itemID, itemAmount); }
         */

        /*
         * if (event.getSyntax().equals("walk")) {
         * System.out.println(context.getPlayer().getPosition().toString() +
         * ", " + context.getPlayer().getLastPosition().toString());
         * context.getPlayer
         * ().getWalkingQueue().setRunningQueue(event.getArgs()[
         * 0].equals("true")); context.getPlayer().getWalkingQueue().addStep(new
         * Position(context.getPlayer().getPosition().getX() + 5,
         * context.getPlayer().getPosition().getY(),
         * context.getPlayer().getPosition().getHeight())); }
         *
         * if (event.getSyntax().equals("equip")) { int weapon = 12904; int helm
         * = 12417; int cape = 13069; int shield = 12817; int body = 10338; int
         * bottom = 10340; int necklace = 12436;
         * context.getPlayer().getEquipment().set(3, new Item(weapon));
         * context.getPlayer().getEquipment().set(0, new Item(helm));
         * context.getPlayer().getEquipment().set(1, new Item(cape));
         * context.getPlayer().getEquipment().set(5, new Item(shield));
         * context.getPlayer().getEquipment().set(4, new Item(body));
         * context.getPlayer().getEquipment().set(7, new Item(bottom));
         * context.getPlayer().getEquipment().set(2, new Item(necklace)); }
         *
         * if (event.getSyntax().equals("inter")) { if (event.getArgs().length >
         * 1) { return; } context.getPlayer().sendOpenWidgetSub(548, 104,
         * Integer.parseInt(event.getArgs()[0]), false); }
         *
         * if (event.getSyntax().equals("item")) { int itemID =
         * Integer.parseInt(event.getArgs()[0]); int itemAmount = 1; if
         * (event.getArgs().length > 1) { itemAmount =
         * Integer.parseInt(event.getArgs()[1]); itemAmount = itemAmount >
         * Integer.MAX_VALUE ? Integer.MAX_VALUE : itemAmount; }
         * context.getPlayer().getInventory().add(itemID, itemAmount); }
         */

        /* if (event.getSyntax().equals("coords")) {
         * System.out.println(context.getPlayer().getPosition().toString()); }
         *
         * if (event.getSyntax().equals("anim")) { int animID =
         * Integer.parseInt(event.getArgs()[0]);
         * context.getPlayer().playAnimation(new Animation(animID)); }
         *
         * if (event.getSyntax().equals("gfx")) { int gfxID =
         * Integer.parseInt(event.getArgs()[0]);
         * context.getPlayer().playGraphic(new Graphic(gfxID)); }
         *
         * if (event.getSyntax().equals("hit")) { int hit =
         * Integer.parseInt(event.getArgs()[0]);
         * context.getPlayer().addBlock(SynchronizationBlock
         * .createHitUpdateBlock(hit, 1, hit, 99, false)); }
         */
    }

}
