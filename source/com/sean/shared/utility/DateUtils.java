package com.sean.shared.utility;

/**
 * Created by Sean on 13/08/2014.
 */

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public final class DateUtils {

	/**
	 * The jagex epoch
	 */
	private static final LocalDateTime JAGEX_EPOCH = LocalDateTime.of(2002, 2, 27, 0, 0, 0, 0);

	/**
	 * The private constructor so the {@link java.lang.Class} can't be
	 * initialised.
	 */
	private DateUtils() {

	}

	/**
	 * Calculates the number of days between a {@link java.util.Date} and the
	 * current date.
	 * 
	 * @param date
	 *            The {@link java.util.Date} to calculate the days between.
	 * @return The amount of days.
	 */
	public static int daysBetween(Date date) {

		if (date == null)
			return 0;

		LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
		LocalDateTime toDay = LocalDateTime.now();
		long betweenJagAndNow = ChronoUnit.DAYS.between(JAGEX_EPOCH, toDay);
		long betweenNowAndLastLogin = ChronoUnit.DAYS.between(dateTime, toDay);
		return (int) (betweenJagAndNow - betweenNowAndLastLogin);
	}

}
