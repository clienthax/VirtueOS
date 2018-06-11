package com.oldscape.client.reference;

import java.awt.event.*;

public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
    public static int mouseLastX;
    public static MouseInput mouse;
    public static volatile int MouseHandler_currentButton;
    public static volatile int mouseX;
    public static volatile int mouseY;
    public static int mouseLastY;
    public static volatile int MouseHandler_lastButton;
    public static int mouseCurrentButton;
    public static volatile int MouseHandler_lastPressedX;
    public static volatile int MouseHandler_lastPressedY;
    public static volatile long MouseHandler_lastPressedTimeMillis;
    public static int mouseLastButton;
    public static int mouseLastPressedX;
    public static int mouseLastPressedY;
    public static long mouseLastPressedTimeMillis;
    static class100 field727;
    static volatile int mouseIdleTicks;

    static {
        mouse = new MouseInput();
        mouseIdleTicks = 0;
        MouseHandler_currentButton = 0;
        mouseX = -1;
        mouseY = -1;
        mouseCurrentButton = 0;
        mouseLastX = 0;
        mouseLastY = 0;
        MouseHandler_lastButton = 0;
        MouseHandler_lastPressedX = 0;
        MouseHandler_lastPressedY = 0;
        MouseHandler_lastPressedTimeMillis = 0L;
        mouseLastButton = 0;
        mouseLastPressedX = 0;
        mouseLastPressedY = 0;
        mouseLastPressedTimeMillis = 0L;
    }

    static int method1066() {
        return 11;
    }

    static void method1062() {
        FileOnDisk var0 = null;

        try {
            var0 = NPC.getPreferencesFile("", class265.field3435.name, true);
            final Buffer var1 = Client.preferences.serialize();
            var0.write(var1.payload, 0, var1.offset);
        } catch (final Exception ignored) {
        }

        try {
            if (var0 != null) {
                var0.closeSync(true);
            }
        } catch (final Exception ignored) {
        }

    }

    public static int ilog(int var0) {
        int var1 = 0;
        if (var0 < 0 || var0 >= 65536) {
            var0 >>>= 16;
            var1 += 16;
        }

        if (var0 >= 256) {
            var0 >>>= 8;
            var1 += 8;
        }

        if (var0 >= 16) {
            var0 >>>= 4;
            var1 += 4;
        }

        if (var0 >= 4) {
            var0 >>>= 2;
            var1 += 2;
        }

        if (var0 >= 1) {
            var0 >>>= 1;
            ++var1;
        }

        return var0 + var1;
    }

    static void method1051(final int var0) {
        if (var0 == -3) {
            BoundingBox3DDrawMode.method53("Connection timed out.", "Please try using a different world.", "");
        } else if (var0 == -2) {
            BoundingBox3DDrawMode.method53("", "Error connecting to server.", "");
        } else if (var0 == -1) {
            BoundingBox3DDrawMode.method53("No response from server.", "Please try using a different world.", "");
        } else if (var0 == 3) {
            class90.loginIndex = 3;
        } else if (var0 == 4) {
            BoundingBox3DDrawMode.method53("Your account has been disabled.", "Please check your message-centre for details.", "");
        } else if (var0 == 5) {
            BoundingBox3DDrawMode.method53("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
        } else if (var0 == 6) {
            BoundingBox3DDrawMode.method53("RuneScape has been updated!", "Please reload this page.", "");
        } else if (var0 == 7) {
            BoundingBox3DDrawMode.method53("This world is full.", "Please use a different world.", "");
        } else if (var0 == 8) {
            BoundingBox3DDrawMode.method53("Unable to connect.", "Login server offline.", "");
        } else if (var0 == 9) {
            BoundingBox3DDrawMode.method53("Login limit exceeded.", "Too many connections from your address.", "");
        } else if (var0 == 10) {
            BoundingBox3DDrawMode.method53("Unable to connect.", "Bad session id.", "");
        } else if (var0 == 11) {
            BoundingBox3DDrawMode.method53("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
        } else if (var0 == 12) {
            BoundingBox3DDrawMode.method53("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
        } else if (var0 == 13) {
            BoundingBox3DDrawMode.method53("Could not complete login.", "Please try using a different world.", "");
        } else if (var0 == 14) {
            BoundingBox3DDrawMode.method53("The server is being updated.", "Please wait 1 minute and try again.", "");
        } else if (var0 == 16) {
            BoundingBox3DDrawMode.method53("Too many login attempts.", "Please wait a few minutes before trying again.", "");
        } else if (var0 == 17) {
            BoundingBox3DDrawMode.method53("You are standing in a members-only area.", "To play on this world move to a free area first", "");
        } else if (var0 == 18) {
            BoundingBox3DDrawMode.method53("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
        } else if (var0 == 19) {
            BoundingBox3DDrawMode.method53("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
        } else if (var0 == 20) {
            BoundingBox3DDrawMode.method53("Invalid loginserver requested.", "Please try using a different world.", "");
        } else if (var0 == 22) {
            BoundingBox3DDrawMode.method53("Malformed login packet.", "Please try again.", "");
        } else if (var0 == 23) {
            BoundingBox3DDrawMode.method53("No reply from loginserver.", "Please wait 1 minute and try again.", "");
        } else if (var0 == 24) {
            BoundingBox3DDrawMode.method53("Error loading your profile.", "Please contact customer support.", "");
        } else if (var0 == 25) {
            BoundingBox3DDrawMode.method53("Unexpected loginserver response.", "Please try using a different world.", "");
        } else if (var0 == 26) {
            BoundingBox3DDrawMode.method53("This computers address has been blocked", "as it was used to break our rules.", "");
        } else if (var0 == 27) {
            BoundingBox3DDrawMode.method53("", "Service unavailable.", "");
        } else if (var0 == 31) {
            BoundingBox3DDrawMode.method53("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
        } else if (var0 == 32) {
            BoundingBox3DDrawMode.method53("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
        } else if (var0 == 37) {
            BoundingBox3DDrawMode.method53("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
        } else if (var0 == 38) {
            BoundingBox3DDrawMode.method53("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
        } else if (var0 == 55) {
            BoundingBox3DDrawMode.method53("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
        } else {
            if (var0 == 56) {
                BoundingBox3DDrawMode.method53("Enter the 6-digit code generated by your", "authenticator app.", "");
                class64.setGameState(11);
                return;
            }

            if (var0 == 57) {
                BoundingBox3DDrawMode.method53("The code you entered was incorrect.", "Please try again.", "");
                class64.setGameState(11);
                return;
            }

            BoundingBox3DDrawMode.method53("Unexpected server response", "Please try using a different world.", "");
        }

        class64.setGameState(10);
    }

    private int method1036(final MouseEvent var1) {
        final int var2 = var1.getButton();
        return !var1.isAltDown() && var2 != 2 ? (!var1.isMetaDown() && var2 != 3 ? 1 : 2) : 4;
    }

    public final synchronized void mouseDragged(final MouseEvent var1) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            mouseX = var1.getX();
            mouseY = var1.getY();
        }

    }

    public final synchronized void mousePressed(final MouseEvent var1) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            MouseHandler_lastPressedX = var1.getX();
            MouseHandler_lastPressedY = var1.getY();
            MouseHandler_lastPressedTimeMillis = class64.method1118();
            MouseHandler_lastButton = this.method1036(var1);
            if (MouseHandler_lastButton != 0) {
                MouseHandler_currentButton = MouseHandler_lastButton;
            }
        }

        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final synchronized void mouseReleased(final MouseEvent var1) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            MouseHandler_currentButton = 0;
        }

        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final void mouseClicked(final MouseEvent var1) {
        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final synchronized void mouseExited(final MouseEvent var1) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            mouseX = -1;
            mouseY = -1;
        }

    }

    public final synchronized void mouseEntered(final MouseEvent var1) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            mouseX = var1.getX();
            mouseY = var1.getY();
        }

    }

    public final synchronized void mouseMoved(final MouseEvent var1) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            mouseX = var1.getX();
            mouseY = var1.getY();
        }

    }

    public final void focusGained(final FocusEvent var1) {
    }

    public final synchronized void focusLost(final FocusEvent var1) {
        if (mouse != null) {
            MouseHandler_currentButton = 0;
        }

    }
}
