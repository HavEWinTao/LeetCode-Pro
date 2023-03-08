import java.util.HashSet;
import java.util.Set;

/**
 * @author fantastic
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(row * col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        uf.union((i - 1) * col + j, i * col + j);
                    }
                    if (i < row - 1 && grid[i + 1][j] == '1') {
                        uf.union((i + 1) * col + j, i * col + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.union(i * col + j - 1, i * col + j);
                    }
                    if (j > col - 1 && grid[i][j + 1] == '1') {
                        uf.union(i * col + j + 1, i * col + j);
                    }
                }
            }
        }
        Set<Integer> ans = new HashSet<>();
        boolean[][] visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visit[i][j] && grid[i][j] == '1') {
                    visit[i][j] = true;
                    ans.add(uf.find(i * col + j));
                }
            }
        }
        return ans.size();
    }

    public static void main(String[] args) {
        NumIslands solution = new NumIslands();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(grid));
    }
}
