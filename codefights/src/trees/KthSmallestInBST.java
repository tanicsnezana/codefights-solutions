package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestInBST {

	public int kthSmallestInBST(TreeNode<Integer> t, int k) {
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        
        TreeNode<Integer> tmp = t;
        
        while(tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
        }
        
        while(!stack.isEmpty()) {
                
                if(k == 1) return stack.pop().value;
                
                k--;
                TreeNode<Integer> curr = stack.pop();
                
                if(curr.right != null) {
                        tmp = curr.right;
                        while(tmp != null){
                                stack.push(tmp);
                                tmp = tmp.left;
                        }
                }
        }
        
        return -1;
}
}
