package assignment;
import java.util.Scanner;

public class SumOf_Digits {
	
	public static int sumOfDigits(int input)
	{
		if (input/10==0)
		{
			return input;
		}
		
		int a = input%10;
		int ans = sumOfDigits(input/10)+a;
		return ans;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the integer");
		int n = Obj.nextInt();
		
		int ans = sumOfDigits(n);
		System.out.println();
		System.out.println(ans);
		
	}

}
