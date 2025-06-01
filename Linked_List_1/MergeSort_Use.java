package tasks;
import java.util.Scanner;

public class MergeSort_Use {
	
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
	
	public static LinkedListNode<Integer> mid_Point(LinkedListNode<Integer> head)
	{
		if (head==null)
		{
			return head;
		}
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;
		
	    fast = fast.next;
		
		while (fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	
	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head)
	{
		if (head==null || head.next==null)
		{
			return head;
		}
		
		LinkedListNode<Integer> m = mid_Point(head);
		LinkedListNode<Integer> midHead = m.next;
		m.next = null;
		
		LinkedListNode<Integer> part1 = mergeSort(head);
		LinkedListNode<Integer> part2 = mergeSort(midHead);
		
		LinkedListNode<Integer> MM = merging(part1,part2);
		
		return MM;
	}
	
	
	
	public static LinkedListNode<Integer> merging(LinkedListNode<Integer> head1,LinkedListNode<Integer> head2)
	{
		if (head1==null)
		{
			return head2;
		}
		if (head2==null)
		{
			return head1;
		}
		
		LinkedListNode<Integer> head=null;
		LinkedListNode<Integer> tail = null;
		
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
	
	public static void printLL(LinkedListNode<Integer> head)
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

	public static void main(String[] args) {
		
		LinkedListNode<Integer> head = takeInput_Better();
		printLL(head);
		
		LinkedListNode<Integer> sh = mergeSort(head);
		System.out.println();
		printLL(sh);

	}

}
