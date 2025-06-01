package assignments;
import java.util.Scanner;

public class ReturnAllCodes_String {
	
	public static char getChar(int n)
	{
		return (char)(96+n);
	}
	
	public static String[] getCode(String input)
	{
		if (input.length()==0)
		{
			String output[] = {""};
			return output;
		}
		
		int dig1 = (input.charAt(0)-'0');
		String smallA1[] = getCode(input.substring(1));
		
		String smallA2[] = new String[0];
		
		int dig2 = 0;
		if (input.length()>=2)
		{
			dig2 = (input.charAt(0)-'0')*10+(input.charAt(1)-'0');
			if (dig2 > 10 && dig2 <= 26)
			{
				smallA2 = getCode(input.substring(2));
			}
		}
		
		String output[] = new String[smallA1.length+smallA2.length];
		int k=0;
		
//		for (String s: smallA1)
//		{
//			char first = getChar(dig1);
//			output[k] =  first+s;
//			k++;
//		}
//		
//		for (String s : smallA2)
//		{
//			char two = getChar(dig2);
//			output[k] = two+s;
//			k++;
//		}
		
		for (int i=0;i<smallA1.length;i++)
		{
			char one = getChar(dig1);
			output[k] = one+smallA1[i];
			k++;
		}
		
		for (int i=0;i<smallA2.length;i++)
		{
			char two = getChar(dig2);
			output[k] = two+smallA2[i];
			k++;
		}
		
		
		
		return output;
			
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the Code");
		String n = Obj.nextLine();
		
		String ans[] = getCode(n);
		
		System.out.println();
		for (int i=0;i<ans.length;i++)
		{
			System.out.println(ans[i]);
		}
		
	}

}
