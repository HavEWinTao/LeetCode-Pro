/**
 * @author fantastic
 */
public class FindRedundantDirectedConnection {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        UnionFind4 uf = new UnionFind4(n + 1);
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        /**
         * 如果此时已经有parent[v]!=v，说明v有两个父节点，将当前的边[u,v] 记为导致冲突的边；
         * 否则，令parent[v]=u，然后在并查集中分别找到u和v的祖先（即各自的连通分支中的根节点）
         * 如果祖先相同，说明这条边导致环路出现，将当前的边[u,v] 记为导致环路出现的边
         * 如果祖先不同，则在并查集中将u和v进行合并。
         */
        for (int i = 0; i < n; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }
        //如果没有冲突的边就出现了环
        if (conflict < 0) {
            return new int[]{edges[cycle][0], edges[cycle][1]};
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                return new int[]{parent[conflictEdge[1]], conflictEdge[1]};
            } else {
                return new int[]{conflictEdge[0], conflictEdge[1]};
            }
        }
    }
}

class UnionFind4 {
    int[] ancestor;

    public UnionFind4(int n) {
        ancestor = new int[n];
        for (int i = 0; i < n; ++i) {
            ancestor[i] = i;
        }
    }

    public void union(int index1, int index2) {
        ancestor[find(index1)] = find(index2);
    }

    public int find(int index) {
        if (ancestor[index] != index) {
            ancestor[index] = find(ancestor[index]);
        }
        return ancestor[index];
    }
}