public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] str = s.toCharArray();
        int start = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[str.length][str.length];
        for (int i = 0; i < str.length; i++) {
            dp[i][i] = true;
        }
        for (int len = 2; len <= str.length; len++) {
            for (int l = 0; l < str.length; l++) {
                int r = l + len - 1;
                if (r >= str.length) {
                    break;
                }
                if (str[l] != str[r]) {
                    dp[l][r] = false;
                } else {
                    if (r - l < 3) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                }
                if (dp[l][r] && len > maxLen) {
                    start = l;
                    maxLen = len;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}