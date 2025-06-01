package part_1;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class ArrayToBST {
	
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
	
	public static void printLevelWise2(Node<Integer> root)
	{
		if (root == null)
		{
			return;
		}
		
		Queue<Node<Integer>> q = new LinkedList<Node<Integer>>();
		
		q.add(root);
		q.add(null);
		
		while (!q.isEmpty())
		{
			Node<Integer> curr = q.remove();
			
			if (curr == null)
			{
				if (!q.isEmpty())
				{
					q.add(null);
					System.out.println();
				}
			}
			else 
			{
				if (curr.left != null)
					q.add(curr.left);
				
				if (curr.right != null)
					q.add(curr.right);
				
				System.out.print(curr.data+" ");
			}
		}
	}
	
	public static Node<Integer> AtoBST(int[] arr,int st,int en)
	{
		if (st > en)
		{
			return null;
		}
		
		int mid = (st+en)/2;
		
		
		Node<Integer> root = new Node<>(arr[mid]);
		root.left = AtoBST(arr,st,mid-1);
		root.right = AtoBST(arr,mid+1,en);
		
		return root;
		
	}
	
	
	
	public static Node<Integer> SortedArrayToBST(int arr[],int n)
	{
		Node<Integer> r = AtoBST(arr,0,n-1);
		return r;
		
	}
	
	public static Node<Integer> AtoBST2(int[] arr, int n)
	{
		if (n == 0)
		{
			return null;
		}
		
		Queue<MyNode> q = new LinkedList<>();
		
		int l =0;
		int r = n-1;
		int value = arr[l+(r)/2];
		
		Node<Integer> root = new Node<>(value);
	
		MyNode a = new MyNode(root,l,r);
		
		q.add(a);
		
		while (!q.isEmpty())
		{
			MyNode curr = q.remove();
			int mid = curr.l + (curr.r - curr.l)/2;
			
			if (mid != curr.l)
			{
				Node<Integer> leftChild = new Node<>(arr[curr.l + (mid-1-curr.l)/2]);
				curr.bst.left = leftChild;
				MyNode b = new MyNode(leftChild,curr.l,mid-1);
				q.add(b);
			}
			
			if (mid != curr.r)
			{
				Node<Integer> rightChild = new Node<>(arr[mid+1+(curr.r-mid-1)/2]);
				curr.bst.right = rightChild;
				MyNode bb = new MyNode(rightChild,mid+1,curr.r);
				q.add(bb);
			}
		}
		
		return root;
	}

	public static void main(String[] args) {
		
		
		int[] A = new int[] {1,2,3,4,5,6,7};
		
		//Node<Integer> root = SortedArrayToBST(A,A.length);
		Node<Integer> root = AtoBST2(A,7);
		printLevelWise2(root);
		
		

	}

}
