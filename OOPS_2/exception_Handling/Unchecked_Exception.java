package exception_Handling;
import java.util.Scanner;

public class Unchecked_Exception {

	public static void main(String[] args) {
		
		try
		{
			System.out.println("Good");
			System.out.println("The output is = "+3/0);
			System.out.println("Well Done");
		}catch(NullPointerException e)
		{
			System.out.println("Exception :"+e.getMessage());
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception is = "+e.getMessage());
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Exception is = "+e.getMessage());
		}
		finally
		{
			System.out.println("Done");
		}
		System.out.println("Hello");

	}

}
