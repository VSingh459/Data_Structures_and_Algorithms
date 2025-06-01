package assignments;
import java.util.Scanner;
import java.util.ArrayList;

public class CodingNinjas {
	
	private static final String TARGET = "CODINGNINJA";
    private static final int[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
	
	
	
	 public static int solve(String[] Graph,int N,int M)
	{
		char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = Graph[i].toCharArray();
        }
        
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == TARGET.charAt(0)) {
                    if (dfs(grid, visited, i, j, 0, N, M)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
	}
	
	private static boolean dfs(char[][] grid, boolean[][] visited, int x, int y, int index, int N, int M) {
        if (index == TARGET.length()) {
            return true;
        }
        if (x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || grid[x][y] != TARGET.charAt(index)) {
            return false;
        }
        
        visited[x][y] = true;
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (dfs(grid, visited, newX, newY, index + 1, N, M)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
	

	public static void main(String[] args) {
		
//		System.out.println("Enter the rows and columns of Matrix");
//		Scanner obj = new Scanner(System.in);
//		int n = obj.nextInt();
//		Scanner obj2 = new Scanner(System.in);
//		int m = obj2.nextInt();
//		
//		char[][] c = new char[n][m];
//		String s = new String();
//		obj.nextLine();
//		
//		for (int i=0;i<n;i++)
//		{
//			s = obj.nextLine();
//			for (int j=0;j<m;j++)
//			{
//				c[i][j] = s.charAt(j);
//			}
//		}
		
		String[] str = {"DANDO","NNINJ","AXGJC","INJAA","CODDI"};
		int ans = solve(str,5,5);
		System.out.println(ans);
		
		
		
	}

}
