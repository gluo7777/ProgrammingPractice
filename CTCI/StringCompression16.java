import java.util.LinkedList;

public class StringCompression16 {
    public static void main(String[] args) {
        StringCompression16 s = new StringCompression16();
        s.test(null, null);
        s.test("", "");
        s.test("a", "a");
        s.test("aa", "aa");
        s.test("aaa", "a3");
        s.test("aab", "aab");
        s.test("aaA", "aaA");
        s.test("aabb", "aabb");
        s.test("aaabb", "a3b2");
    }

    protected void test(String expected, String actual) {
        System.out.printf("Expected=%s. Actual=%s\n", expected, actual);
    }

    protected String compressIfNeeded(String str) {

        if (str == null || str.length <= 2) {
            return str;
        }

        LinkedList<String> cmp = new LinkedList<>();

        int count = 0;
        char prev = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur != prev) {
                cmp.add(cur + Integer.toString(count));
            } else {
                count += 1;
            }
        }

        cmp.add(cur + Integer.toString(count));

        if (cmp.size() * 2 < str.length()) {
            char[] buf = new char[cmp.size() * 2];
            int i = 0;
            for (String part : cmp) {
                buf[i++] = part.charAt(0);
                buf[i++] = part.charAt(1);
            }
            return new String(buf);
        } else {
            return str;
        }

    }
}