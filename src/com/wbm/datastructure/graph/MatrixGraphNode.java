package com.wbm.datastructure.graph;

import com.wbm.datastructure.graph.interfaces.GraphNode;

public class MatrixGraphNode extends GraphNode {
    MatrixGraphNode parent;

    public MatrixGraphNode(int key) {
	super(key, false);
	this.parent = null;
    }
}
