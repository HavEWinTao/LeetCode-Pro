import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        DFS(root);
        return ans;
    }

    private void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}