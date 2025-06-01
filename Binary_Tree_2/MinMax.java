package part_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinMax {
	
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
	
	private static Pair<Integer,Integer> maxMin=new Pair<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
	
	private static void getMinAndMaxHelper(Node<Integer> root)
    {
        if (root==null)
        {
            return;
        }
        
        int rootData=root.data;
        int maxVal=maxMin.maximum;
        if (rootData>maxVal)
        {
            maxMin.maximum=root.data;
        }
        
        int minVal=maxMin.minimum;
        if (rootData<minVal)
        {
            maxMin.minimum=root.data;
        }
        getMinAndMaxHelper(root.left);
        getMinAndMaxHelper(root.right);
    }
	

	
	public static Pair<Integer, Integer> getMinAndMax(Node<Integer> root)
	{
		getMinAndMaxHelper(root);
        return maxMin;     
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

	public static void main(String[] args) {
		
		Node<Integer> root = takeInputLevelWise();
		
//		Pair<Integer,Integer> ans = getMinAndMax(root);
//		System.out.println("Maximum is = " + ans.maximum);
//		System.out.println("Minimum is = " + ans.minimum);
		
		printLevelWise2(root);

	}

}
