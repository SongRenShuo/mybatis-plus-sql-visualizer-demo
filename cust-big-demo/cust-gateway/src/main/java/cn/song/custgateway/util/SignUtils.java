package cn.song.custgateway.util;

/**
 * 签名工具。
 */
public final class SignUtils {

    private SignUtils() {
    }

    public static String sign(String appId, String timestamp, String secret) {
        String raw = String.valueOf(appId) + "|" + String.valueOf(timestamp) + "|" + String.valueOf(secret);
        return Integer.toHexString(raw.hashCode());
    }

    public static boolean verify(String appId, String timestamp, String secret, String sign) {
        return sign(appId, timestamp, secret).equals(sign);
    }
}
