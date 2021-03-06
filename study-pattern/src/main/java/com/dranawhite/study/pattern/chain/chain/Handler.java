package com.dranawhite.study.pattern.chain.chain;

import com.dranawhite.common.model.DranaRequest;

/**
 * 处理请求的接口
 *
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
public interface Handler {

    /**
     * 处理请求
     *
     * @param request 请求
     */
    void processRequest(DranaRequest request);

}
