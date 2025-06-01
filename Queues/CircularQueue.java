package Lectures;

public class CircularQueue {
	
	private int data[];
	private int front;
	private int rear;
	private int size;

	public CircularQueue() {
		
		data = new int[5];
		front = -1;
		rear = -1;
	}

	public CircularQueue(int capacity) {
		
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

	public void enqueue(int elem) throws QueueFullException {
		
		if (size == data.length)
		{
			throw new QueueFullException();
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


