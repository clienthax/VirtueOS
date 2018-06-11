package com.oldscape.shared.network.login;

import com.oldscape.shared.event.Event;
import com.oldscape.shared.utility.IsaacRandom;

/**
 * Created by sean on 17/07/14.
 */
public final class LoginEvent implements Event {

    private final int major;

    private final String token;

    private final String username;

    private final String password;

    private final int[] crcValues;

    private final IsaacRandom encodingRandom;

    private final IsaacRandom decodingRandom;

    public LoginEvent(int major, String token, String username, String password, int[] crcValues, IsaacRandom encodingRandom, IsaacRandom decodingRandom) {
        this.major = major;
        this.token = token;
        this.username = username;
        this.password = password;
        this.crcValues = crcValues;
        this.encodingRandom = encodingRandom;
        this.decodingRandom = decodingRandom;
    }

    /**
     * @return the major
     */
    public int getMajor() {
        return major;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    public IsaacRandom getDecodingRandom() {
        return decodingRandom;
    }

    public int[] getCrcValues() {
        return crcValues;
    }

    public String getPassword() {
        return password;
    }

    public IsaacRandom getEncodingRandom() {
        return encodingRandom;
    }

    public String getUserName() {
        return username;
    }
}
