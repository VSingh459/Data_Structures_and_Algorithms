package assignments;
import java.util.Scanner;

public class Assignment_2 {
	
	public static NodeA<Integer> takeInput_Better()
	{
		NodeA<Integer> head = null;
		NodeA<Integer> tail = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the elements of the Linked List");
		System.out.println("Enter -1 at the end, in order to stop the Linked List");
		int data = s.nextInt();
		
		while (data != -1)
		{
			NodeA<Integer> newNode = new NodeA<>(data);
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
	
	public static void printLL(NodeA<Integer> head)
	{
		while (head != null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
		
	}
	
	public static NodeA<Integer> evenOdd(NodeA<Integer> head)
	{
		if (head==null || head.next==null)
		{
			return head;
		}
		NodeA<Integer> oddHead = null;
		NodeA<Integer> evenHead = null;
		NodeA<Integer> evenTail = null;
		NodeA<Integer> oddTail = null;
		NodeA<Integer> temp = head;
		
		
		
		while (temp != null)
		{
			if (temp.data%2==0)
			{
				if (evenHead==null)
				{
					evenHead = temp;
					evenTail = temp;
				}
				else
				{
					evenTail.next = temp;
					evenTail = temp;
				}
			}
			else
			{
				if (oddHead==null)
				{
					oddHead = temp;
					oddTail = temp;
				}
				else
				{
					oddTail.next = temp;
					oddTail = temp;
				}
			}
			
			temp = temp.next;
		}
		
		if (oddHead != null)
		{
			oddTail.next = evenHead;
			
			if (evenTail != null)
			{
				evenTail.next = null;
			}
			return oddHead;
		}
		else
		{
			evenTail.next = null;
			return evenHead;
		}
	}
	

	public static void main(String[] args) {
		
         Scanner Obj = new Scanner(System.in);
		
		NodeA<Integer> head = takeInput_Better();
		printLL(head);
		System.out.println();
		NodeA<Integer> eo = evenOdd(head);
		printLL(eo);

	}

}
