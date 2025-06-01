package lectures;
import java.util.Scanner;

public class Check_Array {
	
	public static boolean  check_Sorted(int a[])
	{
		if (a.length <=1)
		{
			return true;
		}
		
		int sm[] = new int[a.length-1];
		for (int i=1;i<a.length;i++)
		{
			sm[i-1] = a[i];
		}
		
		boolean ans;
		ans = check_Sorted(sm);
		
		if (!ans)
		{
			return false;
		}
		if (a[0] < a[1])
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static boolean  check_Sorted2(int a[])
	{
		if (a.length <=1)
		{
			return true;
		}
		
		if (a[0] > a[1])
		{
			return false;
		}
		
		int sm[] = new int[a.length-1];
		for (int i=1;i<a.length;i++)
		{
			sm[i-1] = a[i];
		}
		
		boolean ans;
		ans = check_Sorted2(sm);
		
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
		boolean b;
		b = check_Sorted(arr);
		System.out.println();
		System.out.println(b);
		
	}

}
