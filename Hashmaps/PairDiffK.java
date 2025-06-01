package hashmaps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class PairDiffK {
	
	public static int getPairsWithDifferenceK(int[] arr,int k)
	{
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for (int i=0;i<arr.length;i++)
		{
			if (!map.containsKey(arr[i]))
			{
				map.put(arr[i], 1);
			}
			else
			{
				int  oldFreq = map.get(arr[i]);
				map.put(arr[i], oldFreq+1);
			}
		}
			
		
		int count = 0;
		
		if (k==0)
		{
			Set<Integer> kk = map.keySet();
			for (Integer s:kk)
			{
				if (map.get(s) >=2 )
				{
					int f = map.get(s);
					int f1 = map.get(s)-1;
					count = (f*f1)/2;
				}
			}
			
		}
		else
		{
			Set<Integer> key = map.keySet();
			for (Integer s:key)
			{
				int d = k+s;
				if (map.containsKey(d) && map.get(s) != 0)
				{
					int z = map.get(s)*map.get(d);
					count = count + z;
				}
				
				int d1 = s-k;
				
				if (map.containsKey(d1) && map.get(s) != 0)
				{
					int z = map.get(s)*map.get(d1);
					count = count + z;
				}
				
				map.put(s, 0);
			}
			
		}
		
		
		
		return count;
		
	}

	public static void main(String[] args) {
		
		int[] a = {4,4,4,4};
		int ans = getPairsWithDifferenceK(a,0);
		System.out.println(ans);

	}

}
