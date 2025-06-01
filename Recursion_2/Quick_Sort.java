package tasks;
import java.util.Scanner;

public class Quick_Sort {
	
	public static void swap(int arr[],int i,int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public static int partition(int arr[],int left,int right)
	{
		int pivot,start,end;
		pivot = arr[left];
		start = left;
		end = right;
		
		
		while (start < end)
		{
			while ( start < right && arr[start] <= pivot)
			{
				start++;
			}
			while (arr[end] > pivot)
			{
				end--;
			}
			if (start < end)
			{
				swap(arr,start,end);
			}
		}
		
		swap (arr,left,end);
		
		return end;
	}
	
	public static void quickSort(int arr[],int left,int right)
	{
		if (left < right)
		{
			int lock = partition(arr,left,right);
			quickSort(arr,left,lock-1);
			quickSort(arr,lock+1,right);
		}
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the length of the array to be sorted");
		int n = Obj.nextInt();
		System.out.println("Enter the elements of the array");
		int arr[] = new int[n];
		for (int i=0;i<n;i++)
		{
			arr[i] = Obj.nextInt();
		}
		
		System.out.println();
		
		
		quickSort(arr,0,n-1);
		
		for (int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}

	}

}
