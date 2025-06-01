package tasks;

public class PolynomialClass123 {
	
	private int co[];
	private int indD;
	private int indC;
	private int d[];
	private int multFlag=0;
	
	public PolynomialClass123()
	{
		d = new int[2];
		indD = 0;
		co = new int[2];
		indC = 0;
	}
	
	public void setCoefficient(int deg,int coeff)
	{
		int temp[];
		int flag =0;
		if (indD > d.length-1)
		{
			d = restructure(d);
		}
		if (indC > co.length-1)
		{
			co = restructure(co);
			
		}
		for (int i=0;i<indD;i++)
		{
			if (d[i]==deg && deg !=0 &&  multFlag==0)
			{
				co[i] = coeff;
				flag = 1;
			}
		}
		if (flag==0)
		{
			d[indD] = deg;
			indD++;
			co[indC] = coeff;
			indC++;
			
		}
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
	
	public void print()
	{
		int temp;
		int temp1;
		for (int i=0;i<indD;i++)
		{
			for (int j=i+1;j<indD;j++)
			{
				if (d[i] > d[j])
				{
					temp = d[i];
					d[i] = d[j];
					d[j] = temp;
					temp1 = co[i];
					co[i] = co[j];
					co[j] = temp1;
				}
				
			}
			
		}
		for (int i=0;i<indD;i++)
		{
			System.out.print(co[i]+"x"+d[i]);
			System.out.print(" ");
		}
	}
	
	public PolynomialClass123 add(PolynomialClass123 p)
	{
		PolynomialClass123 xx = new PolynomialClass123();
		int b;
		int s;
		int flag=0;
	
			int check[] = new int[p.indD];
			
			for (int i=0;i<indD;i++)
			{
				flag=0;
				for (int j=0;j<p.indD;j++)
				{
					if (d[i]==p.d[j])
					{
						check[j] = 1;
						xx.setCoefficient(d[i],(co[i]+p.co[j]));
						flag=1;
					}
				}
				if (flag==0)
				{
					xx.setCoefficient(d[i], co[i]);
				}
			}
			for (int k=0;k<p.indD;k++)
			{
				if (check[k]==0)
				{
					xx.setCoefficient(p.d[k], p.co[k]);
				}
			}
			
			return xx;	
	}
	
	public PolynomialClass123 subtract(PolynomialClass123 p)
	{
		PolynomialClass123 xx = new PolynomialClass123();
		int b;
		int s;
		int res;
		int flag = 0;
	
			int check[] = new int[p.d.length];
			
			for (int i=0;i<indD;i++)
			{
				flag=0;
				for (int j=0;j<p.indD;j++)
				{
					if (d[i]==p.d[j])
					{
						flag=1;
						check[j] = 1;
						res = co[i]-p.co[j];
						//System.out.println("res ="+res);
						if (res !=0)
						{
							xx.setCoefficient(d[i],res);
							//System.out.println("Hello");
						}
					}
				}
				if (flag==0)
				{
					xx.setCoefficient(d[i], co[i]);
					
				}
			}
			for (int k=0;k<p.indD;k++)
			{
				if (check[k]==0)
				{
					xx.setCoefficient(p.d[k],(-1* p.co[k]));
				}
			}
			
			return xx;	
	}
	
	public PolynomialClass123 multiply(PolynomialClass123 p)
	{
		PolynomialClass123 xx = new PolynomialClass123();
		
		
		xx.multFlag = 1;
		
		for (int i=0;i<indD;i++)
		{
			for (int j=0;j<p.indD;j++)
			{
				xx.setCoefficient(d[i]+p.d[j], co[i]*p.co[j]);
			}
		}
		
		xx.multFlag = 0;
		
		for (int i=0;i<xx.indD;i++)
		{
			for (int j=i+1;j<xx.indD;j++)
			{
				if (xx.d[i]==xx.d[j] )
				{
					xx.setCoefficient(xx.d[i], xx.co[i]+xx.co[j]);
				}
			}
		}
		
		int FF=0;
		int count=0;
		int ccc=0;
		
		int DD[] = new int[xx.d.length];
		int CC[] = new int[xx.d.length];
		
		for (int i=0;i<xx.indD;i++)
		{
			FF=0;
			for (int j=i+1;j<xx.indD;j++)
			{
				if (xx.d[i]==xx.d[j])
				{
					FF=1;
					ccc++;
				}
			}
			if (FF==0 && xx.co[i] !=0) 
			{
				DD[count] = xx.d[i];
				CC[count] = xx.co[i];
				count++;
			}
	}
	
		for (int i=0;i<DD.length;i++)
		{
			xx.d[i] = DD[i];
			xx.co[i] = CC[i];
		}
		xx.indD = count;
		xx.indC = count;
		
		return xx;
	}
	
	
}
