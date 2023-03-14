import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] _heights) {
        //栈是递增的
        Stack<Integer> stack = new Stack<>();
        int[] heights = new int[_heights.length + 2];
        System.arraycopy(_heights, 0, heights, 1, _heights.length);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            //当栈顶元素比当前元素大的时候，为了维护栈需要弹出元素，当前的peek的右侧就是当前的元素i，而弹出后的peek就是左侧的位置
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int top = stack.pop();
                int width = (i - stack.peek() - 1);
                ans = Math.max(ans, width * heights[top]);
            }
            stack.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleArea solution = new LargestRectangleArea();
        int[] nums = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(nums));
    }
}
