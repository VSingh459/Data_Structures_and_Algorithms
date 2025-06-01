package generics;
import java.util.Scanner;

public class PairString {
	
	private String first;
	private String second;
	
	public PairString(String first,String second)
	{
		this.first = first;
		this.second = second;
	}
	
	public String getFirst()
	{
		return first;
	}
	
	public String getSecond()
	{
		return second;
	}
	
	public void setFirst(String first)
	{
		this.first = first;
	}
	
	public void setSecond(String second)
	{
		this.second = second;
	}

}
