import java.util.ArrayList;
import java.util.List;

public class PrintTree {

public void printBinaryTree (final BinaryNode rootNode) {
		
		List<BinaryNode> nodeList = new ArrayList<>();
		List<BinaryNode> tmpList = new ArrayList<>();
		int endOfDepth = 0 ;
		
		nodeList.add(rootNode);
		while (!nodeList.isEmpty()) {
			for (int i = 0; i < nodeList.size(); i ++) {
				
				BinaryNode node = nodeList.get(i);
				if (node.getLeftNode() != null) {
					tmpList.add(node.getLeftNode());
				}
				
				if (node.getRightNode() != null) {
					tmpList.add(node.getRightNode());
				}
				
				System.out.print(node);
				if (i < endOfDepth) {
					System.out.print(",");
				}
			}
			
			System.out.println("");
			
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
		PrintTree printTree = new PrintTree();
		
		BinaryNode rootNode = printTree.buildBinaryTree();
		printTree.printBinaryTree(rootNode);
	}
	
	public class BinaryNode {

		public int value;

		public BinaryNode rightNode;

		public BinaryNode leftNode;

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
}
