package tasks;
import java.util.Scanner;

public class PolynomialUse {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		RealPolynomial p1 = new RealPolynomial();
		
		p1.setCoefficient(3, 1);
		p1.setCoefficient(1, 2);
		p1.setCoefficient(7, 3);
		//p1.setCoefficient(5, 6);
		p1.print();
		System.out.println();
		
		RealPolynomial p2 = new RealPolynomial();
		p2.setCoefficient(2, 7);
		p2.setCoefficient(1, 8);
		//p2.setCoefficient(1, 4);
		//p2.setCoefficient(2, 5);
		p2.print();
		System.out.println();

		RealPolynomial p3 = new RealPolynomial();
		
		p3 = p1.subtract(p2);
		p3.print();
		
		
		
		
		
		
	
		
//		int n = s.nextInt();
//		int degree1[] = new int[n];
//		for(int i = 0; i < n; i++){
//			degree1[i] = s.nextInt();
//		}
//		int coeff1[] = new int[n];
//		for(int i = 0; i < n; i++){
//			coeff1[i] = s.nextInt();
//		}
//		RealPolynomial first = new RealPolynomial();
//		for(int i = 0; i < n; i++){
//			first.setCoefficient(degree1[i],coeff1[i]);
//		}
//		
//		//first.print();
//		//System.out.println();
//		n = s.nextInt();
//		int degree2[] = new int[n];
//		for(int i = 0; i < n; i++){
//			degree2[i] = s.nextInt();
//		}
//		 int coeff2[] = new int[n];
//		for(int i = 0; i < n; i++){
//			coeff2[i] = s.nextInt();
//		}
//		RealPolynomial second = new RealPolynomial();
//		for(int i = 0; i < n; i++){
//			second.setCoefficient(degree2[i],coeff2[i]);
//		}
//		int choice = s.nextInt();
//		RealPolynomial result;
//		switch(choice){
//		// Add
//		case 1: 
//			 result = first.add(second);
//			result.print();
//			break;
//		// Subtract	
//		case 2 :
//			 result = first.subtract(second);
//			result.print();
//			break;
//		// Multiply
//		case 3 :
//			 result = first.multiply(second);
//			result.print();
//			break;
//		}

	}

}
