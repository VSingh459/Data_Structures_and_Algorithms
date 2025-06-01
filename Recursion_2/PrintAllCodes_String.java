package assignments;
import java.util.Scanner;

public class PrintAllCodes_String {
	
	public static void printEncod(String input)
	{
		String output = "";
		realEncod(input,output);
	}
	
	private static char helper1(int ch)
	{
        return (char)('a'+ch-1);
    }
	
	public static void realEncod(String input,String output)
	{
		if(input.length()==0)
        {  System.out.println(output);
        return;
        }
        char ch1=helper1(input.charAt(0)-'0');
        realEncod(input.substring(1),output+ch1);
        if(input.length()>=2)
        {
            int ch2=input.charAt(0)-'0';
            int ch3=input.charAt(1)-'0';
            int x=ch2*10+ch3;
            if(x>=10 && x<=26)
            {
                char ch4=helper1(x);
            realEncod(input.substring(2),output+ch4);
                
        }
        
        
    }
        return;
        
    }
		
	

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the Code");
		String n = Obj.nextLine();
		
		printEncod(n);

	}

}
