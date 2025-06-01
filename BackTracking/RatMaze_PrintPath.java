package backTracking;

public class RatMaze_PrintPath {
	
	public static boolean ratInAMaze2(int maze[][])
	{
		int n = maze.length;
		int path[][] = new int[n][n];
		return solveMaze2(maze,0,0,path);
	}
	
	public static boolean solveMaze2(int[][] maze,int i,int j,int[][] path)
	{
		// Check is i,j cell is valid or not
		int n = maze.length;
		if (i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1)
		{
			return false;
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
			
			return true;
		}
		
		// Explore Further in all Directions
		
		if (solveMaze2(maze,i-1,j,path))  // Top
		{
			return true;
		}
		if (solveMaze2(maze,i,j+1,path))  // Right
		{
			return true;
		}
		if (solveMaze2(maze,i+1,j,path))  // Down
		{
			return true;
		}
		if (solveMaze2(maze,i,j-1,path))  // Left
		{
			return true;
		}
		
		return false;
			
	}

	public static void main(String[] args) {
		
		int maze[][] = {{1,1,0},{1,1,0},{1,1,1}};
		boolean pathPossible = ratInAMaze2(maze);
		System.out.println(pathPossible);

	}

}
