var Animation = Java.type('com.oldscape.server.game.model.sync.reference.Animation');
var AnimationId = Java.type('com.oldscape.server.game.model.anim.AnimationId');
var WidgetId = Java.type('com.oldscape.server.game.model.widget.WidgetId');

var WidgetListener = Java.extend(Java.type('com.oldscape.shared.script.listeners.WidgetListener'), {

    getPossibleWidgets: function() {
        return [WidgetId.EMOTES_GROUP_ID];
    },

    handle: function(player, widgetId, buttonId, itemId, slotId, option) {
        if (forButton(buttonId) != -1) {
            player.playAnimation(new Animation(forButton(buttonId)));
            return true;
        }
    }
});

function forButton(buttonId) {
    switch (buttonId) {

        case WidgetId.EmotePanel.YES:
            return AnimationId.YES;

        case WidgetId.EmotePanel.NO:
            return AnimationId.NO;

        case WidgetId.EmotePanel.BOW:
            return AnimationId.BOW;

        case WidgetId.EmotePanel.ANGRY:
            return AnimationId.ANGRY;

        case WidgetId.EmotePanel.THINK:
            return AnimationId.THINK;

        case WidgetId.EmotePanel.WAVE:
            return AnimationId.WAVE;

        case WidgetId.EmotePanel.SHRUG:
            return AnimationId.SHRUG;

        case WidgetId.EmotePanel.CHEER:
            return AnimationId.CHEER;

        case WidgetId.EmotePanel.BECKON:
            return AnimationId.BECKON;

        case WidgetId.EmotePanel.LAUGH:
            return AnimationId.LAUGH;

        case WidgetId.EmotePanel.JUMP:
            return AnimationId.JUMP;

        case WidgetId.EmotePanel.YAWN:
            return AnimationId.YAWN;

        case WidgetId.EmotePanel.DANCE:
            return AnimationId.DANCE;

        case WidgetId.EmotePanel.JIG:
            return AnimationId.JIG;

        case WidgetId.EmotePanel.SPIN:
            return AnimationId.SPIN;

        case WidgetId.EmotePanel.HEAD_BANG:
            return AnimationId.HEAD_BANG;

        case WidgetId.EmotePanel.CRY:
            return AnimationId.CRY;

        case WidgetId.EmotePanel.BLOW_KISS:
            return AnimationId.BLOW_KISS;

        case WidgetId.EmotePanel.PANIC:
            return AnimationId.PANIC;

        case WidgetId.EmotePanel.RASPBERRY:
            return AnimationId.RASPBERRY;

        case WidgetId.EmotePanel.CLAP:
            return AnimationId.CLAP;

        case WidgetId.EmotePanel.SALUTE:
            return AnimationId.SALUTE;

        /* MISSING */
        default:
            print("EmotePanel.js: Missing animation for button: " + buttonId);
            return;
    }
}

/* Listen for the interfaces specified */
var listen = function(scriptManager) {
    var listener = new WidgetListener();
    scriptManager.setWidgetListener(listener, listener.getPossibleWidgets());
};