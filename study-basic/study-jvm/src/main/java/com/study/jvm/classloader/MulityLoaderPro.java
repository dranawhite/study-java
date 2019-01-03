package com.study.jvm.classloader;

import com.dranawhite.exception.DranawhiteException;
import com.study.log.LoggerBuilder;

/**
 * <pre>
 *  类加载器对于每个类只会加载一次
 *  类加载的步骤：
 *  	执行findLoadedClass(String)检查类是否已经被加载
 * 		从父加载器开始执行loadClass()方法加载类
 * 		执行findClass(String)方法
 *  类卸载的条件：
 *     	1. 该类所有的实例已经被回收
 *     	2. 加载该类的ClassLoder已经被回收
 *     	3. 该类对应的java.lang.Class对象没有任何对方被引用
 *  类加载器首先加载本工程的类，如果找不到才到Jar包里面去找
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/4/28 14:43]
 */
public class MulityLoaderPro {

	public static void main(String[] args) {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			Class<?> clz = classLoader.loadClass("com.study.log.LoggerBuilder");
			LoggerBuilder loggerBuilder = (LoggerBuilder) clz.newInstance();
			loggerBuilder.print();
		} catch(ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			throw new DranawhiteException(e);
		}
	}
}
