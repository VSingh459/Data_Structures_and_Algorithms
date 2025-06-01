package tasks;
import java.util.Scanner;

public class ComplexUse {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the real part of complex number");
		int real1 = s.nextInt();
		System.out.println("Enter the imaginary part of complex number");
		int imaginary1 = s.nextInt();
		
		System.out.println("Enter the real part of 2nd complex number");
		int real2 = s.nextInt();
		System.out.println("Enter the imaginary part of 2nd complex number");
		int imaginary2 = s.nextInt();

		Complex_Numbers123 c1 = new Complex_Numbers123(real1, imaginary1);
		Complex_Numbers123  c2 = new Complex_Numbers123(real2, imaginary2);
		
		System.out.println("Enter the choice");

		int choice = s.nextInt();
		 
		if(choice == 1) {
			// Add
			c1.plus(c2);
			c1.print();
		}
		else if(choice == 2) {
			// Multiply
			c1.multiply(c2);
			c1.print();
		}
		else {
			return;
		}

	}

}
