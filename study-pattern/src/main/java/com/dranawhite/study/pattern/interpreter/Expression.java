package com.dranawhite.study.pattern.interpreter;

/**
 * @author dranawhite
 * @version : Expression.java, v 0.1 2019-08-13 14:40 dranawhite Exp $$
 */
public interface Expression {

    /**
     * 解析表达式
     *
     * @param ctx 表达式上下文
     */
    int interpret(ExpressionContext ctx);
}
