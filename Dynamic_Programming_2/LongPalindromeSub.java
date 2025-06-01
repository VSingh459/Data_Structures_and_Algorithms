package DynamicPrograming_2;
import java.util.ArrayList;

public class LongPalindromeSub {
	
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
	
	public static int longPalSub(String str)
	{
		
		
		String rev = "";
		char ch;
		for (int i=0;i<str.length();i++)
		{
			ch = str.charAt(i);
			rev = ch+rev;
		}
		
		return lcsTAB(str,rev);
		
	}

	public static void main(String[] args) {
		
		String s = "bbabcbcab";
		
		dpTab = new ArrayList<>();
		for (int i=0;i<=s.length();i++)
		{
			ArrayList<Integer> row1 = new ArrayList<>();
			for (int j=0;j<=s.length();j++)
			{
				row1.add(-1);
			}
			dpTab.add(row1);
		}
		
		int ans = longPalSub(s);
		System.out.println(ans);

	}

}
