package assignments;
import java.util.Scanner;

public class Remove_X {
	
	public static String removeX(String input)
	{
		if (input.length() < 1)
		{
			System.out.println(input);
			return input;
		}
		
		String s = "";
		String out = "";
		
		if (input.charAt(0) == 'x')
		{
			s = input.substring(1);
			out = removeX(s);
			return  out;
		}
		
		s = input.substring(1);
		out =   input.charAt(0) + removeX(s);
		
		return  out;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = Obj.next();
		
		String aa = removeX(s);
		System.out.println();
		System.out.println(aa);

	}

}
