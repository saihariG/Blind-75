package Trees;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: If both trees are null, they are identical
        if(p == null && q == null) return true;

        // If one of tree is null, they are not identical
        if(p == null || q == null) return false;

        if(p != null && q != null) {
            // Recursively check if the left and the right subtrees are identical
            if(p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
        
        return false;
    }
}
