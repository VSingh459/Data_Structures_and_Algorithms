package priority_Queues_2;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.*;

public class KSmallest {
	
	public static ArrayList<Integer> kSmallest(int[] input,int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i=0;i<k;i++)
		{
			pq.add(input[i]);
		}
		
		for (int i=k;i<input.length;i++)
		{
			int x = pq.peek();
			if (x > input[i])
			{
				int y = pq.poll();
				pq.add(input[i]);
			}
			
			
		}
		
		ArrayList<Integer> a = new ArrayList<>();
		for (int i=0;i<k;i++)
		{
			a.add(pq.poll());
		}
		
		return a;
	}

	public static void main(String[] args) {
		
		int[] input = {2,12,9,16,10,5,3,20,25,11,1,8,6};
		int k = 4;
		
		ArrayList<Integer> ans = kSmallest(input,k);
		System.out.println(ans);

	}

}
