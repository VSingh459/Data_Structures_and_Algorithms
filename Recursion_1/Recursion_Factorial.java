package lectures;
import java.util.Scanner;

public class Recursion_Factorial {
	
	public static int fact(int n)
	{
		if (n==0)
		{
			return 1;
		}
		
		int small = fact(n-1);
		return n*small;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		
		System.out.println("Enter the integer whose factorial is to be calculated");
		int n = Obj.nextInt();
		int ans = fact(n);
		System.out.println(ans);

	}

}
