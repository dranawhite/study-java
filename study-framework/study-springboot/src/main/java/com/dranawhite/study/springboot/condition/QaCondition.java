package com.dranawhite.study.springboot.condition;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 *
 * @author dranawhite
 * @version : QaCondition.java, v 0.1 2019-07-30 13:55 dranawhite Exp $$
 */
public class QaCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String[] activeProfileArr = context.getEnvironment().getActiveProfiles();
        return StringUtils.equalsIgnoreCase(activeProfileArr[0], "qa");
    }
}
