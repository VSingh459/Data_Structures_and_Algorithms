package assignments;
import java.util.Scanner;

public class Assign_6 {
	
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
	
	public static NodeA<Integer> bubble(NodeA<Integer> head)
	{
		if (head==null || head.next == null)
		{
			return head;
		}
		
		for(int i=0;i<length(head)-1;i++){
            NodeA<Integer> prev = null;
            NodeA<Integer> curr = head;
            NodeA<Integer> next = curr.next;

            while(curr.next != null){
                if(curr.data > curr.next.data){
                    if(prev == null){
                        curr.next = next.next;
                        next.next = curr;
                        prev = next;
                        head = prev;
                    }else{
                        next = curr.next;
                        curr.next = next.next;
                        prev.next = next;
                        next.next = curr;
                        prev = next;
                    }
                }else{
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
		
		return head;
	}

	public static void main(String[] args) {
		
Scanner Obj = new Scanner(System.in);
		
		NodeA<Integer> head = takeInput_Better();
		printLL(head);
		
		NodeA<Integer> so = bubble(head);
		System.out.println();
		printLL(so);

	}

}
