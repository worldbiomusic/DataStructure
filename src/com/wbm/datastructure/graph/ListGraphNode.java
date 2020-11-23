package com.wbm.datastructure.graph;

import com.wbm.datastructure.graph.interfaces.GraphNode;

public class ListGraphNode extends GraphNode
{
	ListGraphNode link;
	
	public ListGraphNode(int key) {
		this(key, null);
	}
	
	public ListGraphNode(int key, ListGraphNode link) {
		super(key, false);
		this.link = link;
	}
}
