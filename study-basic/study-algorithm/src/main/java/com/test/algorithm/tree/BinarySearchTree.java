package com.test.algorithm.tree;

/**
 * 二叉搜索树
 * <pre>
 *     二叉搜索树不平衡;
 *     中序、先序、后序是指父节点的遍历顺序
 *
 *     docs/二叉搜索树删除过程图/png
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/5/7 17:57]
 */
public class BinarySearchTree implements Tree {

	private Node root;

	@Override
	public Node find(int key) {
		Node current = root;
		while (current.data != key) {
			if (key < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	@Override
	public void insert(int key, double data) {
		Node newNode = new Node();
		newNode.key = key;
		newNode.data = data;
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (key < current.key) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	/**
	 * 中序遍历
	 *
	 * @param node 节点
	 */
	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}

	/**
	 * 先序遍历
	 *
	 * @param node 节点
	 */
	public void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	/**
	 * 后序遍历
	 *
	 * @param node 节点
	 */
	public void afterOrder(Node node) {
		if (node != null) {
			afterOrder(node.left);
			afterOrder(node.right);
			System.out.println(node.data);
		}
	}

	@Override
	public void delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while (current.data != key) {
			parent = current;
			if (key < current.data) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			if (current == null) {
				// 未找到待删除的节点
				return;
			}
		}

		// 没有子节点
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (current.right == null) {
			// 只有左节点
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else {
			// 两个节点
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
	}

	public double min() {
		Node current = root;
		Node parent = null;
		while (current != null) {
			parent = current;
			current = current.left;
		}
		return parent.data;
	}

	/**
	 * 查找后继节点
	 * <pre>
	 *     待删除节点的右子树的最左节点
	 * </pre>
	 *
	 * @return 后继节点
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.right;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		// 节点移位，参照/docs/二叉搜索树后继节点
		if (successor != delNode.right) {
			successorParent.left = successor.right;
			successor.right = delNode.right;
		}
		return successor;
	}
}