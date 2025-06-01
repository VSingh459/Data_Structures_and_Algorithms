package assignments;
import java.util.Scanner;

public class Staircase {
	
	public static int stairW(int n)
	{
		if (n==1)
		{
			return 1;
		}
		if (n==2)
		{
			return 2;
		}
		if (n==3)
		{
			return 4;
		}
		
		int ans = stairW(n-1)+stairW(n-2)+stairW(n-3);
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the No of Stairs");
		int n = Obj.nextInt();
		
		int ways = stairW(n);
		System.out.println();
		System.out.println("Total No of ways possible is = "+ways);
		
	}

}
