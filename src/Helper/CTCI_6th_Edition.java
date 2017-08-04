package Helper;

import java.util.HashMap;
import java.util.Map;

/**
 * This class will contain helper functions
 */
public class CTCI_6th_Edition {
    public static <K> Map<K,Integer> getFreqMap(K[] input) {
        Map<K, Integer> freqMap = new HashMap<>();

        for (K elem : input) {
            if (freqMap.containsKey(elem))
                freqMap.put(elem, freqMap.get(elem) + 1);
            else
                freqMap.put(elem, 1);
        }

        return freqMap;
    }
}
