

 var Permission = Java.type('com.sean.shared.model.player.Permission');
 
 
 var CommandListener = Java.extend(Java.type('com.sean.shared.script.listeners.CommandListener'), {

		/* The commands to bind to */
		getPossibleSyntaxes: function() {
			return [ "openbank" ];
		},

		/* The first option on an object */
		handle: function(player, syntax, args, clientCommand) {
			player.sendOpenInterfaceSub(164, 3, 12, false);
			return true;
		},
			
		getPermission : function () {
			return Permission.PLAYER;
		}

	});

	/* Listen to the commands specified */
	var listen = function(scriptManager) {
		var listener = new CommandListener();
		scriptManager.setCommandListener(listener, listener.getPossibleSyntaxes());
	};