package Lectures;

public class Queue_LL<T> {
	
	private Node<T> front;
	private Node<T> rear;
	int size;
	
	public Queue_LL()
	{
		front = null;
		rear = null;
		size = 0;
	}
	
	
	public int size() {
		return size;
		
	}
	
	public boolean isEmpty() {
		
		return size==0;
		
	}
	
	public void enqueue(T elem) {
		
		Node temp = new Node(elem);
		
		if (this.rear == null)
		{
			this.rear = temp;
			this.front = temp;
			size++;
			return;
		}
		
		this.rear.next = temp;
		this.rear = temp;
		size++;
			
	}
	
	public T front() {
		
		T k = this.front.data;
		return k;	
	}
	
	public T dequeue() {
		
		if (this.front == null)
		{
			return this.front.data;
		}
		
		Node temp = this.front;
		T k = this.front.data;
		this.front = this.front.next;
		size--;
		
		if (this.front == null)
		{
			this.rear = null;
		}
		
		return k;
		
	}
}
