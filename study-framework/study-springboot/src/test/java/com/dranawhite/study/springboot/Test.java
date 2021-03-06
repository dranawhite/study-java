
package com.dranawhite.study.springboot;

/**
 *
 * @author dranawhite
 * @version : Test.java, v 0.1 2019-09-27 15:24 dranawhite Exp $$
 */
public class Test {

    @org.junit.Test
    public void test() {
        int n = 1000 * 1000;
        double p = 0.0001;

        int m = (int) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
        int k = Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
        System.out.println("M = " + m + "; K = " + k);
    }

}
