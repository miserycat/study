package security;

import java.util.Base64;

public class SecBase64 {
    public static void main(String[] args) throws Exception {
        String original = "Hello\u00ff±‡¬Î≤‚ ‘";
        String encoded = Base64.getEncoder().encodeToString(original.getBytes());
//        String encoded = Base64.getUrlEncoder().encodeToString(original.getBytes());
        System.out.println(encoded);
        String decoded = new String(Base64.getDecoder().decode(encoded), "UTF-8");
//        String decoded = new String(Base64.getUrlDecoder().decode(encoded), "UTF-8");
        System.out.println(decoded);
    }
}
