package lectures;
import java.util.Scanner;

public class Dynamic_ArrayUSe {

	public static void main(String[] args) {
		
		Dynamic_Array123 d = new Dynamic_Array123();
		
		for (int i=0;i<100;i++)
		{
			d.add(i+10);
		}
		System.out.println(d.size());
		d.set(4, 10);
		System.out.println(d.get(3));
		System.out.println(d.get(4));
		
		while(!d.isEmpty())
		{
			System.out.println(d.removeLast());
			System.out.println("size  = "+d.size());
		}
		
	}
}
