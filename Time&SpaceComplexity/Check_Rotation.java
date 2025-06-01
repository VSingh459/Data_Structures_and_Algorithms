package assignments;
import java.util.Scanner;

public class Check_Rotation {
	
	public static int arrayRot(int arr[])
	{
		if (arr.length==0)
		{
			return 0;
		}
		int count=0;
		int temp = arr[0];
		for (int i=1;i<arr.length;i++)
		{
			if (temp > arr[i])
			{
				count = i;
				temp = arr[i];
				break;
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
			
			 ans = arrayRot(aa);
			System.out.println();
			System.out.println(ans);
			count--;
		}	
	}

}
