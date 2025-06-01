package graphs_1;
import java.util.Scanner;

public class DepthFirstTraversal {
	
	public static void dfs(int[][] adjMat,int curr,boolean[] visited)
	{
		visited[curr] = true;
		System.out.print(curr+" ");
		for (int i=0;i<adjMat.length;i++)
		{
			if (adjMat[curr][i] == 1 && visited[i] == false)
			{
				dfs(adjMat,i,visited);
			}
		}
		
	}
	
	public static void dfsDis(int[][] adjMat,boolean[] visited)
	{
		for (int i=0;i<adjMat.length;i++)
		{
			if (visited[i] == false)
			{
				dfs(adjMat,i,visited);
				System.out.println();
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
		boolean[] visited = new boolean[adjMat.length];
		for (int i=0;i<adjMat.length;i++)
		{
			visited[i] = false;
		}
		//dfs(adjMat,1,visited);
		dfsDis(adjMat, visited);

	}

}
