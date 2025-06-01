package Tasks;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Q_2nd {
	
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	
	
	public void push(int element)
	{
		q1.add(element);
		
	}
	
	public int pop()
	{
		if (q1.isEmpty())
            return -1;
 
        // Leave one element in q1 and
        // push others in q2.
        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }
 
        // Pop the only left element
        // from q1
        int k = q1.remove();
 
        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        
        return k;
	}
	
	public int top()
	{
		if (q1.isEmpty())
            return -1;
 
        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }
 
        // last pushed element
        int temp = q1.peek();
 
        // to empty the auxiliary queue after
        // last operation
        q1.remove();
 
        // push last element to q2
        q2.add(temp);
 
        // swap the two queues names
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return temp;
	}
	

}
