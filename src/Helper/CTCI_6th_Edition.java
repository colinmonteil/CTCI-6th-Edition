package Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class will contain helper functions
 */
public class CTCI_6th_Edition {
    public static Map<Character,Integer> getCharFreqMap(char[] chars) {
        Map<Character,Integer> freqMap = new HashMap<>();

        for (char c : chars) {
            if (freqMap.containsKey(c))
                freqMap.put(c, freqMap.get(c) + 1);
            else
                freqMap.put(c, 1);
        }

        return freqMap;
    }

    public static Map<Character,Integer> getStringFreqMap(String string) {
        Map<Character,Integer> freqMap = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (freqMap.containsKey(c))
                freqMap.put(c, freqMap.get(c) + 1);
            else
                freqMap.put(c, 1);
        }

        return freqMap;
    }

    public static <K> Map<K,Integer> getFreqMapFromArray(K[] input) {
        Map<K, Integer> freqMap = new HashMap<>();

        for (K elem : input) {
            if (freqMap.containsKey(elem))
                freqMap.put(elem, freqMap.get(elem) + 1);
            else
                freqMap.put(elem, 1);
        }

        return freqMap;
    }

    public static <T> Map<T, Integer> getFreqMapFromList(List<T> input) {
        Map<T, Integer> freqMap = new HashMap<>();

        for (T elem : input) {
            if (freqMap.containsKey(elem))
                freqMap.put(elem, freqMap.get(elem) + 1);
            else
                freqMap.put(elem, 1);
        }

        return freqMap;
    }
}
