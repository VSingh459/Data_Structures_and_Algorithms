package graphs_1;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BreadthFirst {
	
	public static void printBFSHelper(int adjMat[][],int sv,boolean[] status)
	{
		Queue<Integer> q = new LinkedList<>();
		q.add(sv);
		status[sv] = true;
		while (!q.isEmpty())
		{
			int curr = q.poll();
			System.out.print(curr+" ");
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
			System.out.println();
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
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
		
		printBFS(adjMat);
		
		

	}

}
