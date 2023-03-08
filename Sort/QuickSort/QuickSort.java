import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public int[] sortArray(int[] nums) {
        randomizedQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void randomizedQuickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = new Random().nextInt(r - l + 1) + l;
            int pivot = partition(nums, l, r, pos);
            randomizedQuickSort(nums, l, pivot - 1);
            randomizedQuickSort(nums, pivot + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r, int pos) {
        swap(nums, r, pos);
        int i = l;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] <= nums[r]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] nums = new int[]{5, 2, 3, 1};
        System.out.println(Arrays.toString(solution.sortArray(nums)));
    }
}
