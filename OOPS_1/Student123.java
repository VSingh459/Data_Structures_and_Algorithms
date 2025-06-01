package lectures;
import java.util.Scanner;

public class Student123 {
	
	String name;
	 final int rollNo;
	 private int mobileNo;
	 
	 private static int count;
	 
	 public static int getCount()
	 {
		 return count;
	 }
	 
	 public Student123(String n,int r)
	 {
		 name = n;
		 rollNo = r;
		 count++;
	 }
	
	public void setmobileNo(int r)
	{
		if (r <= 0)
		{
			return;
		}
		mobileNo = r;
	}
	
	public int getmobileNo()
	{
		return mobileNo;
	}
	

}
