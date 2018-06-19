package com.test.jvm.classloader;

/**
 * @author liangyq
 * @version [1.0, 2018/4/24 9:48]
 */
public class Parent {

	private static int p1 = 3;
	private int p2 = 4;

	static {
		System.out.println("P1=" + p1);
		System.out.println("Parent static");
	}

	public Parent() {
		System.out.println("P1=" + p2);
		System.out.println("Parent construtor");
	}

	{
		p2 = 8;
		System.out.println("P1=" + p2);
		System.out.println("Code Block");
	}

}
