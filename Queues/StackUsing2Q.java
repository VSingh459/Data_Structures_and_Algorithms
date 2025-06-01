package Tasks;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Lectures.Node;

public class StackUsing2Q {
	
	static Queue<Integer> q1 = new LinkedList<Integer>();
	static Queue<Integer> q2 = new LinkedList<Integer>();
	
	static int curr_size;
	
	static void push(int x)
	{
		// Push x in an empty Queue q2
		q2.add(x);
		
		// Push all remaining elements from q1 to q2
		while (!q1.isEmpty())
		{
			q2.add(q1.peek());
			q1.remove();
		}
		
		// Swap the names of two queues
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
	}
	
	static void pop()
	{
		if (q1.isEmpty())
			return;
		q1.remove();
	}
	
	static int top()
	{
		if (q1.isEmpty())
		{
			return -1;
		}
		return q1.peek();
	}
	
	static int size()
	{
		return q1.size();
	}

}
