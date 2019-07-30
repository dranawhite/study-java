package com.dranawhite.study.springboot.spring;

import com.dranawhite.study.springboot.condition.DevCondition;
import com.dranawhite.study.springboot.condition.DevService;
import com.dranawhite.study.springboot.condition.IConditionService;
import com.dranawhite.study.springboot.condition.QaCondition;
import com.dranawhite.study.springboot.condition.QaService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author dranawhite
 * @version : ConditionConfig.java, v 0.1 2019-07-30 14:41 dranawhite Exp $$
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(DevCondition.class)
    public IConditionService devCondition() {
        return new DevService();
    }

    @Bean
    @Conditional(QaCondition.class)
    public IConditionService qaCondition() {
        return new QaService();
    }
}
