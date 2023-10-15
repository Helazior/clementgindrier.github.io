package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DateStrings {
    private DateStrings() {
    }

    public static C0018A4<String, String> getDateRangeString(Long l, Long l2, SimpleDateFormat simpleDateFormat) {
        if (l == null && l2 == null) {
            return new C0018A4<>(null, null);
        }
        if (l == null) {
            return new C0018A4<>(null, getDateString(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return new C0018A4<>(getDateString(l.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return new C0018A4<>(simpleDateFormat.format(new Date(l.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
        } else if (utcCalendar.get(1) == utcCalendar2.get(1)) {
            if (utcCalendar.get(1) == todayCalendar.get(1)) {
                return new C0018A4<>(getMonthDay(l.longValue(), Locale.getDefault()), getMonthDay(l2.longValue(), Locale.getDefault()));
            }
            return new C0018A4<>(getMonthDay(l.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
        } else {
            return new C0018A4<>(getYearMonthDay(l.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
        }
    }

    public static String getDateString(long j) {
        return getDateString(j, null);
    }

    public static String getMonthDay(long j) {
        return getMonthDay(j, Locale.getDefault());
    }

    public static String getMonthDayOfWeekDay(long j) {
        return getMonthDayOfWeekDay(j, Locale.getDefault());
    }

    public static String getYearMonth(Context context, long j) {
        return DateUtils.formatDateTime(context, j - TimeZone.getDefault().getOffset(j), 36);
    }

    public static String getYearMonthDay(long j) {
        return getYearMonthDay(j, Locale.getDefault());
    }

    public static String getYearMonthDayOfWeekDay(long j) {
        return getYearMonthDayOfWeekDay(j, Locale.getDefault());
    }

    public static String getDateString(long j, SimpleDateFormat simpleDateFormat) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j));
        }
        if (todayCalendar.get(1) == utcCalendar.get(1)) {
            return getMonthDay(j);
        }
        return getYearMonthDay(j);
    }

    public static String getMonthDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j));
        }
        return UtcDates.getMediumNoYear(locale).format(new Date(j));
    }

    public static String getMonthDayOfWeekDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getAbbrMonthWeekdayDayFormat(locale).format(new Date(j));
        }
        return UtcDates.getFullFormat(locale).format(new Date(j));
    }

    public static String getYearMonthDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j));
        }
        return UtcDates.getMediumFormat(locale).format(new Date(j));
    }

    public static String getYearMonthDayOfWeekDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearAbbrMonthWeekdayDayFormat(locale).format(new Date(j));
        }
        return UtcDates.getFullFormat(locale).format(new Date(j));
    }

    public static C0018A4<String, String> getDateRangeString(Long l, Long l2) {
        return getDateRangeString(l, l2, null);
    }
}
