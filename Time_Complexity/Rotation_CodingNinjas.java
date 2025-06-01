package assignments;
import java.util.Scanner;

public class Rotation_CodingNinjas {
	
	private static void swappo(int[] arr,int start,int end)
	{
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	
	private static void reversero(int arr[],int start,int end)
	{
		while(start < end)
		{
			swappo(arr,start,end);
			start++;
			end--;
		}
	}
	
	public static void rotaterro(int arr[],int d)
	{
		if (arr.length==0)
		{
			return;
		}
		
		if (d >=arr.length && arr.length !=0)
		{
			d = d%arr.length;
		}
		
		reversero(arr,0,arr.length-1);
		reversero(arr,0,arr.length-d-1);
		reversero(arr,arr.length-d,arr.length-1);
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
			
			rotaterro(aa,dd);
			
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
