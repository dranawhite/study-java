/**
 * <pre>
 *     actuator     所有EndPoint的列表，需要加入Spring Hateoas的支持
 *     autoconfig   当前应用的所有自动配置
 *     beans        当前应用中所有的Bean信息
 *     configprops  当前应用中所有的配置属性
 *     dump         显示当前应用线程状态信息
 *     env          显示当前应用当前环境信息
 *     health       显示当前应用健康状态
 *     info         显示当前应用信息
 *     metrics      显示当前应用的各项指标信息
 *     mappings     显示所有的@RequestMapping映射的路径
 *     shutdown     关闭当前应用（默认关闭）
 *     trace        显示追踪信息（默认最新的HTTP请求）
 * </pre>
 */
package com.dranawhite.study.springboot.actuator;