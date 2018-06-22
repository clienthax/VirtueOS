var Animation = Java.type('com.oldscape.server.game.model.sync.reference.Animation');
var AnimationId = Java.type('com.oldscape.server.game.model.anim.AnimationId');
var WidgetId = Java.type('com.oldscape.server.game.model.widget.WidgetId');
var EmotePanel = Java.type('com.oldscape.server.game.model.widget.WidgetId.EmotePanel');

var WidgetListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.WidgetListener'), {

    getPossibleWidgets: function() {
        return [WidgetId.EMOTES_GROUP_ID];
    },

    handle: function(player, widgetHash, childHash, widgetID, widgetChildID, opcode) {
        if (forButton(widgetID) != -1) {
            player.playAnimation(new Animation(forButton(widgetID)));
            return true;
        }
    }
});

function forButton(buttonId) {
    switch (buttonId) {

        case EmotePanel.YES:
            return AnimationId.YES;

        case EmotePanel.NO:
            return AnimationId.NO;

        case EmotePanel.BOW:
            return AnimationId.BOW;

        case EmotePanel.ANGRY:
            return AnimationId.ANGRY;

        case EmotePanel.THINK:
            return AnimationId.THINK;

        case EmotePanel.WAVE:
            return AnimationId.WAVE;

        case EmotePanel.SHRUG:
            return AnimationId.SHRUG;

        case EmotePanel.CHEER:
            return AnimationId.CHEER;

        case EmotePanel.BECKON:
            return AnimationId.BECKON;

        case EmotePanel.LAUGH:
            return AnimationId.LAUGH;

        case EmotePanel.JUMP:
            return AnimationId.JUMP;

        case EmotePanel.YAWN:
            return AnimationId.YAWN;

        case EmotePanel.DANCE:
            return AnimationId.DANCE;

        case EmotePanel.JIG:
            return AnimationId.JIG;

        case EmotePanel.SPIN:
            return AnimationId.SPIN;

        case EmotePanel.HEAD_BANG:
            return AnimationId.HEAD_BANG;

        case EmotePanel.CRY:
            return AnimationId.CRY;

        case EmotePanel.BLOW_KISS:
            return AnimationId.BLOW_KISS;

        case EmotePanel.PANIC:
            return AnimationId.PANIC;

        case EmotePanel.RASPBERRY:
            return AnimationId.RASPBERRY;

        case EmotePanel.CLAP:
            return AnimationId.CLAP;

        case EmotePanel.SALUTE:
            return AnimationId.SALUTE;
        /* MISSING */
        default:
            print("EmotePanel.js: Missing animation for button: " + buttonId);
            return -1;
    }
}

/* Listen for the interfaces specified */
var listen = function(scriptManager) {
    var listener = new WidgetListener();
    scriptManager.setWidgetListener(listener, listener.getPossibleWidgets());
};