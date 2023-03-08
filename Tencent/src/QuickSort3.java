import java.util.Random;

public class QuickSort3 {
    int[] nums;

    Random random = new Random();

    public int[] sortArray(int[] _nums) {
        nums = _nums;
        randomizedQuickSort(0, nums.length - 1);
        return nums;
    }

    private void randomizedQuickSort(int l, int r) {
        if (l < r) {
            int pos = random.nextInt(r - l + 1) + l;
            swap(pos, r);
            int pivot = partition(l, r);
            randomizedQuickSort(l, pivot - 1);
            randomizedQuickSort(pivot + 1, r);
        }
    }

    private int partition(int l, int r) {
        int i = l;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] <= nums[r]) {
                swap(i++, j);
            }
        }
        swap(i, r);
        return i;
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
