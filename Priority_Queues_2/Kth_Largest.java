package priority_Queues_2;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Kth_Largest {
	
	public static int kthLargest(int[] input,int k)
	{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i=0;i<k;i++)
		{
			pq.add(input[i]);
		}
		
		for (int i=k;i<input.length;i++)
		{
			int x = pq.peek();
			if (x < input[i])
			{
				int y = pq.poll();
				pq.add(input[i]);
			}
		}
		
		int a = pq.peek();
		
		return a;
	}

	public static void main(String[] args) {
		
		int[] arr = {2,6,10,11,13,4,1,20};
		
		int ans = kthLargest(arr,4);
		System.out.println(ans);

	}

}
