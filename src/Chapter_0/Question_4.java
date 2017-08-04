package Chapter_0;

import Helper.CTCI_6th_Edition;

import java.util.Map;

/**
 * A ransom note can be formed by cutting words out of a magazine to form a new
 * sentence. How would you figure out if a ransom note (represented as a string) can be formed
 * from a given magazine (string)?
 */
public class Question_4 {
    public static void main(String[] args) {
        String magazine = "I say come on down to the store and get yourself whatever you want for almost no money";
        String ransomNote = "I want the money";
        System.out.println(isNotePossible(magazine, ransomNote));
    }

    private static boolean isNotePossible(String magazine, String ransomNote) {
        // Collect words from the magazine and ransom note (space seperated)
        String[] magWords = magazine.trim().split("\\s+");
        String[] noteWords = ransomNote.trim().split("\\s+");

        // Create a hash map where:
        //      Keys are words in the magazine
        //      Values are the frequency of the words
        Map<String,Integer> magFreqMap = CTCI_6th_Edition.getFreqMapFromArray(magWords);

        // Go through note words and make sure magazine has a matching word for each
        for (String word : noteWords) {
            if (magFreqMap.containsKey(word) && magFreqMap.get(word) > 0)
                magFreqMap.put(word, magFreqMap.get(word) - 1);
            else
                return false;
        }

        return true;
    }
}
