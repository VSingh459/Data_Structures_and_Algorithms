package tasks;
import java.util.Scanner;

public class replace_Character {
	
	public static String replaceChar(String input,char c1,char c2)
	{
		System.out.println(input);
		if (input.length() == 0)
		{
			return "";
		}
		
		String output = "";
		String s = "";
		
		if (input.charAt(0) == c1)
		{
			s = input.substring(1);
			output = c2 + replaceChar(s,c1,c2);
			return output;
		}
		
		 s = input.substring(1);
		
		output = input.charAt(0) + replaceChar(s,c1,c2);
		
		return output;
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = Obj.next();
		System.out.println("Enter the required characters");
		char a = Obj.next().charAt(0);
		char b = Obj.next().charAt(0);
		
		String aa = replaceChar(s,a,b);
		
		System.out.println();
		System.out.println(aa);

	}

}
