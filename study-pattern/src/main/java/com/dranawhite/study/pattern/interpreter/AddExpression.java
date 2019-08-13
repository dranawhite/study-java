package com.dranawhite.study.pattern.interpreter;

/**
 *
 * @author dranawhite
 * @version : AddExpression.java, v 0.1 2019-08-13 14:43 dranawhite Exp $$
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(VarExpression left, VarExpression right) {
        super(left, right);
    }

    @Override
    public int interpret(ExpressionContext ctx) {
        return left.interpret(ctx) + right.interpret(ctx);
    }
}
