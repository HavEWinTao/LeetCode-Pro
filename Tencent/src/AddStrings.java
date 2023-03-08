import java.util.Arrays;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int length = Math.max(num1.length(), num2.length()) + 1;
        int[] ans = new int[length];
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int c = 0;
        int index = 0;
        while (i >= 0 && j >= 0) {
            ans[index] = num1.charAt(i) - '0' + num2.charAt(j) - '0' + c;
            c = ans[index] / 10;
            ans[index] = ans[index] % 10;
            index++;
            i--;
            j--;
        }
        while (i >= 0) {
            ans[index] = num1.charAt(i) - '0' + c;
            c = ans[index] / 10;
            ans[index] = ans[index] % 10;
            index++;
            i--;
        }
        while (j >= 0) {
            ans[index] = num2.charAt(j) - '0' + c;
            c = ans[index] / 10;
            ans[index] = ans[index] % 10;
            index++;
            j--;
        }
        ans[index] = c;
        StringBuilder stringBuilder = new StringBuilder();
        if (ans[index] == 0) {
            index--;
        }
        while (index >= 0) {
            stringBuilder.append(ans[index]);
            index--;
        }
        return stringBuilder.toString();
    }
}
