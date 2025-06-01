package backTracking;

public class WordSearch {
	
	public static boolean present(char[][] grid,String word,int n,int m)
	{
		int[][] visited = new int[n][m];
		
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				if (grid[i][j] == word.charAt(0))
				{
					visited[i][j] = 1;
					if(search2(grid,word,visited,1,i,j,n,m))
					{
						return true;
					}
					visited[i][j] = 0;
					
				}
			}
		}
		return false;
		
	}
	
	static int row[] = {0,0,-1,+1};
	static int col[] = {+1,-1,0,0};
	
	private static boolean search2(char[][] grid,String word,int[][] visited,int currIndex,int i,int j,int n,int m)
	{
		if (currIndex == word.length())
		{
			return true;
		}
		
		visited[i][j] = 1;
		
		
		
		
		for (int move=0;move < 4;move++)
		{
			int nextRow = i+row[move];
			int nextCol = j+col[move];
			if (nextRow >= 0 && nextRow < n && nextCol >=0 && nextCol < m && visited[nextRow][nextCol]==0 
					 && grid[nextRow][nextCol] == word.charAt(currIndex))
			{
				visited[nextRow][nextCol] = 1;
				if (search2(grid,word,visited,currIndex+1,nextRow,nextCol,n,m))
				{
					return true;
				}
				
			}
			
			
		}
		
		
		return false;
	}
	
	private static boolean search(char[][] grid,String word,int[][] visited,int currIndex,int i,int j,int n,int m)
	{
		if (currIndex == word.length())
		{
			return true;
		}
		
		visited[i][j] = 1;
		
		if (j+1 < m && visited[i][j+1]==0 && grid[i][j+1] == word.charAt(currIndex))
		{
			if (search(grid,word,visited,currIndex+1,i,j+1,n,m))
			{
				return true;
			}
		}
		
		if (j-1 >= 0 && visited[i][j-1] == 0 && grid[i][j-1] == word.charAt(currIndex))
		{
			if (search(grid,word,visited,currIndex+1,i,j-1,n,m))
			{
				return true;
			}
		}
		
		if (i+1 < n  && visited[i+1][j] == 0 && grid[i+1][j] == word.charAt(currIndex))
		{
			if (search(grid,word,visited,currIndex+1,i+1,j,n,m))
			{
				return true;
			}
		}
		
		if (i-1 >=0 && visited[i-1][j] == 0 && grid[i-1][j] == word.charAt(currIndex))
		{
			if (search(grid,word,visited,currIndex+1,i-1,j,n,m))
			{
				return true;
			}
		}
		
		visited[i][j] = 0;
		
		return false;	
	}

	public static void main(String[] args) {
		
		char[][] g = {{'a','h','d','b','h'},{'d','e','l','w','o'},{'z','s','l','o','m'},{'j','i','g','n','k'}}; 
		
		boolean ans = present(g,"bb",4,5);
		System.out.println(ans);
		

	}

}

//public class Solution {
//	
//
//    private static boolean dfs(int i,int j,int n,int m,char[][] board,String word,int k)
//	{
//		 if (k == word.length())
//		{
//			return true;
//		}
//		else if  (i< 0 || i==n || j<0 || j==m || board[i][j]=='#' || board[i][j] != word.charAt(k))
//		{
//			return false;
//		}
//		else{
//			char temp = board[i][j];
//			board[i][j] = '#';
//
//			boolean op3 = dfs(i-1,j,n,m,board,word,k+1);
//			boolean op2 = dfs(i,j+1,n,m,board,word,k+1);
//
//			boolean op1 = dfs(i+1,j,n,m,board,word,k+1);
//			
//			
//			boolean op4 = dfs(i,j-1,n,m,board,word,k+1);
//
//			board[i][j] = temp;
//
//			return op1 || op2 || op3 || op4;
//
//		}
//		
//	}
//    public static boolean present(char [][]board, String word, int n, int m) {
//        // Write your code here.
//		
//		for (int i=0;i<n;i++)
//		{
//			for (int j=0;j<m;j++)
//			{
//				if (board[i][j] == word.charAt(0))
//				{
//					if(dfs(i,j,n,m,board,word,0))
//					{
//						return true;
//					}
//					
//				}
//			}
//		}
//		return false;
//    }
//}
