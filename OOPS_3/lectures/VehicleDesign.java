package lectures;
import java.util.Scanner;
import generics.PrintInterface;

public class VehicleDesign implements PrintInterface {
	
	String color;
	int maxSpeed;
	
	public VehicleDesign(int Spee)
	{
		this.maxSpeed = Spee;
	}
	
	public  void print()
	{
		System.out.println("Max Speed of Vehicle is = "+maxSpeed);
	}

}
