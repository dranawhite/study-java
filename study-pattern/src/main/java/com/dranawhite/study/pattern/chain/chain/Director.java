package com.dranawhite.study.pattern.chain.chain;

import com.dranawhite.api.model.BaseRequest;

/**
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
public class Director implements Handler {

    private Handler handler;

    public Director() {
        this.handler = new Master();
    }

    @Override
    public void processRequest(BaseRequest request) {
        if ("适用条件".equals(request)) {
            System.out.println("Director invoke!");
        } else if (handler != null) {
            handler.processRequest(request);
        }
    }
}
