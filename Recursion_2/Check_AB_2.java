package assignments;
import java.util.Scanner;

public class Check_AB_2 {
	
	public static boolean checkAB2(String input)
	{
		if (input.length()==0)
		{
			return true;
		}
		
		String s="";
		String p="";
		
		if (input.charAt(0)=='a')
		{
			s = input.substring(1);
			if (s.length() > 1 && input.charAt(1)=='b' && input.charAt(2)=='b')
			{
				//System.out.println("HHH");
				s = input.substring(3);
				//System.out.println(s);
				return checkAB2(s);
			}
			else
			{
				s = input.substring(1);
				return checkAB2(s);
			}
		}
		else
		{
			return false;
		}
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the string");
		String s  = Obj.nextLine();
		
		boolean bb = checkAB2(s);
		System.out.println();
		System.out.println(bb);

	}

}
