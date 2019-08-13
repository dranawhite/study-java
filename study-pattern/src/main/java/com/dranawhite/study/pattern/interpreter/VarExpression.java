package com.dranawhite.study.pattern.interpreter;

import lombok.AllArgsConstructor;

/**
 *
 * @author dranawhite
 * @version : VarExpression.java, v 0.1 2019-08-13 14:41 dranawhite Exp $$
 */
@AllArgsConstructor
public class VarExpression implements Expression {

    private String key;

    @Override
    public int interpret(ExpressionContext ctx) {
        return ctx.getVariableValue(key);
    }
}
