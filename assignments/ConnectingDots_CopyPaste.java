package assignments;

public class ConnectingDots_CopyPaste {
	
	private boolean dfs(char[][] grid, boolean[][] visited, int x, int y, int fromX, int fromY, char color, int n, int m) {
        visited[x][y] = true;

        // All possible directions: left, right, up, down
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // Check bounds
            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                // Ignore the cell we came from
                if (newX == fromX && newY == fromY) {
                    continue;
                }
                // If the cell has the same color
                if (grid[newX][newY] == color) {
                    // If the cell is already visited, we found a cycle
                    if (visited[newX][newY]) {
                        return true;
                    }
                    // Continue DFS
                    if (dfs(grid, visited, newX, newY, x, y, color, n, m)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    int solve(String[] board , int n, int m)
	{
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
		char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = board[i].toCharArray();
        }

        boolean[][] visited = new boolean[n][m];

        // Iterate through each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the cell is not visited, start DFS from it
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j], n, m)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
	}

}
