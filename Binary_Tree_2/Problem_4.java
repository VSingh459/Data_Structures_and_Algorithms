package part_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_4 {
	
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
	
	public static void rTLPathSum(Node<Integer> root, int k,String arr)
    {
        if (root==null)
        {
            return;
        }
        
        int r =root.data;
        arr=arr + r +" ";
        if(k==r && root.left==null && root.right==null)
        {
            
            System.out.println(arr);
            return;
        }
        
        rTLPathSum(root.left,k-r,arr);
        rTLPathSum(root.right,k-r,arr);
    }
	
	public static void  rTLPath(Node<Integer> root,int k)
	{
		String arr = "";
		
		rTLPathSum(root,k,arr);
		
		
	}

	public static void main(String[] args) {
		
		Node<Integer> root = takeInputLevelWise();
		
		rTLPath(root,13);

	}

}
