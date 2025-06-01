package Dynamic_Programming_1;
import java.util.ArrayList;

public class Triangle {
	
	private static ArrayList<ArrayList<Integer>> dp;
	private static ArrayList<ArrayList<Integer>> dpTab;
	
	public static int minPTab(int[][] tri,int row,int index)
	{
		int n = tri.length;
		for (int i=n-1;i<=n-1;i++)
		{
			for (int j=0;j<n;j++)
			{
				dpTab.get(i).set(j, tri[i][j]);
			}
		}
		
		for (int i=n-2;i>=0;i--)
		{
			for (int j=0;j<i+1;j++)
			{
				int way1,way2;
				way1 = tri[i][j] + dpTab.get(i+1).get(j);
				way2 = tri[i][j] + dpTab.get(i+1).get(j+1);
				int res = Math.min(way1, way2);
				dpTab.get(i).set(j, res);
			}
		}
		
		return dpTab.get(0).get(0);
	
	}
	
	public static int minPMemo(int[][] tri,int row,int index)
	{
		int n = tri.length;
		
		if (row == n-1)
		{
			return tri[row][index];
		}
		
		if (dp.get(row).get(index) != -1)
		{
			return dp.get(row).get(index);
		}
		
		int currV = tri[row][index];
		int way1,way2;
		way1 = minPMemo(tri,row+1,index);
		way2 = minPMemo(tri,row+1,index+1);
		
		int minimum = Math.min(way1, way2);
		int ans =  currV+minimum;
		dp.get(row).set(index, ans);
		return ans;
	}

	public static int minPathSum(int[][] tri,int row,int index)
	{
		int n = tri.length;
		
		if (row == n-1)
		{
			return tri[row][index];
		}
		
		int currV = tri[row][index];
		int way1,way2;
		way1 = minPathSum(tri,row+1,index);
		way2 = minPathSum(tri,row+1,index+1);
		
		int minimum = Math.min(way1, way2);
		
		return currV+minimum;
		
	}

	public static void main(String[] args) {
		
		int[][] tri = {{1},{2,3},{3,6,7},{8,9,6,10}};
		int n = tri.length;
		dp = new ArrayList<>();
		for (int i=0;i<n;i++)
		{
			ArrayList<Integer> row = new ArrayList<>();
			for (int j=0;j<i+1;j++)
			{
				row.add(-1);
			}
			dp.add(row);
		}
		
		//int ans = minPathSum(tri,0,0);
		//int ans = minPMemo(tri,0,0);
		//System.out.println(ans);
		//System.out.println(dp);
		
		dpTab = new ArrayList<>();
		for (int i=0;i<n;i++)
		{
			ArrayList<Integer> row1 = new ArrayList<>();
			for (int j=0;j<i+1;j++)
			{
				row1.add(0);
			}
			dpTab.add(row1);
		}
		int ans = minPTab(tri,0,0);
		System.out.println(ans);

	}

}
