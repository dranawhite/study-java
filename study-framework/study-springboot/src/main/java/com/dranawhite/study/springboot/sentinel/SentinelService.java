package com.dranawhite.study.springboot.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

/**
 * <pre>
 *     DefaultSlotChain
 *
 *     ProcessorSlotChain chain = new DefaultProcessorSlotChain();
 *     chain.addLast(new NodeSelectorSlot());
 *     chain.addLast(new ClusterBuilderSlot());
 *     chain.addLast(new LogSlot());
 *     chain.addLast(new StatisticSlot());
 *     chain.addLast(new SystemSlot());
 *     chain.addLast(new AuthoritySlot());
 *     chain.addLast(new FlowSlot());
 *     chain.addLast(new DegradeSlot());
 * </pre>
 *
 * @author dranawhite
 * @version : SentinelService.java, v 0.1 2019-08-19 17:39 dranawhite Exp $$
 */
@Service
@Slf4j
public class SentinelService {

    @SentinelResource(value = "sentinelService", blockHandler = "exceptionHandler")
    public String sentinelService() {
        return "SUCCESS";
    }

    public String exceptionHandler(BlockException ex) {
        // blockHandler函数返回值和参数需要和原方法相匹配
        if (ex instanceof FlowException) {
            return "限流";
        }
        if (ex instanceof DegradeException) {
            return "熔断";
        }
        if (ex instanceof SystemBlockException) {
            return "系统保护";
        }
        return "UNKNOWN";
    }
}