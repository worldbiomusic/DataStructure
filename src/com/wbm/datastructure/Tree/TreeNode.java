package com.wbm.datastructure.Tree;

public class TreeNode
{
	public int key;
	public TreeNode left, right;
	
	public TreeNode(int key) {
		this(key, null, null);
	}
	
	public TreeNode(int key, TreeNode left, TreeNode right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
	
	public int getChildrenCount() {
		if(this.left == null && this.right == null) {
			return 0;
		} else if(this.left == null || this.right == null) {
			return 1;
		} else {
			return 2;
		}
	}
	
	@Override
	public String toString()
	{
		return this.key + "";
	}
}
