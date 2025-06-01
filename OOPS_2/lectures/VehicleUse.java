package lectures;
import java.util.Scanner;

public class VehicleUse {

	public static void main(String[] args) {
		
		Vehicle v = new Vehicle();
		v.color = "white";
		v.setPrice(1500);
		v.maxSpeed = 50;
		v.print();
		
		System.out.println();
		
		Car c = new Car();
		
		c.color = "Brown";
		c.maxSpeed = 150;
		c.numGear = 5;
		c.mileage = 10;
		
		c.setPrice(2500);
		
		c.print();
		
		
	}

}
