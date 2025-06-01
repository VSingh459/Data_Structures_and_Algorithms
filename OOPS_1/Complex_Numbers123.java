package tasks;
import java.util.Scanner;

public class Complex_Numbers123 {
	
	private int real;
	private int imag;
	
	public Complex_Numbers123(int real,int imag)
	{
		this.real = real;
		this.imag = imag;
		
	}
	
	public int getImag()
	{
		return imag;
	}
	
	public int getReal()
	{
		return real;
	}
	
	public void setImag(int imag)
	{
		this.imag = imag;
	}
	
	public void setReal(int real)
	{
		this.real = real;
	}
	
	public void print()
	{
		if (imag==0)
		{
			System.out.println(real);
		}
		else if (imag > 0)
		{
			System.out.println(real+" + "+"i"+imag);
		}
		else
		{
			System.out.println(real+" - "+"i"+(-1*imag));
		}
	}
	
	public void plus(Complex_Numbers123 f2)
	{
		this.real = this.real + f2.real;
		this.imag = this.imag + f2.imag;
	}
	
	public void multiply(Complex_Numbers123 f2)
	{
		int a = this.real;
		this.real = this.real*f2.real - this.imag*f2.imag;
		
		this.imag = a*f2.imag + this.imag*f2.real;
	}
	
	

    }
 
    


