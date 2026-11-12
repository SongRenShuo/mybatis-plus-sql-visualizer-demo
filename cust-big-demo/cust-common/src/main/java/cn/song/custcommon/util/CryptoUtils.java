package cn.song.custcommon.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 摘要工具。
 */
public final class CryptoUtils {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    private CryptoUtils() {
    }

    public static String md5Hex(String value) {
        if (value == null) {
            return "";
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(value.getBytes(UTF8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }

    public static String maskMobile(String mobile) {
        if (StringUtils.isBlank(mobile) || mobile.length() < 7) {
            return mobile;
        }
        return mobile.substring(0, 3) + "****" + mobile.substring(mobile.length() - 4);
    }

    public static String maskCertNo(String certNo) {
        if (StringUtils.isBlank(certNo) || certNo.length() < 8) {
            return certNo;
        }
        return certNo.substring(0, 4) + "**********" + certNo.substring(certNo.length() - 4);
    }
}
