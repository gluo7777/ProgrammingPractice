import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

class PairsWithKDiff {
    public static void main(String[] args) {
        test(new int[] { 1, 7, 5, 9, 2, 12, 3, -1 }, 2);
    }

    static void test(int[] nums, int k) {
        List<Integer[]> ans = getKDiffPairs(nums, k);
        System.out.println("Input=" + Arrays.toString(nums));
        System.out.print("Pairs of " + k + "-difference=");
        for (Integer[] a : ans) {
            System.out.print(Arrays.toString(a) + " ");
        }
    }

    static List<Integer[]> getKDiffPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array has less than 2 elements.");
        }

        HashSet<Integer> set = new HashSet<>();
        List<Integer[]> pairs = new LinkedList<>();
        HashSet<Integer> dupes = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (dupes.add(num)) {
                if (set.contains(num - k) && !dupes.contains(num - k)) {
                    pairs.add(new Integer[] { num, num - k });
                }
                if (set.contains(num + k) && !dupes.contains(num + k)) {
                    pairs.add(new Integer[] { num + k, num });
                }
            }
        }

        return pairs;
    }
}