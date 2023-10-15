package p000;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.Time;
import com.google.android.material.badge.BadgeDrawable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: Ld */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0278Ld {

    /* renamed from: a */
    public static Time f920a;

    /* renamed from: b */
    public static Time f921b;

    /* renamed from: c */
    public static SimpleDateFormat f922c = new SimpleDateFormat();

    /* renamed from: a */
    public static String m2217a(long j) {
        return "/Date(" + String.valueOf(j) + "+0000)/";
    }

    /* renamed from: b */
    public static String m2216b(Context context, long j) {
        Resources resources = context.getResources();
        if (f922c == null) {
            f922c = new SimpleDateFormat();
        }
        if (f921b == null) {
            f921b = new Time();
        }
        f921b.setToNow();
        boolean z = false;
        f921b.normalize(false);
        if (j >= 0) {
            if (f920a == null) {
                f920a = new Time();
            }
            f920a.set(j);
            f920a.normalize(true);
        }
        long millis = f921b.toMillis(false) - j;
        if (millis <= 0) {
            return resources.getString(2131689873);
        }
        if (millis < 60000) {
            return resources.getString(2131689874);
        }
        if (millis < 3600000) {
            int i = (int) (millis / 60000);
            return String.format(Locale.getDefault(), resources.getQuantityString(2131623939, i), Integer.valueOf(i));
        }
        Time time = f921b;
        Time time2 = f920a;
        if (time.year == time2.year && time.yearDay == time2.yearDay) {
            int max = Math.max(time.hour - time2.hour, 0);
            return String.format(Locale.getDefault(), resources.getQuantityString(2131623938, max), Integer.valueOf(max));
        }
        time.monthDay--;
        time.normalize(true);
        if (time.year == time2.year && time.yearDay == time2.yearDay) {
            z = true;
        }
        if (z) {
            return f920a.format(context.getString(2131689875));
        }
        Time time3 = f921b;
        Time time4 = f920a;
        time3.monthDay -= 7;
        time3.normalize(true);
        if (time3.before(time4)) {
            return m2214d(context, j);
        }
        Time time5 = f921b;
        Time time6 = f920a;
        time5.month--;
        time5.normalize(true);
        if (time5.before(time6)) {
            return m2214d(context, j);
        }
        Time time7 = f921b;
        Time time8 = f920a;
        time7.year--;
        time7.normalize(true);
        if (time7.before(time8)) {
            return m2214d(context, j);
        }
        return m2214d(context, j);
    }

    /* renamed from: c */
    public static String m2215c(Context context, long j, boolean z, boolean z2, boolean z3, boolean z4) {
        SimpleDateFormat simpleDateFormat;
        if (z3) {
            simpleDateFormat = new SimpleDateFormat("'Le' dd MMMM yyyy");
        } else {
            simpleDateFormat = new SimpleDateFormat("EEEE dd MMMM");
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH'h'mm");
        Time time = new Time();
        time.setToNow();
        time.hour = 0;
        time.minute = 0;
        time.second = 0;
        time.normalize(false);
        if (!z4) {
            Time time2 = new Time();
            time2.set(j);
            if (Time.compare(time, time2) <= 0) {
                if (z) {
                    return context.getString(z2 ? 2131689754 : 2131689755, simpleDateFormat2.format(Long.valueOf(j)));
                }
                return context.getString(z2 ? 2131689753 : 2131689752);
            }
            time.monthDay--;
            time.normalize(false);
            if (Time.compare(time, time2) <= 0) {
                if (z) {
                    return context.getString(z2 ? 2131689758 : 2131689759, simpleDateFormat2.format(Long.valueOf(j)));
                }
                return context.getString(z2 ? 2131689757 : 2131689756);
            }
        }
        return z ? context.getString(2131689748, simpleDateFormat.format(Long.valueOf(j)), simpleDateFormat2.format(Long.valueOf(j))) : context.getString(2131689747, simpleDateFormat.format(Long.valueOf(j)));
    }

    /* renamed from: d */
    public static String m2214d(Context context, long j) {
        Date date = new Date();
        date.setTime(j);
        return new SimpleDateFormat(context.getString(2131689742)).format(date);
    }

    /* renamed from: e */
    public static long m2213e(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(10, calendar.getTimeZone().getOffset(j) / 360000);
        return calendar.getTimeInMillis();
    }

    /* renamed from: f */
    public static long m2212f(String str) {
        String group;
        long j;
        long j2 = -1;
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = Pattern.compile("^\\/Date\\((-?[0-9]*)?([\\+\\-]?[0-9]{4})\\)\\/$").matcher(str);
        int groupCount = matcher.groupCount();
        if (!matcher.matches() || groupCount < 1) {
            return -1L;
        }
        String group2 = matcher.group(1);
        if (group2 != null && group2.length() > 0) {
            j2 = Long.parseLong(group2);
        }
        long offset = Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis());
        if (groupCount < 2 || (group = matcher.group(2)) == null) {
            return j2;
        }
        long parseInt = (Integer.parseInt(group.substring(1)) / 100) * 3600 * 1000;
        if (group.startsWith(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX)) {
            j = offset - parseInt;
        } else if (!group.startsWith("-")) {
            return j2;
        } else {
            j = offset + parseInt;
        }
        return j2 + j;
    }
}
