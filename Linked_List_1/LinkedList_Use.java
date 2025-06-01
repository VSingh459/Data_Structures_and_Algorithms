package lectures;
import java.util.Scanner;

import tasks.LinkedListNode;

public class LinkedList_Use {
	
	public static Node<Integer> takeInput()
	{
		Node<Integer> head = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the elements of the Linked List");
		System.out.println("Enter -1 at the end, in order to stop the Linked List");
		int data = s.nextInt();
		
		while (data != -1)
		{
			Node<Integer> newNode = new Node<>(data);
			if (head==null)
			{
				head = newNode;
			}
			else
			{
				Node<Integer> temp = head;
				while (temp.next !=null)
				{
					temp = temp.next;
				}
				temp.next = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static Node<Integer> takeInput_Better()
	{
		Node<Integer> head = null;
		Node<Integer> tail = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the elements of the Linked List");
		System.out.println("Enter -1 at the end, in order to stop the Linked List");
		int data = s.nextInt();
		
		while (data != -1)
		{
			Node<Integer> newNode = new Node<>(data);
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
	
	public static void printLL(Node<Integer> head)
	{
		while (head != null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
		
	}
	
	public static Node<Integer> insert(Node<Integer> head,int data,int pos)
	{
		Node <Integer> newNode = new Node<>(data);
		
		if (pos==0)
		{
			newNode.next = head;
			return newNode;
		}
		int i=0;
		Node<Integer> temp = head;
		
		while (i < pos-1)
		{
			temp = temp.next;
			i++;
		}
		
		newNode.next = temp.next;
		temp.next = newNode;
		
		return head;	
	}
	
	public static Node<Integer> delete(Node<Integer> head,int pos)
	{
		int L = length(head);
		if (pos >= L)
		{
			return head;
		}
		Node<Integer> temp = head;
		int i=0;
		if (pos==0)
		{
			temp = temp.next;
			return temp;
		}
		while (i<pos-1)
		{
			temp = temp.next;
			i++;
		}
		temp.next = temp.next.next;
		
		return head;
	}
	
	public static int length(Node<Integer> head)
	{
		int LL =0;
		while (head != null)
		{
			head = head.next;
			LL++;
		}
		
		return LL;
	}
	
	public static int findNode(Node<Integer> head,int n)
	{
		if (head==null)
		{
			return -1;
		}
		Node<Integer> temp = head;
		int ind=0;
		
		while (temp.next != null)
		{
			if (temp.data==n)
			{
				return ind;
			}
			temp = temp.next;
			ind++;
		}
		
		return -1;
		
	}
	
	public static Node<Integer> append(Node<Integer> head,int n)
	{
		if (head==null)
		{
			return head;
		}
		Node<Integer> temp = head;
		int L = length(head);
		int nn = L-n;
		int index = 0;
		
		while (temp.next != null)
		{
			temp = temp.next;
		}
		temp.next = head;
		
		while (index < nn)
		{
			temp = temp.next;
			index++;
		}
		head = temp.next;
		temp.next = null;
		
		return head;
	}
	
	public static Node<Integer> removeDupli(Node<Integer> head)
	{
		if (head==null)
		{
			return head;
		}
		Node<Integer> temp = head;
		Node<Integer> temp1 = head.next;
		
		while (temp1 != null)
		{
			if (temp1.data.compareTo(temp.data) == 0)
			{
				temp.next = temp1.next;
				temp1 = temp1.next;
			}
			else
			{
				temp = temp1;
				temp1 = temp1.next;
			}
			
			
		}
		
		return head;
	}
	
	public static void printReverse(Node<Integer> root)
	{
		if (root==null)
		{
			return;
		}
		Node<Integer> temp = root;
		int L = length(root);
		int arr[] = new int[L];
		int c=0;
		
		while (temp != null)
		{
			arr[c] = temp.data;
			temp = temp.next;
			c++;
		}
		
		for (int i=L-1;i>=0;i--)
		{
			System.out.print(arr[i]+" ");
		}
		
	}
	
	public static boolean isPalind(Node<Integer> head)
	{
		if (head==null)
		{
			return true;
		}
		
		Node<Integer> mid = middle(head);
		System.out.println(mid.data);
		Node<Integer> last = reverse(mid);
		Node<Integer> curr = head;
		
		while (last != null)
		{
			if (last.data != curr.data)
			{
				return false;
			}
			last = last.next;
			curr = curr.next;
		}
		
		return true;
	}
	
	public static Node<Integer> middle(Node<Integer> head)
	{
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		
		while (fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
		
	}
	
	public static Node<Integer> reverse(Node<Integer> start)
	{
		Node<Integer> curr = start;
		Node<Integer> prev = null;
		Node<Integer> temp;
		
		while (curr != null)
		{
			 temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		return prev;
	}

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput_Better();
		printLL(head);
		Scanner ss = new Scanner(System.in);
		
		Node<Integer> re = reverse(head);
		System.out.println();
		printLL(re);
		
//		boolean a = isPalind(head);
//		System.out.println();
//		System.out.println(a);
		
//		System.out.println();
//		printReverse(head);
		
//		head = removeDupli(head);
//		System.out.println();
//		printLL(head);
		
//		System.out.println("Enter the value of N");
//		int n = ss.nextInt();
//		
//		head = append(head,n);
//		System.out.println();
//		printLL(head);
		
//		System.out.println("Enter the integer whose index is LL is to be Searched");
//		int dd = ss.nextInt();
//		
//		int ind = findNode(head,dd);
//		System.out.println();
//		System.out.println(ind);
//		
//		System.out.println("Enter the data and position of new node to be inserted");
//		
//		int d = ss.nextInt();
//		int p = ss.nextInt();
//		
//		head = insert(head,d,p);
//		printLL(head);
//		
//		System.out.println("Enter the index of node to be deleted");
//		int ddd = ss.nextInt();
//		
//		head = delete(head,ddd);
//		printLL(head);
		
//		Node<Integer> node1 = new Node<>(10);
//		Node<Integer> node2 = new Node<>(20);
//		
//		node1.next = node2;
//		
//		System.out.println(node1.next);
//		System.out.println(node2);
//		
//		System.out.println(node1.data);
//		System.out.println(node2.data);
//		
//		System.out.println(node2.next);
//		
//		Node<Integer> node3 = new Node<>(30);
//		
//		node2.next = node3;
//		
//		Node<Integer> head;
//		head = node1;
//		
//		System.out.println();
//		
//		printLL(head);

	}

}
