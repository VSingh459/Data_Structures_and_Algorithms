package exception_Handling;
import java.util.Scanner;

public class UserThrow_UserCatch {

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		int balance = 5000;
		System.out.println("Enter the withdrawal amount");
		int w = Obj.nextInt();
		
		try
		{
			if (balance < w)
			{
				throw new ArithmeticException("Insufficient Balance");
			}
			balance = balance - w;
			System.out.println("Transaction Successfully Completed");
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception : "+e.getMessage());
		}
		
		
		System.out.println("Program Continue...");

	}

}
