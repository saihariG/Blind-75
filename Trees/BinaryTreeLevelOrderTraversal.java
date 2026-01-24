package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

     // use a queue (FIFO)
    // start with the root and process the nodes in the order they were inserted 
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            
            List<Integer> level = new ArrayList<>();
            int n = queue.size();

            for(int i = 0 ; i < n ; i++) {
                TreeNode temp = queue.poll();
                level.add(temp.val);

                if(temp.left != null) {
                    queue.offer(temp.left);
                }

                if(temp.right != null) {
                    queue.offer(temp.right);
                }
            }            

            result.add(level);
        }

        return result;
    }
    
}
