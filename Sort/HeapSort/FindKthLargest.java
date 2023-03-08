import java.util.Arrays;
import java.util.Comparator;

/**
 * @author fantastic
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Heap<Integer> heap = new Heap<>(arr, Comparator.comparingInt(o -> o));
        for (int i = 1; i < k; i++) {
            heap.pop();
        }
        return heap.top();
    }
}
