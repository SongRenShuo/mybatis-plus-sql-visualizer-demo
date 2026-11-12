package cn.song.custcommon.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射工具（仅用于演示页面的字段投影）。
 */
public final class BeanUtils {

    private BeanUtils() {
    }

    public static Map<String, Object> toMap(Object bean) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (bean == null) {
            return result;
        }
        Class<?> type = bean.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                result.put(field.getName(), field.get(bean));
            } catch (IllegalAccessException ex) {
                result.put(field.getName(), null);
            }
        }
        return result;
    }

    public static void copy(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        Map<String, Object> values = toMap(source);
        Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!values.containsKey(field.getName())) {
                continue;
            }
            field.setAccessible(true);
            try {
                field.set(target, values.get(field.getName()));
            } catch (IllegalAccessException ex) {
                // 忽略不可写字段
            }
        }
    }
}
