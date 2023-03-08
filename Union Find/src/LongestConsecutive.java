/**
 * @author fantastic
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        UnionFind uf = new UnionFind(nums);
        int ans = 0;

        for (int num : nums) {
            // 当num+1存在，将num合并到num+1所在集合中
            if (uf.find(num + 1) != null) {
                uf.union(num, num + 1);
            }
        }

        for (int num : nums) {
            // 找到num的最远连续右边界
            int right = uf.find(num);
            ans = Math.max(ans, right - num + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutive solution = new LongestConsecutive();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));
    }
}

