package lectures;
import java.util.Scanner;

public class Vehicle {
	
	protected String color;
	int maxSpeed;
	private int price;
	int weight;
	
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public void print()
	{
		System.out.println("Vehicle Color = "+color);
		System.out.println("Max Speed of Vehicle is = "+maxSpeed);
		System.out.println("Price of the Vehicle is = "+getPrice());
	}

}
