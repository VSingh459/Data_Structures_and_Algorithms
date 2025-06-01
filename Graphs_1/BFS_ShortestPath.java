package graphs_1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class BFS_ShortestPath {
	
	public static ArrayList<Integer> getPathBFS(int[][] adjMat,int start,int end)
	{
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		boolean[] visited = new boolean[adjMat.length];
		visited[start] = true;
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(start,-1);
		boolean flag = false;
		
		while (!q.isEmpty())
		{
			int curr = q.poll();
		
			for (int i=0;i<adjMat.length;i++)
			{
				int n = adjMat[curr][i];
				if (n == 1 && visited[i] == false)
				{
					visited[i] = true;
					q.add(i);
					map.put(i, curr);
					if (i==end)
					{
						flag = true;
						break;
					}
				}
			}
		}
		
		if (flag == true)
		{
			ArrayList<Integer> path = new ArrayList<>();
			int current = end;
			while(current != -1)
			{
			path.add(current);
			int parent = map.get(current);
			current = parent;
			}
			
			return path;
		}
		else
		{
			return null;
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
		
		
		System.out.println();
		
		ArrayList<Integer> ans = getPathBFS(adjMat,v1,v2);
		if (ans != null)
		{
			for (int elem: ans)
			{
				System.out.print(elem+" ");
				
			}
		}
		
		
	}

}
