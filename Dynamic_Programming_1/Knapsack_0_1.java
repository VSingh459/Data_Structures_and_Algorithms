package Dynamic_Programming_1;
import java.util.ArrayList;

public class Knapsack_0_1 {
	
	private static ArrayList<ArrayList<Integer>> dp;
	private static ArrayList<ArrayList<Integer>> dpTab;
	private static int[][] dpG;
	
	public static int knapTabGPT(int[] weight, int[] value, int n, int max) {
		
         dpG = new int[n+1][max+1];
        
        for (int i=0;i<=max;i++)
		{
			dpG[0][i] = 0;
		}
		
		for (int i=0;i<=n;i++)
		{
			dpG[i][0] = 0;
		}
        

        // Build table dp[][] in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= max; j++) {
            	
            	int take = Integer.MIN_VALUE;
            	int nTake = dpG[i-1][j];
            	if (weight[i-1] <= j)
            	{
            		int d = j-weight[i-1];
            		take = value[i-1] + dpG[i-1][d];
            	}
            	
            	dpG[i][j] = Math.max(take, nTake);
            }
        }

        return dpG[n][max];
    }
	
	public static int knapTab(int[] wt,int[] val,int n,int max)
	{
		for (int i=0;i<=max;i++)
		{
			dpTab.get(0).set(i, 0);
		}
		
		for (int i=0;i<=n;i++)
		{
			dpTab.get(i).set(0, 0);
		}
		
		for (int i=1;i<=n;i++)
		{
			for (int j=1;j<=max;j++)
			{
				int take = Integer.MIN_VALUE;
				int nTake;
				nTake = dpTab.get(i-1).get(j);
				if (wt[i-1] <= j)
				{
					take = val[i-1] + dpTab.get(i-1).get(j-wt[i-1]);
				}
			
				int temp = Math.max(take, nTake);
				dpTab.get(i).set(j, temp);
			}
		}
		
		return dpTab.get(n).get(max);
	}
	
//	public static int knapsack(int[] weight,int[] value,int n,int maxWeight)
//	{
//		if (n < 0)
//		{
//			return 0;
//		}
//		
////		if (dp.get(n).get(maxWeight) != -1)
////		{
////			return dp.get(n).get(maxWeight);
////		}
//		
//		int nTake = knapsack(weight,value,n-1,maxWeight);
//		int take = Integer.MIN_VALUE;
//		if (weight[n] <= maxWeight)
//		{
//			take = value[n] + knapsack(weight,value,n-1,maxWeight-weight[n]);
//		}
//		
//		int temp = Math.max(take, nTake);
//		//dp.get(n).set(maxWeight, temp);
//		return temp;
//	}

	public static void main(String[] args) {
		
		int[] w = {1,2,4,5};
		int[] v = {5,4,8,6};
		int maxWeight = 5;
		int n= 4;
		
		
		//int ans = knapsack(w,v,n-1,maxWeight);
		//System.out.println(ans);
		
//		dp = new ArrayList<>();
//		for (int i=0;i<=n;i++)
//		{
//			ArrayList<Integer> row = new ArrayList<>();
//			for (int j=0;j<=maxWeight;j++)
//			{
//				row.add(-1);
//			}
//			dp.add(row);
//		}
		
		dpTab = new ArrayList<>();
		for (int i=0;i<=n;i++)
		{
			ArrayList<Integer> row1 = new ArrayList<>();
			for (int j=0;j<=maxWeight;j++)
			{
				row1.add(0);
			}
			dpTab.add(row1);
		}
		
		//int ans = knapTab(w,v,n-1,maxWeight);
		int ans = knapTabGPT(w,v,n,maxWeight);
		System.out.println(ans);
		
		for (int i=0;i<=n;i++)
		{
			for (int j=0;j<=maxWeight;j++)
			{
				System.out.print(dpG[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	

	}

}
