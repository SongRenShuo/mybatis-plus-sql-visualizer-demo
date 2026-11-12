package cn.song.custcommon.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具。
 */
public final class DateUtils {

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private DateUtils() {
    }

    public static Date parse(String value, String pattern) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        try {
            return new SimpleDateFormat(pattern).parse(value.trim());
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String format(Date value, String pattern) {
        if (value == null) {
            return "";
        }
        return new SimpleDateFormat(pattern).format(value);
    }

    public static Date addDays(Date value, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    public static Date startOfDay(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date endOfDay(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static long daysBetween(Date start, Date end) {
        if (start == null || end == null) {
            return 0L;
        }
        long millis = end.getTime() - start.getTime();
        return millis / (24L * 60L * 60L * 1000L);
    }
}
