package Lectures;

public class QueueUse {

	public static void main(String[] args) {
		
		CircularQueue queue = new CircularQueue();
		int arr[] = {10,20,30,40};
		
		for (int i=0;i<arr.length;i++)
		{
			try {
				queue.enqueue(arr[i]);
			} catch (QueueFullException e) {
				
			}
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
