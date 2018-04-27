package com.test.jvm.assertion;

/**
 * 断言
 * <pre>
 *     断言默认是关闭的，开启断言使用jvm的-ea参数
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/4/27 11:15]
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("====Assert Success!====");
		Assert.assertSucc();
		System.out.println("====Assert Fail!   ====");
		Assert.assertFail();
	}

}
