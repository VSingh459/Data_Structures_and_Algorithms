package lectures;
import java.util.Scanner;

public class Return_Subsequence {
	
	public static  String[] subSequence(String str)
	{
		if (str.length()==0)
		{
			String ans[] = {""};
			return ans;
		}
		
		String smallAns[] = subSequence(str.substring(1));
		String ans[] = new String[2*smallAns.length];
		
		for (int i=0;i<smallAns.length;i++)
		{
			ans[i] = smallAns[i];
		}
		
		for (int i=0;i<smallAns.length;i++)
		{
			ans[i+smallAns.length] = str.charAt(0) + smallAns[i];
		}
		
		return ans;
		
	}
		
	
	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = Obj.nextLine();
		String out[];
		
		out = subSequence(s);
		
		//System.out.println();
		
		for (int i=0;i<out.length;i++)
		{
			System.out.println(out[i]);
			
		}
		
	}
}
