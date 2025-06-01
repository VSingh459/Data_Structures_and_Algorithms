package part_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Search_BST {
	
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
	
	public static boolean searchBST(Node<Integer> root,int k)
	{
		if (root == null)
		{
			return false;
		}
		
		if (k < root.data)
		{
			return searchBST(root.left,k);
		}
		else if (k > root.data)
		{
			return searchBST(root.right,k);
		}
		
		return true;
		
	}
	
	// public static Queue<Integer> q = new LinkedList<>();
	
	public static void  elemK1K2(Node<Integer> root,int k1,int k2)
	{
		if (root == null)
		{
			return;
		}
		
		elemK1K2(root.left,k1,k2);
		
		if (root.data >= k1 && root.data <= k2)
		{
			System.out.print(root.data+" ");
		}
		
		elemK1K2(root.right,k1,k2);
		
	}
	
	public static void  elem2(Node<Integer> root,int k1,int k2)
	{
		if (root == null)
		{
			return;
		}
		
		if (root.data < k1)
		{
			elem2(root.right,k1,k2);
		}
		else if (root.data > k2)
		{
			elem2(root.left,k1,k2);
			
		}
		else
		{
			System.out.print(root.data+" ");
			elem2(root.left,k1,k2);
			elem2(root.right,k1,k2);
			
		}
		
		
	}
	
	

	public static void main(String[] args) {
		
		Node<Integer> root = takeInputLevelWise();
		
		//boolean b = searchBST(root,12);
		//System.out.println(b);
		
		//elemK1K2(root,6,10);
		
		elem2(root,6,10);

	}

}
