package com.vikhi.exercise.datastrucutres;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vikhi.pojo.BinaryNode;

public class BinaryTreeTraversal {

	private final Logger log = Logger.getLogger(this.getClass());
	
	public void printBinaryTree (final BinaryNode rootNode) {
		
		List<BinaryNode> nodeList = new ArrayList<>();
		List<BinaryNode> tmpList = new ArrayList<>();
		StringBuilder builder;
		int endOfDepth = 0 ;
		
		nodeList.add(rootNode);
		while (!nodeList.isEmpty()) {
			builder = new StringBuilder();
			for (int i = 0; i < nodeList.size(); i ++) {
				BinaryNode node = nodeList.get(i);
				if (node.getLeftNode() != null) {
					tmpList.add(node.getLeftNode());
				}
				
				if (node.getRightNode() != null) {
					tmpList.add(node.getRightNode());
				}
				
				builder.append(node);
				if (i < endOfDepth) {
					builder.append(",");
				}
			}
			
			builder.append(" - ").append(nodeList.get(0).getValue());
			log.info(builder.toString());
			
			endOfDepth = (nodeList.size() * 2) - 1;
			nodeList = tmpList;
			tmpList = new ArrayList<>();
		}
	}
	
	private BinaryNode buildBinaryTree () {
		
		BinaryNode leafNode1 = new BinaryNode(0, null, null);
		BinaryNode leafNode2 = new BinaryNode(7, null, null);
		BinaryNode leafNode3 = new BinaryNode(9, null, null);
		BinaryNode leafNode4 = new BinaryNode(1, null, null);
		
		BinaryNode midNode1 = new BinaryNode(1, leafNode1, leafNode2);
		BinaryNode midNode2 = new BinaryNode(3, leafNode3, leafNode4);
		
		return new BinaryNode(2, midNode1, midNode2);
	}
	
	public static void main(String[] args) {
		BinaryTreeTraversal treeTraversal = new BinaryTreeTraversal();
		
		BinaryNode rootNode = treeTraversal.buildBinaryTree();
		treeTraversal.printBinaryTree(rootNode);
	}
}
