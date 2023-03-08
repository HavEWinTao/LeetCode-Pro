import java.util.Comparator;

/**
 * @author fantastic
 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Heap<int[]> heap = new Heap<>((Comparator.comparingInt(idx -> -(matrix[idx[0]][idx[1]]))));
        for (int i = 0; i < n; i++) {
            heap.add(new int[]{i, 0});
        }
        int ans = -1;
        while (k > 0 && !heap.isEmpty()) {
            int[] idx = heap.pop();
            ans = matrix[idx[0]][idx[1]];
            if (idx[1] + 1 < n) {
                heap.add(new int[]{idx[0], idx[1] + 1});
            }
            k--;
        }
        return ans;
    }
}
