package DynamicPrograming_2;

import java.util.ArrayList;

public class Minimum_Elements {
	
	private static ArrayList<ArrayList<Integer>> dp;
	private static ArrayList<ArrayList<Integer>> dpTab;
	
	public static int minCoinsTAB(int[] arr,int tar)
	{
		int n = arr.length;
		for (int i=0;i<=tar;i++)
		{
			if (i%arr[0]==0)
			{
				dpTab.get(0).set(i, i/arr[0]);
			}
			else
			{
				dpTab.get(0).set(i, Integer.MAX_VALUE);
			}
		}
		
		for (int i=1;i<n;i++)
		{
			for (int j=0;j<=tar;j++)
			{
				int nTake = dpTab.get(i-1).get(j);
				int take = Integer.MAX_VALUE;
				if (arr[i] <= j)
				{
					int res = dpTab.get(i).get(j-arr[i]);
					if (res != Integer.MAX_VALUE)
					{
						take = 1+res;
					}
				}
				dpTab.get(i).set(j, Math.min(take, nTake));
			}
		}
		
		int ans = dpTab.get(n-1).get(tar);
		if (ans >= Integer.MAX_VALUE)
		{
			return -1;
		}
		
		return ans;
	}
	
	public static int minCoinsMEMO(int[] arr,int index,int tar,ArrayList<ArrayList<Integer>> dp)
	{
		if(index==0)
		{
			if (tar % arr[0] == 0)
			{
				return tar/arr[0];
			}
			else
			{
				return Integer.MAX_VALUE;
			}
		}
		
		if (dp.get(index).get(tar) != -1)
		{
			return dp.get(index).get(tar);
		}
		
		int nTake = 0 + minCoinsMEMO(arr,index-1,tar,dp);
		int take = Integer.MAX_VALUE;
		if (tar >= arr[index])
		{
			int res =  minCoinsMEMO(arr,index,tar-arr[index],dp);
			if (res != Integer.MAX_VALUE)
			{
				take = 1+res;
			}
		}
		
		dp.get(index).set(tar, Math.min(nTake, take));
		return dp.get(index).get(tar);
		
	}
	
	public static int minCoins(int[] arr,int index,int tar)
	{
		if(index==0)
		{
			if (tar % arr[0] == 0)
			{
				return tar/arr[0];
			}
			else
			{
				return Integer.MAX_VALUE;
			}
		}
		
		int nTake = 0 + minCoins(arr,index-1,tar);
		int take = Integer.MAX_VALUE;
		if (tar >= arr[index])
		{
			int res =  minCoins(arr,index,tar-arr[index]);
			if (res != Integer.MAX_VALUE)
			{
				take = 1+res;
			}
		}
		
		return Math.min(nTake, take);
	}
	
	public static int minElem(int[] arr,int x)
	{
		dp = new ArrayList<>();
		for (int i=0;i<arr.length;i++)
		{
			ArrayList<Integer> row = new ArrayList<>();
			for (int j=0;j<=x;j++)
			{
				row.add(-1);
			}
			dp.add(row);
		}
		
		
		
		//int ans =  minCoins(arr,arr.length-1,x);
		int ans = minCoinsMEMO(arr,arr.length-1,x,dp);
		 return (ans == Integer.MAX_VALUE) ? -1 : ans;
	}

	public static void main(String[] args) {
		
		int[] arr = {1,2,3};
		int x = 7;
		
		dpTab = new ArrayList<>();
		for (int i=0;i<arr.length;i++)
		{
			ArrayList<Integer> row1 = new ArrayList<>();
			for (int j=0;j<=x;j++)
			{
				row1.add(-1);
			}
			dpTab.add(row1);
		}
		
		int ans = minCoinsTAB(arr,x);
		//int ans = minElem(arr,7);
		System.out.println(ans);
		

	}

}
