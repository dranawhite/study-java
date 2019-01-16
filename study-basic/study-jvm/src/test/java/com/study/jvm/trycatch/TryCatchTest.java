package com.study.jvm.trycatch;

import org.junit.Test;

/**
 * @author dranawhite 2018/3/13
 */
public class TryCatchTest {

    private TryCatch tryCatch = new TryCatch();

    @Test(expected = NullPointerException.class)
    public void testBarResource() {
        tryCatch.barResource();
    }

    @Test
    public void testFooResource() {
        tryCatch.fooResource();
    }

    @Test
    public void testFooNormalResource() {
        tryCatch.fooNormalResource();
    }

    @Test
    public void testTryWithResources() {
        // try with resource finally执行逻辑
        // 正常语句块
        // 执行Close逻辑
        // Finally语句块
        tryCatch.tryWithResourceFinally();
    }
}
