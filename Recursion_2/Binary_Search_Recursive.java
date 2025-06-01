package assignments;
import java.util.Scanner;

public class Binary_Search_Recursive {
	
	public static int binary2(int input[],int key,int low,int high)
	{
		if (low > high)
		{
			return -1;
		}
		
		int mid = (low+high)/2;
		
		if (input[mid]==key)
		{
			return mid;
		}
		
		if (key > input[mid])
		{
			return binary2(input,key,mid+1,high);
		}
		
		return binary2(input,key,low,mid-1);
		
		
	}
	
	public static int binary(int input[],int element)
	{
		int ans = binary2(input,element,0,input.length-1);
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the no of elements present in the array");
		int n = Obj.nextInt();
		System.out.println("Enter the elements of the array in increasing order");
		
		int arr[] = new int[n];
		
		for (int i=0;i<n;i++)
		{
			arr[i] = Obj.nextInt();
		}
		
		System.out.println("Enter the element to be searched");
		int el = Obj.nextInt();
		
		int ans = binary(arr,el);
		
		System.out.println();
		System.out.println(ans);

	}

}
