package com.wbm.datastructure.Tree;

import java.util.Stack;

public class Heap extends BinaryTree
{
	/*
	 * MaxHeap
	 */
	int count;
	public Heap() {
		this(null);
	}
	
	public Heap(Node root) {
		super(root);
		this.count = 0;
	}
	
	private Node getParentWithCount(int count) {
		if(count == 1) {
			return null;
		}
		Stack<Boolean> isRights = new Stack<>();
		int tmpCount = (count) / 2;
		
		while(tmpCount != 1) {
			int mod = tmpCount % 2;
			tmpCount /= 2;
			if(mod == 1) {
				isRights.add(true);
			} else {
				isRights.add(false);
			}
		}
		
		Node parent = this.root;
		while(!isRights.isEmpty()) {
			boolean isRight = isRights.pop();
			if(isRight) {
				parent = parent.right;
			} else {
				parent = parent.left;
			}
		}
		
		return parent;
	}
	
	public void insert(int key) {
		this.count++;
		if(this.count == 1) {
			this.root = new Node(key);
			return;
		}
		
		int tmpCount = this.count;
		Node parent = this.getParentWithCount(tmpCount);
		Node newNode = new Node(key);
		
		if(parent.left == null) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		
		Node tmpParent = parent;
		while(key > tmpParent.key) {
			newNode.key = tmpParent.key;
			newNode = tmpParent;
			tmpCount /= 2;
			tmpParent = this.getParentWithCount(tmpCount);
			if(tmpParent == null) {
				// root이므로 비교할 대상이 없이 최상위 노드이기 때문
				break;
			}
		}
		
		newNode.key = key;
	}
}



















