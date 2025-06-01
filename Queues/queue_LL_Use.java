package Lectures;
import java.util.Scanner;

public class queue_LL_Use {

	public static void main(String[] args) {
		
		Queue_LL<Integer> q = new Queue_LL();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		
		int s = q.size();
		
		for (int i=0;i<s;i++)
		{
			System.out.println(q.dequeue());
		}
		

	}

}
