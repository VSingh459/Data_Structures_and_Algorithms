package lectures;
import java.util.Scanner;

public class MergeSort_TimeComplexity {
	
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
		
		for (int n=10;n<=10000000;n=n*10)
		{ 
			int input[] = new int[n];
			
			for (int i=0;i<input.length;i++)
			{
				input[i] = input.length-1;
			}
			
			long  startTime = System.currentTimeMillis();
			//System.out.println(System.currentTimeMillis());
			mergeSort2(input,0,input.length-1);
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken by merge sort for "+n+" is = "+(endTime-startTime));
		}
		
	}

}
