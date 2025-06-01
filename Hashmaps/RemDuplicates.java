package hashmaps;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.*;

public class RemDuplicates {
	
	public static ArrayList<Integer>  remDuplicates(int[] arr)
	{
		ArrayList<Integer> output = new ArrayList<>();
		HashMap<Integer,Boolean> map = new HashMap<>();
		
		for (int i=0;i<arr.length;i++)
		{
			if (map.containsKey(arr[i]))
			{
				continue;
			}
			
			output.add(arr[i]);
			map.put(arr[i], true);
		}
		
		return output;
	}
	
	public static int  maxFreq(int[] arr)
	{
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for (int i=0;i<arr.length;i++)
		{
			if (map.containsKey(arr[i]))
			{
				int a = map.get(arr[i]);
				a = a+1;
				map.put(arr[i], a);
			}
			else
			{
				map.put(arr[i], 1);	
			}
			
			
		}
		
		int max=0;
        int maxKey=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
       
        {
            if(map.get(arr[i])>max){
                max=map.get(arr[i]);
                maxKey=arr[i];}
        }
     


        return maxKey ;
		
	}
	
	

	public static void main(String[] args) {
		
//		int[] arr = {1,3,2,2,3,1,6,2,5};
//		
//		ArrayList<Integer> out = remDuplicates(arr);
//		System.out.println(out);
		
		int[] a = {2,12,2,11,12,2,1,2,2,11,12,2,6};
		
		int ans = maxFreq(a);
		System.out.println(ans);

	}

}
