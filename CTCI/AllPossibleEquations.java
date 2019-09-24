import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllPossibleEquations {
    public static void main(String[] args) {
        printAllPermutations(1000);
    }

    static void printAllPermutations(int n) {
        // a^3 + b^3 = c^3 + d^3

        // Precompute a^3 + b^3 -> a,b
        Map<Integer, List<Integer[]>> sums = new HashMap<>();
        for (int a = 0; a <= n; a++) {
            for (int b = 0; b <= n; b++) {
                int sum = (int) (Math.pow(a, 3) + Math.pow(b, 3));
                if (sums.containsKey(sum)) {
                    List<Integer[]> pairs = sums.get(sum);
                    pairs.add(new Integer[] { a, b });
                } else {
                    List<Integer[]> pairs = new LinkedList<>();
                    pairs.add(new Integer[] { a, b });
                    sums.put(sum, pairs);
                }
            }
        }

        // print pairs
        for (int sum : sums.keySet()) {
            String equalPairs = "";
            for (Integer[] pair : sums.get(sum)) {
                equalPairs += Arrays.toString(pair) + ",";
            }
            equalPairs = equalPairs.substring(0, equalPairs.length() - 1);
            for (Integer[] pair : sums.get(sum)) {
                System.out.println(Arrays.toString(pair) + "=" + equalPairs);
            }
        }
    }
}