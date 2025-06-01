package Dynamic_Programming_1;
import java.util.ArrayList;

public class MaxPathSum {
	
	private static ArrayList<ArrayList<Integer>> dp;
	private static ArrayList<ArrayList<Integer>> dpTab;
	
	public static int getMaxTab(int[][] mat)
	{
		int n = mat.length;
		int m = mat[0].length;
		
		for (int i=0;i<m;i++)
		{
			dpTab.get(0).set(i, mat[0][i]);
		}
		
		for (int i=1;i<n;i++)
		{
			for (int j=0;j<m;j++)
			{
				int op1,op2 = Integer.MIN_VALUE, op3 = Integer.MIN_VALUE;
				
				op1 = mat[i][j] + dpTab.get(i-1).get(j);
				if (j != 0)
				{
					op2 = mat[i][j] + dpTab.get(i-1).get(j-1);
				}
				if (j !=m-1)
				{
					op3 = mat[i][j] + dpTab.get(i-1).get(j+1);
				}
				
				int temp = Math.max(op1, Math.max(op2, op3));
				dpTab.get(i).set(j,temp);
			}
			
		}
		int ans = Integer.MIN_VALUE;
		for (int i=0;i<m;i++)
		{
			ans = Math.max(ans, dpTab.get(n-1).get(i));
		}
		return ans;
	}
	
	public static int getMaxMemo(int[][] mat,int row,int col)
	{
		int n = mat.length;
		int m = mat[0].length;
		if (row == n)
		{
			return 0;
		}
		
		if (col<0 || col>=m)
		{
			return -100000;
		}
		
		if (dp.get(row).get(col) != -1)
		{
			return dp.get(row).get(col);
		}
		
		int op1,op2,op3;
		op1 = mat[row][col] + getMaxMemo(mat,row+1,col);
		op2 = mat[row][col] + getMaxMemo(mat,row+1,col-1);
		op3 = mat[row][col] + getMaxMemo(mat,row+1,col+1);
		
		int ans = Math.max(op1, Math.max(op2, op3));
		
		dp.get(row).set(col, ans);
		
		return ans;
		
		
	}
	
	public static int getMaxPathSum(int[][] mat,int row,int col)
	{
		int n = mat.length;
		int m = mat[0].length;
		if (row == n)
		{
			return 0;
		}
		
		if (col<0 || col>=m)
		{
			return -100000;
		}
		
		int op1,op2,op3;
		op1 = mat[row][col] + getMaxPathSum(mat,row+1,col);
		op2 = mat[row][col] + getMaxPathSum(mat,row+1,col-1);
		op3 = mat[row][col] + getMaxPathSum(mat,row+1,col+1);
		
		return Math.max(op1, Math.max(op2, op3));
		
		
	}
	


	public static void main(String[] args) {
		
		int[][] mat = {{10,10,2,-13,20,4},
				       {1,-9,-81,30,2,5},
				       {0,10,4,-79,2,-10},
				       {1,-5,2,20,-11,4}};
		
////		dp = new ArrayList<>();
////		for (int i=0;i<mat.length;i++)
////		{
////			ArrayList<Integer> row = new ArrayList<>();
////			for (int j=0;j<mat[0].length;j++)
////			{
////				row.add(-1);
////			}
////			dp.add(row);
//		}
		
//		int ans = Integer.MIN_VALUE;
//		
//		for (int col=0;col<mat[0].length;col++)
//		{
//			ans = Math.max(ans, getMaxPathSum(mat,0,col));
//		}
		
		dpTab = new ArrayList<>();
		for (int i=0;i<mat.length;i++)
		{
			ArrayList<Integer> row1 = new ArrayList<>();
			for (int j=0;j<mat[0].length;j++)
			{
				row1.add(0);
			}
			dpTab.add(row1);
		}
		
		
		int ans1 = getMaxTab(mat);
		
		System.out.println(ans1);
		

	}

}
