package assignments;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Three_Cycle_CopyPaste {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int solve(boolean[][] graph, int n) {
		/*
		 * Your class should be named Solution 
		 * You may write your code here
		 */
		int count = 0;

        // Iterate through each possible triplet of vertices (P, Q, R)
        for (int P = 0; P < n; P++) {
            for (int Q = P + 1; Q < n; Q++) {
                for (int R = Q + 1; R < n; R++) {
                    // Check if there is an edge between P and Q, Q and R, R and P
                    if (graph[P][Q] && graph[Q][R] && graph[R][P]) {
                        count++;
                    }
                }
            }
        }

        // Return the count of distinct 3-cycles
        return count;
	}

	public static boolean[][] takeInput() throws IOException {
		String[] strNums;
		strNums = br.readLine().split("\\s");
		int n = Integer.parseInt(strNums[0]);
		int m = Integer.parseInt(strNums[1]);

		boolean[][] graphs = new boolean[n][n];
		int firstvertex, secondvertex;

		for (int i = 0; i < m; i++) {
			String[] strNums1;
			strNums1 = br.readLine().split("\\s");
			firstvertex = Integer.parseInt(strNums1[0]);
			secondvertex = Integer.parseInt(strNums1[1]);
			graphs[firstvertex][secondvertex] = true;
			graphs[secondvertex][firstvertex] = true;
		}
		return graphs;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[][] graphs = takeInput();

		int ans = solve(graphs, graphs.length);
		System.out.println(ans);

	}

}
