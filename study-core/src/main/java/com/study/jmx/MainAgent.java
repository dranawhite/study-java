/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.jmx;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 *
 * @author liangyuquan
 * @version $Id: MainAgent.java, v 0.1 2019-01-03 14:26 liangyuquan Exp $$
 */
public class MainAgent {

    public static void main(String[] args) {
        try {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            // 命名格式：域名:name=MBean名称
            ObjectName person = new ObjectName("jmxBean:name=person");
            server.registerMBean(new Person(), person);

            ObjectName adapter = new ObjectName("MainAgent:name=htmladapter,port=8082");
            HtmlAdaptorServer adapterServer = new HtmlAdaptorServer();
            server.registerMBean(adapterServer, adapter);
            adapterServer.start();
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
