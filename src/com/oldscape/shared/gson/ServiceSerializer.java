package com.oldscape.shared.gson;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import com.google.common.util.concurrent.Service;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Created by sean on 16/07/14.
 */
public final class ServiceSerializer implements JsonSerializer<Set<Service>>, JsonDeserializer<Set<Service>> {

	@Override
	public JsonElement serialize(Set<Service> services, Type typeOfSrc, JsonSerializationContext context) {

		/**
		 * The {@link com.google.gson.JsonArray}.
		 */
		JsonArray serviceArray = new JsonArray();

		/**
		 * Loops through the {@link com.google.common.util.concurrent.Service}s
		 * and adds a new {@link com.google.gson.JsonPrimitive} with the name of
		 * the {@link com.google.common.util.concurrent.Service} class.
		 */
		for (Service service : services) {

			/**
			 * Creates a new {@link com.google.gson.JsonPrimitive} with the name
			 * of the {@link com.google.common.util.concurrent.Service}
			 * {@link java.lang.Class}.
			 */
			JsonPrimitive jsonService = new JsonPrimitive(service.getClass().getName());

			/**
			 * Adds the {@link com.google.gson.JsonPrimitive} to the
			 * {@code serviceArray}.
			 */
			serviceArray.add(jsonService);

		}

		/**
		 * Returns the {@code serviceArray}.
		 */
		return serviceArray;
	}

	@Override
	public Set<Service> deserialize(JsonElement element, Type type, JsonDeserializationContext context)
			throws JsonParseException {

		/**
		 * Gets the {@link com.google.gson.JsonArray} from the
		 * {@link com.google.gson.JsonElement}.
		 */
		JsonArray serviceArray = element.getAsJsonArray();

		/**
		 * Creates a new {@link java.util.HashSet}.
		 */
		Set<Service> services = new HashSet<>();

		/**
		 * Loops through the array opf {@link JsonElement}s in the
		 * {@code serviceArray}.
		 */
		for (JsonElement serviceElement : serviceArray) {

			/**
			 * The try/catch to catch the exceptions below.
			 */
			try {

				/**
				 * If the {@code serviceElement} is not a json primitive or is
				 * not a {@link java.lang.String} then an
				 * {@link com.google.gson.JsonParseException} is thrown.
				 */
				if (!serviceElement.isJsonPrimitive() || !((JsonPrimitive) serviceElement).isString())
					new JsonParseException("Error parsing Service element.");

				/**
				 * The class of the
				 * {@link com.google.common.util.concurrent.Service}.
				 */
				String serviceClass = serviceElement.getAsString();

				/**
				 * Creates a new
				 * {@link com.google.common.util.concurrent.Service} based on
				 * the {@link java.lang.String} from the {@code serviceElement}.
				 */
				Service service = (Service) Class.forName(serviceClass).newInstance();

				/**
				 * Adds the {@link com.google.common.util.concurrent.Service} to
				 * the {@link java.util.Set} of
				 * {@link com.google.common.util.concurrent.Service}s.
				 */
				services.add(service);

			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Returns the {@link java.util.Set} of
		 * {@link com.google.common.util.concurrent.Service}s.
		 */
		return services;
	}
}
