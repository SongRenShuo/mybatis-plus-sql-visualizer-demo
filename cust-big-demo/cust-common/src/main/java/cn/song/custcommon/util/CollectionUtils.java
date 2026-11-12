package cn.song.custcommon.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 集合工具。
 */
public final class CollectionUtils {

    private CollectionUtils() {
    }

    public static boolean isEmpty(Collection<?> values) {
        return values == null || values.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> values) {
        return !isEmpty(values);
    }

    public static <T> List<T> emptyIfNull(List<T> values) {
        return values == null ? new ArrayList<T>() : values;
    }

    public static <T> Set<T> distinct(List<T> values) {
        Set<T> result = new LinkedHashSet<T>();
        if (values != null) {
            result.addAll(values);
        }
        return result;
    }

    public static <T> List<T> limit(List<T> values, int maxSize) {
        List<T> result = new ArrayList<T>();
        if (values == null || maxSize <= 0) {
            return result;
        }
        for (int i = 0; i < values.size() && i < maxSize; i++) {
            result.add(values.get(i));
        }
        return result;
    }

    public static <T> List<List<T>> partition(List<T> values, int size) {
        List<List<T>> result = new ArrayList<List<T>>();
        if (values == null || size <= 0) {
            return result;
        }
        List<T> bucket = new ArrayList<T>();
        for (T value : values) {
            bucket.add(value);
            if (bucket.size() == size) {
                result.add(bucket);
                bucket = new ArrayList<T>();
            }
        }
        if (!bucket.isEmpty()) {
            result.add(bucket);
        }
        return result;
    }
}
