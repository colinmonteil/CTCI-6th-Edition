package Chapter_0;

/**
 * Given two sorted arrays, find the number of elements in common. The arrays are the same length
 * and each has all distinct elements.
 */
public class Question_7 {
    public static void main(String[] args) {
        int[] arrayA = {13, 27, 35, 40, 49, 55, 59};
        int[] arrayB = {17, 35, 39, 40, 55, 58, 60};
        System.out.println("\nThey have " + numElemsInCommon(arrayA, arrayB) + " elements in common");
    }

    private static int numElemsInCommon(int[] arrayA, int[] arrayB) {
        int elemsInCommon = 0;
        int arrayLen = arrayA.length;

        // Since the arrays are sorted, we can do a linear search in O(N) time with O(1) space
        int elemAIdx = 0;
        int elemBIdx = 0;
        while (elemAIdx < arrayLen && elemBIdx < arrayLen) {
            if (arrayA[elemAIdx] == arrayB[elemBIdx]) {
                elemsInCommon++;
                System.out.print(arrayA[elemAIdx] + " ");
                elemAIdx++;
                elemBIdx++;
            }
            else if (arrayA[elemAIdx] < arrayB[elemBIdx])
                elemAIdx++;
            else
                elemBIdx++;
        }

        return elemsInCommon;
    }
}
