package com.example.organizer.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtils {

    public static long convertLocalToUTC(long localTimeInMillis) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(localTimeInMillis);
        long localOffset = localCalendar.getTimeZone().getOffset(localCalendar.getTimeInMillis());
        return localTimeInMillis - localOffset;
    }

    public static long convertUTCToLocal(long utcTimeInMillis) {
        Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        utcCalendar.setTimeInMillis(utcTimeInMillis);
        long utcOffset = TimeZone.getDefault().getOffset(utcCalendar.getTimeInMillis());
        return utcTimeInMillis + utcOffset;
    }

    public static String showDate(Long utcTimeInMillis) {
        if (utcTimeInMillis == null) {
            return "";
        }
        long localDateTime = convertUTCToLocal(utcTimeInMillis);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm", Locale.getDefault());
        return sdf.format(new Date(localDateTime));
    }
}

