package assignments;
import java.util.*;

public class Pair_SumArray {
	
	
	public static int pair(int arr[],int sum)
	{
		if (arr.length==0)
		{
			return 0;
		}
		Arrays.sort(arr);
		
		int count=0;
		int i=0;
		int j=arr.length-1;
		
		int max=arr[0];
		
		for (int k=1;k<arr.length;k++)
		{
			if (max < arr[k])
			{
				max = arr[k];
			}
		}
		
		int m[] = new int[max+1];
		
		for (int k=0;k<arr.length;k++)
		{
			int p = arr[k];
			m[p] = m[p]+1;
		}
		
		
		while(i < j)
		{
			if (arr[i]+arr[j]==sum)
			{
				if (arr[i] != arr[j])
				{
					count = count + m[arr[i]]*m[arr[j]];
					i = i+m[arr[i]];
					j = j-m[arr[j]];
				}
				
				else
				{
					count = count + m[arr[i]]+m[arr[j]];
					i = i+m[arr[i]]-1;
					j = j - m[arr[j]] +1;
				}
				
			}
			else if (arr[i]+arr[j] < sum)
			{
				i++;
			}
			else if (arr[i]+arr[j] > sum)
			{
				j--;
			}
		}
		
		return count;	
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
			
			ans = pair(aa,s);
			System.out.println();
			System.out.print(ans);
			count--;
		}	

	}

}
