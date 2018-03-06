package trees;

public class RestoreBinaryTree {
	
	private TreeNode<Integer> construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		
		if(preStart > preEnd || inStart > inEnd)
			return null;
		
		int value = preorder[preStart];
		
		TreeNode<Integer> node = new TreeNode<>();
		node.value = value;
		
		int index = 0;
		
		//Find position of node in inorder traversal
		
		for(int i = 0; i < inorder.length; i++)
			if(inorder[i] == value) {
				index = i;
				break;
			}
		
		node.left = construct(preorder, preStart + 1, preStart + (index - inStart) , inorder, inStart, index - 1);
		node.right = construct(preorder, preStart + (index - inStart) + 1, preEnd, inorder, index + 1, inEnd)
			
		
		return null;
	}
	
	public TreeNode<Integer> restoreBinaryTree(int[] inorder, int[] preorder) {
		if(inorder.length != preorder.length) return null;
		
		return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

}
