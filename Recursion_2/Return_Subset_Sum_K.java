package assignments;
import java.util.Scanner;

public class Return_Subset_Sum_K {
	
	public static int[][] sub_Sum(int input[],int k)
	{
		int ans[][] = sub_Sum2(input,0,k);
		return ans;
	}
	
	public static int[][] sub_Sum2(int input[],int si,int sum)
	{
		if (sum==0)
		{
			int ans[][] = new int[1][0];
			return ans;
		}
		if (si >= input.length)
		{
			int aa[][] = new int[0][0];
			return aa;
		}
		
		int n1[][] =  sub_Sum2(input,si+1,sum-input[si]);
		int n2[][] = sub_Sum2(input,si+1,sum);
		
		
		int ans[][] = new int[n2.length+n1.length][];
		//System.out.println( "length of row ans ="+ans.length);
		
		int count=0;
		
		//if (n1!=null)
		//{
			for (int i=0;i<n1.length;i++)
			{
				int temp[] = new int[n1[i].length+1];
				temp[0] = input[si];
				int s=1;
				for (int j=0;j<n1[i].length;j++)
				{
					temp[s] = n1[i][j];
					s++;
				}
				ans[count] = temp;
				System.out.println(ans.length);
				count++;
			}
		//}
		
		//if (n2!=null)
		//{
			for (int i=0;i<n2.length;i++)
			{
				int temper[] = new int[n2[i].length];
				int sss=0;
				for (int j=0;j<n2[i].length;j++)
				{
					temper[sss] = n2[i][j];
					sss++;
				}
				ans[count] = temper;
				count++;
			}
		//}
		
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
		
		System.out.println("Enter the sum");
		int sum = Obj.nextInt();
		
		int real[][] = sub_Sum(arr,sum);
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
