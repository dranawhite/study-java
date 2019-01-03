package com.study.jvm.concurrent;

import org.junit.Test;

/**
 * @author dranawhite 2017/9/25
 * @version 1.0
 */
public class ThreadUnionTest {

    @Test
    public void testThreadUnion() throws InterruptedException {
        ThreadUnion threadUnion = new ThreadUnion();
        threadUnion.run();
    }

}
