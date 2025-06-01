package tasks;
import java.util.Scanner;

public class Last_Index {
	
	public static int  Lindex(int input[],int x,int startIndex)
	{
		if (startIndex==input.length-1)
		{
			if (input[startIndex]==x)
			{
				return startIndex;
			}
			else
			{
				return -1;
			}
		}
		
		int bbb = Lindex(input,x,startIndex+1);
		
		//System.out.println(startIndex);
		
		if (bbb == -1 && input[startIndex]==x)
		{
			return startIndex;
		}
		else if (bbb != -1)
		{
			return  bbb;
		}
		else
		{
			return -1;
		}
		
	}
	
	public static int lastIndex(int input[],int x)
	{
		return Lindex(input,x,0);
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
		
		int bb = lastIndex(arr,ch);
		System.out.println();
		System.out.println(bb);

	}

}
