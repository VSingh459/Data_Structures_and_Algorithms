package part_1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST_LL {
	
	public static Node<Integer> takeInputLevelWise()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Root Data");
		int rootData = s.nextInt();
		
		if (rootData == -1)
		{
			return null;
		}
		
		Node<Integer> root = new Node<Integer>(rootData);
		Queue<Node<Integer>> q = new LinkedList<Node<Integer>>();
		
		q.add(root);
		
		while (!q.isEmpty())
		{
			Node<Integer> front = q.remove();
			System.out.println("Enter Left Child of " + front.data);
			int left = s.nextInt();
			if (left != -1)
			{
				Node<Integer> leftChild = new Node<Integer>(left);
				front.left = leftChild;
				q.add(leftChild);
			}
			
			System.out.println("Enter the Right Child of " + front.data);
			int right = s.nextInt();
			if (right != -1)
			{
				Node<Integer> rightChild = new  Node<Integer>(right);
				front.right = rightChild;
				q.add(rightChild);
				
			}
		}
		
		return root;
	}
	
	public static Pair helper(Node<Integer> root)
	{
		if (root == null)
		{
			Pair out = new Pair();
			out.head = null;
			out.tail = null;
			return out;
		}
		
		Pair LT = helper(root.left);
		LL_Node<Integer> newNode = new LL_Node<>(root.data);
		Pair RT = helper(root.right);
		
		Pair out = new Pair();
		
		if (LT.head != null)
		{
			out.head = LT.head;
			LT.tail.next = newNode;
		}
		else
		{
			out.head = newNode;
		}
		
		newNode.next = RT.head;
		
		if (RT.head == null)
		{
			out.tail = newNode;
		}
		else
		{
			out.tail = RT.tail;
		}
		
		return out;
		
	}
	
	
	public static  LL_Node<Integer>  constructLL(Node<Integer> root)
	{
		Pair ans = helper(root);
		return ans.head;
	}

	public static void main(String[] args) {
		
		Node<Integer> root = takeInputLevelWise();
		
		LL_Node<Integer> head = constructLL(root);
		
	    LL_Node<Integer> temp = head;
	    
	    while (temp != null)
	    {
	    	System.out.print(temp.data+" ");
	    	temp = temp.next;
	    }
	}

}
