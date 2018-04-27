package com.oldscape.shared.utility;

/**
 * Created by Sean on 13/08/2014.
 */
public class IPAddressUtils {

	/**
	 * Turns to the ip address to an integer.
	 * 
	 * @param addr
	 *            The ip address.
	 * @return The ip as an integer.
	 */
	public static int ipToInt(String addr) {
		String[] addrArray = addr.split("\\.");
		int ip = 0;
		for (int i = 0; i < addrArray.length; i++) {
			int power = 3 - i;
			ip += ((Integer.parseInt(addrArray[i]) % 256 * Math.pow(256, power)));

		}
		return ip;
	}
}
