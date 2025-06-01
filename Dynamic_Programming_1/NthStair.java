package Dynamic_Programming_1;
import java.util.ArrayList;

public class NthStair {
	
	private static ArrayList<Integer> dp;
	
	public static int stepTab(int n)
	{
		dp.set(0, 1);
		dp.set(1, 1);
		
		int temp = 0;
		
		for (int i=2;i<=n;i++)
		{
			temp = dp.set(i,dp.get(i-1)+dp.get(i-2));
		}
		
		return dp.get(n);
		
	}
	
	public static int findSteps(int n)
	{
		if (n==0)
		{
			return 1;
		}
		else if (n < 0)
		{
			return 0;
		}
		else if (dp.get(n) != -1)
		{
			return dp.get(n);
		}
		else 
		{
			int temp = findSteps(n-2) + findSteps(n-1);
			dp.set(n, temp);
			return  temp;
		}
		
		
	}

	public static void main(String[] args) {
		
		dp = new ArrayList<>();
		for (int i=0;i<=10;i++)
		{
			dp.add(-1);
		}
		
		int n=1;
		System.out.println(findSteps(n));
		//System.out.println(stepTab(n));
		

	}

}
