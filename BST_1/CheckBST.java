package part_1;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class CheckBST {
	
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
	
	public static boolean chBST(Node<Integer> root,long minVal,long maxVal)
	{
		if (root == null)
		{
			return true;
		}
		
		if (root.data >= maxVal || root.data <= minVal)
		{
			return false;
		}
		
		return chBST(root.left,minVal,root.data) && chBST(root.right,root.data,maxVal);
	}
	
	public static boolean isBST(Node<Integer> root)
	{
		boolean b = chBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
		return b;
	}

	public static void main(String[] args) {
		
		Node<Integer> root = takeInputLevelWise();
		
		boolean c = isBST(root);
		System.out.println(c);

	}

}
