package com.study.jvm.assertion;

/**
 * 断言
 * <pre>
 *     断言默认是关闭的，开启断言使用jvm的-ea参数
 * </pre>
 *
 * @author dranawhite 2017/8/4
 * @version 1.0
 */
class Assert {

    /**
     * 断言成立时，正常结束
     */
   public static void assertSucc() {
       int m = 9;
       int n = 9;
       assert n == m;
   }

    /**
     * 断言不成立，报java.commons.AssertionError
     */
   public static void assertFail() {
       int m = 9;
       int n = 8;
       assert n == m;
   }

}
