package assignments;
import java.util.Scanner;

public class TowerOfHanoi {
	
	public static void  TowerOfHanoi(int disks,char source,char auxiliary,char target)
	{
		if (disks >= 1)
		{
			TowerOfHanoi(disks-1,source,target,auxiliary);
			System.out.println(source+" "+target);
			TowerOfHanoi(disks-1,auxiliary,source,target);
		}
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the number of disks");
		int n = Obj.nextInt();
		
		TowerOfHanoi(n,'a','b','c');
		
	}

}
