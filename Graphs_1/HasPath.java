package graphs_1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HasPath {
	
	public static boolean pathExistsOrNot(int[][] adjMat,int curr,boolean[] visited,int end)
	{
		visited[curr] = true;
		for (int i=0;i<adjMat.length;i++)
		{
			if (adjMat[curr][i] == 1 && visited[i] == false)
			{
				if (i==end)
				{
					return true;
				}
				boolean a = pathExistsOrNot(adjMat,i,visited,end);
				if (a==true)
				{
					return true;
				}
			}
		}
		
		return false;	
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException  {
		
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
		
		boolean[] visited = new boolean[adjMat.length];
		for (int i=0;i<adjMat.length;i++)
		{
			visited[i] = false;
		}
		
		System.out.println("Enter the value of V1 and V2");
		int v1 = s.nextInt();
		int v2 = s.nextInt();
		
	
		
		boolean ans = pathExistsOrNot(adjMat,v1,visited,v2);
		System.out.println(ans);
		
		

	}

}
