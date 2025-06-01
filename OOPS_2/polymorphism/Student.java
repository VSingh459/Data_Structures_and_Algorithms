package polymorphism;
import java.util.Scanner;

public class Student extends Human{
	
	int rollNo;
	int  stream;
	
	
	public void print()
	{
		System.out.println("Name of Student = "+name);
	}
	
	public int mobileNO()
	{
		System.out.println("Enter the mobile number");
		Scanner Obj = new Scanner(System.in);
		int m;
		m = Obj.nextInt();
		
		return m;
	}

}
