package DynamicPrograming_2;
import java.util.ArrayList;

public class PartitionSubsetSum {
	
	private static ArrayList<ArrayList<Boolean>> dpTab;
	
	public static boolean eqPartTAB(int[] arr,int n,int target)
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
	
	public static boolean equalPartition(int[] arr,int index,int s)
	{
		if ( s== 0)
		{
			return true;
		}
		if (index == 0)
		{
			return (arr[0] == s);
		}
		
		boolean nTake = equalPartition(arr,index-1,s);
		boolean take = false;
		if (arr[index] <= s)
		{
			take = equalPartition(arr,index-1,s-arr[index]);
		}
		
		return take | nTake;
	}
	
	public static boolean canPartition(int[] arr,int n)
	{
		int sum=0;
		for (int i=0;i<n;i++)
		{
			sum = sum + arr[i];
		}
		
		if (sum % 2 != 0)
		{
			return false;
		}
		
		dpTab = new ArrayList<>();
		
		for (int i=0;i<=arr.length;i++)
		{
			ArrayList<Boolean> row = new ArrayList<>();
			for (int j=0;j<=sum/2;j++)
			{
				row.add(false);
			}
			dpTab.add(row);
		}

		
		return eqPartTAB(arr,n,sum/2);
		
	}

	public static void main(String[] args) {
		
		int[] arr = {5,6,5,11,6};
		
		boolean ans = canPartition(arr,arr.length);
		System.out.println(ans);
		

	}

}
