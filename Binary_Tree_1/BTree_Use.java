package Lectures;
import java.util.LinkedList;

public class BTree_Use {

	public static void main(String[] args) {
		
		BTree_Pre<Integer> x = new BTree_Pre<>();
		
		Root<Integer> y = new Root<>();
		
		y = x.Create_Node(1);
		y.left = x.Create_Node(2);
		y.right = x.Create_Node(3);
		
		
		//y.left.left = x.Create_Node(4);
		y.left.right = x.Create_Node(4);
		
		//y.right.left = x.Create_Node(6);
		y.right.right = x.Create_Node(5);
		
		x.PreOrder(y);
		
	

	}

}
