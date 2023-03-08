/**
 * @author fantastic
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        UnionFind9 uf = new UnionFind9(2 * n + 1);
        for (int[] dislike : dislikes) {
            if (uf.connected(dislike[0], dislike[1])) {
                return false;
            }
            uf.union(dislike[0], dislike[1] + n);
            uf.union(dislike[1], dislike[0] + n);
        }
        return true;
    }

    public static void main(String[] args) {
        PossibleBipartition solution = new PossibleBipartition();
        int n = 4;
        int[][] dislikes = new int[][]{{1, 2}, {1, 3}, {2, 4}};
        System.out.println(solution.possibleBipartition(n, dislikes));
    }
}

class UnionFind9 {

    public int[] parent;

    UnionFind9(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent[rootX] = rootY;
    }

    public boolean connected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }
}
