package lectures;
import java.util.Scanner;

public class SelectionSort_TimeComplexity {
	
	public static void selectionSort(int x[])
	{
		for (int i=0;i<x.length;i++)
		{
			int min = x[i];
			int index = i;
			for (int j=i;j<x.length;j++)
			{
				if (min > x[j])
				{
					min = x[j];
					index = j;
				}
			}
			int temp = x[i];
			x[i] = min;
			x[index] = temp;
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
			
			selectionSort(input);
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken by selection sort for "+n+" is = "+(endTime-startTime));
		}

	}

}
