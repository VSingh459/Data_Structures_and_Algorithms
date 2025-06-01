package polymorphism;
import java.util.Scanner;

public class HumanUse {

	public static void main(String[] args) {
		
		Human h;
		h = new Student();
		int mob;
	    //mob = h.mobileNo();
		//h.print();
		
		h.age = 30;
		
		System.out.println("THe age of student is = "+h.age);
		
		//h.rollNo = 55;
	

	}

}
