/**
 * @author fantastic
 */
public class MinSwapsCouples {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        UnionFind7 uf = new UnionFind7(n / 2);
        for (int i = 0; i < n; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return n / 2 - uf.num;
    }

    public static void main(String[] args) {
        MinSwapsCouples solution = new MinSwapsCouples();
        int[] row = new int[]{0, 2, 1, 3};
        System.out.println(solution.minSwapsCouples(row));
    }
}

class UnionFind7 {
    private int[] parent;

    public int num;

    UnionFind7(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        num = n;
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
        num--;
    }
}
