package Test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DEqueue {
	
	private int arr[];
	private int front, rear, size, capacity;
	
	public DEqueue(int x)
	{
		capacity = x;
		arr = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	private boolean isFull()
	{
		return size==capacity;
	}
	
	private boolean isEmpty()
	{
		return size==0;
	}
	
	public void insertFront(int elem)
	{
		if (isFull())
		{
			System.out.println("-1");
			return;
		}
		
		if (isEmpty())
		{
			front = 0;
			rear = 0;
		}
		else
		{
			front = (front-1+capacity) % capacity;
		}
		
		arr[front] = elem;
		size++;
	}
	
	public void  insertRear(int elem)
	{
		if (isFull())
		{
			System.out.println("-1");
			return;
		}
		
		if (isEmpty())
		{
			front = 0;
			rear = 0;
		}
		else
		{
			rear = (rear+1)%capacity;
		}
		
		arr[rear] = elem;
		size++;
	}
	
	public void deleteFront()
	{
		if (isEmpty())
		{
			System.out.println("-1");
			return;
		}
		
		if ( front == rear)
		{
			front = -1;
			rear = -1;
		}
		else
		{
			front = (front+1)%capacity;
		}
		size--;
	}
	
	public void deleteRear()
	{
		if (isEmpty())
		{
			System.out.println("-1");
			return;
		}
		
		if (rear==front)
		{
			rear = -1;
			front = -1;
		}
		else
		{
			rear = (rear-1+capacity)%capacity;
		}
		size--;
	}
	
	public int getFront()
	{
		if (isEmpty())
		{
			return -1;
		}
		
		return arr[front];
	}
	
	public int getRear()
	{
		if (isEmpty())
		{
			return -1;
		}
		
		return arr[rear];
	}
	
	public static void main(String[] args)
	{
		DEqueue deque = new DEqueue(10);

        deque.insertFront(1);
        deque.insertRear(2);
        System.out.println("Front: " + deque.getFront()); // Output: 1
        System.out.println("Rear: " + deque.getRear());   // Output: 2

        deque.deleteFront();
        System.out.println("Front: " + deque.getFront()); // Output: -1

        deque.deleteRear();
        System.out.println("Rear: " + deque.getRear());
	}
	
	
	}
	


