package Chapter_0;

import java.util.Arrays;

/**
 * Swap the minimum and maximum elements of an integer array.
 */
public class Question_10 {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 2, 11};
        System.out.println("Before swap: " + Arrays.toString(array));
        swapMinMax(array);
        System.out.println("After swap: " + Arrays.toString(array));
    }

    private static void swapMinMax(int[] array) {
        int minIdx = getMinIndex(array);
        int maxIdx = getMaxIndex(array);

        int temp = array[minIdx];
        array[minIdx] = array[maxIdx];
        array[maxIdx] = temp;
    }

    private static int getMinIndex(int[] array) {
        int minIdx = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIdx])
                minIdx = i;
        }

        return minIdx;
    }

    private static int getMaxIndex(int[] array) {
        int maxIdx = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIdx])
                maxIdx = i;
        }

        return maxIdx;
    }
}
