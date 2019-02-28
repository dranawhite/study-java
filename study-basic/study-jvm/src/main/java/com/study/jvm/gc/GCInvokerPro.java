package com.study.jvm.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 *
 * @author dranawhite
 * @version $Id: GCInvokerPro.java, v 0.1 2019-02-25 18:25 dranawhite Exp $$
 */
public class GCInvokerPro {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> gcMxBeanList = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcMxBean : gcMxBeanList) {
            System.out.println(gcMxBean.getName());
        }
    }
}
