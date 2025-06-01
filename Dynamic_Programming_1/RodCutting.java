package Dynamic_Programming_1;
import java.util.ArrayList;

public class RodCutting {
	
	public static ArrayList<ArrayList<Integer>> dp;
	
	public static int rodCutTab(int price[],int n)
	{
		for (int i=0;i<=n;i++)
		{
			dp.get(0).set(i, i*price[0]);
		}
		
		for (int i=1;i<n;i++)
		{
			for (int j=0;j<=n;j++)
			{
				int nTake = dp.get(i-1).get(j);
				int take = Integer.MIN_VALUE;
				int rodLength = i+1;
				if (rodLength <=j)
				{
					take = price[i] + dp.get(i).get(j-rodLength);
				}
				dp.get(i).set(j, Math.max(take, nTake));
			}
		}
		
		return dp.get(n-1).get(n);
	}
	
	public static int rodCutMemo(int price[],int index,int n,ArrayList<ArrayList<Integer>> dp)
	{
		if (index==0)
		{
			return n*price[0];
		}
		
		if (dp.get(index).get(n) != -1)
		{
			return dp.get(index).get(n);
		}
		
		int nTake = 0 + rodCutMemo(price,index-1,n,dp);
		int take = Integer.MIN_VALUE;
		int rodLength = index + 1;
		if (rodLength <= n)
		{
			take = price[index] + rodCutMemo(price,index,n-rodLength,dp);
		}
		
		dp.get(index).set(n, Math.max(take, nTake));
		
		return  dp.get(index).get(n);
	}
	
	public static int rodCutter(int price[],int index,int n)
	{
		if (index==0)
		{
			return n*price[0];
		}
		
		int nTake = 0 + rodCutter(price,index-1,n);
		int take = Integer.MIN_VALUE;
		int rodLength = index + 1;
		if (rodLength <= n)
		{
			take = price[index] + rodCutter(price,index,n-rodLength);
		}
		
		
		return  Math.max(take, nTake);
	}

	public static void main(String[] args) {
		
		int n = 5;
		int val[] = {2,5,7,8,10};
		
		dp = new ArrayList<>();
		for (int i=0;i<=n;i++)
		{
			ArrayList<Integer> row = new ArrayList<>();
			for (int j=0;j<=n;j++)
			{
				row.add(0);
			}
			dp.add(row);
		}
		//int ans = rodCutTab(val,n);
		int ans = rodCutter(val,val.length-1,n);
		System.out.println(ans);

	}

}
