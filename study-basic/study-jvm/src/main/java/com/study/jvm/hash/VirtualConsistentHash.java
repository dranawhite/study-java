package com.study.jvm.hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author dranawhite
 * @version $Id: VirtualConsistentHash.java, v 0.1 2019-03-11 19:04 dranawhite Exp $$
 */
public class VirtualConsistentHash {


    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers = {
            "192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111", "192.168.0.3:111", "192.168.0.4:111"
    };

    /**
     * 真实结点列表,考虑到服务器上线、下线的场景，即添加、删除的场景会比较频繁，这里使用LinkedList会更好
     */
    private static List<String> realNodes = new LinkedList<>();

    /**
     * 虚拟节点，key表示虚拟节点的hash值，value表示虚拟节点的名称
     */
    private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();

    /**
     * 虚拟节点的数目，这里写死，为了演示需要，一个真实结点对应5个虚拟节点
     */
    private static final int VIRTUAL_NODES = 5;

    static {
        // 先把原始的服务器添加到真实结点列表中
        for (int i = 0; i < servers.length; i++) {
            realNodes.add(servers[i]);
        }

        // 再添加虚拟节点，遍历LinkedList使用foreach循环效率会比较高
        for (String str : realNodes) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNodeName = str + "&&VN" + i;
                int hash = ringMod(virtualNodeName);
                while (virtualNodes.containsKey(hash)) {
                    hash += 1;
                }
                virtualNodes.put(hash, virtualNodeName);
                System.out.println("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + hash);
            }
        }
        System.out.println();
    }

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
    private static int getServer(String node) {
        // 得到带路由的结点的Hash值
        int hash = ringMod(node);
        // 得到大于该Hash值的所有Map
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        if (subMap.size() == 0) {
            return virtualNodes.firstKey();
        }

        // 第一个Key就是顺时针过去离node最近的那个结点
        return subMap.firstKey();
    }

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
