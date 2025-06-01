package Dynamic_Programming_1;
import java.util.ArrayList;

public class SubsequenceCount {
	
	public static int printS(int[] arr,int ind,int gSum,int s)
	{
		if (ind == arr.length)
		{
			if (s==gSum)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		
		s = s+arr[ind];
		int l = printS(arr,ind+1,gSum,s);
		
		s = s-arr[ind];
		int r = printS(arr,ind+1,gSum,s);
		
		return l+r;
	}

	public static void main(String[] args) {
		

		int[] arr = {1,2,1};
		int sum = 2;
	      
	    int ans = printS(arr,0,sum,0);
	    System.out.println(ans);
		
	}

}
