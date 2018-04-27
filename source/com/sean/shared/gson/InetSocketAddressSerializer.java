package com.sean.shared.gson;

import java.lang.reflect.Type;
import java.net.InetSocketAddress;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Created by sean on 16/07/14.
 */
public final class InetSocketAddressSerializer
		implements JsonSerializer<InetSocketAddress>, JsonDeserializer<InetSocketAddress> {

	@Override
	public InetSocketAddress deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {

		/**
		 * If the element isn't an json object, an
		 * {@link com.google.gson.JsonParseException} is thrown.
		 */
		if (!json.isJsonObject()) {
			throw new JsonParseException("error, no json object detected.");
		}

		/**
		 * The {@link com.google.gson.JsonObject}.
		 */
		JsonObject obj = json.getAsJsonObject();

		/**
		 * Gets the {@link com.google.gson.JsonElement} from the 'address'.
		 */
		JsonElement address = obj.get("address");

		/**
		 * Gets the {@link com.google.gson.JsonElement} from the 'port'.
		 */
		JsonElement port = obj.get("port");

		/**
		 * If the {@code address} or {@code port} is null, an
		 * {@link com.google.gson.JsonParseException} is thrown.
		 */
		if (address == null || port == null)
			new JsonParseException("address or port missing.");

		/**
		 * If the {@code address} is not a json primitive or a
		 * {@link java.lang.String} an
		 * {@link com.google.gson.JsonParseException} is thrown.
		 */
		if (!address.isJsonPrimitive() || !((JsonPrimitive) address).isString())
			new JsonParseException("error parsing address.");

		/**
		 * If the {@code port} is not a json primitive or a type of number, an
		 * {@link com.google.gson.JsonParseException} is thrown.
		 */
		if (!port.isJsonPrimitive() || !((JsonPrimitive) port).isNumber())
			new JsonParseException("error parsing port.");

		/**
		 * Returns a new {@link java.net.InetSocketAddress} from the decoded
		 * data from the json file.
		 */
		return new InetSocketAddress(address.getAsString(), port.getAsInt());
	}

	@Override
	public JsonElement serialize(InetSocketAddress src, Type typeOfSrc, JsonSerializationContext context) {

		/**
		 * Creates a new {@link com.google.gson.JsonObject}.
		 */
		JsonObject obj = new JsonObject();

		/**
		 * Adds the address hostname and port to the {@code obj}.
		 */
		obj.addProperty("address", src.getHostName());
		obj.addProperty("port", src.getPort());

		/**
		 * Returns the {@code obj}.
		 */
		return obj;
	}
}
