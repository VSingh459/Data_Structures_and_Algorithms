package tasks;
import java.util.Scanner;

public class Print_Numbers {
	
	public static void print(int n)
	{
		if (n > 0)
		{
			print(n-1);
			System.out.print(n+" ");
		}
		
		return;
	}

	public static void main(String[] args) {
		
        Scanner Obj = new Scanner(System.in);
		
		System.out.println("Enter the value of n");
		int n = Obj.nextInt();
		print(n);
		

	}

}
