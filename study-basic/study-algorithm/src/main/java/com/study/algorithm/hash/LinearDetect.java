package com.study.algorithm.hash;

/**
 * 线性探测法
 * <pre>
 *     假设一共有60个数据，则申明一个大小为120的数组。当检测到Hash冲突时，则把数据保存到下一个空位
 * </pre>
 *
 * @author dranawhite
 * @version [1.0, 2018/5/7 14:30]
 */
public class LinearDetect implements Hash {

	private DataItem[] hashArray;
	private int arraySize;
	/**
	 * 删除的数据
 	 */
	private DataItem nonItem;

	public LinearDetect(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}

	@Override
	public int hashFunc(int data) {
		return data % arraySize;
	}

	@Override
	public void insert(int data) {
		int hashVal = hashFunc(data);
		// 查询空闲的位置
		while (hashArray[hashVal] != null && hashArray[hashVal].getIData() != -1) {
			++hashVal;
			// 避免超出数组长度
			hashVal %= arraySize;
		}
		hashArray[hashVal] = new DataItem(data);
	}

	@Override
	public int delete(int data) {
		int hashVal = hashFunc(data);
		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getIData() == data) {
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return hashVal;
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return -1;
	}

	@Override
	public int find(int data) {
		int hashVal = hashFunc(data);
		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getIData() == data) {
				return hashVal;
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return -1;
	}
}