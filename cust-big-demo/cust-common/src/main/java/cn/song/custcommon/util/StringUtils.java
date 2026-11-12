package cn.song.custcommon.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串工具。
 */
public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String value) {
        return value == null || value.trim().length() == 0;
    }

    public static boolean isNotBlank(String value) {
        return !isBlank(value);
    }

    public static String trimToEmpty(String value) {
        return value == null ? "" : value.trim();
    }

    public static String defaultIfBlank(String value, String defaultValue) {
        return isBlank(value) ? defaultValue : value;
    }

    public static String upper(String value) {
        return value == null ? null : value.trim().toUpperCase();
    }

    public static String lower(String value) {
        return value == null ? null : value.trim().toLowerCase();
    }

    public static String join(List<String> values, String separator) {
        if (values == null || values.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) {
                sb.append(separator);
            }
            sb.append(values.get(i));
        }
        return sb.toString();
    }

    public static List<String> split(String value, String separator) {
        List<String> result = new ArrayList<String>();
        if (isBlank(value)) {
            return result;
        }
        String[] parts = value.split(separator);
        for (String part : parts) {
            if (isNotBlank(part)) {
                result.add(part.trim());
            }
        }
        return result;
    }

    public static String leftPad(String value, int length, char pad) {
        String text = trimToEmpty(value);
        StringBuilder sb = new StringBuilder();
        for (int i = text.length(); i < length; i++) {
            sb.append(pad);
        }
        sb.append(text);
        return sb.toString();
    }
}
