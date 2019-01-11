/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.study.jvm.string;

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

    @Test
    public void testIntern_new() {
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);
    }
}
