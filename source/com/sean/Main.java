package com.sean;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sean.game.Server;
import com.sean.game.ServerContext;
import com.sean.shared.gson.InetSocketAddressSerializer;

/**
 * Created by sean on 16/07/14.
 */
public final class Main {

	/**
	 * Starts the application.
	 * 
	 * @param args
	 *            The arguments of the application.
	 * @throws java.io.IOException
	 *             The exception thrown if an i/o error occurs.
	 */
	public static void main(String[] args) throws IOException {

		/**
		 * The {@link com.google.gson.GsonBuilder}.
		 */
		GsonBuilder builder = new GsonBuilder();

		/**
		 * Registers adapters for the parsing.
		 */
		builder.registerTypeAdapter(InetSocketAddress.class, new InetSocketAddressSerializer());

		/**
		 * Reads the properties file from the resource.
		 */
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream("./repository/properties.json")))) {

			/**
			 * Creates the {@link com.google.gson.Gson}.
			 */
			Gson gson = builder.create();

			/**
			 * Creates a new {@link com.sean.rs3.game.ServerContext} from the
			 * properties file.
			 */
			ServerContext ctx = gson.fromJson(reader, ServerContext.class);

			/**
			 * Closes the reader
			 */
			reader.close();

			/**
			 * Creates a new {@link com.sean.rs3.game.Server} and initializes
			 * and binds the server.
			 */
			new Server(ctx).initialize().bind();
		}

	}

}