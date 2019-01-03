package com.study.algorithm.tree;

/**
 * 树
 *
 * @author liangyq
 * @version [1.0, 2018/5/7 17:52]
 */
public interface Tree {

	Node find(int key);

	void insert(int key, double data);

	void delete(int key);
}
