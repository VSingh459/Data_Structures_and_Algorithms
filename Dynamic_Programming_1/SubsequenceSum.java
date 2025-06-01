package Dynamic_Programming_1;
import java.util.ArrayList;

public class SubsequenceSum {
	
	public static void printS(int[] arr,int ind,ArrayList<Integer> sub,int gSum,int s)
	{
		if (ind == arr.length)
		{
			if (s==gSum)
			{
				System.out.println(sub);
			}
			return;
		}
		
		sub.add(arr[ind]);
		s = s+arr[ind];
		printS(arr,ind+1,sub,gSum,s);
		
		s = s-arr[ind];
		sub.remove(sub.size()-1);
		printS(arr,ind+1,sub,gSum,s);
		
		
	}

	public static void main(String[] args) {
		
		int[] arr = {1,2,1};
		int sum = 2;
	       
	    ArrayList<Integer> sub = new ArrayList<>();
	    
	    printS(arr,0,sub,sum,0);
	    
	}

}
