package Trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {
    // Leverage the BST and perform Inorder traversal (left -> root -> right)
    // By visiting the left subtree, we ensure that we encounter smaller nodes first, which gives us an ascending values
    // Have a counter variable to track current node in the ascending order of values
    // when counter variable equals k, we return the node's value
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> inorderList = inorder(root, new ArrayList<Integer>());
        System.out.println(inorderList);

        for(int i = 0 ; i < inorderList.size() ; i++) {
            if(i == k-1) return inorderList.get(i);
        }
        
        return -1;
    }


    static List<Integer> inorder(TreeNode root, List<Integer> inorderList) {
        if(root == null) return inorderList;

        inorder(root.left, inorderList);
        inorderList.add(root.val);
        inorder(root.right, inorderList);

        return inorderList;
    }
}
