package com.wbm.datastructure.Tree;

import java.util.Stack;

import com.wbm.datastructure.Tree.interfaces.Heap;

public class HeapWithNodeApp extends BinaryTreeApp implements Heap
{
	/*
	 * MaxHeap
	 * insert, delete연산을 heap의 노드의 갯수인 count를 이용해 해결
	 */
	
	int count;
	public HeapWithNodeApp() {
		this(null);
	}
	
	public HeapWithNodeApp(TreeNode root) {
		super(root);
		this.count = 0;
	}
	
	private TreeNode getParentWithCount(int count) {
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
		
		TreeNode parent = this.root;
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
			this.root = new TreeNode(key);
			return;
		}
		
		int tmpCount = this.count;
		TreeNode parent = this.getParentWithCount(tmpCount);
		TreeNode newNode = new TreeNode(key);
		
		if(parent.left == null) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		
		TreeNode tmpParent = parent;
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
	
	public int delete() {
		// 1. keep rootkey
		int rootKey = this.root.key;
		
		// 2.마지막 노드 값 keep, 삭제
		TreeNode parent = this.getParentWithCount(this.count);
		int lastKey;
		if(parent.getChildrenCount() == 1) { // parent의 자식이 left만 있는 경우
			lastKey = parent.left.key;
			parent.left = null;
		} else { // parent의 자식이 left, right 둘다 있는 경우
			lastKey = parent.right.key;
			parent.right = null;
		}
		
		// 3.자식들중 큰 값보다 root값이 더 작으면 값 교체, 아니면 연산 완료
		TreeNode p = root;
		while(p.getChildrenCount() != 0) {
			TreeNode bigChild;
			if(p.getChildrenCount() == 1) {
				bigChild = p.left;
			} else { // childrenCount == 2
				TreeNode leftChild = p.left;
				TreeNode rightChild = p.right;
				bigChild = (leftChild.key > rightChild.key) ? p.left : p.right;
			}
			
			if(lastKey < bigChild.key) {
				p.key = bigChild.key;
				p = bigChild;
			} else {
				break;
			}
		}
		p.key = lastKey;
		
		
		// 4.count 감소
		this.count--;
		
		// 5.삭제값 반환
		return rootKey;
	}
}



















