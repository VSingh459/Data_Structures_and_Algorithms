package lectures;

public class DynamicStackUse {

	public static void main(String[] args) throws StackFullException {
		
      DynamicStack stack = new  DynamicStack(3);
		
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
