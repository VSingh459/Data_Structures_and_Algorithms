package tasks;
import java.util.Scanner;

public class SumOfArray {
	
	public static int sum(int input[])
	{
		if (input.length <= 1)
		{
			return input[0];
		}
		
		int sm[] = new int[input.length-1];
		for (int i=1;i<input.length;i++)
		{
			sm[i-1] = input[i];
		}
		
		return (sum(sm)+input[0]);
		
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
		
		int ans;
		ans = sum(arr);
		System.out.println();
		System.out.println(ans);

	}

}
