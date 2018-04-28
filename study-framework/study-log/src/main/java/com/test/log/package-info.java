/**
 * <pre>
 *      日志记录器（Logger）是日志处理的核心组件;Logger是有层次关系的，我们可一般性的理解为包名之间的父子继承关系
 *      输出源（Appender）包括console（控制台）、files（文件）、GUI components（图形的组件）、remote socket
 * servers（socket服务）、JMS（Java信息服务）、NT  Event Loggers（NT的事件日志）、remote  UNIX Syslog
 * daemons（远程UNIX后台日志服务）;
 *      格式化管理器（Layout）控制日志的打印格式;
 *
 *      日志的级别由日志记录器级别（Logger）和输出源（Appender）级别共同决定;
 * </pre>
 *
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
package com.test.log;