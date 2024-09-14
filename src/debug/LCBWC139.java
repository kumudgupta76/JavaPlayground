import java.util.*;

public class LCBWC139 {
    int m, n;
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] visited;

    boolean isSafe(int[][] g, int i, int j, int h) {
        // Boundary and base condition checks
        if (h <= 0 || i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
            return false;
        }

        // If we reach the bottom-right corner (destination)
        if (i == m - 1 && j == n - 1) {
            // Return true only if we have at least 1 health remaining
            return h > 0;
        }

        visited[i][j] = true;
        boolean ans = false;

        // Explore all 4 directions
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            // Recursively check next cell, reducing health if the cell is unsafe
            if (isSafe(g, x, y, g[i][j] == 1 ? h - 1 : h)) {
                ans = true;
                break;
            }
        }

        // Backtrack by unmarking the cell
        visited[i][j] = false;

        return ans;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();
        int[][] g = new int[m][n];
        visited = new boolean[m][n];

        // Convert List<List<Integer>> to 2D int array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = grid.get(i).get(j);
            }
        }

        // Start the DFS search from the top-left corner
        return isSafe(g, 0, 0, health);
    }

    public static void main(String[] args) {
        LCBWC139 solution = new LCBWC139();
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1, 0, 0));
        grid.add(Arrays.asList(1, 1, 0));
        grid.add(Arrays.asList(1, 1, 0));
        int health = 2;
        System.out.println(solution.findSafeWalk(grid, health));
    }
    
}
