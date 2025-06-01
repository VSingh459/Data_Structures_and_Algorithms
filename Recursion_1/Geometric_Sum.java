package assignment;
import java.util.Scanner;
import java.util.*;

public class Geometric_Sum {
	
	public static int power(int n,int m)
	{
		
		if (m==0)
		{
			return 1;
		}
		int a;
		a = power(n,m-1)*n;
		return a;
	
	}

	
	public static double  geoSum(int k)
	{
		if (k==0)
		{
			return 1.00000;
		}
		
		int p = power(2,k);
		double f = (double)p;
		double d = (1.00000)/f;
		
		//double d1 = Math.round(d*100000.0)/100000.0;
		//System.out.println(d1);
		
		double ans = geoSum(k-1)+d;
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in);
		System.out.println("Enter the value of  K ");
		int K = Obj.nextInt();
		
		double a = geoSum(K);
		System.out.println();
		System.out.println(a);
		


	}

}
