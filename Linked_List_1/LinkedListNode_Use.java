package tasks;
import java.util.Scanner;

public class LinkedListNode_Use {
	
	public static LinkedListNode<Integer> takeInput_Better()
	{
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the elements of the Linked List");
		System.out.println("Enter -1 at the end, in order to stop the Linked List");
		int data = s.nextInt();
		
		while (data != -1)
		{
			LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
			if (head==null)
			{
				head = newNode;
				tail = newNode;
			}
			else
			{
				tail.next = newNode;
				tail = tail.next;
			}
			data = s.nextInt();
		}
		
		return head;
	}
	
	public static void printLL(LinkedListNode<Integer> head)
	{
		while (head != null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static int length(LinkedListNode<Integer> head)
	{
		int LL =0;
		while (head != null)
		{
			head = head.next;
			LL++;
		}
		
		return LL;
	}
	
	public static void printIthNode(LinkedListNode<Integer> head,int i)
	{
		int ind =0;
		LinkedListNode<Integer> temp = head;
		while (ind != i && temp != null)
		{
			temp = temp.next;
			ind++;
		}
		if (ind==i && temp != null)
		{
			System.out.println(temp.data);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		LinkedListNode<Integer> head = takeInput_Better();
		printLL(head);
		
		int LL = length(head);
		System.out.println(LL);
		System.out.println();
		System.out.println("Enter the index - i");
		int i = s.nextInt();
		
		printIthNode(head,i);

	}

}
