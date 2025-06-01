package tasks;
import java.util.Scanner;

public class MergeSort_Use {
	
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
	
	public static Node3<Integer> mid_Point(Node3<Integer> head)
	{
		if (head==null)
		{
			return head;
		}
		Node3<Integer> slow = head;
		Node3<Integer> fast = head;
		
	    fast = fast.next;
		
		while (fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	
	public static Node3<Integer> mergeSort(Node3<Integer> head)
	{
		if (head==null || head.next==null)
		{
			return head;
		}
		
		Node3<Integer> m = mid_Point(head);
		Node3<Integer> midHead = m.next;
		m.next = null;
		
		Node3<Integer> part1 = mergeSort(head);
		Node3<Integer> part2 = mergeSort(midHead);
		
		Node3<Integer> MM = merging(part1,part2);
		
		return MM;
	}
	
	
	
	public static Node3<Integer> merging(Node3<Integer> head1,Node3<Integer> head2)
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node3<Integer> head = takeInput_Better();
		printLL(head);
		
		Node3<Integer> sh = mergeSort(head);
		System.out.println();
		printLL(sh);

	}

}
