package assignments;
import java.util.Scanner;

public class Print_Permutations {
	
	public static void permu(String str)
	{
		permu1(str,"");
	}
	
	public static void permu1(String str,String output)
	{
		if (str.length()==0)
		{
			System.out.println(output);
			return;
		}
		
		for (int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			String part1 = str.substring(0, i);
			String part2 = str.substring(i+1);
			String part3 = part1+part2;
			permu1(part3,output+ch);
		}
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = Obj.nextLine();
		
		permu(str);

	}

}
