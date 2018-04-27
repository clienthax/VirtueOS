package com.oldscape.client;

import java.util.Calendar;
import java.util.TimeZone;

public class class204 {
   public static final String[][] monthLanguages;
   public static final String[] days;
   public static Calendar gmtCalendar;

   static {
      monthLanguages = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      days = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      gmtCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
