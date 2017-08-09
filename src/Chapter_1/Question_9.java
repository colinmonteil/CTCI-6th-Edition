package Chapter_1;

/**
 * String Rotation: Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring (e.g. "waterbottle" is a rotation of "erbottlewat").
 */
public class Question_9 {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.println("\"" + s1 + "\" is a rotation of \"" + s2 + "\": " + isRotation(s1, s2));
    }

    // Time: O(N) Space: O(N)
    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        // If s2 is a substring of s1 concatenated with itself, then it is a rotation of s1
        String doubledS1 = s1.concat(s1);

        return doubledS1.contains(s2);
    }
}
