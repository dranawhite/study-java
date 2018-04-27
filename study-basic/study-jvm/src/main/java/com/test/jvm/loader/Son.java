package com.test.jvm.loader;

/**
 * @author liangyq
 * @version [1.0, 2018/4/24 9:49]
 */
public class Son extends Parent {

	private static int s1 = 9;
	private int s2 = 12;

	static {
		System.out.println("S1=" + s1);
		System.out.println("Son static");
	}

	public Son() {
		System.out.println("S2=" + s2);
		System.out.println("Son constructor");
	}

	public static void main(String[] args) {
		new Son();
	}

}
