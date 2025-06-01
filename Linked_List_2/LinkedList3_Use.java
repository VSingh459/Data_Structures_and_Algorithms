package tasks;
import java.util.Scanner;

import lectures.Node2;


public class LinkedList3_Use {
	
	public static Node3<Integer> takeInput_Better()
	{
		Node3<Integer> head = null;
		Node3<Integer> tail = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the elements of the Linked List");
		System.out.println("Enter -1 at the end, in order to stop the Linked List");
		int data = s.nextInt();
		
		while (data != -1)
		{
			Node3<Integer> newNode = new Node3<>(data);
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
	
	public static void printLL(Node3<Integer> head)
	{
		if (head==null)
		{
			System.out.println("The Linked List is Empty");
		}
		while (head != null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
		
	}
	
	public static Node3<Integer> mergerLL(Node3<Integer> head1,Node3<Integer> head2)
	{
		if (head1==null)
		{
			return head2;
		}
		if (head2==null)
		{
			return head1;
		}
			
		
		Node3<Integer> dummy = new Node3<>(0);
		Node3<Integer> prev = dummy;
		
		
		
	
		while(head1 != null && head2 != null)
		{
			System.out.println("Hello");
			if (head1.data <= head2.data)
			{
				prev.next = head1;
				head1 = head1.next;
			}
			else
			{
				prev = head2;
				head2 = head2.next;
			}
			prev = prev.next;
		}
		
		System.out.println("HHH");
		
		if (head1 != null)
		{
			prev.next = head1;
			head1 = head1.next;
			prev = prev.next;
		}
		if (head2 != null)
		{
			prev.next = head2;
			head2 = head2.next;
			prev = prev.next;
		}
		
		
		return dummy.next;
		
	}
	
	public static Node3<Integer> mergerLL2(Node3<Integer> head1,Node3<Integer> head2)
	{
		if (head1==null)
		{
			return head2;
		}
		if (head2==null)
		{
			return head1;
		}
		
		Node3<Integer> head=null;
		Node3<Integer> tail = null;
		
        if(head1.data<=head2.data)
        {
            head=head1;
            tail=head1;
            head1=head1.next;
        }
        else
        {
            head=head2;
            tail=head2;
            head2=head2.next;
        }
        while(head1!=null && head2!=null)
        {
            if(head1.data<=head2.data)
            {
                tail.next=head1;
                tail=head1;
                head1=head1.next;
            }
            else
            {
                tail.next=head2;
                tail=tail.next;
                head2=head2.next;
            }
        }
        if(head1==null)
            tail.next=head2;
        if(head2==null)
            tail.next=head1;
        
        return head;
	}
	
	public static Node3<Integer> reverse_Rec(Node3<Integer> head)
	{
		if (head==null || head.next==null)
		{
			return head;
		}
		
		Node3<Integer> newH = reverse_Rec(head.next);
		Node3<Integer> p = head.next;
		
		p.next = head;
		head.next = null;
		
		return newH;
	}

	public static void main(String[] args) {
		
//		Node3<Integer> head1 = takeInput_Better();
//		printLL(head1);
		Scanner ss = new Scanner(System.in);
//		Node3<Integer> head2 = takeInput_Better();
//		printLL(head2);
//		
//		System.out.println();
//		Node3<Integer> m = mergerLL2(head1,head2);
//		printLL(m);
		
		Node3<Integer> head = takeInput_Better();
		printLL(head);
		
		
		Node3<Integer> del = reverse_Rec(head);
		System.out.println();
		printLL(del);
		
		
		

	}

}
