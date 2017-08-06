package Chapter_0;

/**
 * Check if an NxN tic-tac-toe board has a winner.
 *
 * Use any uppercase characters to represent marks.
 * Use ' ' to represent an empty space.
 */
public class Question_11 {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'O', ' '},
                {' ', 'X', 'O'},
                {' ', 'O', 'X'}
        };

        printBoard(board);
        hasWinner(board);
    }

    // Time: O(N^2) Space: O(1)
    private static boolean hasWinner(char[][] board) {
        // Check inputs
        final int N = board.length;
        final char EMPTY = ' ';
        if (N == 0 || board[0].length != N || (N == 1 && board[0][0] == EMPTY))
            return false;

        // Keep track of diagonal statuses
        // Can't be wins if they start with a space
        char topLeftChar = board[0][0];
        char topRightChar = board[0][N - 1];
        boolean topLeftIsWin = (topLeftChar != EMPTY);
        boolean topRightIsWin = (topRightChar != EMPTY);

        // The first row of the board will keep track of if the columns are wins
        // The non-empty characters will become lowercase if the column is not a win
        for (int row = 1; row < N; row++) {
            // Check that this row is the expected length
            if (board[row].length != N)
                return false;

            // Keep track of this row's status
            // Can't be a win if it starts with a space
            char firstCharInRow = board[row][0];
            boolean rowIsWin = (firstCharInRow != EMPTY);

            for (int col = 0; col < N; col++) {
                char firstCharInCol = board[0][col];
                char currChar = board[row][col];

                // Update row status
                if (rowIsWin && currChar != firstCharInRow)
                    rowIsWin = false;

                // Update the first row's marker character if needed
                if (firstCharInCol != EMPTY && !Character.isLowerCase(firstCharInCol) && firstCharInCol != currChar)
                    board[0][col] = Character.toLowerCase(firstCharInCol);

                // Update diagonal statuses
                if (topLeftIsWin && row == col && currChar != topLeftChar)
                    topLeftIsWin = false;
                if (topRightIsWin && col == ((N - 1) - row) && currChar != topRightChar)
                    topRightIsWin = false;
            }

            // Check if this row was a win
            if (rowIsWin) {
                System.out.println("Winner on row " + row);
                restoreBoard(board);
                return true;
            }
        }

        // Check if any column was a win
        for (int col = 0; col < N; col++) {
            if (board[0][col] != EMPTY && Character.isUpperCase(board[0][col])) {
                System.out.println("Winner on column " + col);
                restoreBoard(board);
                return true;
            }
        }

        // Check if either diagonal was a win
        if (topLeftIsWin || topRightIsWin) {
            System.out.println("Winner on diagonal");
            restoreBoard(board);
            return true;
        }

        System.out.println("No winner");
        return false;
    }

    private static void restoreBoard(char[][] board) {
        // Change first row markers back to their original characters
        for (int col = 0; col < board[0].length; col++) {
            char currChar = board[0][col];
            if (currChar != ' ' && Character.isLowerCase(currChar))
                board[0][col] = Character.toUpperCase(currChar);
        }
    }

    private static void printBoard(char[][] board) {
        final int N = board.length;
        for (char[] aBoard : board) {
            if (aBoard.length != N) {
                System.out.println("INVALID BOARD DIMENSIONS!");
                return;
            }
            for (int col = 0; col < N; col++)
                System.out.print(aBoard[col] + " ");
            System.out.println();
        }
    }
}
