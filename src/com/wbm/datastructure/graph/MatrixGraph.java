package com.wbm.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.wbm.datastructure.graph.interfaces.Graph;

public class MatrixGraph implements Graph {
    /*
     * [MatrixGraph 기능] 1.무방향 그래프, 방향 그래프 둘다에 이용 될 수 있음 구현방법: 대각선을 기준으로 간선 연결:1, 간선
     * 비연결: 0이 대칭이면 무방향 그래프, 비대칭이면 방향 그래프
     * 
     * 2.간선에 비용을 부과할 수도 있음 구현방법: 단순 0, 1대신 수치값을 넣어서 비용 부과 가능
     */

    // node순서대로 matrix구성됨
    List<MatrixGraphNode> nodes;
    int[][] matrix;

    public MatrixGraph(List<MatrixGraphNode> nodes, int[][] matrix) {
	/*
	 * nodese: 각 정점 리스트 matrix: 각 정점과 다른정점과의 간선 표시 (주의) nodes길이와 matrix의 가로or세로의 길이가
	 * 같아야 함
	 */
	this.nodes = nodes;
	this.matrix = matrix;
    }

    void initGraphNodeVisited() {
	for (MatrixGraphNode node : this.nodes) {
	    node.visited = false;
	}
    }

    @Override
    public void printGraph() {
	System.out.print("\t");
	for (MatrixGraphNode node : this.nodes) {
	    System.out.print(node.key + "\t");
	}
	System.out.println();

	for (int i = 0; i < this.nodes.size(); i++) {
	    MatrixGraphNode node = this.nodes.get(i);
	    System.out.print(node.key + "\t");
	    for (int value : this.matrix[i]) {
		System.out.print(value + "\t");
	    }
	    System.out.println();
	}

    }

    public MatrixGraphNode getNodeWithKey(int key) {
	/*
	 * nodes리스트는 값으로 접근하는ㄴ것이 아닌 인덱스로 접근해야 되서 불편함
	 */

	for (int i = 0; i < this.nodes.size(); i++) {
	    MatrixGraphNode node = this.nodes.get(i);
	    if (node.key == key) {
		return this.nodes.get(i);
	    }
	}

	return null;
    }

    public void Prim(int key) {
	System.out.println("Prim");

	// graph node visitd 초기화
	this.initGraphNodeVisited();
	/*
	 * Prim algorithm 겱과 출력
	 */

	// 처음 key값의 노드 visited true 변경
	MatrixGraphNode firstNode = this.getNodeWithKey(key);
	firstNode.visited = true;

	// prim algorithm
//	    연결되고 있는 그래프중 가장 작은 인접 간선을 가진 정점 찾기
	while (true) {
	    int minDistance = 999;
	    int firstNodeKey = -1;
	    int SecondNodeKey = -1;
	    MatrixGraphNode node = null;
	    for (int i = 0; i < this.nodes.size() - 1; i++) {
		node = this.nodes.get(i);
		if (node.visited == true) {
		    for (int j = 0; j < this.nodes.size(); j++) {
			MatrixGraphNode inajacencyNode = this.nodes.get(j);
			int distance = this.matrix[i][j];

			if ((!inajacencyNode.visited) && distance < minDistance) {
			    minDistance = distance;
			    firstNodeKey = node.key;
			    SecondNodeKey = inajacencyNode.key;
			}
		    }
		}
	    }
	    if (SecondNodeKey != -1) {
		this.getNodeWithKey(SecondNodeKey).visited = true;
		System.out.println("[" + firstNodeKey + ", " + SecondNodeKey + "]");
		continue;
	    } else {
		// 모두 방문했으면 탈출
		break;
	    }
	}

    }

    @Override
    public void DFS(int key) {
	// node visited 초기화
	this.initGraphNodeVisited();

	Stack<MatrixGraphNode> stack = new Stack<>();

	MatrixGraphNode node = this.nodes.get(0);
	stack.push(node);

	// 1, 2, 4, 3, 5
	F: while (!stack.isEmpty()) {
	    node = stack.pop();
	    if (!node.visited) {
		node.visited = true;
		System.out.print(node.key + " ");
		stack.push(node);

		int nodeIndex = this.nodes.indexOf(node);
		for (int i = 0; i < this.matrix.length; i++) {
		    int connected = this.matrix[nodeIndex][i];
		    MatrixGraphNode targetNode = this.nodes.get(i);

		    if (connected == 1 && !targetNode.visited) {
			stack.push(targetNode);
			continue F;
		    }
		}
	    }

	}

    }

    @Override
    public void BFS(int key) {
	// node visited 초기화
	this.initGraphNodeVisited();
    }
}
