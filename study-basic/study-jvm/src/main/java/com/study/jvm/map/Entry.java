package com.study.jvm.map;

/**
 * @author liangyuquan
 * @version : Entry.java, v 0.1 2019-09-18 10:49 liangyuquan Exp $$
 */
public class Entry {

    private int key;

    public Entry(int key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        Entry e = (Entry) o;
        return this.key == e.key;
    }

    @Override
    public int hashCode() {
        return key;
    }
}
