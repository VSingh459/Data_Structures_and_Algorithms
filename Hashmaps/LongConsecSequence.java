package hashmaps;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

public class LongConsecSequence {
	
	public static ArrayList<Integer> longConsecIncrSeq(int[] arr)
	{
		HashMap<Integer,Boolean> map = new  HashMap<>();
		ArrayList<Integer> out = new ArrayList<>();
		
		for (int i=0;i<arr.length;i++)
		{
			map.put(arr[i], true);
		}
		
		int  maxL = 0;
		int start = 0;
		
		
		
		for (int i=0;i<arr.length;i++)
		{
			if (map.get(arr[i]))
			{
				int size = 0;
				int f = arr[i];
				
				while (map.containsKey(f))
				{
					map.put(f, false);
					size++;
					f++;
				}
				
			
				f = arr[i]-1;
				int sTemp = arr[i];
				
				while (map.containsKey(f))
				{
					map.put(f, false);
					sTemp = f;
					size++;
					f--;
				}
				
				if (size > maxL)
				{
					maxL = size;
					start = sTemp;
					
				}
				else if (size == maxL)
				{
					maxL = size;
					for (int j=0;j<arr.length;j++)
					{
						if (arr[j] == start)
						{
							start = start;
							break;
						}
						else if (arr[j] == sTemp)
						{
							start = sTemp;
							break;
						}
					
					}
					
				}
				
			}
		}
		
		out.add(start);
		out.add(start+maxL-1);
		
		return out;
		
		
	}

	public static void main(String[] args) {
		
		int[] pro = {15,24,23,12,19,11,16};
		
		ArrayList<Integer> ans = longConsecIncrSeq(pro);
		
		System.out.println(ans);
		
		

	}

}
