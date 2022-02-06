package com.learning.iitr;

class Node {
	int val;
	Node left, right;

	Node(int item) {
		val = item;
		left = right = null;
	}
}

public class BinaryTree {
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void binaryTreeToSkewed(Node root, int order) {

		if (root == null) {
			return;
		}

		if (order > 0) {
			binaryTreeToSkewed(root.right, order);
		} else {
			binaryTreeToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		if (order > 0) {
			binaryTreeToSkewed(leftNode, order);
		} else {
			binaryTreeToSkewed(rightNode, order);
		}
	}

	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {
		BinaryTree.node = new Node(50);
		BinaryTree.node.left = new Node(30);
		BinaryTree.node.right = new Node(60);
		BinaryTree.node.left.left = new Node(10);
		BinaryTree.node.right.left = new Node(55);

		int order = 0;
		binaryTreeToSkewed(node, order);
		traverseRightSkewed(headNode);
	}

}
