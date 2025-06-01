package backTracking;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class CombinationSum {
	
	
	private static void generateComb(int[] arr,List<Integer> curr,List<List<Integer>> res,int index,int target)
	{
		if (target==0)
		{
			res.add(new ArrayList<>(curr));
			return;
		}
		
		for (int i=index;i<arr.length;i++)
		{
			if (arr[i] > target)
			{
				break;
			}
			
			curr.add(arr[i]);
			
			generateComb(arr,curr,res,i,target-arr[i]);
			curr.remove(curr.size()-1);
		}
		
		
	}
	
	private static List<List<Integer>> ans = new ArrayList<>();
	
	
	public static List<List<Integer>> combSum(int[] arr,int B)
	{
		if (arr == null || arr.length == 0) {
            return ans;
        }
		
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(arr);
		
		generateComb(arr,temp,ans,0,B);
		return ans;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3};
 
        int sum = 5;
 
        List<List<Integer> > ans = combSum(arr,sum);
 
        // If result is empty, then
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
		
		

	}

}
