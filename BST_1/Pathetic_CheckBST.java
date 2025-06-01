package part_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pathetic_CheckBST {
	
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
	
	public static int minimum(Node<Integer> root)
	{
		if (root == null)
		{
			return Integer.MAX_VALUE;
		}
		
		int leftMin = minimum(root.left);
		int rightMin = minimum(root.right);
		
		int a = Math.min(leftMin,rightMin);
		int ans = Math.min(root.data, a);
		return ans;
		
	}
	
	public static int maximum(Node<Integer> root)
	{
		if (root == null)
		{
			return Integer.MIN_VALUE;
		}
		
		int leftMax = maximum(root.left);
		int rightMax = maximum(root.right);
		
		int a = Math.max(leftMax, rightMax);
		int ans = Math.max(root.data, a);
		return ans;
	}
	
	public static boolean  checkBST(Node<Integer> root)
	{
		if (root == null)
		{
			return true;
		}
		
		int leftMax = maximum(root.left);
		if (leftMax >= root.data)
		{
			return false;
		}
		
		int rightMin = minimum(root.right);
		if (rightMin <= root.data)
		{
			return false;
		}
		
		boolean a = checkBST(root.left);
		boolean b = checkBST(root.right);
		
		return a && b;
	}
	

	public static void main(String[] args) {
		
		Node<Integer> root =  takeInputLevelWise();
		
		boolean b = checkBST(root);
		System.out.println(b);

	}

}
