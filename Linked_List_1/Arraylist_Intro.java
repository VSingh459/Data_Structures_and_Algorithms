package lectures;
import java.util.Scanner;
import java.util.ArrayList;

public class Arraylist_Intro {
	
	public static void main(String[] args)
	{
		
		ArrayList<Integer> list1 = new ArrayList<>();
		
		System.out.println(list1.size()); 
		list1.add(15);
		list1.add(20);
		list1.add(25);
		System.out.println(list1.size());
		System.out.println(list1.get(2));
		
		System.out.println();
		for (int elem : list1)
		{
			System.out.print(elem+" ");
		}
		System.out.println();
		
		
		System.out.println();
		for (int i=0;i<list1.size();i++)
		{
			System.out.print(list1.get(i)+" ");
		}
		System.out.println();
		
		list1.add(0, 50);
		
		
		
		System.out.println();
		for (int i=0;i<list1.size();i++)
		{
			System.out.print(list1.get(i)+" ");
		}
		System.out.println();
		
		list1.remove(1);
		
		System.out.println();
		for (int i=0;i<list1.size();i++)
		{
			System.out.print(list1.get(i)+" ");
		}
		System.out.println();
		
		list1.set(2, 100);
		
		System.out.println();
		for (int i=0;i<list1.size();i++)
		{
			System.out.print(list1.get(i)+" ");
		}
		System.out.println();
		
		
		
		
	
	
	}

}
