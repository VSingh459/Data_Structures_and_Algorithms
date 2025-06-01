package backTracking;

public class ratMaze_AllPaths {
	
	
	
	public static void ratInAMaze3(int maze[][])
	{
		int n = maze.length;
		int path[][] = new int[n][n];
		printAllPaths(maze,0,0,path);
	}
	
	
	public static void printAllPaths(int[][] maze,int i,int j,int[][] path)
	{
		// Check is i,j cell is valid or not
		int n = maze.length;
		if (i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1)
		{
			return;
		}
		
		path[i][j] = 1;
		
		// If we reach destination cell
		if (i==n-1 && j==n-1)
		{
			for (int r=0;r<n;r++)
			{
				for (int c=0;c<n;c++)
				{
					System.out.print(path[r][c]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			path[i][j] = 0;
			return;
		}
		
		// Explore Further in all Directions
		
		printAllPaths(maze,i-1,j,path);  // Top
		
			
		printAllPaths(maze,i,j+1,path); // Right
		
			
		printAllPaths(maze,i+1,j,path); // Down
		
		printAllPaths(maze,i,j-1,path); // Left
		
		path[i][j] = 0;
		
		
		
			
	}

	public static void main(String[] args) {
		
		int maze[][] = {{1,1,0},{1,1,0},{1,1,1}};
		  //int maze[][] = {{1,1},{1,1}};
		 ratInAMaze3(maze);
		//System.out.println(pathPossible);

	}

}
