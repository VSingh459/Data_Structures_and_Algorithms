package part_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Assign_3 {
	
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
	
	public static void printLevelWise(Node<Integer> root)
	{
		if (root == null)
		{
			return;
		}
		
		Queue<Node<Integer>> q = new LinkedList<Node<Integer>>();
		
		q.add(root);
		
		while (!q.isEmpty())
		{
			Node<Integer> front = q.remove();
			System.out.print(front.data + ":");
			if (front.left != null)
			{
				System.out.print("L:" + front.left.data + ",");
				q.add(front.left);
			}
			else 
			{
				System.out.print("L:-1,");
			}
			
			if (front.right != null)
			{
				System.out.print("R:"+front.right.data);
				q.add(front.right);
			}
			else
			{
				System.out.print("R:-1");
			}
			System.out.println();
		}
		
	}
	
	public static int  replace(Node<Integer> root, int sum)
	{
		if (root == null)
		{
			return 0;
		}
		System.out.println(sum);
		
		int right = replace(root.right,sum);
		
		int rData = root.data;
		root.data = root.data+right+sum;
		int left = replace(root.left,root.data);
		
		return rData+right+left;
		
	}
	
	public static void replaceWithLargerNodesSum(Node<Integer> root)
	{
		if (root == null)
		{
			return;
		}
		int ans = replace(root,0);
	}

	public static void main(String[] args) {
		
		Node<Integer> root = takeInputLevelWise();
		
		replaceWithLargerNodesSum(root);
		
		//printLevelWise(root); 
		
		
		
		

	}

}
