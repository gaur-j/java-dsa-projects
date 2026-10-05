package dsa_project;

import java.util.*;

public class Text_toolkit {
    static String toArrStr(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        int i = 0, j = s.length() - 1;

        String copyStr = s.toLowerCase();
        boolean found = true;

        while (i < j) {
            if (copyStr.charAt(i) != copyStr.charAt(j)) {
                return ("The given String '%s' not Palindrome %b".formatted(s, !found));
            }
            i++;
            j--;
        }
        return ("The given String '%s' is a Palindrome %b".formatted(s, found));
    }

    public static void main(String[] args) {
        String s = "baddbc";
        System.out.println(toArrStr(s) + "\n" + longestSubString(s));
    }

    static String longestSubString(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;

        s = s.replaceAll("[^a-zA-Z0-9]", "");
        boolean found = true;

        String copyStr = s.toLowerCase();
        int maxSize = 0;

        while (j < copyStr.length()) {
            while (set.contains(copyStr.charAt(j))) {
                set.remove(copyStr.charAt(i));
                i++;
            }

            set.add(copyStr.charAt(j));
            maxSize = Math.max(maxSize, set.size());
            j++;
        }

        return ("the longest subStr for: %s, %b, maxSize: %d".formatted(set, found, maxSize));
    }
}
