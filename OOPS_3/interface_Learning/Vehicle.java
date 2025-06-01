package interface_Learning;
import java.util.Scanner;

public class Vehicle implements  Vehicle22_Interface {
	
	public String getCompany()
	{
		String name = "Renault";
		return name;
	}
	
	public int getMaxSpeed()
	{
		int s = 250;
		return s;
	}
	
	public void print()
	{
		System.out.println("Good");
	}
	
	

}
