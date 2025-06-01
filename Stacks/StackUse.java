package lectures;
import java.util.Scanner;

public class StackUse {

	public static void main(String[] args) throws StackFullException {
		
		StackUsingArray stack = new StackUsingArray();
		
		for (int i=0;i<5;i++)
		{
			stack.push(i);
		}
		
		while (!stack.isEmpty())
		{
			try
			{
				System.out.print(stack.pop()+" ");
			}
			catch (StackEmptyException e)
			{
				
			}
		}
		
		System.out.println();

	}

}
