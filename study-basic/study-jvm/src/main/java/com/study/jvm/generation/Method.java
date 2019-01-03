package com.study.jvm.generation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dranawhite 2017/11/17
 * @version 1.0
 */
public class Method {

    private List<Number> numList;

    public <T extends Number> T getBean(String name) {
        return null;
    }

    public void init() {
        numList = new ArrayList<>();
        numList.add(new Integer(1));
    }

}
