/**
 * <pre>
 *  Spring Security核心类概览
 *  1) SpringContextHolder存储安全上下文信息（例如：当前登录的用户、用户的权限信息等）
 *     SpringContext安全上下文
 *  2）Authentication鉴权对象
 *     Principal当事人
 *     Credential凭证
 *     UsernamePasswordAuthenticationToken将用户名和密码封装成Authentication
 *  3）AuthenticationManager负责验证Authentication ProviderManager具体的验证类（委托模式）
 *  4）UserDetails用户详细信息
 *     UserDetailsService从特定的地方加载用户信息（例如：数据库）
 *     springSecurityFilterChain作为整个鉴权的入口
 * </pre>
 *
 * 图片: doc/security/SpringSecurity架构图.jpg
 *
 * @author dranawhite 2019/08/05
 */
package com.dranawhite.study.springboot.security;