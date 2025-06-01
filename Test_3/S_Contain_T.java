package problems;
import java.util.Scanner;

public class S_Contain_T {
	
	public static boolean checkSequence(String a,String b)
	{
		if (b.length()==0)
		{
			return true;
		}
		if (a.length()==0)
		{
			return false;
		}
		
		if (a.charAt(0)==b.charAt(0))
		{
			a = a.substring(1);
			b = b.substring(1);
		}
		else
		{
			a = a.substring(1);
		}
		
		boolean ans = checkSequence(a,b);
		
		return ans;
		
	}
	
	

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the 1st String");
		String s = Obj.next();
		System.out.println("Enter the 2nd string");
		String s2 = Obj.next();
		
		boolean a = checkSequence(s,s2);
		
		System.out.println();
		System.out.println(a);

	}

}
