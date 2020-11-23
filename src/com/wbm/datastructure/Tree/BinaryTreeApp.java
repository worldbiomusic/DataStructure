package com.wbm.datastructure.Tree;

public class BinaryTreeApp implements com.wbm.datastructure.Tree.interfaces.BinaryTree
{
	TreeNode root;
	
	public BinaryTreeApp() {
		this(null);
	}
	
	public BinaryTreeApp(TreeNode root) {
		this.root = root;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void preorderTraversal() {
		System.out.print("preorder: ");
		this.preorder(this.root);
		System.out.println();
	}
	
	// root먼저 방문
	private void preorder(TreeNode root) {
		if(root == null) {
			return;
		} else {
			System.out.print(root.key + " ");
			this.preorder(root.left);
			this.preorder(root.right);
		}
	}
	
	public void inorderTraversal() {
		System.out.print("inorder: ");
		this.inorder(this.root);
		System.out.println();
	}
	
	// root 중간 방문
	private void inorder(TreeNode root) {
		if(root == null) {
			return;
		} else {
			this.inorder(root.left);
			System.out.print(root.key + " ");
			this.inorder(root.right);
		}
	}
	
	public void postorderTraversal() {
		System.out.print("postorder: ");
		this.postorder(this.root);
		System.out.println();
	}
	
	// root 마지막 방문
	private void postorder(TreeNode root) {
		if(root == null) {
			return;
		} else {
			this.postorder(root.left);
			this.postorder(root.right);
			System.out.print(root.key + " ");
		}
	}
	
	// 해당 트리의 가장 큰 값 반환
	public TreeNode maxValue()
	{
		TreeNode node = this.root;
		if(node == null) {
			return node;
		} else {
			while(node.right != null) {
				node = node.right;
			}
			return node;
		}
	}

	// 해당 트리의 가장 작은 값 반환
	public TreeNode minValue()
	{
		TreeNode node = this.root;
		if(node == null) {
			return node;
		} else {
			while(node.left != null) {
				node = node.left;
			}
			return node;
		}
	}
	
	public void levelorderTraversal() {
		this.levelorder(this.root);
		System.out.println();
	}
	
	// 레벨 순서 방문
	private void levelorder(TreeNode root) {
		// TODO: queue 구현한 다음에 작성
	}
	
	public BinaryTreeApp getCopy() {
		return new BinaryTreeApp(this.copy(this.root));
	}
	
	private TreeNode copy(TreeNode root) {
		if(root == null) {
			return root;
		} else {
			TreeNode left = this.copy(root.left);
			TreeNode right = this.copy(root.right);
			TreeNode copiedNode = new TreeNode(root.key, left, right);
			return copiedNode;
		}
	}
	
	public boolean equals(TreeNode other) {
		return this.equalsTree(this.root, other);
	}
	
	private boolean equalsTree(TreeNode tree1, TreeNode tree2) {
		return (tree1 == null && tree2 == null) 
				|| ((tree1.key == tree2.key) && (equalsTree(tree1.left, tree2.left) && equalsTree(tree1.right, tree2.right)));
	}

}


























