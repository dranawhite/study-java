package com.dranawhite.study.pattern.composite;

import java.util.List;

/**
 *
 * @author dranawhite
 * @version : IBranchMenu.java, v 0.1 2019-08-13 18:32 dranawhite Exp $$
 */
public interface IBranchMenu extends IMenu {

    /**
     * add leaf menu
     *
     * @param leafMenu leaf menu
     */
    void addChildren(IMenu leafMenu);

    /**
     * get children menu
     *
     * @return children menu
     */
    List<IMenu> listChildren();
}
