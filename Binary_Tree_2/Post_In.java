package part_2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Post_In {
	
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
	
	public static int search(int[] in,int target,int start,int end)
	{
		for (int i=start;i<=end;i++)
		{
			if (in[i] == target)
			{
				return i;
			}
		}
		return -1;
	}
	
	public static Node<Integer> buildBTree(int[] post,int[] in,int inStart,int inEnd,int index)
	{
		if (inStart > inEnd)
		{
			return null;
		}
		
		Node<Integer> root = new Node<Integer>(post[index]);
		int pos = search(in,post[index],inStart,inEnd);
		
		root.right = buildBTree(post,in,pos+1,inEnd,index-1);
		root.left = buildBTree(post,in,inStart,pos-1,index-(inEnd-pos)-1);
		
		return root;
	}

	public static void main(String[] args) {
		
		int[] post = {4,5,2,6,7,3,1};
		int[] in = {4,2,5,1,6,3,7};
		
		Node<Integer> result = buildBTree(post,in,0,in.length-1,in.length-1);
		
		printLevelWise(result);
		
	}

}
