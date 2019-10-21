/**
 * <pre>
 *     开启事务:
 *     EnableTransactionManagement注解在做事务管理的时候
 *     每次开启事务的时候将conn.setAutoCommit(false);在commit或者rollback后，对conn.setAutoCommit(true)从而避免了长事务
 * </pre>
 *
 * <pre>
 *     事务管理器:
 *     在spring boot autoconfigure中会判断IoC容器中是否存在PlatformTransactionManager，如果没有的话默认实现一个DatasourceTransactionManager
 * </pre>
 *
 * <pre>
 *     事务回滚:
 *     事务默认在遇到RuntimeException或者Error时回滚
 * </pre>
 *
 * @see org.springframework.transaction.support.AbstractPlatformTransactionManager
 * @see org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
 * @see org.springframework.transaction.interceptor.RuleBasedTransactionAttribute
 */
package com.dranawhite.study.springboot.transaction;