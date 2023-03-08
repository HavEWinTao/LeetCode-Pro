import java.util.Arrays;
import java.util.Comparator;

/**
 * @author fantastic
 */
public class SmallestK {
    public int[] smallestK(int[] nums, int k) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Heap<Integer> heap = new Heap<>(arr, Comparator.comparingInt(o -> -o));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        SmallestK solution = new SmallestK();
        int k = 10;
        int size = 20;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        System.out.println(Arrays.toString(solution.smallestK(arr, k)));
    }
}
