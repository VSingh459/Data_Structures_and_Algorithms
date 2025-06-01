package assignments;
import java.util.Scanner;

public class DuplicateINARRAY {
	
	public static int dupli(int[] arr)
	{
		int s = (arr.length-2);
		int s1 = s*(s+1);
		int sum = s1/2;
		
		int tot=0;
		for (int i=0;i<arr.length;i++)
		{
			tot = tot+arr[i];
		}
		
		int d = tot-sum;
		
		return d;
		
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
			
			ans = dupli(aa);
			System.out.println();
			System.out.print(ans);
			count--;
		}	

	}

}
