import java.util.Arrays;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        boolean[] show = new boolean[128];
        Arrays.fill(show, false);
        int i = 0, j = 0;
        int ans = 0;
        while (i <= j && j < s.length()) {
            if (i == j || !show[s.charAt(j)]) {
                show[s.charAt(j)] = true;
                j++;
                ans = Math.max(j - i, ans);
            } else {
                show[s.charAt(i)] = false;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
