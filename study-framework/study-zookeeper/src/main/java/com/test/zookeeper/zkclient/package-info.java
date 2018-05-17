/**
 * <pre>
 * zkclient是github上对zookeeper的封装；
 * maven依赖如下：
 *		org.apache.zookeeper:zookeeper
 *		com.github.sgroschupf:zkclient
 *
 * ZkConnection类是对ZooKeeper类最基本的封装
 *
 * ZkClient在ZK原生API接口之上进行了包装，是一个更易用的ZooKeeper客户端。同时ZkClient在内部实现了诸如Session超时重连，Watcher反复注册等功能
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/5/17 15:04]
 */
package com.test.zookeeper.zkclient;