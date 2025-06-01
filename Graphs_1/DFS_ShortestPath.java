package graphs_1;
import java.util.Scanner;
import java.util.ArrayList;

public class DFS_ShortestPath {
	
	public static ArrayList<Integer> getPathHelper(int[][] edges,int sv,int ev,boolean[] visited)
	{
		if (sv==ev)
		{
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(sv);
			return ans;
		}
		
		visited[sv] = true;
		int n = edges.length;
		
		for (int i=0;i<n;i++)
		{
			if (edges[sv][i] == 1 && !visited[i])
			{
				ArrayList<Integer> smallAns = getPathHelper(edges,i,ev,visited);
				if (smallAns != null)
				{
					smallAns.add(sv);
					return smallAns;
				}
				
			}
		}
		
		return null;
	}
	
	public static ArrayList<Integer> getPathDFS(int[][] edges,int sv,int ev)
	{
		boolean[] visited = new boolean[edges.length];
		return getPathHelper(edges,sv,ev,visited);

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
		
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				System.out.print(adjMat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		ArrayList<Integer> ans = getPathDFS(adjMat,v1,v2);
		if (ans != null)
		{
			for (int elem: ans)
			{
				System.out.print(elem+" ");
				
			}
		}

	}

}
