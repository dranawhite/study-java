package com.study.jvm.annotation;

/**
 * JVM注解
 * <pre>
 * Java注解是通过反射获取的
 *
 * 标准注解，J2SE中定义了三种标准注解
 *      Override注解——表示当前方法将覆盖父类中的方法;
 *      Deprecated注解——如果程序员使用了注解为它的元素，则编译器会报出警告;
 *      SuppressWarnings——关闭不当的编译器警告信息;
 *
 * 元注解的作用就是负责注解其它注解
 *      Target——说明了Annotation所修饰的对象范围
 *      Retention——定义了该Annotation被保留的时间长短
 *      Documented——将此注解包含在JavaDoc中
 *      Inherited——允许子类继承父类中的注解
 * JDK1.8新加入两个注解
 *      RepeatableAnno——同一个注解可以在一个位置重复使用
 *      Native——被标注的变量可以被本地方法引入
 *
 * 注解定义规则
 *      1）只能用public修饰符；
 *      2）参数成员只能用基本类型byte、short、char、int、long、float、double、boolean八种基本数据类型和String、Enum、Class
 *       、annotations等数据类型，以及这一些类型的数组;
 *      3）如果只有一个参数成员，最好把参数名称设为"value"，后加小括号;
 *      4）返回类型不能为void;
 *      5) 注解元素必须有确定的值，要么在定义注解的默认值中在指定，要么在使用注解时指定，非基本类型的注解元素的值不可为null;
 * </pre>
 *
 * @author dranawhite 2017/7/4
 * @version 1.0
 *
 * @see java.lang.Override
 * @see java.lang.Deprecated
 * @see java.lang.SuppressWarnings
 *
 * @see java.lang.annotation.Target
 * @see java.lang.annotation.Retention
 * @see java.lang.annotation.Documented
 * @see java.lang.annotation.Inherited
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("测试注解：");
		UserCaseTracker userCaseTracker = new UserCaseTracker();
		userCaseTracker.annotation(Main.class);
	}

	@UserCase(id = 1)
	public void annotationMethod() {

	}
}
