package Chapter_1;

import Helper.CTCI_6th_Edition;

import java.util.Map;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
 * other.
 *
 * Assume that the comparison is case-sensitive and whitespace is significant.
 */
public class Question_2 {
    public static void main(String[] args) {
        String inputA = "Coding";
        String inputB = "doCing";
        System.out.println("\"" + inputA + "\" and \"" + inputB + "\" are permutations of each other: "
                + permutation(inputA, inputB));
    }

    // Time: O(N) Space: O(N)
    // Create a frequency map for the characters in both strings
    private static boolean permutation(String inputA, String inputB) {
        if (inputA.length() != inputB.length())
            return false;

        // Find out if both strings have the same character frequencies
        Map<Character,Integer> freqMapA = CTCI_6th_Edition.getCharFreqMap(inputA.toCharArray());
        for (int i = 0; i < inputA.length(); i++) {
            char currChar = inputB.charAt(i);
            if (freqMapA.containsKey(currChar) && freqMapA.get(currChar) > 0)
                freqMapA.put(currChar, freqMapA.get(currChar) - 1);
            else
                return false;
        }

        return true;
    }
}
