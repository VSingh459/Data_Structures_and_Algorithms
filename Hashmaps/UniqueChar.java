package hashmaps;
import java.util.*;

import java.util.ArrayList;

public class UniqueChar {
	
	public static String uniChar(String str)
	{
		HashMap<Character,Boolean> map = new HashMap<>();
		String out = "";
		
		for (int i=0;i<str.length();i++)
		{
			if (map.containsKey(str.charAt(i)))
			{
				continue;
			}
			
			out = out + str.charAt(i);
			map.put(str.charAt(i), true);
		}
		
		return out;
	}

	public static void main(String[] args) {
		
		String str = "ababacd";
		
		String  ans = uniChar(str);
		System.out.println(ans);

	}

}
