package part_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Assign_2 {
	
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
	
	public static int getLCA(Node<Integer> root,int a,int b) 
	{
		if (root == null)
		{
			return -1;
		}
		
		if (root.data > a && root.data > b)
		{
			return getLCA(root.left,a,b);
		}
		
		if (root.data < a && root.data < b)
		{
			return getLCA(root.right,a,b);
		}
		
			return root.data;
		
	}
	
	
	

	public static void main(String[] args) {
		
		Node<Integer> root = takeInputLevelWise();
		
		int ans = getLCA(root,2,6);
		System.out.println(ans);
	

	}

}
