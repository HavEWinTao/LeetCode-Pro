public class KthLargest {
    public int kthLargest(TreeNode root, int k) {
        int right = nodeNums(root.right);
        if (k == right + 1) {
            return root.val;
        } else if (k < right + 1) {
            return kthLargest(root.right, k);
        } else {
            return kthLargest(root.left, k - right - 1);
        }
    }

    public int nodeNums(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + nodeNums(root.left) + nodeNums(root.right);
    }

    public static void main(String[] args) {
        KthLargest solution = new KthLargest();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(solution.kthLargest(root, 3));
    }
}
