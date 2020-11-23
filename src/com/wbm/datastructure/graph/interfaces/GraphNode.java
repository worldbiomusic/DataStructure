package com.wbm.datastructure.graph.interfaces;

public class GraphNode
{
	public int key;
	public boolean visited;
	
	public GraphNode(int key, boolean visited) {
		this.key = key;
		this.visited = visited;
	}
}
