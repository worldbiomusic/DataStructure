package com.wbm.datastructure.sort;

import java.util.ArrayList;
import java.util.List;

import com.wbm.datastructure.Tree.BinarySearchTreeApp;
import com.wbm.datastructure.Tree.TreeNode;

public class TreeSort extends Sort {

    public TreeSort(int[] array) {
	super("TreeSort", array);
    }

    @Override
    public int[] sort() {
	BinarySortTree tree = new BinarySortTree();
	for (int e : this.a) {
	    tree.insert(e);
	}

	// BinarySortTree에서 inorderTraversal 순서대로 원소가 넣어진 리스트 가져오기
	List<Integer> list = tree.inorderTraversalList();

	for (int i = 0; i < a.length; i++) {
	    this.a[i] = list.get(i);
	}

	return this.a;
    }

}

class BinarySortTree extends BinarySearchTreeApp {
    List<Integer> sortedNodes = new ArrayList<>();

    @Override
    protected TreeNode insertNode(TreeNode root, int key) {
	if (root == null) {
	    return new TreeNode(key, null, null);
	} else if (key < root.key) {
	    root.left = insertNode(root.left, key);
	}
	// 크면 -> 크거나 같으면으로 수정
	else if (key >= root.key) {
	    root.right = insertNode(root.right, key);
	}

	// 1.이미 있는 데이터인 경우
	// 2.재귀적으로 구현했으므로 현재 노드 반환
	return root;
    }

    public List<Integer> inorderTraversalList() {
	this.inorderList(this.root);
	return this.sortedNodes;
    }

    private void inorderList(TreeNode root) {
	if (root == null) {
	    return;
	} else {
	    this.inorderList(root.left);
	    this.sortedNodes.add(root.key);
	    this.inorderList(root.right);
	}
    }
}