public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        boolean[] visit = new boolean[26];
        char[] str = s.toCharArray();
        for (char c : str) {
            cnt[c - 'a']++;
        }
        StringBuffer sf = new StringBuffer();
        for (char c : str) {
            if (!visit[c - 'a']) {
                while (!sf.isEmpty() && sf.charAt(sf.length() - 1) > c) {
                    if (cnt[sf.charAt(sf.length() - 1) - 'a'] > 0) {
                        visit[sf.charAt(sf.length() - 1) - 'a'] = false;
                        sf.deleteCharAt(sf.length() - 1);
                    } else {
                        break;
                    }
                }
                sf.append(c);
                visit[c - 'a'] = true;
            }
            cnt[c - 'a']--;
        }
        return sf.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
        String s = "cbacdcbc";
        System.out.println(solution.removeDuplicateLetters(s));
    }
}
