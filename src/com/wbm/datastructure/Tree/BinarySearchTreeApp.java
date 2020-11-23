package com.wbm.datastructure.Tree;

import com.wbm.datastructure.Tree.interfaces.BinarySearchTree;

public class BinarySearchTreeApp extends BinaryTreeApp implements BinarySearchTree
{
//	public Node root;
	
	public BinarySearchTreeApp() {
		this(null);
	}
	
	public BinarySearchTreeApp(TreeNode root) {
		super(root);
	}
	
	public TreeNode search(int key) {
		return this.searchNode(this.root, key);
	}
	
	private TreeNode searchNode(TreeNode root, int key)
	{
		if(root==null||root.key==key)
		{
			return root;
		}
		else if(key<root.key)
		{
			return searchNode(root.left, key);
		}
		else // if(key > root.key) {
			return searchNode(root.right, key);
	}
	@Override
	public void insert(int key) {
		this.root = this.insertNode(this.root, key);
	}

	private TreeNode insertNode(TreeNode root, int key)
	{
		if(root==null)
		{ // 탐색에 실패했으므로 key를 넣을 수 있어서 key값을 가지는 새로운 노드 반환
			return new TreeNode(key, null, null);
		}
		else if(key<root.key)
		{
			root.left=insertNode(root.left, key);
		}
		else if(key>root.key)
		{
			root.right=insertNode(root.right, key);
		}

		// 1.이미 있는 데이터인 경우
		// 2.재귀적으로 구현했으므로 현재 노드 반환
		return root;
	}
	@Override
	public TreeNode delete(int key) {
		return this.deleteNode(this.root, key);
	}

	private TreeNode deleteNode(TreeNode root, int key)
	{
		if(root==null)
		{
			return root;
		}
		else if(root.key==key)
		{
			if(root.left==null&&root.right==null)
			{ // 자식 0
				return null;
			}
			else if(root.left==null)
			{ // 자식 1(오른쪽)
				return root.right;
			}
			else if(root.right==null)
			{ // 자식 1(왼쪽)
				return root.left;
			}
			else
			{ // 자식 2 (왼쪽의 max값 사용)
				root.key= new BinaryTreeApp(root.left).maxValue().key; // 왼쪽에서 max가져와서 key등록
				root.left=deleteNode(root.left, root.key); // 왼쪽에서 가져온 key노드 제거
			}
		}
		else if(key<root.key)
		{
			root.left=deleteNode(root.left, key);
		}
		else if(key>root.key)
		{
			root.right=deleteNode(root.right, key);
		}

		return root;
	}
	
	public static BinarySearchTreeApp threeJoin(BinarySearchTreeApp left, int rootKey, BinarySearchTreeApp right) {
		/*
		 * left의 모든 원소 < rootKey < right의 모든 원소 가정
		 */
		TreeNode root = new TreeNode(rootKey, left.root, right.root);
		BinarySearchTreeApp bst = new BinarySearchTreeApp(root);
		return bst;
	}
	
	public static BinarySearchTreeApp twoJoin(BinarySearchTreeApp left, BinarySearchTreeApp right) {
		/*
		 * left의 모든 원소 < right의 모든 원소 
		 */
		int leftMaxKey = left.maxValue().key;
		left.delete(leftMaxKey);
		
		return BinarySearchTreeApp.threeJoin(left, leftMaxKey, right);
	}
	
	public static void split(BinarySearchTreeApp target, int splitKey, BinarySearchTreeApp left, BinarySearchTreeApp right) {
		/*
		 * target트리를 splitKey기준으로 나눠서 left, right에 할당해준다
		 */
		
		// TODO: 내가 직접 짜기 (책에선 변수이름이 이상해서 이해안됨)
	}
	
	public TreeNode getParent(int key) {
		TreeNode node = this.root;
		TreeNode parent = null;
		while(node != null) {
			if(node.key == key) {
				return parent;
			} else if(key < node.key) {
				parent = node;
				node = node.left;
			} else { // if(key > node.key)
				parent = node;
				node = node.right;
			}
		}
		
		return null;
	}
}



























