package cn.song.custgateway.util;

/**
 * IP 工具。
 */
public final class IpUtils {

    private IpUtils() {
    }

    public static boolean isInternal(String ip) {
        if (ip == null) {
            return false;
        }
        return ip.startsWith("127.")
                || ip.startsWith("10.")
                || ip.startsWith("192.168.")
                || ip.startsWith("172.16.");
    }

    public static String normalize(String forwardedFor) {
        if (forwardedFor == null) {
            return "";
        }
        int comma = forwardedFor.indexOf(',');
        return comma < 0 ? forwardedFor.trim() : forwardedFor.substring(0, comma).trim();
    }
}
