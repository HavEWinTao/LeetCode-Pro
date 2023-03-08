public class Search {

    private int[] nums;

    private int target;

    public int search(int[] _nums, int _target) {
        nums = _nums;
        target = _target;
        return binarySearch(0, nums.length - 1);
    }

    private int binarySearch(int l, int r) {
        if (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                return binarySearch(l, mid - 1);
            } else if (nums[mid] < target) {
                return binarySearch(mid + 1, r);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }
}
