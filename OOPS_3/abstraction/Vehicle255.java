package abstraction;
import java.util.Scanner;

public abstract  class Vehicle255 {
	
	String color;
	int maxSpeed;
	
	public abstract boolean isMotorized();
	
	public abstract int noOfPassengers();
	
	public int getMaxspeed()
	{
		return maxSpeed;
	}
	
	public abstract String getCompany();

}
