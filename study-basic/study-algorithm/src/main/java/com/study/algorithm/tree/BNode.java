package com.study.algorithm.tree;

/**
 * 2-4树节点
 *
 * @author liangyq
 * @version [1.0, 2018/5/9 15:49]
 */
public class BNode {

	BNode[] nodes = new BNode[3];
	int[] datas = new int[3];
	int numItems;
	BNode parent;

	public void connectChild(int childNum, BNode child) {
		nodes[childNum] = child;
		child.parent = this;
	}

	public BNode disconnectChild(int childNum) {
		BNode tempNode = nodes[childNum];
		nodes[childNum] = null;
		return tempNode;
	}

	public int findItem(int key) {
		for (int i = 0; i < 3; i++) {
			if (datas[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public void insertItem(int key) {
		// 插入法排序
		for (int i = 3; i >= 0; i--) {
			if (datas[i] == 0) {
				continue;
			}
			if (datas[i] > key) {
				datas[i + 1] = datas[i];
			} else {
				datas[i] = key;
			}
		}
		datas[0] = key;
	}

}
