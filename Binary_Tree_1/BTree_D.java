package Lectures;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BTree_D {
	
public static BT_Node<Integer> takeTreeInputBetter(boolean isRoot,int pData, boolean isleft) {
	
	if (isRoot)
	{
		System.out.println("Enter Root Data");
	}
	else
	{
		if (isleft)
		{
			System.out.println("Enter Left Child of " + pData);
		}
		else
		{
			System.out.println("Enter right Child of " + pData);
		}
	}
	
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		
		if (rootData == -1)
		{
			return null;
		}
		
		BT_Node<Integer> root = new BT_Node<Integer>(rootData);
		BT_Node<Integer> leftChild = takeTreeInputBetter(false,rootData,true);
		BT_Node<Integer> rightChild = takeTreeInputBetter(false,rootData,false);
		
		root.left = leftChild;
		root.right = rightChild;
		
		return root;
	}
	
	
	public static BT_Node<Integer> takeTreeInput() {
		
		System.out.println("Enter Root Data");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		
		if (rootData == -1)
		{
			return null;
		}
		
		BT_Node<Integer> root = new BT_Node<Integer>(rootData);
		BT_Node<Integer> leftChild = takeTreeInput();
		BT_Node<Integer> rightChild = takeTreeInput();
		
		root.left = leftChild;
		root.right = rightChild;
		
		return root;
	}
	
	public static void PreOrderD(BT_Node<Integer> root)
	{
		if (root == null)
		{
			return;
		}
		
		System.out.print(root.data + ":");
		if (root.left != null)
		{
			System.out.print("L" + root.left.data + ", ");
		}
		if (root.right != null)
		{
			System.out.print("R" + root.right.data + ", ");
		}
		System.out.println();
		
		PreOrderD(root.left);
		PreOrderD(root.right);
		
	}
	
	public static int numNodes(BT_Node<Integer> root)
	{
		if (root == null)
		{
			return 0;
		}
		
		int leftNodeCount = numNodes(root.left);
		int rightNodeCount = numNodes(root.right);
		return 1+leftNodeCount+rightNodeCount;
	}
	
	public static BT_Node<Integer> takeInputLevelWise()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Root Data");
		int rootData = s.nextInt();
		
		if (rootData == -1)
		{
			return null;
		}
		
		BT_Node<Integer> root = new BT_Node<Integer>(rootData);
		Queue<BT_Node<Integer>> q = new LinkedList<BT_Node<Integer>>();
		
		q.add(root);
		
		while (!q.isEmpty())
		{
			BT_Node<Integer> front = q.remove();
			System.out.println("Enter Left Child of " + front.data);
			int left = s.nextInt();
			if (left != -1)
			{
				BT_Node<Integer> leftChild = new BT_Node<Integer>(left);
				front.left = leftChild;
				q.add(leftChild);
			}
			
			System.out.println("Enter the Right Child of " + front.data);
			int right = s.nextInt();
			if (right != -1)
			{
				BT_Node<Integer> rightChild = new  BT_Node<Integer>(right);
				front.right = rightChild;
				q.add(rightChild);
				
			}
		}
		
		return root;
	}
	
	public static void printLevelWise(BT_Node<Integer> root)
	{
		if (root == null)
		{
			return;
		}
		
		Queue<BT_Node<Integer>> q = new LinkedList<BT_Node<Integer>>();
		
		q.add(root);
		
		while (!q.isEmpty())
		{
			BT_Node<Integer> front = q.remove();
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
	
	public static int getSum(BT_Node<Integer> root)
	{
		if (root == null)
		{
			return 0;
		}
		
		Queue<BT_Node<Integer>> q = new LinkedList<BT_Node<Integer>>();
		
		q.add(root);
		
		int sum=0;
		
		while (!q.isEmpty())
		{
			BT_Node<Integer> front = q.remove();
			sum = sum + front.data;
			if (front.left != null)
			{
				q.add(front.left);
			}
			
			if (front.right != null)
			{
				q.add(front.right);
			}
		}
		
		return sum;	
	}
	
	public static int findMax(BT_Node<Integer> root)
	{
		if (root == null)
			return -1;
		
		int lar = root.data;
		
		int leftLar = findMax(root.left);
		int rightLar = findMax(root.right);
		
		if (leftLar > lar)
			lar = leftLar;
		if (rightLar > lar)
			lar = rightLar;
		
		return lar;
		
	}
	
	public static int fGreater(BT_Node<Integer> root, int x)
	{
		if (root == null)
			return 0;
		
		
		int total = fGreater(root.left,x) + fGreater(root.right,x);
		
		if (root.data > x)
		{
			return total+1;
		}
		else
		{
			return total;
		}
	}
	
	public static int height(BT_Node<Integer> root)
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
	
	public static int numLeaves(BT_Node<Integer> root)
	{
		if (root == null)
			return 0;
		
		if (root.left == null && root.right == null)
			return 1;
		
		int t = numLeaves(root.left) + numLeaves(root.right);
		
		return t;
	}
	
	public static void pDK(BT_Node<Integer> root, int k)
	{
		if (root == null)
			return;
		
		if (k == 0)
		{
			System.out.println(root.data);
			return;
		}
		
		pDK(root.left, k-1);
		pDK(root.right, k-1);
	}
	
	public static void  chValueD(BT_Node<Integer> root)
	{
		changeVD(root,0);
		
	}
	
	public static void changeVD(BT_Node<Integer> root, int level)
	{
		if (root == null)
			return;
		
		root.data = level;
		
		changeVD(root.left, level+1);
		changeVD(root.right, level+1);
		
	}
	
	public static boolean isNodeP(BT_Node<Integer> root, int x)
	{
		if (root == null)
			return false;
		
		if (root.data == x)
			return true;
		
		boolean res1 = isNodeP(root.left, x);
		
		if (res1)
			return true;
		
		boolean res2 = isNodeP(root.right, x);
		
		return res2;
		
	}
	
	public static void printNWS(BT_Node<Integer> root)
	{
		if (root == null)
			return;
		
		if (root.left == null && root.right == null)
		{
			return;
		}
		if (root.left==null)
        {
            System.out.print(root.right.data+" ");
            printNWS(root.right);
        }
        else if (root.right==null)
        {
            System.out.print(root.left.data+" ");
            printNWS(root.left);
            
        }
		else
        {
            printNWS(root.left);
            printNWS(root.right);
        }

	}

	public static void main(String[] args) {
		
//		BT_Node<Integer> root = new BT_Node<>(1);
//		BT_Node<Integer> rootLeft = new BT_Node<>(2);
//		BT_Node<Integer> rootRight = new BT_Node<>(3);
//		
//		root.left = rootLeft;
//		root.right = rootRight;
//		
//		BT_Node<Integer> rlRight = new BT_Node<>(4);
//		BT_Node<Integer> rrLeft = new BT_Node<>(5);
//		
//		rootLeft.right = rlRight;
//		rootRight.left = rrLeft;
		
		//BT_Node<Integer> root = takeTreeInputBetter(true,0,true);
		
		BT_Node<Integer> root = takeInputLevelWise();
		
		//PreOrderD(root);
		System.out.println("Number of Nodes = " + numNodes(root));
		
		System.out.println("The total sum of all the nodes is = " + getSum(root));
		
		//printLevelWise(root);
		System.out.println("Largest node is = " + findMax(root));
		
		System.out.println("Height of the Tree is = "+height(root));
		
	   Scanner obj = new Scanner(System.in);
	   System.out.println("Enter the Value of X");
	   int x = obj.nextInt();
	   System.out.println("The no of nodes greater than "+x+" are = "+fGreater(root,x));
	   
	   System.out.println("Total No of Leaves = "+numLeaves(root));
	   
	   pDK(root, 1);
	   
	   boolean a = isNodeP(root, 3);
	   System.out.println(a);
	   
	   printNWS(root);
	   

	}

}
