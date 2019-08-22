/**
 * 1) entry 每一个SentinelResource在Sentinel内部对应为一个Entry 2) Slot  Sentinel中定义Slot Chain用来处理不同的职责，Slot实现了ProcessorSlot接口
 *
 *
 * NodeSelectorSlot     负责收集资源的路径，并将这些资源的调用路径，以树状结构存储起来，用于根据调用路径来限流降级； ClusterBuilderSlot   则用于存储资源的统计信息以及调用者信息，例如该资源的
 * RT, QPS, thread count 等等，这些信息将用作为多维度限流，降级的依据； StatisticSlot        则用于记录、统计不同纬度的 runtime 指标监控信息； FlowSlot
 * 则用于根据预设的限流规则以及前面 slot 统计的状态，来进行流量控制； AuthoritySlot        则根据配置的黑白名单和调用来源信息，来做黑白名单控制； DegradeSlot
 * 则通过统计信息以及预设的规则，来做熔断降级； SystemSlot           则通过系统的状态，例如 load1 等，来控制总的入口流量；
 *
 * docs/sentinel/sentinel核心逻辑架构图.jpg
 */
package com.dranawhite.study.springboot.sentinel;