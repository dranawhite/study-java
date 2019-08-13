package com.dranawhite.study.pattern.composite;

import lombok.AllArgsConstructor;

/**
 * @author dranawhite
 * @version : Leaf.java, v 0.1 2019-08-13 18:30 dranawhite Exp $$
 */
@AllArgsConstructor
public class LeafMenu implements IMenu {

    private String name;

    @Override
    public String getName() {
        return this.name;
    }
}
