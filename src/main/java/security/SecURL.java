package security;

import java.net.URLEncoder;

/**
 * URL�����Ǳ����㷢�����Ǽ����㷨
 * URL��Ŀ���ǰ������ı����ݱ���Ϊ%ǰ׺��ʾ���ı�
 * �������Ľ�����A~Z,a-z,0~9,-_.*,%
 */
public class SecURL {
    public static void main(String[] args) throws Exception {
        String original = "URL ����";
        String encoded = URLEncoder.encode(original, "UTF-8");
        System.out.println(encoded);
        String decoded = URLEncoder.encode(encoded, "UTF-8");
        System.out.println(decoded);
    }
}
