package tasks;
import java.util.Scanner;

public class NoOf_Digits {
	
	public static int digits(int n)
	{
		if (n/10 == 0)
		{
			return 1;
		}
		int a = digits(n/10);
		return 1+a;
		
		
	}

	public static void main(String[] args) {
		
        Scanner Obj = new Scanner(System.in);
		
		System.out.println("Enter the value of n");
		int n = Obj.nextInt();
		int a;
		a = digits(n);
		System.out.println(a);
		

	}

}
