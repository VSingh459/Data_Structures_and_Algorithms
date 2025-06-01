package generics;
import java.util.Scanner;

public class GenericPrint {
	
	public static<T> void printArr(T a[])
	{
		for (int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args)
	{
		Scanner Obj = new Scanner(System.in);
		Integer p[] = new Integer[5];
		System.out.println("Enter the elements of array int");
		for (int i=0;i<p.length;i++)
		{
			p[i] = Obj.nextInt();
		}
		
		printArr(p);
		
		Double d[] = new Double[5];
		System.out.println("Enter the elements of the double array");
		
		for (int i=0;i<d.length;i++)
		{
			d[i] = Obj.nextDouble();
		}
		
		printArr(d);
		
	}


}
