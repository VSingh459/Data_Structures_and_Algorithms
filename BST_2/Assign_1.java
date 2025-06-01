package part_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;


public class Assign_1 {
	
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
	
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(Node<Integer> root)
	{
		ArrayList<LinkedListNode<Integer>> ans = new ArrayList<>();
		if(root == null)
		return ans;
		
		Queue<Node<Integer>> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty())
		{
		int size = q.size();
		LinkedListNode<Integer> level = new LinkedListNode<>(0);
		LinkedListNode<Integer> head = null;
		while(size-- > 0)
		{
		Node<Integer> temp = q.poll();
		if(temp.left != null)
		q.add(temp.left);
		if(temp.right != null)
		q.add(temp.right);
		if(head == null)
		{
		LinkedListNode<Integer> newNode = new LinkedListNode<>(temp.data);
		level=newNode;
		head = newNode;
		}
		else
		{
		LinkedListNode<Integer> newNode = new LinkedListNode<>(temp.data);
		level.next=newNode;
		level=level.next;
		}
		}
		ans.add(head);
		}
		return ans;
		
		}
	
	public static void traversal(LinkedListNode<Integer> head)
	{
		LinkedListNode<Integer> temp = head;
		
		while (temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
		
		
	

	public static void main(String[] args) {
		
		Node<Integer> root = takeInputLevelWise();
		
		ArrayList<LinkedListNode<Integer>> a = constructLinkedListForEachLevel(root);
		
		for (int i=0;i<a.size();i++)
		{
			LinkedListNode<Integer> b = a.get(i);
			traversal(b);
			System.out.println();
			
		}
	

	}

}
