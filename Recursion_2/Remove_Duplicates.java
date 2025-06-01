package tasks;
import java.util.Scanner;

public class Remove_Duplicates {
	
	public static String removeDupli(String s)
	{
		if (s.length() == 1)
		{
			String r = "";
			r = r+s.charAt(0);
			return  r;
		}
		
		String out = "";
		String small = "";
		
		if (s.charAt(0) == s.charAt(1))
		{
			small = s.substring(1);
			out = removeDupli(small);
			return out;
		}
		
		small = s.substring(1);
		out = s.charAt(0) + removeDupli(small);
		
		return out;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = Obj.next();
		
		String aa =  removeDupli(s);
		System.out.println();
		System.out.println(aa);
		
	}

}
