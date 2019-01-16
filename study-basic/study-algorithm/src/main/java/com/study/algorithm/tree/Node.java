package com.study.algorithm.tree;

import lombok.NoArgsConstructor;

/**
 * @author dranawhite
 * @version [1.0, 2018/5/7 17:55]
 */
@NoArgsConstructor
public class Node {

	int key;
	double data;
	Node left;
	Node right;
	boolean color;

	public Node(int key, double data, boolean color) {
		this.key = key;
		this.data = data;
		this.color = color;
	}
}
