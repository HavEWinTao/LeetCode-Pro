public class Trap {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n + 1];
        left[0] = 0;
        for (int i = 1; i <= n; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        int[] right = new int[n + 1];
        right[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += Math.min(left[i], right[i - 1]) - height[i - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Trap solution = new Trap();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }
}
