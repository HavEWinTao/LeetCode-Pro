import java.util.Objects;

public class MyAtoi {
    public int myAtoi(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int length = str.length;
        int index = 0;
        while (index < length && str[index] == ' ') index++;
        boolean flag = true;
        if (index < length && str[index] == '+') index++;
        else if (index < length && str[index] == '-') {
            flag = false;
            index++;
        }
        long ans = 0;
        while (index < length && (str[index] >= '0' && str[index] <= '9')) {
            if (flag) {
                ans = ans * 10 + (str[index] - '0');
                if ((int) ans != ans) {
                    return Integer.MAX_VALUE;
                }
            } else {
                ans = ans * 10 - (str[index] - '0');
                if ((int) ans != ans) {
                    return Integer.MIN_VALUE;
                }
            }
            index++;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        MyAtoi solution = new MyAtoi();
        String num = "42";
        System.out.println(solution.myAtoi(num));
    }
}
