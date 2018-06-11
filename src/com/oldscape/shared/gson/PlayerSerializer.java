/**
 * Copyright (c) 2015 Virtue Studios
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oldscape.shared.gson;

import com.google.gson.*;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.shared.model.Position;
import com.oldscape.shared.model.Position.RegionSize;
import com.oldscape.shared.model.player.AccountCredentials;
import com.oldscape.shared.model.player.DisplayMode;
import com.oldscape.shared.model.player.Permission;
import com.oldscape.shared.model.player.SubscriptionType;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * @author Im Frizzy <skype:kfriz1998>
 * @since Mar 16, 2015
 */
public class PlayerSerializer implements JsonSerializer<Player>, JsonDeserializer<Player> {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
     * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
     */
    @Override
    public Player deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        /**
         * Creates a new {@link com.google.gson.JsonObject}.
         */
        JsonObject obj = json.getAsJsonObject();

        /**
         * Creates a new {@link java.text.SimpleDateFormat}.
         */
        DateFormat format = new SimpleDateFormat();

        /**
         * Parses the player's credentials to the {@code obj}.
         */
        String username = obj.get("username").getAsString();
        String display = obj.get("display").getAsString();
        String password = obj.get("password").getAsString();
        Permission permission = Permission.valueOf(obj.get("permission").getAsString());
        SubscriptionType subscription = SubscriptionType.valueOf(obj.get("subscription").getAsString());
        String ip = obj.get("ip").getAsString();
        String email = obj.get("email").getAsString();
        boolean verified = obj.get("verified").getAsBoolean();
        boolean auth = obj.get("authenticated").getAsBoolean();
        int unread = obj.get("unread").getAsInt();

        Date creation = null;
        Date login = null;
        Date expire = null;
        try {
            creation = format.parse(obj.get("creation").getAsString());
            login = format.parse(obj.get("login").getAsString());
            expire = format.parse(obj.get("expire").getAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DisplayMode mode = DisplayMode.valueOf(obj.get("mode").getAsString());

        int x = obj.get("x").getAsInt();
        int y = obj.get("y").getAsInt();
        int height = obj.get("height").getAsInt();
        RegionSize size = RegionSize.valueOf(obj.get("size").getAsString());

        AccountCredentials credentials = new AccountCredentials(creation, login, username, display, email, password,
                unread, ip, expire, subscription, permission, verified, auth);
        Position position = new Position(x, y, height, size);
        Player player = new Player(1, credentials, mode);
        player.setPosition(position);
        player.setLastPosition(position);

        /**
         * Returns the {@code com.oldscape.shared.model.player.AccountCredentials}.
         */
        return player;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.google.gson.JsonSerializer#serialize(java.lang.Object,
     * java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
     */
    @Override
    public JsonElement serialize(Player src, Type typeOfSrc, JsonSerializationContext context) {

        /**
         * Creates a new {@link com.google.gson.JsonObject}.
         */
        JsonObject obj = new JsonObject();

        /**
         * Creates a new {@link java.text.SimpleDateFormat}.
         */
        DateFormat format = new SimpleDateFormat();

        /**
         * Adds the player's credentials to the {@code obj}.
         */
        obj.addProperty("username", src.getCredentials().getUserName());
        obj.addProperty("display", src.getCredentials().getDisplayName());
        obj.addProperty("password", src.getCredentials().getPassword());
        obj.addProperty("permission", src.getCredentials().getPermission().toString());
        obj.addProperty("subscription", src.getCredentials().getSubscriptionType().toString());
        obj.addProperty("ip", src.getCredentials().getLastKnownIpAddress());
        obj.addProperty("email", src.getCredentials().getEmailAddress());
        obj.addProperty("verified", src.getCredentials().isEmailVerified());
        obj.addProperty("authenticated", src.getCredentials().isAurthenticated());
        obj.addProperty("unread", src.getCredentials().getUnreadMessage());
        obj.addProperty("creation", format.format(src.getCredentials().getAccountCreation()));
        obj.addProperty("login", format.format(Date.from(Instant.now())));
        obj.addProperty("expire", format.format(src.getCredentials().getMembershipExpiryDate()));
        obj.addProperty("mode", src.getDisplay().toString());
        obj.addProperty("x", src.getPosition().getX());
        obj.addProperty("y", src.getPosition().getY());
        obj.addProperty("height", src.getPosition().getHeight());
        obj.addProperty("size", src.getPosition().getMapSize().toString());

        /**
         * Returns the {@code obj}.
         */
        return obj;
    }
}
