package com.study.algorithm.recursion;

/**
 * 递归算法探究
 *
 * @author dranawhite
 * @version : RecursionPro.java, v 0.1 2019-04-11 14:58 dranawhite Exp $$
 */
public class RecursionPro {

    /**
     * 问题1：假设有N阶台阶，每次可以迈1步，也可以迈2步。有多少种走法；
     * 分析：问题可以拆解为第一次走1步 + 其它（N-1）台阶的走法 + 第一次走2步 + 其它（N-2）台阶的走法
     * 模型：F(N) = F(N-1) + F(N-2); F(1) = 1, F(2) = 2;
     */
    public int stepCount(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return stepCount(n - 1) + stepCount(n - 2);
    }

    public static void main(String[] args) {
        RecursionPro pro = new RecursionPro();
        int stepCount = pro.stepCount(5);
        System.out.println("StepCount = " + stepCount);
    }
}
