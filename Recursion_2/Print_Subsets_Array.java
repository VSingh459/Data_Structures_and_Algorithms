package assignments;
import java.util.Scanner;

public class Print_Subsets_Array {
	
	public static void printSubsets(int input[])
	{
		int out[] = new int[0];
		printS2(input,0,out);
	}
	
	public static void printS2(int input[],int si,int output[])
	{
		if (si==input.length)
		{
			for (int i=0;i<output.length;i++)
			{
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		printS2(input,si+1,output);
		
		int newoutput[] = new int[output.length+1];
		
		int k=0;
		
		for (int j=0;j<output.length;j++)
		{
			newoutput[j] = output[j];
			k++;
		}
		
		newoutput[k] = input[si];
		
		printS2(input,si+1,newoutput);
		
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
		
		printSubsets(arr);

	}

}
