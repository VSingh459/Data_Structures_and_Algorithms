package assignments;
import java.util.Scanner;

public class Print_Subset_Sum {

	public static void  printer(int[] input,int k)
	{
		int out[] = new int[0];
		printer22(input,0,k,out);
	}
	
	public static void printer22(int[] input,int si,int sum,int[] output)
	{
			if (sum==0)
			{
			for (int i=0;i<output.length;i++)
			{
				System.out.print(output[i]+" ");
			}
			
			System.out.println();
			return;
			}
			if (si==input.length)
			{
				return;
			}
		
		
		printer22(input,si+1,sum,output);
		
		int newoutput[] = new int[output.length+1];
		
		int k=0;
		
		for (int j=0;j<output.length;j++)
		{
			newoutput[j] = output[j];
			k++;
		}
		
		newoutput[k] = input[si];
		
		printer22(input,si+1,sum-input[si],newoutput);
		
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
		
		printer(arr,sum);
		System.out.println();

	}

}
