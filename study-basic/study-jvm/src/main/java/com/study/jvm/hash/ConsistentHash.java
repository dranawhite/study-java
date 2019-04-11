package com.study.jvm.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <pre>
 *     不带虚拟节点
 * </pre>
 *
 * @author dranawhite
 * @version $Id: ConsistentHash.java, v 0.1 2019-03-11 18:46 dranawhite Exp $$
 */
public class ConsistentHash {

    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers = {
            "192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111", "192.168.0.3:111", "192.168.0.4:111"
    };

    /**
     * key表示服务器的hash值，value表示服务器的名称
     */
    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    /**
     * 程序初始化，将所有的服务器放入sortedMap中
     */
    static {
        for (int i = 0; i < servers.length; i++) {
            int hash = ringMod(servers[i]);
            System.out.println("[" + servers[i] + "]加入集合中, 其Hash值为" + hash);
            sortedMap.put(hash, servers[i]);
        }
        System.out.println();
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
     */
    private static int getHash(String str) {
        int h;
        return (str == null) ? 0 : (h = str.hashCode()) ^ (h >>> 16);
    }

    private static int ringMod(String str) {
        final int ringSize = 128;
        int hash = getHash(str);
        return hash & (ringSize - 1);
    }

    /**
     * 得到应当路由到的结点
     */
    private static int getServer(String data) {
        // 得到带路由的结点的Hash值
        int hash = ringMod(data);
        // 得到大于该Hash值的所有Map
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        // 第一个Key就是顺时针过去离node最近的那个结点
        if (subMap.size() == 0) {
            return sortedMap.firstKey();
        }
        return subMap.firstKey();
    }

    /**
     *
     * 结果
     * <pre>
     *      Node: 112;      Value: 469277
     *      Node: 101;      Value: 1171939
     *      Node: 86;       Value: 1169436
     *      Node: 71;       Value: 6798663
     *      Node: 106;      Value: 390685
     *      Min = 390685;   Max =  6798663
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        final int dataSize = 10000000;
        Random random = new Random();
        Map<Integer, Integer> nodeMap = new HashMap<>(16);
        for (int i = 0; i < dataSize; i++) {
            int randomValue = random.nextInt(Integer.MAX_VALUE);
            int index = getServer(String.valueOf(randomValue));
            if (nodeMap.containsKey(index)) {
                nodeMap.put(index, nodeMap.get(index) + 1);
            } else {
                nodeMap.put(index, 1);
            }
        }

        int min = -1;
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : nodeMap.entrySet()) {
            System.out.println("Node: " + entry.getKey() + "; Value: " + entry.getValue());
            int num = entry.getValue();
            if (min < 0 || min > num) {
                min = num;
            }
            if (max < 0 || max < num) {
                max = num;
            }
        }
        System.out.println("Min = " + min + "; Max = " + max);
    }
}
