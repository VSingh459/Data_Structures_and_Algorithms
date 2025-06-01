package generics;
import java.util.Scanner;
import lectures.VehicleDesign;


public class BoundedGeneric_Use {
	
	public static<T extends  PrintInterface> void printArr(T a[])
	{
		for (int i=0;i<a.length;i++)
		{
			a[i].print();
		}
		System.out.println();
	}
	
	

	
	

	public static void main(String[] args) {
	
		VehicleDesign v[] = new VehicleDesign[5];
		
		for (int i=0;i<v.length;i++)
		{
			v[i] = new VehicleDesign(i+1);
		}
		
		printArr(v);
		
		Student s[] = new Student[5];
		
		for (int j=0;j<s.length;j++)
		{
			s[j] = new Student(j+10);
		}
		System.out.println();
		
		printArr(s);

	}

}
