package Test;
import java.util.LinkedList;

public class Problem_3 {
	
	Node head;
	
	class Node<Integer> {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	public void deleteAlternateNodes(Node<Integer> head)
	{
		if (head==null)
			return;
		
		Node node = head;
		
		while (node !=null && node.next !=null)
		{
			node.next = node.next.next;
			node = node.next;
		}
		
		
	}

}
