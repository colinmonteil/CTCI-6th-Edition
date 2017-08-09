package Chapter_1;

/**
 * Zero Matrix: Write an algorithm such that is an element in an MxN matrix is 0, its entire row and
 * column are set to 0.
 */
public class Question_8 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 0, 5},
                {1, 2, 3, 4, 5},
                {0, 2, 0, 4, 5},
                {1, 2, 0, 4, 5},
                {1, 2, 3, 4, 5},
                {0, 2, 3, 4, 5}
        };

        setZeros(matrix);
        printMatrix(matrix);
    }

    // Time: O(M * N) Space: O(1)
    private static void setZeros(int[][] matrix) {
        final int M = matrix.length;
        final int N = matrix[0].length;

        // Nothing to do if matrix is 1x1 or smaller
        if (M <= 1 && N <= 1)
            return;

        // Search first row and first column for zeros
        boolean firstRowHadZero = false;
        boolean firstColHadZero = false;
        for (int elem : matrix[0]) {
            if (elem == 0)
                firstRowHadZero = true;
        }
        for (int[] row : matrix) {
            if (row[0] == 0)
                firstColHadZero = true;
        }

        // Search remainder of matrix for zeros
        // Use the first row and column to mark rows and columns for deletion
        for (int row = 1; row < M; row++) {
            for (int col = 1; col < N; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        // Zero out rows and columns marked for deletion
        for (int row = 1; row < M; row++) {
            if (matrix[row][0] == 0)
                for (int col = 1; col < N; col++)
                    matrix[row][col] = 0;
        }
        for (int col = 1; col < N; col++) {
            if (matrix[0][col] == 0)
                for (int row = 1; row < M; row++)
                    matrix[row][col] = 0;
        }

        // Zero out first row and column if needed
        if (firstRowHadZero) {
            for (int col = 0; col < N; col++)
                matrix[0][col] = 0;
        }
        if (firstColHadZero) {
            for (int row = 0; row < M; row++)
                matrix[row][0] = 0;
        }
    }

    private static void printMatrix(int[][] imageMatrix) {
        for (int[] row : imageMatrix) {
            for (int elem : row)
                System.out.print(elem + "\t");
            System.out.println();
        }
    }
}
