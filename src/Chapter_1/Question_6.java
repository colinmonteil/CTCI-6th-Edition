package Chapter_1;

/**
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a-z).
 */
public class Question_6 {
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println("\"" + input + "\" compressed is: \"" + compress(input) + "\"");
    }

    // Time: O(N) Space: O(N)
    private static String compress(String input) {
        // Check if compression produces a strictly smaller string
        int sizeDiff = compressedSizeDiff(input);
        if (sizeDiff >= 0) {
            System.out.println("COMPRESSED STRING WOULD NOT BE SMALLER THAN ORIGINAL");
            return input;
        }

        // Create the compressed string
        StringBuilder sb = new StringBuilder(input.length() + sizeDiff);
        char savedChar = input.charAt(0);
        int savedCharCount = 1;

        for (int i = 1; i < input.length(); i++) {
            char currChar = input.charAt(i);

            if (currChar == savedChar)
                savedCharCount++;
            else {
                sb.append(savedChar);
                sb.append(savedCharCount);
                savedChar = currChar;
                savedCharCount = 1;
            }

            // Write the final character and its count to the StringBuilder
            if (i == input.length() - 1) {
                sb.append(savedChar);
                sb.append(savedCharCount);
            }
        }

        return sb.toString();
    }

    // Time: O(N) Space: O(1)
    private static int compressedSizeDiff(String input) {
        char savedChar = input.charAt(0);
        int sizeDiff = 1;

        for (int i = 1; i < input.length(); i++) {
            char currChar = input.charAt(i);
            if (currChar == savedChar)
                sizeDiff--;
            else {
                sizeDiff++;
                savedChar = currChar;
            }
        }

        return sizeDiff;
    }
}
