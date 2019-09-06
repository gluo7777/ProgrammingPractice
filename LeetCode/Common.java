public class Common {
    public static boolean isLetter(char c) {
        int i = c - 'A';
        // before 'A', between, after 'z'
        return (i < 0 || (i >= 26 && i <= 31) || i > 57);
    }
}