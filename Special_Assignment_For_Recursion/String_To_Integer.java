package assignments;
import java.util.Scanner;

import java.util.Scanner;

public class String_To_Integer {
	
	public static int  strToInt(String input)
	{
		if (input.length() == 1)
		{
			return input.charAt(0) - '0';
		}
		
		String s = input.substring(1);
		
		int y = strToInt(s);
		
		double x = input.charAt(0) - '0';
		
		System.out.println(x);
		
		x = x*Math.pow(10,input.length()-1)+y;
		//System.out.println(x);
		
		return  (int)x;

		
		
	}
	
	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = Obj.next();
		
		int aa = strToInt(s);
		System.out.println();
		System.out.println(aa);

	}

}
