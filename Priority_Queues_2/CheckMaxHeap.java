package priority_Queues_2;
import java.util.PriorityQueue;

public class CheckMaxHeap {
	
	public static boolean checkMH(int arr[])
	{
		
		 for (int i=0;i<arr.length;i++)
			{
				int x = arr[i];
				int left = i*2+1;
				int right = i*2+2;
				
				if (left < arr.length)
				{
					if (x < arr[left])
					{
						return false;
					}
					if (right < arr.length && x < arr[right])
					{
						return false;
					}
					
				}
				
			}
			
			return true;
	}

	public static void main(String[] args) {
		
		int[] a = {5,4,3,2,1};
		
		boolean ans = checkMH(a);
		System.out.println(ans);

	}

}
