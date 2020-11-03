package com.wbm.datastructure.Tree.interfaces;

import com.wbm.datastructure.Tree.BinarySearchTreeApp;
import com.wbm.datastructure.Tree.Node;

public interface BinarySearchTree
{
	public Node search(int key);
	public void insert(int key);
	public Node delete(int key);
	public static BinarySearchTreeApp threeJoin(BinarySearchTreeApp left, int rootKey, BinarySearchTreeApp right)
	{
		return null;
	}
	public static BinarySearchTreeApp twoJoin(BinarySearchTreeApp left, BinarySearchTreeApp right)
	{
		return null;
	}
	public static void split(BinarySearchTreeApp target, int splitKey, BinarySearchTreeApp left, BinarySearchTreeApp right)
	{}
}
