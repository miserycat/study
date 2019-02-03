package security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES_ECB_Cipher {
    private static final String CIPHER_NAME = "AES/ECB/PKCS5Padding"; //ECB：工作模式， PKCS5Padding:填充模式

    public static void main(String[] args) throws Exception {
        String message = "Hello, World! encrypted using AES!";
        System.out.println("Message: " + message);
        //128bit key = 16bytes key
        byte[] key = "1234567890abedef".getBytes();
        byte[] data = message.getBytes("UTF-8");
        byte[] encrypt = encrypt(key, data);
        System.out.println("Encrypt data: " + Base64.getEncoder().encodeToString(encrypt));
        //decrypt
        byte[] decrypt = decrypt(key, encrypt);
        System.out.println("Decrypted data: " + new String(decrypt, "UTF-8"));


    }

    public static byte[] encrypt(byte[] key, byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_NAME);
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }

    public static byte[] decrypt(byte[] key, byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_NAME);
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }


}
