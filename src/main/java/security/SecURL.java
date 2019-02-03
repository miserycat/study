package security;

import java.net.URLEncoder;

/**
 * URL编码是编码算发，不是加密算法
 * URL的目的是把任意文本数据编码为%前缀表示的文本
 * 编码后的文仅包括A~Z,a-z,0~9,-_.*,%
 */
public class SecURL {
    public static void main(String[] args) throws Exception {
        String original = "URL 参数";
        String encoded = URLEncoder.encode(original, "UTF-8");
        System.out.println(encoded);
        String decoded = URLEncoder.encode(encoded, "UTF-8");
        System.out.println(decoded);
    }
}
