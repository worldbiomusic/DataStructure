package com.wbm.datastructure.Tree;

public class HeapNode extends TreeNode {
	/*
	 * Heap의 insert, delete연산에서 부모노드가 필요한 상황이 있어서
	 * Node class에다가 parent속성 추가한 클래스를 만듬
	 */
	
	public HeapNode parent;
	
	public HeapNode(int key)
	{
		super(key);
		this.parent = null;
	}
}
