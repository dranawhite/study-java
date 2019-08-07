/**
 * 代理模式（委托模式）
 * <pre>
 *     Client发送请求给代理类Proxy，Proxy在内部选择合适的被代理类，并将请求转发给被代理类
 *  作用：1）隐藏了具体的实现，可以在具体的实现前后实现其他的逻辑，如统计方法的执行时间
 *       2）在代理类中可以选择合适的被代理类执行，如HttpMessageConverter
 * </pre>
 *
 * @author dranawhite 2019/08/07
 */
package com.dranawhite.study.pattern.proxy;