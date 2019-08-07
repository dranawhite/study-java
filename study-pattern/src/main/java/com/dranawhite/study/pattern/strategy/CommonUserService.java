package com.dranawhite.study.pattern.strategy;

/**
 *
 * @author dranawhite
 * @version : CommonUserService.java, v 0.1 2019-08-07 17:57 dranawhite Exp $$
 */
public class CommonUserService implements IUserService {

    @Override
    public void printUserRole() {
        System.out.println("COMMON");
    }
}
