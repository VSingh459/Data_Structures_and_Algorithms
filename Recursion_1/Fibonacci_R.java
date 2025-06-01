package lectures;
import java.util.Scanner;

public class Fibonacci_R {
	
	public static int fib(int n)
	{
		int p,k,sum;
		p=0;
		k=1;
		if (n==1)
			return p;
		if (n==2)
			return k;
		
		sum = fib(n-2) + fib(n-1);
		return sum;
		
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = Obj.nextInt();
		
		int ans = fib(n);
		System.out.println();
		System.out.println(ans);
		
	}

}
