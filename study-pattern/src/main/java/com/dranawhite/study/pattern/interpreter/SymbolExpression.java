package com.dranawhite.study.pattern.interpreter;

import lombok.AllArgsConstructor;

/**
 * @author dranawhite
 * @version : SymbolExpression.java, v 0.1 2019-08-13 14:43 dranawhite Exp $$
 */
@AllArgsConstructor
public abstract class SymbolExpression implements Expression {

    VarExpression left;
    VarExpression right;

}
