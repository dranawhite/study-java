package com.test.algorithm.hash;

import lombok.Getter;

/**
 * @author liangyq
 * @version [1.0, 2018/5/7 16:09]
 */
public class Link {

	@Getter
	private int iData;
	public Link next;

	public Link(int iData) {
		this.iData = iData;
	}
}
