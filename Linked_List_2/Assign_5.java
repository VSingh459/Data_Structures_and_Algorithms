package assignments;
import java.util.Scanner;



public class Assign_5 {
	
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
	
	public static int length(NodeA<Integer> head)
	{
		int LL =0;
		while (head != null)
		{
			head = head.next;
			LL++;
		}
		
		return LL;
	}
	
	public static NodeA<Integer> kReverse(NodeA<Integer> head,int k)
	{
		if (head==null || k==0)
		{
			return head;
		}
		
		NodeA<Integer> dummy = new NodeA<>(-1);
		dummy.next = head;
		
		NodeA<Integer> curr = dummy;
		NodeA<Integer> prev = dummy;
		NodeA<Integer> forw = dummy;
		NodeA<Integer> temp = null;
		NodeA<Integer> pp = null;
		
		int count = length(head);
		
		while (count >= k)
		{
			curr = prev.next;
			forw = curr.next;
			
			for (int i=1;i<k;i++)
			{
				curr.next = forw.next;
				forw.next = prev.next;
				prev.next = forw;
				forw = curr.next;
			}
			
			prev = curr;
			count = count-k;
		}
		
		pp = curr.next;
		prev = null;
		
		
		while (pp != null)
		{
			temp = pp.next;
			pp.next = prev;
			prev = pp;
			pp = temp;
		}
		
		curr.next = prev;
		
		return dummy.next;
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		
		NodeA<Integer> head = takeInput_Better();
		printLL(head);
		System.out.println("Enter the value of 'k' ");
		int k = Obj.nextInt();
		
		NodeA<Integer> ans = kReverse(head,k);
		System.out.println();
		printLL(ans);

	}

}
