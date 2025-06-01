package DynamicPrograming_2;
import java.util.ArrayList;

public class PartitionsW_Diff {
	
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
	
	public static int countPartitions(int[] arr,int d,int n)
	{
		int totSum = 0;
		for (int i=0;i<arr.length;i++)
		{
			totSum = totSum+arr[i];
		}
		
		if (totSum - d < 0 || (totSum-d)%2 != 0)
		{
			return 0;
		}
		
		int s = (totSum-d)/2;
		
		return countSubsetsTAB(arr,s);
		
	}

	public static void main(String[] args) {
		
		int[] arr = {5,2,6,4};
		int d = 3;
		
		int ans = countPartitions(arr,d,arr.length);
		System.out.println(ans);
		

	}

}
