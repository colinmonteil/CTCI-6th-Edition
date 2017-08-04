package Chapter_0;

import java.util.*;

/**
 * Given an array of distinct integer values, count the number of pairs of integers that
 * have difference k. For example, given the array {1, 7, 5, 9, 2, 12, 3} and the difference
 * k = 2, there are three pairs with difference 2: (1,3), (3,5), (7,9).
 */
public class Question_1 {
    public static void main(String[] args) {
        int[] input = {1,7,5,9,2,12,3};
        int k = 2;
        int pairCount = getUniquePairCount(input, k);
        System.out.println("There are " + pairCount + " unique pairs with difference " + k);
    }

    public static int getUniquePairCount(int[] input, int k) {
        // Create a set for the elements of the input array
        Set<Integer> inputSet = new HashSet<>();
        for (int elem : input)
            inputSet.add(elem);

        // For each element, check if the set contains members that are elem-k or elem+k
        int pairCount = 0;
        for (int elem : input) {
            if (inputSet.contains(elem - k)) {
                pairCount++;
                System.out.println(elem + " & " + (elem - k));
            }
            if (inputSet.contains(elem + k)) {
                pairCount++;
                System.out.println(elem + " & " + (elem + k));
            }
            // Don't include identical pairs
            inputSet.remove(elem);
        }

        return pairCount;
    }

}
