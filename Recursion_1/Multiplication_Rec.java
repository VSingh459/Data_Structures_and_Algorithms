package assignment;
import java.util.Scanner;

public class Multiplication_Rec {
	
	public static int mult2Int(int m,int n)
	{
		if (n==0)
		{
			return 0;
		}
		int ans;
		ans = mult2Int(m,n-1)+m;
		return ans;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj =  new Scanner(System.in);
		System.out.println("Enter the value of M ");
			int m = Obj.nextInt();
		System.out.println("Enter the value of N ");
		int n = Obj.nextInt();
		
		int b = mult2Int(m,n);
		System.out.println();
		System.out.println(b);

	}

}
