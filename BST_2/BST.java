package part_2;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	
	private Node<Integer> root;
	//private int size;
	
	private static boolean isPHelper(Node<Integer> root,int x)
	{
		if (root == null)
		{
			return false;
		}
		
		if (root.data == x)
		{
			return true;
		}
		
		if (x < root.data)
		{
			boolean b = isPHelper(root.left,x);
			return b;
		}
		else
		{
			boolean b = isPHelper(root.right,x);
			return b;
		}
		
	}
	
	public boolean isPresent(int x)
	{
		boolean b = isPHelper(root,x);
		return b;
		
	}
	
	private static Node<Integer> insertHelper(Node<Integer> root,int x)
	{
		if (root == null)
		{
			Node<Integer> node = new Node<>(x);
			return node;
		}
		
		
		if (x <= root.data)
		{
			root.left = insertHelper(root.left,x);
		}
		else if (x>root.data)
		{
			root.right = insertHelper(root.right,x);
		}
		
		return root;
		
		
	}
	
	public void insert(int x)
	{
		root = insertHelper(root,x);
		return;
	}
	
	private static Node<Integer> delHelper(Node<Integer> root,int x)
	{
		if (root == null)
		{
			return root;
		}
		
		if (x < root.data)
		{
			root.left = delHelper(root.left,x);
			return root;
		}
		else if ( x > root.data)
		{
			root.right = delHelper(root.right,x);
			return root;
		}
		
		if (root.left == null)
		{
			Node<Integer> temp = root.right;
			return temp;
		}
		else if (root.right == null)
		{
			Node<Integer> t = root.left;
			return t;
		}
		else
		{
			Node<Integer> sp = root;
			
			Node<Integer> s = root.right;
			while (s.left != null)
			{
				sp = s;
				s = s.left;
			}
			
			if (sp != root)
			{
				sp.left = s.right;
			}
			else
			{
				sp.right = s.right;
				
			}
			
			root.data = s.data;
			return root;
		}	
		
	}
	
	public void deleteData(int x)
	{
		root = delHelper(root,x);
		return;
		
	}
	
//	public int size()
//	{
//		
//	}
	
	private static void pTHelper(Node<Integer> root)
	{
		if (root == null)
		{
			return;
		}
		
        System.out.print(root.data+":");
        if (root.left != null)
        {
        	System.out.print("L:"+root.left.data+", ");
        }
        if (root.right != null)
        {
        	System.out.print("R:"+root.right.data+", ");
        }
        System.out.println();
        
        pTHelper(root.left);
        pTHelper(root.right);
		
	}
	
	public void printTree()
	{
		pTHelper(root);
		
	}

}
