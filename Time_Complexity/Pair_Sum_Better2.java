package assignments;
import java.util.Arrays;
import java.util.Scanner;

public class Pair_Sum_Better2 {
	
	public static int tripletSum(int arr[],int num)
	{
		Arrays.sort(arr);
		int n = arr.length;
		
		int numTriplets = 0;
		
		for (int i=0;i<n;i++)
		{
			int pairSumFor = num - arr[i];
			int numPairs = pairSum(arr,(i+1),(n-1),pairSumFor);
			
			numTriplets = numTriplets+numPairs;
		}
		return numTriplets;
	}
	
	public static int pairSum(int[] arr,int startIndex,int endIndex,int num)
	{
		int numPair = 0;
		
		while (startIndex < endIndex)
		{
			if (arr[startIndex]+arr[endIndex] < num)
			{
				startIndex++;
			}
			else if (arr[startIndex]+arr[endIndex] > num)
			{
				endIndex--;
			}
			else
			{
				int elementAtStart = arr[startIndex];
				int elementAtEnd = arr[endIndex];
				
				if (elementAtStart==elementAtEnd)
				{
					int totalElementsFromStartToEnd = (endIndex-startIndex)+1;
					numPair = numPair + (totalElementsFromStartToEnd*(totalElementsFromStartToEnd-1)/2);
					
					return numPair;
				}
				
				int tempStartIndex = startIndex+1;
				int tempEndIndex = endIndex-1;
				
				while (tempStartIndex <= tempEndIndex && arr[tempStartIndex]== elementAtStart)
				{
					tempStartIndex++;
				}
				
				while (tempEndIndex >= tempStartIndex && arr[tempEndIndex]  == elementAtStart)
				{
					tempEndIndex--;
				}
				
				int totalElementsFromStart = (tempStartIndex-startIndex);
				int totalElementsFromEnd = (endIndex-tempEndIndex);
				
				numPair = numPair + (totalElementsFromStart*totalElementsFromEnd);
				
				startIndex = tempStartIndex;
				endIndex = tempEndIndex;
			}
		}
		return numPair;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter the number of  Test cases ");
		Scanner Obj = new Scanner(System.in);
		int t = Obj.nextInt();
		int ans;
		
		int count = t;
		
		while (count > 0 )
		{
			System.out.println("Enter the size of the array ");
			int size = Obj.nextInt();
			int aa[] = new int[size];
			System.out.println("Enter the elements of array");
			for (int i=0;i<size;i++)
			{
				aa[i] = Obj.nextInt();
			}
			
			System.out.println("Enter the the sum");
			int s = Obj.nextInt();
			
			ans = tripletSum(aa,s);
			System.out.println();
			System.out.print(ans);
			count--;
		}	

	}

}
