package lectures;
import java.util.Scanner;

public class Merge_Sort {
	
	public static void merge(int arr[],int left,int mid,int right)
	{
		System.out.println("Hello");
	
		int n1 = mid-left+1;
		int n2 = right-mid;
		
		int LL[] = new int[n1];
		int RR[] = new int[n2];
		
		for (int i=0;i<n1;++i)
		{
			LL[i] = arr[left+i];
		}
		for (int j=0;j<n2;++j)
		{
			RR[j] = arr[mid+1+j];
		}
		
		int i,j,k;
		i = 0;
		j = 0;
		k = left;
		
		while (i < n1 && j < n2)
		{
			if (LL[i] <= RR[j])
			{
				arr[k] = LL[i];
				i++;
			}
			else 
			{
				arr[k] = RR[j];
				j++;
			}
			k++;
		}
		
		while(i<n1)
		{
			arr[k] = LL[i];
			i++;
			k++;
		}
		
		while(j<n2)
		{
			arr[k] = RR[j];
			j++;
			k++;
		}
	}
	
	public static void mergeSort(int arr[],int left,int right)
	{
		if (left < right)
		{
			int mid = (left + right)/2;
		
		
		mergeSort(arr,left,mid);
		mergeSort(arr,mid+1,right);
		
		merge(arr,left,mid,right);
		
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
		
		
		mergeSort(arr,0,n-1);
		
		for (int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

}
