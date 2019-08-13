package com.dranawhite.study.pattern.interpreter;

/**
 * @author dranawhite
 * @version : SubExpression.java, v 0.1 2019-08-13 14:44 dranawhite Exp $$
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(VarExpression left, VarExpression right) {
        super(left, right);
    }

    @Override
    public int interpret(ExpressionContext ctx) {
        return left.interpret(ctx) - right.interpret(ctx);
    }
}
