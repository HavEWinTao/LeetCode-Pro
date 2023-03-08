import java.util.Random;

public class QuickSort2 {
    int[] nums;

    public int[] sortArray(int[] _nums) {
        nums = _nums;
        //nums = _nums.clone();
        randomizedQuickSort(0, nums.length - 1);
        return nums;
    }

    private void randomizedQuickSort(int l, int r) {
        if (l < r) {
            int pos = new Random().nextInt(r - l + 1) + l;
            swap(pos, r);
            int index = partition(l, r);
            randomizedQuickSort(l, index - 1);
            randomizedQuickSort(index + 1, r);
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
