package DynamicPrograming_2;
import java.util.ArrayList;

public class Longest_Increasing_Subsequence {
	
	private static ArrayList<ArrayList<Integer>> dp;
	private static ArrayList<ArrayList<Integer>> dpTab;
	private static int[] dpB;
	private static int[] hash;
	
	public static int lowerBound(int[] a,int low,int high,int element)
	{
		while (low < high)
		{
			int middle = low + (high-low)/2;
			if (element > a[middle])
			{
				low = middle+1;
			}
			else
			{
				high = middle;
			}
		}
		
		return low;
	}
	
	public static int lisN(int[] arr)
	{
		int n = arr.length;
		int dpN[] = new int[n];
		int ans = 0;
		
		for (int i=0;i<n;i++)
		{
			int position = lowerBound(dpN,0,ans,arr[i]);
			dpN[position] = arr[i];
			if (position==ans)
			{
				ans++;
			}
			
		}
		return ans;
	}
	
	
	
	public static int lisBetter(int[] arr)
	{
		int max = 1;
		int n= arr.length;
		for (int i=0;i<n;i++)
		{
			hash[i] = i;
			for (int prev=0;prev<i;prev++)
			{
				if (arr[prev] < arr[i])
				{
					dpB[i] = Math.max(dpB[i], 1+dpB[prev]);
				}
			}
			max = Math.max(max, dpB[i]);
		}
		
		return max;
		
	}
	
	public static int lisSpace(int[] arr)
	{
		int n= arr.length;
		int[] next = new int[n+1];
		int[] curr = new int[n+1];
		
		for (int ind=n-1;ind>=0;ind--)
		{
			for (int prevInd =ind-1;prevInd>= -1;prevInd-- )
			{
				int nTake = next[prevInd+1];
				int take = Integer.MIN_VALUE;
				if (prevInd == -1 || arr[ind] > arr[prevInd])
				{
					take = 1 + next[ind+1];
				}
				curr[prevInd+1] = Math.max(take, nTake);
			}
			next = curr;
		}
		
		return next[-1+1];
		
		
	}
	
	public static int lisTAB(int[] arr)
	{
		int n = arr.length;
		for (int ind=n-1;ind>=0;ind--)
		{
			for (int prevInd =ind-1;prevInd>= -1;prevInd-- )
			{
				int nTake = dpTab.get(ind+1).get(prevInd+1);
				int take = Integer.MIN_VALUE;
				if (prevInd == -1 || arr[ind] > arr[prevInd])
				{
					take = 1 + dpTab.get(ind+1).get(ind+1);
				}
				dpTab.get(ind).set(prevInd+1, Math.max(take,nTake));
			}
		}
		
		return dpTab.get(0).get(-1+1);
		
	}
	
	public static int lisMEMO(int[] arr,int ind,int prevInd)
	{
		if (ind==arr.length)
		{
			return 0;
		}
		
		if (dp.get(ind).get(prevInd+1) != -1)
		{
			return dp.get(ind).get(prevInd+1);
		}
		
		int nTake = 0 + lisMEMO(arr,ind+1,prevInd);
		int take = Integer.MIN_VALUE;
		if (prevInd == -1 || arr[ind] > arr[prevInd])
		{
			take = 1 + lisMEMO(arr,ind+1,ind);
		}
		
		int aa =  Math.max(nTake, take);
		dp.get(ind).set(prevInd+1, aa);
		return aa;
	}
	
	public static int lis(int[] arr,int ind,int prevInd)
	{
		if (ind==arr.length)
		{
			return 0;
		}
		
		int nTake = 0 + lis(arr,ind+1,prevInd);
		int take = Integer.MIN_VALUE;
		if (prevInd == -1 || arr[ind] > arr[prevInd])
		{
			take = 1 + lis(arr,ind+1,ind);
		}
		
		return Math.max(nTake, take);
	}
	
	
	
	public static int longIncrSub(int arr[])
	{
		dp = new ArrayList<>();
		for (int i=0;i<arr.length;i++)
		{
			ArrayList<Integer> row = new ArrayList<>();
			for (int j=0;j<=arr.length;j++)
			{
				row.add(-1);
			}
			dp.add(row);
		}
		
		//return lis(arr,0,-1);
		return lisMEMO(arr,0,-1);
	}

	public static void main(String[] args) {
		
		int[] arr = {5,4,11,1,16,8};
		
		dpTab = new ArrayList<>();
		for (int i=0;i<=arr.length;i++)
		{
			ArrayList<Integer> row1 = new ArrayList<>();
			for (int j=0;j<=arr.length;j++)
			{
				row1.add(0);
			}
			dpTab.add(row1);
		}
		//int ans = longIncrSub(arr);
		//int ans = lisTAB(arr);
		
		dpB = new int[arr.length];
		hash = new int[arr.length];
		for (int i=0;i<arr.length;i++)
		{
			dpB[i] = 1;
		}
		//int ans = lisSpace(arr);
		//int ans = lisBetter(arr);
		int ans = lisN(arr);
		System.out.println(ans);

	}

}
