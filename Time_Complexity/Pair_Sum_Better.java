package assignments;
import java.util.*;

public class Pair_Sum_Better {
	
	public static int pair2(int arr[],int sum)
	{
		if (arr.length==0)
		{
			return 0;
		}
		Arrays.sort(arr);
		
		System.out.println();
		int count=0;
		int i=0;
		int j=arr.length-1;
		int cc=0;
		int flag=0;
		
		
		while(i < j)
		{
			if (arr[i]+arr[j]==sum)
			{
				//System.out.println(arr[i]+" "+arr[j]);
					count++;
					if (arr[j] != arr[j-1])
					{
						i++;
						if (arr[i]==arr[i-1])
						{
							flag=1;
						}
					}
					else
					{
						cc++;
					}
					j--;
					
			}
			else if (arr[i]+arr[j] < sum)
			{
				i++;
			}
			else if (arr[i]+arr[j] > sum)
			{
				j--;
			}
			
			if (i==j && arr[i]==arr[j+1])
			{
				i++;
				j=arr.length-1;
			}
			if (i>0 && arr[i]==arr[i-1] && flag==1)
			{
				j = j+cc+1;
				flag=0;
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
			
			ans = pair2(aa,s);
			System.out.println();
			System.out.print(ans);
			count--;
		}	


	}

}
