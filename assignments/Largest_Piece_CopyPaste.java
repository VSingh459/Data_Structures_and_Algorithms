package assignments;

public class Largest_Piece_CopyPaste {
	
	 static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		public static int dfs(String[] edge, int n) {
			/* Your class should be named Solution
			 * Don't write main().
			 * Don't read input, it is passed as function argument.
			 * Return output and don't print it.
		 	 * Taking input and printing output is handled automatically.
	        */
			boolean[][] visited = new boolean[n][n];
	        int maxPieceSize = 0;

	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (edge[i].charAt(j) == '1' && !visited[i][j]) {
	                    int pieceSize = explore(edge, visited, i, j, n);
	                    maxPieceSize = Math.max(maxPieceSize, pieceSize);
	                }
	            }
	        }

	        return maxPieceSize;
		}

		private static int explore(String[] edge, boolean[][] visited, int x, int y, int n) {
	        visited[x][y] = true;
	        int pieceSize = 1; // Count the current '1'

	        for (int[] d : dir) {
	            int newX = x + d[0];
	            int newY = y + d[1];

	            if (newX >= 0 && newX < n && newY >= 0 && newY < n && edge[newX].charAt(newY) == '1' && !visited[newX][newY]) {
	                pieceSize += explore(edge, visited, newX, newY, n);
	            }
	        }

	        return pieceSize;
	    }
	
	 
  

	

}
