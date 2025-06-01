package assignments;
import java.util.Scanner;

import java.util.Scanner;

public class Return_Subset_Array {
	
	public static int[][] subsets(int input[])
	{
		int ans[][] = subsets2(input,0);
		return ans;
	}
	
	public static int[][] subsets2(int input[],int si)
	{
		if (si==input.length)
		{
			int ans[][] = new int[1][0];
			return ans;
		}
		
		int smallA[][] = subsets2(input,si+1);
		
		int ans[][] = new int[(smallA.length)*2][];
		
		for (int i=0;i<smallA.length;++i)
		{
			ans[i] = smallA[i];
		}
		
		for (int i=0;i<smallA.length;++i)
		{
			ans[i+smallA.length] = new int[smallA[i].length+1];
		}
		
		for (int i=0;i<smallA.length;++i)
		{
			for (int j=0;j<ans[i+smallA.length].length;++j)
			{
				if (j==0)
				{
					ans[i+smallA.length][j] = input[si];
				}
				else
				{
					ans[i+smallA.length][j] = smallA[i][j-1];
				}
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the no of elements present in the array");
		int n = Obj.nextInt();
		System.out.println("Enter the elements of the array");
		
		int arr[] = new int[n];
		
		for (int i=0;i<n;i++)
		{
			arr[i] = Obj.nextInt();
		}
		
		int real[][] = subsets(arr);
		System.out.println();
		
		for (int i=0;i<real.length;i++)
		{
			for (int j=0;j<real[i].length;j++)
			{
				System.out.print(real[i][j]+" ");
			}
			System.out.println();
			
		}

	}

}
