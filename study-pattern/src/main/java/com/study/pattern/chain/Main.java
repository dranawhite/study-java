package com.study.pattern.chain;

import com.dranawhite.api.model.BaseRequest;

/**
 * 职责链模式
 * <pre>
 *     职责链中的每个节点都会遍历到
 *     Manager —— Director —— Master
 * </pre>
 *
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        BaseRequest request = new BaseRequest(){};
        Handler handler = new Manager();
        handler.processRequest(request);
    }

}
