package Dynamic_Programming_1;
import java.util.ArrayList;

public class MaxNonAdj {
	
	private static ArrayList<Integer> dp;
	
	public static int mTabSpaceSum(ArrayList<Integer> nums,int index)
	{
		int prev = nums.get(0);
		int prev2 = 0;
		
		int take;
		int not;
		int curr;
	
		
		for (int i=1;i<=index;i++)
		{
			take = nums.get(i)+ prev2;
			
			 not = prev;
			int r = Math.max(take, not);
			curr = r;
			prev2 = prev;
			prev = curr;
		}
		return prev;
	}
	
	public static int maxTabSum(ArrayList<Integer> nums,int index)
	{
		dp.set(0, nums.get(0));
		
		int take;
	
		
		for (int i=1;i<=index;i++)
		{
			if (i>1)
			{
				 take = nums.get(i) + dp.get(i-2);	
			}
			else
			{
				 take = nums.get(i);
			}
			
			int not = dp.get(i-1);
			int r = Math.max(take, not);
			dp.set(i, r);
		}
		return dp.get(index);
	}
		
	
	public static int maxMemoSum(ArrayList<Integer> nums,int index)
	{
		if (index==0)
		{
			return nums.get(index);
		}
		
		if (index < 0)
		{
			return 0;
		}
		
		if (dp.get(index) != -1)
		{
			return dp.get(index);
		}
		
		int s1 =  nums.get(index) + maxMemoSum(nums,index-2);
		
		int s2 = maxMemoSum(nums,index-1);
		
		int max = Math.max(s1, s2);
		dp.set(index, max);
		
		return max;
		
	}
	
	public static int maxSum(ArrayList<Integer> nums,int index)
	{
		if (index==0)
		{
			return nums.get(index);
		}
		
		if (index < 0)
		{
			return 0;
		}
		
		int s1 =  nums.get(index) + maxSum(nums,index-2);
		
		int s2 = maxSum(nums,index-1);
		
		return Math.max(s1, s2);
		
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<>();
//		nums.add(2);
//		nums.add(1);
//	    nums.add(4);
//		nums.add(9);
		
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(1);
		nums.add(3);
		nums.add(5);
		nums.add(8);
		nums.add(1);
		nums.add(9);
		
		dp = new ArrayList<>();
		
//		for (int i=0;i<20;i++)
//		{
//			dp.add(-1);
//		}

		
		
		//int ans = maxSum(nums,nums.size()-1);
		//int ans = maxMemoSum(nums,nums.size()-1);
		//int ans = maxTabSum(nums,8);
		int ans = mTabSpaceSum(nums,8);
		System.out.println(ans);

	}

}
