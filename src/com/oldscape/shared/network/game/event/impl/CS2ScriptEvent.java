package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.event.Event;

public final class CS2ScriptEvent implements Event {

	public final int id;
	public final Object[] params;

	public CS2ScriptEvent(int id, Object[] params) {
		this.id = id;
		this.params = params;
	}

	public int getId() {
		return id;
	}

	public Object[] getParams() {
		return params;
	}

	public String getParamsAsString() {
		String paramString = "";
		if (params == null) {
			return "";
		}
		for (int param = params.length - 1; param >= 0; param--) {
			if (params[param] instanceof String) {
				paramString += "s";
			} else {
				paramString += "i";
			}
		}
		return paramString;
	}

}
