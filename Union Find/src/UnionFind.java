import java.util.HashMap;
import java.util.Map;

class UnionFind {
    /**
     * 记录每个节点的父节点
     */
    private final Map<Integer, Integer> parent;

    public UnionFind(int[] nums) {
        parent = new HashMap<>();
        // 初始化父节点为自身
        for (int num : nums) {
            parent.put(num, num);
        }
    }

    public UnionFind(int num) {
        parent = new HashMap<>();
        // 初始化父节点为自身
        for (int i = 0; i < num; i++) {
            parent.put(i, i);
        }
    }

    /**
     * 寻找x的父节点
     */
    public Integer find(int x) {
        // nums不包含x
        if (!parent.containsKey(x)) {
            return null;
        }
        // 遍历找到x的父节点
        while (x != parent.get(x)) {
            // 进行路径压缩，不写下面这行也可以，但是时间会慢些
            parent.put(x, parent.get(parent.get(x)));
            x = parent.get(x);
        }
        return x;
    }

    /**
     * 判断两个结点是否连通
     */
    public boolean connected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }

    /**
     * 合并两个连通分量
     */
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent.put(rootX, rootY);
    }
}
