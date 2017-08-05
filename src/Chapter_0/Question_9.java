package Chapter_0;

/**
 * Write a function to check if the value of a binary number (passed as a string)
 * equals the hexadecimal representation of a string.
 */
public class Question_9 {
    public static void main(String[] args) {
        String binary = "1010";
        String hex = "A";
        System.out.println(compareBinToHex(binary, hex));
    }

    private static boolean compareBinToHex(String binary, String hex) {
        int n1 = convertToBase10(binary, 2);
        int n2 = convertToBase10(hex, 16);

        return (n1 == n2);
    }

    private static int convertToBase10(String num, int base) {
        // Check for valid inputs
        if (base < 2 || (base > 10 && base != 16))
            return -1;

        // Iterate backwards through the digits of the number and convert it to base 10
        // Uses the formula: base10num = digit * (base ^ (numLen - i - 1))
        int decimalVal = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(num.substring(i, i + 1), base);
            // Check for invalid digits
            if (digit < 0 || digit >= base)
                return -1;
            int exp = (num.length() - i) - 1;
            decimalVal += digit * (int) Math.pow(base, exp);
        }

        return decimalVal;
    }
}
