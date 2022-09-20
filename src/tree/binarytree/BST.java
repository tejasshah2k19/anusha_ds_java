package tree.binarytree;

public class BST {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.root = bst.addNode(bst.root, 50);
		bst.addNode(bst.root, 100);
		bst.addNode(bst.root, 30);
		bst.addNode(bst.root, 70);
		bst.addNode(bst.root, 150);
		bst.addNode(bst.root, 20);
		bst.addNode(bst.root, 40);

		System.out.println("InORDER");
		bst.inOrder(bst.root);
		System.out.println("PreOrder");
		bst.preOrder(bst.root);
		System.out.println("PostOrder");
		bst.postOrder(bst.root);
	}
}

class BinarySearchTree {
	Node root = null;

	Node createNode(int num) {

		Node node = new Node();
		node.left = null;
		node.right = null;
		node.data = num;
		return node;
	}

	Node addNode(Node node, int num) {// 50

		if (node == null) {
			node = createNode(num);
			return node;
		} else if (node.data < num) {
			node.right = addNode(node.right, num);// 100
		} else if (node.data > num) {
			node.left = addNode(node.left, num);// 30 70
		}
		return node;
	}

	void inOrder(Node node) {// | 20 25 30 40 50 70 100 150
		if (node == null)
			return;
		inOrder(node.left);// left
		System.out.println(node.data);// root
		inOrder(node.right);// 25
	}

	void preOrder(Node node) {// 50
		if (node == null)
			return;
		System.out.println(node.data);// root
		preOrder(node.left);// left
		preOrder(node.right);// 25
	}

	void postOrder(Node node) {// 50
		if (node == null)
			return;
		postOrder(node.left);// left
		postOrder(node.right);// 25
		System.out.println(node.data);// root

	}
}

class Node {
	int data;
	Node left, right;
}
