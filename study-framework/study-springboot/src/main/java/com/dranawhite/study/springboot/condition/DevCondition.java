package com.dranawhite.study.springboot.condition;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author dranawhite
 * @version : DevCondition.java, v 0.1 2019-07-30 13:51 dranawhite Exp $$
 */
public class DevCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        return StringUtils.equalsIgnoreCase(activeProfiles[0], "dev");
    }
}
