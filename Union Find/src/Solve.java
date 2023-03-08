import java.util.Arrays;

/**
 * @author fantastic
 */
public class Solve {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;

        UnionFind uf = new UnionFind(row * col + 1);
        int dummyNode = row * col;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        uf.union(i * col + j, dummyNode);
                    } else {
                        if (board[i - 1][j] == 'O') {
                            uf.union(i * col + j, (i - 1) * col + j);
                        }
                        if (board[i + 1][j] == 'O') {
                            uf.union(i * col + j, (i + 1) * col + j);
                        }
                        if (board[i][j - 1] == 'O') {
                            uf.union(i * col + j, i * col + j - 1);
                        }
                        if (board[i][j + 1] == 'O') {
                            uf.union(i * col + j, i * col + j + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!uf.connected(i * col + j, dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        Solve solution = new Solve();
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}