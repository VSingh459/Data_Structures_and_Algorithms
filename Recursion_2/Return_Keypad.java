package tasks;
import java.util.Scanner;

public class Return_Keypad {
	
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
	
	public static String[] keypad(int n)
	{
		if (n == 0)
		{ 
			String[] ans = {""};
			return ans;
		}
		
		
		String smallA[] = keypad(n/10);
		
		int pp = n%10;
		String aa[] = code(n%10);
		String ans[] = new String[aa.length*smallA.length];
			
		
		int count=0;
		
		for (int i=0;i<aa.length;i++)
		{
			for (int j=0;j<smallA.length;j++)
			{
				ans[count] = smallA[j] + aa[i];
				count++;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the code");
		int code = Obj.nextInt();
		
		String out[] = keypad(code);
		
		System.out.println();
		for (int i=0;i<out.length;i++)
		{
			System.out.println(out[i]);
		}


	}

}
