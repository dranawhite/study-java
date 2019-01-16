/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.study.boot.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 *
 * @author dranawhite
 * @version $Id: WinCondition.java, v 0.1 2018-08-13 17:59 dranawhite Exp $$
 */
public class WinCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("os.name").contains("Windows");
    }
}
