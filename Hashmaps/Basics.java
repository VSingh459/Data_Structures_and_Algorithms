package hashmaps;
import java.util.HashMap;
import java.util.*;

public class Basics {
	
	public static void  main(String[]  args)
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("abc", 1);
		map.put("def",3);
		
		if (map.containsKey("abc"))
		{
			System.out.println("Map has abc");
		}
		
		if (map.containsKey("abc1"))
		{
			System.out.println("Map has xxx");
		}
		
		int v = map.get("abc");
		System.out.println(v);
		
		int v1=0;
		
		if (map.containsKey("abc1"))
		{
			 v1 = map.get("abc1");
			System.out.println(v1);
		}
		
		
		map.remove("abc");
		if (map.containsKey("abc"))
		{
			System.out.println("Map has abc");
		}
		
		map.put("ghi", 5);
		map.put("ghi", 10);
		map.put("xyz", 15);
		
		System.out.println(map.size());
		
		// Iteration
		
		Set<String> keys = map.keySet();
		for (String s:keys)
		{
			System.out.println(s);
		}
		
			
	}
	
}
