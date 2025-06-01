package lectures;
import java.util.Scanner;

public class FractionUse {

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		
		int a,b;
		System.out.println("Enter the numerator of fraction");
		a = Obj.nextInt();
		System.out.println("Enter the denominator of fraction");
		b = Obj.nextInt();
		
		Fraction123 f1 = new Fraction123(a,b);
		f1.print();
		
		f1.setNum(12);
		
		int d = f1.getDenom();
		System.out.println(d);
		f1.print();
		
		f1.setNum(10);
		f1.setDenom(30);
		f1.print();
		
		Fraction123 f2 = new Fraction123(3,4);
		f1.add(f2);
		f1.print();
		f2.print();
		
		Fraction123 f3 = new Fraction123(4,5);
		f3.mult(f2);
		f3.print();
		
		Fraction123 f4 =  Fraction123.add(f1, f3);
		f1.print();
		f3.print();
		f4.print();
		
		
		

	}

}
