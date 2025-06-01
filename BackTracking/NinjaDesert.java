package backTracking;
import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class NinjaDesert {
	
	private static int close(int a,int b,int target)
	{
		if (a==0)
		{
			return b;
		}
		if (b==0)
		{
			return a;
		}
		
		if (Math.abs(target-a) == Math.abs(target-b))
		{
			return a < b ? a:b;
		}
		
		return (Math.abs(target-a) < Math.abs(target-b) ? a:b);
		
	}
	
	private static int dfs(ArrayList<Integer> top,int i,int sum,int target)
	{
		//System.out.println(i);
		if (i >=top.size())
		{
			return sum;
		}
		
		int a = dfs(top,i+1,sum+top.get(i),target);	
		//System.out.println("Value of a = "+a);
		int b = dfs(top,i+1,sum+top.get(i)*2,target);
		//System.out.println("Value of b = "+b) ;
		
		int c = dfs(top,i+1,sum,target);
		
		sum = close(a,close(b,c,target),target);
		//System.out.println("Value of Sum = "+sum);
		return sum;
		
	}
	
	public static int closestCost(int n,int m, ArrayList<Integer> baseCosts, ArrayList<Integer> toppings,int target)
	{
		int ans = 0;
		for (int i=0;i<n;i++)
		{
			ans = close(dfs(toppings,0,baseCosts.get(i),target),ans,target);
			
		}
		
		return ans;
		
		
	}
	
	

	public static void main(String[] args) {
		
		ArrayList<Integer> b = new ArrayList<>();
		b.add(1);
		b.add(7);
		//b.add(4);
		//b.add(3);
		ArrayList<Integer> t = new ArrayList<>();
		t.add(1);
		t.add(2);
		t.add(3);
		
		int ans = closestCost(2,3,b,t,10);
		System.out.println(ans);
		

	}

}
