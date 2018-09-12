/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.test.jvm.reference;

import com.rometools.rome.feed.atom.Person;

import java.io.IOException;
import java.util.WeakHashMap;

/**
 * 弱引用实验
 * <pre>
 *     -Xmx = 6M
 * </pre>
 *
 * @author liangyq
 * @version $Id: WeakMapPro.java, v 0.1 2018-09-12 19:16 liangyq Exp $$
 */
public class WeakMapPro {

    public static void main(String[] args) {
        WeakHashMap map = new WeakHashMap();
        for (int i = 0; i < 1024 * 1024; i++) {
            map.put(i, new Integer(1));
        }
        System.out.println("SIZE = " + map.size());
        System.gc();
        System.out.println("SIZE = " + map.size());
    }

}

class person {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

