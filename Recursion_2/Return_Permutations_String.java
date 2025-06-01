package assignments;
import java.util.Scanner;

public class Return_Permutations_String {
	
	public static String[] permutation(String input)
	{
		if (input.length()==0)
		{
			String output[] = {""};
			return output;
		}
		
		String smallA[] = permutation(input.substring(1));
		
		String output[] = new String[input.length()*smallA.length];
		
		int k=0;
		for (int i=0;i<smallA.length;i++)
		{
			String current = smallA[i];
			//System.out.println(smallA[i]);
			for (int j=0;j<=current.length();j++)
			{
				output[k] = current.substring(0, j)+ input.charAt(0) + current.substring(j);
				System.out.println(output[k]);
				k++;
			}
		}
		
		return output;
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = Obj.nextLine();
		
		String out[] = permutation(str);
		System.out.println();
		
		for (int i=0;i<out.length;i++)
		{
			System.out.println(out[i]);
		}

		

	}

}
