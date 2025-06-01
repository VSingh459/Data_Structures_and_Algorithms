package priority_Queues_2;
import java.util.*;

public class Ticket {
	
	public static int buyTicket(int[] input,int k)
	{
		Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<input.length;i++){
            queue.add(i);
            pq.add(input[i]);
        }
        int time=0;
        while (!queue.isEmpty()){
            if (input[queue.peek()] < pq.peek())
            {
                queue.add(queue.poll());
            }
            else
            {
                int idx = queue.poll();
                pq.remove();
                time++;
                if (idx == k)
                {
                    break;
                }
            }
        }
        return time;
	}

	public static void main(String[] args) {
		
		int[] a = {2,3,2,2,4};
		
		int ans = buyTicket(a,3);
		System.out.println(ans);

	}

}
