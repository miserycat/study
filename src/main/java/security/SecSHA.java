package security;

import java.math.BigInteger;

public class SecSHA {
    public static void main(String[] args) {
        String original = "password";
        byte[] bytes = sha1(original.getBytes());
        System.out.println(String.format("%40x", new BigInteger(1, bytes)));
    }

    private static byte[] sha1(byte[] input) {
        return Digest.digest("SHA-1", input);
    }
}
