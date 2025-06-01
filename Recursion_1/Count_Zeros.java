package assignment;
import java.util.Scanner;

public class Count_Zeros {
	
	public static int countZerosRec(int input)
	{
		if (input==0)
		{
			return 1;
		}
		if (input/10==0)
		{
			return 0;
		}
		int c=0;
		if (input % 10==0)
		{
			c++;
		}
		int ans = countZerosRec(input/10)+c;
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the required integer");
		int n = Obj.nextInt();
		
		int a = countZerosRec(n);
		System.out.println();
		System.out.println(a);

	}

}
