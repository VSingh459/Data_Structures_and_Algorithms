package assignments;



public class NodeA<T> {
	
	T data;
	NodeA<T> next;
	
	public NodeA(T data)
	{
		this.data = data;
		this.next = null;	
	}

}
