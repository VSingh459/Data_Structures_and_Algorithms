package hashmaps;
import java.util.HashMap;
import java.util.ArrayList;

public class SubArrayZero {
	
	public static int longestSubAZero(int[] arr)
	{
		HashMap<Integer,Integer> map = new HashMap<>();
		int sum = 0;
		int maxLength = 0;
		
		for (int i=0;i<arr.length;i++)
		{
			sum = sum+arr[i];
			if (sum == 0)
			{
				maxLength = i+1;
			}
			
			Integer prev = map.get(sum);
			
			if (prev != null)
			{
				maxLength = Math.max(maxLength, i-prev);
			}
			else
			{
				map.put(sum, i);
			}
			
				
		}
		
		return maxLength;
		
		
	}

	public static void main(String[] args) {
		
		int[] a = {6,3,-1,2,-4,3,1,-2,20};
		
		int ans = longestSubAZero(a);
		System.out.println(ans);
		
		

	}

}
