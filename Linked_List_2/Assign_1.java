package assignments;
import java.util.Scanner;

import lectures.Node2;


public class Assign_1 {
	
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
	
	public static int finder(NodeA<Integer> head,int n)
	{
		return findRec(head,n,0);
		
	}
	
	public static int findRec(NodeA<Integer> head,int n,int index)
	{
		if (head == null)
		{
			return -1;
		}
		
		if (head.data == n)
		{
			return index;
		}
		
		int ind = findRec(head.next,n,index+1);
		
		return ind;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner Obj = new Scanner(System.in);
		
		NodeA<Integer> head = takeInput_Better();
		printLL(head);
		System.out.println("Enter the data of node to be found");
		int dd = Obj.nextInt();
		System.out.println();
		
		int nn = finder(head,dd);
		System.out.println(nn);
		
	}

}
