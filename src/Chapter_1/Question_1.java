package Chapter_1;

import java.util.HashSet;
import java.util.Set;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 */
public class Question_1 {
    public static void main(String[] args) {
        String input = "laakmann";
        System.out.println("\"" + input + "\" contains all unique characters: " + isUniqueChars1(input));
    }

    // Time: O(N) Space: O(N)
    // Case 1: additional data structures are allowed
    private static boolean isUniqueChars1(String input) {
        if (input.length() == 1)
            return true;

        // Add each character in the string to a set
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            // Check that you haven't already added the current character to the set
            if (characterSet.contains(currChar))
                return false;
            characterSet.add(currChar);
        }

        return true;
    }

    // Time: O(N^2) Space: O(1)
    // Case 2: Additional data structures are not allowed
    private static boolean isUniqueChars2(String input) {
        if (input.length() == 1)
            return true;

        // Compare every character in the string to every other to find duplicates
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j))
                    return false;
            }
        }

        return true;
    }
}
