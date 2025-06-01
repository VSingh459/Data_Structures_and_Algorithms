package generics;

public class Student implements PrintInterface {
	
	int rollNumber;
	int age;
	
	public Student(int x)
	{
		this.rollNumber = x;
	}
	
	public void print()
	{
		System.out.println("THe roll number of student is = "+rollNumber);
	}

}
