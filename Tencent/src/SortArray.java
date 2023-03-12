import java.util.Arrays;

public class SortArray {

    public int[] sortArray(int[] nums) {
        Heap heap = new Heap(nums);
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1};
        SortArray solution = new SortArray();
        System.out.println(Arrays.toString(solution.sortArray(nums)));
    }
}

class Heap {
    int[] nums;

    int size;

    Heap(int[] nums) {
        this.nums = nums;
        size = nums.length;
        buildHeap();
    }

    private void buildHeap() {
        for (int i = (size - 1) / 2; i >= 0; i--) {
            down(i);
        }
    }

    private void down(int index) {
        int left = index * 2 + 1;
        left = left < size ? left : -1;
        if (left == -1) {
            return;
        }
        int right = (index + 1) * 2;
        right = right < size ? right : -1;
        if (right == -1) {
            if (nums[index] > nums[left]) {
                swap(index, left);
            }
            return;
        }
        int next = nums[left] < nums[right] ? left : right;
        if (nums[index] > nums[next]) {
            swap(index, next);
        }
        down(next);
    }

    public int poll() {
        int ret = nums[0];
        size--;
        swap(0, size);
        down(0);
        return ret;
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}