package com.dranawhite.study.pattern.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dranawhite
 * @version : ExpressionContext.java, v 0.1 2019-08-13 14:41 dranawhite Exp $$
 */
public class ExpressionContext {

    private Map<String, Integer> ctx;

    public ExpressionContext() {
        ctx = new HashMap<>();
    }

    public int getVariableValue(String key) {
        return ctx.get(key);
    }
}
