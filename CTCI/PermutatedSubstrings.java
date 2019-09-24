import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.SourceDataLine;

public class PermutatedSubstrings {
    public static void main(String[] args) {
        printPermutatedSubstrings("abbc", "cbabadcbbabbcbabaabccbabc");
    }

    static void printPermutatedSubstrings(String s, String b) {
        // sliding window
        // map1 - count chars in s
        // map2 - count chars in each sliding window
        // skip chars of b not in s

        if (s == null || b == null || s.length() > b.length()) {
            return;
        }

        Map<Character, Integer> sCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int count = sCount.getOrDefault(s.charAt(i), 0) + 1;
            sCount.put(s.charAt(i), count);
        }

        Map<Character, Integer> bCount;

        for (int i = 0; i < b.length(); i++) {
            if (!sCount.containsKey(b.charAt(i))) {
                continue;
            }

            bCount = new HashMap<>();

            for (int j = 0; j < s.length() && i + j < b.length(); j++) {
                char cur = b.charAt(i + j);
                if (!sCount.containsKey(cur)) {
                    i = i + j + 1;
                    break;
                }
                bCount.put(cur, bCount.getOrDefault(cur, 0) + 1);
            }

            boolean allMatch = true;
            for (char cur : sCount.keySet()) {
                if (sCount.get(cur) != bCount.getOrDefault(cur, 0)) {
                    allMatch = false;
                    break;
                }
            }

            if (allMatch) {
                System.out.printf("Found permutation of s in b[%d:%d]: %s\n", i, i + s.length() - 1,
                        b.substring(i, i + s.length()));
            }
        }
    }
}