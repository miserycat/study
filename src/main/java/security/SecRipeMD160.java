package security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import java.security.MessageDigest;
import java.security.Security;

public class SecRipeMD160 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest md = MessageDigest.getInstance("RipeMD160");
        md.update("password".getBytes());
        byte[] bytes = md.digest();

        System.out.println(ByteUtils.toHexString(bytes));
    }
}
