package com.dranawhite.study.pattern.visitor;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author dranawhite
 * @version $Id: ElementOne.java, v 0.1 2019-01-02 17:16 dranawhite Exp $$
 */
@AllArgsConstructor
public class ElementOne implements Element {

    @Getter
    private String name;

    @Override
    public void accept(Visitor visitor) {
        visitor.compute(this);
    }
}
