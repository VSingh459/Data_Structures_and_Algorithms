package DynamicPrograming_2;
import java.util.ArrayList;

public class LongestCommonSub {
	
	private static ArrayList<ArrayList<Integer>> dp;
	private static ArrayList<ArrayList<Integer>> dpTab;
	
	public static int lcsTAB(String str1,String str2)
	{
		int n = str1.length();
		int m = str2.length();
		
		for (int i=0;i<=n;i++)
		{
			dpTab.get(i).set(0, 0);
		}
		for (int j=0;j<=m;j++)
		{
			dpTab.get(0).set(j, 0);
		}
		
		for (int i=1;i<=n;i++)
		{
			for (int j=1;j<=m;j++)
			{
				char a = str1.charAt(i-1);
				char b = str2.charAt(j-1);
	
				if (a==b)
				{
					int aa = 1+dpTab.get(i-1).get(j-1);
					dpTab.get(i).set(j, aa);
				}
				else
				{
					int aa = Math.max(dpTab.get(i-1).get(j),dpTab.get(i).get(j-1));
					dpTab.get(i).set(j, aa);
				}
			}
		}
		
		return dpTab.get(n).get(m);
		
	}
	
	public static int lcsMEMO(String str1,String str2,int i,int j)
	{
		if (i < 0 || j < 0)
		{
			return 0;
		}
		
		if (dp.get(i).get(j) != -1)
		{
			return dp.get(i).get(j);
		}
		
		char a = str1.charAt(i);
		char b = str2.charAt(j);
		
		if (a == b)
		{
			int aa = 1+lcsMEMO(str1,str2,i-1,j-1);
			 dp.get(i).set(j, aa);
			 return aa;
		}
		
		int aa = Math.max(lcsMEMO(str1,str2,i-1,j),lcsMEMO(str1,str2,i,j-1));
		 dp.get(i).set(j, aa );
		 return aa;
	
	}
	
	public static int lcsRec(String str1,String str2,int i,int j)
	{
		if (i < 0 || j < 0)
		{
			return 0;
		}
		
		char a = str1.charAt(i);
		char b = str2.charAt(j);
		
		if (a == b)
		{
			return 1 + lcsRec(str1,str2,i-1,j-1);
		}
		
		int ans = Math.max(lcsRec(str1,str2,i-1,j),lcsRec(str1,str2,i,j-1));
		return ans;
	}
	
	public static int lcs(String s, String t)
	{
		int n = s.length();
		int m = t.length();
		
		dp = new ArrayList<>();
		for (int i=0;i<n;i++)
		{
			ArrayList<Integer> row = new ArrayList<>();
			for (int j=0;j<m;j++)
			{
				row.add(-1);
			}
			dp.add(row);
		}
		
		//return lcsRec(s,t,n-1,m-1);
		return lcsMEMO(s,t,n-1,m-1);
	}

	public static void main(String[] args) {
		
		String s = "abcdb";
		String t = "bcacdhb";
	
		
		dpTab = new ArrayList<>();
		for (int i=0;i<=s.length();i++)
		{
			ArrayList<Integer> row1 = new ArrayList<>();
			for (int j=0;j<=t.length();j++)
			{
				row1.add(-1);
			}
			dpTab.add(row1);
		}
		
		//int ans = lcs(s,t);
		int ans = lcsTAB(s,t);
		System.out.println(ans);

	}

}
