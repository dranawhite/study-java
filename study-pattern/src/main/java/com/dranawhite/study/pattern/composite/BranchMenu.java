package com.dranawhite.study.pattern.composite;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dranawhite
 * @version : BranchMenu.java, v 0.1 2019-08-13 18:33 dranawhite Exp $$
 */
public class BranchMenu implements IBranchMenu {

    private String name;

    @Getter
    private List<IMenu> childMenuList;

    public BranchMenu(String name) {
        this.name = name;
        this.childMenuList = new ArrayList<>();
    }

    @Override
    public void addChildren(IMenu leafMenu) {
        childMenuList.add(leafMenu);
    }

    @Override
    public List<IMenu> listChildren() {
        return childMenuList;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
