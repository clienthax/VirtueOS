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
package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.model.sync.reference.Animation;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.model.player.DisplayMode;
import com.oldscape.shared.network.game.event.impl.InterfaceClickEvent;

/**
 * @author Kyle Friz
 * @date May 4, 2015
 */

@Deprecated
public class InterfaceClickEventListener implements EventListener<InterfaceClickEvent, GameSessionContext> {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.oldscape.shared.event.EventListener#onEvent(com.oldscape.shared.event.Event,
     * com.oldscape.shared.event.EventContext)
     */
    @Override
    public void onEvent(InterfaceClickEvent event, GameSessionContext context) {
        Player player = context.getPlayer();

        // TODO Move to sperate classe
        //TODO Seems this is all handled via the buttonclicks now

        System.out.println("interfaceclick " + event.getOpcode() + ", " + event.getInterfaceID() + ", " + event.getButtonID() + ", " + event.getItemID() + ", " + event.getSlotID());


        if (event.getInterfaceID() == 182 && event.getButtonID() == 1) {// TODO
            // Fix
            player.sendOpenInterfaceSub(164, 64, 69, true);
            player.sendInterfaceSetClickMask(164, 17, -1, -1, 2);
            player.sendCS2Script(747, new Object[]{});
            player.sendCS2Script(764, new Object[]{0, 19268, "Trade - Free"});
            player.sendCS2Script(764, new Object[]{1, 19335, "Trade - Members"});
            player.sendCS2Script(764, new Object[]{2, 19407, ""});
            player.sendCS2Script(764, new Object[]{3, 19471, "Trouble Brewing"});
            player.sendCS2Script(764, new Object[]{4, 19525, "Falador Party Room"});
            player.sendCS2Script(764, new Object[]{5, 19589, "Barbarian Assault"});
            player.sendCS2Script(764, new Object[]{6, 19718, "Wilderness PK - free style"});
            player.sendCS2Script(764, new Object[]{7, 19783, ""});
            player.sendCS2Script(764, new Object[]{8, 19847, ""});
            player.sendCS2Script(764, new Object[]{9, 19919, ""});
            player.sendCS2Script(764, new Object[]{10, 19983, ""});
            player.sendCS2Script(764, new Object[]{11, 20037, ""});
            player.sendCS2Script(764, new Object[]{12, 20101, "Dorgesh-Kaan Agility"});
            player.sendCS2Script(764, new Object[]{13, 20230, "Wilderness PK - free style"});
            player.sendCS2Script(764, new Object[]{14, 20295, ""});
            player.sendCS2Script(764, new Object[]{15, 20357, "<col=ff0000>Bounty World"});
            player.sendCS2Script(764, new Object[]{16, 20431, ""});
            player.sendCS2Script(764, new Object[]{17, 20495, ""});
            player.sendCS2Script(764, new Object[]{18, 20549, ""});
            player.sendCS2Script(764, new Object[]{19, 20613, "Duel Arena"});
            player.sendCS2Script(764, new Object[]{20, 20805, "<col=ff0000>PvP World"});
            player.sendCS2Script(764, new Object[]{21, 20870, ""});
            player.sendCS2Script(764, new Object[]{22, 20943, ""});
            player.sendCS2Script(764, new Object[]{23, 21007, ""});
            player.sendCS2Script(764, new Object[]{24, 21061, "Clan Wars - Members"});
            player.sendCS2Script(764, new Object[]{25, 21125, "House Party, Gilded Altar"});
            player.sendCS2Script(764, new Object[]{26, 21319, "Games Room, Rogues' Den"});
            player.sendCS2Script(764, new Object[]{27, 21383, "Castle Wars 1"});
            player.sendCS2Script(764, new Object[]{28, 21454, ""});
            player.sendCS2Script(764, new Object[]{29, 21519, "Running - nature rune"});
            player.sendCS2Script(764, new Object[]{30, 21573, "<col=ff0000>PvP World - High Risk"});
            player.sendCS2Script(764, new Object[]{31, 21637, ""});
            player.sendCS2Script(764, new Object[]{32, 21831, "Running - law rune"});
            player.sendCS2Script(764, new Object[]{33, 21895, "Role-playing"});
            player.sendCS2Script(764, new Object[]{34, 21967, ""});
            player.sendCS2Script(764, new Object[]{35, 22031, "Pest Control"});
            player.sendCS2Script(764, new Object[]{36, 22085, ""});
            player.sendCS2Script(764, new Object[]{37, 22149, "Agility training"});
            player.sendCS2Script(764, new Object[]{38, 22343, ""});
            player.sendCS2Script(764, new Object[]{39, 22407, "TzHaar Fight Pit"});
            player.sendCS2Script(764, new Object[]{40, 22479, ""});
            player.sendCS2Script(764, new Object[]{41, 22543, ""});
            player.sendCS2Script(764, new Object[]{42, 22597, ""});
            player.sendCS2Script(764, new Object[]{43, 22661, "Castle Wars 2"});
            player.sendCS2Script(764, new Object[]{44, 22855, ""});
            player.sendCS2Script(764, new Object[]{45, 22919, "Blast Furnace"});
            player.sendCS2Script(764, new Object[]{46, 22991, ""});
            player.sendCS2Script(764, new Object[]{47, 23055, ""});
            player.sendCS2Script(764, new Object[]{48, 23109, ""});
            player.sendCS2Script(764, new Object[]{49, 23173, "Pyramid Plunder"});
            player.sendCS2Script(764, new Object[]{50, 23367, "<col=ffff00>High Risk World"});
            player.sendCS2Script(764, new Object[]{51, 23431, ""});
            player.sendCS2Script(764, new Object[]{52, 23503, ""});
            player.sendCS2Script(764, new Object[]{53, 23567, ""});
            player.sendCS2Script(764, new Object[]{54, 23621, "Wilderness PK - members"});
            player.sendCS2Script(764, new Object[]{55, 23685, "Fishing Trawler"});
            player.sendCS2Script(764, new Object[]{56, 23879, ""});
            player.sendCS2Script(764, new Object[]{57, 23943, ""});
            player.sendCS2Script(764, new Object[]{58, 24015, "Barbarian Fishing"});
            player.sendCS2Script(764, new Object[]{59, 24079, ""});
            player.sendCS2Script(764, new Object[]{60, 24133, "Mort'ton temple, Rat Pits"});
            player.sendCS2Script(764, new Object[]{61, 24197, ""});
            player.sendCS2Script(764, new Object[]{62, 24390, ""});
            player.sendCS2Script(764, new Object[]{63, 24454, ""});
            player.sendCS2Script(764, new Object[]{64, 24526, ""});
            player.sendCS2Script(764, new Object[]{65, 24590, ""});
            player.sendCS2Script(764, new Object[]{66, 24644, "Bot analysis"});
            player.sendCS2Script(764, new Object[]{67, 24709, "Bot analysis"});
            player.sendCS2Script(764, new Object[]{68, 25156, "Clan Wars - Free"});
            player.sendCS2Script(764, new Object[]{69, 25220, ""});
            player.sendCS2Script(764, new Object[]{70, 0, ""});
            player.sendCS2Script(764, new Object[]{71, 0, ""});
            player.sendCS2Script(764, new Object[]{72, 0, ""});
            player.sendCS2Script(764, new Object[]{73, 0, ""});
            player.sendCS2Script(764, new Object[]{74, 0, ""});
            player.sendCS2Script(764, new Object[]{75, 0, ""});
            player.sendCS2Script(764, new Object[]{76, 0, ""});
            player.sendCS2Script(764, new Object[]{77, 0, ""});
            player.sendCS2Script(764, new Object[]{78, 0, ""});
            player.sendCS2Script(764, new Object[]{79, 0, ""});
            player.sendCS2Script(764, new Object[]{80, 0, ""});
            player.sendCS2Script(764, new Object[]{81, 0, ""});
            player.sendCS2Script(764, new Object[]{82, 0, ""});
            player.sendCS2Script(764, new Object[]{83, 0, ""});
            player.sendCS2Script(764, new Object[]{84, 0, ""});
            player.sendCS2Script(764, new Object[]{85, 0, ""});
            player.sendCS2Script(764, new Object[]{86, 0, ""});
            player.sendCS2Script(764, new Object[]{87, 0, ""});
            player.sendCS2Script(764, new Object[]{88, 0, ""});
            player.sendCS2Script(764, new Object[]{89, 0, ""});
            player.sendCS2Script(764, new Object[]{90, 0, ""});
            player.sendCS2Script(764, new Object[]{91, 0, ""});
            player.sendCS2Script(764, new Object[]{92, 0, ""});
            player.sendCS2Script(764, new Object[]{93, 0, ""});
            player.sendCS2Script(764, new Object[]{94, 0, ""});
            player.sendCS2Script(764, new Object[]{95, 0, ""});
            player.sendCS2Script(764, new Object[]{96, 0, ""});
            player.sendCS2Script(764, new Object[]{97, 0, ""});
            player.sendCS2Script(764, new Object[]{98, 0, ""});
            player.sendCS2Script(764, new Object[]{99, 0, ""});
            player.sendVarp(477, 0);
            player.sendVarp(477, 0);
            player.sendCS2Script(748, new Object[]{});
        }

        if (event.getInterfaceID() == 261 && event.getButtonID() == 11) {
            player.sendCS2Script(917, new Object[]{-1, -1});
            if (player.getDisplay().equals(DisplayMode.RESIZE_PANELS)) {
                player.sendOpenInterfaceSub(164, 8, 60, false);
            } else if (player.getDisplay().equals(DisplayMode.RESIZE)) {
                player.sendOpenInterfaceSub(161, 8, 60, false);
            } else {
                player.sendOpenInterfaceSub(548, 16, 60, false);
            }
        }

        if (event.getInterfaceID() == 60 && event.getButtonID() == 12) {
            if (player.getDisplay().equals(DisplayMode.RESIZE)) {
                player.sendVarp(1055, 64);
            } else {
                player.sendVarp(1055, 576);
            }
        }

        if (event.getInterfaceID() == 60 && event.getButtonID() == 10) {
            player.sendVarp(1055, 72);
        } else {
            player.sendVarp(1055, 64);
            player.sendOpenInterfaceSub(161, 16, 160, true);
        }

        if (event.getInterfaceID() == 60 && event.getButtonID() == 15) {
            if (player.getDisplay().equals(DisplayMode.RESIZE_PANELS)) {
                player.setDisplay(DisplayMode.RESIZE);
                player.sendSetRootInterface(player.getDisplay().getId());
                player.sendSetInterfaceMoveSubEvent(164, 19, 161, 17);
                player.sendSetInterfaceMoveSubEvent(164, 8, 161, 8);
                player.sendSetInterfaceMoveSubEvent(164, 3, 161, 3);
                player.sendSetInterfaceMoveSubEvent(164, 6, 161, 6);
                player.sendSetInterfaceMoveSubEvent(164, 52, 161, 54);
                player.sendSetInterfaceMoveSubEvent(164, 54, 161, 56);
                player.sendSetInterfaceMoveSubEvent(164, 55, 161, 57);
                player.sendSetInterfaceMoveSubEvent(164, 56, 161, 58);
                player.sendSetInterfaceMoveSubEvent(164, 57, 161, 59);
                player.sendSetInterfaceMoveSubEvent(164, 58, 161, 60);
                player.sendSetInterfaceMoveSubEvent(164, 59, 161, 61);
                player.sendSetInterfaceMoveSubEvent(164, 60, 161, 62);
                player.sendSetInterfaceMoveSubEvent(164, 61, 161, 63);
                player.sendSetInterfaceMoveSubEvent(164, 62, 161, 64);
                player.sendSetInterfaceMoveSubEvent(164, 63, 161, 65);
                player.sendSetInterfaceMoveSubEvent(164, 64, 161, 66);
                player.sendSetInterfaceMoveSubEvent(164, 65, 161, 67);
                player.sendSetInterfaceMoveSubEvent(164, 66, 161, 68);
                player.sendSetInterfaceMoveSubEvent(164, 67, 161, 69);
                player.sendSetInterfaceMoveSubEvent(164, 4, 161, 4);
                player.sendSetInterfaceMoveSubEvent(164, 7, 161, 7);
                player.sendSetInterfaceMoveSubEvent(164, 16, 161, 16);
                player.sendCS2Script(917, new Object[]{-1, -1});
                player.sendOpenInterfaceSub(161, 8, 60, false);
            } else {
                player.setDisplay(DisplayMode.RESIZE_PANELS);
                player.sendSetRootInterface(player.getDisplay().getId());
                player.sendSetInterfaceMoveSubEvent(161, 17, 164, 19);
                player.sendSetInterfaceMoveSubEvent(161, 8, 164, 8);
                player.sendSetInterfaceMoveSubEvent(161, 3, 164, 3);
                player.sendSetInterfaceMoveSubEvent(161, 6, 164, 6);
                player.sendSetInterfaceMoveSubEvent(161, 54, 164, 52);
                player.sendSetInterfaceMoveSubEvent(161, 56, 164, 54);
                player.sendSetInterfaceMoveSubEvent(161, 57, 164, 55);
                player.sendSetInterfaceMoveSubEvent(161, 58, 164, 56);
                player.sendSetInterfaceMoveSubEvent(161, 59, 164, 57);
                player.sendSetInterfaceMoveSubEvent(161, 60, 164, 58);
                player.sendSetInterfaceMoveSubEvent(161, 61, 164, 59);
                player.sendSetInterfaceMoveSubEvent(161, 62, 164, 60);
                player.sendSetInterfaceMoveSubEvent(161, 63, 164, 61);
                player.sendSetInterfaceMoveSubEvent(161, 64, 164, 62);
                player.sendSetInterfaceMoveSubEvent(161, 65, 164, 63);
                player.sendSetInterfaceMoveSubEvent(161, 66, 164, 64);
                player.sendSetInterfaceMoveSubEvent(161, 67, 164, 65);
                player.sendSetInterfaceMoveSubEvent(161, 68, 164, 66);
                player.sendSetInterfaceMoveSubEvent(161, 69, 164, 67);
                player.sendSetInterfaceMoveSubEvent(161, 4, 164, 4);
                player.sendSetInterfaceMoveSubEvent(161, 7, 164, 7);
                player.sendSetInterfaceMoveSubEvent(161, 16, 164, 16);
                player.sendCS2Script(917, new Object[]{-1, -1});
                player.sendOpenInterfaceSub(164, 8, 60, false);
            }
        }

        if (event.getInterfaceID() == 160 && event.getButtonID() == 1) {
            context.getPlayer().sendOpenInterfaceSub(164, 3, 122, false);
        }

        if (event.getInterfaceID() == 261 && event.getButtonID() == 21) {
            context.getPlayer().sendOpenInterfaceSub(164, 3, 60, false);
        }
        if (event.getInterfaceID() == 261 && event.getButtonID() == 69) {
            context.getPlayer().sendOpenInterfaceSub(164, 3, 65, false);
        }

        if (event.getInterfaceID() == 387 && event.getButtonID() == 19) {
            context.getPlayer().sendOpenInterfaceSub(164, 3, 464, false);
        }
        if (event.getInterfaceID() == 387 && event.getButtonID() == 21) {
            context.getPlayer().sendOpenInterfaceSub(164, 3, 102, false);// 548, 104
        }
        if (event.getInterfaceID() == 387 && event.getButtonID() == 17) {
            context.getPlayer().sendOpenInterfaceSub(164, 3, 84, false);
        }
        if (event.getInterfaceID() == 261 && event.getButtonID() == 60) {
            context.getPlayer().sendOpenInterfaceSub(164, 3, 65, false);
        }
        if (event.getInterfaceID() == 164 && event.getButtonID() == 52
                || event.getInterfaceID() == 160 && event.getButtonID() == 21) {
            context.getPlayer().getWalkingQueue().flipRunningQueue();
        }
        switch (event.getInterfaceID()) {
            case 216:
                switch (event.getButtonID()) {
                    case 0:
                        context.getPlayer().playAnimation(new Animation(855));// yes
                        return;
                    case 1:
                        context.getPlayer().playAnimation(new Animation(856));// no
                        return;
                    case 2:
                        context.getPlayer().playAnimation(new Animation(858));// bow
                        return;
                    case 3:
                        context.getPlayer().playAnimation(new Animation(859));// angry
                        return;
                    case 4:
                        context.getPlayer().playAnimation(new Animation(857));// think
                        return;
                    case 5:
                        context.getPlayer().playAnimation(new Animation(863));// wave
                        return;
                    case 6:
                        context.getPlayer().playAnimation(new Animation(2113));// shrug
                        return;
                    case 7:
                        context.getPlayer().playAnimation(new Animation(862));// cheer
                        return;
                    case 8:
                        context.getPlayer().playAnimation(new Animation(864));// beckon
                        return;
                    case 9:
                        context.getPlayer().playAnimation(new Animation(864));// laugh
                        // <--
                        return;
                    case 10:
                        context.getPlayer().playAnimation(new Animation(2109));// jump
                        // for
                        // joy
                        return;
                    case 11:
                        context.getPlayer().playAnimation(new Animation(2111));// yawn
                        return;
                    case 12:
                        context.getPlayer().playAnimation(new Animation(866));// dance
                        return;
                    case 13:
                        context.getPlayer().playAnimation(new Animation(2106));// jig
                        return;
                    case 14:
                        context.getPlayer().playAnimation(new Animation(2107));// spin
                        return;
                    case 15:
                        context.getPlayer().playAnimation(new Animation(2108));// head
                        // butt
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

}
