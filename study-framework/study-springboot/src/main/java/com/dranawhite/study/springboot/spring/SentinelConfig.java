package com.dranawhite.study.springboot.spring;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

/**
 * <pre>
 *     引入sentinel console
 *     1）添加transport依赖包
 *     2）配置JVM启动参数 -Dcsp.sentinel.dashboard.server=consoleIp:port
 * </pre>
 *
 * <pre>
 *     Sentinel主要代码
 *     try (Entry entry = SphU.entry(ResourceName)) {
 *         // 业务代码
 *         // try-with-resource方式，资源使用过后要关闭
 *     } catch (BlockException ex) {
 *
 *     }
 * </pre>
 *
 * @author dranawhite
 * @version : SentinelConfig.java, v 0.1 2019-08-19 17:45 dranawhite Exp $$
 */
@Configuration
@Slf4j
public class SentinelConfig {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    @PostConstruct
    public void initSentinelRules() {
        log.info("初始化Sentinel规则");
        initFlowRules();
        initDegradeRules();
    }

    private void initFlowRules() {
        // 限流规则
        // 限制QPS为3
        FlowRule rule = new FlowRule("sentinelService");
        rule.setCount(20);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER);

        List<FlowRule> ruleList = new ArrayList<>();
        ruleList.add(rule);
        FlowRuleManager.loadRules(ruleList);
    }

    private void initDegradeRules() {
        DegradeRule rule = new DegradeRule();
        rule.setCount(3);
        rule.setResource("sentinelService");
        rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        rule.setTimeWindow(2);

        List<DegradeRule> ruleList = new ArrayList<>();
        ruleList.add(rule);
        DegradeRuleManager.loadRules(ruleList);
    }
}
