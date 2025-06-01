package tasks;
import java.util.Scanner;

public class Power123 {
	
	public static int power(int n,int m)
	{
		
		if (m==0)
		{
			return 1;
		}
		int a;
		a = power(n,m-1)*n;
		return a;
	
	}

	public static void main(String[] args) {
		
        Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = Obj.nextInt();
		System.out.println("Enter the value of m");
		int m = Obj.nextInt();
		
		
		int ans = power(n,m);
		System.out.println();
		System.out.println(ans);

	}

}
