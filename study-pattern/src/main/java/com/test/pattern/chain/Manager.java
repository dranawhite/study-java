package com.test.pattern.chain;

import com.dranawhite.api.model.BaseRequest;

/**
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
public class Manager implements Handler {

    private Handler handler;

    public Manager() {
        this.handler = new Director();
    }

    @Override
    public void processRequest(BaseRequest request) {
        if ("适用条件".equals(request)) {
            System.out.println("Manager invoke!");
        } else if (handler != null){
            handler.processRequest(request);
        }
    }
}
