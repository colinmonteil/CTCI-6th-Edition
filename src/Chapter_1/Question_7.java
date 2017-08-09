package Chapter_1;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class Question_7 {
    public enum ROT_DIRECTION {
        CLOCKWISE, COUNTER_CLOCKWISE
    }

    public static void main(String[] args) {
        int[][] imageMatrix = {
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        rotate(imageMatrix, ROT_DIRECTION.CLOCKWISE);
        printMatrix(imageMatrix);
    }

    // Time: O(N^2) Space: O(1)
    private static void rotate(int[][] matrix, ROT_DIRECTION dir) {
        final int N = matrix.length;
        if (N == 1)
            return;

        for (int layer = 0; layer < N / 2; layer++) {
            int layerMaxIdx = (N - 1) - layer;

            for (int elemIdx = layer; elemIdx < layerMaxIdx; elemIdx++) {
                /*  Save the values of each of the four working elements (can also be done with saving only 1)
                    The notation I'm using is based on an alphabetical 4x4 matrix:
                    A B C D
                    E F G H
                    I J K L
                    M N O P
                */
                int a = matrix[layer][elemIdx];
                int d = matrix[elemIdx][layerMaxIdx];
                int p = matrix[layerMaxIdx][(layerMaxIdx - elemIdx) + layer];
                int m = matrix[(layerMaxIdx - elemIdx) + layer][layer];

                // Replace the old values with the new based on rotation direction
                if (dir == ROT_DIRECTION.CLOCKWISE) {
                    // A->D, D->P, P->M, M->A
                    matrix[elemIdx][layerMaxIdx] = a;
                    matrix[layerMaxIdx][(layerMaxIdx - elemIdx) + layer] = d;
                    matrix[(layerMaxIdx - elemIdx) + layer][layer] = p;
                    matrix[layer][elemIdx] = m;
                }
                else if (dir == ROT_DIRECTION.COUNTER_CLOCKWISE) {
                    // A->M, D->A, P->D, M->P
                    matrix[(layerMaxIdx - elemIdx) + layer][layer] = a;
                    matrix[layer][elemIdx] = d;
                    matrix[elemIdx][layerMaxIdx] = p;
                    matrix[layerMaxIdx][(layerMaxIdx - elemIdx) + layer] = m;
                }
            }

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
