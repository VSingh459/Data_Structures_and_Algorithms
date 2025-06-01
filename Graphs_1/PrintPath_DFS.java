package graphs_1;
import java.util.Scanner;

public class PrintPath_DFS {
	
	public static void dfsPrint(int[][] adjMat,int curr,boolean[] visited,int end)
	{
		if (visited[end] == true)
		{
			return;
		}
		visited[curr] = true;
		System.out.print(curr+" ");
		for (int i=0;i<adjMat.length;i++)
		{
			if (adjMat[curr][i] == 1 && visited[i] == false)
			{
				dfsPrint(adjMat,i,visited,end);
			}
		}
		
	}
	
	public static void pathExistsOrNot(int[][] adjMat,boolean[] visited,int curr,int v1,int v2)
	{
		if (visited[v2] == true)
		{
			return;
		}
		visited[curr] = true;
		for (int i=0;i<adjMat.length;i++)
		{
			if (adjMat[curr][i] == 1 && visited[i] == false)
			{
				if (i==v2)
				{
					visited[v2] = true;
					boolean[] status = new boolean[adjMat.length];
					dfsPrint(adjMat,v2,status,v1);
				}
				else
				{
					pathExistsOrNot(adjMat,visited,i,v1,v2);
				}
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
		
		boolean[] visited = new boolean[adjMat.length];
		for (int i=0;i<adjMat.length;i++)
		{
			visited[i] = false;
		}
		
		System.out.println("Enter the value of V1 and V2");
		int v1 = s.nextInt();
		int v2 = s.nextInt();
		
		pathExistsOrNot(adjMat,visited,v1,v1,v2);
	

	}

}
