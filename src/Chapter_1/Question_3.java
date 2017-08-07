package Chapter_1;

import java.util.Arrays;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 *
 * EXAMPLE:
 *  Input:  "Mr John Smith    ", 13
 *  Output: "Mr%20John%20Smith"
 */
public class Question_3 {
    public static void main(String[] args) {
        char[] input = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};
        int realSize = 13;
        replaceSpaces(input, realSize);
        System.out.println(Arrays.toString(input));
    }

    // Time: O(N) Space: O(1)
    private static void replaceSpaces(char[] input, int realSize) {
        // For every space in the 'real' part, we will need 2 additional spaces at the end to make the conversion
        int neededLength = realSize;
        for (int i = 0; i < realSize; i++) {
            if (input[i] == ' ')
                neededLength += 2;
        }

        // Check if input array is large enough for the conversion
        if (input.length < neededLength) {
            System.out.println("INPUT ARRAY IS TOO SMALL TO MAKE CONVERSION");
            return;
        }

        // Iterate backwards through the input array
        // Move non-space characters in the 'real' part to the end and replace 'real' spaces with '%20'
        int realPointer = realSize - 1;
        for (int i = neededLength - 1; i >= 0; i--) {
            char currChar = input[realPointer];
            if (currChar != ' ') {
                input[i] = currChar;
                realPointer--;
            }
            else {
                input[i] = '0';
                input[i - 1] = '2';
                input[i - 2] = '%';
                i -= 2;
                realPointer--;
            }
        }
    }
}
