package com.dranawhite.study.pattern.interpreter;

/**
 * @author dranawhite
 * @version : Calculator.java, v 0.1 2019-08-13 14:44 dranawhite Exp $$
 */
public class Calculator {

    private Expression expression;

    public void run(ExpressionContext ctx) {
        expression.interpret(ctx);
    }

}
