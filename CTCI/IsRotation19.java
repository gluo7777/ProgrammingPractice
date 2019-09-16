public class IsRotation19 {

    public static void main(String[] args) {
        IsRotation19 isRotation19 = new IsRotation19();
        isRotation19.test("", ""); // t
        isRotation19.test("a", "a"); // t
        isRotation19.test("a", "b"); // f
        isRotation19.test("ab", "ab"); // t
        isRotation19.test("ab", "ba"); // t
        isRotation19.test("ab", "bb"); // f
        isRotation19.test("abc", "cab"); // t
    }

    private void test(String s1, String s2) {
        System.out.printf("'%s' is a rotation of '%s' -> %s\n", s1, s2, isRotation(s1, s2));
    }

    /**
     * 
     * @param s1 - rotated string
     * @param s2 - original string
     * @return true if s1 is a rotation of s2
     */
    private boolean isRotation(String s1, String s2) {

        // input check
        if ((s1 == null || s2 == null) || (s1.length() < 2 || s2.length() < 2)) {
            return s1 == s2;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        int x = -1; // start of match in s1
        int y = 0; // length of match

        // find a right substring of s1 that matches a left substring of s2
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(y)) {
                if (x == -1) {
                    x = i;
                }
                y += 1;
            } else {
                if (s1.charAt(i) == s2.charAt(0)) {
                    x = i;
                    y = 1;
                } else {
                    x = -1;
                    y = 0;
                }
            }
        }

        // call isSubstring once
        // determine if left part of s1 is a substring in s2
        if (x == -1) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            return this.isSubstring(s1.substring(0, x), s2);
        }
    }

    /**
     * 
     * @param s1 - string
     * @param s2 - string
     * @return true if s1 is a substring of s2
     */
    private boolean isSubstring(String s1, String s2) {
        return s2.contains(s1);
    }

}