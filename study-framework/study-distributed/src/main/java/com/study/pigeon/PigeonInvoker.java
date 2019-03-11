package com.study.pigeon;

import com.dianping.pigeon.remoting.ServiceFactory;

import java.io.IOException;

/**
 *
 * @author dranawhite
 * @version $Id: PigeonInvoker.java, v 0.1 2019-03-06 18:05 dranawhite Exp $$
 */
public class PigeonInvoker {

    public static void main(String[] args) throws IOException {
        String serviceUrl = "http://service.ymm.com/pigeon/pigeonService_1.0.0";
        IPigeonService pigeonService = ServiceFactory.getService(serviceUrl, IPigeonService.class);
        pigeonService.demoTest("Hello World");
        System.in.read();
    }
}
