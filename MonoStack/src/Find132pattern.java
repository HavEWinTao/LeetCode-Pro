import java.util.ArrayDeque;
import java.util.Deque;

public class Find132pattern {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int j = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < j) {
                return true;
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                j = Math.max(deque.pollLast(), j);
            }
            deque.addLast(nums[i]);
        }
        return false;
    }
}
