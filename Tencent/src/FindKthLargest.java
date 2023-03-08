import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.peek();
    }
}
