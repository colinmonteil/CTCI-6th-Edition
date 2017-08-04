package Chapter_0;

import java.util.*;

/**
 * Given a smaller string s and a bigger string b, design an algorithm to find all permuta-
 * tions of the shorter string within the larger one. Print the location of each permutation.
 */
public class Question_3 {
    public static void main(String[] args) {
        String s = "abbc";
        String b = "cbabadcbbabbcbabaabccbabc";
        printPermPositions(s, b);
    }

    // O(B * S)
    private static void printPermPositions(String small, String large) {
        Map<Character,Integer> smallFreqMap = getCharFreqMap(small.toCharArray());

        for (int i = 0; i < large.length(); i++) {
            int numCorrect = 0;
            for (int j = i; j < i + small.length() && j < large.length(); j++) {
                char currChar = large.charAt(j);
                // Check if the current char is a valid find
                if (smallFreqMap.containsKey(currChar) && smallFreqMap.get(currChar) > 0) {
                    smallFreqMap.put(currChar, smallFreqMap.get(currChar) - 1);
                    numCorrect++;
                }
                // If we have all letters in the small string, we've found a match
                if (numCorrect == small.length()) {
                    System.out.print(i + " ");
                    break;
                }
            }
            // Reset frequency map of small string's characters
            smallFreqMap = getCharFreqMap(small.toCharArray());
        }
    }

    private static Map<Character,Integer> getCharFreqMap(char[] chars) {
        Map<Character,Integer> freqMap = new HashMap<>();

        for (char c : chars) {
            if (freqMap.containsKey(c))
                freqMap.put(c, freqMap.get(c) + 1);
            else
                freqMap.put(c, 1);
        }

        return freqMap;
    }
}
