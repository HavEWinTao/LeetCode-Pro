/**
 * @author fantastic
 */
public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        UnionFind8 uf = new UnionFind8(graph.length);
        for (int i = 0; i < graph.length; i++) {
            int[] edges = graph[i];
            for (int u : edges) {
                if (uf.isConnected(i, u)) {
                    return false;
                }
                //假设对于点0，edges表示该点相对于其他点的关系，这些点应该位于同一个连通分支内
                uf.union(edges[0], u);
            }
        }
        return true;
    }
}

class UnionFind8 {
    int[] ancestors;

    public UnionFind8(int n) {
        ancestors = new int[n];
        for (int i = 0; i < n; i++) {
            ancestors[i] = i;
        }
    }

    public int find(int i) {
        if (ancestors[i] != i) {
            ancestors[i] = find(ancestors[i]);
        }
        return ancestors[i];
    }

    public boolean isConnected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        ancestors[rootP] = rootQ;
    }
}