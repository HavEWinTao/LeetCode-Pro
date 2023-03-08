import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

/**
 * @author fantastic
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> num2cnt = new HashMap<>();
        for (int num : nums) {
            int cnt = num2cnt.getOrDefault(num, 0);
            num2cnt.put(num, cnt + 1);
        }
        Heap<int[]> heap = new Heap<>(((o1, o2) -> o2[1] - o1[1]));
        for (int key : num2cnt.keySet()) {
            if (heap.size() < k) {
                heap.add(new int[]{key, num2cnt.get(key)});
            } else {
                if (num2cnt.get(key) > heap.top()[1]) {
                    heap.pop();
                    heap.add(new int[]{key, num2cnt.get(key)});
                }
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.pop()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};
        int k = 10;
        TopKFrequent solution = new TopKFrequent();
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k)));
    }
}