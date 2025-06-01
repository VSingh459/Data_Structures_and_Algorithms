package assignments;
import java.util.Scanner;

public class Rotation_Array {
	
	public static void rotate(int arr[],int d)
	{
		if (arr.length==0)
		{
			return;
		}
		int dd = d%arr.length;
		System.out.println(dd);
		int k=0;
		int temp=0;
		for (int i=arr.length-1;i>=arr.length/2;i--)
		{
			temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
			k++;
		}
		
		 k=0;
		temp=0;
		for (int i=arr.length-1-dd;i>=(arr.length-dd)/2;i--)
		{
			temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
			k++;
		}
		
		k=arr.length-dd;
		temp=0;
		int diff=0;
	    diff = (arr.length-dd+arr.length-1)/2;
		
		for (int i=arr.length-1;i>diff;i--)
		{
			System.out.println("HH");
			temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
			k++;
		}
		
	}

	public static void main(String[] args) {
		
		System.out.println("Enter the number of  Test cases ");
		Scanner Obj = new Scanner(System.in);
		int t = Obj.nextInt();
		int ans;
		
		int count = t;
		
		while (count > 0 )
		{
			System.out.println("Enter the size of the array ");
			int size = Obj.nextInt();
			int aa[] = new int[size];
			System.out.println("Enter the elements of array");
			for (int i=0;i<size;i++)
			{
				aa[i] = Obj.nextInt();
			}
			
			System.out.println("Enter number of elements which should be rotated");
			int dd = Obj.nextInt();
			
			rotate(aa,dd);
			
			System.out.println();
			for (int i=0;i<aa.length;i++)
			{
				System.out.print(aa[i]+" ");
			}
			System.out.println();
			count--;
		}	

	}

}
