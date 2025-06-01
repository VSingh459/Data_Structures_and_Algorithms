package Lectures;

public class DQueue_Run {

	public static void main(String[] args) {
		
		Dynamic_Queue queue = new Dynamic_Queue(5);
		int arr[] = {10,20,30,40,50,60,70};
		
		for (int i=0;i<arr.length;i++)
		{
			queue.enqueue(arr[i]);
		}
		
		while (! queue.isEmpty())
		{
			try {
				System.out.println(queue.deQueue());
			} catch (QueueEmptyException_1 e) {
				
			}
			
		}
		

	}

}
