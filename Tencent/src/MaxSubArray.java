public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int temp = 0;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            if (temp < 0) {
                temp = 0;
            }
            temp = temp + num;
            ans = Math.max(temp, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSubArray solution = new MaxSubArray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }
}
