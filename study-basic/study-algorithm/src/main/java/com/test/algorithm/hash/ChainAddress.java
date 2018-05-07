package com.test.algorithm.hash;

import lombok.Getter;

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

class SortedLink {
	private Link first;

	public SortedLink() {
		first = null;
	}

	public void insert(Link link) {
		int data = link.getIData();
		Link previous = null;
		Link current = first;

		while (current != null && data > current.getIData()) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			first = link;
		} else {
			previous.next = link;
		}
		link.next = current;
	}

	public void delete(int data) {
		Link previous = null;
		Link current = first;

		while(current != null && data != current.getIData()) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
	}

	public Link find(int data) {
		Link current = first;
		while (current != null && current.getIData() <= data) {
			if (current.getIData() == data) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
}

class Link {

	@Getter
	private int iData;
	public Link next;

	public Link(int iData) {
		this.iData = iData;
	}
}




















