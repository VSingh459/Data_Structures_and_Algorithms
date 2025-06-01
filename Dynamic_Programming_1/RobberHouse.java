package Dynamic_Programming_1;

import java.util.ArrayList;

public class RobberHouse {
	
	public static long houseRobber(int[] valueInHouse)
	{
		if (valueInHouse.length==1)
		{
			return valueInHouse[0];
		}
		int[] x = new int[valueInHouse.length-1];
		int[] y = new int[valueInHouse.length-1];
		for (int i=0;i<valueInHouse.length-1;i++)
		{
			x[i] = valueInHouse[i];
			y[i] = valueInHouse[i+1];
		}
		
		
		int a1 = mTabSpaceSum(x,valueInHouse.length-2);
		int a2 = mTabSpaceSum(y,valueInHouse.length-2);
		
		return Math.max(a1, a2);
		
	}
	
	public static int mTabSpaceSum(int[] nums,int index)
	{
		int prev = nums[0];
		int prev2 = 0;
		
		int take;
		int not;
		int curr;
	
		
		for (int i=1;i<=index;i++)
		{
			take = nums[i]+ prev2;
			
			 not = prev;
			int r = Math.max(take, not);
			curr = r;
			prev2 = prev;
			prev = curr;
		}
		return prev;
	}

	public static void main(String[] args) {
		
		int[] arr = {1,5,1,2,6};
		
		long ans = houseRobber(arr);
		
		System.out.println(ans);
		
		
		
		

	}

}
