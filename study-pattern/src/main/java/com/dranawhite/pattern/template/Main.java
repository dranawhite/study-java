package com.dranawhite.pattern.template;

/**
 * 模板方法模式
 * <pre>
 *     将子类中方法的调用顺序放在父类中，将变化的代码放到各个子类中
 *
 *     类图:/docs/template.png
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/3/24 17:41]
 */
public class Main {

	public static void main(String[] args) {
		SuperClass clz = new SubClass();
		clz.template();
	}

}
