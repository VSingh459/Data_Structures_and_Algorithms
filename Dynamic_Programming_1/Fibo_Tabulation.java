package Dynamic_Programming_1;
import java.util.ArrayList;

public class Fibo_Tabulation {
	
	private static int fib(int n)
	{
		dp.set(0, 0);
		dp.set(1, 1);
		
		for (int i=2;i<=n;i++)
		{
			dp.set(i, dp.get(i-1) + dp.get(i-2));
			
		}
		
		return dp.get(n);
	}
	
	private static ArrayList<Integer> dp;
	public static void main(String[] args) {
		
		dp = new ArrayList<>();
		for (int i=0;i<=5;i++)
		{
			dp.add(-1);
		}
		
		int ans = fib(5);
		System.out.println(ans);

	}

}
