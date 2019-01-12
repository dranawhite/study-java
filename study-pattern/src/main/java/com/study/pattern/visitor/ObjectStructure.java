/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author liangyuquan
 * @version $Id: ObjectStructure.java, v 0.1 2019-01-02 17:21 liangyuquan Exp $$
 */
public class ObjectStructure {

    private List<Element> elementList;

    public ObjectStructure() {
        elementList = new ArrayList<>();
    }

    public void attach(Element e) {
        elementList.add(e);
    }

    public void compute(Visitor visitor) {
        for (Element e : elementList) {
            e.accept(visitor);
        }
    }
}