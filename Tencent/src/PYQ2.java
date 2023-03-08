import java.util.*;

public class PYQ2 {
    static Scanner in = new Scanner(System.in);

    private static void func() {
        int m = in.nextInt();
        UnionFind uf = new UnionFind();
        while (m-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            uf.union(a,b);
        }
        System.out.println(uf.ans);
    }

    public static void main(String[] args) {
        int T = in.nextInt();
        while (T-- > 0) {
            func();
        }
    }
}

class UnionFind {
    private int[] parent;

    public int ans;

    private int[] nums;

    UnionFind() {
        parent = new int[100001];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        nums = new int[100001];
        Arrays.fill(nums, 1);
        ans = 1;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootQ] = rootP;
        nums[rootP] += nums[rootQ];
        ans = Math.max(nums[rootP], ans);
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}