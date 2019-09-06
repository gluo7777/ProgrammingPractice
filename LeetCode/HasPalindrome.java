import java.util.Arrays;

public class HasPalindrome {
    public static void main(String[] args) {
        HasPalindrome hasPalindrome = new HasPalindrome();
        hasPalindrome.print("a"); // t
        hasPalindrome.print("aa"); // t
        hasPalindrome.print("ab"); // f
        hasPalindrome.print("aab"); // t
        hasPalindrome.print("aabb"); // t
        hasPalindrome.print("aa bb"); // t
        hasPalindrome.print("aa bb c"); // t
        hasPalindrome.print("aa bb cc"); // t
        hasPalindrome.print("aa bb c"); // t
        hasPalindrome.print("aa bb c a"); // f
        hasPalindrome.print("aa bb c a c"); // t
    }

    private void print(String word) {
        System.out.printf("'%s' is a palindrome -> %s\n", word, hasPalindrome(word));
    }

    private boolean hasPalindrome(String word) {
        // error check
        if (word == null)
            throw new NullPointerException("Word cannot be null.");

        char[] chars = word.toCharArray();
        int[] ct = new int[26];
        int odds = 0;

        for (char c : chars) {
            // skip spaces
            if (c == ' ') {
                continue;
            }

            // case insensitive
            int i = c - 'A';
            if (i < 0 || (i >= 26 && i <= 31) || i > 57) // before 'A', between, after 'z'
                throw new RuntimeException("Invalid character: " + c);
            if (i >= 26) {
                i = c - 'a';
            }

            ct[i] = ct[i] + 1;
            if (ct[i] % 2 == 1)
                odds += 1;
            else
                odds -= 1;
        }

        return odds <= 1;
    }
}