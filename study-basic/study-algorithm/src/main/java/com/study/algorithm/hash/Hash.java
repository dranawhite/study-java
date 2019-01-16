package com.study.algorithm.hash;

/**
 * @author dranawhite
 * @version [1.0, 2018/5/7 15:24]
 */
public interface Hash {

	int hashFunc(int data);

	void insert(int data);

	int delete(int data);

	int find(int data);
}
