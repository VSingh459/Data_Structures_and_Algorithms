package DynamicPrograming_2;
import java.util.ArrayList;

public class MatrixChainMultiplication {
	
	private static ArrayList<ArrayList<Integer>> dp;
	
	public static int fTAB(int[] arr)
	{
		int n = arr.length;
		int dpT[][] = new int[n][n];
		for (int i=1;i<n;i++)
		{
			dpT[i][i] = 0;
		}
		
		for (int i=n-1;i>=1;i--)
		{
			for (int j=i+1;j<n;j++)
			{
				int min = Integer.MAX_VALUE;
				for (int k=i;k<j;k++)
				{
					int steps = arr[i-1]*arr[k]*arr[j] + dpT[i][k] + dpT[k+1][j];
					if (steps<min)
					{
						min = steps;
					}
				}
				dpT[i][j] = min;
			}
		}
		return dpT[1][n-1];
	}
	
	public static int fMEMO(int i,int j,int[] arr)
	{
		if (i==j)
		{
			return 0;
		}
		
		if (dp.get(i).get(j) != -1)
		{
			return dp.get(i).get(j);
		}
		
		int min = Integer.MAX_VALUE;
		for (int k=i;k<j;k++)
		{
			int steps = arr[i-1]*arr[k]*arr[j] + fMEMO(i,k,arr) + fMEMO(k+1,j,arr);
			if (steps < min)
			{
				min = steps;
			}
		}
		
		dp.get(i).set(j, min);
		
		return min;	
	}
	
	public static int f(int i,int j,int[] arr)
	{
		if (i==j)
		{
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		for (int k=i;k<j;k++)
		{
			int steps = arr[i-1]*arr[k]*arr[j] + f(i,k,arr) + f(k+1,j,arr);
			if (steps < min)
			{
				min = steps;
			}
		}
		
		return min;	
	}
	
	public static int matrixMult(int[] arr)
	{
		dp = new ArrayList<>();
		int n = arr.length;
		for (int i=0;i<n;i++)
		{
			ArrayList<Integer> row = new ArrayList<>();
			for (int j=0;j<n;j++)
			{
				row.add(-1);
			}
			dp.add(row);
		}
		return f(1,n-1,arr);
	}

	public static void main(String[] args) {
		
		int arr[] = {10,20,30,40,50};
		//int ans = matrixMult(arr);
		int ans = fTAB(arr);
		System.out.println(ans);

	}

}
