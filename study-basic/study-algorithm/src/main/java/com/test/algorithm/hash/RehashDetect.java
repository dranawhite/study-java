package com.test.algorithm.hash;

/**
 * 再哈希法
 * <pre>
 *     第一次哈希用于确定数据在数组中的位置；当发生碰撞时，再重新进行哈希算法确定步长；
 *     公式如下：stepSize = constant - (data % constant); constant是一个质数
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/5/7 15:13]
 */
public class RehashDetect implements Hash {

	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;

	public RehashDetect(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}

	@Override
	public int hashFunc(int data) {
		return data % arraySize;
	}

	public int rehashFunc(int data) {
		return 5 - data % 5;
	}

	@Override
	public void insert(int data) {
		int hashVal = hashFunc(data);
		while (hashArray[hashVal] != null && hashArray[hashVal].getIData() != -1) {
			int stepSize = rehashFunc(data);
			hashVal += stepSize;
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
			int stepSize = rehashFunc(data);
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		return -1;
	}

	@Override
	public int find(int data) {
		int hashVal = hashFunc(data);
		while(hashArray[hashVal] != null) {
			if(hashArray[hashVal].getIData() == data) {
				return hashVal;
			}
			int stepSize = rehashFunc(data);
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		return -1;
	}
}


























