/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.jmx;

/**
 *
 * @author liangyuquan
 * @version $Id: PersonMBean.java, v 0.1 2019-01-03 14:24 liangyuquan Exp $$
 */
public interface PersonMBean {

    void setName(String name);

    String getName();

    void setAddress(String address);

    String getAddress();
}
