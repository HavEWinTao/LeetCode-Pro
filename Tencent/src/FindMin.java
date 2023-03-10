public class FindMin {

    private int[] nums;

    public int findMin(int[] _nums) {
        nums = _nums;
        return binarySearch(0, nums.length - 1);
    }

    private int binarySearch(int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[l] && nums[mid] > nums[r]) {
            return binarySearch(mid + 1, r);
        }
        if (nums[mid] < nums[l] && nums[mid] < nums[r]) {
            return binarySearch(l, mid);
        }
        if ((nums[mid] < nums[r]) && nums[mid] >= nums[l]) {
            return binarySearch(l, mid);
        }
        if (nums[mid] > nums[r] && nums[mid] <= nums[l]) {
            return binarySearch(mid + 1, r);
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMin solution = new FindMin();
        int[] nums = new int[]{6, 1};
        System.out.println(solution.findMin(nums));
    }
}
