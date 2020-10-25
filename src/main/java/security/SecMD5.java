package security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * MD5��һ�ֳ��õ�hash�㷨 ���128bits/16byte
 * ��������֤����������
 * ���ô洢����ʱҪ���ǲʺ��������salt��
 */
public class SecMD5 {
    public static void main(String[] args) {
        String original = "password";
        byte[] bytes = toMD5(original.getBytes());
        System.out.println(String.format("%32x", new BigInteger(1, bytes)));
        System.out.println(String.format("%32x", new BigInteger(1, toMD5(original, "testSalt"))));
    }

    private static byte[] toMD5(byte[] input) {
        return Digest.digest("MD5", input);
    }

    private static byte[] toMD5(String orginal, String salt) {

        try {
            return toMD5((orginal + salt).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
