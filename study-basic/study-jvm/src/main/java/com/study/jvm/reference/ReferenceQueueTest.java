package com.study.jvm.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * ReferenceQueue保存已经被回收的WeakReference对象
 * <pre>
 * 运行结果：
 *  Reference Queue is listening.
 *  Ready to gc
 *  java.lang.ref.WeakReference@dc7a4fc event fired.
 *  wr.get: null
 * </pre>
 *
 * @author dranawhite 2017/8/4
 * @version 1.0
 */
class ReferenceQueueTest {

    public static void main(String[] args) {
        final ReferenceQueue<String> q = new ReferenceQueue<>();
        // String对象才能被回收，常量字符串会被缓存到常量池中
        String str = new String("AK47");
        WeakReference<String> wr = new WeakReference<>(str, q);
        Thread t = new Thread(() -> {
            try {
                // 如果WeakReference对象被回收时才会获取到对象
                Reference reference = q.remove();
                System.out.println(reference + " event fired.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        t.start();
        System.out.println("Reference Queue is listening.");
        // clear strong reference
        str = null;
        System.out.println("Ready to gc");
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wr.get: " + wr.get());
    }
}
