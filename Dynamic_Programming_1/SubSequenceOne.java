package Dynamic_Programming_1;

import java.util.ArrayList;

public class SubSequenceOne {
	
	public static boolean printS(int[] arr,int ind,ArrayList<Integer> sub,int gSum,int s)
	{
		if (ind == arr.length)
		{
			if (s==gSum)
			{
				System.out.println(sub);
				return true;
			}
			else
			{
				return false;
			}
		}
		
		
		sub.add(arr[ind]);
		s = s+arr[ind];
		if (printS(arr,ind+1,sub,gSum,s)==true)
		{
			return true;
		}
		
		s = s-arr[ind];
		sub.remove(sub.size()-1);
		if (printS(arr,ind+1,sub,gSum,s)==true)
		{
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		int[] arr = {1,2,1};
		int sum = 2;
	       
	    ArrayList<Integer> sub = new ArrayList<>();
	    
	    printS(arr,0,sub,sum,0);

	}

}
