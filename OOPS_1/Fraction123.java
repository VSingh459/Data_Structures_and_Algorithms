package lectures;
import java.util.Scanner;

public class Fraction123 {
	
	private int num;
	private int denom;
	
	public Fraction123(int num,int denom)
	{
		this.num = num;
		if (denom==0)
		{
			// TODO error out
			return;
			
		}
		this.denom = denom;
		simplify();
	}
	
	public int getDenom()
	{
		return denom;
	}
	
	public int getNum()
	{
		return num;
	}
	
	public void setNum(int n)
	{
		this.num = n;
		simplify();
	}
	
	public void setDenom(int d)
	{
		if (d==0)
		{
			return;
		}
		this.denom = d;
		simplify();
	}
	
	private void simplify()
	{
		int gcd =1;
		int small = Math.min(num, denom);
		for (int i=1;i<=small;i++)
		{
			if (num%i==0 && denom%i==0)
			{
				gcd=i;
			}
		}
		num = num/gcd;
		denom = denom/gcd;
	}
	
	public void print()
	{
		if (denom==1)
		{
			System.out.println(num);
		}
		else
		{
			System.out.println(num+"/"+denom);
		}
	}
	
	public void add(Fraction123 f2)
	{
		this.num = this.num*f2.denom + this.denom*f2.num;
		this.denom = this.denom*f2.denom;
		simplify();
	}
	
	public void mult(Fraction123 f2)
	{
		this.num = this.num*f2.num;
		this.denom = this.denom*f2.denom;
		simplify();
	}
	
	public static Fraction123 add(Fraction123 f1,Fraction123 f2)
	{
		int newNum = f1.num*f2.denom + f2.num*f1.denom;
		int newDenom = f1.denom*f2.denom;
		Fraction123 f = new Fraction123(newNum,newDenom);
		return f;
	}

	

}