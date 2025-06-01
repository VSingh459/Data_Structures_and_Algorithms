package assignments;
import java.util.Scanner;

public class Replace_Pi {
	
	public static String replace(String input)
	{
		if (input.length() <= 1)
		{
			return input;
		}
		
		String s = "";
		String out = "";
		
		if (input.charAt(0)=='p' && input.charAt(1)=='i')
		{
			 s =  input.substring(2);
			 out = "3.14" + replace(s);
			return   out;
		}
		
		s =  input.substring(1);
		out = input.charAt(0) + replace(s);
		
		return  out;
		
		
	}
	

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = Obj.next();
		
		String aa = replace(s);
		System.out.println();
		System.out.println(aa);

	}

}
