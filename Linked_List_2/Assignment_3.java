package assignments;
import java.util.Scanner;

public class Assignment_3 {
	
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
	
	public static NodeA<Integer> skipDel(NodeA<Integer> head,int m,int n)
	{
		if(head==null || n==0)
		{
			return head;
		}
		if (m==0)
		{
			return null;
		}
		
		NodeA<Integer> temp = head;
		NodeA<Integer> t = null;
		
		while (temp != null)
		{
			for (int i=1;i<m && temp != null;i++)
			{
				temp = temp.next;
			}
			
			if (temp==null)
			{
				return head;
			}
			
			t = temp.next;
			
			for (int j=1;j<=n && t != null;j++)
			{
				t = t.next;
			}
			
			temp.next = t;
			
			temp = t;
		}
		
		return head;
		
	}

	public static void main(String[] args) {
		
Scanner Obj = new Scanner(System.in);
		
		NodeA<Integer> head = takeInput_Better();
		printLL(head);
		System.out.println("Enter the values of 'M' and 'N' ");
		int m = Obj.nextInt();
		int n = Obj.nextInt();
		
		NodeA<Integer> ans = skipDel(head,m,n);
		System.out.println();
		printLL(ans);


	}

}
