package com.study.jvm.hash;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author liangyuquan
 * @version $Id: CommonHash.java, v 0.1 2019-03-11 18:03 liangyuquan Exp $$
 */
public class CommonHash {

    private static final int NODE_SIZE = 32;

    private static List<Integer> map = new ArrayList<>(32);

    public static void main(String[] args) throws Exception {
        run();
    }

    /**
     * 结果
     * <pre>
     *    MIN = 311252; MAX = 313467
     * </pre>
     */
    private static void run() throws Exception {
        final int dataSize = 10000000;
        HashMap hash = new HashMap(1);
        Method hashMethod = hash.getClass().getDeclaredMethod("hash", Object.class);
        hashMethod.setAccessible(true);
        Random random = new Random(Integer.MAX_VALUE);
        for (int i = 0; i < NODE_SIZE; i++) {
            map.add(0);
        }

        for (int i = 0; i < dataSize; i++) {
            int hashValue = (int) hashMethod.invoke(hash, random.nextInt());
            int mod = hashValue & (NODE_SIZE - 1);
            int num = map.get(mod);
            map.set(mod, num + 1);
        }

        int min = -1;
        int max = -1;
        for (int value : map) {
            if (min < 0) {
                min = value;
            }
            if (max < 0) {
                max = value;
            }
            if (min > value) {
                min = value;
            }
            if (max < value) {
                max = value;
            }
        }
        System.out.println("MIN = " + min + "; MAX = " + max);
    }
}
