package lectures;

import java.util.Scanner;

public class LinkedList2_Use {
	
	public static Node2<Integer> takeInput_Better()
	{
		Node2<Integer> head = null;
		Node2<Integer> tail = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the elements of the Linked List");
		System.out.println("Enter -1 at the end, in order to stop the Linked List");
		int data = s.nextInt();
		
		while (data != -1)
		{
			Node2<Integer> newNode = new Node2<>(data);
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
	
	public static void printLL(Node2<Integer> head)
	{
		while (head != null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
		
	}
	
	public static Node2<Integer> mid_Point(Node2<Integer> head)
	{
		if (head==null)
		{
			return head;
		}
		Node2<Integer> slow = head;
		Node2<Integer> fast = head;
		
	    fast = fast.next;
		
		while (fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	public static Node2<Integer> insert_Rec(Node2<Integer> head,int pos,int elem)
	{
		if (pos==0)
		{
			Node2<Integer> newNode = new Node2<>(elem);
			newNode.next = head;
			return newNode;
		}
		
		head.next = insert_Rec(head.next,pos-1,elem);
		
		return head;
		
	}
	
	public static Node2<Integer> deleteRec(Node2<Integer> head,int pos)
	{
		if (head==null)
		{
			return head;
		}
		if (pos==0)
		{
			head = head.next;
			return head;
		}
		
		head.next = deleteRec(head.next,pos-1);
		return head;
		
	}
	
	public static Node2<Integer> reverse_n2(Node2<Integer> head)
	{
		if (head==null || head.next==null)
		{
			return head;
		}
		
		Node2<Integer> newH = reverse_n2(head.next);
		
		Node2<Integer> temp = newH;
		
		while (temp.next != null)
		{
			temp = temp.next;
		}
		
		temp.next = head;
		head.next = null;
		
		return newH;
	}
	
	public static Head_And_Tail reverse_Better(Node2<Integer> head)
	{
		if (head==null || head.next==null)
		{
			Head_And_Tail ans = new Head_And_Tail();
			ans.head = head;
			ans.tail = head;
			return ans;
		}
		
		Head_And_Tail  smallAns = reverse_Better(head.next);
		smallAns.tail.next = head;
		head.next = null;
		
		Head_And_Tail ans = new Head_And_Tail();
		ans.head = smallAns.head;
		ans.tail = head;
		
		return ans;
		
		
	}

	public static void main(String[] args) {
		
		Scanner ss = new Scanner(System.in);
		
//		Node2<Integer> head = takeInput_Better();
//		printLL(head);
//		
//		Node2<Integer> m = mid_Point(head);
//		System.out.println();
//		System.out.println(m.data);
		
		Node2<Integer> head = takeInput_Better();
		printLL(head);
		
//		System.out.println("Enter the value new node");
//		int val = ss.nextInt();
//		System.out.println("Enter the pos of new node");
//		int pos = ss.nextInt();
//		
//		Node2<Integer> rec = insert_Rec(head,pos,val);
//		printLL(rec);
		
//		System.out.println("Enter the positon of node to be deleted");
//		int dd = ss.nextInt();
//		Node2<Integer> del = deleteRec(head,dd);
//		printLL(del);
		
//		Node2<Integer> rr = reverse_n2(head);
//		System.out.println();
//		printLL(rr);
		
		Head_And_Tail rb = reverse_Better(head);
		printLL(rb.head);
		
		
		
		

	}

}
