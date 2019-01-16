package com.study.jvm.classloader;

/**
 * <pre>
 * 类加载顺序：
 * 		首先是父类的静态变量、静态代码块
 * 		然后是子类的静态变量、静态代码块
 * 		然后是父类的变量初始化，构造方法
 * 		最后才是子类的变量初始化，构造方法
 * </pre>
 *
 * @author dranawhite
 * @version [1.0, 2018/4/28 14:41]
 */
public class LoaderOrderPro {

	public static void main(String[] args) {
		new Son();
	}
}
