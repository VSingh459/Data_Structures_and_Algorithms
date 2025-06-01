package part_2;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class In_Pre {
	
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
	
	
	public static Node<Integer> builtTree(int[] pre,int[] in)
	{
		
		if (pre.length == 1)
		{
			Node<Integer> r = new Node<Integer>(pre[0]);
			return r;
		}
		int r = pre[0];
		Node<Integer> root = new Node<Integer>(r);
		int f=-1;
		int c=0;
		
		while (f != r)
		{
			f = in[c];
			c++;
		}
		int[] t1 = new int[c];
		int[] t2 = new int[c];
		
		for (int i=0;i<c;i++)
		{
			t1[i] = in[i];
			t2[i] = pre[i+1];
		}
		
		int s = in.length-c-1;
		
		int[] t3 = new int[s];
		int[] t4 = new int[s];
		
		for (int i=c+1;i<=s;i++)
		{
			t3[i]  = in[i];
			t4[i] = pre[i];
		}
		
		Node<Integer> left = builtTree(t2,t1);
		Node<Integer> right = builtTree(t4,t3);
		
		root.left = left;
		root.right = right;
		
		return root;
		
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
	
	public static Node<Integer> buildBTree(int[] pre,int[] in,int inStart,int inEnd,int index)
	{
		if (inStart > inEnd)
		{
			return null;
		}
		
		Node<Integer> root = new Node<Integer>(pre[index]);
		int pos = search(in,pre[index],inStart,inEnd);
		
		root.left = buildBTree(pre,in,inStart,pos-1,index+1);
		root.right = buildBTree(pre,in,pos+1,inEnd,index+(pos-inStart)+1);
		
		return root;
	}

	public static void main(String[] args) {
		
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the total no of nodes of the tree");
		int total = obj.nextInt();
		
		System.out.println("Enter the preOrder of the tree");
		int[] p = new int[total];
		for (int i=0;i<total;i++)
		{
			p[i] = obj.nextInt();
		}
		
		System.out.println("Enter the inOrder of the tree");
		int[] in = new int[total];
		for (int i=0;i<total;i++)
		{
			in[i] = obj.nextInt();
		}
		
		Node<Integer> result = buildBTree(p,in,0,in.length-1,0);
		
		printLevelWise(result);
		
	}

}
