package part_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Medium_CheckBST {
	
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
	
	public static Check isBST3(Node<Integer> root)
	{
		if (root == null)
		{
			Check ans = new Check(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
			return ans;
		}
		
		Check leftAns = isBST3(root.left);
		Check rightAns = isBST3(root.right);
		
		int min = Math.min(root.data,Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		boolean isBST = true;
		
		if (leftAns.max >= root.data)
		{
			isBST = false;
		}
		if (rightAns.min < root.data)
		{
			isBST = false;
		}
		if (!leftAns.isBST)
		{
			isBST = false;
		}
		if (!rightAns.isBST)
		{
			isBST = false;
		}
		
		Check ans = new Check(min,max,isBST);
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		Node<Integer> root = takeInputLevelWise();
		
		Check b = isBST3(root);
		System.out.println(b.min+" "+b.max+" "+b.isBST);
		 

	}

}
