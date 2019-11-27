package com.vikhi.pojo;

public class BinaryNode {

	private int value;
	private BinaryNode rightNode;
	private BinaryNode leftNode;

	public BinaryNode(int value, BinaryNode leftNode, BinaryNode rightNode) {
		this.value = value;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public int getValue() {
		return value;
	}

	public BinaryNode getRightNode() {
		return rightNode;
	}

	public BinaryNode getLeftNode() {
		return leftNode;
	}

	@Override
	public String toString() {
		return "(" + this.value + ")";
	}
}
