package tasks;
import java.util.Scanner;

public class StackUsingLL {
	
	private NodeS head;
	private int size;
	
	public StackUsingLL()
	{
		head = null;
		size = 0;
	}
	
	
	int size()
	{
		return size;
	}
	
	boolean isEmpty()
	{
		return size()==0;
	}
	
	int top()
	{
		if (size()==0)
		{
			return -1;
		}
		return head.data;
	}
	
	void push(int elem)
	{
		NodeS newNode = new NodeS(elem);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	int pop()
	{
		if (size()==0)
		{
			return -1;
		}
		int temp = head.data;
		head = head.next;
		size--;
		return temp;
	}

}
