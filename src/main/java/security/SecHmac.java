package security;

import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class SecHmac {
    public static void main(String[] args) throws Exception {
        String algorithm = "HmacSHA1";

        String data = "helloworld";
        //generate key randomly
        KeyGenerator keygen = KeyGenerator.getInstance(algorithm);
        SecretKey skey = keygen.generateKey();
        byte[] key = skey.getEncoded();
        System.out.println(ByteUtils.toHexString(key));
        byte[] result = hmac(algorithm, skey, algorithm.getBytes("UTF-8"));
        System.out.println(ByteUtils.toHexString(result));
    }

    private static byte[] hmac(String hmacAlgorithm, SecretKey skey, byte[] input) throws Exception {
        Mac mac = Mac.getInstance(hmacAlgorithm);
        mac.init(skey);
        mac.update(input);

        return mac.doFinal();
    }
}
