package com.study.algorithm.tree;

/**
 * 2-3树，2-4树
 * <pre>
 * 以2-3树为例：
 * 1) 任一节点只能是2个节点或者3个节点，不存在元素数为0的节点
 * 2) 所有叶子节点都拥有相同的深度
 * 3) 元素始终保持排序顺序
 * </pre>
 * <pre>
 * 插入规则：
 * 1) 新数据项总是插到叶子节点里，在树的最底层
 * 2) 如果要插入的位置，数据项已经满了，则要进行节点分裂
 * </pre>
 * <pre>
 * 对于2-4树，分裂规则如下：
 * 1) 如果当前节点为4度节点，即有3个元素。则将该节点分裂为两个节点，位于中间的数据项上升到父节点
 * 如图: /docs/2-4树节点分裂图.png
 * 2) 根节点分裂:
 * 		如果要插入时，根是满的，则分裂，分裂规则同上
 * </pre>
 * <pre>
 * B树分裂规则:
 * 1) B树是自底而上的分裂，即在插入新数据时如果父节点已满，则先不分裂，而是直接插入数据
 * 2) 如图:/docs/B树分裂图.png
 * </pre>
 *
 * @author dranawhite
 * @version [1.0, 2018/5/9 15:22]
 */
public class BinaryToFourTree {

	public int find(BNode node, int key) {
		BNode current = node;
		int childNum;
		while (true) {
			if ((childNum = current.findItem(key)) != -1) {
				return childNum;
			} else if (current.datas.length == 0) {
				return -1;
			} else {
				int index = -1;
				for (int i = 0, len = current.datas.length; i < len; i++) {
					if(key < current.datas[i]) {
						index = i;
					}
				}
				if (index < 0) {
					index = current.datas.length;
				}
				find(current.nodes[index], key);
			}
		}
	}
}

























