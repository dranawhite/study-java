/**
 * JVM引用，包括强引用、软引用、弱引用以及幽灵引用
 * <pre>
 *      强引用（Strong Reference）	只要强引用还存在，垃圾收集器永远不会回收掉被引用的对象；
 *      软引用（Soft Reference）     描述一些还有用，但是非必需的对象。对于软引用关联着的对象，在系统将要发
 * 生内存溢出异常之前，将会把这些对象列进回收范围之中并进行第二次回收。如果这次回收还是没有足够的内存，才会抛
 * 出内存溢出异常，用SoftReference类实现软引用；软引用一般用作不限大小的cache（无需手动remove）；
 *      弱引用（WeakReference）      也是描述非必需对象的，但是它的强度比软引用更弱一些，被弱引用关联的对象
 * 只能生存到下一次垃圾收集发生之前。当垃圾收集器工作时，无论当前内存是否足够，都会回收掉只被弱引用关联的对象，
 * 用WeakReference类实现弱引用；弱引用的作用一般为引用提供一个被回收的凭据，结合ReferenceQueue可以让程序在
 * 第一时间内得到引用被回收的事件，从而做一些额外的clean操作；
 *      虚引用（PhantomReference）   也称为幽灵引用或者幻影引用，它是最弱的一种引用关系。一个对象是否有虚引
 * 用的存在，完全不会对其生存时间构成影响，也无法通过虚引用来取得一个对象实例。为一个对象设置虚引用关联的唯一
 * 目的就是希望能在这个对象被收集器回收时收到一个系统通知，用PhantomReference类实现虚引用；GC会将幽灵引用放
 * 入Reference Queue，以便程序在另一边通过queue的remove\poll方法，感知引用被GC回收的事件；
 * </pre>
 * @author dranawhite 2017/7/21
 * @version 1.0
 */

package com.test.jvm.reference;