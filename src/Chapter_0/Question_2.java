package Chapter_0;

import java.util.*;

/**
 * Print all positive integer solutions to the equation a^3 + b^3 = c^3 + d^3 where a,b,c,
 * and d are less than 1000. You should only print the non-trivial solutions. A solution is considered
 * to be trivial if it is in the form x^3 + y^3 = x^3 + y^3 (the same values on the left and right
 * side) or if it is a permutation of another equivalent solution (e.g. 22^3 + 986^3 = 180^3 + 984^3
 * can be represented eight different ways by just rearranging the elements, but you should only print one
 * of those).
 */
public class Question_2 {
    public static void main(String[] args) {
        int n = 1000;
        printSolutions(n);
    }

    public static class Pair {
        private int digitA;
        private int digitB;
        Pair(int A, int B) {
            digitA = A;
            digitB = B;
        }

        @Override
        public String toString() {
            return "(" + digitA + ", " + digitB + ")";
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            // Pairs are equal if they contain the same numbers
            if (digitA == pair.digitB && digitB == pair.digitA)
                return true;

            if (digitA != pair.digitA)
                return false;
            return digitB == pair.digitB;
        }
        @Override
        public int hashCode() {
            int result = digitA;
            result = 31 * result + digitB;
            return result;
        }
    }

    private static void printSolutions(int n) {
        // Check for valid inputs
        if (n < 1)
            return;

        // Create map where:
        //      Each key is the sum of the digits of a pair
        //      Each value is a list of Pair objects
        // Note that the inner loop begins with b = a which eliminates pairs that have equal but switched values
        // This takes care of trivial case 1, same values on both sides of the equation
        Map<Integer,List<Pair>> sumMap = new HashMap<>();
        for (int a = 0; a < n; a++) {
            for (int b = a; b < n; b++) {
                int sum = (int) (Math.pow(a, 3) + Math.pow(b, 3));
                if (sumMap.containsKey(sum))
                    sumMap.get(sum).add(new Pair(a, b));
                else {
                    sumMap.put(sum, new ArrayList<>());
                    sumMap.get(sum).add(new Pair(a, b));
                }
            }
        }

        // Now that we have all possible pairs, generate all non-trivial pairs
        // Note that the j loop starts at element i + 1
        // This takes care of trivial case 2, no permutations of equivalent solutions
        int pairCount = 0;
        for (int sum : sumMap.keySet()) {
            int sumListSize = sumMap.get(sum).size();
            for (int i = 0; i < sumListSize; i++) {
                Pair pairA = sumMap.get(sum).get(i);
                for (int j = i + 1; j < sumListSize; j++) {
                    Pair pairB = sumMap.get(sum).get(j);
                    System.out.println(pairA + ", " + pairB);
                    pairCount++;
                }
            }
        }

        System.out.println("\nThere are " + pairCount + " non-trivial solutions when n = " + n);
    }
}
