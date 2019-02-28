package com.study.jvm.gc;

/**
 * GC安全点探究(STW——Stop The World)
 * <pre>
 *    -XX:+PrintGC
 *    -XX:+PrintGCApplicationStoppedTime
 *    -XX:+PrintSafepointStatistics
 *    -XX:+UseCountedLoopSafepoints
 * </pre>
 *
 * <pre>
 *     GCRoots一般而言包括但不限于以下几种:
 *     1) Java方法帧中的局部变量
 *     2) 已加载类的静态变量
 *     3) JNI Handles
 *     4) 已启动且未停止的Java线程
 * </pre>
 *
 * <pre>
 *     不同状态下安全点的定义:
 *     1) JNI执行本地方法，如果在此时这段代码不访问Java对象，调用Java方法或者返回至原Java方法
 *     2）解释执行字节码——字节码之间皆可以作为安全点，当有安全点请求时，执行一条字节码便进行一次安全点检测
 *     3）执行即时编译器生成的机器码——在生成机器码时，即时编译器需要插入安全点检测，以避免机器码长时间没有安全点检测的情况。(
 *      HotSpot虚拟机的做法便是在生成代码的方法出口以及非计数循环回边处插入安全点检测)
 *     4）线程阻塞
 * </pre>
 *
 * @author dranawhite
 * @version $Id: SafePointPro.java, v 0.1 2019-02-26 10:59 dranawhite Exp $$
 */
public class SafePointPro {

    static double sum = 0;

    public static void foo() {
        for (int i = 0; i < 0x77777777; i++) {
            sum += Math.sqrt(i);
        }
    }

    public static void bar() {
        for (int i = 0; i < 50_000_000; i++) {
            new Object().hashCode();
        }
    }

    public static void main(String[] args) {
        new Thread(SafePointPro::foo).start();
        new Thread(SafePointPro::bar).start();
    }
}
