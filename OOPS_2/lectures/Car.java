package lectures;
import java.util.Scanner;

public class Car  extends Vehicle{
	
	int numGear;
	int mileage;
	int  weight;
	
	
	
	public void print()
	{
		System.out.println("Good");
		System.out.println("Color = "+color);
		this.weight = 10;
		super.weight = 20;
		super.print();
	}

}
