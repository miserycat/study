package security;

import java.security.MessageDigest;

public class Digest {
    public static byte[] digest(String hashAlgorithm, byte[] input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(hashAlgorithm);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        md.update(input);
        return md.digest();
    }
}
