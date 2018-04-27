package com.sean.shared.model.player;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * Created by sean on 10/08/14.
 */
public final class AccountCredentials {

	/**
	 * The {@link java.util.Date} the account was created.
	 */
	private final Date accountCreation;

	/**
	 * The last time the account logged in.
	 */
	private final Date lastLoggedIn;

	/**
	 * The amount of unread messages.
	 */
	private final int unreadMessage;

	/**
	 * The email address.
	 */
	private final String emailAddress;

	/**
	 * The username.
	 */
	private final String username;

	/**
	 * The password.
	 */
	private final String password;

	/**
	 * The display name.
	 */
	private final String displayName;

	/**
	 * The last known ip address.
	 */
	private final String lastKnownIpAddress;

	/**
	 * The {@link java.util.Date} of the expiry of the membership of the account
	 */
	private final Date membershipExpiryDate;

	/**
	 * The type of subscription of the account
	 */
	private final SubscriptionType subscriptionType;

	/**
	 * The {@link com.sean.shared.model.player.Permission} of the account.
	 */
	private final Permission permission;

	/**
	 * Is the email address verified.
	 */
	private final boolean emailVerified;

	/*
	 * Is the account authenticated
	 */
	private final boolean authenticated;

	/**
	 * Creates a new {@link AccountCredentials}.
	 * 
	 * @param accountCreation
	 *            The {@link java.util.Date} the account was created.
	 * @param lastLoggedIn
	 *            The last time the account is logged in.
	 * @param username
	 *            The username.
	 * @param displayName
	 *            The display name.
	 * @param emailAddress
	 *            The email address.
	 * @param password
	 *            The password.
	 * @param unreadMessage
	 *            The amount of unread messages.
	 * @param lastKnownIpAddress
	 *            The last known ip address.
	 * @param membershipExpiryDate
	 *            The date the membership will expire.
	 * @param subscriptionType
	 *            The type of subscription.
	 * @param permission
	 *            The permission of the account.
	 * @param emailVerified
	 *            Is the email verified.
	 */
	public AccountCredentials(Date accountCreation, Date lastLoggedIn, String username, String displayName,
			String emailAddress, String password, int unreadMessage, String lastKnownIpAddress,
			Date membershipExpiryDate, SubscriptionType subscriptionType, Permission permission, boolean emailVerified,
			boolean auth) {

		this.accountCreation = accountCreation;
		this.lastLoggedIn = lastLoggedIn;
		this.emailAddress = emailAddress;
		this.password = password;
		this.username = username;
		this.displayName = displayName;
		this.unreadMessage = unreadMessage;
		this.lastKnownIpAddress = lastKnownIpAddress;
		this.membershipExpiryDate = membershipExpiryDate;
		this.subscriptionType = subscriptionType;
		this.permission = permission;
		this.emailVerified = emailVerified;
		this.authenticated = auth;
	}

	/**
	 * Gets the User Name.
	 * 
	 * @return The {@code username}.
	 */
	public String getUserName() {
		return username;
	}

	/**
	 * Gets the password.
	 * 
	 * @return The {@code password}.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the email address.
	 * 
	 * @return The {@code emailAddress}.
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Gets the display name.
	 * 
	 * @return The {@code displayName}.
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Gets the {@link java.util.Date} of when the account was created.
	 * 
	 * @return The {@code accountCreation}.
	 */
	public Date getAccountCreation() {
		return accountCreation;
	}

	/**
	 * Gets the last logged in {@link java.util.Date}.
	 * 
	 * @return The {@code lastLoggedIn}.
	 */
	public Date getLastLoggedIn() {
		return lastLoggedIn;
	}

	/**
	 * Gets the {@code lastLoggedIn} time as days left.
	 * 
	 * @return The {@code lastLoggedIn} as days left.
	 */
	public long getLastLoggedInDays() {
		return lastLoggedIn == null ? 0 : Days.daysBetween(new DateTime(lastLoggedIn), new DateTime()).getDays();
	}

	/**
	 * Gets the amount of unread messages.
	 * 
	 * @return The amount of unread messages.
	 */
	public int getUnreadMessage() {
		return unreadMessage;
	}

	/**
	 * Gets the last known ip address.
	 * 
	 * @return The {@code lastKnownIpAddress}.
	 */
	public String getLastKnownIpAddress() {
		return lastKnownIpAddress;
	}

	/**
	 * Gets the {@link java.util.Date} of the membership expiry.
	 * 
	 * @return The {@code membershipExpiryDate}.
	 */
	public Date getMembershipExpiryDate() {
		return membershipExpiryDate;
	}

	/**
	 * Gets the {@code membershipExpiryDate} time as days left.
	 * 
	 * @return The {@code membershipExpiryDate} as days left.
	 */
	public int getMembershipDaysLeft() {
		return membershipExpiryDate == null ? 0
				: Days.daysBetween(new DateTime(), new DateTime(membershipExpiryDate)).getDays();
	}

	/**
	 * Gets the {@link SubscriptionType}.
	 * 
	 * @return The {@code subscriptionType}.
	 */
	public SubscriptionType getSubscriptionType() {
		return subscriptionType;
	}

	/**
	 * Gets the {@link com.sean.shared.model.player.Permission}.
	 * 
	 * @return The {@code permission}.
	 */
	public Permission getPermission() {
		return permission;
	}

	/**
	 * Is the email verified.
	 * 
	 * @return The {@code emailVerified};
	 */
	public boolean isEmailVerified() {
		return emailVerified;
	}

	/**
	 * Is the account authenticated
	 * 
	 * @return The {@code authenticated};
	 */
	public boolean isAurthenticated() {
		return authenticated;
	}
}
