package Dynamic_Programming_1;
import java.util.ArrayList;

public class PrintSubsequenceArray {
	
	public static void printSubsequence(int[] arr,int index,ArrayList<Integer> sub)
	{
		if (index == arr.length)
		{
			if (sub.size()==0)
			{
				System.out.println("{}");
			}
			else
			{
				System.out.println(sub);
			}
			return;
		}
		
		sub.add(arr[index]);
		printSubsequence(arr,index+1,sub);
		sub.remove(sub.size()-1);
		printSubsequence(arr,index+1,sub);
	}

	public static void main(String[] args) {
		
		 int[] arr = {3,1,2};
	       
	      ArrayList<Integer> path = new ArrayList<>();
	       
	      printSubsequence(arr, 0, path);

	}

}
