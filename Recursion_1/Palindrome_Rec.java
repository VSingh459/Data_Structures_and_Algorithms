package assignment;
import java.util.Scanner;

public class Palindrome_Rec {
	
	public static boolean isPal2(String input,int startIndex,String r)
	{
		if (startIndex==input.length())
		{
			boolean comp = input.equals(r);
			return comp;
		}
		
		r = input.charAt(startIndex) + r;
		
		boolean ans = isPal2(input,startIndex+1,r);
		
		return ans;
		
	}
	
	
	public static boolean isPal(String input)
	{
		String r = "";
		return isPal2(input,0,r);
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = Obj.next();
		
		boolean b = isPal(s);
		System.out.println();
		System.out.println(b);
		
	}

}
