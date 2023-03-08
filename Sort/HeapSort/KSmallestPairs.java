import java.util.*;

/**
 * @author fantastic
 */
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = Math.min(nums1.length, k);
        int n = Math.min(nums2.length, k);
        Heap<int[]> heap = new Heap<>((Comparator.comparingInt(idx -> -(nums1[idx[0]] + nums2[idx[1]]))));
        for (int i = 0; i < m; i++) {
            heap.add(new int[]{i, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (k > 0 && !heap.isEmpty()) {
            int[] idx = heap.pop();
            ans.add(Arrays.asList(nums1[idx[0]], nums2[idx[1]]));
            if (idx[1] + 1 < n) {
                heap.add(new int[]{idx[0], idx[1] + 1});
            }
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        KSmallestPairs solution = new KSmallestPairs();
        int[] nums1 = new int[]{1, 7, 11};
        int[] nums2 = new int[]{2, 4, 6};
        int k = 3;
        System.out.println(solution.kSmallestPairs(nums1, nums2, k));
    }
}
