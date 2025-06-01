package Dynamic_Programming_1;
import java.util.ArrayList;

public class MinimumSquares {
	
	
	public static int getMinTAB(int n)
	{
		if (n <= 3)
		{
			return n;
		}
		
		int[] dp = new int[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for (int i=4;i<=n;i++)
		{
			dp[i] = i;
			
			for (int x=1;x<= Math.ceil(Math.sqrt(i));x++)
			{
				int temp = x*x;
				if (temp > i)
				{
					break;
				}
				else
				{
					int t = Math.min(dp[i], 1 + dp[i-temp]);
					dp[i] = t;
				}
				
			}
		}
		
		int res = dp[n];
		
		return res;
	}
	
	public static int getMinSquares(int n)
	{
		if (n <= 3)
		{
			return n;
		}
		
		int res = n;
		for (int i=1;i<=n;i++)
		{
			int temp = i*i;
			if (temp > n)
			{
				break;
			}
			else
			{
				int t = 1 + getMinSquares(n-temp);
				res = Math.min(i, t);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		
		int n = 100;
		int ans = getMinTAB(n);
		System.out.println(ans);

	}

}
