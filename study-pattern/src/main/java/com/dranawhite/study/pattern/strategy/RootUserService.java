package com.dranawhite.study.pattern.strategy;

/**
 * @author dranawhite
 * @version : RootUserService.java, v 0.1 2019-08-07 17:57 dranawhite Exp $$
 */
public class RootUserService implements IUserService {

    @Override
    public void printUserRole() {
        System.out.println("ROOT");
    }
}
