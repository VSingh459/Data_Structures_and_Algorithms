package priority_Queues_2;
import java.util.ArrayList;

public class Inplace {
	
	public static void  inplaceHeapSort(int arr[])
	{
		int x=0;
		int nl = arr.length/2-1;
		int ind=nl;
		int left = nl*2+1;
		int right = nl*2+2;
		while (nl >= 0)
		{
			int p = nl;
			ind = p;
			left = p*2+1;
			right = p*2+2;
			
			while (left < arr.length)
			{
				if (arr[p] > arr[left])
				{
					ind = left;
				}
				if ( right < arr.length && arr[right] < arr[ind])
				{
					ind = right;
				}
				//System.out.println(ind);
				if (ind == p)
				{
					//System.out.println("Break= "+ p);
					break;
				}
				else
				{
					int temp = arr[p];
					arr[p] = arr[ind];
					arr[ind] = temp;
					p = ind;
					left = p*2+1;
					right = p*2+2;
				}
				
			}
			nl = nl-1;		
		}
			
		// Remove Minimum
		
		int count = arr.length-1;
		
		while (count > 0)
		{
			int temp = arr[0];
			
			arr[0] = arr[count];
			arr[count] = temp;
			
			
			int p = 0;
			int min = 0;
			left = 1;
			right = 2;
			
			while (left < count)
			{
				if (arr[left] < arr[min])
				{
					min = left;
				}
				if (right < count && arr[right] < arr[min])
				{
					min = right;
				}
				if (min == p)
				{
					break;
				}
				else
				{
					int temp1 = arr[p];
					arr[p] = arr[min];
					arr[min] = temp1;
					p = min;
					left = p*2+1;
					right = p*2+2;
				}
			}
			count--;
			
		}
		
		
		
	}
	
	public static void print(int arr[])
	{
		for (int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		int[] a = {1,2,3,4,5,6};
		inplaceHeapSort(a);
		print(a);
	}

}
