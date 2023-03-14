import java.util.Stack;

public class Trap {
    public int trap(int[] height) {
        Stack<Integer> monoStack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!monoStack.isEmpty() && height[i] > height[monoStack.peek()]) {
                int index = monoStack.pop();
                if (monoStack.isEmpty()) {
                    break;
                }
                int h = Math.min(height[i], height[monoStack.peek()]);
                int distance = i - monoStack.peek() - 1;
                ans += (h - height[index]) * distance;
            }
            monoStack.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Trap solution = new Trap();
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(nums));
    }
}