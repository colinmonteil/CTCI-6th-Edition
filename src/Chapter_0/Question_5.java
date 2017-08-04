package Chapter_0;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to print all permutations of a string. For simplicity, assume all char-
 * acters are unique.
 */
public class Question_5 {
    public static void main(String[] args) {
        String test = "abcdefg";
        printStringPerms(test);
    }

    // Helper function to print permutations
    private static void printStringPerms(String inputString) {
        List<String> perms = getStringPerms(inputString);
        System.out.println(perms);
        System.out.println("There are " + perms.size() + " permutations of " + inputString);
    }

    private static List<String> getStringPerms(String inputString) {
        // There is only one permutation of a string of length 1
        if (inputString.length() == 1) {
            List<String> perm = new ArrayList<>();
            perm.add(inputString);
            return  perm;
        }

        // Cut first letter off string
        char first = inputString.charAt(0);
        StringBuilder sb = new StringBuilder(inputString.substring(1));

        // Get permutations of rest of string
        List<String> perms = getStringPerms(sb.toString());

        // Place first letter in all positions of all perms
        List<String> allPerms = new ArrayList<>();
        for (String perm : perms) {
            for (int i = 0; i <= perm.length(); i++) {
                sb.insert(i, first);
                allPerms.add(sb.toString());
                sb.deleteCharAt(i);
            }
        }

        return allPerms;
    }
}
