package generics;
import java.util.Scanner;

public class PairGeneric<T> {
	
	private T first;
	private T second;
	
	public PairGeneric(T first,T second)
	{
		this.first = first;
		this.second = second;
	}
	
	public T getFirst()
	{
		return first;
	}
	
	public T getSecond()
	{
		return second;
	}
	
	public void setFirst(T first)
	{
		this.first = first;
	}
	
	public void setSecond(T second)
	{
		this.second = second;
	}

}
