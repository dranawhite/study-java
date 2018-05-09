package com.test.algorithm.tree;

/**
 * 红黑树
 * <pre>
 * 规则：
 * 1) 每一个节点不是红色就是黑色
 * 2) 根总是黑色的
 * 3) 如果节点是红色的，则它的子节点必须是黑色的(反之倒不一定必须为真)
 * 4) 从根到叶节点或者空子节点的每条路径，必须包含相同数目的黑色节点
 * 5) 如果一个黑节点下面两个节点颜色不同，则红色节点只能是左节点
 * </pre>
 * <pre>
 * 旋转规则:
 * 1) 横向移动节点：对于内侧子孙节点而言，如果它是上移节点(在右旋中是顶端节点的左子节点)的子节点，
 * 它总是要断开和父节点的连接并且重新连接到它以前的祖父节点上。
 * </pre>
 * 如图:
 * docs/红黑树横向移动节点.png
 * docs/红黑树横向移动节点.png
 * <pre>
 * 插入节点规则:
 * 1) 在顺着树向下查找插入点时，只要发现一个黑色节点有两个红色的子节点就执行一次颜色变换。
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/5/8 11:07]
 */
public class RedBlackTree {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private Node root;

	private boolean isRed(Node x) {
		if (x == null) {
			return false;
		}
		return x.color == RED;
	}

	public Node find(int key) {
		Node current = root;
		while (current != null) {
			if (key < current.key) {
				current = current.left;
			} else if (key > current.key) {
				current = current.right;
			} else {
				return current;
			}
		}
		return null;
	}

	public void insert(int key, double data) {
		root = insert(root, key, data);
		root.color = BLACK;
	}

	private Node insert(Node node, int key, double data) {
		if (node == null) {
			return new Node(key, data, RED);
		}

		if (key < node.key) {
			node.left = insert(node.left, key, data);
		} else if (key > node.key) {
			node.right = insert(node.right, key, data);
		} else {
			node.data = data;
		}

		// 如果一个黑色节点下面的两个节点一个黑色，一个红色，则红色节点只能是左节点
		if (isRed(node.right) && !isRed(node.left)) {
			node = rotateLeft(node);
		}

		// 红色节点下面不能有红色节点
		if (isRed(node.left) && isRed(node.left.left)) {
			node = rotateRight(node);
		}

		// 当一个黑色节点下有两个红色节点，则要进行颜色变换
		if (isRed(node.left) && isRed(node.right)) {
			flipColors(node);
		}
		return node;
	}


	/**
	 * 节点右旋
	 *
	 * @param node 节点
	 *
	 * @return 节点
	 */
	private Node rotateRight(Node node) {
		Node x = node.left;
		node.left = x.right;
		x.right = node;
		x.color = x.right.color;
		x.right.color = RED;
		return x;
	}

	/**
	 * 节点左旋
	 *
	 * @param node 节点
	 *
	 * @return 节点
	 */
	private Node rotateLeft(Node node) {
		Node x = node.right;
		node.right = x.left;
		x.left = node;
		x.color = x.left.color;
		x.left.color = RED;
		return x;
	}

	/**
	 * 对节点和两个子节点做颜色变换
	 * <pre>
	 *     当一个黑色节点下面有两个红色节点则进行颜色变换，根节点只能是黑色
	 * </pre>
	 *
	 * @param node 节点
	 */
	private void flipColors(Node node) {
		node.color = !node.color;
		node.left.color = !node.left.color;
		node.right.color = !node.right.color;
	}
}


