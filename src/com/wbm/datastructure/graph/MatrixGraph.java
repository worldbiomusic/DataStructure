package com.wbm.datastructure.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.wbm.datastructure.graph.interfaces.Graph;

public class MatrixGraph implements Graph {
    /*
     * [MatrixGraph 기능]
     * 
     * 1.무방향 그래프, 방향 그래프 둘다에 이용 될 수 있음 구현방법: 대각선을 기준으로 간선 연결:1, 간선 비연결: 0이 대칭이면 무방향
     * 그래프, 비대칭이면 방향 그래프
     * 
     * 2.간선에 비용을 부과할 수도 있음 구현방법: 단순 0, 1대신 수치값을 넣어서 비용 부과 가능
     * 
     * [주의]
     * 
     * - nodes에 넣는 정점은 0부터 1씩 증가하며 차례대로 넣어야 함
     * 
     * - matrix에 들어가는 값들도 nodes의 정점과 같은 순서로 들어가야 함
     */

    // node순서대로 matrix구성됨
    List<MatrixGraphNode> nodes;
    int[][] matrix;

    public MatrixGraph(List<MatrixGraphNode> nodes, int[][] matrix) {
	/*
	 * nodese: 각 정점 리스트 matrix: 각 정점과 다른정점과의 간선 표시
	 * 
	 * (주의) nodes길이와 matrix의 가로or세로의 길이가 같아야 함
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

    public int getMatrixIndexWithKey(int key) {
	/*
	 * 해당키의 matrix index 반환
	 */
	for (int i = 0; i < nodes.size(); i++) {
	    if (this.nodes.get(i).key == key) {
		return i;
	    }
	}
	return -1;
    }

    public void dijkstraDistance(int src) {
	/*
	 * src로부터 다른 모든 정점의 거리 출력
	 * 
	 * node를 0부터 순서대로 넣고, matrix순서도 node넣은대로 똑같이 넣어야 정상작동됨
	 */
	// node visited 초기화
	this.initGraphNodeVisited();

	// 변수 초기화
	int[] dist = new int[this.nodes.size()];
	for (int i = 0; i < dist.length; i++) {
	    dist[i] = this.matrix[src][i];
//	    System.out.println(dist[i]);
	}

	// src노드 방문 표시
	this.nodes.get(src).visited = true;

	// 알고리즘 순서
	/*
	 * 1.dist에서 가장 짧고 방문 안한 노드 방문
	 * 
	 * 2.방문한 노드 방문표시하고 주변 거리 업데이트
	 * 
	 * 3.다시 1번으로 반복
	 */

	// 단순 반복 for문
	for (int i = 0; i < this.nodes.size() - 1; i++) {
//	    1.dist가장 짧고 방문 안한 노드 방문
	    int minDist = 1000;
	    int minNodeIndex = 0;
	    for (int x = 0; x < dist.length; x++) {
		MatrixGraphNode n = this.nodes.get(x);
		if (!n.visited) {
		    if (dist[x] < minDist) {
			minDist = dist[x];
			minNodeIndex = x;
		    }
		}
	    }

	    // 2.방문한 노드 방문표시하고 주변 거리 업데이트
	    this.nodes.get(minNodeIndex).visited = true;
	    for (int y = 0; y < dist.length; y++) {
		int newDist = dist[minNodeIndex] + this.matrix[minNodeIndex][y];
		int oldDist = dist[y];
		// update
		if (newDist < oldDist) {
		    dist[y] = newDist;
		}
	    }
	}

	for (int i = 0; i < this.nodes.size(); i++) {
	    System.out.println(src + " to " + i + " dist: " + dist[i]);
	}
    }

    private List<Integer> getCopy(List<Integer> list) {
	/*
	 * List<Integer>복사본 반환하는 메소드
	 */
	List<Integer> copy = new ArrayList<>();
	for (int n : list) {
	    copy.add(n);
	}

	return copy;
    }

    public void dijkstraPath(int src) {
	/*
	 * src로부터 dst까지 경로 출력
	 * 
	 * node를 0부터 순서대로 넣고, matrix순서도 node넣은대로 똑같이 넣어야 정상작동됨
	 */
	// node visited 초기화
	this.initGraphNodeVisited();

	// 경로 변수 초기화
	/*
	 * 근데 사실 Node의 속성에 parent를 추가하고, 길 찾는 알고리즘 도중에 갱신될때마다 parent를 지정하면 쉽게 찾을 수 있다
	 */
	List<List<Integer>> paths = new ArrayList<List<Integer>>();
	for (int i = 0; i < this.nodes.size(); i++) {
	    List<Integer> list = new ArrayList<>();
	    paths.add(list);
	}
	paths.get(src).add(src);

	// 거리 변수 초기화
	int[] dist = new int[this.nodes.size()];
	for (int i = 0; i < dist.length; i++) {
	    dist[i] = this.matrix[src][i];
//	    System.out.println(dist[i]);

	    // 경로 초기값 추가
	    if (dist[i] != 999 && i != src) {
		paths.set(i, this.getCopy(paths.get(src)));
		paths.get(i).add(i);
	    }
	}

	// src노드 방문 표시
	this.nodes.get(src).visited = true;

	// 알고리즘 순서
	/*
	 * 1.dist에서 가장 짧고 방문 안한 노드 방문
	 * 
	 * 2.방문한 노드 방문표시하고 주변 거리 업데이트
	 * 
	 * 3.다시 1번으로 반복
	 */

	// 단순 반복 for문
	for (int i = 0; i < this.nodes.size() - 1; i++) {
//	    1.dist가장 짧고 방문 안한 노드 방문
	    int minDist = 1000;
	    int minNodeIndex = 0;
	    for (int x = 0; x < dist.length; x++) {
		MatrixGraphNode n = this.nodes.get(x);
		if (!n.visited) {
		    if (dist[x] < minDist) {
			minDist = dist[x];
			minNodeIndex = x;
		    }
		}
	    }

	    // 2.방문한 노드 방문표시하고 주변 거리 업데이트
	    this.nodes.get(minNodeIndex).visited = true;

	    for (int y = 0; y < dist.length; y++) {
		int newDist = dist[minNodeIndex] + this.matrix[minNodeIndex][y];
		int oldDist = dist[y];
		// update
		if (newDist < oldDist) {
		    // 거리 업데이트
		    dist[y] = newDist;
		    // 경로 업데이트
		    paths.set(y, this.getCopy(paths.get(minNodeIndex)));
		    paths.get(y).add(y);
		}
	    }
	}

	for (int i = 0; i < paths.size(); i++) {
	    for (int path : paths.get(i)) {
		System.out.print(path + 1 + "->");
	    }
	    System.out.println();
	}
    }

    public void bellmanFord(int src) {
	int[] dist = new int[this.nodes.size()];
	// dist 초기화
	for (int i = 0; i < dist.length; i++) {
	    if (i == src) {
		dist[i] = 0;
	    } else {
		dist[i] = 999;
	    }
	}

	// 단순 반복
	for (int i = 0; i < this.nodes.size() - 1; i++) {
	    // nodeA
	    for (int A = 0; A < dist.length; A++) {
		// nodesB
		for (int B = 0; B < dist.length; B++) {
		    // 서로 인접한 정점일때 비교 (인접하지 않거나 자신이랑은 비교 안함)
		    if (this.matrix[A][B] != 999 || this.matrix[A][B] != 0) {
			this.processBellmanFordComparing(dist, A, B);
		    }
		}
	    }
	}

	// 거리 출력
	System.out.println("distance===============");
	for (int i = 0; i < this.nodes.size(); i++) {
	    System.out.println(src + " to " + i + ": " + dist[i]);
	}

	// 경로 출력
	System.out.println("path===============");
	for (int i = 0; i < this.nodes.size(); i++) {
	    String path = src + " -> ";
	    System.out.print(src + " to " + i + ": ");
	    MatrixGraphNode node = this.nodes.get(i);
	    while (node != null) {
		path = node.key + " -> " + path;
		// 부모노드 따라 올라가기
		node = node.parent;
	    }
	    System.out.println(path);
	}
    }

    private void processBellmanFordComparing(int[] dist, int nodeA, int nodeB) {
	// node1 -> node2
	int AtoB = dist[nodeA] + this.matrix[nodeA][nodeB];
	int B = dist[nodeB];
	if (AtoB < B) {
	    // update dist
	    dist[nodeB] = AtoB;
	    // parent 기록
	    this.nodes.get(nodeB).parent = this.nodes.get(nodeA);
	}

	// node2 -> node1
	int BtoA = dist[nodeB] + this.matrix[nodeB][nodeA];
	int A = dist[nodeA];
	if (BtoA < A) {
	    // update dist
	    dist[nodeA] = BtoA;
	    // parent 기록
	    this.nodes.get(nodeA).parent = this.nodes.get(nodeB);
	}
    }
}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
