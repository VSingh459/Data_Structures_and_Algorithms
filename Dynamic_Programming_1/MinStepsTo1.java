package Dynamic_Programming_1;
import java.util.ArrayList;

public class MinStepsTo1 {
	
	private static ArrayList<Integer> dp;
	
	public static int countTabu(int n)
	{
	    
		dp.set(0, 0);
	    dp.set(1, 0);
		if (n==1)
		{
			return 0;
		}
	    dp.set(2, 1);
		if (n==2)
		{
			return 1;
		}
	    dp.set(3, 1);
		if (n==3)
		{
			return 1;
		}
	    
	    for(int i=4;i<=n;i++)
	    {
	         int way1 = Integer.MAX_VALUE;
	         int way2 = Integer.MAX_VALUE;
	         int way3 = Integer.MAX_VALUE;
	         
	         if(i%3 == 0)
	         way1 =1+dp.get(i/3);
	         if(i%2 == 0);
	         way2 =1+dp.get(i/2);
	         way3 =1+dp.get(i-1);
	         int temp = Math.min(way1, Math.min(way2,way3));
	         dp.set(i, temp);
	    }
	  
	    return dp.get(n);
	}
	
	public static int countMinSteps(int n)
	{
		if (n==1)
		{
			return 0;
		}
		
		if (dp.get(n) != -1)
		{
			return dp.get(n);
		}
		
		int way1 = Integer.MAX_VALUE;
		int way2 = Integer.MAX_VALUE;
		int way3;
		
		if (n%2 == 0)
		{
			way1 = 1+countMinSteps(n/2);
		}
		
		if (n%3 == 0)
		{
			way2 = 1+countMinSteps(n/3);
		}
		 
		way3 =  1+countMinSteps(n-1);
		
		int temp =  Math.min(way1, Math.min(way2, way3));
		dp.set(n, temp);
		return temp;
		
	}

	public static void main(String[] args) {
		
		dp = new ArrayList<>();
		
		int n = 15;
		
		for (int i=0;i<=n;i++)
		{
			dp.add(-1);
		}
		
		int ans = countTabu(n);
		System.out.println(ans);
		System.out.println(dp);

	}

}
