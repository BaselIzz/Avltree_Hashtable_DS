
public class AVLTree<T extends Comparable<T>> {
	private TNode root;
	String Sortedlist = "";

	private TNode rotateRight(TNode nodeN) {
		TNode nodeC = nodeN.getLeft();
		nodeN.setLeft(nodeC.getRight());
		nodeC.setRight(nodeN);
		return nodeC;
	}

	private TNode remove(T data) {
		TNode current = root;
		TNode parent = root;
		boolean isLeftChild = false;
		if (isEmpty())
			return null; // tree is empty
		while (current != null && !current.getData().toString().equalsIgnoreCase(data.toString())) {
			parent = current;
			if (data.toString().compareToIgnoreCase((String) current.getData().toString()) < 0) {
				current = current.getLeft();
				isLeftChild = true;
			} else {
				current = current.getRight();
				isLeftChild = false;
			}
		}
		if (current == null)
			return null; // node to be deleted not found
		// case 1: node is a leaf
		if (!current.hasLeft() && !current.hasRight()) {
			if (current == root) // tree has one node
				root = null;
			else {
				if (isLeftChild)
					parent.setLeft(null);
				else
					parent.setRight(null);
			}
		}
		// Case 2 broken down further into 2 separate cases
		else if ((current.hasLeft()) && (!current.hasRight())) { // current has left child only
			if (current == root) {
				root = current.getLeft();
			} else if (isLeftChild) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		} else if ((!current.hasLeft()) && (current.hasRight())) { // current has right child only
			if (current == root) {
				root = current.getRight();
			} else if (isLeftChild) {
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
		}
		// case 3: node to be deleted has 2 children
		else {

			if (isEmpty())
				return null;
			TNode successor = getSuccessor(current);
			if (current == root)
				root = successor;
			else if (isLeftChild) {
				parent.setLeft(successor);
			} else {
				parent.setRight(successor);
			}
			successor.setLeft(current.getLeft());
			return successor;
		}
		// other cases
		return current;
	}

	private TNode getSuccessor(TNode node) {
		TNode parentOfSuccessor = node;
		TNode successor = node;
		TNode current = node.getRight();
		while (current != null) {
			parentOfSuccessor = successor;
			successor = current;
			current = current.getLeft();
		}
		if (successor != node.getRight()) { // fix successor connections
			parentOfSuccessor.setLeft(successor.getRight());
			successor.setRight(node.getRight());
		}
		return successor;
	}

	public void traverseInOrder() {
		traverseInOrder(root);
	}

	private void traverseInOrder(TNode node) {

		if (node != null) {
			if (node.getLeft() != null)
				traverseInOrder(node.getLeft());
			Sortedlist += (node + "    " + "\n");
			if (node.getRight() != null)
				traverseInOrder(node.getRight());
		}

	}

	private TNode rotateLeft(TNode nodeN) {
		TNode nodeC = nodeN.getRight();
		nodeN.setRight(nodeC.getLeft());
		nodeC.setLeft(nodeN);
		return nodeC;
	}

	private TNode rotateRightLeft(TNode nodeN) {
		TNode nodeC = nodeN.getRight();
		nodeN.setRight(rotateRight(nodeC));

		return rotateLeft(nodeN);
	}

	private TNode rotateLeftRight(TNode nodeN) {
		TNode nodeC = nodeN.getLeft();
		nodeN.setLeft(rotateLeft(nodeC));

		return rotateRight(nodeN);
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(T data) {
		if (isEmpty())
			root = new TNode<>(data);
		else {
			TNode rootNode = root;
			addEntry(data, rootNode);
			root = rebalance(rootNode);
		}
	}

	private TNode rebalance(TNode nodeN) {
		int diff = getHeightDifference(nodeN);
		if (diff > 1) { // addition was in node's left subtree
			if (getHeightDifference(nodeN.getLeft()) > 0)
				nodeN = rotateRight(nodeN);
			else
				nodeN = rotateLeftRight(nodeN);
		} else if (diff < -1) { // addition was in node's right subtree
			if (getHeightDifference(nodeN.getRight()) < 0)
				nodeN = rotateLeft(nodeN);
			else
				nodeN = rotateRightLeft(nodeN);
		}
		return nodeN;
	}

	private int getHeightDifference(TNode nodeN) {
		int leftHight = height(nodeN.getLeft());
		int rightHight = height(nodeN.getRight());

		return leftHight - rightHight;
	}

	public TNode delete(T data) {
		TNode temp = this.remove(data);
		if (temp != null) {
			TNode rootNode = root;
			root = rebalance(rootNode);
		}
		return temp;
	}

	public TNode find(T data) {
		return find(data, root);
	}

	private TNode find(T data, TNode node) {
		if (node != null) {
			int comp = node.getData().toString().compareToIgnoreCase(data.toString());
			if (comp == 0)
				return node;
			else if (comp > 0 && node.hasLeft())
				return find(data, node.getLeft());
			else if (comp < 0 && node.hasRight())
				return find(data, node.getRight());
		}
		return null;
	}

	public int height() {
		return height(root);
	}

	private int height(TNode node) {
		if (node == null)
			return 0;
		if (node.isLeaf())
			return 1;
		int left = 0;
		int right = 0;
		if (node.hasLeft())
			left = height(node.getLeft());
		if (node.hasRight())
			right = height(node.getRight());
		return (left > right) ? (left + 1) : (right + 1);
	}

	private void addEntry(T data, TNode rootNode) {
		assert rootNode != null;
		if (data.compareTo((T) rootNode.getData()) < 0) { // right into left subtree
			if (rootNode.hasLeft()) {
				TNode leftChild = rootNode.getLeft();
				addEntry(data, leftChild);
				rootNode.setLeft(rebalance(leftChild));
			} else
				rootNode.setLeft(new TNode(data));
		} else { // right into right subtree
			if (rootNode.hasRight()) {
				TNode rightChild = rootNode.getRight();
				addEntry(data, rightChild);
				rootNode.setRight(rebalance(rightChild));
			} else
				rootNode.setRight(new TNode(data));
		}
	}

	public void clearTree() {
		this.root = null;
	}
}
