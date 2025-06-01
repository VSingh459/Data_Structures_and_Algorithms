package Dynamic_Programming_1;
import java.util.ArrayList;

public class Frog_Jump {
	
	private static ArrayList<Integer> dp;
	
	public static int energyTab(int n,int height[])
	{
		dp.set(0, 0);
		dp.set(1, 0);
		
		for (int i=2;i<=n;i++)
		{
			int op1;
			int op2 = Integer.MAX_VALUE;
			
			op1 = Math.abs(height[i-1]-height[i-2]) + dp.get(i-1);
			if (i-2>0)
			{
				op2 = Math.abs(height[i-1]-height[i-3]) + dp.get(i-2);
			}
			
			dp.set(i, Math.min(op1, op2));
		}
		
		return dp.get(n);
		
	}
	
	public static int stepEnergy(int n,int height[])
	{
		if (n == 1) {
            return 0;
        }
		
		if (dp.get(n) != -1)
		{
			return dp.get(n);
		}

        // Calculate the energy for a jump from (i-1)th to ith step
        int op1 = stepEnergy(n - 1, height) + Math.abs(height[n-1] - height[n - 2]);

        // Initialize the energy for a jump from (i-2)th to ith step to infinity
        int op2 = Integer.MAX_VALUE;
        if (n-2>0) {
            op2 = stepEnergy(n - 2, height) + Math.abs(height[n-1] -  height[n - 3]);
        }

        // Return the minimum of both possible jumps
        int temp =  Math.min(op1, op2);
        dp.set(n, temp);
        return temp;

	}
	
	public static int recEnergy(int n,int[] height)
	{
		if (n == 1) {
            return 0;
        }

        // Calculate the energy for a jump from (i-1)th to ith step
        int op1 = recEnergy(n - 1, height) + Math.abs(height[n-1] - height[n - 2]);

        // Initialize the energy for a jump from (i-2)th to ith step to infinity
        int op2 = Integer.MAX_VALUE;
        if (n-2>0) {
            op2 = recEnergy(n - 2, height) + Math.abs(height[n-1] -  height[n - 3]);
        }

        // Return the minimum of both possible jumps
        int temp =  Math.min(op1, op2);
        return temp;
		
	}

	public static void main(String[] args) {
		
		dp = new ArrayList<>();
		
		for (int i=0;i<=10;i++)
		{
			dp.add(-1);
		}
		
		int height[] = {7,4,4,2,6,6,3,4};
		
		int ans = stepEnergy(8,height);
		//int ans = energyTab(8,height);
		//int ans = recEnergy(8,height);
		System.out.println(ans);

	}

}
