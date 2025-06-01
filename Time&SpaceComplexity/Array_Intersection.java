package assignments;
import java.util.Scanner;
import java.util.*;

public class Array_Intersection {
	
	public static void inter(int arr1[],int[] arr2)
	{
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int j = 0;
		int s=0;
		int i=0;
		
		while (i<arr1.length && j<arr2.length)
		{
			if (arr1[i] == arr2[j])
			{
				System.out.print(arr1[i]+" ");
				j++;
				i++;
			}
			else if (arr1[i] < arr2[j])
			{
				i++;
			}
			else
			{
				j++;
			}
			
		}
		
		System.out.println();	
		
	}

	public static void main(String[] args) {
		
		System.out.println("Enter the number of  Test cases ");
		Scanner Obj = new Scanner(System.in);
		int t = Obj.nextInt();
		int ans;
		
		int count = t;
		
		while (count > 0 )
		{
			System.out.println("Enter the size of the 1st array ");
			int size = Obj.nextInt();
			int aa[] = new int[size];
			System.out.println("Enter the elements of 1st array");
			for (int i=0;i<size;i++)
			{
				aa[i] = Obj.nextInt();
			}
			System.out.println("Enter the size of the 2nd array");
			int size2 = Obj.nextInt();
			int aa2[] = new int[size2];
			System.out.println("Enter the elements of the 2nd array");
			for (int i=0;i<size2;i++)
			{
				aa2[i] = Obj.nextInt();
			}
			
			System.out.println();
			inter(aa,aa2);
			count--;
		}	


	}

}
