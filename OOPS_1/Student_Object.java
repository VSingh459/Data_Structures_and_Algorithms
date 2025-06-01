package lectures;
import java.util.Scanner;

public class Student_Object {

	public static void main(String[] args) {
		
		Student123  stu1 = new Student123("Ankush",123);
		
//		stu1.name = "Ankush";
     	//stu1.rollNo = 123;
		
		//stu1.setmobileNo(999888);
		
		System.out.println(stu1);
		
		System.out.println(stu1.getmobileNo());
		System.out.println(stu1.rollNo);
		System.out.println(stu1.name);
		
		Student123  stu2 = new Student123("Mary",201);
		
		System.out.println();
		//System.out.println(stu1.count);
		//System.out.println(stu2.count);
		//System.out.println(Student123.count);
		
		//Student123.count = 10;
		
		int c = Student123.getCount();
		System.out.println(c);
		

	}

}
