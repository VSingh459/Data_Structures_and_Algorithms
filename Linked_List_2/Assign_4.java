package assignments;
import java.util.Scanner;

public class Assign_4 {
	
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
	
	public static NodeA<Integer> swapNodes(NodeA<Integer> head,int i,int j)
	{
		if (head==null)
		{
			return head;
		}
		if (i==j)
		{
			return head;
		}
		
		NodeA<Integer> temp = head;
		NodeA<Integer> t1 = null;
		NodeA<Integer> t2 = null;
		NodeA<Integer> p1 = null;
		NodeA<Integer> p2 = null;
		NodeA<Integer> inter = null;
		
		int A = i;
		int B = j;
		
		while (temp != null)
		{
			A--;
			 if (A==0 && i !=0)
			{
				  p1 = temp;
				  t1 = p1.next;
			
			}
			B--;
			if (B==0 && j != 0)
			{
				p2 = temp;
				t2 = p2.next;
			}
			
			temp = temp.next;
		}
		
		if (i==0)
		{
			p2.next = head;
			inter = head.next;
			head.next = t2.next;
			head = t2;
			t2.next = inter;
			
		}
		else if (j==0)
		{
			p1.next = head;
			inter = head.next;
			head.next = t1.next;
			head = t1;
			t1.next = inter;
		}
		else
		{
			p1.next = t2;
			p2.next = t1;
			inter = t2.next;
			t2.next = t1.next;
			t1.next = inter;
		}
	
		return head;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Scanner Obj = new Scanner(System.in);
		
		NodeA<Integer> head = takeInput_Better();
		printLL(head);
		System.out.println("Enter the values of 'M' and 'N' ");
		int m = Obj.nextInt();
		int n = Obj.nextInt();
		
		NodeA<Integer> ans = swapNodes(head,m,n);
		System.out.println();
		printLL(ans);
		
		
		

	}

}
