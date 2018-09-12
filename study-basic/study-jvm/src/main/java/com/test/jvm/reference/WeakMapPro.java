/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.test.jvm.reference;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * 弱引用实验
 * <pre>
 *     GC后会回收弱引用对象;
 *     当WeakHashMap中值直接或者间接的引用键时，WeakHashMap中的数据不会被回收
 *     可以用WeakReference包裹值
 * </pre>
 *
 * @author liangyq
 * @version $Id: WeakMapPro.java, v 0.1 2018-09-12 19:16 liangyq Exp $$
 */
public class WeakMapPro {

    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<Integer, WeakReference<Integer>> map = new WeakHashMap();
        for (int i = 0; i < 1024 * 1024; i++) {
            Integer num = new Integer(i + 128);
            WeakReference<Integer> reference = new WeakReference<>(num);
            map.put(num, reference);
        }
        System.out.println(map.get(200).get());
        System.out.println("SIZE = " + map.size());
        System.gc();
        Thread.sleep(5000);
        System.out.println("SIZE = " + map.size());
    }

}

class PersonPO {

    Integer id;

    PersonPO(Integer id) {
        this.id = id;
    }

    PersonPO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

