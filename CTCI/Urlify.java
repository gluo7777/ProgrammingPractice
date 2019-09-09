import java.util.Arrays;

public class Urlify {
    public static void main(String[] args) {
        Urlify urlify = new Urlify();
        System.out.println(Arrays.toString(urlify.urlify(new char[] { ' ', 'a', '\0', '\0' }, 2))); // %20a
        System.out.println(Arrays.toString(urlify.urlify(new char[] { 'a', ' ', '\0', '\0' }, 2))); // a%20
        System.out.println(Arrays.toString(
                urlify.urlify(new char[] { 'a', ' ', 'b', ' ', ' ', '\0', '\0', '\0', '\0', '\0', '\0' }, 5))); // a%20b%20%20
    }

    private char[] urlify(char[] w, int n) {
        if (w == null || w.length == 0 || n == 0)
            return w;
        if (n > w.length || n < 0)
            throw new RuntimeException();

        int h = n - 1, t = w.length - 1;

        while (h != t) {
            if (w[h] != ' ') {
                w[t] = w[h];
                t -= 1;
            } else {
                w[t] = '0';
                w[t - 1] = '2';
                w[t - 2] = '%';
                t -= 3;
            }
            h -= 1;
        }

        return w;
    }
}