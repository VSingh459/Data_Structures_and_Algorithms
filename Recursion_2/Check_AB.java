package assignments;
import java.util.Scanner;

public class Check_AB {
	
	public static boolean checkAB(String input)
	{
		if (input.charAt(0) !='a')
		{
			return false;
		}
		
		String s="";
		
		if (input.charAt(0)=='a')
		{
			if (input.charAt(1)=='a')
			{
				System.out.println("HHH");
				s = input.substring(1);
				return checkAB(s);
			}
			 if (input.charAt(1)=='a' || input.charAt(1)=='\0')
			{
				return true;
				
			}
			 if (input.charAt(1)=='b' && input.charAt(2)=='b')
			{
				if (input.charAt(3)=='a' || input.charAt(3)=='\0')
				{
					return true;
				}
			}
		}
		
	    s = input.substring(1);
			
		checkAB(s);
		
		return false;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the string");
		String s  = Obj.nextLine();
		
		boolean bb = checkAB(s);
		System.out.println();
		System.out.println(bb);
		

	}

}
