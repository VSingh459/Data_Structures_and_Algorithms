package tasks;
import java.util.Scanner;

public class All_Indices {
	
	public static int[] allIndexes12(int input[],int x,int startIndex,int[] newArr,int newIndex)
	{
		if (startIndex==input.length)
		{
			return newArr;
		}
		if (input[startIndex]==x)
		{
			newArr[newIndex] = startIndex;
			newIndex++;
		}
		
		int bbb[] = allIndexes12(input,x,startIndex+1,newArr,newIndex);
		
		return bbb;
		
	}
	
	public static int[] allIndex(int input[],int x)
	{
		int aa[] = new int[input.length];
		for (int i=0;i<input.length;i++)
		{
			aa[i] = -1;
		}
		int ccc[] = allIndexes12(input,x,0,aa,0);
		int count=0;
		for (int i=0;i<input.length;i++)
		{
			if (ccc[i] != -1)
			{
				count++;
			}
		}
		int ans[] = new int[count];
		for (int i=0;i<count;i++)
		{
			ans[i] = ccc[i];
		}
		
		return ans;
	
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the length of the array");
		int n = Obj.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the elements of the array");
		for (int i=0;i<n;i++)
		{
			arr[i] = Obj.nextInt();
		}
		
		System.out.println("Enter the number to be checked in the array");
		int ch = Obj.nextInt();
		
		int bb[] = allIndex(arr,ch);
		System.out.println();
		for (int i=0;i<bb.length;i++)
		{
			System.out.print(bb[i]+" ");
		}

	}

}
