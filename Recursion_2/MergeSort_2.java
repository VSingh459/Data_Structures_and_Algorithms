package lectures;
import java.util.Scanner;

public class MergeSort_2 {
	
	public static void merge2(int arr[],int left,int mid,int right)
	{
	
		int i,j,k;
		i = left;
		j = mid+1;
		k = 0;
		int n = right-left+1;
		
		int bb[] = new int[n];
		
		while (i <= mid && j <= right)
		{
			if (arr[i] <= arr[j])
			{
				bb[k] = arr[i];
				i++;
			}
			else
			{
				bb[k] = arr[j];
				j++;
			}
			k++;
		}
		
		while(i < mid+1)
		{
			bb[k] = arr[i];
			k++;
			i++;
		}
		
		while (j <= right)
		{
			bb[k] = arr[j];
			j++;
			k++;
		}
		
		k=0;
		
		for (int m=left;m<left+n;m++)
		{
			arr[m] = bb[k];
			k++;
		}
		
	}
	
	public static void mergeSort2(int arr[],int left,int right)
	{
		if (left < right)
		{
			int mid = (left + right)/2;
		
		
		mergeSort2(arr,left,mid);
		mergeSort2(arr,mid+1,right);
		
		merge2(arr,left,mid,right);
		
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
//		
		
		
		mergeSort2(arr,0,n-1);
		
		for (int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}

	}

}
