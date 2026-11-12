package cn.song.custgateway.util;

/**
 * URL 工具。
 */
public final class UrlUtils {

    private UrlUtils() {
    }

    public static String join(String base, String path) {
        if (base == null) {
            return path;
        }
        if (path == null) {
            return base;
        }
        if (base.endsWith("/") && path.startsWith("/")) {
            return base + path.substring(1);
        }
        if (!base.endsWith("/") && !path.startsWith("/")) {
            return base + "/" + path;
        }
        return base + path;
    }

    public static String pathOf(String url) {
        if (url == null) {
            return "";
        }
        int index = url.indexOf("://");
        if (index < 0) {
            return url;
        }
        int slash = url.indexOf('/', index + 3);
        return slash < 0 ? "/" : url.substring(slash);
    }
}
