/**
 * Copyright (c) 2014 Virtue Studios
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
 
var Integer = Java.type('java.lang.Integer');
var Permission = Java.type('com.sean.shared.model.player.Permission');
 
/**
 * @author Im Frizzy <skype:kfriz1998>
 * @auther Kayla <skype:ashbysmith1996>
 * @since 7/9/2015
 */

var CommandListener = Java.extend(Java.type('com.sean.shared.script.listeners.CommandListener'), {

	/* The commands to bind to */
	getPossibleSyntaxes: function() {
		return [ "item"];
	},

	/* The first option on an object */
	handle: function(player, syntax, args, clientCommand) {
		var itemID = Integer.parseInt(args[0]);
		var itemAmount = 1;
		if (args.length > 1) {
			itemAmount = Integer.parseInt(args[1]);
			itemAmount = itemAmount > Integer.MAX_VALUE ? Integer.MAX_VALUE : itemAmount;
		}
		player.getInventory().add(itemID, itemAmount);
		return true;
	},
		
	getPermission : function () {
		return Permission.ADMINISTRATOR;
	}

});

/* Listen to the commands specified */
var listen = function(scriptManager) {
	var listener = new CommandListener();
	scriptManager.setCommandListener(listener, listener.getPossibleSyntaxes());
};
