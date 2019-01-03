package com.study.jvm.trycatch;

import org.junit.Test;

/**
 * @author liangyq 2018/3/13
 */
public class TryCatchTest {

    private TryCatch tryCatch;

    {
        tryCatch = new TryCatch();
    }

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
}
