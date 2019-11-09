package com.study.jvm.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author dranawhite
 * @version : ConcurrentHashMap.java, v 0.1 2019-09-21 10:32 dranawhite Exp $$
 */
public class ConcurrentHashMapPro {

    public static void main(String[] args) {
        ConcurrentHashMap<Entry, String> map = new ConcurrentHashMap(2);
        Entry entry1 = new Entry(1);
        Entry entry2 = new Entry(5);
        Entry entry3 = new Entry(9);

        // hash值相同，在同一个链表中
        map.put(entry1, "1");
        map.put(entry2, "5");
        map.put(entry3, "9");
        // 填充node数组，促使发生resize操作
        // JDK1.8按存入的数据量与threshold进行比对，从而触发扩容。而不是Node数组的大小扩容
        map.put(new Entry(2), "2");
    }
}
