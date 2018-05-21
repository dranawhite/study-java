package com.test.jvm.excep;

/**
 * 除法错误
 * <pre>
 *     抛出java.lang.ArithmeticException
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/5/21 15:51]
 */
public class DivException {

	public static void main(String[] args) {
		int num = 18/0;
		System.out.println(num);
	}

}
