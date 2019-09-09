/**
 * Assumptions - case matters - no characters are ignored - spacing matters
 */
public class OneAway {
    public static void main(String[] args) {
        OneAway oneAway = new OneAway();
        oneAway.test("p", "");
        oneAway.test("", "p");
        oneAway.test("p", "p");
        oneAway.test("pay", "pa");
        oneAway.test("pay", "ay");
        oneAway.test("paye", "pa");
        oneAway.test("pai", "ay");
        oneAway.test("pay", "pai");
        oneAway.test("pay", "pai");
        oneAway.test("pay", "pci");
    }

    protected void test(String s1, String s2) {
        System.out.printf("\"%s\" and \"%s\" are one away=%s\n", s1, s2, oneAway(s1, s2));
    }

    protected boolean oneAway(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new NullPointerException("s1 and s2 cannot be null.");
        }

        int diff = s1.length() - s2.length();
        if (Math.abs(diff) > 1) {
            return false;
        } else if (diff > 0) {
            return oneAway1(s1, s2);
        } else if (diff < 0) {
            return oneAway1(s2, s1);
        } else {
            return oneAway0(s1, s2);
        }
    }

    // when strings are equal length, can only replace
    private boolean oneAway0(String s1, String s2) {
        boolean replaced = false;
        int i = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (replaced) {
                    return false;
                } else {
                    replaced = true;
                }
            }
            i += 1;
        }
        return true;
    }

    // when strings are 1 away in length, can remove in larger string or insert in
    // smaller string
    private boolean oneAway1(String lg, String sm) {
        int i = 0, j = 0;
        while (j < sm.length()) {
            if (lg.charAt(i) != sm.charAt(j)) {
                if (i != j) {
                    return false;
                } else {
                    j -= 1;
                }
            }
            i += 1;
            j += 1;
        }
        return true;
    }
}