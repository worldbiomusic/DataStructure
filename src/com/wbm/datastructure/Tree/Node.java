package com.wbm.datastructure.Tree;

public class Node
{
	public int key;
	public Node left, right;
	
	public Node(int key) {
		this(key, null, null);
	}
	
	public Node(int key, Node left, Node right) {
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
