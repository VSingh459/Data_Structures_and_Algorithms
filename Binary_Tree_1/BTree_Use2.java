package Lectures;
import java.util.LinkedList;

public class BTree_Use2 {
	
	public static void PreOrder2(BT_Node<Integer> root)
	{
		if (root == null)
		{
			return;
		}
		
		System.out.println(root.data);
		PreOrder2(root.left);
		PreOrder2(root.right);
		
	}

	public static void main(String[] args) {
		
		BT_Node<Integer> root = new BT_Node<>(1);
		BT_Node<Integer> rootLeft = new BT_Node<>(2);
		BT_Node<Integer> rootRight = new BT_Node<>(3);
		
		root.left = rootLeft;
		root.right = rootRight;
		
		BT_Node<Integer> rlRight = new BT_Node<>(4);
		BT_Node<Integer> rrLeft = new BT_Node<>(5);
		
		rootLeft.right = rlRight;
		rootRight.left = rrLeft;
		
		PreOrder2(root);
		
		
	}

}
