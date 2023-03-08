/**
 * @author fantastic
 */
public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind2 uf = new UnionFind2(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getNum();
    }

    public static void main(String[] args) {
        FindCircleNum solution = new FindCircleNum();
        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution.findCircleNum(isConnected));
    }
}

class UnionFind2 {

    private int[] parent;

    private int num;

    UnionFind2(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        num = n;
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = find(parent[x]);
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent[rootX] = rootY;
        num--;
    }

    public int getNum() {
        return num;
    }
}
