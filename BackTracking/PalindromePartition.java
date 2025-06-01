package backTracking;
import java.util.List;
import java.util.ArrayList;

public class PalindromePartition {
	
	public static int count=0;
	
	public static boolean isPalindrome(String str)
    {
        String rev = "";

        boolean ans = false;

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        if (str.equals(rev)) {
            ans = true;
        }
        return ans;
    }
	
	public static void partitionHelp(String s,List<List<String>> res,List<String> curr,int start)
	{
		count++;
		if (start==s.length())
		{
			res.add(new ArrayList<>(curr));
			return;
		}
		
		for (int end = start + 1; end <= s.length(); end++) 
		{
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) 
            {
                curr.add(substring);
                partitionHelp(s,res,curr,end);
                curr.remove(curr.size() - 1);
            }
        }
		
		
	}
	
	public static List<List<String>> partition(String s)
	{
		List<List<String>> ans = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		
		partitionHelp(s,ans,temp,0);
		
		return ans;
	}

	public static void main(String[] args) {
		
		String s = "BaaB";
		List<List<String>> ans = partition(s);
		
		if (ans.size() == 0) {
            System.out.println("Empty");
            return;
        }
 
        // print all combinations stored in ans
 
        for (int i = 0; i < ans.size(); i++) {
 
            System.out.print("(");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print(") ");
        }
        System.out.println();
        
        System.out.println("Count = "+count);
				
				
				
				

	}

}
