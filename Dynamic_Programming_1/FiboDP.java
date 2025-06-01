package Dynamic_Programming_1;
import java.util.ArrayList;

public class FiboDP {
	
	private static int fib(int n)
	{
		if (n<=1)
			return n;
		
		if (dp.get(n) != -1)
		{
			return dp.get(n);
		}
		
		int temp = fib(n-1) + fib(n-2);
		dp.set(n, temp);
		return temp;
		
	}
	
	private static ArrayList<Integer> dp;
	public static void main(String[] args) {
		
		dp = new ArrayList<>();
		for (int i=0;i<=6;i++)
		{
			dp.add(-1);
		}
		
		int ans = fib(3);
		System.out.println(ans);
	}

}
