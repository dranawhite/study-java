package com.study.pigeon;

import com.dianping.pigeon.remoting.ServiceFactory;

import java.io.IOException;

/**
 *
 * @author dranawhite
 * @version $Id: PigeonProvider.java, v 0.1 2019-03-06 17:58 dranawhite Exp $$
 */
public class PigeonProvider {

    public static void main(String[] args) throws IOException {
        String serviceUrl = "http://service.ymm.com/pigeon/pigeonService_1.0.0";
        ServiceFactory.addService(serviceUrl, IPigeonService.class, new PigeonServiceImpl());
        ServiceFactory.publishService(serviceUrl);
        System.in.read();
    }

}
