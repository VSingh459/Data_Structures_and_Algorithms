package DynamicPrograming_2;
import java.util.ArrayList;

public class CountSubsetsSumK {
	
	private static ArrayList<ArrayList<Integer>> dp;
	
	public static int countSubsetsTAB(int arr[],int sum)
	{
		int n = arr.length;
		int dpTab[][] = new int[n+1][sum+1];
		
		dpTab[0][0] = 1;
		
		for (int i=1;i<=n;i++)
		{
			for (int j=0;j<=sum;j++)
			{
				dpTab[i][j] = dpTab[i-1][j];
				if (arr[i-1] <= j)
				{
					dpTab[i][j] = dpTab[i][j] + dpTab[i-1][j-arr[i-1]];
					dpTab[i][j] = dpTab[i][j] % 1000000007;
				}
			}
		}
		
		return dpTab[n][sum];
		
	}
	
	
	public static int countSubsetsMEMO(int arr[],int index,int sum,ArrayList<ArrayList<Integer>> dp)
	{
		if (index==0)
		{
			if (sum==0 && arr[0]==0)
			{
				return 2;
			}
			if (sum==0 || sum==arr[0])
			{
				return 1;
			}
			return 0;
		}
		
		if (dp.get(index).get(sum) != -1)
		{
			return dp.get(index).get(sum);
		}
		
		int nTake = countSubsetsMEMO(arr,index-1,sum,dp);
		int take = 0;
		if (sum >= arr[index])
		{
			take = countSubsetsMEMO(arr,index-1,sum-arr[index],dp);
		}
		
		dp.get(index).set(sum, (take+nTake)%1000000007);
		
		return (take+nTake)%1000000007;
	
	}
	
	public static int countSubsets(int arr[],int index,int sum)
	{
		if (index==0)
		{
			if (sum==0 && arr[0]==0)
			{
				return 2;
			}
			if (sum==0 || sum==arr[0])
			{
				return 1;
			}
			return 0;
		}
		
		int nTake = countSubsets(arr,index-1,sum);
		int take = 0;
		if (sum >= arr[index])
		{
			take = countSubsets(arr,index-1,sum-arr[index]);
		}
		
		return take+nTake;
	
	}
	
	public static int findWays(int[] arr,int tar)
	{
		//return countSubsets(arr, arr.length-1, tar);
		dp = new ArrayList<>();
		for (int i=0;i<=arr.length;i++)
		{
			ArrayList<Integer> row = new ArrayList<>();
			for (int j=0;j<=tar;j++)
			{
				row.add(-1);
			}
			dp.add(row);
		}
		
		
		
		//return countSubsets(arr,arr.length,tar,0,0);
		//return countSubsetsMEMO(arr,arr.length-1,tar,dp);
		return countSubsetsTAB(arr,tar);
	}

	public static void main(String[] args) {
		
		int[] arr = {0,0,1};
		
		int ans = findWays(arr,1);
		System.out.println(ans);

	}

}
