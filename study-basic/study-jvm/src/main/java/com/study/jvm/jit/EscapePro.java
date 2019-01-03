package com.study.jvm.jit;

import java.io.IOException;

/**
 * HotSpot下逃逸分析研究
 * <pre>
 * 逃逸分析并不是一种优化技术，但是可以作为其他优化技术的依据
 * 逃逸分析分为：
 *      方法逃逸——当一个对象在方法中定以后，作为参数传递到其它方法中；
 *      线程逃逸——如方法中修改类变量或者实例变量等可以被其它线程访问到；
 *
 * 如果不存在逃逸行为，则可以做以下优化
 *      标量替换——将一个聚合量拆分为多个标量，从而避免创建该聚合量造成的性能浪费；通过-XX:+EliminateAllocations开启标量替换，
 *              -XX:+PrintEliminateAllocations查看标量替换情况；
 *      栈上分配——将对象直接在栈上分配，从而避免GC的性能影响；HotSpot并未实现
 *      同步消除——消除对象的同步锁；通过-XX:+EliminateLocks开启
 *
 * -XX:-DoEscapeAnalysis        关闭逃逸分析
 * -XX:-TieredCompilation       关闭分层编译
 * -XX:CompileThreshold         JIT编译阈值
 * -XX:-BackgroundCompilation   关闭异步编译
 * OSR编译(栈上替换)阈值计算公式    -XX:CompileThreshold = 10000
 *                               -XX:OnStackReplacePercentage = 140
 *                               -XX:InterpreterProfilePercentage = 33
 *   OSR trigger = (CompileThreshold * (OnStackReplacePercentage - InterpreterProfilePercentage))/ 100 = 10700
 * </pre>
 *
 * @author liangyuquan
 * @version [V1.0, 2018/2/11]
 */
public class EscapePro {

    public static void main(String[] args) throws IOException {
        EscapePro pro = new EscapePro();
        int sum = 0;
        for(int i = 0; i < 100000; i++) {
            sum += pro.test(i);
        }
        System.out.println("Waiting!");
        System.in.read();
    }

    public int test(int age) {
        User user = new User(age);
        int i = user.getAge();
        return i;
    }

}

class User {

    User(int age) {
        this.age = age;
    }

    private int age;

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
