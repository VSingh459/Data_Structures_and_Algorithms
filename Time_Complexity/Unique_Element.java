package assignments;
import java.util.Scanner;

public class Unique_Element {
	
	public static int unique(int arr[])
	{
		int uni = arr[0];
		
		for (int i=1;i<arr.length;i++)
		{
			uni = uni^arr[i];	
		}
		
		return uni;	
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int size = Obj.nextInt();
		System.out.println("Enter the elements of the array");
		int arr[] = new int[size];
		for (int i=0;i<size;i++)
		{
			arr[i] = Obj.nextInt();
		}
		
		int uniq = unique(arr);
		System.out.println();
		System.out.println(uniq);

	}

}
