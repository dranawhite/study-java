package com.study.algorithm.hash;

/**
 * @author liangyq
 * @version [1.0, 2018/5/7 16:09]
 */
public class SortedLink {
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
