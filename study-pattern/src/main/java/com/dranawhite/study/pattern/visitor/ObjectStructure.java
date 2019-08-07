package com.dranawhite.study.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dranawhite
 * @version $Id: ObjectStructure.java, v 0.1 2019-01-02 17:21 dranawhite Exp $$
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
