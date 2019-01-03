package com.study.algorithm.hash;

/**
 * 链地址法
 * <pre>
 *     碰撞的部分用链表存储；
 *     桶——碰撞的部分用数组存储
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/5/7 15:42]
 */
public class ChainAddress implements Hash {

	private SortedLink[] hashArray;
	private int arraySize;

	public ChainAddress(int size) {
		arraySize = size;
		hashArray = new SortedLink[arraySize];
		for (int j = 0; j < arraySize; j++) {
			hashArray[j] = new SortedLink();
		}
	}

	@Override
	public int hashFunc(int data) {
		return data % arraySize;
	}

	@Override
	public void insert(int data) {
		int hashVal = hashFunc(data);
		hashArray[hashVal].insert(new Link(data));
	}

	@Override
	public int delete(int data) {
		int hashVal = hashFunc(data);
		hashArray[hashVal].delete(data);
		return hashVal;
	}

	@Override
	public int find(int data) {
		int hashVal = hashFunc(data);
		Link link = hashArray[hashVal].find(data);
		return link == null? -1 : hashVal;
	}
}




















