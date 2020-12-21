package com.wbm.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
//		matrixG.DFS(1);
//

//		int[] nodes = {0, 1, 2, 3, 4};
//		int[][] links = {
//				{1, 2, 3, 4},
//				{0, 3},
//				{0, 3, 4},
//				{0, 1, 2, 4},
//				{0, 2, 3}
//		};
//		
//		ListGraph listG = new ListGraph(nodes, links);
//		listG.printGraph();
//		System.out.println("\nDFS");
////		listG.DFS(0); // 0 1 3 2 4
//		System.out.println("\nBFS");
//		listG.BFS(1); // 1 0 3 2 4

	List<MatrixGraphNode> nodes = new ArrayList<>();

	// 내 블로그 Prim 알고리즘 그림
//	int[][] matrix = { 
//		{ 0, 999, 999, 999, 4, 4 },
//		{ 999, 0, 3, 999, 3, 999 },
//		{ 999, 3, 0, 3, 4, 999 },
//		{ 999, 999, 3,0, 2, 999 },
//		{ 4, 3, 4, 2, 0, 2 }, 
//		{ 4, 999, 999, 999, 2, 0 }};

//	https://www.codingame.com/playgrounds/1608/shortest-paths-with-dijkstras-algorithm/keeping-track-of-paths
//	int[][] matrix = { 
//		{ 0, 6, 3, 999, 999, 999 },
//		{ 6, 0, 2, 5, 999, 999 },
//		{ 3, 2, 0, 3, 4, 999 },
//		{ 999, 5, 3, 0, 2, 3 },
//		{ 999, 999, 4, 2, 0, 5 },
//		{ 999, 999, 999, 3, 5, 0 } };
	
//	https://www.codingame.com/playgrounds/1608/shortest-paths-with-dijkstras-algorithm/keeping-track-of-paths
	int[][] matrix = { 
		{ 0, 3, 1, 999, 999 },
		{3, 0, 7, 5, 1},
		{1, 7,0,2,999},
		{999,5,2,0,7},
		{999,1,999,7,0}};
	
	for (int i = 0; i < matrix.length; i++) {
	    nodes.add(new MatrixGraphNode(i));
	}

	MatrixGraph matrixG = new MatrixGraph(nodes, matrix);

	matrixG.printGraph();
//	matrixG.Prim(4);
//	System.out.println("distance");
//	matrixG.dijkstraDistance(2);
//	System.out.println("path");
//	matrixG.dijkstraPath(2);
	matrixG.bellmanFord(2);
    }
}
