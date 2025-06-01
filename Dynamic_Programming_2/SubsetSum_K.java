package DynamicPrograming_2;
import java.util.ArrayList;

public class SubsetSum_K {
	
	private static ArrayList<ArrayList<Integer>> dp;
	private static ArrayList<ArrayList<Boolean>> dpTab;
	
	public static boolean subSumTAB(int[] arr,int n,int target)
	{
		for (int i=0;i<=n;i++)
		{
			dpTab.get(i).set(0, true);
		}
		
		for (int i=1;i<=target;i++)
		{
			dpTab.get(0).set(i, false);
		}
		
		for (int i=1;i<=n;i++)
		{
			for (int j=1;j<=target;j++)
			{
				boolean take = false;
				boolean nTake = dpTab.get(i-1).get(j);
				
				if (j>=arr[i-1])
				{
					take = dpTab.get(i-1).get(j-arr[i-1]);
				}
				
				dpTab.get(i).set(j, take || nTake);
			}
		}
		
		return dpTab.get(n).get(target);
	}
	
	public static boolean subSumMEMO(int[] arr,int index, int target,ArrayList<ArrayList<Integer>> dp)
	{
		if (target == 0)
		{
			return true;
		}
		if (index == 0)
		{
			return (arr[0] == target);
		}
		
		if (dp.get(index).get(target) != -1)
		{
			return dp.get(index).get(target) == 0 ? false : true;
		}
		
		boolean nTake = subSumMEMO(arr,index-1,target,dp);
		boolean take = false;
		if (arr[index] <= target)
		{
			take = subSumMEMO(arr,index-1,target-arr[index],dp);
		}
		
		boolean temp =  take | nTake;
		dp.get(index).set(target, temp==true ? 1: 0);
		return temp;
		
	}
	
	
	public static boolean subSumToK(int[] arr,int index, int target)
	{
		if (target == 0)
		{
			return true;
		}
		if (index == 0)
		{
			return arr[0]==target;
		}
		
		boolean nTake = subSumToK(arr,index-1,target);
		boolean take = false;
		if (arr[index] <= target)
		{
			take = subSumToK(arr,index-1,target-arr[index]);
		}
		
		return take | nTake;
		
	}
	

	public static void main(String[] args) {
		
		int arr[] = {6,7,2,9};
		int k = 2;
		int n = arr.length;
		
		dp = new ArrayList<>();
		
		for (int i=0;i<=n;i++)
		{
			ArrayList<Integer> row = new ArrayList<>();
			for (int j=0;j<=k;j++)
			{
				row.add(-1);
			}
			dp.add(row);
		}
		
         dpTab = new ArrayList<>();
		
		for (int i=0;i<=n;i++)
		{
			ArrayList<Boolean> row = new ArrayList<>();
			for (int j=0;j<=k;j++)
			{
				row.add(false);
			}
			dpTab.add(row);
		}
		
		boolean ans = subSumToK(arr,n-1,k);
		//boolean ans = subSumMEMO(arr,n-1,k,dp);
		//boolean ans = subSumTAB(arr,n,k);
		System.out.println(ans);
		
		for (int i=0;i<=n;i++)
		{
			for (int j=0;j<=k;j++)
			{
				System.out.print(dpTab.get(i).get(j)+" ");
			}
			System.out.println();
		}
	

	}

}
