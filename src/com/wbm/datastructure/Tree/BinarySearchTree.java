package com.wbm.datastructure.Tree;

public class BinarySearchTree extends BinaryTree
{
//	public Node root;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Node root) {
		super(root);
	}
	
	public Node search(int key) {
		return this.searchNode(this.root, key);
	}
	
	private Node searchNode(Node root, int key)
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
	
	public void insert(int key) {
		this.root = this.insertNode(this.root, key);
	}

	private Node insertNode(Node root, int key)
	{
		if(root==null)
		{ // 탐색에 실패했으므로 key를 넣을 수 있어서 key값을 가지는 새로운 노드 반환
			return new Node(key, null, null);
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
	
	public Node delete(int key) {
		return this.deleteNode(this.root, key);
	}

	private Node deleteNode(Node root, int key)
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
				root.key= new BinaryTree(root.left).maxValue().key; // 왼쪽에서 max가져와서 key등록
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
	
	public static Node threeJoin(BinarySearchTree left, int rootKey, BinarySearchTree right) {
		/*
		 * left의 모든 원소 < rootKey < right의 모든 원소 
		 */
		Node root = new Node(rootKey, left.root, right.root);
		return root;
	}
	
	public static Node twoJoin(BinarySearchTree left, BinarySearchTree right) {
		/*
		 * left의 모든 원소 < right의 모든 원소 
		 */
		int leftMaxKey = left.maxValue().key;
		left.delete(leftMaxKey);
		
		return BinarySearchTree.threeJoin(left, leftMaxKey, right);
	}
	
	public void split(BinarySearchTree target, int splitKey, BinarySearchTree left, BinarySearchTree right) {
		/*
		 * target트리를 splitKey기준으로 나눠서 left, right에 할당해준다
		 */
		
		// TODO: 내가 직접 짜기 (책에선 변수이름이 이상해서 이해안됨)
	}
	
	public Node getParent(int key) {
		Node node = this.root;
		Node parent = null;
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



























