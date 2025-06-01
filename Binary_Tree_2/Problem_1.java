package part_2;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem_1 {
	
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
	
	public static void insertDupNode(Node<Integer> root)
	{
	
		
		if (root == null)
		{
			return;
		}
		
		insertDupNode(root.left);
		insertDupNode(root.right);
		
		Node<Integer> temp = root.left;
		root.left = new Node<>(root.data);
		root.left.left = temp;
		
	}
	
	public static void doubleTree(Node<Integer> root)
	{
		Stack<Node<Integer>> s = new Stack<>();
		s.add(root);
		
		while (!s.empty())
		{
			Node<Integer> r = s.pop();
			if (r.right != null)
			{
				s.add(r.right);
			}
			
			if (r.left != null)
			{
				s.add(r.left);
			}
			
			Node<Integer> n = new Node<>(r.data);
			Node<Integer> t = r.left;
			r.left = n;
			r.left.left = t;
			
		}
		
	}

	public static void main(String[] args) {
		
		Node<Integer> root = takeInputLevelWise();
		
		//insertDupNode(root);
		doubleTree(root);
		
		printLevelWise(root);
		
		
		
		

	}

}
