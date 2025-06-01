package part_1;

public class MyNode {
	
	Node<Integer> bst;
	int l;
	int r;
	
	public MyNode(Node<Integer> n,int lValue,int rValue)
	{
		l = lValue;
		r = rValue;
		bst = n;
	}

}
