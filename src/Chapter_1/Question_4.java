package Chapter_1;

import Helper.CTCI_6th_Edition;

import java.util.Map;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin-
 * drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 *
 * EXAMPLE:
 *  Input:  Tact Coa
 *  Output: True (permutations: "taco cat", "atco cta", etc.)
 *
 *  ASSUMPTIONS:
 *   - Ignores case
 *   - Ignores whitespace
 */
public class Question_4 {
    public static void main(String[] args) {
        String phrase = "Tact Coa";
        System.out.println("\"" + phrase + "\" is a permutation of a palindrome: " + isPermutationOfPalindrome(phrase));
    }

    private static boolean isPermutationOfPalindrome(String phrase) {
        // Remove whitespace from input and make all characters lowercase
        phrase = phrase.replaceAll("\\s+", "").toLowerCase();

        // If the input is 1 or fewer characters, it is a palindrome
        if (phrase.length() <= 1)
            return true;

        // Create character frequency map for input
        Map<Character, Integer> phraseFreqMap = CTCI_6th_Edition.getStringFreqMap(phrase);

        // Check if more then one character appears an odd number of times
        boolean multipleOdds = false;
        for (char c : phraseFreqMap.keySet()) {
            if (phraseFreqMap.get(c) % 2 != 0) {
                if (multipleOdds)
                    return false;
                multipleOdds = true;
            }
        }

        return true;
    }
}
