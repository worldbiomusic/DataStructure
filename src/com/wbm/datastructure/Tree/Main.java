package com.wbm.datastructure.Tree;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("TREE RUN");
		// =========BT
//		Node root = new Node(1);
//		Node n2 = new Node(2);
//		Node n3 = new Node(3);
//		root.left = n2;
//		root.right = n3;
//		
//		BinaryTree bt = new BinaryTree(root);
//		bt.postorderTraversal();
		
		
		// ============BST
//		BinarySearchTree bst = new BinarySearchTree();
//		int[] keys = {15, 11, 70, 5, 13, 50};
//		
//		for(int key : keys) {
//			bst.insert(key);
//		}
//		
//		
//		bst.preorderTraversal();
//		bst.inorderTraversal();
//		bst.postorderTraversal();
//		
//		System.out.println(bst.getParent(15));

		
		int[] keys = {18, 12 ,8, 13 ,5};
		HeapWithArrayApp heap = new HeapWithArrayApp();
		heap.arr= keys;
		heap.count = keys.length;
		heap.heapify();
		heap.inorderTraversal();
		System.out.println("OK");
		
//		// inorder: 12 13 5 18 8
//		for(int key : keys) {
//			heap.insert(key);
//		}
////		
//		
////		heap.insert(19);
////		
//		heap.delete();
//		heap.delete();
//		
//		// 5 12 13 8
//		heap.inorderTraversal();
//		
//		System.out.println("TREE END");
	}
}


















