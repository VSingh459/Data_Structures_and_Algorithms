package assignments;
import java.util.Scanner;

public class PairStar {
	
	public static  String  addStars(String s)
	{
		if (s.length() == 1)
		{
			return  s;
		}
		
		String s2 = "";
		String out = "";
		
		
		
		if (s.charAt(0) == s.charAt(1))
		{
			s2 = s.substring(1);
			out = s.charAt(0) + "*" + addStars(s2);
			return out;
		}
		
		s2 = s.substring(1);
		out = s.charAt(0) + addStars(s2);
		
		return out;
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = Obj.next();
		
		String aa = addStars(s);
		System.out.println();
		System.out.println(aa);


	}

}
