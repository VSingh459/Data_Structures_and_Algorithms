package part_2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Lectures.BT_Node;


public class BTree_Use {
	
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
	
	public static Node<Integer> removeLeaf(Node<Integer> root)
	{
		if (root == null)
		{
			return null;
		}
		
		if (root.left == null && root.right == null)
		{
			return null;
		}
		
		root.left = removeLeaf(root.left);
		root.right = removeLeaf(root.right);
		
		return root;
		
	}
	
	public static void mirrorBT(Node<Integer> root)
	{
		if (root == null)
		{
			return;
		}
		
		Node<Integer> t = root.left;
		
		root.left = root.right;
		root.right = t;
		
		mirrorBT(root.left);
		mirrorBT(root.right);
	}
	
	public static int height(Node<Integer> root)
	{
		if (root == null)
			return 0;
		else 
		{
			int hLeft = height(root.left);
			int hRight = height(root.right);
			
			if (hLeft > hRight)
				return hLeft+1;
			else
				return hRight+1;
		}
	}
	
	public static boolean isBalanced(Node<Integer> root)
	{
		if (root == null)
			return true;
		
		int leftH = height(root.left);
		int rightH = height(root.right);
		
		if (Math.abs(leftH - rightH) > 1)
		{
			return false;
		}
		
		boolean isLeftB = isBalanced(root.left);
		boolean isRightB = isBalanced(root.right);
		
		return isLeftB && isRightB;
		
	}
	
	public static BBT_Return isBBetter(Node<Integer> root)
	{
		if (root == null)
		{
			int height = 0;
			boolean isBal = true;
			BBT_Return ans = new BBT_Return();
			ans.height = height;
			ans.isBalanced = isBal;
			return ans;
		}
		
		BBT_Return lOut = isBBetter(root.left);
		BBT_Return rOut = isBBetter(root.right);
		boolean isBal = true;
		int height = 1 + Math.max(lOut.height, rOut.height);
		
		if (Math.abs(lOut.height - rOut.height) > 1)
		{
			isBal = false;
		}
		
		if (!lOut.isBalanced || !rOut.isBalanced)
		{
			isBal = false;
		}
		
		BBT_Return ans = new BBT_Return();
		ans.height = height;
		ans.isBalanced = isBal;
		
		return ans;
	}
	
	public static Dia findDia(Node<Integer> root)
	{
		if (root == null)
		{
			Dia ans = new Dia();
			ans.height = 0;
			ans.diameter = 0;
			return ans;
		}
		
		Dia lTree = findDia(root.left);
		Dia rTree = findDia(root.right);
		
		int height = 1 + Math.max(lTree.height, rTree.height);
		
		int Diameter = 0;
		
		if (lTree.diameter > height)
		{
			Diameter = lTree.diameter;
			
		}
		else if (rTree.diameter > height)
		{
			Diameter = rTree.diameter;
		}
		else
		{
			Diameter = lTree.height + rTree.height;
		}
		
		Dia ans = new Dia();
		ans.height = height;
		ans.diameter = Diameter;
		
		return ans;
	}
	
	

	public static void main(String[] args) {
		
		Node<Integer> root = takeInputLevelWise();
		
		printLevelWise(root);
		
		//Node<Integer> nRoot = removeLeaf(root);
		System.out.println();
		
		//mirrorBT(root);
		//printLevelWise(root);
		
		//BBT_Return a = isBBetter(root);
		//System.out.println("Is Balanced = " + a.isBalanced);
		
		Dia q = findDia(root);
		
		System.out.println("Diameter of Tree is = " + q.diameter);

	}

}
