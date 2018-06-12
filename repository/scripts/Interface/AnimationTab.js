var Animation = Java.type('com.oldscape.server.game.model.sync.reference.Animation');

var WidgetListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.WidgetListener'), {

    /* The interfaces to bind to */
    getPossibleWidgets: function() {
        /* EMOTE_CONTAINER */
        return [216];
    },

    handle: function(player, widgetId, buttonId, itemId, slotId, option) {
        if (forButton(buttonId) != -1) {
            player.playAnimation(new Animation(forButton(buttonId)));
        }
    }
});

function forButton(buttonId) {
    switch (buttonId) {
        /* YES */
        case 0:
            return 885;
        /* NO */
        case 1:
            return 856;
        /* BOW *
        case 2:
            return 858;
        /* ANGRY */
        case 3:
            return 859;
        /* THINK */
        case 4:
            return 857;
        /* WAVE */
        case 5:
            return 863;
        /* SHRUG */
        case 6:
            return 2113;
        /* CHEER */
        case 7:
            return 862;
        /* BECKON */
        case 8:
            return 864;
        /* LAUGH */
        case 9:
            return 861;
        /* JUMP */
        case 10:
            return 2109;
        /* YAWN */
        case 11:
            return 2111;
        /* DANCE */
        case 12:
            return 866;
        /* JIG */
        case 13:
            return 2106;
        /* SPIN */
        case 14:
            return 2107;
        /* HEAD BANG */
        case 15:
            return 2108;
        /* CRY */
        case 16:
            return 860;
        /* BLOW KISS */
        case 17:
            return 1374;
        /* PANIC */
        case 18:
            return 2105;
        /* RASPBERRY */
        case 19:
            return 2110;
        /* CLAP */
        case 20:
            return 865;
        /* SALUTE */
        case 21:
            return 2112;

        /* MISSING */
        default:
            print("AnimationTab.js: Missing animation for button: " + buttonId);
            return;
    }
}

/* Listen for the interfaces specified */
var listen = function(scriptManager) {
    var listener = new WidgetListener();
    scriptManager.setInterfaceListener(listener, listener.getPossibleWidgets));
};