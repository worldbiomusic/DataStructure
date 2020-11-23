package com.wbm.datastructure.graph;

import java.util.List;
import java.util.Stack;

import com.wbm.datastructure.graph.interfaces.Graph;

public class MatrixGraph implements Graph
{
	/*
	 * 
	 */

	// node순서대로 matrix구성됨
	List<MatrixGraphNode> nodes;
	int[][] matrix;

	public MatrixGraph(List<MatrixGraphNode> keyList, int[][] matrix)
	{
		/*
		 * keyList의 길이와 matrix의 가로or세로의 길이가 같아야 함
		 */
		this.nodes=keyList;
		this.matrix=matrix;
	}

	@Override
	public void printGraph()
	{
		System.out.print("\t");
		for(MatrixGraphNode node : this.nodes)
		{
			System.out.print(node.key+"\t");
		}
		System.out.println();

		for(int i=0; i<this.nodes.size(); i++)
		{
			MatrixGraphNode node=this.nodes.get(i);
			System.out.print(node.key+"\t");
			for(int value : this.matrix[i])
			{
				System.out.print(value+"\t");
			}
			System.out.println();
		}

	}

	@Override
	public void DFS(int key)
	{
		Stack<MatrixGraphNode> stack=new Stack<>();

		// TODO: copy 만들기
		List<MatrixGraphNode> nodesCopy=this.nodes;

		MatrixGraphNode node=nodesCopy.get(0);
		stack.push(node);

		// 1, 2, 4, 3, 5
		F: while(!stack.isEmpty())
		{
			node = stack.pop();
			if(!node.visited)
			{
				node.visited=true;
				System.out.print(node.key + " ");
				stack.push(node);

				int nodeIndex = nodesCopy.indexOf(node);
				for(int i = 0; i < this.matrix.length; i++) {
					int connected = this.matrix[nodeIndex][i];
					MatrixGraphNode targetNode = nodesCopy.get(i);
					
					if(connected == 1 &&
							!targetNode.visited) {
						stack.push(targetNode);
						continue F;
					}
				}
			}
			
		}

	}

	@Override
	public void BFS(int key)
	{
		
	}
}
