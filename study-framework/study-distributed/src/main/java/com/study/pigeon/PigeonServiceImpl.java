package com.study.pigeon;

/**
 *
 * @author dranawhite
 * @version $Id: PigeonServiceImpl.java, v 0.1 2019-03-06 17:57 dranawhite Exp $$
 */
public class PigeonServiceImpl implements IPigeonService {

    @Override
    public String demoTest(String code) {
        System.out.println("Code = " + code);
        return "SUCCESS";
    }
}
