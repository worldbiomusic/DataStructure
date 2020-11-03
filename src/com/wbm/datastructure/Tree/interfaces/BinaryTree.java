package com.wbm.datastructure.Tree.interfaces;

import com.wbm.datastructure.Tree.Node;

public interface BinaryTree
{
	public boolean isEmpty();
	
	public void preorderTraversal();
	public void inorderTraversal();
	public void postorderTraversal();
	public void levelorderTraversal();
	
	public BinaryTree getCopy(); 
	public Node minValue();
	public Node maxValue();
	public boolean equals(Node other);
}
