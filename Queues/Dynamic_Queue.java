package Lectures;

public class Dynamic_Queue {
	
	private int data[];
	private int front;
	private int rear;
	private int size;

	public Dynamic_Queue() {
		
		data = new int[5];
		front = -1;
		rear = -1;
	}

	public Dynamic_Queue(int capacity) {
		
		data = new int[capacity];
		front = -1;
		rear = -1;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		
		return size==0;
	}

	public void enqueue(int elem)  {
		
		if (size == data.length)
		{
			doubleCapacity();
		}
		
		if (size == 0)
		{
			front = 0;
		}
		
//		rear++;
//		if (rear == data.length)
//		{
//			rear = 0;
//		}
		rear = (rear+1) % data.length;
		data[rear] = elem;
		size++;
		
	}
	
	private void doubleCapacity() {
		
		int temp[] = data;
		data = new int[2*temp.length];
		
		int index=0;
		for (int i=front;i<temp.length;i++)
		{
			data[index++] = temp[i];
		}
		for (int i=0; i<front-1;i++)
		{
			data[index++] = temp[i];
		}
		
		front = 0;
		rear = temp.length - 1;
	}

	public int front() throws QueueEmptyException_1{
		
		if (size == 0)
		{
			throw new QueueEmptyException_1();
		}
		
		int k = data[front];
		
		return k;
	}

	public int deQueue() throws QueueEmptyException_1 {
		
		if (size == 0)
		{
			throw new QueueEmptyException_1();
		}
		
		int temp = data[front];
//		front++;
//		if (front == data.length)
//		{
//			front = 0;
//		}
		front = (front+1) % data.length;
		size--;
		if (size == 0)
		{
			front = -1;
			rear = -1;
		}
		return temp;
	}


}
