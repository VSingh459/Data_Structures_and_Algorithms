package part_2;

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
	
	
//	private static Node_Info largestBST(Node<Integer> root)
//	{
//		if (root == null)
//		{
//			Node_Info ans = new Node_Info(0,Integer.MIN_VALUE,Integer.MAX_VALUE,true);
//			return ans;
//		}
//		
//		Node_Info left = largestBST(root.left);
//		Node_Info right = largestBST(root.right);
//		
//		Node_Info ret = new Node_Info();
//		
//		ret.min = Math.min(left.min, root.data);
//		ret.max = Math.max(right.max, root.data);
//		ret.isBST = (left.isBST && right.isBST) && (root.data>left.max && root.data<right.min);
//		
//		if (ret.isBST)
//		{
//			ret.size = left.size + right.size + 1;
//		}
//		else
//		{
//			ret.size = Math.max(left.size, right.size);
//		}
//		
//		return ret;
//		
//	}
//	
//	public static int largestBSTSubtree(Node<Integer> root)
//	{
//		Node_Info ans = largestBST(root);
//		return ans.size;
//	}
	
	private static int Height(Node<Integer> root)
    {
        if (root==null)
            return 0;
        
        if (root.left==null && root.right==null)
            return 1;
        
        return Math.max(Height(root.left),Height(root.right))+1;
    }
    
    private static boolean isBST(Node<Integer> root, int min, int max)
    {
        if(root == null)
			return true;
		
        if(root.data < min || root.data > max)
			return false;
		else
			return isBST(root.left,min,root.data -1) && isBST(root.right,root.data +1,max);
    }
    
    public static int largestBSTSubtree(Node<Integer> root) {
		// Write your code here
        if (root==null)
            return 0;
        
        if (isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE))
            return Height(root);
        else
        {
        	return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
        }
            
	}

	
	

	public static void main(String[] args) {
	
		
		Node<Integer> root = takeInputLevelWise();
		
		int a = largestBSTSubtree(root);
		System.out.println(a);

	}

}
