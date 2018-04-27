package com.test.jvm.benchmark.collection;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <pre>
 *     TreeMap按照中序二叉树保存，遍历时由左子树到右子树遍历
 * </pre>
 *
 * @author dranawhite 2017/12/27
 * @version 1.0
 */
public class TreeMapPro {

    public static void main(String[] args) {
        SortedMap<Integer, Object> map = new TreeMap<>();
        map.put(111, null);
        map.put(11, null);
        map.put(112, null);
        map.put(12, null);
        map.put(16, null);
        map.put(230, null);

        for (Map.Entry<Integer, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

}
