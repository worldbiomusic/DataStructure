package com.wbm.datastructure.Tree.interfaces;

import com.wbm.datastructure.Tree.TreeNode;

public interface BinaryTree
{
	public boolean isEmpty();
	
	public void preorderTraversal();
	public void inorderTraversal();
	public void postorderTraversal();
	public void levelorderTraversal();
	
	public BinaryTree getCopy(); 
	public TreeNode minValue();
	public TreeNode maxValue();
	public boolean equals(TreeNode other);
}
