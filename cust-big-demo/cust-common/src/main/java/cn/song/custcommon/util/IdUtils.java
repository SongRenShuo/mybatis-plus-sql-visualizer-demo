package cn.song.custcommon.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 简单 ID 生成器（演示用）。
 */
public final class IdUtils {

    private static final AtomicLong SEQUENCE = new AtomicLong(1000L);

    private IdUtils() {
    }

    public static long nextId() {
        return System.currentTimeMillis() * 1000L + SEQUENCE.incrementAndGet() % 1000L;
    }

    public static String nextBizNo(String prefix) {
        return StringUtils.trimToEmpty(prefix) + nextId();
    }

    public static Long parseLong(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        try {
            return Long.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
