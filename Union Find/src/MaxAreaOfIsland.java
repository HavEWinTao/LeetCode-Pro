import java.util.Map;

/**
 * @author fantastic
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind5 uf = new UnionFind5(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i > 0 && grid[i - 1][j] == 1) {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (i < m - 1 && grid[i + 1][j] == 1) {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, uf.size[i * n + j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(solution.maxAreaOfIsland(grid));
    }
}

class UnionFind5 {

    private int[] ancestors;

    public int[] size;

    UnionFind5(int n) {
        ancestors = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            ancestors[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (ancestors[x] != x) {
            ancestors[x] = find(ancestors[x]);
        }
        return ancestors[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        ancestors[rootX] = rootY;
        size[rootY] = size[rootY] + size[rootX];
    }
}
