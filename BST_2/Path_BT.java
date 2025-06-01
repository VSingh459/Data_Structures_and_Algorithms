package part_2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

public class Path_BT {
	
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
	
	public static ArrayList<Integer>  pathToRoot(Node<Integer> root,int x)
	{
		if (root == null)
		{
			return null;
		}
		
		if (root.data == x)
		{
			ArrayList<Integer> out = new ArrayList<Integer>();
			out.add(x);
			return out;
		}
		
		ArrayList<Integer> leftOut = pathToRoot(root.left,x);
		if (leftOut != null)
		{
			leftOut.add(root.data);
			return leftOut;
		}
		
		ArrayList<Integer> rightOut = pathToRoot(root.right,x);
		if (rightOut != null)
		{
			rightOut.add(root.data);
			return rightOut;
		}
		
		return null;
		
	}

	public static void main(String[] args) {
		
		Node<Integer> root = takeInputLevelWise();
		
		ArrayList<Integer> path = pathToRoot(root,1);
		
			System.out.print(path);
			System.out.println();
			System.out.println(path.size());
		

	}

}
