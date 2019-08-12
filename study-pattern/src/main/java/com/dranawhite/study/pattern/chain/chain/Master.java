package com.dranawhite.study.pattern.chain.chain;

import com.dranawhite.api.model.BaseRequest;

/**
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
public class Master implements Handler {

    @Override
    public void processRequest(BaseRequest request) {
        System.out.println("Master invoke!");
    }
}
