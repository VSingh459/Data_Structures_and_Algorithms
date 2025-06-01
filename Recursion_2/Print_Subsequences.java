package lectures;
import java.util.Scanner;

public class Print_Subsequences {
	
	public static void  print_Sub2(String input,String output)
	{
		if (input.length()==0)
		{
			System.out.println(output);
			return;
		}
		
		print_Sub2(input.substring(1),output);
		print_Sub2(input.substring(1),output+input.charAt(0));
		
	}
	
	public static void print_Sub(String input)
	{
		print_Sub2(input,"");
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = Obj.nextLine();
		
		print_Sub(s);

	}

}
