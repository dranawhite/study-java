/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.test.jvm.string;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author liangyq
 * @version $Id: StringCacheTest.java, v 0.1 2018-08-21 9:21 liangyq Exp $$
 */
public class StringCacheTest {

    @Test
    public void testIntern() {
        String str = new String("str");
        String intern = str.intern();

        // str是堆中对String对象的引用，intern是对字符串常量池中的"str"的引用
        Assert.assertNotNull(str, intern);

        String cacheStr = "str";
        // cacheStr取常量池中的"str"的引用，和intern指向同一个引用
        Assert.assertEquals(intern, cacheStr);
    }
}
