package com.wbm.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.wbm.datastructure.graph.interfaces.Graph;

public class ListGraph implements Graph {

    List<ListGraphNode> list;

    public ListGraph(int[] nodes, int[][] links) {
	this.list = new ArrayList<ListGraphNode>();

	this.makeListWithArrays(nodes, links);
    }

    void initGraphNodeVisited() {
	for (ListGraphNode node : this.list) {
	    node.visited = false;
	}
    }

    void makeListWithArrays(int[] nodes, int[][] links) {
	for (int node : nodes) {
	    this.list.add(new ListGraphNode(node));
	}

	for (int i = 0; i < nodes.length; i++) {
	    ListGraphNode p = this.list.get(i);
	    for (int j = 0; j < links[i].length; j++) {
		p.link = new ListGraphNode(links[i][j]);
		p = p.link;
	    }
	    p.link = null;
	}
    }

    @Override
    public void printGraph() {
	// TODO Auto-generated method stub
	for (int i = 0; i < this.list.size(); i++) {
	    ListGraphNode node = this.list.get(i);
	    while (node != null) {
		System.out.print(node.key + " -> ");
		node = node.link;
	    }
	    System.out.println("null");
	}
    }

    @Override
    public void DFS(int key) {
	// graph node visited 초기화
	this.initGraphNodeVisited();

	ListGraphNode node = this.list.get(key);
	if (node.visited) {
	    return;
	}
	node.visited = true;
	System.out.print(node.key + " -> ");

	while ((node = node.link) != null) {
	    DFS(node.key);
	}
    }

    @Override
    public void BFS(int key) {
	// graph node visited 초기화
	this.initGraphNodeVisited();

	// enqueue: add(k), dequeue: remove()
	Queue<Integer> queue = new LinkedList<>();

	this.list.get(key).visited = true;
	queue.add(key);

	while (!queue.isEmpty()) {
	    int k = queue.remove();
	    ListGraphNode node = this.list.get(k);
	    System.out.print(k + " -> ");
	    while ((node = node.link) != null) {
		ListGraphNode headerNode = this.list.get(node.key);
		if (!headerNode.visited) {
		    headerNode.visited = true;
		    queue.add(headerNode.key);
		}
	    }
	}

    }

    public void dijkstra() {
	// graph node visited 초기화
	this.initGraphNodeVisited();

	
	
	
	
	
	
    }
}













