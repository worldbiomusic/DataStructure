package com.wbm.datastructure.Tree;

import com.wbm.datastructure.Tree.interfaces.Heap;

public class HeapWithHeapNode extends BinaryTreeApp implements Heap
{
	/*
	 * Max Heap
	 * 부모노드있는것으로 heap만들어보려했는데 실패
	 */
	HeapNode lastParent;
	
	public HeapWithHeapNode() {
		this(null);
	}
	
	public HeapWithHeapNode(HeapNode root) {
		super(root);
	}
	
	public void insert(int key) {
//		HeapNode newNode = new HeapNode(key);
//		
//		if(this.isEmpty()) {
//			this.root = this.lastParent = newNode;
//		} else {
//			HeapNode parent = this.lastParent;
//			
//			if(parent.getChildrenCount() == 2) {
//				parent = this.lastParent = (HeapNode)parent.parent.right;
//			}
//			
//			HeapNode child;
//			if(parent.getChildrenCount() == 0) {
//				parent.left = child = newNode;
//			} else { // count == 1
//				parent.right = child = newNode;
//				this.lastParent = (HeapNode)parent.left;
//			}
//			
//			while(parent != null) {
//				if(child.key > parent.key) {
//					child.key = parent.key;
//				} else {
//					return;
//				}
//				child = parent;
//				parent = parent.parent;
//			}
//		}
	}
	
	public int delete() {
		
		
		return 0;
	}
}


























