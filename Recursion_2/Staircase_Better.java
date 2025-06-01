package assignments;
import java.util.Scanner;

public class Staircase_Better {
	
	public static int stair2(int n)
	{
		if (n==0)
		{
			return 1;
		}
		else if (n < 0)
		{
			return 0;
		}
		 
		int ans = stair2(n-3) + stair2(n-2) + stair2(n-1);
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the No of Stairs");
		int n = Obj.nextInt();
		
		int ways = stair2(n);
		System.out.println();
		System.out.println("Total No of ways possible is = "+ways);

	}

}
