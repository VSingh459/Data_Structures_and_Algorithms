package graphs_1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsConnected {
	
	private static int counter;
	
	public static boolean isConnected(int[][] adjMat)
	{
		if (adjMat.length==0)
		{
			return true;
		}
		counter = 0;
		printBFS(adjMat);
		if (counter==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	
		
	}
	
	public static void printBFSHelper(int adjMat[][],int sv,boolean[] status)
	{
		counter++;
		Queue<Integer> q = new LinkedList<>();
		q.add(sv);
		status[sv] = true;
		while (!q.isEmpty())
		{
			int curr = q.poll();
			for (int i=0;i<adjMat.length;i++)
			{
				int neigh = adjMat[curr][i];
				if (neigh == 1 && status[i] == false)
				{
					status[i] = true;
					q.add(i);
				}
			}
		}
		
	}
	
	public static void  printBFS(int[][] adjMat)
	{
		boolean[] status = new boolean[adjMat.length];
		for (int i=0;i<adjMat.length;i++)
		{
			status[i] = false;
		}
		
		for (int i=0;i<status.length;i++)
		{
			if (!status[i])
			{
				printBFSHelper(adjMat,i,status);
			}
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Enter the number of nodes in Graph");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Enter the number of edges in Graph");
		int e = s.nextInt();
		
		int adjMat[][] = new int[n][n];
		System.out.println("Enter the Coordinates of edges that connect the nodes ");
		for (int i=0;i<e;i++)
		{
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			adjMat[v1][v2] = 1;
			adjMat[v2][v1] = 1;
			
		}
		
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				System.out.print(adjMat[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		boolean ans = isConnected(adjMat);
		System.out.println(ans);

	}

}
