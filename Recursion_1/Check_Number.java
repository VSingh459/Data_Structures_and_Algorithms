package tasks;
import java.util.Scanner;

public class Check_Number {
	
	public static boolean check123(int input[],int x)
	{
		if (input.length <=1)
		{
			System.out.println("Hello");
			if (input[0]==x)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		if (input[0]==x)
		{
			return true;
		}
		
		int sm[] = new int[input.length-1];
		for (int i=1;i<input.length;i++)
		{
			sm[i-1] = input[i];
		}
		
		boolean ans = check123(sm,x);
		
		return ans;
		
	}
	
	public static boolean checker(int input[],int x)
	{
		if (input.length <=1)
		{
			if (input[0]==x)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		
		int sm[] = new int[input.length-1];
		for (int i=1;i<input.length;i++)
		{
			sm[i-1] = input[i];
		}
		
		boolean ans = checker(sm,x);
		
		if (input[0]==x)
		{
			return ans || true;
		}
		else
		{
			return ans || false;
		}
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the length of the array");
		int n = Obj.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the elements of the array");
		for (int i=0;i<n;i++)
		{
			arr[i] = Obj.nextInt();
		}
		
		System.out.println("Enter the number to be checked in the array");
		int ch = Obj.nextInt();
		
		boolean bb = check123(arr,ch);
		System.out.println();
		System.out.println(bb);

	}

}
