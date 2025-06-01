package backTracking;
import java.util.ArrayList;

public class ValidSudoku {
	
	private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) { // Find an empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Place the number
                            if (solveSudoku(board)) { // Recursively solve the rest
                                return true;
                            }
                            board[row][col] = 0; // Undo the placement
                        }
                    }
                    return false; // No valid number can be placed in this cell
                }
            }
        }
        return true; // All cells are filled correctly
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true; // It's valid to place the number
    }
	
	public static boolean isItSudoku(int[][] matrix)
	{
		return solveSudoku(matrix);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
