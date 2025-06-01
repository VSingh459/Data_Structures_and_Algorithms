package backTracking;

public class N_Queens {
	
	public static void placeNQueeens(int n)
	{
		int[][] board = new int[n][n];
		placeQueens(board,n,0);
		
	}
	
	private static void placeQueens(int[][] board,int n, int row)
	{
		if (row == n)
		{
			printBoard(board,n);
			System.out.println();
			return;
		}
		
		for (int j=0;j<n;j++)
		{
			if (isBoardSafe(board,n,row,j))
			{
				board[row][j] = 1;
				placeQueens(board,n,row+1);
				board[row][j] = 0;
				
			}
		}
	}
	
	private static boolean isBoardSafe(int[][] board,int n,int row,int col)
	{
		for (int i=row-1;i>=0;i--) // Vertical Check
		{
			if (board[i][col]==1)
				return false;
		}
		
		for (int i=row-1, j=col-1;i>=0 && j>=0; i--,j-- )
		{
			if (board[i][j]==1)
			{
				return false;
			}
		}
		
		for (int i=row-1, j=col+1;i>=0 && j<n; i--,j++ )
		{
			if (board[i][j]==1)
			{
				return false;
			}
		}
		
		return true;
	}
	
	private static void printBoard(int[][] board,int n)
	{
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		
		placeNQueeens(4);
		
		
		
		

	}

}
