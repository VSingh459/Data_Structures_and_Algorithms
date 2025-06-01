package lectures;
import java.util.Scanner;

public class CheckArray_Better {
	
	public static boolean checkBetter(int input[],int startindex)
	{
		if (startindex == input.length-1)
		{
			return true;
		}
		
		if (input[startindex] > input[startindex+1])
		{
			return false;
		}
		
		boolean ans = checkBetter(input,startindex+1);
		
		return ans;
	}
	
	public static boolean checkBB(int input[])
	{
		return checkBetter(input,0);
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
		
		boolean bb = checkBB(arr);
		System.out.println();
		System.out.println(bb);

	}

}
