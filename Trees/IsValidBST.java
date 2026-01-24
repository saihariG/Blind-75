package Trees;

public class IsValidBST {
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Intuition: Root value must be greater than or equal to min (left subtree)
    // And Root value must be lesser than or equal to max (right subtree)
    static boolean isValidBST(TreeNode root, long min, long max) {

        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        boolean isLeftBST = isValidBST(root.left, min, root.val);
        boolean isRightBST = isValidBST(root.right, root.val, max);

        return isLeftBST && isRightBST;
    }
}
