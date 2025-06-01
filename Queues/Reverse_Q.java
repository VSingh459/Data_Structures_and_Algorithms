package Tasks;
import java.util.LinkedList;
import java.util.Queue;


public class Reverse_Q {
	
	public static  void Print(Queue<Integer> Queue)
	  {
	    while (Queue.size() > 0) {
	      System.out.println(Queue.peek() + " ");
	      Queue.remove();
	    }
	  }
	
	public static void reverse(Queue<Integer> q)
	{
		if (q.size() == 0)
		      return;
		    // storing front(first element) of queue
		    int fr = q.peek();
		 
		    // removing front
		    q.remove();
		 
		    // asking recursion to reverse the
		    // leftover queue
		    reverse(q);
		 
		    // placing first element
		    // at its correct position
		    q.add(fr);
		
	}
	
	public static void main(String[] args) {
		
		Queue<Integer> obj = new LinkedList<>();
		
		for (int i=1;i<=9;i++)
		{
			obj.add(i*10);
		}
		
		reverse(obj);
		Print(obj);
	
	}	
}

	
	
	
	
	
	
	
	
	














	
	
			
	

