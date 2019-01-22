package com.study.jvm.classloader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * 用于从JAR或者目录中加载类或者资源
 *
 * @author dranawhite
 * @version [1.0, 2018/4/28 15:32]
 */
public class UrlClassloaderPro {

	public static void main(String[] args) throws Exception {
		String path = UrlClassloaderPro.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		URL[] urlArr = new URL[]{new URL("file", null, path)};
		URLClassLoader classLoader = new URLClassLoader(urlArr, Thread.currentThread().getContextClassLoader());
		Class clz = classLoader.loadClass("com.study.jvm.classloader.UrlClassloaderPro");
		UrlClassloaderPro pro = (UrlClassloaderPro) clz.newInstance();
		pro.print();
	}

	public void print() {
		System.out.println("Hello ClassLoader!");
	}

}
