public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        int len = num.length() - k;
        StringBuffer sf = new StringBuffer();
        for (char c : num.toCharArray()) {
            while (k > 0 && !sf.isEmpty() && sf.charAt(sf.length() - 1) > c) {
                sf.deleteCharAt(sf.length() - 1);
                k--;
            }
            sf.append(c);
        }
        while (sf.length() > len) {
            sf.deleteCharAt(sf.length() - 1);
        }
        while (sf.length() > 0 && sf.charAt(0) == '0') {
            sf.deleteCharAt(0);
        }
        if (sf.length() == 0) {
            return "0";
        }
        return sf.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits solution = new RemoveKdigits();
        String s = "10";
        System.out.println(solution.removeKdigits(s, 2));
    }
}
