import java.util.Arrays;
import java.util.Stack;

public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] maxNum = new int[k];
        for (int i = 1; i <= k; i++) {
            if (i <= nums1.length && k - i <= nums2.length) {
                int[] temp = merge(pickMaxNum(nums1, i), pickMaxNum(nums2, k - i));
                maxNum = compare(maxNum, 0, temp, 0) > 0 ? maxNum : temp;
            }
        }
        return maxNum;
    }

    private int[] pickMaxNum(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int drop = nums.length - k;
        for (int num : nums) {
            while (drop > 0 && !stack.isEmpty() && num > stack.peek()) {
                stack.pop();
                drop--;
            }
            stack.add(num);
        }
        stack.setSize(k);
        return stack.stream().mapToInt(o -> o).toArray();
    }

    private int[] merge(int[] num1, int[] num2) {
        int i = 0, j = 0;
        int[] ret = new int[num1.length + num2.length];
        int index = 0;
        while (i < num1.length && j < num2.length) {
            if (compare(num1, i, num2, j) > 0) {
                ret[index++] = num1[i++];
            } else {
                ret[index++] = num2[j++];
            }
        }
        while (i < num1.length) {
            ret[index++] = num1[i++];
        }
        while (j < num2.length) {
            ret[index++] = num2[j++];
        }
        return ret;
    }

    private int compare(int[] a, int index1, int[] b, int index2) {
        int diff = 0;
        while (index1 < a.length && index2 < b.length) {
            diff = a[index1] - b[index2];
            if (diff != 0) {
                return diff;
            }
            index1++;
            index2++;
        }
        return (a.length - index1) - (b.length - index2);
    }

    public static void main(String[] args) {
        MaxNumber solution = new MaxNumber();
        int[] nums1 = new int[]{8, 6, 9};
        int[] nums2 = new int[]{1, 7, 5};
        System.out.println(Arrays.toString(solution.maxNumber(nums1, nums2, 3)));
    }
}
