package Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class will contain helper functions
 */
public class CTCI_6th_Edition {
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
