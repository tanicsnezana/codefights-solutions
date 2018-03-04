package trees;

public class HasPathWithGivenSum {
	
	public boolean hasPathWithGivenSum(TreeNode<Integer> t, int s) {
		if(t == null) return false;
		
		boolean result = false;
		int subsum = s - t.value;
		
		if(s == 0 && t.left == null && t.right == null)
			return true;
		if(t.left != null)
			return result |= hasPathWithGivenSum(t.left, subsum);
		if(t.right != null)
			return result |= hasPathWithGivenSum(t.right, subsum);
		
		return false;
	}

}
