package trees;

public class IsSubtree {
	
	private boolean areIdentical(TreeNode<Integer> t1, TreeNode<Integer> t2) {
		if(t1 == null && t2 == null) 
			return true;
		
		if(t1 == null || t2 == null)
			return t1 == t2;
		
		if(!t1.value.equals(t2.value))
			return false;
		
		return areIdentical(t1.left, t2.left) && areIdentical(t1.right, t2.right);
	}

	
	public boolean isSubtree(TreeNode<Integer> t1, TreeNode<Integer> t2) {
		if(t2 == null) return true;
		
		if(t1 == null) return false;
		
		if(t1.value.equals(t2.value))
			return areIdentical(t1, t2);
		
		return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
	}
}
