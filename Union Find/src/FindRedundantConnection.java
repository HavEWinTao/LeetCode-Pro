import java.util.Arrays;

/**
 * @author fantastic
 */
public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind3 uf = new UnionFind3(n + 1);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (uf.connected(u, v)) {
                return edge;
            } else {
                uf.union(u, v);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FindRedundantConnection solution = new FindRedundantConnection();
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(Arrays.toString(solution.findRedundantConnection(edges)));
    }
}

class UnionFind3 {
    int[] parent;

    UnionFind3(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
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
    }

    public boolean connected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }
}