package wenjun.concurrent.chapter29;

import java.io.*;

public final class EncryptUtils {
    public static final byte ENCRYPT_FACTOR = (byte) 0xff;
    private EncryptUtils() {

    }

    public static void doEncryption(final String source, final String target) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(target)){
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data ^ ENCRYPT_FACTOR);
            }
            fos.flush();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        doEncryption("/Users/shengchaowu/MyClassLoaderDir/wenjun/concurrent/chapter29/MyObject_plain.class",
                "/Users/shengchaowu/MyClassLoaderDir/wenjun/concurrent/chapter29/MyObject.class");
    }
}
