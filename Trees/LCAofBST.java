package Trees;

public class LCAofBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val > root.val && q.val > root.val) {
            // our LCA is in the right subtree
            return lowestCommonAncestor(root.right, p, q);

        } else if(p.val < root.val && q.val < root.val) {
            // our LCA will be in the left subtree
            return lowestCommonAncestor(root.left, p, q);

        } else {
            // nodes are split across the subtrees
            // the node where they split will be the LCA
            return root;
        }
    }

}