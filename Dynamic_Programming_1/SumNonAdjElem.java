package Dynamic_Programming_1;
import java.util.ArrayList;

public class SumNonAdjElem {
	
	private static ArrayList<Integer> dp;
	
	public static int memoSum(ArrayList<Integer> nums,int index)
	{
		if (index >= nums.size())
		{
			return 0;
		}
		
		if (dp.get(index) != -1)
		{
			return dp.get(index);
		}
		
		int temp = Math.max(memoSum(nums,index+1),nums.get(index)+memoSum(nums,index+2));
		dp.set(index, temp);
		
		return dp.get(index);
	}
	
	public static int maxNonAdjSum(ArrayList<Integer> nums,int index,int N)
	{
		if (index >= N)
		{
			return 0;
		}
		
		
		return Math.max(nums.get(index)+maxNonAdjSum(nums,index+2,N),maxNonAdjSum(nums,index+1,N));
	}
	
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums)
	{
		return maxNonAdjSum(nums,0,nums.size());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
