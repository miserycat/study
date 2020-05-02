package wenjun.concurrent.chapter29;


//一个整形a, a^b^b = a
public class SimpleEncrypt {
    private static final String plain = "Hello ClassLoader";
    private static final byte ENCRYPT_FACTOR = (byte) 0xff;

    public static void main(String[] args) {
        final byte[] bytes = plain.getBytes();
        final byte[] encrypt =new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            encrypt[i] = (byte) (bytes[i] ^ ENCRYPT_FACTOR);
        }

        System.out.println(new String(encrypt));

        final byte[] decrypt = new byte[bytes.length];
        for (int i = 0; i < encrypt.length; i++) {
            decrypt[i] = (byte) (encrypt[i] ^ ENCRYPT_FACTOR);
        }

        System.out.println(new String(decrypt));

    }
}
