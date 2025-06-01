package Dynamic_Programming_1;
import java.util.ArrayList;

public class UniquePath {
	
	public static ArrayList<ArrayList<Integer>> dp;
	public static ArrayList<ArrayList<Integer>> dpTab;
	static final int MOD = 1000000007;
	
	public static int countPTabBetter(int[][] grid,int n,int m)
	{
		for (int i=0;i<m;i++)
		{
			if (grid[0][i] == -1)
			{
				break;
			}
			dpTab.get(0).set(i, 1);
		}
		
		for (int i=0;i<n;i++)
		{
			if (grid[i][0] == -1)
			{
				break;
			}
			dpTab.get(i).set(0, 1);
		}
		
		for (int i=1;i<n;i++)
		{
			for (int j=1;j<m;j++)
			{
				if (grid[i][j] == -1)
				{
					dpTab.get(0).set(j, 0);
				}
				else
				{
					int res = dpTab.get(i-1).get(j) + dpTab.get(i).get(j-1);
					dpTab.get(i).set(j, res);
				}
			}
		}
		
		return dpTab.get(n-1).get(m-1);
	}
	
	public static int countPSpace(int[][] grid,int n,int m)
	{
		int[] prev = new int[m];
		
		for (int i=0;i<n;i++)
		{
			int[] curr = new int[m];
			for (int j=0;j<m;j++)
			{
				if (grid[i][j] == -1 )
				{
					curr[j] = 0;
				}
				else if (i==0 && j==0)
				{
					curr[j] = 1;
				}
				else
				{
					int up = 0;
					int left = 0;
					if (i>0)
					{
						up = prev[j];
					}
					if (j>0)
					{
						left = curr[j-1];
					}
				     curr[j] = (up+left)%MOD;
					
				}
			}
			prev = curr;
		}
		
		return prev[m-1];
		
	}
	
	public static int countPTab(int[][] grid,int n,int m)
	{
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<m;j++)
			{
				if (grid[i][j] == -1 )
				{
					dp.get(i).set(j, 0);
				}
				else if (i==0 && j==0)
				{
					dp.get(i).set(j, 1);
				}
				else
				{
					int up = 0;
					int left = 0;
					if (i>0)
					{
						up = dp.get(i-1).get(j);
					}
					if (j>0)
					{
						left = dp.get(i).get(j-1);
					}
					int res = (up+left)%MOD;
					dp.get(i).set(j, res);
				}
			}
		}
		
		return dp.get(n-1).get(m-1);
	
	}
	
	public static int countPMemo(int[][] grid,int i,int j)
	{
		int n = grid.length;
		int m = grid[0].length;
		
		if (i >= n || j >= m || grid[i][j] == -1)
		{
			return 0;
		}
		
		if (i==n-1 && j==m-1)
		{
			return 1;
		}
		
		if (dp.get(i).get(j) != -1)
		{
			return dp.get(i).get(j);
		}
		
		
		
		int way1,way2;
		
		way1 = countPMemo(grid,i+1,j);
		way2 = countPMemo(grid,i,j+1);
		
		int ans = way1+way2;
		
		dp.get(i).set(j, ans);
		
		
		return ans;
		
		
	}
	
	public static int countPRecursive(int[][] grid,int i,int j)
	{
		int n = grid.length;
		int m = grid[0].length;
		
		if (i >= n || j >= m || grid[i][j] == -1)
		{
			return 0;
		}
		
		if (i==n-1 && j==m-1)
		{
			return 1;
		}
		
		int way1,way2;
		
		way1 = countPRecursive(grid,i+1,j);
		way2 = countPRecursive(grid,i,j+1);
		
		int ans = way1+way2;
		return ans;
	}

	public static void main(String[] args) {
		
		int grid[][] = {{0,0,0},{0,-1,0},{0,0,0}};
		int n=3;
		int m=3;
		dp = new ArrayList<>();
		for (int i=0;i<n;i++)
		{
			ArrayList<Integer> row = new ArrayList<>();
			for (int j=0;j<m;j++)
			{
				row.add(-1);
			}
			dp.add(row);
		}
		
		//int ans = countPRecursive(grid,0,0);
		//int ans = countPMemo(grid,0,0);
		//int ans = countPTab(grid,3,3);
		//int ans = countPSpace(grid,3,3);
		
		dpTab = new ArrayList<>();
		
		for (int i=0;i<n;i++)
		{
			ArrayList<Integer> row1 = new ArrayList<>();
			for (int j=0;j<m;j++)
			{
				row1.add(0);
			}
			dpTab.add(row1);
		}
		int ans = countPTabBetter(grid,3,3);
		System.out.println(ans);
		System.out.println(dp);
		

	}

}
