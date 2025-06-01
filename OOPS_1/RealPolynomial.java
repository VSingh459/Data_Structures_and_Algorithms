package tasks;

public class RealPolynomial {
	
	private int dc[];
	private int index;
	
	public  RealPolynomial()
	{
		dc = new int[100];
		index = 0;
	}
	
	public int[] restructure(int data[])
	{
		int temp[] = data;
		data = new int[data.length*2];
		
		for (int i=0;i<temp.length;i++)
		{
			data[i] = temp[i];
		}
		return data;
		
	}
	
	public void setCoefficient(int degree,int coeff)
	{
		if (degree > dc.length-1)
		{
			dc = restructure(dc);
		}
		
				dc[degree] = coeff;
	}
	
	public int getDegree()
	{
		int r=0;
		for (int i=0;i<dc.length;i++)
		{
			if (dc[i] !=0)
			{
				r = i;
			}
		}

		return r;
		
	}
	
	public void print()
	{
		index = getDegree();
	
		for (int i=0;i<=index;i++)
		{
			if (dc[i] != 0)
			{
				System.out.print(dc[i]+"x"+i+" ");
			}
		}
	}
	
	public RealPolynomial multiply(RealPolynomial p)
	{
		RealPolynomial xx = new RealPolynomial();
		
		int n = getDegree();
		int m = p.getDegree();
		int k = m+n;
		xx.dc = new int[k+1];
		
		
		
		for (int i=0;i<=n;i++)
		{
			for (int j=0;j<=m;j++)
			{
				//System.out.println("HHH");
				k = i+j;
				xx.setCoefficient(k,xx.dc[k]+dc[i]*p.dc[j]);
			}
		}
		
		return xx;
	}
	
	public RealPolynomial add(RealPolynomial p)
	{
		RealPolynomial xx = new RealPolynomial();
		
		int s=0;
		int g=0;
		int n = getDegree();
		int m = p.getDegree();
		int k;
		if (n>m)
			k=n;
		else
			k=m;
		
		xx.dc = new int[k+1];
		
		for (int i=0;i<dc.length;i++)
		{
			xx.setCoefficient(i, dc[i]+p.dc[i]);
				
				
	    }
				
		return xx;
	}
	
	public RealPolynomial subtract(RealPolynomial p)
	{
		RealPolynomial xx = new RealPolynomial();
		
		int n = getDegree();
		int m = p.getDegree();
		int k;
		if (n>m)
			k=n;
		else
			k=m;
		
		xx.dc = new int[100];
		
		for (int i=0;i<dc.length;i++)
		{
			xx.setCoefficient(i, xx.dc[i]+dc[i]-p.dc[i]);
				
				
	    }
		
		return xx;
	}
	
	
	
}








