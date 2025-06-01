package tasks;
import java.util.Scanner;

public class StackUse2 {

	public static void main(String[] args) {
		
		StackUsingLL stack = new StackUsingLL();
		
		System.out.println("Enter the number of queries");
		Scanner Obj = new Scanner(System.in);
		int q = Obj.nextInt();
		
		System.out.println("Enter the queries");
		int que[][] = new int[q][2];
		
		for (int i=0;i<que.length;i++)
		{
			for (int j=0;j<que[i].length;j++)
			{
					if (j==0)
					{
						que[i][j] = Obj.nextInt();
					}
					else if (j==1 && que[i][0]==1)
					{
						que[i][j] = Obj.nextInt();
					}
			}
		}

		System.out.println();
		
		for (int i=0;i<que.length;i++)
		{
			if (que[i][0]==1)
			{
				stack.push(que[i][1]);
			}
			else if (que[i][0]==2)
			{
				System.out.println(stack.pop());
			}
			else if (que[i][0]==3)
			{
				System.out.println(stack.top());
			}
			else if (que[i][0]==4)
			{
				System.out.println(stack.size());
			}
			else
			{
				System.out.println(stack.isEmpty());
			}
			
		}

		
		
		
		
		
		

	}

}
