package tasks;
import java.util.Scanner;

public class Print_Keypad {
	
	public static String[] code(int n)
	{
		if (n==2)
		{
			String c[] = {"a","b","c"};
			return c;
		}
		else if (n==3)
		{
			String c[] = {"d","e","f"};
			return c;
		}
		else if (n==4)
		{
			String c[] = {"g","h","i"};
			return c;
		}
		else if (n==5)
		{
			String c[] = {"j","k","l"};
			return c;
		}
		else if (n==6)
		{
			String c[] = {"m","n","o"};
			return c;
		}
		else if (n==7)
		{
			String c[] = {"p","q","r","s"};
			return c;
		}
		else if (n==8)
		{
			String c[] = {"t","u","v"};
			return c;
		}
		else if (n==9)
		{
			String c[] = {"w","x","y","z"};
			return c;
		}
		
		String a[] = {""};
		return a;
	}
	
	public static void print_Key2(int input,String output)
	{
		if (input==0)
		{
			System.out.println(output);
			return;
		}
		
		int p = input%10;
		String cc[] = code(p);
		
		print_Key2(input/10,cc[0]+output);
		print_Key2(input/10,cc[1]+output);
		print_Key2(input/10,cc[2]+output);
		if (p==7 || p==9)
		{
			print_Key2(input/10,cc[3]+output);
		}
		
	}
	
	public static void print_Keypad(int input)
	{
		print_Key2(input,"");
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the code");
		int code = Obj.nextInt();
		
		print_Keypad(code);

	}

}
