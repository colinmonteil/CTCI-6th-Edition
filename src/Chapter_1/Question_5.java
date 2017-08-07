package Chapter_1;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 *
 * EXAMPLE:
 *  pale,   ple     -> true
 *  pales,  pale    -> true
 *  pale,   bale    -> true
 *  pale,   bake    -> false
 */
public class Question_5 {
    public static void main(String[] args) {
        String inputA = "pale";
        String inputB = "ple";
        System.out.println("\"" + inputA + "\" and \"" + inputB + "\" are one edit away: " + oneEditAway(inputA, inputB));
    }

    // Time: O(N) Space: O(1)
    private static boolean oneEditAway(String inputA, String inputB) {
        // Check inputs
        if (Math.abs(inputA.length() - inputB.length()) > 1)
            return false;

        int idxA = 0;
        int idxB = 0;
        int lenA = inputA.length();
        int lenB = inputB.length();
        boolean differed = false;

        // Compare the characters of the two strings in order and check if they differ more then once
        while (idxA < lenA && idxB < lenB) {
            if (inputA.charAt(idxA) != inputB.charAt(idxB)) {
                if (differed)
                    return false;
                differed = true;

                // Handles insertion and removal cases
                if (lenA > lenB)
                    idxA++;
                else if (lenA < lenB)
                    idxB++;
                // Handles replacement case
                else {
                    idxA++;
                    idxB++;
                }
            }
            else {
                idxA++;
                idxB++;
            }
        }

        return true;
    }
}
