package priority_Queues_2;
import java.util.PriorityQueue;

public class InbuiltPQ {

	public static void main(String[] args) {
		
		int[] arr = {4,3,7,6,9,10,1,2};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i=0;i<arr.length;i++)
		{
			pq.add(arr[i]);
		}
		
		while (!pq.isEmpty())
		{
			System.out.println(pq.peek());
			pq.poll();
		}

	}

}
