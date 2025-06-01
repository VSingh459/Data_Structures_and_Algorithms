package tasks;
import java.util.Stack;
import java.util.Scanner;


public class Stock_Span {
	
	public static int[] stockSpan(int price[])
	{
		int span[] = new int[price.length];
		
		Stack<Integer> st = new Stack<>();
		st.push(0);
		span[0] = 1;
		
		for (int i=1;i<price.length;i++)
		{
			while (st.size() > 0 &&  price[i] > price[st.peek()])
			{
				st.pop();
				
			}
			
			if (st.size()==0)
			{
				span[i] = i+1;
			}
			else
			{
				span[i] = i - st.peek();
			}
			
			st.push(i);
			
		}
		return span;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Ente the number of days");
		int days = Obj.nextInt();
		int p[] = new int[days];
		System.out.println("Enter the price of stock for each day ");
		
		for (int i=0;i<days;i++)
		{
			p[i] = Obj.nextInt();
		}
		int ans[] = stockSpan(p);
		
		System.out.println();
		for (int i=0;i<days;i++)
		{
			System.out.print(ans[i]+" ");
		}
		System.out.println();

	}

}
