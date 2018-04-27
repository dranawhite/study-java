package com.test.jvm.benchmark.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试Iterable的foreach方法
 *
 * @author dranawhite 2017/8/11
 * @version 1.0
 */
public class ForEachPro {

    /**
     * 编译后字节码如下，foreach其实底层就是iterator遍历
     * <pre>
     *     public void testForEach();
     *      Code:
     *       0: invokestatic  #2                  // Method com/dranawhite/jvm/collection/ForEach.getList:()Ljava/util/List;
     *       3: astore_1
     *       4: aload_1
     *       5: invokeinterface #3,  1            // InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
     *       10: astore_2
     *       11: aload_2
     *       12: invokeinterface #4,  1            // InterfaceMethod java/util/Iterator.hasNext:()Z
     *       17: ifeq          40
     *       20: aload_2
     *       21: invokeinterface #5,  1            // InterfaceMethod java/util/Iterator.next:()Ljava/commons/Object;
     *       26: checkcast     #6                  // class java/commons/Integer
     *       29: astore_3
     *       30: getstatic     #7                  // Field java/commons/System.out:Ljava/io/PrintStream;
     *       33: aload_3
     *       34: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/commons/Object;)V
     *       37: goto          11
     *       40: return
     * </pre>
     */
    public void proCollection() {
        List<Integer> list = new ArrayList<>();
        for (Integer num : list) {
            //啥也不做
        }
    }
    /**
     * 编译字节码如下，对于数组foreach底层是用for循环实现
     * <pre>
     *      0: invokestatic  #7                  // Method com/dranawhite/jvm/collection/ForEach.getArray:()[Ljava/commons/Integer;
     *       3: astore_1
     *       4: aload_1
     *       5: astore_2
     *       6: aload_2
     *       7: arraylength
     *       8: istore_3
     *       9: iconst_0
     *       10: istore        4
     *       12: iload         4
     *       14: iload_3
     *       15: if_icmpge     30
     *       18: aload_2
     *       19: iload         4
     *       21: aaload
     *       22: astore        5
     *       24: iinc          4, 1
     *       27: goto          12
     *       30: return
     * </pre>
     */
    public void proArray() {
        Integer[] arr = new Integer[]{};
        for (Integer num : arr) {
            //啥也不做
        }
    }

}
