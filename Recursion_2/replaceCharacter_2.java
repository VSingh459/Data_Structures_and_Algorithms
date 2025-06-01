package tasks;

import java.util.Scanner;

public class replaceCharacter_2 {
	
	public static String  replaceChar_2(String input,char c1,char c2)
	{
		if (input.length() == 0)
		{
			return "";
		}
		
		char c;
		
		if (input.charAt(0) == c1)
		{
			c = c2;
		}
		else
		{
			c = input.charAt(0);
		}
		
		String out = "";
		
		String s = input.substring(1);
		
		out = out + c + replaceChar_2(s,c1,c2);
		
		return out;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = Obj.next();
		System.out.println("Enter the required characters");
		char a = Obj.next().charAt(0);
		char b = Obj.next().charAt(0);
		
		String aa = replaceChar_2(s,a,b);
		
		System.out.println();
		System.out.println(aa);

	}

}
