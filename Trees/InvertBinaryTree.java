package Trees;

import Trees.MaximumDepthOfBinaryTree.TreeNode;

public class InvertBinaryTree {
    
    public TreeNode invert(TreeNode root) {
        if(root == null) return null;

        // swapping the nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);

        return root;
    }

}
