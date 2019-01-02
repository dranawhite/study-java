/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.pattern.visitor;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author liangyuquan
 * @version $Id: ElementTwo.java, v 0.1 2019-01-02 17:16 liangyuquan Exp $$
 */
@AllArgsConstructor
public class ElementTwo implements Element {

    @Getter
    private String name;

    @Override
    public void accept(Visitor visitor) {
        visitor.compute(this);
    }
}
