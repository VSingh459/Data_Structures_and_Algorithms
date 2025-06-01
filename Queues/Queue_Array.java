package Lectures;

public class Queue_Array {
	
	private int data[];
	private int front;
	private int rear;
	private int size;
	
	public Queue_Array() {
		
		data = new int[5];
		front = -1;
		rear = -1;
	}
	
	public Queue_Array(int capacity) {
		
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
		
		rear++;
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
		front++;
		size--;
		if (size == 0)
		{
			front = -1;
			rear = -1;
		}
		return temp;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
