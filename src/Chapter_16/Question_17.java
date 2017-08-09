package Chapter_16;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Contiguous Sequence: You are given an array of integers (both positive and negative). Find the
 * contiguous sequence with the largest sum, return the sum.
 *
 * EXAMPLE:
 *  Input:  2, -8, 3, -2, 4, -10
 *  Output: 5 (i.e., {3, -2, 4})
 */
public class Question_17 {
    public static void main(String[] args) {
        int[] sequence = {2, -8, 3, -2, 4, -10};

        System.out.println("The max contiguous sum of " + Arrays.toString(sequence) + " is " + getMaxSum(sequence));
    }

    // Time: O(N) Space: O(N)
    private static int getMaxSum(int[] sequence) {
        if (sequence.length == 1)
            return sequence[0];

        // First condense the sequence by grouping streaks of positives and negatives
        // Ex. [2, -8, -3, 2, 4, -10] becomes [2, -11, 6, -10]
        // The idea is that we never want just a part of either a negative or positive streak, so condensing them is OK
        sequence = condense(sequence);

        // Then iterate through the condensed sequence
        // Update sum when adding the current element to it doesn't make it negative
        // Update maxSum when sum is larger than maxSum's current value
        // NOTE: If the sequence is all negative values, 0 is returned
        int currSum = 0;
        int maxSum = 0;
        for (int elem : sequence) {
            currSum += elem;
            if (currSum > maxSum)
                maxSum = currSum;
            else if (currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }

    private static int[] condense(int[] sequence) {
        ArrayList<Integer> condensed = new ArrayList<>();
        condensed.add(sequence[0]);
        boolean isPositive = sequence[0] > 0;
        int condensedIdx = 0;

        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] < 0 && isPositive) {
                isPositive = false;
                condensed.add(sequence[i]);
                condensedIdx++;
            }
            else if (sequence[i] > 0 && !isPositive) {
                isPositive = true;
                condensed.add(sequence[i]);
                condensedIdx++;
            }
            else
                condensed.set(condensedIdx, condensed.get(condensedIdx) + sequence[i]);
        }

        int[] condensedFinal = new int[condensed.size()];
        for (int i = 0; i < condensed.size(); i++)
            condensedFinal[i] = condensed.get(i);

        return condensedFinal;
    }
}
