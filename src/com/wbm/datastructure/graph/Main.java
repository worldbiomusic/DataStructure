package com.wbm.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main
{
	public static void main(String[] args)
	{
//		List<MatrixGraphNode> nodes= new ArrayList<>();
//		
//		nodes.add(new MatrixGraphNode(1));
//		nodes.add(new MatrixGraphNode(2));
//		nodes.add(new MatrixGraphNode(3));
//		nodes.add(new MatrixGraphNode(4));
//		nodes.add(new MatrixGraphNode(5));
//
//		int[][] matrix={
//				{0, 1, 1, 1, 0}, 
//				{1, 0, 0, 1, 0}, 
//				{1, 0, 0, 1, 1}, 
//				{1, 1, 1, 0, 1}, 
//				{0, 0, 1, 1, 0}};
//		MatrixGraph matrixG=new MatrixGraph(nodes, matrix);
//		
//		matrixG.printGraph();
//		matrixG.DFS();
//
		
		int[] nodes = {0, 1, 2, 3, 4};
		int[][] links = {
				{1, 2, 3, 4},
				{0, 3},
				{0, 3, 4},
				{0, 1, 2, 4},
				{0, 2, 3}
		};
		
		ListGraph listG = new ListGraph(nodes, links);
		listG.printGraph();
		System.out.println("\nDFS");
//		listG.DFS(0); // 0 1 3 2 4
		System.out.println("\nBFS");
		listG.BFS(1); // 1 0 3 2 4
	}
}




























