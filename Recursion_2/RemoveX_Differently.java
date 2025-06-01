package lectures;
import java.util.Scanner;

public class RemoveX_Differently {
	
	public static  String  removeXD(String input)
	{
		if (input.length() == 0)
		{
			return "";
		}
		
		String ans = "";
		
		if (input.charAt(0) != 'x')
		{
			ans = ans + input.charAt(0);
		}
		
		String small = input.substring(1);
		
		ans = ans + removeXD(small);
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = Obj.next();
		
		String aa = removeXD(s);
		System.out.println();
		System.out.println(aa);

	}

}
