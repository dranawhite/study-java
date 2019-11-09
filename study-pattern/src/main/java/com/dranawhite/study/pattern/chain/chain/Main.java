package com.dranawhite.study.pattern.chain.chain;

import com.dranawhite.common.model.DranaRequest;

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
        DranaRequest request = new DranaRequest(){};
        Handler handler = new Manager();
        handler.processRequest(request);
    }

}
