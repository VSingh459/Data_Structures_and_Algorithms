package Test;

public class Problem_1 {
	
	public static LinkedListNode<Integer> newNode(int data)
	{
		LinkedListNode<Integer>  new_Node = new LinkedListNode(data);
		new_Node.next = null;
		return new_Node;	
	}
	
	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head)
	{
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> curr = head;
		LinkedListNode<Integer> next = null;
		
		while (curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	public static LinkedListNode<Integer> AddOne(LinkedListNode<Integer> head)
	{
		LinkedListNode<Integer> res = head;
		LinkedListNode<Integer> temp = null;
		LinkedListNode<Integer> prev = null;
		
		int carry = 1;
		int sum;
		
		while (head != null)
		{
			sum = carry + head.data;
			
			if (sum >= 10)
			{
				carry = 1;
			}
			else
			{
				carry = 0;
			}
			
			sum = sum % 10;
			head.data = sum;
			temp = head;
			head = head.next;
		}
		
		if (carry > 0)
		{
			temp.next = newNode(carry);
		}
		
		return res;
	}
	
	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
		
		head = reverse(head);
		head = AddOne(head);
		
		return reverse(head);
		
	}
	
	static void printList(LinkedListNode node)
    {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }
	
	public static void main(String[] args)
    {
        LinkedListNode head = newNode(1);
        head.next = newNode(9);
        head.next.next = newNode(9);
        head.next.next.next = newNode(9);
 
        System.out.print("List is ");
        printList(head);
 
        head = nextLargeNumber(head);
        System.out.println();
        System.out.print("Resultant list is ");
        printList(head);
    }

}
