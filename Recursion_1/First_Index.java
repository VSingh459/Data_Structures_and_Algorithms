package tasks;
import java.util.Scanner;

public class First_Index {
	
	public static int indexer(int input[],int x,int startIndex)
	{
		if (startIndex==input.length)
		{
				return -1;
		}
		if (input[startIndex]==x)
		{
			return startIndex;
		}
		
		int bbb = indexer(input,x,startIndex+1);
		
		return bbb;
		
	}
	
	public static int firstIndex(int input[],int x)
	{
		return indexer(input,x,0);
		
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
		
		int bb = firstIndex(arr,ch);
		System.out.println();
		System.out.println(bb);

	}

}
