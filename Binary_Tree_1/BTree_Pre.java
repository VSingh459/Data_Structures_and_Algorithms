package Lectures;
import java.util.LinkedList;

public class BTree_Pre<T> {
	
	public Root<T> Create_Node(T elem)
	{
		Root x = new Root();
		x.data = elem;
		x.left = null;
		x.right = null;
		return x;
	}
	
	public void PreOrder(Root x)
	{
		if (x != null)
		{
			System.out.println(x.data);
			PreOrder(x.left);
			PreOrder(x.right);
		}
	}
}
