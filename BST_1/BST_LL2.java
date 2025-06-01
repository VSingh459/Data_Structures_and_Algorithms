package part_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST_LL2 {
	
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
	
	public static LL_Node<Integer> addNode(Node<Integer> currBSTnode, LL_Node<Integer> currLLnode)
	{
		LL_Node<Integer> nNode = new LL_Node<>(currBSTnode.data);
		currLLnode.next = nNode;
		return nNode;
	}
	
	
	public static LL_Node<Integer> helper(Node<Integer> currBSTnode, LL_Node<Integer> currLLnode)
	{
		if (currBSTnode == null)
		{
			return currLLnode;
		}
		
		if (currBSTnode.left != null)
		{
			currLLnode = helper(currBSTnode.left,currLLnode);
		}
		
		currLLnode = addNode(currBSTnode,currLLnode);
		
		if (currBSTnode.right != null)
		{
			currLLnode = helper(currBSTnode.right, currLLnode);
		}
		
		return currLLnode;
	}
	
	public static LL_Node<Integer> constructLL(Node<Integer> root)
	{
		if (root == null)
		{
			return null;
		}
		
		LL_Node<Integer> head = new LL_Node<>(root.data);
		
	    helper(root,head);
	    
	    return head.next;
		
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
